<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h2>hello world</h2>

    <form name = "form1" action="/manage/product/upload.do" method="post" enctype = "multipart/form-data">
        <input type="file" name="upload_file"/>
        <input type="submit" value="SpringMVC文件上传"/>
    </form>

    <form name = "form1" action="/manage/product/richtext_img_upload.do" method="post" enctype = "multipart/form-data">
        <input type="file" name="upload_file"/>
        <input type="submit" value="富文本文件上传"/>
    </form>
</body>
</html>