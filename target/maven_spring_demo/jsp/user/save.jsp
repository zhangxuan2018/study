<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/26
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<meta charset="UTF-8">
<head>
    <form action="demo/user/saveUser" method="post">
        姓名：<input name="name"/>
        手机号：<input name="mobilePhone"/>
        性别：<input type="checkbox" name="sex" value="0">女</input>
        <input type="checkbox" name="sex" value="1">男</input>
        <input type="submit" value="提交"/>
    </form>
</head>
<body>

</body>
</html>
