<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head lang='pt-br'>
        <meta charset='UTF-8'>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estetica</title>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <link rel='shortcut icon' href='static/favicon.ico' type='image/x-icon'>
        <link rel='icon' href='static/favicon.ico' type='image/x-icon'>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
    </head>
    <body>
            <c:if test="${logado == null}">
                <jsp:forward page="login.jsp"> 
                    <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema."/>
                </jsp:forward>
            </c:if>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='novo-tab' class='tab selected'>
                    Novo atendimento
                </button>
                <button id='historico-tab' class='tab' onclick="location.href = 'ClienteServlet?action=Listagem_atendimentos';">
                    Meus atendimentos
                </button>
                <button id='alterar-tab' class='tab' onclick="location.href = 'ClienteServlet?action=alterar_dados';">
                    Alterar meus dados
                </button>
            </div>
            <div id='session'>
                <button id='user-name' class='drop-button'  onclick="location.href = 'LogoutServlet';">
                    Sair
                </button>
            </div>
        </header>
        <div class='caixa cadastro'>
            <div class='conteudo'>
                <h1>Informações sobre o atendimento</h1>
                <form method='post' action='ClienteServlet?action=cadastrando_atendimento'>
                    <select name="produto" required class='form-control campo1'>
                        <option disabled selected hidden>Produto</option>
                        <c:forEach items="${produtos}" var="p">
                            <option name="produto" value="${p.produto_codigo}">${p.produto_nome}</option>
                        </c:forEach>
                    </select>
                    <select name="tipoA" required class='form-control campo1'>
                        <option disabled selected hidden>Tipo de atendimento</option>
                        <c:forEach items="${tipos_atendimentos}" var="t">
                            <option name="tipoA" value="${t.tipo_atendimento_codigo}">${t.tipo_atendimento_nome}</option>
                        </c:forEach>
                    </select>
                    <div class='form-group green-border-focus'>
                        <textarea class='form-control campo0'rows='10' name="descricao" placeholder='Descrição'></textarea>
                    </div>      
                    <button type='submit' class='btn btn-primary margem'>Solicitar atendimento</button>
                </form>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>  
</html>