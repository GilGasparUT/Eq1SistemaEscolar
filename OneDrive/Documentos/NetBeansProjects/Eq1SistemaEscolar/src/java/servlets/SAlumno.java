package servlets;

import beans.Alumno;
import dao.DAOAlumno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SAlumno extends HttpServlet 
{
private String mostrar;
private String nuevo;
private String editar;

private String accion;
private String acceso;

private Alumno alumno;
private DAOAlumno daoAlumno;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
       response.setContentType("text/html;charset=UTF-8");
      
        mostrar = "vistas/alumnos/mostrar.jsp";
        nuevo   = "vistas/alumnos/nuevo.jsp";
        editar  = "vistas/alumnos/editar.jsp";
        
        accion = request.getParameter("tfAccion");
        
        if(request.getParameter("btnBuscar")!=null)
        {
            request.setAttribute("claveCarrera", request.getParameter("tfClaveCarrera"));
            request.setAttribute("atrCarrera", request.getParameter("tfClaveCarrera"));
        }
        
       else if (accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
       else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            alumno = new Alumno();
            alumno.setMatricula(request.getParameter("tfMatricula"));
            alumno.setYear(request.getParameter("tfYear"));
            alumno.setCurp(request.getParameter("tfCURP"));
            alumno.setApellidos(request.getParameter("tfApellidos"));
            alumno.setNombre(request.getParameter("tfNombre"));
            alumno.setFechanac(request.getParameter("tfFechaNac"));
            alumno.setSexo(request.getParameter("tfSexo"));
            alumno.setClavecarrera(request.getParameter("tfClaveCarrera"));
            
            daoAlumno = new DAOAlumno();
            daoAlumno.agregar(alumno);
            
            acceso = mostrar;
        }
        
         else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("matricula", request.getParameter("tfMatricula"));
            
            acceso = editar;
            
        }
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            alumno = new Alumno();
            String matriculaOld = request.getParameter("tfMatriculaOld");
            alumno.setMatricula(request.getParameter("tfMatricula"));
            alumno.setYear(request.getParameter("tfYear"));
            alumno.setCurp(request.getParameter("tfCURP"));
            alumno.setApellidos(request.getParameter("tfApellidos"));
            alumno.setNombre(request.getParameter("tfNombre"));
            alumno.setFechanac(request.getParameter("tfFechaNac"));
            alumno.setSexo(request.getParameter("tfSexo"));
            alumno.setClavecarrera(request.getParameter("tfClaveCarrera"));
            
            daoAlumno = new DAOAlumno();
            daoAlumno.actualizar(alumno,matriculaOld);
            
            acceso = mostrar;
        }    
        
        else if (accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String matricula = request.getParameter("tfMatricula");
            daoAlumno = new DAOAlumno();
            daoAlumno.eliminar(matricula);
            
            acceso = mostrar;
        } 
        
        else 
        {
            acceso = mostrar;
        }
        
        request.getRequestDispatcher(acceso).forward(request, response);  
}
    

 @Override
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
          processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
