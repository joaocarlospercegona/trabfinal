<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética</title>
        <meta charset='UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <link rel='shortcut icon' href='static/favicon.ico' type='image/x-icon'>
        <link rel='icon' href='static/favicon.ico' type='image/x-icon'>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>
        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>  <!-- mascara -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        <link rel='stylesheet' href='css/styles.css'>
        <script type="text/javascript">
            $("#telefone").mask("(00) 00000-0000");
            $("#cep").mask("00000-000");
            $("#cpf").mask("000.000.000-00");
        </script>
<!--        <script type="text/javascript" > //USAR ESSE

                        function getCidades(){
                        var idestado = $("#estado").val();
                        var url = "AJAXServlet";
                        //console.log("entrou1");
                        $.ajax({
                        url : url, // URL da sua Servlet
                                data : {
                                idestado : idestado
                                }, // Parâmetro passado para a Servlet
                                dataType : 'json',
                                success : function(data) {
                                console.log("executou");
                                // Se sucesso, limpa e preenche a combo de cidade
                                // alert(JSON.stringify(data));
                                $("#cidade").empty();
                                $.each(data, function(i, obj) {
                                $("#cidade").append('<option value=' + obj.idcidadeteste + '>' + obj.nomecidadeteste + '</option>');
                                });
                                },
                                error : function(request, textStatus, errorThrown) {
                                console.log("deu erro");
                                alert(request.status + ', Error: ' + request.statusText);
                                // Erro
                                }
                        });
                        }
                    </script>-->

    </head>
    <body style='text-align:center; background-color: #21B180;'>
        <img class='imagem-inicial' src='static/logo_transparent.jpg' alt='aqui'/>
        <div class='caixa cadastro'>
            <div class='conteudo'>
                <h1>Cadastro</h1>
                <form method='post' action="ClienteServlet?action=cadastro_cliente">          
                    <input type='text'  class='form-control campo0' id='usuario' name='usuario' placeholder='Nome Completo'>             
                    <input type='tel'  class='form-control campo0' id='telefone' name='telefone' placeholder='Telefone'><br>  
                    <input type='text'  class='form-control campo1' id='cpf' name='cpf' placeholder='CPF'><br>  
                    <input type='email'  class='form-control campo1' id='email' name='email' placeholder='Email'><br> 
                    <input type='text'  class='form-control campo1' id='cep' name='cep' placeholder='CEP'><br>
                    <label>Estado</label>
                    <select id="estado" name="estado" required class="form-control">
                        <c:forEach var="estadoss" items="${estadoss}">
                            <option>
                                ${estadoss.nomeEstado}
                            </option>
                        </c:forEach>
                    </select>
<!--
                    <label>Cidade</label>
                    <select id="cidade" name="cidade" required class="form-control" >
                        <option >{city.nomecidadeteste}</option>
                    </select>-->
                    <input type='text'  class='form-control campo1' id='bairro' name='bairro' placeholder='Bairro'><br>
                    <input type='text'  class='form-control campo1' id='rua' name='rua' placeholder='Rua'><br>
                    <input type='text'  class='form-control campo2' id='numero' name='numero' placeholder='Número'><br>
                    <input type='text'  class='form-control campo2' id='complemento' name='complemento' placeholder='Complemento'><br> 
                    <input type='password'  class='form-control campo1' id='senha' name='senha' placeholder='Sua senha'><br>
                    <input type='password'  class='form-control campo1' id='senha' name='senha2' placeholder='Confirmação da senha'><br> 
                    <button type='submit' class='btn btn-primary margem'>Cadastrar</button>
                </form>
            </div>
        </div>     
    </body>
</html>