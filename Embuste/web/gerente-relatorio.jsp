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
        <script src='functions.js'></script>
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
    </head>
    <body>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='pessoas-tab' class='tab' onclick="location.href = 'gerente-funcionarios.html';">
                    FuncionÃ¡rios
                </button>
                <button id='atendimentos-tab' class='tab' onclick="location.href = 'gerente-atendimento.html';">
                    Atendimentos
                </button>
                <button id='relatorios-tab' class='tab selected'>
                    RelatÃ³rios
                </button>
            </div>
            <div id='session'>
                <button id='user-name' class='drop-button'>
                    Sair
                </button>
            </div>
        </header> 
        <div class='caixa relatorio'>
            <div class='conteudo'>
                <h1>RelatÃ³rios</h1>
                <select required id ='relatorio-box' class='form-control campo0'  onclick='showBox()'>
                    <option disabled selected hidden>RelatÃ³rios</option>
                    <option>FuncionÃ¡rios</option>
                    <option>Produtos mais reclamados</option>
                    <option>Atendimentos em aberto por data</option>
                    <option>ReclamaÃ§Ãµes</option>
                </select>
                <select disabled required id='reclama-box' class='form-control campo0'>
                    <option>Todos</option>
                    <option>Em aberto</option>
                    <option>Finalizados</option>
                </select>
                <div>
                    <label>Data de inÃ­cio:</label>
                    <input id='data-ini-box' disabled class='form-control campo0' type='date'><br><br>
                </div>
                <div>
                    <label>Data final:</label>
                    <input id='data-fim-box' disabled class='form-control campo0' type='date'><br><br>
                </div>
                <button type='submit' class='btn btn-primary margem'>Gerar relatÃ³rio</button>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>
</html>