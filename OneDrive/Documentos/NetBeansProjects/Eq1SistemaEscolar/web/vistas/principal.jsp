<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOAlumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.Alumno"%>

<%
  String  usuario = (String) request.getSession().getAttribute("usuario");
  if(usuario==null)
  response.sendRedirect("SIndex");
%>
<!DOCTYPE html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Home</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <link rel="stylesheet" href="../recursos/externos/LTE/plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="./recursos/externos/LTE/dist/css/adminlte.min.css">
  <link rel="stylesheet" href="./recursos/externos/Bootstrap5/bootstrap.css">
  <link rel="stylesheet" href="./recursos/externos/DataTables/datatables.min.css">
</head>

<body class="hold-transition sidebar-mini">
<div class="wrapper">
    
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <ul class="navbar-nav">
      <li class="nav-item d-none d-sm-inline-block">
        <a class="nav-link">Bienvenido</a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
          <div class="dropdown-divider"></div>
          <a href="SSalir" class="dropdown-item dropdown-footer">
          <img src="./recursos/internos/img/icon/out.png" alt="" width="20" height="20">Cerrar Sesion</a>
    </ul>
  </nav>
    
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a style="text-decoration: none;" class="brand-link">
      <img src="./recursos/externos/LTE/dist/img/logoUTRNG.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: 100">
      <span class="brand-text font-weight-light">UTRNG</span>
    </a>
            
    <div class="sidebar">
        
        
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

          <li class="nav-item menu-open">
            <ul class="nav nav-treeview">

              <li class="nav-item">
                <a href="SAlumno" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Alumnos</p>
                </a>
              </li>
               
              
              <li class="nav-item">
                <a href="SProfesor" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Profesores</p>
                </a>
              </li>
              
              
              <li class="nav-item">
                <a href="SCarrera" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Carreras</p>
                </a>
              </li>
              
              
              <li class="nav-item">
                <a href="SMateria" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Materias</p>
                </a>
              </li>
              
              <li class="nav-item">
                <a href="SGrupoo"class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Grupos</p>
                </a>
              </li>
              
              
              <li class="nav-item">
                <a href="SCalificacion" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Calificaciones</p>
                </a>
              </li>
                                        
              <li class="nav-item">
                <a href="SAsignacion"class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Asignaciones</p>
                </a>
              </li>
              
              <li class="nav-item">
                <a href="SInscripcion" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Inscripciones</p>
                </a>
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
        <div class="row mb-2">
          <div class="col-sm-12">
             <div class="container px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                <div class="col-lg-12">
                    <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
                            <div class="carousel-indicators">
                              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                              <div class="carousel-item active" data-bs-interval="10000">
                                <img src="recursos/internos/img/img1.png" class="d-block w-100" alt="..." width="120" height="350">
                                <div class="carousel-caption d-none d-md-block">
                                </div>
                              </div>
                              <div class="carousel-item" data-bs-interval="2000">
                                <img src="recursos/internos/img/img2.png" class="d-block w-100" alt="..." width="120" height="350">
                                <div class="carousel-caption d-none d-md-block">
                                </div>
                              </div>
                              <div class="carousel-item">
                                <img src="recursos/internos/img/img3.png" class="d-block w-100" alt="..." width="120" height="350">
                                <div class="carousel-caption d-none d-md-block">
                                </div>
                              </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                              <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                              <span class="carousel-control-next-icon" aria-hidden="true"></span>
                              <span class="visually-hidden">Next</span>
                            </button>
                          </div>
                </div>
            </div>
        </div>
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

  <aside class="control-sidebar control-sidebar-dark">
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-inline">
     
    </div>
    <strong>Copyright &copy; 2022-2023 <a  >UTRNG</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<script src="./recursos/externos/DataTables/jquery.min.js"></script>
<script src="./recursos/externos/Bootstrap5/bootstrap.bundle.js"></script>
<script src="./recursos/externos/DataTables/datatables.min.js"></script>
</body>
</html>
