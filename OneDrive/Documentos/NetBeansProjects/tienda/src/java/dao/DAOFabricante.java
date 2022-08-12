package dao;

import beans.Fabricante;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFabricante
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Fabricante fabricante;        
            
    public ArrayList mostrar()
    {
        ArrayList<Fabricante> listaFabricantes = new ArrayList<>();
        String sql = "SELECT * FROM fabricante";
            
        try 
        {
         
         
            con = ConexionMySQL.getConnection(); //Conectar a la BD
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); //ejecutar consulta y obtener resultados
            while(rs.next())
            {
                fabricante=new Fabricante();
                fabricante.setCodigo_fabricante(rs.getString("Codigo_fabricante"));
                fabricante.setNombre(rs.getString("Nombre"));
                fabricante.setRFC(rs.getString("RFC"));
                             
                listaFabricantes.add(fabricante);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOFabricante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaFabricantes;
    }
    
    public boolean agregar(Fabricante fabricante)
    {
        String sql = "INSERT INTO fabricante VALUES('" + 
                fabricante.getCodigo_fabricante() +"','"+
                fabricante.getNombre() +"','"+
                fabricante.getRFC() +"')";
        try 
        {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        
            ps.close();
            con.close();
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOFabricante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    public Fabricante buscar (String codigo_fabricante)
    {
        String sql = "SELECT * FROM fabricante WHERE Codigo_fabricante='"+codigo_fabricante+"'";
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                fabricante=new Fabricante();
                fabricante.setCodigo_fabricante(rs.getString("Codigo_fabricante"));
                fabricante.setNombre(rs.getString("Nombre"));
                fabricante.setRFC(rs.getString("RFC"));
     
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOFabricante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fabricante;
    }
   
    
   public boolean actualizar(Fabricante fabricante,String old)
    {
    String sql = "UPDATE fabricante SET "+
                 "Codigo_fabricante ='"+ fabricante.getCodigo_fabricante() +"', "+
                 "Nombre    ='"+ fabricante.getNombre()+"', "+
                 "RFC      ='"+ fabricante.getRFC()+"' " +
                 "WHERE Codigo_fabricante ='" + old + "'";
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
           
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOFabricante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
   
   

   public boolean eliminar(String codigo_fabricante)
    {
       String sql = "DELETE FROM fabricante WHERE Codigo_fabricante ='" + codigo_fabricante + "'";   
                 
       
       try 
        {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        
            ps.close();
            con.close();
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOFabricante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}