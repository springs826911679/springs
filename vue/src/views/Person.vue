<template>
    <el-card style="width: 500px;">
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

            <el-form-item>
                <el-button type="primary" @click="save" v-show="dialog_visible">确 定</el-button>
                <el-button type="warning" @click="$router.push('/')">返回</el-button>
            </el-form-item>

        </el-form>
    </el-card>
</template>

<script>
    export default {
        name: "person",
        user:{},
        data(){
            return{
                form:{},
                dialog_visible:false,
                user:localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{}
            }
        },
        created() {
                this.form = localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{}
                if (this.user.username=="admin"){
                    this.dialog_visible=true
                }
        },
        methods:{
            save(){
                console.log(this.form)
                this.request.post("/users",this.form).then(res=>{
                    if (res){
                        this.$message.success("保存成功")
                        this.$router.push("/")
                    }else {
                        this.$message.error("保存失败")
                    }
                })
            },
        }
    }
</script>

<style scoped>

</style>