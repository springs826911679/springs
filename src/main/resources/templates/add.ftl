<!DOCTYPE html>
<html>
<head>
    <title><汤河学院></汤河学院>的首页</title>


    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script></span>
    <script src="https://cdn.jsdelivr.net/npm/knockout@3.5.0/build/output/knockout-latest.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/knockout.validation@2.0.4/dist/knockout.validation.min.js"></script>
    <style type="text/css">

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
<div class="body">
    <div class="container" style="margin-top: 50px">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading" style="text-align: center">
                <button class="btn btn-primary" style="float: right;margin-top: -6px" data-toggle="modal" data-target="#myModal" id="clear">新增</button>
                课程列表
            </div>
            <div class="panel-body">
                <!-- Table -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>描述</th>
                        <th>价格</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach:goodsList">
                    <tr>
                        <td data-bind="text:name">Tanmay</td>
                        <td data-bind="text:intro">Tanmay</td>
                        <td data-bind="text:price">Tanmay</td>
                        <td><a data-toggle="modal" data-target="#myModal1" data-bind="event:{click:$root.del.bind($data,id)}">删除</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
</body>


<#--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>-->
<#--模态框-->

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="margin-top: 250px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel" style="text-align: center">是否选择删除商品</h4>
            </div>
            <div class="modal-body" style="margin-top: 20px;text-align: center">
                <button type="button" class="btn btn-default" data-dismiss="modal" style="margin-right: 20px">取消</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" data-bind="click:$root.change">确定</button>
            </div>
            <div class="clearfix"></div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel" style="text-align: center">新增课程</h4>
            </div>
            <div class="modal-body" style="margin-top: 20px;">
                <div>
                    <form action="" data-bind="submit:commitSubmit">
                        <div class="form-group">
                            <div class="row">
                                <label for="name" class="col-md-2" style="margin-left: 10px;text-align: center;margin-top: 5px">名称:</label>
                                <input type="text" class="col--md-10" data-bind="value:name" placeholder="请输入名称" style="padding: 5px">
                            </div>
                        </div>
                                                <div class="form-group">
                                                    <div class="row">
                                                        <label for="name" class="col-md-2" style="margin-left: 10px;text-align: center;margin-top: 5px">课程分类:</label>
                                                        <div class="col-md-8">
                                                            <div class="row" style="margin-top: 5px">
                                                            <input type="radio" name="categoryName" data-bind="checked:categoryName" value="python">python
                                                            <input type="radio" name="categoryName" data-bind="checked:categoryName" value="c语言">c语言
                                                            <input type="radio" name="categoryName" data-bind="checked:categoryName" value="数据结构">数据结构
                                                            <input type="radio" name="categoryName" data-bind="checked:categoryName" value="大数据">大数据
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                        <div class="form-group">
                            <div class="row">
                                <label for="name" class="col-md-2" style="margin-left: 10px;text-align: center;margin-top: 5px">价格:</label>
                                <input type="text" class="col--md-10" data-bind="value:price" placeholder="请输入价格" style="padding: 5px" >
                            </div>
                        </div>
                                                <div class="form-group">
                                                    <div class="row">
                                                        <label for="name" class="col-md-2" style="margin-left: 10px;text-align: center;margin-top: 5px">图片地址:</label>
                                                        <input type="text" class="col--md-10" data-bind="value:url" placeholder="请输入图片地址" style="padding: 5px" >
                                                    </div>
                                                </div>
                        <div class="form-group">
                            <div class="row">
                                <label for="name" class="col-md-2" style="margin-left: 10px;text-align: center;margin-top: 5px">描述:</label>
                                <input type="text" class="col--md-10" data-bind="value:intro" placeholder="请输入描述" style="padding: 5px">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <label for="name" class="col-md-2" style="margin-left: 10px;text-align: center;margin-top: 5px">课程老师:</label>
                                <input type="text" class="col--md-10" data-bind="value:author" placeholder="请输入作者" style="padding: 5px">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <label for="name" class="col-md-2" style="margin-left: 10px;text-align: center;margin-top: 5px">视频地址:</label>
                                <input type="text" class="col--md-10" data-bind="value:video" placeholder="请输入地址" style="padding: 5px">
                            </div>
                        </div>
                        <#--                        <button type="submit" class="btn btn-primary" data-bind="submit:commitSubmit">确定</button>-->
                </div>
            </div>
            <div class="clearfix"></div>
            <div class="modal-footer" style="margin-top: 40px">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" data-dismiss="modal" data-bind="click:commitSubmit">确定</button>
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script>
    $("#clear").click(function () {
        viewModel.name('');
        viewModel.price('');
        viewModel.intro('');
        viewModel.url('');
        viewModel.categoryName('');
        viewModel.video('');
        viewModel.author('');
    });
    var viewModel = {
        goodsList:ko.observableArray([]),
        flag:ko.observable(''),
        name:ko.observable('').extend({required:true}),
        author:ko.observable('').extend({required:true}),
        price:ko.observable('').extend({required:true}),
        intro:ko.observable('').extend({required:true}),
        url:ko.observable('').extend({required:true}),
        video:ko.observable('').extend({required:true}),
        categoryName:ko.observable(''),
        change:function(){
            $.ajax({
                url: "/api/goods/"+ viewModel.flag(),
                method: "DELETE",
                contentType: "application/json", //必须这样写
                dataType: "json",
                // data:JSON.stringify(list),
                success: function (result) {
                    console.log(result);
                    viewModel.name('');
                    viewModel.price('');
                    viewModel.intro('');
                    viewModel.goodsList([]);
                    viewModel.url('');
                    viewModel.categoryName('');
                    viewModel.video('');
                    viewModel.author('');
                    $.get('/api/goods',function (result) {
                        console.log(result);
                        $.each(result.list, function (i, el) {
                            viewModel.goodsList.push(el);
                        })
                    });
                },
                error : function(result) {
                    console.log(result);
                }
            });
            return false;
        },
        del:function(id){
            console.log(id);
            viewModel.flag(id);
        },
        commitSubmit: function () {
            if(viewModel.name()== '' || viewModel.price() =='' || viewModel.intro()== ''){
                console.log('不能为空');
                alert("请完整填写信息");
                return false;
            }
            var list = {};
            list.name = viewModel.name();
            list.price = viewModel.price();
            list.intro = viewModel.intro();
            list.img = viewModel.url();
            list.categoryName = viewModel.categoryName();
            list.video = viewModel.video();
            list.author = viewModel.author();
            console.log(list);
            $.ajax({
                url: "/api/goods",
                method: "POST",
                contentType: "application/json", //必须这样写
                dataType: "json",
                data:JSON.stringify(list),
                success: function (result) {
                    console.log(result);
                    viewModel.name('');
                    viewModel.price('');
                    viewModel.intro('');
                    viewModel.goodsList([]);
                    viewModel.video('');
                    $.get('/api/goods',function (result) {
                        console.log(result);
                        $.each(result.list, function (i, el) {
                            viewModel.goodsList.push(el);
                        })
                    });
                },
                error : function(result) {
                    console.log(result);
                }
            });
            return false;
        }

    };

    $.get('/api/goods',function (result) {
        console.log(result);
        $.each(result.list, function (i, el) {
            viewModel.goodsList.push(el);
        })
    });
    ko.applyBindings(viewModel);
</script>
</html>



