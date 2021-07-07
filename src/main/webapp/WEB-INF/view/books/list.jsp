<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Books List</title>
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
<h2>Lista dostępnych książek:</h2>
<div>
    <table class="table table-hover" id="tableText">
        <tr>
            <th scope="col">Nazwa</th>
            <th scope="col">Wydawnictwo</th>
            <th scope="col">Autorzy</th>
            <th scope="col">Cena</th>
            <th scope="col">Kategoria</th>
            <th scope="col"></th>
        </tr>
        <c:forEach var="book" items="${books}" >
            <c:url var="update" value="/books/edit">
                <c:param name="bookId" value="${book.id}"/>
            </c:url>
            <c:url var="delete" value="/books/delete">
                <c:param name="bookId" value="${book.id}"/>
            </c:url>
            <tr>
                <td>${book.title}</td>
                <td>${book.publishing_house}</td>
                <td>
                    <c:forEach var="author" items="${book.authors}">
                        ${author.fullName},
                    </c:forEach>
                </td>
                <td>${book.price}</td>
                <td>${book.category.name}</td>
                <form:form action="" modelAttribute="book" method="POST">
                    <form:hidden path="id" value="${book.id}"/>
                    <td><form:button type="submit" class="btn btn-secondary btn-sm">Dodaj</form:button></td>
                </form:form>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <button class="btn btn-secondary" id="bloc3" onclick="location.href='${contextPath}';">Powrót</button>
</div>
</body>
</html>