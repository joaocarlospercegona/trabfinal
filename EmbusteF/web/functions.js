function showBox() {
    var box = document.getElementById('relatorio-box');
    var rec = document.getElementById('reclama-box');
    var data1 = document.getElementById('data-ini-box');
    var data2 = document.getElementById('data-fim-box');
    if (box.selectedIndex == 4) {
        rec.disabled = false;
        data1.disabled = true;
        data2.disabled = true;
    } else if (box.selectedIndex == 3) {
        rec.disabled = true;
        data1.disabled = false;
        data2.disabled = false;
    } else {
        rec.disabled = true;
        data1.disabled = true;
        data2.disabled = true;
    }
}

function confirmaDeleteAte (ba){
    var del=confirm("Deseja realmente apagar?");
    if (del==true)
        window.location.href = "ClienteServlet?action=remover_atendimento&cod=" + ba;   
}

function confirmaDeleteProd (ba){
    var del=confirm("Deseja realmente apagar?");
    if (del==true)
        window.location.href = "FuncionarioServlet?action=remover_produto&id=" + ba;   
}

function confirmaDeleteCat (ba){
    var del=confirm("Deseja realmente apagar?");
    if (del==true)
        window.location.href = "FuncionarioServlet?action=remover_categoria&id=" + ba;   
}

function confirmaDeleteGrt (ba){
    var del=confirm("Deseja realmente apagar?");
    if (del==true)
        window.location.href = "GerenteServlet?action=remover&type=2&cpf=" + ba;   
}

function confirmaDeleteFunc (ba){
    var del=confirm("Deseja realmente apagar?");
    if (del==true)
        window.location.href = "GerenteServlet?action=remover&type=1&cpf=" + ba;   
}

function getCidades(){
    var idestado = $("#estado").val();
    var url = "AJAXServlet";
    $.ajax({
    url : url, 
        data : {
        idestado : idestado
        }, 
        dataType : 'json',
        success : function(data) {
            $("#cidade").empty();
            $("#cidade").attr("disabled", false);
            $.each(data, function(i, obj) {
                $("#cidade").append('<option value=' + obj.nomecidadeteste + '>' + obj.nomecidadeteste + '</option>');
            });
            var  texto = $('#estado').find(':selected').text();
            //$('#estado').find(':selected').val() = texto;
            var valor = $('#estado').find(':selected').val(texto); 
            console.log(texto);
            $(document).ready(function() {
                $('#estado').find(':selected').val().change(function(){
                    $('#estado').find(':selected').val($(this).find(":selected").text());
                })
                .trigger('change');
            });     
            console.log($('#estado').find(':selected').val());       
        },
        error : function(request, textStatus, errorThrown) {
            alert(request.status + ', Error: ' + request.statusText);
        }
    });
}

