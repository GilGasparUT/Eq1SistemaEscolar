package servlets;


import beans.Calificacion;
import dao.DAOCalificacion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SCalificacion extends HttpServlet 
{
private String mostrar;
private String nuevo;
private String editar;

private String accion;
private String acceso;

private Calificacion calificacion;
private DAOCalificacion daoCalificacion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
       response.setContentType("text/html;charset=UTF-8");
      
        mostrar = "vistas/calificaciones/mostrar.jsp";
        nuevo   = "vistas/calificaciones/nuevo.jsp";
        editar  = "vistas/calificaciones/editar.jsp";
        
        accion = request.getParameter("tfAccion");
        
        if(request.getParameter("btnBuscar")!=null)
        {
            request.setAttribute("claveInscripcion", request.getParameter("tfClaveInscripcion"));
        }
        
        if (accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
       else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            calificacion = new Calificacion();
            calificacion.setClavecalificacion(request.getParameter("tfClaveCalificacion"));
            calificacion.setP1(request.getParameter("tfP1"));
            calificacion.setP2(request.getParameter("tfP2"));
            calificacion.setP3(request.getParameter("tfP3"));
            calificacion.setExtra(request.getParameter("tfExtra"));
            calificacion.setClaveasignacion(request.getParameter("tfClaveAsignacion"));
            calificacion.setClaveinscripcion(request.getParameter("tfClaveInscripcion"));
            
            daoCalificacion = new DAOCalificacion();
            daoCalificacion.agregar(calificacion);
            
            acceso = mostrar;
        }
        
         else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("clavecalificacion", request.getParameter("tfClaveCalificacion"));
            acceso = editar;
            
        }
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            calificacion = new Calificacion();
            String clavecalificacionOld = request.getParameter("tfClaveCalificacionOld");
            calificacion.setClavecalificacion(request.getParameter("tfClaveCalificacion"));
            calificacion.setP1(request.getParameter("tfP1"));
            calificacion.setP2(request.getParameter("tfP2"));
            calificacion.setP3(request.getParameter("tfP3"));
            calificacion.setExtra(request.getParameter("tfExtra"));
            calificacion.setClaveasignacion(request.getParameter("tfClaveAsignacion"));
            calificacion.setClaveinscripcion(request.getParameter("tfClaveInscripcion"));
            
            daoCalificacion = new DAOCalificacion();
            daoCalificacion.actualizar(calificacion,clavecalificacionOld);
            
            acceso = mostrar;
        }    
        
        else if (accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String clavecalificacion = request.getParameter("tfClaveCalificacion");
            daoCalificacion = new DAOCalificacion();
            daoCalificacion.eliminar(clavecalificacion);
            
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
