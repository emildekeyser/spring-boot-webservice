<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title><spring:message code="label.adddish"/></title>
</head>
<body>
    <h1><spring:message code="label.adddish"/></h1>
    <c:if test="${errors!=null}">
        <div>
            <c:forEach items="${errors}" var="error">
                <p>${error.field}: ${error.defaultMessage}</p>
            </c:forEach>
        </div>
    </c:if>

    <form method="post" action="/dishes/add">
        <p>
            <label><spring:message code="label.dish.name"/></label>
            <input type="text" name="name" />
        </p>
        <p>
            <label><spring:message code="label.dish.description"/></label>
            <input type="text" name="description" />
        </p>
        <p>
            <label><spring:message code="label.dish.price"/></label>
            <input type="text" name="price" />
        </p>
        <p>
            <input type="submit" value="<spring:message code="label.addnew"/>" />
            <input type="reset" value="<spring:message code="label.reset"/>" />
        </p>
    </form>
</body>
</html>