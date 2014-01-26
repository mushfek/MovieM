<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Home | Movie Manager </title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<div id="home-menu-ver">
    <table>
        <tr>
            <td><h3> Hello, ${user.name}! </h3></td>
        </tr>
        <tr>
            <td><h3><a href="/user-profile/${user.id}"> Check Out Movie List </a></h3></td>
        </tr>
        <tr>
            <td><h3><a href="/new-movie-form/${user.id}"> Add A New Movie </a></h3></td>
        </tr>
        <tr>
            <td><h3><a href="/logout/${user.id}"> Logout </a></h3></td>
        </tr>
    </table>
</div>
</body>
</html>