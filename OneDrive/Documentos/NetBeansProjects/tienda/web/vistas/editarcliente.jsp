<%@page import="beans.Cliente"%>
<%@page import="dao.DAOCliente"%>
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
                    DAOCliente dao    = new DAOCliente();
                    Cliente cliente    = new Cliente();
                    String id_cliente = request.getAttribute("id_cliente").toString();
                    cliente          = dao.buscar(id_cliente);
              %>
              
        <div>
            <h1>Editar_Cliente</h1>
            <form action="SCliente" method="POST">
            <table>
                <thead>
                    <tr>
                       
                        <th>Id_cliente</th>
                        <th>RFC</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Telefono</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <input type = "hidden" name ="tfId_clienteOld" value="<%=cliente.getId_cliente()%>">
                        
                        <td><input type="text"   name="tfId_cliente"     value="<%=cliente.getId_cliente()%>"    size="11" maxlength="11"/></td>
                        <td><input type="text"   name="tfRFC"            value="<%=cliente.getRFC()%>"           size="15"               /></td>
                        <td><input type="text"   name="tfNombre"         value="<%=cliente.getNombre()%>"        size="15"               /></td>
                        <td><input type="text"   name="tfApellidos"      value="<%=cliente.getApellidos()%>"     size="30"                /></td>
                        <td><input type="text"   name="tfTelefono"       value="<%=cliente.getTelefono()%>"      size="10"                /></td>
                        <td><input type="submit" name="accion"           value="Actualizar"                                             /></td>  
                        <td><a     href="SCliente"> <button>Regresar </button></a></td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       

</html>
