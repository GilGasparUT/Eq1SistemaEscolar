<%-- 
    Document   : index
    Created on : 18/06/2022, 08:09:57 AM
    Author     : adrian
--%>

<%@page import="beans.Alumno"%>

<%@page import="java.text.DecimalFormat"%>


<%!
    Alumno alum[]=new Alumno[10];
    int contador=0;
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilos.css">
    <title>Document</title>
</head>
<body>
    <h1>Sistema de Alumnos</h1> 
    <form action="index.jsp" method="POST">
        <table border="0">
            <thead>
                <tr>
                    <th>Matricula</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>CJV</th>
                    <th>DWI</th>
                    <th>ECBD</th>
                    <th>Opcion</th>
                </tr>
            </thead>
            <tbody >
                <tr>
                  <td><input type="text" id= "matricula" name="tfMatricula" value="" size="11"/></td>
                  <td><input type="text" name="tfNombre" value="" size="15"/></td>
                  <td><input type="text" name="tfApellidos" value="" size="15"/></td>
                  <td><input type="text" name="tfCjv" value="" size="2"/></td>
                  <td><input type="text" name="tfDwi" value="" size="2"/></td>
                  <td><input type="text" name="tfEcbd" value="" size="2"/></td>
                  <td><input type="submit" name="btnRegistrar" value="Registrar" size="2"/></td>
                </tr>
            </tbody>
        </table>
    </form>
    <br>
                
              <% 
                 if (request.getParameter("btnRegistrar")!=null)
                     // contador
                 {
                   alum[contador]=new Alumno();
                  /*matricula  = request.getParameter("tfMatricula");*/
                   alum[contador].setMatricula(request.getParameter("tfMatricula"));
                   //nombre     =request.getParameter("tfNombre");
                   alum[contador].setNombre(request.getParameter("tfNombre"));
                   //apellidos  =request.getParameter("tfApellidos");
                   alum[contador].setApellidos(request.getParameter("tfApellidos"));
                   //dwi        =Integer.parseInt(request.getParameter("tfDwi"));
                   alum[contador].setDwi(Integer.parseInt(request.getParameter("tfDwi")));
                   //cjv        =Integer.parseInt(request.getParameter("tfCjv"));
                   alum[contador].setCjv(Integer.parseInt(request.getParameter("tfCjv")));
                   //ecbd       =Integer.parseInt(request.getParameter("tfEcbd"));
                   alum[contador].setEcbd(Integer.parseInt(request.getParameter("tfEcbd")));
                   //prom       =(cjv+dwi+ecbd)/3.0;
                   alum[contador].calcularProm();
                   contador++;
                   
                  
                   
                 
                 
                 }
              %>

   
    
       <table  id="tabla"  border="1" align="center">
            <thead>
                <tr>
                    <th>MATRICULA</th>
                    <th>NOMBRE DEL ALUMNO</th>
                    <th>DWI</th>
                    <th>CJV</th>
                    <th>ECDB</th>
                    <th>PROM</th>
                </tr>
            </thead>
           
    
           <%for (int j=0; j<contador;j++)
          {%>
       
            
        
            <tbody >
                <tr>
                 <td> <%=alum[j].getMatricula()%></td>
                 <td> <%=alum[j].getNombre()%><%= alum[j].getApellidos()%> </td> 
                 <td> <%=alum[j].getDwi()%></td>
                 <td> <%=alum[j].getCjv()%></td>
                 <td> <%=alum[j].getEcbd()%></td>
                 <td> <%=alum[j].calcularProm()%></td>
               </tr>
            </tbody>
 
   <% } %> 
  

            
        </table>
        
         
</body>
</html>