package servlets;

import beans.Materia;
import dao.DAOMateria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SMateria extends HttpServlet {
private String mostrar;
private String nuevo;
private String editar;

private String accion;
private String acceso;

private Materia materia;
private DAOMateria daoMateria;

     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
     {
        response.setContentType("text/html;charset=UTF-8");
        
        mostrar = "vistas/materias/mostrar.jsp";
        nuevo   = "vistas/materias/nuevo.jsp";
        editar  = "vistas/materias/editar.jsp";
        
        accion = request.getParameter("tfAccion");
        
        if (accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
       else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            materia = new Materia();
            materia.setClavemat(request.getParameter("tfClaveMat"));
            materia.setMateria(request.getParameter("tfMateria"));
            materia.setSemestre(request.getParameter("tfSemestre"));
            materia.setClavecarrera(request.getParameter("tfClaveCarrera"));
         
            
            daoMateria = new DAOMateria();
            daoMateria.agregar(materia);
            
            acceso = mostrar;
        }
        
         else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("clavemat", request.getParameter("tfClaveMat"));
            acceso = editar;
            
        }
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            
            materia = new Materia();
            String clavematOld = request.getParameter("tfClaveMatOld");
            materia.setClavemat(request.getParameter("tfClaveMat"));
            materia.setMateria(request.getParameter("tfMateria"));
            materia.setSemestre(request.getParameter("tfSemestre"));
            materia.setClavecarrera(request.getParameter("tfClaveCarrera"));

            
            daoMateria = new DAOMateria();
            daoMateria.actualizar(materia, clavematOld);
            
            acceso = mostrar;
        }    
        
        else if (accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String clavemat = request.getParameter("tfClaveMat");
            daoMateria = new DAOMateria();
            daoMateria.eliminar(clavemat);
            
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
