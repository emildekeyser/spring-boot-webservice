<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Gerechten</title>
</head>
<body>
<h1>Gerechten</h1>
<table>
    <thead>
    <th>Naam</th>
    <th>Prijs</th>
    </thead>
    <tbody>
    <c:forEach var="dish" items="${dishes}">
        <tr>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
                <%--<td>${dish.description}</td>--%>
            <td><a href="/dishes/update/${dish.id}">Update</a></td>
            <td><a href="/dishes/delete/${dish.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/dishes/add">Add new</a>
</body>
</html>