<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head lang='pt-br'>
        <meta charset='UTF-8'>
        <title>BEIBE - Beauty Embuste Industria de Beleza e Estetica</title>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <link rel='shortcut icon' href='static/favicon.ico' type='image/x-icon'>
        <link rel='icon' href='static/favicon.ico' type='image/x-icon'>    
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>
        <script src='functions.js'></script>
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
    </head>
    <body style='text-align:center; background-color: white'>
        <c:if test="${funcOn == null}">
            <jsp:forward page="login.jsp"> 
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema."/>
            </jsp:forward>
        </c:if>
        <c:set var="i" value="0"/>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='atendimentos-tab' class='tab' onclick="location.href = 'FuncionarioServlet?action=todos_atendimentos';">
                    Atendimentos
                </button>
                <button id='produtos-tab' class='tab selected'>
                    Cadastros
                </button>
            </div>
            <div id='session'>
                <button id='user-name' class='drop-button'  onclick="location.href = 'LogoutServlet';">
                    Sair
                </button>
            </div>
        </header> 
        <c:if test="${func == 'cadastrar'}">
            <div class='caixa cadastro'>
                <div class='conteudo'>
                    <h1>Cadastrar Categoria</h1>
                    <form method='post' action="FuncionarioServlet?action=cadastrando_categoria">          
                        <input type='text'  class='form-control campo0' id='nome' name='nome' placeholder='Nome categoria'> <br>            
                        <button type='submit' class='btn btn-primary margem'>Cadastrar</button>
                    </form>
                    <button class='btn btn-danger margem' onclick= "location.href='FuncionarioServlet?action=painel_cadastro'">Voltar</button>
                </div>
            </div>     
        </c:if>
        <c:if test="${func == 'alterar'}">
            <div class='caixa cadastro'>
                <div class='conteudo'>
                    <h1>Alterar Categoria</h1>
                    <form method='post' action="FuncionarioServlet?action=alterando_categoria&idc=${categoria.categoria_codigo}">          
                        <input type='text'  class='form-control campo0' id='nome' name='nome' value="${categoria.categoria_nome}" placeholder='Nome categoria'> <br>            
                        <button type='submit' class='btn btn-primary margem'>Alterar</button>
                    </form>
                        <button class='btn btn-danger margem' onclick= "location.href='FuncionarioServlet?action=painel_cadastro'">Voltar</button>
                </div>
            </div>     
        </c:if>
        <c:if test="${func == 'visualizar'}">
            <div class='caixa cadastro'>
                <div class='conteudo'>
                    <h1>Categoria</h1>
                    <form method='post' action="FuncionarioServlet?action=painel_cadastro">          
                        <input type='text'  class='form-control campo0' id='nome' name='nome' disabled  value="${categoria.categoria_nome}" placeholder='Nome categoria'> <br>            
                        <button type='submit' class='btn btn-primary margem'>Voltar</button>
                    </form>
                </div>
            </div>     
        </c:if>
    </body>
</html>
