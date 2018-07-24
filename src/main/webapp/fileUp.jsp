<%--
  Created by IntelliJ IDEA.
  User: 王南北
  Date: 2018/7/24
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">


</script>
</head>
<body>
    <form  action="http://localhost:8090/upload" method="post" enctype="multipart/form-data">
        <label>上传头像：</label><input type="file" name="file"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
