package dao;


import beans.Calificacion;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCalificacion
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Calificacion calificacion;
    
 public ArrayList mostrar()  
 {
     ArrayList<Calificacion> listaCalificaciones = new ArrayList<>();
     String sql = "SELECT * FROM calificaciones";
     
     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         calificacion=new Calificacion();
         calificacion.setClavecalificacion(rs.getString("ClaveCalificacion"));
         calificacion.setP1(rs.getString("P1"));
         calificacion.setP2(rs.getString("P2"));
         calificacion.setP3(rs.getString("P3"));
         calificacion.setExtra(rs.getString("Extra"));
         calificacion.setClaveasignacion(rs.getString("ClaveAsignacion"));
         calificacion.setClaveinscripcion(rs.getString("ClaveInscripcion"));
         
         listaCalificaciones.add(calificacion);
     }
     rs.close();
     ps.close();
     con.close();
     }
     
    catch (SQLException ex)
     {
     Logger.getLogger(DAOCalificacion.class.getName()).log(Level.SEVERE, null,ex);
     }
     
     return listaCalificaciones;
 }
 public boolean agregar(Calificacion calificacion)
    {
        String sql = "INSERT INTO calificaciones VALUES('" + calificacion.getClavecalificacion()+"','" +
                calificacion.getP1()+"','"+
                calificacion.getP2()+"','"+
                calificacion.getP3()+"','"+
                calificacion.getExtra()+"','"+
                calificacion.getClaveasignacion()+"','"+
                calificacion.getClaveinscripcion()+"')";
        
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
            Logger.getLogger(DAOCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
 
 public Calificacion buscar(String clavecalificacion)
 {
    String sql = "SELECT * FROM calificaciones WHERE ClaveCalificacion='"+clavecalificacion+"'";
        try 
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                calificacion = new Calificacion();
                calificacion.setClavecalificacion(rs.getString("ClaveCalificacion"));
                calificacion.setP1(rs.getString("P1"));
                calificacion.setP2(rs.getString("P2"));
                calificacion.setP3(rs.getString("P3"));
                calificacion.setExtra(rs.getString("Extra"));
                calificacion.setClaveasignacion(rs.getString("ClaveAsignacion"));
                calificacion.setClaveinscripcion(rs.getString("ClaveInscripcion"));
            }
            rs.close();
            ps.close();
            con.close();   
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
 return calificacion;
 }
 
 
 public boolean actualizar(Calificacion calificacion,String old)
    {
    String sql = "UPDATE calificaciones SET "+
                 "ClaveCalificacion = '" + calificacion.getClavecalificacion() + "', " +
                 "P1   = '" + calificacion.getP1()    + "', " +
                 "P2   = '" + calificacion.getP2()    + "', " +
                 "P3       = '"  + calificacion.getP3() + "',  " +
                 "Extra = '" + calificacion.getExtra() + "', " +
                 "ClaveAsignacion     = '"  + calificacion.getClaveasignacion() + "',  " +
                 "ClaveInscripcion = '"+ calificacion.getClaveinscripcion() +"' "+
                 "WHERE ClaveCalificacion = '" + old + "'";
    
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
            Logger.getLogger(DAOCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
 
 public boolean eliminar(String clavecalificacion)
 {
      String sql = "DELETE FROM calificaciones WHERE ClaveCalificacion = '" + clavecalificacion + "'";
     
        try 
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
     
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOCalificacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
    
     return true;
 }
 
}