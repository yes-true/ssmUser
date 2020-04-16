$(function () {
    $('#b1').click(function () {
        var userid = $('#userid').val();
        var password = $('#password').val();
        var url = $('#pageContext').val();
        if(userid == ""){

            alert("用户不能为空");
            return false;
        }
        if(password == ""){

            alert("密码不能为空");
            return false;
        }
        $.ajax({
            type : "post",
            url : url+"/ulogin/"/*?userid=+userid+
                "&password="+password*/,
            dataType : "json",
            contentType : 'application/json',
            data : JSON.stringify({
                userid:userid,
                password:password
            }),
            success : function (data){
                if (data.key == -1){
                    alert("账户或密码错误");
                    return false;
                }else{
                    window.location.href = url + "/udatum?userid="+data.key;
                }
            },
            error : function () {
                alert("连接失败")
                return false;
            }
        })

    })
})