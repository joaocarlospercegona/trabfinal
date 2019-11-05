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
                <button id='pessoas-tab' class='tab' onclick="location.href = 'GerenteServlet?action=listar';">
                    Funcionarios
                </button>
                <button id='atendimentos-tab' class='tab selected'onclick="location.href = 'GerenteServlet?action=todos_atendimentos';">
                    Atendimentos
                </button>
                <button id='relatorios-tab' class='tab' onclick="location.href = 'gerente-relatorio.jsp';">
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
                <h1>Histórico</h1>
                <c:if test="${func == 'todos'}">
                    <select id="comboBreaker" name="comboBreaker" class='form-control campo2' onchange="redirecionar(value)">
                        <option value="GerenteServlet?action=todos_atendimentos">Todos os atendimentos</option>
                        <option value="GerenteServlet?action=atendimentos_abertos">Atendimentos em aberto</option>
                    </select>

                    <table class='table table-hover'>
                        <thead class='black white-text'>
                            <tr>
                                <td scope='col'>#</td>
                                <td>Data</td>
                                <td>Produto</td>
                                <td>Situação</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="i" value="0"/>
                            <c:forEach items="${atendimentos}" var="x">
                                <tr bgcolor="RED">
                                    <td scope='row'>${i = i+1}</td>
                                    <td>${x.atendimento_data_hora}</td>
                                    <td>${x.atendimento_cod_produto}</td>
                                    <td>${x.atendimento_situacao}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <form method="get" action="resolucao-atendimento.jsp">
                    <button type='submit' class='btn btn-primary margem'>Verificar atendimento</button>
                </form>
            </c:if>
            
            <c:if test="${func == 'aberto'}">
                    <select id="comboBreaker" name="comboBreaker" class='form-control campo2' onchange="redirecionar(value)">
                        <option value="GerenteServlet?action=atendimentos_abertos">Atendimentos em aberto</option>
                        <option value="GerenteServlet?action=todos_atendimentos">Todos os atendimentos</option>
                    </select>
            <c:set var="i" value="0"/>  
                    <table  class="table">
                        <thead class="thead-dark">
                            <tr>
                                <td scope='col'>#</td>
                                <td>Data</td>
                                <td>Produto</td>
                                <td>Situação</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${atendimentos}" var="x"> 
                                <tr bgcolor="RED    ">

                                    <td scope='row'>${i = i+1}</td>
                                    <td>${x.atendimento_data_hora}</td>
                                    <td>${x.atendimento_cod_produto}</td>
                                    <td>${x.atendimento_situacao}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                <form method="get" action="resolucao-atendimento.jsp">
                    <button type='submit' class='btn btn-primary margem'>Verificar atendimento</button>
                </form>
            </c:if>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>
</html>