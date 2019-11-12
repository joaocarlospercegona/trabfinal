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
                <button id='user-name' class='drop-button'  onclick="location.href = 'LogoutServlet';">
                    Sair
                </button>
            </div>
        </header>
        <div class='caixa cadastro'>
            <div class='conteudo'>
                <h1>Cadastrar Categoria</h1>

                <form method="get" action="FuncionarioServlet?action=cadastrando_categoria">
                    <div class='form-group green-border-focus'>
                        <textarea class='form-control campo0'rows='1' placeholder='Nome Categoria' required></textarea>
                    </div>   
                    <div class='form-group green-border-focus'>
                        <textarea class='form-control campo0'rows='10' placeholder='DescriÃ§Ã£o' required></textarea>
                    </div>             
                    <button type='submit' class='btn btn-primary'>Salvar</button>  
                </form>
                <a href="funcionario-cadastro.jsp"><button type='submit' class='btn btn-danger'>Cancelar</button></a>
            </div>
        </div>
    </div>  
</body>
<footer>
    &#9400 Beibe
</footer>  
</html>