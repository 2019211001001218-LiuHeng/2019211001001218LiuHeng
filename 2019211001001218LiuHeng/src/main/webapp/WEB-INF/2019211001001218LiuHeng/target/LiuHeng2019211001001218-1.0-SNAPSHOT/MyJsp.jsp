<%--
  Created by IntelliJ IDEA.
  User: 刘衡
  Date: 2021/3/15
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">go to ecjtu</a><!--method is GET-->
<form method="post"><!--what is method when we use form?--><!--its GET,why?default is GET,form data is added in the URl,u can see-->-->
<!--its better to use POST in form,data in not added in the URL-->
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    <input type="submit" value="Send data to server"/>
</form>

</body>
</html>
