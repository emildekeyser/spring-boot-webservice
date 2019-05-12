<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="label.dishes"/></title>
</head>
<body>
    <ul>
        <li><a href="/dishes/"><spring:message code="label.dishes" /></a></li>
        <%--<li><a href="/feedback/add">Add feedback</a></li>--%>
    </ul>
    <span><spring:message code="lang.change"/></span>:
    <select id="locales">
        <option value=""></option>
        <option value="en"><spring:message code="lang.en" /></option>
        <option value="nl"><spring:message code="lang.nl" /></option>
        <option value="fr"><spring:message code="lang.fr" /></option>
    </select>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
    </script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#locales").change(function () {
                var selectedOption = $('#locales').val();
                if (selectedOption != ''){
                    window.location.replace('/' + selectedOption + '/home');
                }
            });
        });
    </script>
</body>
</html>