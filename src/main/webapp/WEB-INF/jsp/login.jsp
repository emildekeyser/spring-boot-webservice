<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title><spring:message code="lang.login"/></title>
</head>
<body>
    <h1><spring:message code="lang.login"/></h1>
    <form action="/login" method="POST">
        <p>
            <label for="username"><spring:message code="lang.username"/></label>
            <input id="username" type="text" name="username"/>
        </p>
        <p>
            <label for="password"><spring:message code="lang.password"/></label>
            <input id="password" type="password" name="password"/>
        </p>
        <input type="submit" name="submit" value="<spring:message code='lang.login'/>"/>
    </form>
</body>
</html>