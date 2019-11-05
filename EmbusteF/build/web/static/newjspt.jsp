<%-- 
    Document   : newjspt
    Created on : 25/10/2019, 15:30:37
    Author     : joao
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang='pt-br'>
        <meta charset='UTF-8'>
        <title>BEIBE - Beauty Embuste Industria de Beleza e Estatica</title>
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
    <body>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='pessoas-tab' class='tab selected'>
                    Funcionarios
                </button>
                <button id='atendimentos-tab' class='tab' onclick="location.href = '#';">
                    Atendimentos
                </button>
                <button id='relatorios-tab' class='tab'  onclick="location.href = '#';">
                    Relatorios
                </button>
            </div>
            <div id='session'>
                <button id='user-name' class='drop-button'  onclick="location.href = 'login.jsp';">
                    Sair
                </button>
            </div>
        </header> 
        <div class='caixa tabela'>
            <div class='conteudo'>
                <h1>Funcionarios</h1>
                
<!--            VER COMO MUDAR DE TELA AQUI-->
                <select class='form-control campo2'>
                    <option>Funcionarios</option>
                    <option>Gerente</option>
                </select>
                
                
                <table class='table table-hover'>
                    <thead class='black white-text'>
                        <tr>
                            <td scope='col'>#</td>
                            <td>Nome</td>
                            <td>CPF</td>
                            <td>E-mail</td>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <c:forEach items="funcionarios" var="c">
                            <tr>
                                <td scope='row'>1</td>
                                <td>${c.funcionario_nome}</td>
                                <td>${c.funcionario_cpf}</td>
                                <td>${c.funcionario_email}</td>
                                <a href="GerenteServlet?action=visualizar&cpf=${c.funcionario_cpf}"><button type='submit' class='btn btn-primary margem'>Visualizar</button></a>
                                <a href="GerenteServlet?action=alterar&cpf=${c.funcionario_cpf}"><button type='submit' class='btn btn-danger margem'>Alterar</button></a>
                                <a href="GerenteServlet?action=remover&cpf=${c.funcionario_cpf}"><button type='submit' class='btn btn-danger margem'>Remover</button></a>
                            </tr>
                        <c:forEach/>
                    </tbody>
                </table>
                <form method="get" action="GerenteServlet?action=novo">
                    <button type='submit' class='btn btn-success margem' >Cadastrar</button>
                </form>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>
</html>