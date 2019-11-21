<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BEIBE - Beauty Embuste Industria de Beleza e Estetica</title>
        <meta charset='UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <link rel='shortcut icon' href='static/favicon.ico' type='image/x-icon'>
        <link rel='icon' href='static/favicon.ico' type='image/x-icon'>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>
        <link rel='stylesheet' href='css/styles.css'>
    </head>
    <body style='text-align:center; background-color: #21B180;' >
        <img class='imagem-inicial' src='static/logo_transparent.jpg' alt='aqui'/>
        <div class='caixa relatorio'>
            <div class='conteudo'>
                <form method='post' action='LoginServlet'>          
                    <label class='margem'>Usuario:</label>
                    <input type='text'  class='form-control margem' id='usuario' name='usuario'>
                    <label for='pwd' class='margem'>Senha:</label>
                    <input type='password' class='form-control margem' id='pwd'  name='senha'><br>
                    <input type="radio" name="tipo" value="1"> Cliente<br>
                    <input type="radio" name="tipo" value="2"> Funcionario<br>
                    <input type="radio" name="tipo" value="3"> Gerente<br>
                    <button type='submit' class='btn btn-primary margem'>Logar</button>
                </form>
                <a href="cadastro.jsp">Ainda não possui conta?</a>
            </div>
        </div>     
    </body>
</html>