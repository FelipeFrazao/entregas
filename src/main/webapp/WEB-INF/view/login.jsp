<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Spring Security Tutorial</title>
    <link rel="stylesheet" type="text/css" th:href="@{/css/login.css}" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<form th:action="@{/registration}" method="get">
    <button class="btn btn-md btn-warning btn-block" type="Submit">Go To Registration Page</button>
</form>

<div class="container">
    <form:form action="/login" method="POST" class="form-signin" modelAttribute="user">
        <h3 class="form-signin-heading" th:text="Welcome"></h3>
        <br/>

        <form:input path="email" type="text" id="email" name="email"  th:placeholder="Email"
               class="form-control" /> <br/>
        <form:input path="password" type="password"  th:placeholder="Password"
               id="password" name="password" class="form-control" /> <br />

        <div align="center" th:if="${param.error}">
            <p style="font-size: 20; color: #FF1C19;">Email or Password invalid, please verify</p>
        </div>
        <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit" text="Login"></button>
    </form:form>
</div>
</body>
</html>