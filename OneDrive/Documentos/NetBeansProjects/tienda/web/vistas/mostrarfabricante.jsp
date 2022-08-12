<%@page import="beans.Fabricante"%>
<%@page import="dao.DAOFabricante"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/estilos.css">
        <title>Fabricante</title>
    </head>
    <body>
        <h1>Listado_Fabricante</h1>
        <div id="nuevofabricante">
            <a href="SFabricante?accion=nuevo"><button>Nuevo</button>  </a>
        </div>
        
        <div>
        <table border="1">
                <thead>
                    <tr>
                        <th>Codigo_Fabricante</th>
                        <th>Nombre</th>
                        <th>RFC</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    DAOFabricante daoFabricante = new DAOFabricante();
                    ArrayList<Fabricante> lista = daoFabricante.mostrar();
                    for(int i=0; i<lista.size(); i++)
                    {
                     Fabricante fabricante=new Fabricante();
                     fabricante= lista.get(i);
                    %>
                    <tr>
                        <td><%=fabricante.getCodigo_fabricante()%></td>
                        <td><%=fabricante.getNombre()%></td>
                        <td><%=fabricante.getRFC()%></td>
                        
                        <td><a href="SFabricante?accion=editar&codigo_fabricante=<%=fabricante.getCodigo_fabricante()%>"><button>Editar</button></a></td>
                        <td><a href="SFabricante?accion=eliminar&codigo_fabricante=<%=fabricante.getCodigo_fabricante()%>"><button>Eliminar</button></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
