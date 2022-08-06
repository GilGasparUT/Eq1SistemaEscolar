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
           <h1>Registar_nuevoCliente</h1>
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
                        <td><input type="text"   name="tfId_cliente" value="" size="11" maxlength="11"/></td>
                        <td><input type="text"   name="tfRFC"       value="" size="11"                /></td>
                        <td><input type="text"   name="tfNombre"    value="" size="15"               /></td>
                        <td><input type="text"   name="tfApellidos" value="" size="30"               /></td>
                        <td><input type="text"   name="tfTelefono" value="" size="12"               /></td>
                        <td><input type="submit" name="accion"      value="Agregar"                  /></td>  
                        <td><a href="SCliente"><button>Regresar</button></a>                                           </td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
    </body>
</html>