var cmbInscripcion = document.querySelector("#cmbInscripcion");
var tfMatricula = document.querySelector("#tfMatricula");

cmbInscripcion.addEventListener( "change", ()=>
{
 tfMatricula.value = cmbInscripcion.value;
});

