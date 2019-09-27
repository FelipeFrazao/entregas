<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editar perfil</title>
</head>
<header>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Pedir nova entrega</a>
                </li>
                <li class="nav-item dropdown align-right">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Conta
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/profile/${user.id}">Perfil</a>
                        <a class="dropdown-item" href="#">Sair</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>
<body>
<div class="col-md-6 justify-content-center align-items-center">
    <form:form class="form-horizontal" action='register' method="POST" modelAttribute="user">
        <fieldset>
            <div id="legend">
                <legend class="">Editar seu perfil</legend>
            </div>
            <div class="form-group">
                <!-- Username -->
                <form:label path="name" class="control-label" for="username">Nome Completo</form:label>
                <div class="controls">
                    <form:input path="name" type="text" id="username" name="username" placeholder="" class="form-control" required="required"/>
                </div>
            </div>

            <div class="form-group">
                <!-- E-mail -->
                <form:label path="email" class="control-label" for="email">E-mail</form:label>
                <div class="controls">
                    <form:input path="email" type="text" id="email" name="email" placeholder="" class="form-control" required="required"/>
                </div>
            </div>

            <div class="form-group">
                <!-- Password-->
                <form:label path="password" for="password">Senha</form:label>
                <div class="controls">
                    <form:input path="password" type="password" id="password" name="password" placeholder="" class="form-control" required="required"/>
                </div>
            </div>

            <div class="form-group">
                <!-- Telefone -->
                <form:label path="phone" for="phone">Telefone</form:label>
                <div class="controls">
                    <form:input path="phone" type="text" id="phone" name="phone" placeholder="" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <!-- CPF -->
                <form:label path="cpf" for="phone">Telefone</form:label>
                <div class="form-group">
                    <form:input path="cpf" type="text" id="cpf" name="cpf" placeholder="" class="form-control" required="required"/>
                </div>
            </div>

            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-primary">Salvar</button>
                </div>
            </div>
        </fieldset>
    </form:form>
</div>

</body>
</html>