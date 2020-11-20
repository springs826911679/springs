<span style="font-size:14px;"><!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script></span>

<!DOCTYPE html>
<html>
<head>
    <title><网上商城></网上商城>的首页</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-theme.min.css" />
    <script type="text/javascript" src="jquery-3.2.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style type="text/css">

    </style>
</head>
<body>
<div class="container">
    <div class="rows" style="margin-top: 20px">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed"
                            data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span> <span
                                class="icon-bar"></span> <span class="icon-bar"></span> <span
                                class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">首页</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse"
                     id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">java<span
                                        class="sr-only">(current)</span> </a></li>
                        <li><a href="#">python</a></li>
                        <li><a href="#">c语言</a></li>
                        <li><a href="#">数据结构</a></li>
                        <li><a href="#">大数据</a></li>
                    </ul>
                    <div style="float: right;margin-top: 10px">
                        <button type="button" class="btn btn-default">我的课程</button>
                        <button type="button" class="btn btn-default">录入课程</button>
                        <button type="button" class="btn btn-default">退出登录</button>
                    </div>

                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </div>
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
                    <img src="http://pic.eduwind.cn/t0/uploads/image/png/f9a00238fc0202f3ba941031d5a11a59.png" alt="...">
                    <div class="carousel-caption"></div>
                </div>
                <div class="item">
                    <img src="http://pic.eduwind.cn/t0/uploads/image/png/f9a00238fc0202f3ba941031d5a11a59.png" alt="...">
                    <div class="carousel-caption">你好，中国</div>
                </div>
                <div class="item">
                    <img src="http://pic.eduwind.cn/t0/uploads/image/png/f9a00238fc0202f3ba941031d5a11a59.png" alt="...">
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
            热门商品<img alt="" src="../imag/sign.png">
        </h3>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-sm-6 col-md-3">
                    <a class="thumbnail"  href="#" style="text-decoration: none" data-toggle="modal" data-target="#myModal">
                        <img src="http://pic.eduwind.cn/t0/uploads/image/png/f9a00238fc0202f3ba941031d5a11a59.png" alt="...">
                        <div class="caption">
                            <h3>Thumbnail label</h3>
                            <p>qweqwdsad</p>
                        </div>
                    </a>
                </div>
            </div>

        </div>
    </div>
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
                        <button class="btn btn-primary" style="margin-right: 30px">加入我的课程</button>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer" style="margin-top: 40px">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<script>
    // $('#identifier').modal(options)
</script>
</html>



