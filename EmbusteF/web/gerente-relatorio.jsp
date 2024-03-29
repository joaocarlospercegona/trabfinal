<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head lang='pt-br'>
        <meta charset='UTF-8'>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética</title>
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
        <c:if test="${empty gerenteOn}">
            <jsp:forward page="login.jsp"> 
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema."/>
            </jsp:forward>
        </c:if>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='pessoas-tab' class='tab' onclick="location.href = 'GerenteServlet?action=listar';">
                    Funcionarios
                </button>
                <button id='atendimentos-tab' class='tab' onclick="location.href = 'GerenteServlet?action=atendimentos_abertos';">
                    Atendimentos
                </button>
                <button id='relatorios-tab' class='tab selected'>
                    Relatorios
                </button>
            </div>
            <div id='session'>
                <button id='user-name' class='drop-button' onclick="location.href = 'LogoutServlet';">
                    Sair
                </button>
            </div>
        </header> 
        <div class='caixa relatorio'>
            <div class='conteudo'>
                <h1>Relatórios</h1>
                <form method='post' action="GeradorRelatorios"> 
                    <select required id ='relatorio-box' name='relatorio-box' class='form-control campo0' onclick='showBox()'>
                        <option disabled selected hidden>Escolha um Relatório...</option>
                        <option value='func'>Funcionários</option>
                        <option value='prod'>Produtos mais reclamados</option>
                        <option value='ate'>Atendimentos em aberto por data</option>
                        <option value='rec'>Reclamações</option>
                    </select>
                    <select disabled required id='reclama-box' name='reclama-box' class='form-control campo0'>
                        <option>Todas</option>
                        <option>Em aberto</option>
                        <option>Finalizadas</option>
                    </select>
                    <div>
                        <label>Data de início:</label>
                        <input id='data-ini-box' disabled class='form-control campo0' name='data-ini-box' type='date'><br><br>
                    </div>
                    <div>
                        <label>Data final:</label>
                        <input id='data-fim-box' disabled class='form-control campo0' name='data-fim-box' type='date'><br><br>
                    </div>
                    <button type='submit' class='btn btn-primary margem'>
                        Gerar relatório
                    </button>
                </form>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>
</html>