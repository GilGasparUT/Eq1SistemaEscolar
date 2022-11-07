<%@page import="dao.DAOAlumno"%>
<%@page import="beans.Alumno"%>
<%@page import="servlets.SAlumno"%>
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
  <title>EditarAlumno</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <link rel="stylesheet" href="./recursos/externos/LTE/plugins/fontawesome-free/css/all.min.css">
        <link rel="stylesheet" href="./recursos/externos/LTE/dist/css/adminlte.min.css">
        <link rel="stylesheet" href="./recursos/externos/Bootstrap5/bootstrap.css">
        <link rel="stylesheet" href="./recursos/externos/DataTables/datatables.min.css">
</head>

<body class="hold-transition sidebar-mini">
              <% 
                    DAOAlumno dao    = new DAOAlumno();
                    Alumno alumno    = new Alumno();
                    String matricula = request.getAttribute("matricula").toString();
                    alumno           = dao.buscar(matricula);
              %>
<div class="wrapper">

 <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
          <a href="SPrincipal" class="nav-link">Principal</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
     <li class="nav-item">
        <div class="navbar-search-block">
          <form class="form-inline">
            <div class="input-group input-group-sm">
              <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
              <div class="input-group-append">
                <button class="btn btn-navbar" type="submit">
                  <i class="fas fa-search"></i>
                </button>
                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                  <i class="fas fa-times"></i>
                </button>
              </div>
            </div>
          </form>
        </div>
      </li>
    </ul>
 </nav>
 
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a href="" class="brand-link">
      <img src="./recursos/internos/img/logos/logoUTRNG.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: 100">
      <span class="brand-text font-weight-light">UTRNG</span>
    </a>
            
    <div class="sidebar">
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
           <li class="nav-item menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Opcion
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                  <i class="far fa-circle nav-icon"></i>
              </li>
             </ul>
          </li>
        </ul>
      </nav>
    </div>
  </aside>


  <div class="content-wrapper">
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-6">
          <div class="col-sm-6">
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Cerrar Sesion</a></li>
              <li class="breadcrumb-item active"></li>
            </ol>
          </div>
          <div>
               <h2>Editar Alumno</h2><br>
            <form action="SAlumno" method="POST">
                        <input type = "hidden" name ="tfMatriculaOld" value="<%=alumno.getMatricula()%>"> <!-- matricula original -->
                        
            Matricula:  <input type="text" name="tfMatricula"   value="<%=alumno.getMatricula()%>"       maxlength="20"/> <br>
            CURP:       <input type="text" name="tfCURP"        value="<%=alumno.getCurp()%>"            maxlength="20"/><br>
            Nombre:     <input type="text" name="tfNombre"      value="<%=alumno.getNombre()%>"          maxlength="20"/><br>
            Apelidos:   <input type="text" name="tfApellidos"   value="<%=alumno.getApellidos()%>"       maxlength="20"/><br>
            FechaNac:   <input type="text" name="tfFechaNac"    value="<%=alumno.getFechanac()%>"        maxlength="20"/><br>
            Sexo:       <input type="text" name="tfSexo"        value="<%=alumno.getSexo()%>"            maxlength="20"/><br>
                        <input type="submit" name="tfAccion"    value="Actualizar"/>
                        <a href="SAlumno"><button>Regresar</button></a>
            </form>
        </div>
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

