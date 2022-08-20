
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  String usuario = (String) request.getSession().getAttribute("usuario");
    if (usuario==null)
    response.sendRedirect("SIndex");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/estilos.css">
        <title>Nuevofabricante</title>
    </head>
    <body>
        <div id="container">
            <%@include file="header.jsp"%>
        </div>
    <div>
           <h1>Registar_nuevoFabricante</h1>
           
           <form action="SFabricante" method="POST">
            <table>
                <thead>
                    <tr>
                        <th>Codigo_Fabricante</th>
                        <th>RFC</th>
                        <th>Nombre</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text"   name="tfCodigo_fabricante" value="" size="11" maxlength="11"/></td>
                        <td><input type="text"   name="tfNombre"    value="" size="15"               /></td>
                        <td><input type="text"   name="tfRFC"       value="" size="11"                /></td>
                        <td><input type="submit" name="tfAccion"      value="Agregar"                  /></td>  
                        <td><a href="SFabricante"><button>Regresar</button></a>                                           </td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
    </body>
</html>