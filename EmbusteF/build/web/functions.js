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

