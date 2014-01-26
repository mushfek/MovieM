<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mushfekur
  Date: 9/3/13
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> ${user.name}'s Movie List </title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>

<body>
<div style="text-align: left"><a href="/new-movie-form/${user.id}"> Add A New Movie </a> |
    <a href="/logout/${user.id}"> Logout </a></div>

<div style="text-align: center">
    <h2 id="headings" align="center"> ${user.name}'s Movie List </h2>
    <table id="movie-list">
        <thead>
        <tr>
            <th scope="col"> Movie Name</th>
            <th scope="col"> Release Year</th>
            <th scope="col"> Director</th>
            <th scope="col"> Lead Actor</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="movie" items="${movieList}">
            <tr>
                <td><a href="${movie.link}" target="_blank"> ${movie.name} </a></td>
                <td><a href="/movie-by-year/${user.id}/${movie.year}"> ${movie.year} </a></td>
                <td><a href="/dir-movie-list/${user.id}/${movie.director.id}"> ${movie.director.name} </a></td>
                <td><a href="/actor-movie-list/${user.id}/${movie.actor.id}"> ${movie.actor.name} </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>