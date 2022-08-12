package servlets;



import java.io.IOException;
import beans.Fabricante;
import dao.DAOFabricante;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SFabricante extends HttpServlet 
{
    private String mostrar;
    private String nuevo;
    private String editar;
    
    private String accion;
    private String acceso;
    
    private Fabricante fabricante;
    private DAOFabricante daoFabricante;
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        mostrar = "vistas/mostrarfabricante.jsp";
        nuevo = "vistas/nuevofabricante.jsp";
        editar = "vistas/editarfabricante.jsp";
        
        accion = request.getParameter("accion");
        
        if(accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            fabricante = new Fabricante();
            fabricante.setCodigo_fabricante(request.getParameter("tfCodigo_fabricante"));
            fabricante.setNombre(request.getParameter("tfNombre"));
            fabricante.setRFC(request.getParameter("tfRFC"));
        
            daoFabricante = new DAOFabricante();
            daoFabricante.agregar(fabricante);
            
            acceso = mostrar;
        }
        
        
        
        else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("codigo_fabricante", request.getParameter("codigo_fabricante"));
            acceso = editar;
            
        }
        
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            
            fabricante = new Fabricante();
            String codigo_fabricanteOld = request.getParameter("tfCodigo_fabricanteOld");
            fabricante.setCodigo_fabricante(request.getParameter("tfCodigo_fabricante"));
            fabricante.setRFC(request.getParameter("tfRFC"));
            fabricante.setNombre(request.getParameter("tfNombre"));
            
        
            daoFabricante= new DAOFabricante();
            daoFabricante.actualizar(fabricante, codigo_fabricanteOld);
            
            acceso = mostrar;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String codigo_fabricante = request.getParameter("codigo_fabricante");
            daoFabricante = new DAOFabricante();
            daoFabricante.eliminar(codigo_fabricante);
            
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
