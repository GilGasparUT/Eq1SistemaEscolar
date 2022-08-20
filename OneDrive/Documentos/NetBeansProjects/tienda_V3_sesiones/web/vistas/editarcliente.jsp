
<%@page import="beans.Cliente"%>
<%@page import="dao.DAOCliente"%>

<!DOCTYPE html>

<%  String usuario = (String) request.getSession().getAttribute("usuario");
    if (usuario==null)
    response.sendRedirect("SIndex");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vistas/estilos.css">
    
    <title>EditarCLiente</title>
    
 </head>
   
    <body>
        <div id="container">
            <%@include file="header.jsp"%>
        </div>
              <% 
                    DAOCliente dao    = new DAOCliente();
                    Cliente cliente    = new Cliente();
                    String id_cliente = request.getAttribute("id_cliente").toString();
                    cliente           = dao.buscar(id_cliente);
              %>
        <div>
            <h1>Editar_Cliente</h1>
            <a id= "btnRegresar" href="SCliente">Regresar</a>
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
                        <input type = "hidden" name ="tfId_clienteOld" value="<%=cliente.getId_cliente()%>">
                        
                        <td><input type="text"   name="tfId_cliente"  value="<%=cliente.getId_cliente()%>"  size="5" maxlength="11"/></td>
                        <td><input type="text"   name="tfRFC"         value="<%=cliente.getRFC()%>"         size="15"               /></td>
                        <td><input type="text"   name="tfNombre"      value="<%=cliente.getNombre()%>"      size="20"               /></td>
                        <td><input type="text"   name="tfApellidos"   value="<%=cliente.getApellidos()%>"   size="25"                /></td>
                        <td><input type="text"   name="tfTelefono"    value="<%=cliente.getTelefono()%>"    size="15"                /></td>
                        
                        <td><input type="submit" name="tfAccion"        value="Actualizar"                                             /></td>  
                        <td><a     href="SCliente"> <button>Regresar </button>                                                                   </a></td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
</body>
</html>

