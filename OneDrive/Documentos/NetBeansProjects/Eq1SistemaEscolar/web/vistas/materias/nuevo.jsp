
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
  <title>NuevaMateria</title>

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
        <a  href="SMateria" class="nav-link">Regresar</a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
          <div class="dropdown-divider"></div>
          <a href="SSalir" class="dropdown-item dropdown-footer">
          <img src="./recursos/internos/img/icon/out.png" alt="" width="20" height="20">Cerrar Sesion</a>
    </ul>
  </nav>
 
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a href="SPrincipal" style="text-decoration: none;" class="brand-link">
      <img src="./recursos/internos/img/logos/logoUTRNG.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: 100">
      <span class="brand-text font-weight-light">Principal</span>
    </a>
  </aside>
    
    <div class="container px-4 px-lg-5">
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
		    <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
		   <div class="text-center my-5">
			<img src="./recursos/internos/img/icon/editar.png" alt="logo" width="50" height="50">
                        <h1>Nueva Materia</h1>
		  </div>
                <div class="card shadow-lg">
		   <div class="card-body p-5">
                    <form action="SMateria" method="POST">
                          <label class="mb-2 text-muted">ClaveMateria</label>
			  <input type="text" name="tfClaveMat"   value=""    maxlength="20" class="form-control">
                          <br>
                          <label class="mb-2 text-muted">Nombre_Materia</label>
			  <input type="text" name="tfMateria"   value=""    maxlength="30" class="form-control">
                          <br>
                          <label class="mb-2 text-muted">Semestre</label>
			  <input type="text" name="tfSemestre"        value=""    maxlength="20"class="form-control">
                          <br>
                          <label class="mb-2 text-muted">Clave_Carrera</label>
			  <input type="text" name="tfClaveCarrera"   value=""    maxlength="20" class="form-control">
                          <br>
                          <button type="submit" name="tfAccion" value="Agregar" class="btn btn-primary ms-auto" >
			       Agregar
			  </button>
                          <a href="SMateria"><button class="btn btn-primary ms-auto">
			        Regresar
			  </button></a>
		  </form>
                </div>
             </div>
          </div>
        </div>
      </div>
    </section>
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

