package servlet;

import beans.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


   
public class Procesar extends HttpServlet
{
     
   
    Alumno alum[]=new Alumno[10];
    int contador=0;
   
                
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
          response.setContentType("text/html;charset=UTF-8");
         {
             if (request.getParameter("btnRegistrar")!=null)
                    
                 {
                     alum[contador]=new Alumno();
            PrintWriter out = response.getWriter();
            
            alum[contador].setMatricula(request.getParameter("tfMatricula"));
            alum[contador].setNombre(request.getParameter("tfNombre"));
            alum[contador].setApellidos(request.getParameter("tfApellidos"));
            alum[contador].setDwi(Integer.parseInt(request.getParameter("tfDwi")));
            alum[contador].setCjv(Integer.parseInt(request.getParameter("tfCjv")));
            alum[contador].setEcbd(Integer.parseInt(request.getParameter("tfEcbd")));
            alum[contador].calcularProm();
            contador++;
            
             
            out.println();
           out.println("<link rel=\'stylesheet\' href=\'estilos.css\'>"
                     +"<h1>Sistema de Alumnos</h1>"
                     +"<th><button onClick=\"window.location.href='index.jsp';\">  \n"
                     +"AGREGAR NUEVO ALUMNO\n"
                     +"</button><br></th>"
                     +"<table>"
                     + "<thead>"
                     + "<tr>"
                     + "<th>MATRICULA</th>"
                     + "<th>NOMBRE DEL ALUMNO</th>"
                     + "<th>DWI</th>"
                     + "<th>CJV</th>"
                     + "<th>ECDB</th>"
                     + "<th>PROM</th>"
                     + "</tr>"
                     + "</thead>");
           
           
            for (int i=0; i<contador; i++)
            {
                out.println("<tbody>"
                           + "<tr>"
                           +"<td>" 
                           +      alum[i].getMatricula()
                           +"</td>"
                        
                           +"<td>" 
                           +      alum[i].getNombre()+alum[i].getApellidos()
                           +"</td>"
                                
                           +"<td>" 
                           +      alum[i].getDwi()
                           +"</td>"
                        
                           +"<td>" 
                           +      alum[i].getCjv()
                           +"</td>"
                        
                           +"<td>" 
                           +      alum[i].getEcbd()
                           +"</td>"
                        
                           +"<td>" 
                           +      alum[i].calcularProm()
                                                      
                           +"</td>"+"</tr>"+ "</tbody>");
               
                
                
            }
            
           }
            
        }
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
        //request.getRequestDispatcher("/index.jsp").forward(request, response);
         
       
       
        
        
        
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
