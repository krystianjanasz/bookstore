<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Index</title>
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
        #bloc3
        {
            margin: 5px;
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
<div class="list-group">
    <a class="list-group-item list-group-item-action" href="${contextPath}/books/list">Lista Książek</a>
    <a class="list-group-item list-group-item-action" href="${contextPath}/books/add">Dodaj Książkę</a>
    <br>
    <a class="list-group-item list-group-item-action" href="${contextPath}/categories/list">Lista Kategorii</a>
    <a class="list-group-item list-group-item-action" href="${contextPath}/categories/add">Dodaj Kategorię</a>
    <br>
    <a class="list-group-item list-group-item-action" href="${contextPath}/authors/list">Lista Autorów</a>
    <a class="list-group-item list-group-item-action" href="${contextPath}/authors/add">Dodaj Autora</a>
    <br>
</div>
</body>
</html>
