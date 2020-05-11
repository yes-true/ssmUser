<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改头像</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
    <script src="static/js/ajaxfileupload.js"></script>
</head>
<body>

<form enctype="multipart/form-data" id="upload">
    <input type="file" name="photo" id="pic_img" />
    <input type="hidden" name="user_id" id="user_id" value="${user.id}">
    <input type="button" onclick="upload()" value="点击上传"/>
</form>
<input type="hidden" id="path" value="${pageContext.request.contextPath}" />
<script>

    function upload() {
        var path = $('#path').val();
        var id = $('#user_id').val();
        var formData = new FormData($('#upload')[0]);
        formData.append('img',$('#pic_img')[0].files[0]);
        formData.append('user_id',$('#user_id').val());
        if($('#pic_img').val() == ''){
            alert("不能为空");
            return false;
        }
        $.ajax({
            type : "post",
            url : path+"/upload_img",
            dataType : "json",
            data : formData,
            async : false,
            //上传文件不需要缓存
            cache : false,
            contentType : false,
            processData : false,
            success : function (data) {
                if (data.error != 0){
                    alert("上传失败");
                    return false;
                }else{
                    window.location.href = path+"/udatum?userid="+id;
                }

            },
            error : function () {
                //alert("连接失败");
                window.location.href = path+"/udatum?userid="+id;
                //return false;
            }
        })
    }
</script>
</body>
</html>
