

<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOAlumno"%>
<%@page import="beans.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/estilos.css">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Alumnos IDGS</h1>
        <div>
            <a href="SAlumno?accion=nuevo"><button>Nuevo</button>  </a>
        </div>
        
        <div>
        <table border="1">
                <thead>
                    <tr>
                        <th>Matricula</th>
                        <th>Nombre Completo</th>
                        <th>DDI</th>
                        <th>DWI</th>
                        <th>ECBD</th> 
                        <th>PROM</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    DAOAlumno daoAlumno = new DAOAlumno();
                    ArrayList<Alumno> lista = daoAlumno.mostrar();
                    for(int i=0; i<lista.size(); i++)
                    {
                     Alumno alumno=new Alumno();
                     alumno = lista.get(i);
                    %>
                    <tr>
                        <td><%=alumno.getMatricula()%></td>
                        <td><%=alumno.getNombre()%>&nbsp;<%=alumno.getApellidos()%></td>
                        <td><%=alumno.getDwi()%></td>
                        <td><%=alumno.getCjv()%></td>
                        <td><%=alumno.getEcbd()%></td>
                        <td><%=alumno.calcularProm()%></td>
                        <td><a href="SAlumno?accion=editar&matricula=<%=alumno.getMatricula()%>"><button>Editar</button></a></td>
                        <td><a href="SAlumno?accion=eliminar&matricula=<%=alumno.getMatricula()%>"><button>Eliminar</button></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
