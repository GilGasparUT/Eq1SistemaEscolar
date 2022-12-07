

var cmbAsignacion = document.querySelector("#cmbAsignacion");
var tfClaveEmpleado = document.querySelector("#tfClaveEmpleado");

cmbAsignacion.addEventListener( "change", ()=>
{
 tfClaveEmpleado.value = cmbAsignacion.value;
});

