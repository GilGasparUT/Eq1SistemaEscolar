
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../recursos/externos/Bootstrap5/bootstrap.css">
        <link rel="stylesheet" href="../recursos/internos/css/logincss.css">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark " style="background-color:#00675A;">
            <div class="container px-5">
                <a class="navbar-brand" ><img src="../recursos/internos/img/logos/logoUTRNG.png" alt="" width="40" height="40"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="../index.jsp">
                                <img src="../recursos/internos/img/icon/home.png" alt="" width="30" height="30"></a></li>
                        <li class="nav-item"><a class="nav-link" href="../index.jsp">Principal</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container px-4 px-lg-5">
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="text-center my-5">
						<img src="../recursos/internos/img/logos/logologin.png" alt="logo" width="150" height="150">
					</div>
					<div class="card shadow-lg">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4">Login</h1>
							<form action="../SSesion" method="POST" class="needs-validation" novalidate="" autocomplete="off">
								<div class="mb-3">
									<label class="mb-2 text-muted" for="email">Correo Electrónico</label>
									<input id="email" type="email" class="form-control" name="tfUsuario" value="" required autofocus>
									<div class="invalid-feedback">
										Email invalido
									</div>
								</div>
								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="password">Contraseña</label>
									</div>
									<input id="password" type="password" class="form-control" name="tfPassword" required>
								    <div class="invalid-feedback">
								    	Contraseña Requerida
							    	</div>
								</div>
								<div class="d-flex align-items-center">
									<div class="form-check">
										<input type="checkbox" name="remember" id="remember" class="form-check-input">
										<label for="remember" class="form-check-label">Recordar</label>
									</div>
									<button type="submit"  name="btnSesion" value="Iniciar Sesion" class="btn btn-primary ms-auto">
										Login
									</button>
								</div>
							</form>
						</div>
					</div>
					<div class="text-center mt-5 text-muted">
						 
                                                             <div class="card-body">
                                                             <!-- Facebook -->
                                                             <i class="fab fa-facebook-f">
                                                                 <a class="nav-link active" aria-current="page" href="#">
                                                                 <img src="../recursos/internos/img/icon/facebook.png" alt="" width="30" height="30"></a>
                                                             </i>

                                                            <!-- Twitter -->
                                                            <i class="fab fa-twitter"></i>

                                                            <!-- Google -->
                                                            <i class="fab fa-google"></i>

                                                            <!-- Instagram -->
                                                            <i class="fab fa-instagram"></i>

                                                            <!-- Whatsapp -->
                                                            <i class="fab fa-whatsapp"></i>
                                                            </div>
                                                </div>
					</div>
				</div>
			</div>
		</div>
	</section>
   </div>
        <footer class="py-5" style="background-color:#00675A;">
            <div class="container px-4 px-lg-5"><p class="m-0 text-center text-white">Copyright &copy; UTRNG 2022</p></div>
        </footer>
<script src="../recursos/externos/DataTables/jquery.min.js"></script>
<script src="../recursos/externos/Bootstrap5/bootstrap.bundle.js"></script>
<script src="../recursos/externos/DataTables/datatables.min.js"></script>
</body>
</html>