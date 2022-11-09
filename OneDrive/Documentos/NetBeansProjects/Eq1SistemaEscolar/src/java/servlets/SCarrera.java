package servlets;


import beans.Carrera;
import dao.DAOCarrera;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SCarrera extends HttpServlet 
{
private String mostrar;
private String nuevo;
private String editar;

private String accion;
private String acceso;

private Carrera carrera;
private DAOCarrera daoCarrera;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
       response.setContentType("text/html;charset=UTF-8");

        mostrar = "vistas/carreras/mostrar.jsp";
        nuevo   = "vistas/carreras/nuevo.jsp";
        editar  = "vistas/carreras/editar.jsp";

        accion = request.getParameter("tfAccion");

        if (accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }

       else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            carrera = new Carrera();
            carrera.setClavecarrera(request.getParameter("tfClaveCarrera"));
            carrera.setCarrera(request.getParameter("tfCarrera"));
            
            daoCarrera = new DAOCarrera();
            daoCarrera.agregar(carrera);

            acceso = mostrar;
        }

         else if(accion != null && accion.equalsIgnoreCase("editar"))
        {

            request.setAttribute("clavecarrera", request.getParameter("tfClaveCarrera"));
            acceso = editar;

        }

        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            carrera = new Carrera();
            String clavecarreraOld = request.getParameter("tfClaveCarreraOld");
            carrera.setClavecarrera(request.getParameter("tfClaveCarrera"));
            carrera.setCarrera(request.getParameter("tfCarrera"));

            daoCarrera = new DAOCarrera();
            daoCarrera.actualizar(carrera,clavecarreraOld);

            acceso = mostrar;
        }    

        else if (accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String clavecarrera = request.getParameter("tfClaveCarrera");
            daoCarrera = new DAOCarrera();
            daoCarrera.eliminar(clavecarrera);

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
