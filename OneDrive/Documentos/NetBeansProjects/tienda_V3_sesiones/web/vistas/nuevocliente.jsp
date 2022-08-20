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
        <title>NuevoCliente</title>
    </head>
    <body>
        <div id="container">
            <%@include file="header.jsp"%>
        </div>
    <div>
           <h1>Nuevo_Cliente</h1>
           
           <form action="SCliente" method="POST">
            <table>
                <thead>
                    <tr>
                        <th>Id_Cliente</th>
                        <th>RFC</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Telefono</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text"   name="tfId_cliente" value="" size="5" maxlength="11"/></td>
                        <td><input type="text"   name="tfRFC"       value="" size="15"               /></td>
                        <td><input type="text"   name="tfNombre"    value="" size="15"               /></td>
                        <td><input type="text"   name="tfApellidos" value="" size="25"               /></td>
                        <td><input type="text"   name="tfTelefono"  value="" size="10"                /></td>
                        <td><input type="submit" name="tfAccion"      value="Agregar"                  /></td>  
                        <td><a href="SCliente"><button>Regresar</button></a>                            </td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
    </body>
</html