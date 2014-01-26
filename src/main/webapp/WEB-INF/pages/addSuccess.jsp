<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mushfekur
  Date: 9/4/13
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Adding Successful | Movie Manager </title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div id="home-menu-ver">
    <h2 id="headings" align="center"> Movie Added Successfully! </h2>

    <a href="/new-movie-form/${user.id}"> Add Another Movie </a> <br/>
    <a href="/user-profile/${user.id}"> Go back to movie List </a>
</div>
</body>
</html>