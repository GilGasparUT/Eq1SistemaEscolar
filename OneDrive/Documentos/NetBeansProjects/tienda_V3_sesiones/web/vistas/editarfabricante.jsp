<%@page import="dao.DAOFabricante"%>
<%@page import="beans.Fabricante"%>
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
    <title>EditarFabricante</title>
    
</head>
        <div id="container">
            <%@include file="header.jsp"%>
        </div>

   
    
              <% 
                    DAOFabricante dao    = new DAOFabricante();
                    Fabricante fabricante    = new Fabricante();
                    String codigo_fabricante = request.getAttribute("codigo_fabricante").toString();
                    fabricante         = dao.buscar(codigo_fabricante);
              %>
              
        <div>
            <h1>Editar_Fabricante</h1>
            <a id= "btnRegresar" href="SFabricante">Regresar</a>
            <form action="SFabricante" method="POST">
            <table>
                <thead>
                    <tr>
                       
                        <th>Codigo_Fabricante</th>
                        <th>Nombre</th>
                        <th>RFC</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <input type = "hidden" name ="tfCodigo_fabricanteOld" value="<%=fabricante.getCodigo_fabricante()%>">
                        
                        <td><input type="text"   name="tfCodigo_fabricante"       value="<%=fabricante.getCodigo_fabricante()%>"    size="11" maxlength="11"/></td>
                        <td><input type="text"   name="tfNombre"                  value="<%=fabricante.getNombre()%>"           size="15"                 /></td>
                        <td><input type="text"   name="tfRFC"                     value="<%=fabricante.getRFC()%>"        size="15"                    /></td>
                        <td><input type="submit" name="tfAccion"           value="Actualizar"/></td>  
                        <td><a href="SFabricante"> <button>Regresar </button></a></td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       

</html>
