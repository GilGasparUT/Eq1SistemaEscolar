package servlets;

import beans.Alumno;
import dao.DAOAlumno;
import java.io.IOException;
//import java.util.ArrayList;
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
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        mostrar = "/vistas/mostrar.jsp";
        nuevo = "/vistas/nuevo.jsp";
        editar = "/vistas/editar.jsp";
        
        accion = request.getParameter("accion");
        
        if(accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            alumno = new Alumno();
            alumno.setMatricula(request.getParameter("tfMatricula"));
            alumno.setNombre(request.getParameter("tfNombre"));
            alumno.setApellidos(request.getParameter("tfApellidos"));
            alumno.setDwi(Integer.parseInt(request.getParameter("tfDwi")));
            alumno.setCjv(Integer.parseInt(request.getParameter("tfDwi")));
            alumno.setEcbd(Integer.parseInt(request.getParameter("tfEcbd")));
            
            daoAlumno = new DAOAlumno();
            daoAlumno.agregar(alumno);
            
            acceso = mostrar;
        }
        
        
        
        else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("matricula", request.getParameter("matricula"));
            acceso = editar;
            
        }
        
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            
            alumno = new Alumno();
            String matriculaOld = request.getParameter("tfMatriculaOld");
            alumno.setMatricula(request.getParameter("tfMatricula"));
            alumno.setNombre   (request.getParameter("tfNombre"));
            alumno.setApellidos(request.getParameter("tfApellidos"));
            alumno.setDwi      (Integer.parseInt(request.getParameter("tfDwi")));
            alumno.setCjv      (Integer.parseInt(request.getParameter("tfCjv")));
            alumno.setEcbd     (Integer.parseInt(request.getParameter("tfEcbd")));
            
            daoAlumno = new DAOAlumno();
            daoAlumno.actualizar(alumno, matriculaOld);
            
            acceso = mostrar;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String matricula = request.getParameter("matricula");
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
