<%--
  Created by IntelliJ IDEA.
  User: LongGuoShuai
  Date: 2020/4/1
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改头像</title>
    <script src="static/js/jQuery-1.10.2.js"></script>
    <script src="static/js/ajaxfileupload.js"></script>
</head>
<body>

<input type="file" οnchange="imageUpload(this)" class="form-control" placeholder="点击按钮选择图片"id="pictureUpload">
<script>
    function imageUpload(obj) {
        //判断图片格式
        var fileName=obj.value;
        var suffixIndex=fileName.lastIndexOf(".");
        var suffix=fileName.substring(suffixIndex+1).toUpperCase();
        if(suffix!="BMP"&&suffix!="JPG"&&suffix!="JPEG"&&suffix!="PNG"&&suffix!="GIF"){
            layer.msg( "请上传图片（格式BMP、JPG、JPEG、PNG、GIF等）!");
            var file = $("#pictureUpload");
            file.after(file.clone().val(""));
            file.remove();
            return;
        }

        var formData = new FormData();
        formData.append('file', $('#pictureUpload')[0].files[0]);  //添加图片信息的参数
        $.ajax({
            type: "POST",
            url: "/fileUploadPage.do",
            data:formData,
            cache: false, //上传文件不需要缓存
            processData: false,// 告诉jQuery不要去处理发送的数据
            contentType: false,// 告诉jQuery不要去设置Content-Type请求头
            encType:"multipart/form-data",
            success: function(data) {
                alert(data)
            }
        });

    }
</script>
</body>
</html>
