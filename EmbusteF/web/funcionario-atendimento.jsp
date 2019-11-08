<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
           <script>
            function redirecionar(opc){
                    window.location.href = opc;
            }
        </script>
    </head>
    <body>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='atendimentos-tab' class='tab selected'>
                    Atendimentos
                </button>
                <button id='produtos-tab' class='tab' onclick="location.href = 'FuncionarioServlet?action=painel_cadastro';">
                    Cadastros
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
                <c:if test="${func == 'todos'}">
                    <select id="comboBreaker" name="comboBreaker" class='form-control campo2' onchange="redirecionar(value)">
                        <option value="FuncionarioServlet?action=todos_atendimentos">Todos os atendimentos</option>
                        <option value="FuncionarioServlet?action=atendimentos_abertos">Atendimentos em aberto</option>
                    </select>
                    <table class='table table-hover'>
                        <thead class='black white-text'>
                            <tr>
                                <td width="30" scope='col'>#</td>
                                <td width="200">Data</td>
                                <td width="200">Produto</td>
                                <td width="200">Situação</td>
                                <td width="100">Analisar Atendimento</td>
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
                                    <c:if test="${x.atendimento_nivel == 2}">
                                        <td style="color:green">${x.atendimento_situacao}</td>
                                    </c:if>
                                    <c:if test="${x.atendimento_nivel == 1}">
                                        <td style="color:red">${x.atendimento_situacao}</td>
                                    </c:if>
                                    <c:if test="${x.atendimento_nivel == 0}">
                                        <td style="color:yellow">${x.atendimento_situacao}</td>
                                    </c:if>
                                    <td><a href="FuncionarioServlet?action=resolucao&cod=${x.atendimento_codigo}"><img src="ver.png" width=45 height=40></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </c:if>
            
            <c:if test="${func == 'aberto'}">
                    <select id="comboBreaker" name="comboBreaker" class='form-control campo2' onchange="redirecionar(value)">
                        <option value="FuncionarioServlet?action=atendimentos_abertos">Atendimentos em aberto</option>
                        <option value="FuncionarioServlet?action=todos_atendimentos">Todos os atendimentos</option>
                    </select>
            <c:set var="i" value="0"/>  
                    <table  class="table">
                        <thead class="thead-dark">
                            <tr>
                                <td width="30" scope='col'>#</td>
                                <td width="200">Data</td>
                                <td width="200">Produto</td>
                                <td width="200">Situação</td>
                                <td width="100">Analisar Atendimento</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${atendimentos}" var="x"> 
                                    <tr>
                                        <td scope='row'>${i = i+1}</td>
                                        <td>${x.atendimento_data_hora}</td>
                                        
                                        <c:forEach items="${produtos}" var="a">
                                            <c:if test="${x.atendimento_cod_produto == a.produto_codigo}">
                                                <td>${a.produto_nome}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${x.atendimento_nivel == 2}">
                                            <td style="color:green">${x.atendimento_situacao}</td>
                                        </c:if>
                                        <c:if test="${x.atendimento_nivel == 1}">
                                            <td style="color:red">${x.atendimento_situacao}</td>
                                        </c:if>
                                        <c:if test="${x.atendimento_nivel == 0}">
                                            <td>${x.atendimento_situacao}</td>
                                        </c:if>
                                        <td><a href="FuncionarioServlet?action=resolucao&cod=${x.atendimento_codigo}"><img src="ver.png" width=45 height=40></a></td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </c:if>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>
</html>