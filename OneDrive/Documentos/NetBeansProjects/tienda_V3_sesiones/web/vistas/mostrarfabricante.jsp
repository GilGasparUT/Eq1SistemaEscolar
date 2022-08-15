<%@page import="beans.Fabricante"%>
<%@page import="dao.DAOFabricante"%>
<%@page import="java.util.ArrayList"%>

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
        <title>MostrarFabricante</title>
    </head>
    <body>
        <header class="header"></header>
        
    <form id="frmFabricante" action="SFabricante" method="POST">
        
        <h1>Listado_Fabricante</h1>
        
        <div id="nuevofabricante">
            <!---<a href="SFabricante?accion=nuevo"><button>Nuevo</button></a>-->
            <a href="#" onclick="procesar('nuevo','')">Nuevo</a>
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
                        
                        <td>
                            <a href="#" onclick="procesar('editar','<%=fabricante.getCodigo_fabricante()%>')">Editar</a>
                            <%--<a href="SFabricante?accion=editar&codigo_fabricante=<%=fabricante.getCodigo_fabricante()%>"><button>Editar</button></a>--%>
                        </td>
                        
                        <td>
                            <a href="#" onclick="procesar('eliminar','<%=fabricante.getCodigo_fabricante()%>')">Eliminar</a>
                            <%--<a href="SFabricante?accion=eliminar&codigo_fabricante=<%=fabricante.getCodigo_fabricante()%>"><button>Eliminar</button></a>--%>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </form>
                
                
                
                <script>
                    function procesar(accion, codigo_fabricante)
                    {
                        var tfAccion   = document.createElement("input");
                        tfAccion.name  = "tfAccion";
                        tfAccion.type   = "hidden";
                        tfAccion.value = accion;
                        
                        var tfCodigo_fabricante = document.createElement("input");
                        tfCodigo_fabricante.name= "tfCodigo_fabricante";
                        tfCodigo_fabricante.type="hidden";
                        tfCodigo_fabricante.value = codigo_fabricante;
                        
                        var padre =  document.getElementById("frmFabricante");
                        padre.appendChild(tfAccion);
                        padre.appendChild(tfCodigo_fabricante);
                        padre.submit();
                    }
                </script>
    </body>
</html>
