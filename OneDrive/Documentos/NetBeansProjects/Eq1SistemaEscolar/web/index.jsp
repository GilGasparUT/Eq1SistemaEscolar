
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="recursos/externos/Bootstrap5/bootstrap.css">
        <link rel="stylesheet" href="recursos/internos/css/estilos.css">
         <link rel="stylesheet" href="recursos/externos/DataTables/datatables.min.css">
        <title>Inicio</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark " style="background-color:#00675A;">
            <div class="container px-5">
                <a class="navbar-brand"><img src="recursos/internos/img/logos/logoUTRNG.png" alt="" width="40" height="40"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="vistas/sesion.jsp">
                                <img src="recursos/internos/img/icon/inicioSesion.png" alt="" width="30" height="30"></a></li>
                        <li class="nav-item"><a class="nav-link" href="vistas/sesion.jsp">Iniciar Sesion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 align-items-center my-5">
                <div class="col-lg-7">
                    <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
                            <div class="carousel-indicators">
                              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                              <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                              <div class="carousel-item active" data-bs-interval="10000">
                                <img src="recursos/internos/img/img1.png" class="d-block w-100" alt="..." width="120" height="200">
                                <div class="carousel-caption d-none d-md-block">
                                </div>
                              </div>
                              <div class="carousel-item" data-bs-interval="2000">
                                <img src="recursos/internos/img/img2.png" class="d-block w-100" alt="..." width="120" height="200">
                                <div class="carousel-caption d-none d-md-block">
                                </div>
                              </div>
                              <div class="carousel-item">
                                <img src="recursos/internos/img/img3.png" class="d-block w-100" alt="..." width="120" height="200">
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
                <div class="col-lg-5">
                    <h1 class="font-weight-light">Bienvenido(a)</h1>
                    <p style="text-align: justify;">Desde la Universidad Tecnológica de la Montaña seguimos preparándonos y trabajando arduamente en coordinación con nuestras autoridades, para generar las mejores condiciones que permitan seguir juntos y unidos en la búsqueda de un mejor futuro.</p>
                </div>
            </div>
            <div class="card text-white my-5 py-4 text-center" style="background-color:#00675A;">
                <div class="card-body"><p class="text-white m-0">Ingeniería en Desarrollo y Gestión de Software </p></div>
            </div>
            <div class="row gx-4 gx-lg-5">
                <div class="col-md-4 mb-5">
                    <div class="card h-100" style="border-color: #00675A;">
                        <div class="card-body">
                            <h2 class="card-title">Misión</h2>
                            <p class="card-text" style="text-align: justify;">Formar profesionistas a nivel superior mediante un modelo educativo integral, con una visión global, programas de calidad y competencias para incorporarse al sector productivo.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <div class="card h-100" style="border-color: #00675A;">
                        <div class="card-body">
                            <h2 class="card-title">Visión</h2>
                            <p class="card-text" style="text-align: justify;">Ser en el año 2018, la institución de educación superior con mayor aceptación de profesionistas en el sector laboral en la zona de influencia, mediante una formación integral.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 mb-5">
                    <div class="card h-100" style="border-color: #00675A;">
                        <div class="card-body">
                            <h2 class="card-title">Calidad</h2>
                            <p class="card-text" style="text-align: justify;">En la UT, estamos comprometidos a mejorar continuamente el proceso educativo y satisfacer los requisitos de nuestros clientes,  mediante la aplicación  de un Sistema de Gestión de Calidad.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="py-5" style="background-color:#00675A;">
            <div class="container px-4 px-lg-5"><p class="m-0 text-center text-white">Copyright &copy; UTRNG 2022</p></div>
        </footer>
        <script src="./recursos/externos/DataTables/jquery.min.js"></script>
        <script src="./recursos/externos/Bootstrap5/bootstrap.bundle.js"></script>
        <script src="./recursos/externos/DataTables/datatables.min.js"></script>
    </body>
</html>
