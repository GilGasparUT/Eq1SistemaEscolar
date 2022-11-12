package dao;

import beans.Inscripcion;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOInscripcion 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Inscripcion inscripcion;
    
 public ArrayList mostrar()  
 {
     ArrayList<Inscripcion> listaInscripciones = new ArrayList<>();
     String sql = "SELECT * FROM inscripciones";
     
     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         inscripcion=new Inscripcion();
         inscripcion.setClaveinscripcion(rs.getString("ClaveInscripcion"));
         inscripcion.setFechainscripcion(rs.getString("FechaInscripcion"));
         inscripcion.setClavegrupo(rs.getString("ClaveGrupo"));
         inscripcion.setMatricula(rs.getString("Matricula"));
         
         listaInscripciones.add(inscripcion);
     }
     rs.close();
     ps.close();
     con.close();
     }
     
    catch (SQLException ex)
     {
     Logger.getLogger(DAOInscripcion.class.getName()).log(Level.SEVERE, null,ex);
     }
     
     return listaInscripciones;
 }
 public boolean agregar(Inscripcion inscripcion)
    {
        String sql = "INSERT INTO inscripciones VALUES('" + inscripcion.getClaveinscripcion()+"','" +
                inscripcion.getFechainscripcion()+"','"+
                inscripcion.getClavegrupo()+"','"+
                inscripcion.getMatricula()+"')";
        
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
            Logger.getLogger(DAOInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
 
 public Inscripcion buscar(String claveinscripcion)
 {
    String sql = "SELECT * FROM inscripciones WHERE ClaveInscripcion='"+claveinscripcion+"'";
        try 
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                inscripcion = new Inscripcion();
                inscripcion.setClaveinscripcion(rs.getString("ClaveInscripcion"));
                inscripcion.setFechainscripcion(rs.getString("FechaInscripcion"));
                inscripcion.setClavegrupo(rs.getString("ClaveGrupo"));
                inscripcion.setMatricula(rs.getString("Matricula"));
            }
            rs.close();
            ps.close();
            con.close();   
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
 return inscripcion;
 }
 
 
 public boolean actualizar(Inscripcion inscripcion,String old)
    {
    String sql = "UPDATE inscripciones SET "+
                 "ClaveInscripcion = '" + inscripcion.getClaveinscripcion() + "', " +
                 "FechaInscripcion   = '" + inscripcion.getFechainscripcion()    + "', " +
                 "ClaveGrupo       = '"  + inscripcion.getClavegrupo() + "',  " +
                 "Matricula = '" + inscripcion.getMatricula() + "' " +
                 "WHERE ClaveInscripcion = '" + old + "'";
    
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
            Logger.getLogger(DAOInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
 
 public boolean eliminar(String claveinscripcion)
 {
      String sql = "DELETE FROM inscripciones WHERE ClaveInscripcion = '" + claveinscripcion + "'";
     
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
            Logger.getLogger(DAOInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }        
    
     return true;
 }
 
}