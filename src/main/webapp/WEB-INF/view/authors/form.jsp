<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Form - add Author</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #tableText
        {
            vertical-align: middle;
        }
        #bloc1
        {
            display:inline;
            font-size: 20px;
            padding-right: 5px;
        }
        #bloc2
        {
            display:inline;
        }
        #home{
            display:inline;
            float: left;
            font-size: 20px;
            padding-right: 5px
        }
    </style>
</head>
<body>
<div class="p-2 mb-2 bg-dark text-white" align="right">
    <div class="text-light" id="home" onclick="location.href='${contextPath}';">
        Home
    </div>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            <div class="text-light" id="bloc1">
                Hello, ${pageContext.request.userPrincipal.name}
            </div>
            <div id="bloc2">
                <button class="btn btn-primary" onclick="location.href='${contextPath}/books/shopping-cart';">Cart</button>
            </div>
            <div id="bloc2">
                <button class="btn btn-secondary" onclick="location.href='${contextPath}/logout';">Logout</button>
            </div>
        </c:when>
        <c:otherwise>
            <button class="btn btn-secondary" onclick="location.href='${contextPath}/login';">Login</button>
        </c:otherwise>
    </c:choose>
</div>
<form:form action="add" modelAttribute="author" method="POST">
    <table>
        <tbody>
        <tr>
            <td><label for="name">imię:</label></td>
            <td><form:input path="name" id="name"/></td>
        </tr>
        <tr>
            <td><label for="surname">nazwisko:</label></td>
            <td><form:input path="surname" id="surname"/></td>
        </tr>
        <tr>
            <td><form:button class="btn btn-secondary" type="submit">Save</form:button></td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
