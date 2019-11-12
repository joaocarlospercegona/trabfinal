<%-- 
    Document   : funcionario-cad-categ
    Created on : 28/10/2019, 19:47:58
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head lang='pt-br'>
        <meta charset='UTF-8'>
        <title>BEIBE - Beauty Embuste IndÃºstria de Beleza e EstÃ©tica</title>
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
                    <h1>Cadastro de Categoria</h1>
                    <form method='post' action="FuncionarioServlet?action=cadastrando_categoria">          
                        <input type='text'  class='form-control campo0' id='nome' name='nome' placeholder='Nome categoria'> <br>            
                        <button type='submit' class='btn btn-primary margem'>Cadastrar</button>
                    </form>
                </div>
            </div>     
        </c:if>
        <c:if test="${func == 'alterar'}">
            <div class='caixa cadastro'>
                <div class='conteudo'>
                    <h1>Cadastro de Categoria</h1>
                    <form method='post' action="FuncionarioServlet?action=alterando_categoria&idc=${categoria_codigo}">          
                        <input type='text'  class='form-control campo0' id='nome' name='nome' value="${categoria_nome}" placeholder='Nome categoria'> <br>            
                        <button type='submit' class='btn btn-primary margem'>Alterar</button>
                    </form>
                </div>
            </div>     
        </c:if>
        <c:if test="${func == 'visualizar'}">
            <div class='caixa cadastro'>
                <div class='conteudo'>
                    <h1>Cadastro de Categoria</h1>
                    <form method='post' action="FuncionarioServlet?action=painel_cadastro">          
                        <input type='text'  class='form-control campo0' id='nome' name='nome' disabled  value="${categoria_nome}" placeholder='Nome categoria'> <br>            
                        <button type='submit' class='btn btn-primary margem'>Voltar</button>
                    </form>
                </div>
            </div>     
        </c:if>
    </body>
</html>
