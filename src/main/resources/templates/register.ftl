<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>love</title>
    <link href="favicon.ico" rel="shortcut icon" />
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
</head>
<body style=" background: url(
'/login—background.png'
) no-repeat center center fixed; background-size: 100%;">


<div class="modal-dialog" style="margin-top: 10%;width: 410px">
    <div class="modal-content">
        <div class="modal-header">

            <h4 class="modal-title text-center" id="myModalLabel">登录</h4>
        </div>
        <div class="modal-body" id = "model-body">
            <div class="form-group">

                <input type="text" name="username" class="form-control"placeholder="用户名" id="username">
            </div>
            <div class="form-group">

                <input type="text" name="password" class="form-control" placeholder="密码" id="password">
            </div>
        </div>
        <div class="modal-footer">
            <div class="form-group">
                <button type="submit" class="btn btn-primary form-control" id="btn">注册</button>
            </div>
            <div class="form-group">
                <a type="button" class="btn btn-default form-control" href="/login">返回</a>
            </div>

        </div>
    </div><!-- /.modal-content -->
</div><!-- /.modal -->

</body>
<script>
    $("#btn").click(function () {
        var list = {};
        list.username = $('#username').val();
        list.password = $('#password').val();
        console.log(list);
        $.ajax({
            url: '/api/register',
            method: 'POST',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(list),
            success: function (result) {
                console.log('注册成功');
                // console.log(result.status);
                    window.location.href = '/login';
            },
            error: function (result) {
                console.log('注册bu成功');
                console.log(result);
            }
        })
    })
</script>
</html>