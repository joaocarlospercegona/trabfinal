<%-- 
    Document   : funcionario-cad-prod
    Created on : 28/10/2019, 19:47:44
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
        <script src='functions.js'></script>
        <link rel='stylesheet' href='css/styles.css'>
        <link rel='stylesheet' href='css/header.css'>
    </head>
    <body style='text-align:center; background-color: white'>
        <c:set var="i" value="0"/>
        <header>
            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>
            <div id='menu'>
                <button id='atendimentos-tab' class='tab' onclick="location.href = 'funcionario-atendimento.html';">
                    Atendimentos
                </button>
                <button id='produtos-tab' class='tab selected'>
                    Cadastros
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
                <c:if test="${func == 'cadastrar'}">
                    <h1>Cadastro de Produto</h1>
                    <form method='post' action="FuncionarioServlet?action=cadastrando_produto">          
                        <input type='text'  class='form-control campo0' id='nome' name='nome' placeholder='Nome produto'> <br>            
                        <input type="text"  class="form-control campo0" id="desc" name="descricao" placeholder="Descrição"> <br>
                        <input type="number" class="form-control campo1" id="peso" name="peso" placeholder="peso"> <br>
                        <select name="select" class='form-control campo1'>
                          <option disabled selected hidden>Categorias</option>
                          <c:forEach items="${categorias}" var="x">
                              <option value="${i= i+1}">${x.categoria_nome}</option>
                          </c:forEach>
                        </select>
                        <button type='submit' class='btn btn-primary margem'>Cadastrar</button>
                    </form>
                </c:if>
                
                <c:if test="${func == 'alterar'}">
                    <h1>Alterar Produto</h1>
                    <form method='post' action="FuncionarioServlet?action=alterando_produto&idp=${prod.produto_codigo}">          
                        <input type='text'  class='form-control campo0' id='nome'  value="${prod.produto_nome}" name='nome' placeholder='Nome produto'> <br>            
                        <input type="text"  class="form-control campo0" id="desc"  value="${prod.produto_descricao}" name="descricao" placeholder="Descrição"> <br>
                        <input type="number" class="form-control campo1" id="peso" value="${prod.produto_peso}" name="peso" placeholder="peso"> <br>
                        
<!--                        arrumar aqui-->
                        <select name="select" class='form-control campo1'>
                          <c:forEach items="${categorias}" var="x">
                              <c:if test="${nome == x.categoria_nome}">
                                  <option selected hidden value="${i= i+1}">${x.categoria_nome}</option>
                              </c:if>
                              <option value="${i= i+1}">${x.categoria_nome}</option>
                          </c:forEach>
                        </select>
                        <button type='submit' class='btn btn-primary margem'>Cadastrar</button>
                    </form>
                        
                </c:if>
                    
                <c:if test="${func == 'visualizar'}">
                                       
                    <h1>Visualiza Produto</h1>
                    <form method='post' action="FuncionarioServlet?action=painel_cadastro">          
                        <input type='text'  class='form-control campo0' id='nome'  disabled value="${prod.produto_nome}" name='nome' placeholder='Nome produto'> <br>            
                        <input type="text"  class="form-control campo0" id="desc"  disabled value="${prod.produto_descricao}" name="descricao" placeholder="Descrição"> <br>
                        <input type="number" class="form-control campo1" id="peso" disabled value="${prod.produto_peso}" name="peso" placeholder="peso"> <br>
                        <select disabled name="select" class='form-control campo1'>
                          <option disabled selected hidden>${nome}</option>  
                        </select>
                        <button type='submit' class='btn btn-primary margem'>voltar</button>
                    </form>
                        
                </c:if>
            </div>
        </div>     
    </body>
</html>
