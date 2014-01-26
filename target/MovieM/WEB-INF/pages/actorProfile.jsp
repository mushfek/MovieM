<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mushfekur
  Date: 9/8/13
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> ${actor.name}'s Movies | Movie Manager </title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div style="text-align: left"><a href="/user-profile/${user.id}"> Go Back to Full Movie List </a> |
    <a href="/logout/${user.id}"> Logout </a></div>

<div style="text-align: center">
    <h2 id="headings"><a href="${actor.link}" target="_blank"> ${actor.name} </a>'s Movies </h2>
</div>

<table id="movie-list">
    <thead>
    <tr>
        <th scope="col"> Movie Name</th>
        <th scope="col"> Release Name</th>
        <th scope="col"> Director</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="movie" items="${movieList}">
        <tr>
            <td><a href="${movie.link}" target="_blank"> ${movie.name} </a></td>
            <td><a href="/movie-by-year/${user.id}/${movie.year}"> ${movie.year} </a></td>
            <td><a href="/dir-movie-list/${user.id}/${movie.director.id}"> ${movie.director.name} </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>