<template>
    <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden"
             background-color="rgb(48, 65, 86)"
             text-color="#fff"
             active-text-color="#ffd04b"
             :collapse-transition="false"
             :collapse="isCollapse"
             router
    >
        <div style="height: 60px; line-height: 60px; text-align: center">
            <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top: 5px; right: 5px">
            <b style="color: white" v-show="logoTextShow">后台管理系统</b>
        </div>
        <el-menu-item index="/">
            <template slot="title">
                 <i class="el-icon-house"></i>
                <span slot="title">主页</span>
            </template>
        </el-menu-item>
        <el-submenu index="2" v-show="dialog_visible">
            <template slot="title">
                <i class="el-icon-menu"></i>
                <span slot="title">系统管理</span>
            </template>
            <el-menu-item index="/user">
                <i class="el-icon-s-custom"></i>
                <span slot="title">用户管理</span>
            </el-menu-item>
            <el-menu-item index="/rewardList">
                <i class="el-icon-s-custom"></i>
                <span slot="title">抽奖记录管理</span>
            </el-menu-item>
        </el-submenu >
        <el-submenu index="3">
            <template slot="title">
                <i class="el-icon-menu"></i>
                <span slot="title">抽奖管理</span>
            </template>
            <el-menu-item index="/lotteryDraw">
                <i class="el-icon-s-custom"></i>
                <span slot="title">抽奖</span>
            </el-menu-item>
            <el-menu-item index="/personRewardList">
                <i class="el-icon-s-custom"></i>
                <span slot="title">抽奖记录</span>
            </el-menu-item>
        </el-submenu>
    </el-menu>

</template>

<script>
    export default {
        name: "Aside",
        props:{
            isCollapse:Boolean,
            logoTextShow:Boolean,
            dialog_visible:Boolean
        },
        // created() {
        //     this.user=localStorage.getItem("user")?JSON.parse(localStorage.getItem("user")):{}
        //     showDialog(user.username)
        // },
        // data(){
        //     return{
        //         dialog_visible:false
        //     }
        // },
        // methods:{
        //     showDialog(username) {
        //         if (username=='admin')
        //         this.dialog_visible = true;
        //     }
        // }
    }

</script>

<style scoped>

</style>