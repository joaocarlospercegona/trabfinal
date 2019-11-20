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
        <script src='functions.js'></script>
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
        <script>
            function redirecionar(opc){
                window.location.href = opc;
                

            }
function funcao1(msg)
{
    alert(msg);
}
        </script>
    </head>
    <body>
        <c:if test="${funcOn == null}">
            <jsp:forward page="login.jsp"> 
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema."/>
            </jsp:forward>
        </c:if>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='atendimentos-tab' class='tab' onclick="location.href = 'FuncionarioServlet?action=todos_atendimentos';">
                    Atendimentos
                </button>
                <button id='produtos-tab' class='tab selected'>
                    Cadastros
                </button>
            </div>
            <div id='session'>
                <button id='user-name' class='drop-button'  onclick="location.href = 'LogoutServlet';">
                    Sair
                </button>
            </div>
        </header> 
        <h4 style="color:red; text-align: center">${msgC}</h4>
        <div class='caixa cadastro'>
            <div class='conteudo'>
                <c:if test="${func == 'categoria'}" >
                    <h1>Categorias Cadastradas</h1>    
                    
                <select id="comboBreaker" name="comboBreaker" class='form-control campo2' onchange="redirecionar(value)">
                    <option value="FuncionarioServlet?action=painel_cadastro">Categorias</option>
                    <option value="FuncionarioServlet?action=ver_produtos">Produtos</option>
                </select>
                
                
                <table class='table table-hover'>
                    <thead class='black white-text'>
                        <tr>
                            <td scope='col'>#</td>
                            <td>Nome</td>
                            <td>Visualizar</td>
                            <td>Editar</td>
                            <td>Remover</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="k" value="0"></c:set>
                        <c:forEach items="${cat}" var="c">
                            <tr>
                                <td scope='row'>${k = k+1}</td>
                                <td>${c.categoria_nome}</td>
                                <td width="50"><a href="FuncionarioServlet?action=visualizar_categoria&id=${c.categoria_codigo}"><img src="ver.png" width=45 height=40></a></td>
                                <td width="50"><a href="FuncionarioServlet?action=alterar_categoria&id=${c.categoria_codigo}"><img src="edit.png" width=45 height=40></a></td>
                                <td width="50"><a onclick="confirmaDeleteCat(${c.categoria_codigo})"><img src="exclui.png" width=45 height=40></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="FuncionarioServlet?action=cadastrar_categoria"><button class='btn btn-primary margem'>Cadastrar Categoria</button></a>
            </c:if>
            
            <c:if test="${func == 'produto'}" >
                <h1>Produtos Cadastrados</h1>
               
                
                <select id="comboBreaker" name="comboBreaker" class='form-control campo2' onchange="redirecionar(value)">
                    <option value="FuncionarioServlet?action=ver_produtos">Produtos</option>
                    <option value="FuncionarioServlet?action=painel_cadastro">Categorias</option>
                </select>
                <table class='table table-hover'>
                    <thead class='black white-text'>
                        <tr>
                            <td scope='col'>#</td>
                            <td>Produto</td>
                            <td>Visualizar</td>
                            <td>Editar</td>
                            <td>Remover</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="i" value="0"></c:set>
                        <c:forEach items="${prod}" var="c">
                            <tr>
                                <td scope='row'>${i = i+1}</td>
                                <td>${c.produto_nome}</td>
                                <td width="50"><a href="FuncionarioServlet?action=visualizar_produto&id=${c.produto_codigo}"><img src="ver.png" width=45 height=40></a></td>
                                <td width="50"><a href="FuncionarioServlet?action=alterar_produto&id=${c.produto_codigo}"><img src="edit.png" width=45 height=40></a></td>
                                <td width="50"><a onclick="confirmaDeleteProd(${c.produto_codigo})"><img src="exclui.png" width=45 height=40></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="FuncionarioServlet?action=cadastrar_produto"><button class='btn btn-primary margem'>Cadastrar Produto</button></a>
            </c:if>    
            </div>
        </div>  
    </body>
    <footer>
        &#9400 Beibe
    </footer>
</html>