<%@page import="java.util.ArrayList"%>
<%@page import="beans.Cliente"%>
<%@page import="dao.DAOCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos.css">
        <title>Cliente</title>
    </head>
    <body>
        <h1>Listado_Clientes</h1>
        <div>
            <a href="SCliente?accion=nuevo"><button>Nuevo</button>  </a>
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
                        
                        <td><a href="SCliente?accion=editar&id_cliente=<%=cliente.getId_cliente()%>"><button>Editar</button></a></td>
                        <td><a href="SCliente?accion=eliminar&id_cliente=<%=cliente.getId_cliente()%>"><button>Eliminar</button></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
