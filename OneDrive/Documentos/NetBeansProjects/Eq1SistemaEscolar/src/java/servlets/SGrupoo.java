package servlets;

import beans.Grupo;
import dao.DAOGrupo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SGrupoo extends HttpServlet 
{

    private String mostrar;
    private String nuevo;
    private String editar;
    
    private String accion;
    private String acceso;
    
    private Grupo grupo;
    private DAOGrupo daoGrupo;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         response.setContentType("text/html;charset=UTF-8");
        
        mostrar = "vistas/grupos/mostrar.jsp";
        nuevo   = "vistas/grupos/nuevo.jsp";
        editar  = "vistas/grupos/editar.jsp";
        
        accion = request.getParameter("tfAccion");
        
        if(accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            grupo = new Grupo();
            grupo.setClavegrupo(request.getParameter("tfClaveGrupo"));
            grupo.setSemestre(request.getParameter("tfSemestre"));
            grupo.setLetra(request.getParameter("tfLetra"));
            grupo.setYear(request.getParameter("tfYear"));
            grupo.setTurno(request.getParameter("tfTurno"));
            grupo.setClavecarrera(request.getParameter("tfClaveCarrera"));

            daoGrupo = new DAOGrupo();
            daoGrupo.agregar(grupo);
            
            acceso = mostrar;
        }
        
        
        
        else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("claveg", request.getParameter("tfClaveG"));
            acceso = editar;
            
        }
        
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            
            grupo = new Grupo();
            String clavegrupoOld = request.getParameter("tfClaveGrupoGOld");
            grupo.setClavegrupo(request.getParameter("tfClaveG"));
            grupo.setSemestre(request.getParameter("tfSemestre"));
            grupo.setLetra(request.getParameter("tfLetra"));
            grupo.setYear(request.getParameter("tfYear"));
            grupo.setTurno(request.getParameter("tfTurno"));
            grupo.setClavecarrera(request.getParameter("tfClaveCarrera"));
              
            daoGrupo= new DAOGrupo();
            daoGrupo.actualizar(grupo, clavegrupoOld);
            
            acceso = mostrar;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String clavegrupo = request.getParameter("tfClaveGrupo");
            daoGrupo = new DAOGrupo();
            daoGrupo.eliminar(clavegrupo);
            
            acceso = mostrar;
        }
        else
        {
            acceso = mostrar;
        }
        
       request.getRequestDispatcher(acceso).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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