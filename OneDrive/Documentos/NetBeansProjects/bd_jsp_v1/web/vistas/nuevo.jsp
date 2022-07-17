<%-- 
    Document   : nuevo
    Created on : 9/07/2022, 08:13:25 AM
    Author     : adria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/estilos.css">
        <title>Nuevo</title>
    </head>
    <body>
    <div>
           <h1>Nuevo_Alumno_IDGS</h1>
           <form action="SAlumno" method="POST">
            <table>
                <thead>
                    <tr>
                        <th>Matricula</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>DWI</th>
                        <th>Cjv</th>
                        <th>ECBD</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text"   name="tfMatricula" value="" size="11" maxlength="11"/></td>
                        <td><input type="text"   name="tfNombre"    value="" size="15"               /></td>
                        <td><input type="text"   name="tfApellidos" value="" size="30"               /></td>
                        <td><input type="text"   name="tfDwi"       value="" size="2"                /></td>
                        <td><input type="text"   name="tfCjv"       value="" size="2"                /></td>
                        <td><input type="text"   name="tfEcbd"      value="" size="2"                /></td>
                        <td><input type="submit" name="accion"      value="Agregar"                  /></td>  
                        <td><a href="SAlumno"><button>Regresar</button></a>                                           </td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
    </body>
</html>