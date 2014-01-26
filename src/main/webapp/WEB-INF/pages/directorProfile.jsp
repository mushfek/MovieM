<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mushfekur
  Date: 9/5/13
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Movies Directed by ${director.name} | Movie Manager </title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div style="text-align: left"><a href="/user-profile/${user.id}"> Go Back to Full Movie List </a> |
    <a href="/logout/${user.id}"> Logout </a></div>

<div style="text-align: center">
    <h2 id="headings" align="center">
        Movies Directed by <a href="${director.link}"> ${director.name} </a>
    </h2>

    <table id="movie-list">
        <thead>
        <tr>
            <th scope="col"> Movie Name</th>
            <th scope="col"> Release Year</th>
            <th scope="col"> Lead Actor</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="movie" items="${movieList}">
            <tr>
                <td><a href="${movie.link}" target="_blank"> ${movie.name} </a></td>
                <td><a href="/movie-by-year/${user.id}/${movie.year}"> ${movie.year} </a></td>
                <td><a href="/actor-movie-list/${user.id}/${movie.actor.id}"> ${movie.actor.name} </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>