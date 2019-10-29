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
                <button id='novo-tab' class='tab selected'>
                    Novo atendimento
                </button>
                <button id='historico-tab' class='tab' onclick="location.href = 'cliente-meus-atendimentos.html';">
                    Meus atendimentos
                </button>
                <button id='alterar-tab' class='tab' onclick="location.href = 'ClienteServlet?action=alterar_dados';">
                    Alterar meus dados
                </button>
            </div>
            <div id='session'>
                <button id='user-name' class='drop-button'  onclick="location.href = 'login.html';">
                    Sair
                </button>
            </div>
        </header>
        <div class='caixa cadastro'>
            <div class='conteudo'>
                <h1>InformaÃ§Ãµes sobre o atendimento</h1>
                <form method='post' action='Servlet'>
                    <select required class='form-control campo1'>
                        <option disabled selected hidden>Categoria</option>
                        <option>Maquiagem</option>
                        <option>Perfume</option>
                        <option>Batom</option>
                        <option>Cremes</option>
                    </select>
                    <select required class='form-control campo1'>
                        <option disabled selected hidden>Produto</option>
                        <option>Beibe mozao</option>
                        <option>Beibe eu sou a diva</option>
                        <option>Beibe arrasou miga</option>
                        <option>Beibe sua loka</option>
                    </select>
                    <select required class='form-control campo0'>
                        <option disabled selected hidden>Tipo de atendimento</option>
                        <option>ReclamaÃ§Ã£o</option>
                        <option>Efeito colateral</option>
                        <option>DevoluÃ§Ã£o</option>
                        <option>Troca</option>
                    </select>
                    <div class='form-group green-border-focus'>
                        <textarea class='form-control campo0'rows='10' placeholder='DescriÃ§Ã£o'></textarea>
                    </div>      
                    <button type='submit' class='btn btn-primary margem'>Solicitar atendimento</button>
                </form>
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>  
</html>