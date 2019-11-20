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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
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
            </div>
        </header>
        <div class='caixa cadastro'>
            <div class='conteudo'>
                <h1>Meus dados</h1>
                <form method='post' action='GerenteServlet?action=alterando&func=${func}&emailu=${c.pessoa_email}&cpfu=${c.pessoa_cpf}'>          
                    <input type='text'  class='form-control campo0' id='usuario' name='nome' placeholder='Nome Completo' value="${c.pessoa_nome}">
                    <input type='tel'  class='form-control campo0' id='telefone' name='telefone' placeholder='Telefone' value="${c.pessoa_telefone}"><br>
                    <input type='text'  class='form-control campo1' id='cpf' name='cpf' placeholder='CPF' value="${c.pessoa_cpf}" disabled ><br>  
                    <input type='email'  class='form-control campo1' id='email' name='email' placeholder='Email' value="${c.pessoa_email}"disabled ><br> 
                    <input type='text'  class='form-control campo1' id='cep' name='cep' placeholder='CEP' value="${c.pessoa_cep}"><br>
                    <input type='text'  class='form-control campo1' id='estado' name='estado' placeholder='Estado' value="${c.pessoa_estado}"><br>    
                    <input type='text'  class='form-control campo1' id='cidade' name='cidade' placeholder='Cidade' value="${c.pessoa_cidade}"><br> 
                    <input type='text'  class='form-control campo1' id='bairro' name='bairro' placeholder='Bairro' value="${c.pessoa_bairro}"><br>
                    <input type='text'  class='form-control campo1' id='rua' name='rua' placeholder='Rua' value="${c.pessoa_rua}"><br>
                    <input type='number'  class='form-control campo2' id='numero' name='numero' placeholder='Numero' value="${c.pessoa_numero}"><br>
                    <input type='text'  class='form-control campo2' id='complemento' name='complemento' placeholder='Complemento' value="${c.pessoa_complemento}"><br> 
                    <input type='password'  class='form-control campo1' id='senha' name='senha' placeholder='Sua senha' value="${c.pessoa_senha}"><br>
                    <input type='password'  class='form-control campo1' id='senha2' name='senha2' placeholder='Confirme sua senha' value="${c.pessoa_senha}"><br> 
                    <div>
                        <select name="tipo" id="tipo" required class='form-control campo0'>
                            <c:if test="${func == '1'}" >
                                <option  value="2">Gerente</option>
                                <option   selected hidden value="1">Funcionario</option>
                                <option    value="1">Funcionario</option>
                            </c:if>
                            <c:if test="${func == '2'}">
                                <option  selected hidden value="2">Gerente</option>
                                <option  value="1">Funcionario</option>
                                <option  value="2">Gerente</option>
                            </c:if>
                        </select>
                    <br>
                    </div>
                    <button type='submit' class='btn btn-primary margem'>Alterar dados</button>
                </form>
                <button class='btn btn-danger margem' onclick= "location.href='GerenteServlet?action=listar'">Voltar</button>
                <p>Obs: CPF e email não podem ser alterados</p>
            </div>
        </div>
    </body>
    <footer>
        &#9400 Beibe
    </footer>  
</html>
