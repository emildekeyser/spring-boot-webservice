<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title><spring:message code="label.dishes"/></title>
</head>
<body>
<h1><spring:message code="label.dishes"/></h1>
<table>
    <thead>
    <th><spring:message code="label.dish.name"/></th>
    <th><spring:message code="label.dish.price"/></th>
    </thead>
    <tbody>
    <c:forEach var="dish" items="${dishes}">
        <tr>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
                <%--<td>${dish.description}</td>--%>
            <td><a href="/dishes/update/${dish.name}"><spring:message code="label.update"/></a></td>
            <td><a href="/dishes/delete/${dish.name}"><spring:message code="label.delete"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/dishes/add"><spring:message code="label.addnew"/></a>
</body>
</html>