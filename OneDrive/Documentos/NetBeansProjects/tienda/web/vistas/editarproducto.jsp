

<%@page import="beans.Producto"%>
<%@page import="dao.DAOProducto"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vistas/estilos.css">
    <title>editar</title>
</head>
   
    
              <% 
                    DAOProducto dao    = new DAOProducto();
                    Producto producto    = new Producto();
                    String codigo_producto = request.getAttribute("codigo_producto").toString();
                    producto          = dao.buscar(codigo_producto);
              %>
              
        <div>
            <h1>Editar_producto</h1>
            <form action="SProducto" method="POST">
            <table>
                <thead>
                    <tr>
                       
                        <th>Codigo_producto</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Codigo_fabricante</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <input type = "hidden" name ="tfCodigo_productoOld" value="<%=producto.getCodigo_producto()%>">
                        
                        <td><input type="text"   name="tfCodigo_producto"       value="<%=producto.getCodigo_producto()%>"    size="11" maxlength="11"/></td>
                        <td><input type="text"   name="tfNombre"                value="<%=producto.getNombre()%>"           size="15"                 /></td>
                        <td><input type="text"   name="tfPrecio"                value="<%=producto.getPrecio()%>"        size="15"                    /></td>
                        <td><input type="text"   name="tfCodigo_fabricante"     value="<%=producto.getCodigo_fabricante()%>"     size="30"              ></td>
                        <td><input type="submit" name="accion"           value="Actualizar"                                                           /></td>  
                        <td><a href="SProducto"> <button>Regresar </button></a></td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       

</html>
