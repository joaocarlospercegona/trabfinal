<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang='pt-br'>
        <meta charset='UTF-8'>
        <title>BEIBE - Beauty Embuste Industria de Beleza e Estática</title>
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
        <c:if test="${logado == null}">
            <jsp:forward page="index.jsp"> 
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema."/>
            </jsp:forward>
        </c:if>  

        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>        
                <button id='novo-tab' class='tab' onclick="location.href = 'ClienteServlet?action=novo_atendimento';">
                    Novo atendimento
                </button>        
                <button id='historico-tab' class='tab selected'>
                    Meus atendimentos
                </button>
                <button id='alterar-tab' class='tab' onclick="location.href = 'ClienteServlet?action=alterar_dados';">
                    Alterar meus dados
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
                <h1>Histórico</h1>
                <table class='table table-hover'>
                    <thead class='black white-text'>
                        <tr>
                            <td scope='col'>#</td>
                            <td>Data</td>
                            <td>Produto</td>
                            <td>Situação</td>
                            <td>Observar</td>
                            <td>Remover</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="i" value="0"/>
                            <c:forEach items="${atendimentos}" var="x">
                                <tr>
                                    <td scope='row'>${i = i+1}</td>
                                    <td>${x.atendimento_data_hora}</td>
                                    <c:forEach items="${produtos}" var="a">
                                        <c:if test="${x.atendimento_cod_produto == a.produto_codigo}">
                                            <td>${a.produto_nome}</td>    
                                        </c:if>
                                    </c:forEach>
                                    <td>${x.atendimento_situacao}</td>
                                    <td><a href="ClienteServlet?action=ver_atendimento&cod=${x.atendimento_codigo}"><img src="ver.png" width=45 height=40></a></td>
                                    <c:if test="${x.atendimento_nivel == 1}">
                                        <td><img src="exclui.png" width=45 height=40></a></td>
                                    </c:if>
                                    <c:if test="${x.atendimento_nivel == 0}">
                                        <td><a href="ClienteServlet?action=remover_atendimento&cod=${x.atendimento_codigo}"><img src="exclui.png" width=45 height=40 ></a></td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                    </tbody>
                </table>
            </div>  
        </div>
    </body>
    <footer>
        &#9400 Beibe
    </footer>  
</html>
