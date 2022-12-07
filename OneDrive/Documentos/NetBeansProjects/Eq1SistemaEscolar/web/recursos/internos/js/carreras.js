
var cmbCarreras = document.querySelector("#cmbCarreras");
var tfClaveCarrera = document.querySelector("#tfClaveCarrera");

cmbCarreras.addEventListener( "change", ()=>
{
 tfClaveCarrera.value = cmbCarreras.value;
});

