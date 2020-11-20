<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>love</title>
    <link href="favicon.ico" rel="shortcut icon" />
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style=" background: url(
'/login—background.png'
) no-repeat center center fixed; background-size: 100%;">


<div class="modal-dialog" style="margin-top: 10%;width: 410px">
    <div class="modal-content">
        <div class="modal-header">

            <h4 class="modal-title text-center" id="myModalLabel">登录</h4>
        </div>
        <form action="/toLogin" method="post">
        <div class="modal-body" id = "model-body">
            <div class="form-group">

                <input type="text"  name="username" class="form-control"placeholder="用户名" autocomplete="off">
            </div>
            <div class="form-group">

                <input type="text" name="password" class="form-control" placeholder="密码" autocomplete="off">
            </div>
        </div>
        <div class="modal-footer">
            <div class="form-group">
                <button type="submit" class="btn btn-primary form-control">登录</button>
            </div>
            <div class="form-group">
                <a type="button" class="btn btn-default form-control" href="/register">注册</a>
            </div>
        </div>
        </form>
    </div><!-- /.modal-content -->
</div><!-- /.modal -->

</body>

<script>

</script>
</html>