<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<form:form class="form-horizontal" action='register' method="POST" modelAttribute="client">
    <fieldset>
        <div id="legend">
            <legend class="">Crie sua conta</legend>
        </div>
        <div class="control-group">
            <!-- Username -->
            <form:label path="name" class="control-label" for="username">Nome Completo</form:label>
            <div class="controls">
                <form:input path="name" type="text" id="username" name="username" placeholder="" class="input-xlarge" required="required"/>
                <p class="help-block">Coloque seu nome</p>
            </div>
        </div>

        <div class="control-group">
            <!-- E-mail -->
            <form:label path="email" class="control-label" for="email">E-mail</form:label>
            <div class="controls">
                <form:input path="email" type="text" id="email" name="email" placeholder="" class="input-xlarge" required="required"/>
                <p class="help-block">Por favor entre com seu E-mail</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <form:label path="password" class="control-label" for="password">Senha</form:label>
            <div class="controls">
                <form:input path="password" type="password" id="password" name="password" placeholder="" class="input-xlarge" required="required"/>
            </div>
        </div>

        <div class="control-group">
            <!-- Telefone -->
            <form:label path="phone" class="control-label" for="phone">Telefone</form:label>
            <div class="controls">
                <form:input path="phone" type="text" id="phone" name="phone" placeholder="" class="input-xlarge"/>
                <p class="help-block">Por favor entre com seu telefone</p>
            </div>
        </div>

        <div class="control-group">
            <!-- CPF -->
            <form:label path="cpf" class="control-label" for="phone">Telefone</form:label>
            <div class="controls">
                <form:input path="cpf" type="text" id="cpf" name="cpf" placeholder="" class="input-xlarge" required="required"/>
                <p class="help-block">Por favor entre com seu cpf</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success">Criar Conta</button>
            </div>
        </div>
    </fieldset>
</form:form>