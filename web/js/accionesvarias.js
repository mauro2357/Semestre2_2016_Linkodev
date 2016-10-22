/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cancelarsubmit() {
    if (document.getElementById('imagenperfil').files.length === 0) {
        alert("Por favor seleccione un archivo");
        return false;
    }
}
function filtroIncorrecto() {
    if (document.getElementById('imagenperfil').files.length === 0) {
        alert("Por favor seleccione un archivo");
        return false;
    }
}

function previewFile() {
    var preview = document.querySelector('img');
    var file = document.querySelector('input[type=file]').files[0];
    var reader = new FileReader();
    reader.addEventListener("load", function () {
        preview.src = reader.result;
    }, false);

    if (file) {
        reader.readAsDataURL(file);
    }
}

function valida(e) {
    tecla = (document.all) ? e.keyCode : e.which;

    //Tecla de retroceso para borrar, siempre la permite
    if (tecla == 8) {
        return true;
    }

    // Patron de entrada, en este caso solo acepta numeros
    patron = /[0-9]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
}

$(function comprobrarClave() {
    $('#contrasena').keyup(function () {
        var _this = $('#contrasena');
        var contrasenaNueva = $('#contrasena').val();
        _this.attr('style', 'background:white');
        if (contrasenaNueva.charAt(0) == ' ') {
            _this.attr('style', 'background:#FF4A4A');
        }

        if (contrasenaNueva.val() == '') {
            _this.attr('style', 'background:#FF4A4A');
        }
    });

    $('#confirmarContrasena').keyup(function () {
        var contrasenaNueva = $('#contrasena').val();
        var confirmarContrasena = $('#confirmarContrasena').val();
        var _this = $('#confirmarContrasena');
        _this.attr('style', 'background:white');
        if (contrasenaNueva != confirmarContrasena && confirmarContrasena != '') {
            _this.attr('style', 'background:#ef9a9a ');
            return false;
        } else {
            if (confirmarContrasena == '') {
                _this.attr('style', 'background:white ');
            } else {
                _this.attr('style', 'background:#e8f5e9  ');
            }

        }
    });
});


function comprobarClave2() {
    contrasenaNueva = document.getElementById("contrasena").value;
    confirmarContrasena = document.getElementById("confirmarContrasena").value;
    if (contrasenaNueva != confirmarContrasena) {
        alert("La clave nueva no coincide");
        return false;
    }
}

function mandarAlerta() {
    contador = document.getElementById("contador").value;
    if (contador > 19 & contador < 26) {
        alert("Don/Doña tal vez estes alquilando o vendiendo el inmueble muy caro");
        return false;
    }
}

function mandarAlerta2(cont) {
    contador = paresInt(cont);
    if (contador > 1) {
        alert("Don/Doña tal vez estes alquilando o vendiendo el inmueble muy caro");
        return false;
    }
}

function load() {
    if (GBrowserIsCompatible()) {
      var map = new GMap2(document.getElementById("map"));
      //map.setCenter(new GLatLng(37.4419, -122.1419), 13);
      map.setCenter(new GLatLng(-19.435514, 48.603516), 5);
      map.addControl(new GMapTypeControl());
      map.addControl(new GLargeMapControl());
      map.addControl(new GScaleControl());
      map.addControl(new GOverviewMapControl());
      var point = new GLatLng(-19.000514,46.603516);
      map.addOverlay(new GMarker(point));
    }
  }
  
  function myMap() {
    var mapCanvas = document.getElementById("map");
    var myCenter=new google.maps.LatLng(6.219082,-75.332379);
    var mapOptions = {center: myCenter, zoom: 19};
    var map = new google.maps.Map(mapCanvas, mapOptions);
    google.maps.event.addListener(map, 'click', function(event) {
      placeMarker(map, event.latLng);
    });
  }


  function initMap() {
      var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 19,
        center: {lat: -34.397, lng: 150.644}
      });
      var geocoder = new google.maps.Geocoder();

      document.getElementById('submit').addEventListener('click', function(event) {
        geocodeAddress(geocoder, map);
        //placeMarker(map, event.latLng);
      });
  }

  function geocodeAddress(geocoder, resultsMap) {
      var address = document.getElementById('address').value;
      geocoder.geocode({'address': address}, function(results, status) {
        if (status === google.maps.GeocoderStatus.OK) {
          resultsMap.setCenter(results[0].geometry.location);
          var marker = new google.maps.Marker({
            map: resultsMap,
            position: results[0].geometry.location
          });
          //alert(results[0].geometry.location.lat()+" Se supone es la latitud");
          //alert(+results[0].geometry.location.lng()+"y la longitud");
          document.getElementById('latitud').value = results[0].geometry.location.lat();
          document.getElementById('longitud').value = results[0].geometry.location.lng();
        } else {
          alert('Geocode was not successful for the following reason: ' + status);
        }
      });
  }

  function placeMarker(map, location) {
    var marker = new google.maps.Marker({
      position: location,
      map: map
    });
    var infowindow = new google.maps.InfoWindow({
      content: 'Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng()
    });
    infowindow.open(map,marker);
    document.getElementById('latitud').value = location.lat();
    document.getElementById('longitud').value = location.lng();
  }
