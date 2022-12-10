
<%@page import="beans.Materia"%>
<%@page import="dao.DAOMateria"%>
<%@page import="beans.Profesor"%>
<%@page import="dao.DAOProfesor"%>
<%@page import="beans.Asignacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOAsignacion"%>
<!DOCTYPE html>
         <%
            DAOAsignacion daoAsignacion = new DAOAsignacion();
            Asignacion asignacion = new Asignacion();
            
            DAOProfesor daoProfesor= new DAOProfesor();
            Profesor profesor = new Profesor();
            
            String claveEmpleado =(String) request.getAttribute("claveEmpleado");
            String atrClaveEmpleado =(String) request.getAttribute("atrClaveEmpleado");
            claveEmpleado = (claveEmpleado ==null) ? "" : claveEmpleado;
            
            ArrayList<Asignacion>lista = daoAsignacion.mostrar(claveEmpleado);

            ArrayList<Asignacion>listClaveEmpleado = daoAsignacion.mostrar();
            ArrayList<Profesor>listNombrePro = daoProfesor.mostrar();


        
            String  usuario = (String) request.getSession().getAttribute("usuario");
            if(usuario==null)
            response.sendRedirect("SIndex");
        %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Asignaciones</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <link rel="stylesheet" href="./recursos/externos/LTE/plugins/fontawesome-free/css/all.min.css">
        <link rel="stylesheet" href="./recursos/externos/LTE/dist/css/adminlte.min.css">
        <link rel="stylesheet" href="./recursos/externos/Bootstrap5/bootstrap.css">
        <link rel="stylesheet" href="./recursos/externos/DataTables/datatables.min.css">
</head>

<body class="hold-transition sidebar-mini">
    
<div class="wrapper">

  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <ul class="navbar-nav">
      <li class="nav-item d-none d-sm-inline-block">
        <a  href="SPrincipal" class="nav-link">Principal</a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
          <div class="dropdown-divider"></div>
          <a href="SSalir" class="dropdown-item dropdown-footer">
          <img src="./recursos/internos/img/icon/out.png" alt="" width="20" height="20">Cerrar Sesion</a>
    </ul>
  </nav>
 
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
      <a href="SPrincipal" class="brand-link" style="text-decoration: none;">
      <img src="./recursos/internos/img/logos/logoUTRNG.png" class="brand-image img-circle elevation-3" style="opacity: 100">
      <span class="brand-text font-weight-light">UTRNG</span>
    </a>
  </aside>
  <div class="content-wrapper">
    <div class="content-header">
      <div class="container-fluid">
          <div class="row mb-5">
               <form  action="SAsignacion" method="POST">
                  <select id="cmbAsignacion" name="cmbAsignacion">
                    <option hidden>Elige la Clave del Profesor</option>
                    <%
                           for (int i=0; i<listClaveEmpleado.size(); i++)
                           {
                               asignacion = listClaveEmpleado.get(i);
                               profesor = listNombrePro.get(i);
                        if(atrClaveEmpleado!=null && claveEmpleado.equals(listClaveEmpleado.get(i).getClaveempleado()))
                             {
                             %>
                             <option value="<%=atrClaveEmpleado%>"selected><%=listClaveEmpleado.get(i).getClaveempleado()%>-<%=profesor.getNombre()%>&nbsp<%=profesor.getApellidos()%></option>
                             <%}
                             else
                             {  
                                                
                         %>
                         <option value="<%=asignacion.getClaveempleado()%>"><%=asignacion.getClaveempleado()%>-<%=profesor.getNombre()%>&nbsp<%=profesor.getApellidos()%></option>
                     <%}}%>
                  </select>
                  <input type="text" id="tfClaveEmpleado" name="tfClaveEmpleado" hidden="">
                    <button type="submit" name="btnBuscar" class="btn btn-primary">Buscar</button>
                    </form> 
          </div>
        <div class="row mb-5">
           <form id="frmAsignaciones" action="SAsignacion" method="POST">
          <a href="#" onclick="procesar('nuevo','')"><button class="btn btn-primary">Nuevo</button></a>
        <div>
          <table  class="table table-bordered" id="example" class="display" style="font-size:14px" style="width:100%">
        <thead style="color:white;">
            <tr  style="background-color:grey;">
               
                <th class="text-center">No. deAsignacion</th>
                <th class="text-center">ClaveProfesor</th>
                <th class="text-center">Materia</th>
                <th class="text-center">Grupo</th>
                <th class="text-center">opciones</th>
            </tr>
        </thead>
        <tbody>
             <% 
                    
                   for (int i=0; i<lista.size(); i++) 
                   {
                     asignacion = lista.get(i);
                    
                    %>
            <tr>
                <td class="text-center"><%=asignacion.getClaveasignacion()%></td>
                <td class="text-center"><%=asignacion.getClaveempleado()%></td>
                <td class="text-center"><%=asignacion.getClavemat()%></td>
                <td class="text-center"><%=asignacion.getClavegrupo()%></td>
                <td class="text-center">
                    <a class="btn btn-light" style="text-decoration: none;" href="#" onclick="procesar('editar','<%=asignacion.getClaveasignacion()%>')">
                    <img src="./recursos/internos/img/icon/editar.png"  alt="" width="30" height="30"></a>
                    
                       <a class="btn btn-light" style="text-decoration: none;" href="#" onclick="procesar('eliminar','<%=asignacion.getClaveasignacion()%>')">
                       <img src="./recursos/internos/img/icon/eliminar.png"  alt="" width="30" height="30"></a>
                <%}%>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <!--  <tr>
                <th>Matricula</th>
                <th>CURP</th>
                <th>Nombre del Alumno</th>
                <th>Fecha de Nacimiento</th>
                <th>Sexo</th>
                <th></th>
            </tr> -->
        </tfoot>
          </table>
      </div>
     </form>
             <script>
                    function procesar (accion,claveasignacion)
                    {
                        var tfAccion = document.createElement("input");
                        tfAccion.name = "tfAccion";
                        tfAccion.type = "hidden";
                        tfAccion.value = accion;
                        
                        var tfClaveAsignacion = document.createElement("input");
                        tfClaveAsignacion.name = "tfClaveAsignacion";
                        tfClaveAsignacion.type = "hidden";
                        tfClaveAsignacion.value = claveasignacion;
                        
                        
                        var padre = document.getElementById("frmAsignaciones");
                        padre.appendChild(tfAccion);
                        padre.appendChild(tfClaveAsignacion);
                        
                        
                        padre.submit();
                    }
                </script>   
        </div>
      </div>
    </div>

    <div class="content">
      <div class="container-fluid">
        <div class="row">
        </div>
      </div>
    </div>
  </div>

  <footer class="main-footer">
    <strong>Copyright &copy; 2022-2024 <a>Universidad Tecnologica</a>.</strong> All rights reserved.
  </footer>
</div>
<script src="./recursos/externos/DataTables/jquery.min.js"></script>
<script src="./recursos/externos/Bootstrap5/bootstrap.bundle.js"></script>
<script src="./recursos/externos/DataTables/datatables.min.js"></script>
<script src="./recursos/internos/js/asignaciones.js"></script>

</body>
</html>

<script type="text/javascript">
        $(document).ready(function () {
   $('#example').dataTable({
                "paging": false,
                "searching": true,
                 "order": true,
                 "info": false,
                 columnDefs: [
            {
                target:0,
                visible: false,
               
            }
                 
   ],   
                 

                "language": {
                    "url": "https://cdn.datatables.net/plug-ins/1.10.21/i18n/Spanish.json"
                }
              
            });
});
    </script>