<!DOCTYPE html>
<html>
<head>
    <title><网上商城></网上商城>的首页</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script></span>

    <style type="text/css">
        .tabtitle {
            font-size: 25px;
            color: #fff;
            text-shadow: #d56238 0px 2px,
            #d56238 2px 0px,
            #d56238 -2px 0px,
            #d56238 0px -2px,
            #d56238 -1.4px -1.4px,
            #d56238 1.4px 1.4px,
            #d56238 1.4px -1.4px,
            #d56238 -1.4px 1.4px;
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
                            <li><a href="/?categoryName=python">python</a></li>
                            <li><a href="/?categoryName=c语言">c语言</a></li>
                            <li><a href="/?categoryName=数据结构">数据结构</a></li>
                            <li><a href="/?categoryName=大数据">大数据</a></li>
                        </ul>
                        <div style="float: right;margin-top: 10px">
                            <ul class="nav navbar-nav">
                                <li><a href="/mygoods">我的课程</a></li>
                                <li><a href="/add">课程管理</a></li>
                                <li><a href="/logout">退出登录</a></li>
                            </ul>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<div class="body" >
    <div class="container" >
        <div class="row">
            <div id="carousel-example-generic" class="carousel slide"
                 data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0"
                        class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="./轮播图1.png" alt="...">
                        <div class="carousel-caption"></div>
                    </div>
                    <div class="item">
                        <img src="./banner2.jpg" alt="...">
                        <div class="carousel-caption"></div>
                    </div>
                    <div class="item">
                        <img src="./banner3.png" alt="...">
                        <div class="carousel-caption"></div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic"
                   role="button" data-slide="prev"> <span
                            class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span> </a> <a
                        class="right carousel-control" href="#carousel-example-generic"
                        role="button" data-slide="next"> <span
                            class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span> </a>
            </div>
        </div>
        <div class="row">
            <h3 style="margin-left: 23px">
                热门课程<img alt="" src="">
            </h3>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <#list goods as good>
                    <div class="col-sm-6 col-md-3">
                            <a class="thumbnail"  href="#" style="text-decoration: none" data-toggle="modal" data-target="#myModal" onclick="enrollment(${good.id?c})">
                            <img src="${good.img}" alt="...">
                            <div class="caption">
                                <h3>${good.name}</h3>
                                <p>${good.intro}</p>
                            </div>
                             </a>
                    </div>
                    </#list>
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
                            <li style="margin-left: -40px"><a href="#" class="tabtitle" >实验楼</a></li>
                            <li><a href="#">汤河学院，助力年薪百万</a></li>
                            <li>
                                <div class="row">
                                    <span col-md-4><img src="./QQ.png" alt="" style="width: 20px;height: 20px;"></span>
                                    <span col-md-4><img src="./微信.png" alt="" style="width: 20px;height: 20px;margin-left: 20px"></span>
                                    <span col-md-4><img src="./github.png" alt="" style="width: 20px;height: 20px;margin-left: 20px"></span>
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



<#--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>-->
<#--模态框-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel" style="text-align: center">商品详细信息</h4>
            </div>
            <div class="modal-body" style="margin-top: 20px;">
                <img style="float: left;margin-right: 20px" src="http://pic.eduwind.cn/t0/uploads/image/png/f9a00238fc0202f3ba941031d5a11a59.png" alt="">
                <div>
                    <div style="margin-bottom: 20px"><h3>课程标题</h3></div>
                    <div>课程作者</div>
                    <div style="margin-top: 50px">
                        <button class="btn btn-primary" style="margin-right: 30px" onclick="join()">加入我的课程</button>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer" style="margin-top: 40px">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" >确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<script>
    var goodId;
    var enrollment = function (id) {
        goodId = id;
    };
    var join = function () {
        $.ajax({
            url: "/api/goods-enrollment?id="+goodId,
            method: "POST",
            contentType: "application/json", //必须这样写
            dataType: "json",
            // data:JSON.stringify(list),
            success: function (result) {
                console.log(result);
                window.location.reload();
            },
            error : function(result) {
                console.log(result);
            }
        });
        return false;
    }
</script>
</html>



