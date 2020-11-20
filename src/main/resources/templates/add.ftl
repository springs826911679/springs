
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<form role="form">
    <div class="form-group">
        <label for="name">标题</label>
        <input type="text" class="form-control" placeholder="文本输入">
    </div>
    <div class="form-group">
        <label for="price">价格</label>
        <input type="text" class="form-control" placeholder="文本输入">
    </div>
    <div class="form-group">
        <label for="intro">价格</label>
        <input type="text" class="form-control" placeholder="文本输入">
    </div>
    <button  id="btn">提交</button>
</form>
<script>
    // $.post('/api/goods',{"name":"你好","price":1}).then(
    //
    // )
    $("#btn").click(function () {
        console.log('asd');
        var list = [];
        list.id = 3;
        list.name = 'Nihao ';
        list.price = 2;
        // $.get('/api/goods',function (res) {
        //     console.log(res);
        // });
        $.ajax({
            url: '/api/goods',
            type: 'GET',
            data: {},
            dataType:'jsonp',
            success: function (res) {
                console.log(res);
            }

        })
    });


</script>