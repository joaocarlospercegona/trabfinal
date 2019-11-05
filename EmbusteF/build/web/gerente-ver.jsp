<%-- 
    Document   : gerente-ver
    Created on : 27/10/2019, 21:57:27
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>  <!-- mascara -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
        <script type="text/javascript">
            $("#telefone").mask("(00) 00000-0000");
            $("#cep").mask("00000-000");
            $("#cpf").mask("000.000.000-00");
        </script>
    </head>
       <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>

                <div id='session'>
                    <button id='user-name' class='drop-button'  onclick="location.href = 'login.html';">
                        Sair
                    </button>
                </div>
        </header>
        <div class='caixa cadastro'>
            <div class='conteudo'>
                <h1>Meus dados</h1>
                <form method='post' action='GerenteServlet?action=listar'>          
                    <input type='text'  class='form-control campo0' id='usuario' name='nome' placeholder='Nome Completo' value="${c.pessoa_nome}"disabled>
                    <input type='tel'  class='form-control campo0' id='telefone' name='telefone' placeholder='Telefone' value="${c.pessoa_telefone}"disabled><br>
                    <input type='text'  class='form-control campo1' id='cpf' name='cpf' placeholder='CPF' value="${c.pessoa_cpf}" disabled ><br>  
                    <input type='email'  class='form-control campo1' id='email' name='email' placeholder='Email' value="${c.pessoa_email}"disabled ><br> 
                    <input type='text'  class='form-control campo1' id='cep' name='cep' placeholder='CEP' value="${c.pessoa_cep}"disabled><br>
                    <input type='text'  class='form-control campo1' id='estado' name='estado' placeholder='Estado' value="${c.pessoa_estado}"disabled><br>    
                    <input type='text'  class='form-control campo1' id='cidade' name='cidade' placeholder='Cidade' value="${c.pessoa_cidade}"disabled><br> 
                    <input type='text'  class='form-control campo1' id='bairro' name='bairro' placeholder='Bairro' value="${c.pessoa_bairro}"disabled><br>
                    <input type='text'  class='form-control campo1' id='rua' name='rua' placeholder='Rua' value="${c.pessoa_rua}"disabled><br>
                    <input type='number'  class='form-control campo2' id='numero' name='numero' placeholder='NÃºmero' value="${c.pessoa_numero}"disabled><br>
                    <input type='text'  class='form-control campo2' id='complemento' name='complemento' placeholder='Complemento' value="${c.pessoa_complemento}"disabled><br> 
                    <input type='password'  class='form-control campo1' id='senha' name='senha' placeholder='Sua senha' value="${c.pessoa_senha}"disabled><br>
                    <input type='password'  class='form-control campo1' id='senha2' name='senha2' placeholder='ConfirmaÃ§Ã£o da senha' value="${c.pessoa_senha}"disabled><br> 
                    <div>
                        <select disabled name="tipo" id="tipo" required class='form-control campo1'>
                            <c:if test="${func == '1'}" >
                                <option  disabled selected hidden value="1">Funcionario</option>
                            </c:if>
                            <c:if test="${func == '2'}">
                                <option  disabled selected hidden value="2">Gerente</option>
                            </c:if>
                        </select>
                    <br>
                    </div>
                    <button type='submit' class='btn btn-primary margem'>Voltar</button>
                </form>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>  
</html>
