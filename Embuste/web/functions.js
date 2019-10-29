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

//Escolher linha de uma tabela

window.onload = defineObject;


function defineObject(){
var elements= document.getElementsByTagName('td');
    for(var i=0; i<elements.length;i++)    {
        (elements)[i].addEventListener("click", function(){ alert(this.innerHTML); });
    }    
}