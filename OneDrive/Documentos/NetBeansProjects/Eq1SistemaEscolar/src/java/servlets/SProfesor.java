package servlets;


import beans.Profesor;
import dao.DAOProfesor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SProfesor extends HttpServlet 
{
private String mostrar;
private String nuevo;
private String editar;

private String accion;
private String acceso;

private Profesor profesor;
private DAOProfesor daoProfesor;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
       response.setContentType("text/html;charset=UTF-8");

        mostrar = "vistas/profesores/mostrar.jsp";
        nuevo   = "vistas/profesores/nuevo.jsp";
        editar  = "vistas/profesores/editar.jsp";

        accion = request.getParameter("tfAccion");
        
        if(request.getParameter("btnBuscar")!=null)
        {
            request.setAttribute("claveCarrera", request.getParameter("tfClaveCarrera"));
            request.setAttribute("atrCarrera", request.getParameter("tfClaveCarrera"));

        }

        if (accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }

       else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            profesor = new Profesor();
            profesor.setClaveempleado(request.getParameter("tfClaveEmpleado"));
            profesor.setApellidos(request.getParameter("tfApellidos"));
            profesor.setNombre(request.getParameter("tfNombre"));
            profesor.setClavecarrera(request.getParameter("tfClaveCarrera"));
            
            daoProfesor = new DAOProfesor();
            daoProfesor.agregar(profesor);

            acceso = mostrar;
        }

         else if(accion != null && accion.equalsIgnoreCase("editar"))
        {

            request.setAttribute("claveempleado", request.getParameter("tfClaveEmpleado"));
            acceso = editar;

        }

        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            profesor = new Profesor();
            String claveempleadoOld = request.getParameter("tfClaveEmpleadoOld");
            profesor.setClaveempleado(request.getParameter("tfClaveEmpleado"));
            profesor.setApellidos(request.getParameter("tfApellidos"));
            profesor.setNombre(request.getParameter("tfNombre"));
            profesor.setClavecarrera(request.getParameter("tfClaveCarrera"));

            daoProfesor = new DAOProfesor();
            daoProfesor.actualizar(profesor,claveempleadoOld);

            acceso = mostrar;
        }    

        else if (accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String claveempleado = request.getParameter("tfClaveEmpleado");
            daoProfesor = new DAOProfesor();
            daoProfesor.eliminar(claveempleado);

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
