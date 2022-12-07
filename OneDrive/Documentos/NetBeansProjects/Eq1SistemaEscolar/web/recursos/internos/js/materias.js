var cmbCarreras = document.querySelector("#cmbCarreras");
var tfClaveCarrera = document.querySelector("#tfClaveCarrera");

cmbCarreras.addEventListener( "change", ()=>
{
 tfClaveCarrera.value = cmbCarreras.value;
});


var cmbSemestre = document.querySelector("#cmbSemestre");
var tfSemestre = document.querySelector("#tfSemestre");

cmbSemestre.addEventListener( "change", ()=>
{
 tfSemestre.value = cmbSemestre.value;
});

