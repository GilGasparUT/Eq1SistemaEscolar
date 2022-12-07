
var cmbCalificacion = document.querySelector("#cmbCalificacion");
var tfClaveInscripcion = document.querySelector("#tfClaveInscripcion");

cmbCalificacion.addEventListener( "change", ()=>
{
 tfClaveInscripcion.value = cmbCalificacion.value;
});

