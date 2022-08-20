<%@page import="java.util.ArrayList"%>
<%@page import="beans.Cliente"%>
<%@page import="dao.DAOCliente"%>
<%@page import="servlets.SVista"%>
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
        
        <title>MostrarCliente</title>
    </head>
    <body>
        <div id="container">
            <%@include file="header.jsp"%>
        </div>
        
        <form id="frmCliente" action="SCliente" method="POST">
            
            <h1>Listado_Clientes</h1>
            
            <div id="nuevocliente">
            <!---<a href="SCliente?accion=nuevo"><button>Nuevo</button>  </a>-->
            <a href="#" onclick="procesar('nuevo','')"><button>Nuevo</button></a>
           
           </div>
            
             <div>
                <table border="1">
                <thead>
                    <tr>
                        <th>Id_cliente</th>
                        <th>RFC</th>
                        <th>Nombre Completo</th>
                        <th>Telefono</th>
                        
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    DAOCliente daoCliente = new DAOCliente();
                    ArrayList<Cliente> lista = daoCliente.mostrar();
                    for(int i=0; i<lista.size(); i++)
                    {
                     Cliente cliente=new Cliente();
                     cliente = lista.get(i);
                    %>
                    <tr>
                        <td><%=cliente.getId_cliente()%></td>
                        <td><%=cliente.getRFC()%></td>
                        <td><%=cliente.getNombre()%>&nbsp;<%=cliente.getApellidos()%></td>
                        <td><%=cliente.getTelefono()%></td>
                        
                        <td>
                            <a href="#" onclick="procesar('editar','<%=cliente.getId_cliente()%>')"><button>Editar</button></a>
                            <%-- <a href="SCliente?accion=editar&id_cliente=<%=cliente.getId_cliente()%>"><button>Editar</button></a> --%>
                        </td>
                        
                        <td>
                            <a href="#" onclick="procesar('eliminar','<%=cliente.getId_cliente()%>')"><button>Eliminar</button></a>
                            <%--<a href="SCliente?accion=eliminar&id_cliente=<%=cliente.getId_cliente()%>"><button>Eliminar</button></a>--%>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        </form>
        
        
       
                <script>
                    function procesar(accion, id_cliente)
                    {
                        var tfAccion   = document.createElement("input");
                        tfAccion.name  = "tfAccion";
                        tfAccion.type   = "hidden";
                        tfAccion.value = accion;
                        
                        var tfId_cliente = document.createElement("input");
                        tfId_cliente.name= "tfId_cliente";
                        tfId_cliente.type="hidden";
                        tfId_cliente.value = id_cliente;
                        
                        var padre =  document.getElementById("frmCliente");
                        padre.appendChild(tfAccion);
                        padre.appendChild(tfId_cliente);
                        padre.submit();
                    }
                </script>
    </body>
</html>
