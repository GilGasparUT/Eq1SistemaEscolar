<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  String usuario = (String) request.getSession().getAttribute("usuario");
    if (usuario==null)
    response.sendRedirect("SIndex");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="vistas/style.css" />
        <title>Vista</title>
    </head>
    
    <body>
        
      <header class="header">
          
          
        <nav class="nav">
        <a href="SVista" class="logo nav-link"><img  id ="icon" src="img/icon.png" align="center" ></a>
        
              
        <button class="nav-toggle" aria-label="Abrir menú">
        <i class="fas fa-bars"></i> 
        </button>
        
        
        <ul class="nav-menu">
           <li class="nav-menu-item">
            <a href="SCliente" class="nav-menu-link nav-link">Clientes</a>
           </li>
           <li class="nav-menu-item">
           <a href="SFabricante" class="nav-menu-link nav-link">Fabricantes</a>
           </li>
           <li class="nav-menu-item">
           <a href="SProducto" class="nav-menu-link nav-link">Productos</a>
           </li>
        </ul>
        
        
      </nav>
    </header>
        
      <img  src="img/logotienda.png" align="center" id ="logo" >
    
    </body>
</html>
