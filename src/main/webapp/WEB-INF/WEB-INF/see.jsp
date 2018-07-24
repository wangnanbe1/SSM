<%--
  Created by IntelliJ IDEA.
  User: 王南北
  Date: 2018/7/24
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
    function test(){
       alert(111)
        $.ajax({
			url:"http://localhost:8090/see",
	        type: "post",
			dataType:"json",
			success:function(msg){

				if(msg.code == '200'){
					$("#img").attr ("src",msg.msg);
				}else{
					mini.alert("审核失败!");
			    }
			}
		});
    }
    </script>
</head>
<body>
    <input type="button" onclick="test()" value="查看"><br>
    <img id="img"  />
</body>
</html>
