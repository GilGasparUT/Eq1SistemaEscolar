package servlets;



import beans.Producto;
import dao.DAOProducto;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SProducto extends HttpServlet 
{
    private String mostrar;
    private String nuevo;
    private String editar;
    
    private String accion;
    private String acceso;
    
    private Producto producto;
    private DAOProducto daoProducto;
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        mostrar = "vistas/mostrarproducto.jsp";
        nuevo   = "vistas/nuevoproducto.jsp";
        editar  = "vistas/editarproducto.jsp";
        
        accion = request.getParameter("tfAccion");
        
        if(accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            producto = new Producto();
            producto.setCodigo_producto(request.getParameter("tfCodigo_producto"));
            producto.setNombre(request.getParameter("tfNombre"));
            producto.setPrecio(Double.parseDouble(request.getParameter("tfPrecio")));
            producto.setCodigo_fabricante(request.getParameter("tfCodigo_fabricante"));
            
            
            daoProducto = new DAOProducto();
            daoProducto.agregar(producto);
            
            acceso = mostrar;
        }
        
        
        
        else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("codigo_producto", request.getParameter("tfCodigo_producto"));
            acceso = editar;
            
        }
        
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            
            producto = new Producto();
            String codigo_productoOld = request.getParameter("tfCodigo_productoOld");
            producto.setCodigo_producto(request.getParameter("tfCodigo_producto"));
            producto.setNombre(request.getParameter("tfNombre"));
            producto.setPrecio(Double.parseDouble(request.getParameter("tfPrecio")));
            producto.setCodigo_fabricante(request.getParameter("tfCodigo_fabricante"));
                  
            
            daoProducto= new DAOProducto();
            daoProducto.actualizar(producto, codigo_productoOld);
            
            acceso = mostrar;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String codigo_producto = request.getParameter("tfCodigo_producto");
            daoProducto = new DAOProducto();
            daoProducto.eliminar(codigo_producto);
            
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
