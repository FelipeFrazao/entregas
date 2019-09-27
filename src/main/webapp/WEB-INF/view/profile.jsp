<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Perfil</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
<div class="container" >
    <div class="row my-2">
        <div class="col-lg-8 order-lg-2">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="" data-target="#profile" data-toggle="tab" class="nav-link active">Profile</a>
                </li>
                <li class="nav-item">
                    <a href="" data-target="#deliveries" data-toggle="tab" class="nav-link">Historico de entrega</a>
                </li>
                <li class="nav-item">
                    <a href="/editUser/${client.id}" class="nav-link">Edit</a>
                </li>
            </ul>
            <div class="tab-content py-4">
                <div class="tab-pane active" id="profile">
                    <h3 class="mb-3">${client.name}</h3>
                    <div class="row">
                        <div class="col-md-6">
                            <h6>Email</h6>
                            <p>
                                ${client.email}
                            </p>
                            <h6>Telefone</h6>
                            <p>
                                ${client.phone}
                            </p>
                            <h6>CPF</h6>
                            <p>
                                ${client.cpf}
                            </p>
                            <h6>Endereço padrão</h6>
                            <p>
                                ${client.defaultAddress}
                            </p>
                        </div>
                        <div class="col-md-12">
                            <h3>Histórico de entregas</h3>
                            <c:forEach var="delivery" items="${client.deliveries}">
                                <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Recent Activity</h5>
                                <div class="row">
                                    <h4>${delivery.senderAddress}</h4>
                                </div>
                                <div class="row">
                                    <h5>${delivery.deliveryman.name}</h5>
                                </div>
                                <div class="row">
                                    <p>${delivery.distance}</p>
                                </div>
                                <div class="row">
                                    <p>${delivery.status}</p>
                                </div>
                                <c:forEach var="payload" items="${delivery.payloads}">
                                    <div class="row">
                                        <p>${payload.name}</p>
                                    </div>
                                    <div class="row">
                                        <p>${payload.name}</p>
                                    </div>
                                </c:forEach>
                            </c:forEach>
                            <table class="table table-sm table-hover table-striped">
                                <tbody>
                                <tr>
                                    <td>
                                        <strong>Abby</strong> joined ACME Project Team in <strong>`Collaboration`</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>Gary</strong> deleted My Board1 in <strong>`Discussions`</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>Kensington</strong> deleted MyBoard3 in <strong>`Discussions`</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>John</strong> deleted My Board1 in <strong>`Discussions`</strong>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>Skell</strong> deleted his post Look at Why this is.. in <strong>`Discussions`</strong>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--/row-->
                </div>
                <div class="tab-pane" id="deliveries">
                    <div class="alert alert-info alert-dismissable">
                        <a class="panel-close close" data-dismiss="alert">×</a> This is an <strong>.alert</strong>. Use this to show important messages to the user.
                    </div>
                    <table class="table table-hover table-striped">
                        <tbody>
                        <tr>
                            <td>
                                <span class="float-right font-weight-bold">3 hrs ago</span> Here is your a link to the latest summary report from the..
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class="float-right font-weight-bold">Yesterday</span> There has been a request on your account since that was..
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class="float-right font-weight-bold">9/10</span> Porttitor vitae ultrices quis, dapibus id dolor. Morbi venenatis lacinia rhoncus.
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class="float-right font-weight-bold">9/4</span> Vestibulum tincidunt ullamcorper eros eget luctus.
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class="float-right font-weight-bold">9/4</span> Maxamillion ais the fix for tibulum tincidunt ullamcorper eros.
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>