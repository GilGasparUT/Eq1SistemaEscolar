package servlets;


import beans.Cliente;
import dao.DAOCliente;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SCliente extends HttpServlet 
{
    private String mostrar;
    private String nuevo;
    private String editar;
    
    private String accion;
    private String acceso;
    
    private Cliente cliente;
    private DAOCliente daoCliente;
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
       
        
        mostrar = "vistas/mostrarcliente.jsp";
        nuevo   = "vistas/nuevocliente.jsp";
        editar  = "vistas/editarcliente.jsp";
        
        accion = request.getParameter("accion");
        
        if(accion != null && accion.equalsIgnoreCase("nuevo"))
        {
            acceso = nuevo;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            cliente = new Cliente();
            cliente.setId_cliente(request.getParameter("tfId_cliente"));
            cliente.setRFC(request.getParameter("tfRFC"));
            cliente.setNombre(request.getParameter("tfNombre"));
            cliente.setApellidos(request.getParameter("tfApellidos"));
            cliente.setTelefono(request.getParameter("tfTelefono"));
            
            
            daoCliente = new DAOCliente();
            daoCliente.agregar(cliente);
            
            acceso = mostrar;
        }
        
        
        
        else if(accion != null && accion.equalsIgnoreCase("editar"))
        {
            
            request.setAttribute("id_cliente", request.getParameter("id_cliente"));
            acceso = editar;
            
        }
        
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            
            cliente = new Cliente();
            String id_clienteOld = request.getParameter("tfId_clienteOld");
            cliente.setId_cliente(request.getParameter("tfId_cliente"));
            cliente.setRFC(request.getParameter("tfRFC"));
            cliente.setNombre(request.getParameter("tfNombre"));
            cliente.setApellidos(request.getParameter("tfApellidos"));
            cliente.setTelefono(request.getParameter("tfTelefono"));
            
           
            
            daoCliente= new DAOCliente();
            daoCliente.actualizar(cliente, id_clienteOld);
            
            acceso = mostrar;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String id_cliente = request.getParameter("id_cliente");
            daoCliente = new DAOCliente();
            daoCliente.eliminar(id_cliente);
            
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
