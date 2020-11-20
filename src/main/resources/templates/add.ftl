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

    </style>
</head>
<body>
    <div>
        <form action="" data-bind="submit:commitSubmit">
            <div class="form-group">
                <label for="name">名称</label>
                <input type="text" class="form-control" data-bind="value:name" placeholder="请输入名称">
            </div>
            <div class="form-group">
                <label for="price">价格</label>
                <input type="text" class="form-control" data-bind="value:price" placeholder="请输入价格">
            </div>
            <div class="form-group">
                <label for="price">描述</label>
                <input type="text" class="form-control" data-bind="value:desc" placeholder="请输入描述">
            </div>
            <button type="submit" class="btn btn-default" id="btn">提交</button>
        </form>
    </div>
</body>
<script>
    var viewModel = {
        name:ko.observable(''),
        price:ko.observable(''),
        desc:ko.observable(''),
        commitSubmit: function () {
            var list = {};
            list.name = viewModel.name();
            list.price = viewModel.price();
            list.desc = viewModel.desc();
            console.log(list);
            $.ajax({
                url: "/api/goods",
                method: "POST",
                contentType: "application/json", //必须这样写
                dataType: "json",
                // data:JSON.stringify(list),
                success: function (result) {
                    console.log(result);
                },
                error : function(result) {
                    console.log(result);
                }
            });
            return false;
        }

    };
    ko.applyBindings(viewModel);
</script>
</html>



