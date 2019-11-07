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
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
    </head>
    <body>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>

            </div>
            <div id='session'>
                <button id='user-name' class='drop-button'  onclick="location.href = 'login.jsp';">
                    Sair
                </button>
            </div>
        </header> 
        <div class='caixa relatorio'>
            <div class='conteudo'>
                <h1>Atendimento</h1>
                <p>CPF - Cliente: ${atendimento.cpf_cliente}</p>
                <p>Data: ${atendimento.data_hora}</p>
                <p>Situação: ${atendimento.situacao}</p>
                <p>Descrição: ${atendimento.descricao}</p>
<!--            fazer um campo de texto para solução-->
                <a href="FuncionarioServlet?action=finalizar"><button type='submit' class='btn btn-primary margem'>Fechar atendimento</button></a>
                <a href="FuncionarioServlet?action=todos_atendimentos"> <button type='submit' class='btn btn-danger margem'>Voltar</button></a>
            </div>
        </div>  
        <footer>
            &#9400; Beibe
        </footer>  
    </body>
</html>