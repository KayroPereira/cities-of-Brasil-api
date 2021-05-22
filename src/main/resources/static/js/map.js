let mapa;
let markers = [null, null];
let bounds;

function inicializar() {
    let coordenadas = {lat: -13.997872, lng: -49.126678};

    mapa = new google.maps.Map(document.getElementById('mapa'), {
      zoom: 3,
      center: coordenadas
    });
}

function pointStart(){
    mapa.setZoom(3);
    mapa.setCenter({lat: -13.997872, lng: -49.126678});
}

function addMarker(latitude, longitude, component, title){

    let marker = new google.maps.Marker({
        position: new google.maps.LatLng(latitude, longitude),
        map: mapa,
        draggable: true,
        animation: google.maps.Animation.DROP,
        title: title
    });
    markers[component] = marker;
    markers[component].setMap(mapa);
}

function clearMarkers() {
    for(i = 0; i < markers.length; i++){
        if(markers[i] != null){
            markers[i].setMap(null);
        }
    }
}

function centerMap(coordenadas){
    bounds = new google.maps.LatLngBounds();

    let coordenadaNull = false;
    for (i = 0; i < coordenadas.length; i++) {

        if(coordenadas[i] != null){
            bounds.extend(new google.maps.LatLng(coordenadas[i].lat, coordenadas[i].lng));
        }else{
            coordenadaNull = true;
        }
    }
    mapa.fitBounds(bounds);

    if(coordenadaNull){
        mapa.setZoom(10);
    }else if((coordenadas[0].lat === coordenadas[1].lat) && (coordenadas[0].lng === coordenadas[1].lng)){
        mapa.setZoom(10);
    }
}