
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header class="header"></header>
        <a href="SVista">Menú</a>
           <div>
            <div id="div1" > 
                 <img src ="img/logotienda.png" align="center" id="logo">

                 <form id="login"   action="SSesion" method="POST">
                     <input id="input" type="text" name="tfUsuario" placeholder="usuario">
                     <br>
                     <input id="input" type="password" name="tfPassword" placeholder="Contraseña">
                     <br>
                     <input id="input" type="submit" name="btnSesion" value="Iniciar sesion">
                 </form>
             </div> 
        
        </div>
    </body>
</html>
