/**
 * 判断邮箱是否可用
 */
$(function () {
    $("#userEmail").on('input propertychange',function(){
        reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        menbername = $.trim($("#menbername").val());
        url = $.trim($("#pageContext").val());
        userEmail = $.trim($("#userEmail").val());
        password = $.trim($("#password").val());
        isok = reg.test(userEmail);
        if (isok && userEmail.split("@")[0].length <= 64 && userEmail.length <= 255){
            $("#f1").html("该邮箱可用");
            $("#f1").attr("color","green");
            $("#b1").attr("disabled",false);
        }else if(userEmail.split("@")[0].length > 64 || userEmail.length > 255){
            $("#f1").html("邮箱过长");
            $("#f1").attr("color","red");
            $("#b1").attr("disabled",true);
        }else {
            $("#f1").html("邮箱不可用");
            $("#f1").attr("color","red");
            $("#b1").attr("disabled",true);//true按钮不可用 false按钮可用
        }
        $.ajax({
            type : "post",
            url : url + "/uJudge",
            dataType : "json",
            contentType : "application/json",
            data : JSON.stringify({
                menbername : menbername,
                email : userEmail,
                password : password
            }),
            success : function (data) {

                if (data.error == -1){
                    $("#f1").html("该邮箱不可用")
                    $("#f1").attr("color","red")
                    $("#b1").attr("disabled",true)
                }
            }
        })
    });

})
/**
 * 实时监控密码框，对比两次密码是否相等
 */
$(document).ready(function(){
    $('#password').on('input propertychange', function() {
        //input propertychange即实时监控键盘输入包括粘贴
        var pwd = $.trim($(this).val());
        //获取this，即passwod的val()值，trim函数的作用是去除空格
        var rpwd = $.trim($("#password1").val());
        if(rpwd!=""){
            if(pwd==""&&rpwd==""){
                //若都为空，则提示密码不能为空，为了用户体验（在界面上用required同时做了处理）
                $("#f2").html("密码不能为空");
                $("#f2").attr("color","red")
            }
            else{
                if(pwd==rpwd){                                 //相同则提示密码匹配
                    $("#f2").html("两次密码匹配通过");
                    $("#f2").attr("color","green")
                    $("#b1").attr("disabled",false);
                }else{                                          //不相同则提示密码匹配
                    $("#f2").html("两次密码不匹配");
                    $("#b1").attr("disabled",true);
                }
            }}
    })
})

//由于是两个输入框，所以进行两个输入框的几乎相同的判断
$(document).ready(function(){
    $('#password1').on('input propertychange', function() {
        var pwd = $.trim($(this).val());
        var rpwd = $.trim($("#password").val());
        if(pwd==""&&rpwd==""){
            $("#f2").html("密码不能为空");
            $("#f2").attr("color","red")
        }
        else{
            if(pwd==rpwd){
                $("#f2").html("两次密码匹配通过");
                $("#f2").attr("color","green")
                $("#b1").attr("disabled",false);
            }else{
                $("#f2").html("两次密码不匹配");
                $("#f2").attr("color","red")
                $("#b1").attr("disabled",true);
            }
        }
    })
})
/**
 * 提交用户注册，成功后调至页面
 */
$(function () {
    $("#b1").click(function () {
        if ($.trim($('#userEmail').val()) == "" ||
            $.trim($('#password').val()) == "" ||
            $.trim($('#password1').val()) == ""){
            alert("不能有空值");
            return false;
        }
        url = $("#pageContext").val();
        $.ajax({
            type : "post",
            url : url + "/uReg",
            dataType : "json",
            contentType : "application/json",
            //JSON.stringify()将json对象转为String类型
            data : JSON.stringify({
                menbername : $.trim($("#menbername").val()),
                email : $.trim($("#userEmail").val()),
                password : $.trim($("#password").val()),
                atime : $("#atime").val(),
                utime : $("#utime").val()
            }),
            success : function (data) {
                if (data.error == -1){
                    alert("提交失败，刷新后重试！！！");
                    return false;
                }else{
                    window.location.href = url + "/udatum?userid="+data.uid;
                }
            },
            error : function () {
                alert("请求失败，刷新后重试！！！");
                return false;
            }
        })
    })
})

/**
 * 页面实时时间戳
 */
function displayTime() {
    date = new Date().getTime();
    /*getYear = date.getFullYear();
    getMonth = date.getMonth()+1;
    if (getMonth < 10){
        getMonth = "0"+getMonth;
    }
    getDate = date.getDate();
    getHouts = date.getHours();
    getMinutes = date.getMinutes();
    getSeconds = date.getSeconds();*/

    /*$("#atime").attr("value",getYear+getMonth+getDate+getHouts+getMinutes+getSeconds);
    $("#utime").attr("value",getYear+getMonth+getDate+getHouts+getMinutes+getSeconds);*/
    $("#atime").attr("value",date);
    $("#utime").attr("value",date);
    setTimeout("displayTime()",1000);
}
window.onload = function(){
    displayTime();
}
