<!DOCTYPE html>
<html>
<head>
    <title><网上商城></网上商城>的首页</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script></span>

    <style type="text/css">
        .fontE {
            color: white;
            font-size:20px;
            text-shadow: 1px 1px black, -1px -1px black,
            1px -1px black, -1px 1px black;
        }
    </style>
</head>
<body style="background-color: #f7f7f7;width: 100%;">
<div class="nav">
        <div class="container" style="width: 100%; background-color: #EFEFEF">
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
                                <#if user.username=='admin'>
                                <li><a href="/add">课程管理</a></li>
                            </#if>
                                <li><a href="#">${user.username}</a></li>
                                <li><a href="/logout">退出登录</a></li>
                            </ul>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<div class="body" style="background-color: #fff">
    <div class="container" style="min-height: 550px;">
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
                            <a class="thumbnail"  href="#" style="text-decoration: none" data-toggle="modal" data-target="#myModal" onclick="enrollment('${good.id?c}','${good.img}','${good.name}','${good.author}')">
                            <img src="${good.img}" alt="" style="height: 128px;width: 202px">
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


        <div class="row">
            <h3 style="margin-left: 23px">
                实战推荐<img alt="" src="">
            </h3>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                        <div class="col-sm-6 col-md-3" style="max-height: 235px">
                            <a class="thumbnail"  href="#" style="text-decoration: none">
                                <div style="width: 100%; height: 40px; background-color: green;padding-left: 20px;"><div style="padding-top: 8px" class="fontE">测试</div></div>
                                <div style="padding-left: 20px;margin-top: 15px">Android自动化测试实战工具 框架 脚本</div>
                                <div style="opacity: 0.4;padding-left: 20px;margin-top: 15px">找Android自动化测试工作必学的主流工具、框架</div>
                                <div style="padding-left: 20px;margin-top: 15px"><span style="opacity: 0.4">178在学</span></div>
                            </a>
                        </div>
                    <div class="col-sm-6 col-md-3" style="min-height: 235px;max-height: 235px">
                        <a class="thumbnail"  href="#" style="text-decoration: none">
                            <div style="width: 100%; height: 40px; background-color: palevioletred;padding-left: 20px;"><div style="padding-top: 8px" class="fontE">webApp</div></div>
                            <div style="padding-left: 20px;margin-top: 15px">AngularJS仿拉勾网WebApp开发移动端单页应用</div>
                            <div style="opacity: 0.4;padding-left: 20px;margin-top: 15px">基于Angular,拉勾网开发一个移动端单页的应用</div>
                            <div style="padding-left: 20px;margin-top: 15px"><span style="opacity: 0.4">200在学</span></div>
                        </a>
                    </div>
                    <div class="col-sm-6 col-md-3" style="min-height: 235px;max-height: 235px">
                        <a class="thumbnail"  href="#" style="text-decoration: none">
                            <div style="width: 100%; height: 40px; background-color: mediumpurple;padding-left: 20px;"><div style="padding-top: 8px" class="fontE">python</div></div>
                            <div style="padding-left: 20px;margin-top: 15px">python高级编程以及各种的实战教程视频</div>
                            <div style="opacity: 0.4;padding-left: 20px;margin-top: 15px">精选50个python训练任务，带你领略各种爬虫</div>
                            <div style="padding-left: 20px;margin-top: 15px"><span style="opacity: 0.4">1222在学</span></div>
                        </a>
                    </div>
                    <div class="col-sm-6 col-md-3" style="min-height: 235px;max-height: 235px">
                        <a class="thumbnail"  href="#" style="text-decoration: none">
                            <div style="width: 100%; height: 40px; background-color: saddlebrown;padding-left: 20px;"><div style="padding-top: 8px" class="fontE">测试</div></div>
                            <div style="padding-left: 20px;margin-top: 15px">Android自动化测试实战工具 框架 脚本</div>
                            <div style="opacity: 0.4;padding-left: 20px;margin-top: 15px">Android自动化测试实战工具 框架 脚本,带你领略移动app</div>
                            <div style="padding-left: 20px;margin-top: 15px"><span style="opacity: 0.4">178在学</span></div>
                        </a>
                    </div>
                    <div class="col-sm-6 col-md-3" style="min-height: 235px;max-height: 235px">
                        <a class="thumbnail"  href="#" style="text-decoration: none">
                            <div style="width: 100%; height: 40px; background-color: green;padding-left: 20px;"><div style="padding-top: 8px" class="fontE">测试</div></div>
                            <div style="padding-left: 20px;margin-top: 15px">Android自动化测试实战工具 框架 脚本</div>
                            <div style="opacity: 0.4;padding-left: 20px;margin-top: 15px">实战工具</div>
                            <div style="padding-left: 20px;margin-top: 15px"><span style="opacity: 0.4">178在学</span></div>
                        </a>
                    </div>
                    <div class="col-sm-6 col-md-3" style="min-height: 235px;max-height: 235px">
                        <a class="thumbnail"  href="#" style="text-decoration: none">
                            <div style="width: 100%; height: 40px; background-color: green;padding-left: 20px;"><div style="padding-top: 8px" class="fontE">测试</div></div>
                            <div style="padding-left: 20px;margin-top: 15px">Android自动化测试实战工具 框架 脚本</div>
                            <div style="opacity: 0.4;padding-left: 20px;margin-top: 15px">实战工具</div>
                            <div style="padding-left: 20px;margin-top: 15px"><span style="opacity: 0.4">178在学</span></div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <div class="main_nav_bottom" >
        <nav class="navbar navbar-default " >
            <div class="container" align="center" style="background-color: gray;width: 100%">
                <style>
                    .nav-tabs
                    {
                        text-align: center;
                        height: 40px;
                        line-height: 40px;
                    }
                    a{
                        color: inherit;
                    }
                </style>
                <ul class="nav nav-tabs nav-tabs-justified">
                    <div class="row" align="center" style="color:white!important;">
                        <div class="col-md-4 " align="center">
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
                <img id="img" style="float: left;margin-right: 20px;width: 300px;height: 200px;"  alt="">
                <div>
                    <div style="margin-bottom: 20px"><h3 id="title">课程标题</h3></div>
                    <div >课程作者:  <span id="author"></span></div>
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
    var img;
    var name;
    var enrollment = function (id,img,name,author) {
        goodId = id;
        // console.log('asdasd');
        $('#title').html(name);
        $('#author').html(author);
        $("#img").attr('src',img);
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



