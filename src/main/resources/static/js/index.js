
let estado = document.getElementById("estadoSelect");
let cidadeFrom = document.getElementById("cidadeFromSelect");
let cidadeTo = document.getElementById("cidadeToSelect");

let retornoDistancia = document.getElementById("retornoDistanciaDiv");

let calcularDistancia = document.querySelector("#calcularButton");

function updateSelect(selectCompoment, dados, textItens){

    selectCompoment.innerHTML = "";
    selectCompoment.style.display="block";

    let itens = dados;

    let opt = document.createElement("option");
    opt.value = '';
    opt.selected = true;
    opt.disabled = true;
    opt.innerHTML = "Selecione " + textItens;
    selectCompoment.appendChild(opt);

    itens.forEach(function(item){
        opt = document.createElement("option");

        opt.text = item.name;
        opt.value = item.id;

        selectCompoment.appendChild(opt);
    });
}

function controleBotao(status){
    status ? calcularDistancia.style.display="block": calcularDistancia.style.display="none";
}

function controleResposta(status){
    status ? retornoDistancia.style.display="block": retornoDistancia.style.display="none";
}

cidadeFrom.onchange = function(){
    controleResposta(false);

    let cidadeSelected = this.value;

    if(++cidadesSelecionadas >= 2){
        controleBotao(true);
    }
}

cidadeTo.onchange = function(){
    controleResposta(false);

    let cidadeSelected = this.value;

    if(++cidadesSelecionadas >= 2){
        controleBotao(true);
    }
}

let estadoSelected = -1;
let cidadesSelecionadas = 0;

estado.onchange = function(){
    controleBotao(false);
    controleResposta(false);

    cidadesSelecionadas = 0;

    let estado = this.value;

    cidades = getCidades(estado);

    let labelCidadeFrom = document.getElementById("labelCidadeFrom");
    let labelCidadeTo = document.getElementById("labelCidadeTo");

    labelCidadeFrom.style.display="inline-flex";
    updateSelect(cidadeFromSelect, cidades, " a cidade");

    labelCidadeTo.style.display="inline-flex";
    updateSelect(cidadeToSelect, cidades, " a cidade");
}

calcularDistancia.addEventListener("click", function(){

    let distanciaMetros = 0;
    let distanciaMilhas = 0;

    if(cidadeFrom.value !== cidadeTo.value){
        distanciaMetros = (getCalculoDistanciaMetros(cidadeFrom.value, cidadeTo.value)/1000).toFixed(3);
        distanciaMilhas = getCalculoDistanciaMilhas(cidadeFrom.value, cidadeTo.value).toFixed(3);
    }

    let respostaMetrosAlert = document.getElementById("respostaMetrosAlert");
    let respostaMilhasAlert = document.getElementById("respostaMilhasAlert");

    respostaMetrosAlert.innerHTML = `A distância em quilometros entre ${cidadeFrom[cidadeFrom.selectedIndex].text} e ${cidadeTo[cidadeTo.selectedIndex].text} é: ${distanciaMetros}Km`;
    respostaMilhasAlert.innerHTML = `A distância em milhas entre ${cidadeFrom[cidadeFrom.selectedIndex].text} e ${cidadeTo[cidadeTo.selectedIndex].text} é: ${distanciaMilhas}mi`;
    retornoDistancia.style.display="block";
    controleResposta(true);
});

updateSelect(estado, getEstados().content, " o estado");