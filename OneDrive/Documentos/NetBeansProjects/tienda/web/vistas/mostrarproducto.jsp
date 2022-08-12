<%@page import="beans.Producto"%>
<%@page import="dao.DAOProducto"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/estilos.css">
        <title>Cliente</title>
    </head>
    <body>
        <h1>Listado_Productos</h1>
        <div id="nuevoproducto">
            <a href="SProducto?accion=nuevo"><button>Nuevo</button>  </a>
        </div>
        
        <div>
        <table border="1">
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
                    <%
                    DAOProducto daoProducto = new DAOProducto();
                    ArrayList<Producto> lista = daoProducto.mostrar();
                    for(int i=0; i<lista.size(); i++)
                    {
                     Producto producto=new Producto();
                     producto = lista.get(i);
                    %>
                    <tr>
                        <td><%=producto.getCodigo_producto()%></td>
                        <td><%=producto.getNombre()%></td>
                        <td><%=producto.getPrecio()%></td>
                        <td><%=producto.getCodigo_fabricante()%></td>
                        
                        <td><a href="SProducto?accion=editar&codigo_producto=<%=producto.getCodigo_producto()%>"><button>Editar</button></a></td>
                        <td><a href="SProducto?accion=eliminar&codigo_producto=<%=producto.getCodigo_producto()%>"><button>Eliminar</button></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
