<%-- 
    Document   : index
    Created on : 26/06/2022, 07:11:13 PM
    Author     : adria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos.css">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Sistema de Alumnos</h1> 
    <form action="Procesar"   method="POST">
        <table border="0">
            <thead>
                <tr>
                    <th>Matricula</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>CJV</th>
                    <th>DWI</th>
                    <th>ECBD</th>
                    <th>Opcion</th>
                </tr>
            </thead>
            <tbody >
                <tr>
                  <td><input type="text" id= "matricula" name="tfMatricula" value="" size="11"/></td>
                  <td><input type="text" name="tfNombre" value="" size="15"/></td>
                  <td><input type="text" name="tfApellidos" value="" size="15"/></td>
                  <td><input type="text" name="tfCjv" value="" size="2"/></td>
                  <td><input type="text" name="tfDwi" value="" size="2"/></td>
                  <td><input type="text" name="tfEcbd" value="" size="2"/></td>
                  <td><input type="submit" name="btnRegistrar" value="Registrar" size="2"/></td>
                </tr>
            </tbody>
        </table>
    </form>
       
    
       
    </body>
</html>
