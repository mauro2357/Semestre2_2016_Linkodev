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




