/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarDatosRegistro(){
    var campoNit = document.getElementById("newNit");
    var campoName = document.getElementById("newName");
    var campoDirection = document.getElementById("newDirection");
    var campoPhone = document.getElementById("newPhone");
    var botonRegistro = document.getElementById("Registrar");
    
    botonRegistro.disabled=true;
    
    if(campoNit.value.length == 0 || campoName.value.length == 0 || campoDirection.value.length == 0){
        botonRegistro.disabled = true;
    } else {
        botonRegistro.disabled = false;
    }
}
