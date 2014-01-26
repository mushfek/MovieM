<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mushfekur
  Date: 9/3/13
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> New Movie Form | Movie Manager </title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>

<body>
<div id="headings"><h1 align="center"> New Movie Form </h1></div>

<div id="new-movie-field">
    <form action="/add-success" method="post">
        <%--Movie Info--%>
        <fieldset>
            <legend> Movie Info</legend>
            Movie Name <input type="text" name="movieName"/> <br/>
            Release Year <input type="text" name="releaseYear"/> <br/>
            IMDb Link <input type="text" name="movieLink"/> <br/>
        </fieldset>

        <%--Director Info--%>
        <fieldset>
            <legend> Director Info</legend>
            Director Name <input type="text" name="directorName"/> </br>
            IMDb Link <input type="text" name="directorLink"/> </br>
        </fieldset>

        <%--Actor Info--%>
        <fieldset>
            <legend> Actor Info</legend>
            Actor Name <input type="text" name="actorName"/> </br>
            IMDb Link <input type="text" name="actorLink"/> </br>
        </fieldset>
        <input type="hidden" name="userId" value="${user.id}"/>
        <input type="submit" value="Add" style="width: 100px"/>
        <input type="reset" name="reset" value="Reset" style="width: 100px"/>
    </form>
</div>
</form>
</body>
</html>