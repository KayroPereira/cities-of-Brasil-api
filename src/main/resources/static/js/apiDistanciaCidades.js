
const urlPage = "http://localhost:8080";

//const urlPage = "https://cities-of-brasil-api.herokuapp.com";

function getUrl(url){
    let request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send();
    return request.responseText;
}

function getEstados(){
    let data = getUrl(urlPage+"/states?page=0&size=30&sort=name,asc");
    return JSON.parse(data);
}

function getEstadoPorNome(estadoNome){
    let data = getUrl(urlPage+"/states/name/"+estadoNome);
    return JSON.parse(data);
}

function getCidades(estadoUF){
    let data = getUrl(urlPage+"/cities/uf/"+estadoUF);
    return JSON.parse(data);
}

function getCidadePorId(cidadeId){
    let data = getUrl(urlPage+"/cities/"+cidadeId);
    return JSON.parse(data);
}

//function getCidadePorNome(cidadeNome, estadoId){
//    let data = getUrl(urlPage+"/cities/filter?city="+cidadeNome+"&uf="+estadoId);
//    return JSON.parse(data);
//}

function getCalculoDistanciaMetros(cidadeFrom, cidadeTo){
    let data = getUrl(urlPage+"/distances/by-cube?from="+cidadeFrom+"&to="+cidadeTo);
    return JSON.parse(data);
}

function getCalculoDistanciaMilhas(cidadeFrom, cidadeTo){
    let data = getUrl(urlPage+"/distances/by-points?from="+cidadeFrom+"&to="+cidadeTo);
    return JSON.parse(data);
}