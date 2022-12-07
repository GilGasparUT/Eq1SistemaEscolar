package servlets;


import beans.Asignacion;
import dao.DAOAsignacion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SAsignacion extends HttpServlet 
{
private String mostrar;
private String nuevo;
private String editar;

private String accion;
private String acceso;

private Asignacion asignacion;
private DAOAsignacion daoAsignacion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
       response.setContentType("text/html;charset=UTF-8");
      
        mostrar = "vistas/asignaciones/mostrar.jsp";
        nuevo   = "vistas/asignaciones/nuevo.jsp";
        editar  = "vistas/asignaciones/editar.jsp";
        
        accion = request.getParameter("tfAccion");
        
         if(request.getParameter("btnBuscar")!=null)
        {
            request.setAttribute("claveEmpleado", request.getParameter("tfClaveEmpleado"));
        }
        
        if (accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
       else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            asignacion = new Asignacion();
            asignacion.setClaveasignacion(request.getParameter("tfClaveAsignacion"));
            asignacion.setClaveempleado(request.getParameter("tfClaveEmpleado"));
            asignacion.setClavemat(request.getParameter("tfClaveMat"));
            asignacion.setClavegrupo(request.getParameter("tfClaveGrupo"));
            daoAsignacion = new DAOAsignacion();
            daoAsignacion.agregar(asignacion);
            
            acceso = mostrar;
        }
        
         else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("claveasignacion", request.getParameter("tfClaveAsignacion"));
            acceso = editar;
            
        }
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            asignacion = new Asignacion();
            String claveasignacionOld = request.getParameter("tfClaveAsignacionOld");
            asignacion.setClaveasignacion(request.getParameter("tfClaveAsignacion"));
            asignacion.setClaveempleado(request.getParameter("tfClaveEmpleado"));
            asignacion.setClavemat(request.getParameter("tfClaveMat"));
            asignacion.setClavegrupo(request.getParameter("tfClaveGrupo"));
            
            daoAsignacion = new DAOAsignacion();
            daoAsignacion.actualizar(asignacion,claveasignacionOld);
            
            acceso = mostrar;
        }    
        
        else if (accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String claveasignacion = request.getParameter("tfClaveAsignacion");
            daoAsignacion = new DAOAsignacion();
            daoAsignacion.eliminar(claveasignacion);
            
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
