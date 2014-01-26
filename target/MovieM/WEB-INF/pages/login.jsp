<%--
  Created by IntelliJ IDEA.
  User: mushfekur
  Date: 9/8/13
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rmreb00t
  Date: 9/8/13
  Time: 1:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Login | Movie Manager </title>
    <style> .error {
        color: red
    } </style>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
    <%--<script type="text/javascript">--%>
    <%--function focusIt() {--%>
    <%--var unameBox = document.getElementById("username");--%>
    <%--unameBox.focus();--%>
    <%--}--%>
    <%--onload = focusIt();--%>
    <%--</script>--%>
</head>
<body>
<div id="login-form">
    <form action="/home" method="post">
        <table>
            <tr>
                <td></td>
                <td colspan="2">
                    <h2 id="headings"> Login </h2>
                    <c:if test="${error == true}">
                        <div class="error"> Incorrect username or password. Please try again!</div>
                    </c:if>
                </td>
            </tr>

            <tr>
                <td> Username</td>
                <td><input type="text" name="username" id="username" size="32" autofocus="autofocus"/></td>
            </tr>
            <tr>
                <td> Password</td>
                <td><input type="password" name="password" id="password" size="32"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" name="submit" value="Login"/>
                    <input type="reset" name="reset" value="Reset"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>