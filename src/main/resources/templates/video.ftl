<!DOCTYPE html>
<html>
<head>
    <title><网上商城></网上商城>的首页</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script></span>

    <script src="https://cdn.jsdelivr.net/npm/knockout@3.5.0/build/output/knockout-latest.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/knockout.validation@2.0.4/dist/knockout.validation.min.js"></script>

    <style type="text/css">
        a{
            color: black;
            text-decoration: none;
        }
        .capation li {
            margin-bottom: 15px;
        }
    </style>
</head>
<body style="background-color: #f7f7f7;width: 100%;">
<div class="nav">
    <div class="container" style="width: 100%; background-color: #fff">
        <div class="rows" >
            <nav class="navbar ">
                <div class="container-fluid">
                    <div class="navbar-header" style="margin-left: 150px;margin-top: 10px">
                        <a class="navbar-brand" href="/">首页</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
                        <ul class="nav navbar-nav" style="margin-top: 10px;margin-left: 50px">
                            <li><a href="#">python</a></li>
                            <li><a href="#">c语言</a></li>
                            <li><a href="#">数据结构</a></li>
                            <li><a href="#">大数据</a></li>
                        </ul>
                        <div style="float: right;margin-top: 10px">
                            <ul class="nav navbar-nav">
                                <li><a href="/mygoods">我的课程</a></li>
                                <li><a href="/add">课程管理</a></li>
                                <li><a href="#">退出登录</a></li>
                            </ul>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<div class="body" >
    <div class="container" style="min-height: 550px">

        <div class="row">
            <h3 style="margin-left: 23px">
                1-1  前言<img alt="" src="">
            </h3>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-7" style="margin-left: 35px">
                        <div class="video" >
                            <video controls="controls">
                                <source src="http://mooc1vod.stu.126.net/nos/mp4/2014/11/06/901011_sd.mp4" type="video/mp4">
                            </video>
                        </div>
                        <div class="comments"  >
                            <div class="title" style="margin: 20px 0 20px;color: deepskyblue;font-size: 20px;"><strong>评论</strong></div>
                            <div class="comment" style="border-top: 1px solid #E2E2E2;">
                                <#list threads.list as thread>
                                <div class="item">
                                    <img style="width: 50px;height: 50px;float: left;margin-right: 20px;border-radius: 50%" src="https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3390655233,3276061794&fm=111&gp=0.jpg" alt="" >
                                    <div class="username"><h4>${thread.userName}</h4></div>
                                    <div class="content" style="margin-bottom: 10px">${thread.content}</div>
                                    <div class="time" style="margin-left: 70px">${thread.createDate?date}</div>
                                </div>
                                </#list>
                            </div>
                        </div>
                        <div class="post" >
                            <div class="title" style="margin: 20px 0 20px ">发布评论</div>
                            <textarea  id="input" style="width: 70%" placeholder="评论内容不超过100个字"></textarea>
                            <div><button class="btn btn-primary" id="btn" >发布</button></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="capation" style="text-decoration: none;">
                            <ul >
                                <li style="margin-bottom: 10px;font-size: 18px"><a href="">所有章节</a></li>
                                <li><a href=""><strong>第1章 课程介绍</strong></a></li>
                                <li><a href="">1.1 如何使用bootstarp优雅布局</a></li>
                                <li><a href="">1.2 如何使用springboot进行后端api开发</a></li>
                                <li><a href=""><strong>第2章 课程介绍</strong></a></li>
                                <li><a href="">2.1 如何使用bootstarp优雅布局</a></li>
                                <li><a href="">2.2 如何使用springboot进行后端api开发</a></li>
                                <li><a href=""><strong>第3章 课程介绍</strong></a></li>
                                <li><a href="">3.1 如何使用bootstarp优雅布局</a></li>
                                <li><a href="">3.2 如何使用springboot进行后端api开发</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="main_nav_bottom">
    <nav class="navbar navbar-default ">
        <div class="container" align="center">
            <style>
                .nav-tabs
                {
                    text-align: center;
                    height: 40px;
                    line-height: 40px;
                }
            </style>
            <ul class="nav nav-tabs nav-tabs-justified">
                <div class="row" align="center">
                    <div class="col-md-4 " align="center">
                        <li><a href="#">汤河学院，助力年薪百万</a></li>
                        <li>
                            <div class="row">
<#--                                <span col-md-4><img src="./QQ.png" alt="" style="width: 20px;height: 20px;"></span>-->
<#--                                <span col-md-4><img src="./微信.png" alt="" style="width: 20px;height: 20px;margin-left: 20px"></span>-->
<#--                                <span col-md-4><img src="./github.png" alt="" style="width: 20px;height: 20px;margin-left: 20px"></span>-->
                            </div>
                        </li>
                    </div>
                    <div class="col-md-2 " align="center">
                        <li><a href="#" ><strong>公司</strong></a></li>
                        <li><a href="#">关于我们</a></li>
                        <li><a href="#">联系我们</a></li>
                        <li><a href="#">加入我们</a></li>
                        <li><a href="#">技术博客</a></li>
                    </div>
                    <div class="col-md-2 " align="center">
                        <li><a href="#"><strong>合作</strong></a></li>
                        <li><a href="#">概要合作</a></li>
                        <li><a href="#">教师合作</a></li>
                        <li><a href="#">校园合作</a></li>
                        <li><a href="#">友情合作</a></li>
                    </div>
                    <div class="col-md-2 " align="center">
                        <li><a href="#"><strong>服务</strong></a></li>
                        <li><a href="#">微商城服务</a></li>
                        <li><a href="#">在线客服</a></li>
                        <li><a href="#">售后服务</a></li>
                        <li><a href="#">商品服务</a></li>
                    </div><div class="col-md-2 " align="center">
                        <li><a href="#"><strong>学习路径</strong></a></li>
                        <li><a href="#">python学习路径</a></li>
                        <li><a href="#">java学习路径</a></li>
                        <li><a href="#">c语言学习路径</a></li>
                        <li><a href="#">全部</a></li>
                    </div>
                </div>
            </ul>
        </div>
    </nav>
</div>
</body>
<script>

    $('#btn').click(function () {
        var content = $('#input').val();
        console.log(content);
        var list ={};
        list.content = content;
        list.goodsId = ${goods.id};
        $.ajax({
            url: "/api/threads",
            method: "POST",
            contentType: "application/json", //必须这样写
            dataType: "json",
            data:JSON.stringify(list),
            success: function (result) {
                console.log(result);
                window.location.reload();
            },
            error : function(result) {
                console.log(result);
            }
        });
    });

</script>
</html>



