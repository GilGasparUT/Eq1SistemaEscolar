<%@page import="dao.DAOAlumno"%>
<%@page import="servlets.SAlumno"%>
<%@page import="beans.Alumno"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vistas/estilos.css">
    <title>editar</title>
</head>
    </head>
    <body>
              <% 
                    DAOAlumno dao    = new DAOAlumno();
                    Alumno alumno    = new Alumno();
                    String matricula = request.getAttribute("matricula").toString();
                    alumno           = dao.buscar(matricula);
              %>
        <div>
            <h1>Editar_Alumno_IDGS</h1>
            <form action="SAlumno" method="POST">
            <table>
                <thead>
                    <tr>
                       
                        <th>Matricula</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>DDI</th>
                        <th>DWI</th>
                        <th>ECBD</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <input type = "hidden" name ="tfMatriculaOld" value="<%=alumno.getMatricula()%>">
                        
                        <td><input type="text"   name="tfMatricula"   value="<%=alumno.getMatricula()%>"  size="11" maxlength="11"/></td>
                        <td><input type="text"   name="tfNombre"      value="<%=alumno.getNombre()%>"     size="15"               /></td>
                        <td><input type="text"   name="tfApellidos"   value="<%=alumno.getApellidos()%>"  size="15"               /></td>
                        <td><input type="text"   name="tfDwi"         value="<%=alumno.getDwi()%>"        size="2"                /></td>
                        <td><input type="text"   name="tfCjv"         value="<%=alumno.getCjv()%>"        size="2"                /></td>
                        <td><input type="text"   name="tfEcbd"        value="<%=alumno.getEcbd()%>"       size="2"                /></td>
                        <td><input type="submit" name="accion"        value="Actualizar"                                             /></td>  
                        <td><a     href="SAlumno"> <button>Regresar </button>                                                                   </a></td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
</body>
</html>
