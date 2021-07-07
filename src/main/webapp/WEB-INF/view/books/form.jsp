<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Form - add Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #tableText
        {
            vertical-align: middle;
            margin: 5px;
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
    <form:form action="add" modelAttribute="book" method="POST">
        <table id="tableText">
            <tbody>
            <tr>
                <td><label for="title">Tytuł:</label></td>
                <td><form:input path="title" id="title"/></td>
            </tr>
            <tr>
                <td><label for="publishing_house">Wydawnictwo:</label></td>
                <td><form:input path="publishing_house" id="publishing_house"/></td>
            </tr>
            <tr>
                <td><label for="price">Cena:</label></td>
                <td><form:input path="price" id="price"/></td>
            </tr>
            <tr>
                <td><label for="categories">Kategoria:</label></td>
                <td>
                    <form:select path="category" id="categories">
                        <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><label for="authors">Autorzy:</label></td>
                <td>
                    <form:select multiple="true" path="authors" id="authors">
                        <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:hidden path="id"/></td>
            </tr>
            <tr>
                <td>
                    <form:button class="btn btn-secondary" type="submit">Save</form:button>
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>
<button class="btn btn-secondary" id="bloc3" onclick="location.href='${contextPath}/books/list';">Powrót</button>
</body>
</html>
