<%@page import="java.util.ArrayList"%>
<%@page import="beans.Alumno"%>
<%@page import="dao.DAOAlumno"%>
<!DOCTYPE html>
<%
  String  usuario = (String) request.getSession().getAttribute("usuario");
  if(usuario==null)
  response.sendRedirect("SIndex");
%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Alumnos</title>

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
          
            
           <form id="frmAlumnos" action="SAlumno" method="POST">
          <a href="#" onclick="procesar('nuevo','')"><button class="btn btn-primary">Nuevo</button></a>
        <div>
          <table  class="table table-bordered" id="example" class="display" style="font-size:14px" style="width:100%">
        <thead style="color:white;">
            <tr  style="background-color:grey;">
               
                <th class="text-center">Matricula</th>
                <th class="text-center">A�o</th>
                <th class="text-center">CURP</th>
                <th class="text-center">Nombre</th>
                <th class="text-center">FechaNacimiento</th>
                <th class="text-center">Sexo</th>
                <th class="text-center">ClaveCarrera</th>
                <th class="text-center">opciones</th>
            </tr>
        </thead>
        <tbody>
             <% 
                    DAOAlumno daoAlumno = new DAOAlumno();
                    ArrayList<Alumno> lista = daoAlumno.mostrar();
                    
                   for (int i=0; i<lista.size(); i++) 
                   {
                     Alumno alumno = new Alumno();
                     alumno = lista.get(i);
                   
                    %>
            <tr>
                <td class="text-center"><%=alumno.getMatricula()%></td>
                <td class="text-center"><%=alumno.getYear()%></td>
                <td class="text-center"><%=alumno.getCurp()%></td>
                <td class="text-center"><%=alumno.getApellidos()%>&nbsp<%=alumno.getNombre()%></td>
                <td class="text-center"><%=alumno.getFechanac()%></td>
                <td class="text-center"><%=alumno.getSexo()%></td>
                <td class="text-center"><%=alumno.getClavecarrera()%></td>
                <td class="text-center">
                    <a class="btn btn-light" style="text-decoration: none;" href="#" onclick="procesar('editar','<%=alumno.getMatricula()%>')">
                    <img src="./recursos/internos/img/icon/editar.png"  alt="" width="30" height="30"></a>
                    
                       <a class="btn btn-light" style="text-decoration: none;" href="#" onclick="procesar('eliminar','<%=alumno.getMatricula()%>')">
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
                    function procesar (accion,matricula)
                    {
                        var tfAccion = document.createElement("input");
                        tfAccion.name = "tfAccion";
                        tfAccion.type = "hidden";
                        tfAccion.value = accion;
                        
                        var tfMatricula = document.createElement("input");
                        tfMatricula.name = "tfMatricula";
                        tfMatricula.type = "hidden";
                        tfMatricula.value = matricula;
                        
                        
                        var padre = document.getElementById("frmAlumnos");
                        padre.appendChild(tfAccion);
                        padre.appendChild(tfMatricula);
                        
                        
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
</body>
</html>

<script type="text/javascript">
        $(document).ready(function () {
   $('#example').dataTable({
                "paging": false,
                "searching": true,
                 "order": true,
                 "info": false,

                "language": {
                    "url": "https://cdn.datatables.net/plug-ins/1.10.21/i18n/Spanish.json"
                }
              
            });
});
    </script>