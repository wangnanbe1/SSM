<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript">

  $(
    reload
  );

	function reload(){
		document.getElementById("image").src="http://localhost:8090/verification?date="+new Date().getTime();
	}

</script>
</head>
<body>
<form action="http://localhost:8090/login2" method="post">
  用户名:<input type="text" name="id" >	</br>
  密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="name" >	</br>
  <input type="text" name="checkcode"  id="checkcode" class="home_login_button3" placeholder="请输入验证码"/><br />
  <div >
    <img  src="/ssmTest/verification" alt="验证码" id="image"  class="home_login_check_code"/>
    <a href="javascript:reload();" class="home_login_button3_font"><label>换一张</label></a><br>
    <span id="span"> </span>
  </div>
  <input type="submit" value="提交">



</form>

</body>
</html>