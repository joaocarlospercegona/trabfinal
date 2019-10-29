<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <body>
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
                <h1>Cadastrar Funcionario/Gerente</h1>

                <form method="post" action="GerenteServlet?action=cadastrando">
                    <input type='text'  class='form-control campo0' id='usuario' name='nome' placeholder='Nome Completo'>             
                    <input type='tel'  class='form-control campo0' id='telefone' name='telefone' placeholder='Telefone'><br>  
                    <input type='text'  class='form-control campo1' id='cpf' name="cpf" placeholder='CPF'><br>  
                    <input type='email'  class='form-control campo1' id='email' name='email' placeholder='Email'><br> 
                    <input type='text'  class='form-control campo1' id='cep' name='cep' placeholder='CEP'><br>
                    <input type='text'  class='form-control campo1' id='estado' name='estado' placeholder='Estado'><br>       
                    <input type='text'  class='form-control campo1' id='cidade' name='cidade' placeholder='Cidade'><br> 
                    <input type='text'  class='form-control campo1' id='bairro' name='bairro' placeholder='Bairro'><br>
                    <input type='text'  class='form-control campo1' id='rua' name='rua' placeholder='Rua'><br>
                    <input type='text'  class='form-control campo2' id='numero' name='numero' placeholder='Número'><br>
                    <input type='text'  class='form-control campo2' id='complemento' name='complemento' placeholder='Complemento'><br> 
                    <input type='password'  class='form-control campo1' id='senha' name='senha' placeholder='Sua senha'><br>
                    <input type='password'  class='form-control campo1' id='senha' name='senha2' placeholder='Confirmação da senha'><br> 
                    <select name="tipo" id="tipo" required class='form-control campo1'>
                        <option disabled selected hidden>Cargo</option>
                        <option  value="1">Gerente</option>
                        <option  value="2">Funcionario</option>
                    </select>
                    <button type='submit' class='btn btn-primary margem'>Salvar</button>
                    <a href="GerenteServlet?action=listar"><button class='btn btn-danger margem'>Cancelar</button></a>
                </form>

            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>  
</html>