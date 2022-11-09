package servlets;

import beans.Inscripcion;
import dao.DAOInscripcion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SInscripcion extends HttpServlet 
{
private String mostrar;
private String nuevo;
private String editar;

private String accion;
private String acceso;

private Inscripcion inscripcion;
private DAOInscripcion daoInscripcion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
       response.setContentType("text/html;charset=UTF-8");
      
        mostrar = "vistas/inscripciones/mostrar.jsp";
        nuevo = "vistas/inscripciones/nuevo.jsp";
        editar = "vistas/inscripciones/editar.jsp";
        
        accion = request.getParameter("tfAccion");
        
        if (accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
       else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            inscripcion = new Inscripcion();
            inscripcion.setClaveinscripcion(request.getParameter("tfClaveInscripcion"));
            inscripcion.setFechainscripcion(request.getParameter("tfFechaInscripcion"));
            inscripcion.setClavegrupo(request.getParameter("tfClaveGrupo"));
            inscripcion.setMatricula(request.getParameter("tfMatricula"));
            
            daoInscripcion = new DAOInscripcion();
            daoInscripcion.agregar(inscripcion);
            
            acceso = mostrar;
        }
        
         else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("claveinscripcion", request.getParameter("tfClaveInscripcion"));
            acceso = editar;
            
        }
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            inscripcion = new Inscripcion();
            String claveinscripcionOld = request.getParameter("tfClaveInscripcionOld");
            inscripcion.setClaveinscripcion(request.getParameter("tfClaveInscripcion"));
            inscripcion.setFechainscripcion(request.getParameter("tfFechaInscripcion"));
            inscripcion.setClavegrupo(request.getParameter("tfClaveGrupo"));
            inscripcion.setMatricula(request.getParameter("tfMatricula"));
            
            daoInscripcion = new DAOInscripcion();
            daoInscripcion.actualizar(inscripcion,claveinscripcionOld);
            
            acceso = mostrar;
        }    
        
        else if (accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String claveinscripcion = request.getParameter("tfClaveInscripcion");
            daoInscripcion = new DAOInscripcion();
            daoInscripcion.eliminar(claveinscripcion);
            
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
