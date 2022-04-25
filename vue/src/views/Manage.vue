<template>
    <el-container style="min-height: 100vh">

        <el-aside :width="sideWidth + 'px'" style="box-shadow: 2px 0 6px rgb(0 21 41 / 35%);">
            <Aside :isCollapse="isCollapse" :logoTextShow="logoTextShow":dialog_visible="dialog_visible"/>
        </el-aside>

        <el-container>
            <el-header style=" border-bottom: 1px solid #ccc; ">
                <Header :collapse-btn-class="collapseBtnClass" @asideCollapse="collapse"/>
            </el-header>

            <el-main>
<!--                表示当前页面的子路由会在  <router-view/>里面展示-->
              <router-view/>
            </el-main>

        </el-container>
    </el-container>
</template>

<script>

    import Aside from "@/components/Aside";
    import Header from "@/components/Header";
    export default {
        name: 'Home',
        data() {
            return {
                user:{},
                collapseBtnClass: 'el-icon-s-fold',
                isCollapse: false,
                sideWidth: 200,
                logoTextShow: true,
                dialog_visible:false
            }
        },
        created() {
            this.user=localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{}
            console.log("更新")
            this.request.get("/users/"+this.user.id).then(res=>{
                if (res){
                    localStorage.setItem("user",JSON.stringify(res))
                    console.log(res)
                }
            }
            )
            this.user=localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{}
            // console.log(this.user.username=="admin")
            if (this.user.username=="admin"){
                this.dialog_visible=true
                console.log("dialog_visible"+this.dialog_visible)
            }
        },
        components:{
            Header,
            Aside
        },
        methods: {
            collapse() {  // 点击收缩按钮触发
                this.isCollapse = !this.isCollapse
                if (this.isCollapse) {  // 收缩
                    this.sideWidth = 64
                    console.log("!!!!!")
                    this.collapseBtnClass = 'el-icon-s-unfold'
                    this.logoTextShow = false
                } else {   // 展开
                    this.sideWidth = 200
                    console.log("!!!#!")

                    this.collapseBtnClass = 'el-icon-s-fold'
                    this.logoTextShow = true
                }
            },

        },


    }
</script>

