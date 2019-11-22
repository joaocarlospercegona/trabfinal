<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <script type="text/javascript" > //USAR ESSE

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
                    </script>



                    <select id="estado" name="estado" required class="form-control" onchange="getCidades()" >
                        <option >${state.nomeEstado}</option>
                        <c:forEach var="estadoss" items="${estadoss}">
                            <option value="${estadoss.idEstado}">
                                ${estadoss.nomeEstado}
                            </option>
                        </c:forEach>
                    </select>

                    <label>Cidade</label>
                    <select id="cidade" name="cidade" required class="form-control" >
                        <option >${city.nomecidadeteste}</option>
                    </select>
                    <button type="submit" class="btn btn-primary">Salvar</button>
    </body>
</html>
