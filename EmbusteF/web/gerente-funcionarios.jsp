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
         <script>
            function redirecionar(opc){
                window.location.href = opc;
                

            }
        </script>
    </head>
    <body>
        <c:if test="${empty gerenteOn}">
            <jsp:forward page="login.jsp"> 
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema."/>
            </jsp:forward>
        </c:if>
        <c:set var="i" value="0"/>  
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='pessoas-tab' class='tab selected'>
                    Funcionarios
                </button>
                <button id='atendimentos-tab' class='tab' onclick="location.href = 'GerenteServlet?action=atendimentos_abertos';">
                    Atendimentos
                </button>
                <button id='relatorios-tab' class='tab'  onclick="location.href = 'gerente-relatorio.jsp';">
                    Relatorios
                </button>
            </div>
            <div id='session'>
                <button id='user-name' class='drop-button'  onclick="location.href = 'LogoutServlet';">
                    Sair
                </button>
            </div>
        </header> 
        <div class='caixa tabela'>
            <div class='conteudo'>
                <c:if test="${func == 'funcionario'}" >
                    <h1>Funcionarios</h1>
                    <select id="comboBreaker" name="comboBreaker" class='form-control campo2' onchange="redirecionar(value)">
                        <option value="GerenteServlet?action=listar">Funcionarios</option>
                        <option value="GerenteServlet?action=listar_gerente">Gerente</option>
                    </select>               
                    <table class='table table-hover'>
                        <thead class='black white-text'>
                            <tr>
                                <td scope='col'>#</td>
                                <td>Nome</td>
                                <td>CPF</td>
                                <td>E-mail</td>
                                <td>Consultar</td>
                                <td>Editar</td>
                                <td>Remover</td>
                            </tr>
                        </thead>                    
                        <tbody>
                            <c:forEach items="${funcionarios}" var="x">
                                <tr>
                                    <td scope='row'>${i = i+1}</td>
                                    <td>${x.funcionario_nome}</td>
                                    <td>${x.funcionario_cpf}</td>
                                    <td>${x.funcionario_email}</td>
                                    <td width="50"><a href="GerenteServlet?action=visualizar&type=1&cpf=${x.funcionario_cpf}"><img src="ver.png" width=45 height=40></a></td>
                                    <td width="50"><a href="GerenteServlet?action=alterar&type=1&cpf=${x.funcionario_cpf}"><img src="edit.png" width=45 height=40></a></td>
                                    <td width="50"><a onclick="confirmaDeleteFunc(${x.funcionario_cpf})"><img src="exclui.png" width=45 height=40></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <form method="post" action="GerenteServlet?action=novo">
                        <button type='submit' class='btn btn-success margem' >Cadastrar</button>
                    </form>
                </c:if>
                <c:if test="${func == 'gerente'}" >
                    <h1>Gerentes</h1>
                    <select id="comboBreaker" name="comboBreaker" class='form-control campo2' onchange="redirecionar(value)">
                        <option value="GerenteServlet?action=listar_gerente">Gerente</option>
                        <option value="GerenteServlet?action=listar">Funcionarios</option>
                    </select>                
                    <table class='table table-hover'>
                        <thead class='black white-text'>
                            <tr>
                                <td scope='col'>#</td>
                                <td>Nome</td>
                                <td>CPF</td>
                                <td>E-mail</td>                            
                                <td>Consultar</td>
                                <td>Editar</td>
                                <td>Remover</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${gerentes}" var="x">
                                <tr>
                                    <td scope='row'>${i = i+1}</td>
                                    <td>${x.gerente_nome}</td>
                                    <td>${x.gerente_cpf}</td>
                                    <td>${x.gerente_email}</td>
                                    <td width="50"><a href="GerenteServlet?action=visualizar&type=2&cpf=${x.gerente_cpf}"><img src="ver.png" width=45 height=40></a></td>
                                    <td width="50"><a href="GerenteServlet?action=alterar&type=2&cpf=${x.gerente_cpf}"><img src="edit.png" width=45 height=40></a></td>
                                    <td width="50"><a onclick="confirmaDeleteGrt(${x.gerente_cpf})"><img src="exclui.png" width=45 height=40></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <form method="post" action="GerenteServlet?action=novo">
                        <button type='submit' class='btn btn-success margem' >Cadastrar</button>
                    </form>
                </c:if>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>
</html>