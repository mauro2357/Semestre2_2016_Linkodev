/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function initMap() {
    var latitud = document.getElementById("latitud").value;
    var longitud = document.getElementById("longitud").value;
    var destino = document.getElementById("destino").value;
    var origen = document.getElementById("address").value;
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
        center: {lat: latitud, lng: longitud}  // Australia.
    });

    var directionsService = new google.maps.DirectionsService;
    var directionsDisplay = new google.maps.DirectionsRenderer({
        draggable: true,
        map: map,
        panel: document.getElementById('right-panel')
    });
    directionsDisplay.addListener('directions_changed', function () {
        computeTotalDistance(directionsDisplay.getDirections());
    });
    document.getElementById('submit').addEventListener('click', function (event) {
        destino = document.getElementById("destino").value;
        displayRoute(origen, destino, directionsService,
                directionsDisplay);
        //placeMarker(map, event.latLng);
    });
    displayRoute(origen, destino, directionsService,
            directionsDisplay);
}
function displayRoute(origin, destination, service, display) {
    service.route({
        origin: origin,
        destination: destination,
        //waypoints: [{location: 'autopista medellin-bogota'}, {location: 'envigado.antioquia'}],
        travelMode: google.maps.TravelMode.DRIVING,
        avoidTolls: true
    }, function (response, status) {
        if (status === google.maps.DirectionsStatus.OK) {
            display.setDirections(response);
        } else {
            alert('Could not display directions due to: ' + status);
        }
    });


    function computeTotalDistance(result) {
        var total = 0;
        var myroute = result.routes[0];
        for (var i = 0; i < myroute.legs.length; i++) {
            total += myroute.legs[i].distance.value;
        }
        total = total / 1000;
        document.getElementById('total').innerHTML = total + ' km';
    }
}



