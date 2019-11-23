<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>  <!-- mascara -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
        <script src='functions.js'></script>
        <script type="text/javascript">
            $("#telefone").mask("(00) 00000-0000");
            $("#cep").mask("00000-000");
            $("#cpf").mask("000.000.000-00");
        </script>
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

                <div id='session'>
                    <button id='user-name' class='drop-button'  onclick="location.href = 'LogoutServlet';">
                        Sair
                    </button>
                </div>
        </header>
        <div class='caixa cadastro'>
            <div class='conteudo'>
                <h1>Cadastrar Funcionario/Gerente</h1>

                <form method="post" action="GerenteServlet?action=cadastrando">
                    <input type='text'  class='form-control campo0' id='usuario' name='nome' placeholder='Nome Completo'>             
                    <input type='tel'  class='form-control campo0' id='telefone' name='telefone' placeholder='Telefone'><br>  
                    <input type='text'  class='form-control campo1' id='cpf' name="cpf" placeholder='CPF'><br>  
                    <input type='email'  class='form-control campo1' id='email' name='email' placeholder='Email'><br> 
                    <select id="estado" name="estado" required class="form-control campo1" onchange="getCidades()">
                        <c:forEach var="e" items="${estados}">
                            <option disabled selected hidden>Estado</option>
                            <option name="est" value="${e.idEstado}">
                                ${e.nomeEstado}
                            </option>
                        </c:forEach>
                    </select>   
                    <select id="cidade" name="cidade" required class="form-control campo1" disabled>
                        <option disabled selected hidden>Cidade</option>
                    </select> 
                    <input type='text'  class='form-control campo1' id='cep' name='cep' placeholder='CEP'><br>
                    <input type='text'  class='form-control campo1' id='bairro' name='bairro' placeholder='Bairro'><br>
                    <input type='text'  class='form-control campo1' id='rua' name='rua' placeholder='Rua'><br>
                    <input type='text'  class='form-control campo2' id='numero' name='numero' placeholder='Número'><br>
                    <input type='text'  class='form-control campo2' id='complemento' name='complemento' placeholder='Complemento'><br> 
                    <input type='password'  class='form-control campo1' id='senha' name='senha' placeholder='Sua senha'><br>
                    <input type='password'  class='form-control campo1' id='senha' name='senha2' placeholder='Confirmação da senha'><br> 
                    <select name="tipo" id="tipo" required class='form-control campo0'>
                        <option disabled selected hidden>Cargo</option>
                        <option  value="1">Gerente</option>
                        <option  value="2">Funcionario</option>
                    </select>
                    <button type='submit' class='btn btn-primary margem'>Salvar</button>
                </form>
                <button class='btn btn-danger margem' onclick= "location.href='GerenteServlet?action=listar'">Voltar</button>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>  
</html>