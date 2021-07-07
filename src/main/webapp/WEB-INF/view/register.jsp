<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Rejestracja</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #loginText
        {
            text-align: center;
            margin: 5px auto;
        }
        #block1
        {
            text-align: center;
            margin: auto;
        }
    </style>
</head>
<body>
<c:if test="${not empty info}">
    <p><c:out value="${info}"/></p>
</c:if>
<form:form method="post" modelAttribute="user">
    <h3 id="loginText">Rejestracja</h3>
    <table id="block1">
        <tbody>
        <tr>
            <td><label for="username">Nazwa:</label></td>
            <td><form:input path="username" id="username"  /></td>
        </tr>
        <tr>
            <td><label for="password">Hasło:</label></td>
            <td><form:password path="password" id="password"  /></td>
        </tr>
        <tr>
            <td>
                <button class="btn btn-secondary" type="submit" >Zarejestruj</button>
            </td>
        </tr>
        </tbody>
    </table>
</form:form>
</body>
</html>
