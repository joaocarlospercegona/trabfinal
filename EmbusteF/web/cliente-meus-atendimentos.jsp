<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang='pt-br'>
        <meta charset='UTF-8'>
        <title>BEIBE - Beauty Embuste Industria de Beleza e Estática</title>
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
                <button id='novo-tab' class='tab' onclick="location.href = 'cliente-novo-atendimento.jsp';">
                    Novo atendimento
                </button>        
                <button id='historico-tab' class='tab selected'>
                    Meus atendimentos
                </button>
                <button id='alterar-tab' class='tab' onclick="location.href = 'ClienteServlet?action=alterar_dados';">
                    Alterar meus dados
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
                <h1>HistÃ³rico</h1>
                <table class='table table-hover'>
                    <thead class='black white-text'>
                        <tr>
                            <td scope='col'>#</td>
                            <td>Data</td>
                            <td>Produto</td>
                            <td>SituaÃ§Ã£o</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td scope='row'>1</td>
                            <td>30/09/2019 - 14:04</td>
                            <td>Batom</td>
                            <td style="color: darkorange">NÃ£o resolvido</td>
                        </tr>
                        <tr>
                            <td scope='row'>2</td>
                            <td>26/09/2019 - 12:54</td>
                            <td>Base</td>
                            <td style="color: darkorange">NÃ£o resolvido</td>
                        </tr>
                        <tr>
                            <td scope='row'>3</td>
                            <td>23/09/2019 - 08:27</td>
                            <td>LÃ¡pis de Olho</td>
                            <td style="color: red"> NÃ£o Resolvido</td>
                        </tr>
                        <tr>
                            <td scope='row'>4</td>
                            <td>22/09/2019 - 07:47</td>
                            <td>Sombra</td>
                            <td style="color:green">Resolvido</td>
                        </tr>
                    </tbody>
                </table>
                <button type='submit' class='btn btn-primary margem'>Visualizar/Alterar</button>
                <button type='submit' class='btn btn-danger margem'>Remover</button>
            </div>  
        </div>
    </body>
    <footer>
        &#9400 Beibe
    </footer>  
</html>
