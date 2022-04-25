<template>
    <div>

        <div style="margin: 10px 0">
            <el-input style="width: 200px" placeholder="请输入奖励名称" suffix-icon="el-icon-search" v-model="name"></el-input>
            <!--                    <el-input style="width: 200px" placeholder="请输入邮箱" suffix-icon="el-icon-message" class="ml-5"></el-input>-->
            <!--                    <el-input style="width: 200px" placeholder="请输入地址" suffix-icon="el-icon-position" class="ml-5"></el-input>-->
            <el-button class="ml-5" type="primary" @click="loadByName">搜索</el-button>
            <el-button class="ml-5" type="warning" @click="reset">重置</el-button>

        </div>

        <div style="margin: 10px 0">
<!--            <el-button type="primary" @click="handleAdd">新增 <i class="el-icon-circle-plus-outline"></i></el-button>-->
<!--            <el-popconfirm-->
<!--                    class="ml-5"-->
<!--                    confirm-button-text='确定'-->
<!--                    cancel-button-text='我再想想'-->
<!--                    icon="el-icon-info"-->
<!--                    icon-color="red"-->
<!--                    title="您确定批量删除这些数据吗？"-->
<!--                    @confirm="delBatch"-->
<!--            >-->
<!--                <el-button type="danger" slot="reference">批量删除 <i class="el-icon-remove-outline"></i></el-button>-->
<!--            </el-popconfirm>-->

<!--            <el-button type="primary">导入 <i class="el-icon-bottom"></i></el-button>-->
<!--            <el-button type="primary">导出 <i class="el-icon-top"></i></el-button>-->
        </div>

        <el-table :data="tableData" border stripe :header-cell-class-name="'headerBg'"  @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="id" label="ID" width="80" align="center">
            </el-table-column>
            <el-table-column prop="name" label="奖励名称" width="150" align="center">
            </el-table-column>
            <el-table-column prop="username" label="用户名" width="80" align="center">
            </el-table-column>
            <el-table-column prop="createDate" label="抽奖时间" align="center">
            </el-table-column>

<!--            <el-table-column label="操作"  width="200" align="center">-->
<!--                <template slot-scope="scope">-->
<!--                    <el-button type="success" @click="handleEdit(scope.row)">编辑 <i class="el-icon-edit"></i></el-button>-->
<!--                    <el-popconfirm-->
<!--                            class="ml-5"-->
<!--                            confirm-button-text='确定'-->
<!--                            cancel-button-text='我再想想'-->
<!--                            icon="el-icon-info"-->
<!--                            icon-color="red"-->
<!--                            title="您确定删除吗？"-->
<!--                            @confirm="del(scope.row.id)"-->
<!--                    >-->
<!--                        <el-button type="danger" slot="reference">删除 <i class="el-icon-remove-outline"></i></el-button>-->
<!--                    </el-popconfirm>-->
<!--                </template>-->
<!--            </el-table-column>-->
        </el-table>
        <div style="padding: 10px 0">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[2, 5, 10, 20]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>
        <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%" >
            <el-form label-width="80px" size="small">
                <el-form-item label="用户名">
                    <el-input v-model="form.username" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="抽奖次数">
                    <el-input v-model="form.count" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="form.email" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="电话">
                    <el-input v-model="form.phone" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="地址">
                    <el-input v-model="form.address" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="save">确 定</el-button>
            </div>
        </el-dialog>

    </div>
</template>

<script>
    export default {
        name: "User",
        data(){
            return{
                user:{},
                tableData: {},
                total: 0,
                username:"",
                name:"",
                pageNum:1,
                pageSize:2,
                dialogFormVisible:false,
                form:{},
                multipleSelection: [],

            }
        },
        created() {
            //请求分页查询数据
            this.user=localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{}
            this.load()
        },
        methods:{
            handleSizeChange(pageSize){
                console.log(pageSize)
                this.pageSize = pageSize
                this.load()
            },
            handleCurrentChange(pageNum){
                console.log(pageNum)
                this.pageNum = pageNum
                this.load()
            },
            handleAdd(){
                this.dialogFormVisible = true
                this.form = {}
            },

            load(){
                this.request.get("/rewardRecord",{
                    params: {
                        currentPage :this.pageNum,
                        pageSize : this.pageSize,
                        userId:this.user.id
                    }
                }).then(res=>{
                    console.log(res)
                    this.tableData = res.list
                    this.total = res.pagination.total
                })
            },
            loadByName(){
                this.request.get("/rewardRecordByName",{
                    params: {
                        currentPage :this.pageNum,
                        pageSize : this.pageSize,
                        name:this.name,
                        userId:this.user.id
                    }
                }).then(res=>{
                    console.log(res)
                    this.tableData = res.list
                    this.total = res.pagination.total
                })
            },
            handleSelectionChange(val) {
                console.log(val)
                this.multipleSelection = val
            },
            delBatch(){
                let ids = this.multipleSelection.map(v=>v.id)
                this.request.post("/rewardRecordBatch", ids).then(res => {
                    if (res) {
                        this.$message.success("批量删除成功")
                        this.load()
                    } else {
                        this.$message.error("批量删除失败")
                    }
                })
            },
            save(){
                console.log(this.form)
                this.request.post("/rewardRecord",this.form).then(res=>{
                    if (res){
                        this.$message.success("保存成功")
                        this.dialogFormVisible = false
                        this.$router.push("/user")
                    }else {
                        this.$message.error("保存失败")
                    }
                })
            },
            // update(){
            //     request.put("/users/"+id,this.form).then(res=>{
            //         if (res){
            //             this.$message.success("保存成功")
            //             this.dialogFormVisible = false
            //         }else {
            //             this.$message.error("保存失败")
            //         }
            //     })
            // },
            handleEdit(row){
                this.form = row
                this.dialogFormVisible = true
                console.log(this.id)
            },
            del(id){
                this.request.delete("/rewardRecord/"+id).then(res=>{
                    if (res) {
                        this.$message.success("删除成功")
                        this.load()
                    } else {
                        this.$message.error("删除失败")
                    }
                })
            },
            reset(){
                this.name = ""
                this.load()
            }
        }


    }
</script>

<style>
    .headerBg {
        background: #eee!important;
    }
</style>