package dao;

import beans.Asignacion;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOAsignacion 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Asignacion asignacion;
    
 public ArrayList mostrar()  
 {
     ArrayList<Asignacion> listaAsignaciones = new ArrayList<>();
     String sql = "SELECT * FROM asignaciones";
     
     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         asignacion=new Asignacion();
         asignacion.setClaveasignacion(rs.getString("ClaveAsignacion"));
         asignacion.setClaveempleado(rs.getString("ClaveEmpleado"));
         asignacion.setClavemat(rs.getString("ClaveMat"));
         asignacion.setClavegrupo(rs.getString("ClaveGrupo"));
         listaAsignaciones.add(asignacion);
     }
     rs.close();
     ps.close();
     con.close();
     }
     
    catch (SQLException ex)
     {
     Logger.getLogger(DAOAsignacion.class.getName()).log(Level.SEVERE, null,ex);
     }
     
     return listaAsignaciones;
 }
 
 public ArrayList mostrar(String claveEmpleado)  
 {
     ArrayList<Asignacion> listaAsignaciones = new ArrayList<>();
    String sql = "SELECT * FROM asignaciones WHERE ClaveEmpleado='"+claveEmpleado+"'";
      
//String sql = "SELECT Nombre,Materia, ClaveGrupo,ClaveAsignacion  FROM profesores, grupos, materias, asignaciones  WHERE profesores.ClaveEmpleado= asignaciones.'"+claveEmpleado+"' AND asignaciones.ClaveGrupo=grupos.ClaveGrupo AND  asignaciones.ClaveGrupo = grupos.ClaveGrupo ";
     
     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         asignacion=new Asignacion();
         asignacion.setClaveasignacion(rs.getString("ClaveAsignacion"));
         asignacion.setClaveempleado(rs.getString("ClaveEmpleado"));
         asignacion.setClavemat(rs.getString("ClaveMat"));
         asignacion.setClavegrupo(rs.getString("ClaveGrupo"));
         listaAsignaciones.add(asignacion);
     }
     rs.close();
     ps.close();
     con.close();
     }
     
    catch (SQLException ex)
     {
     Logger.getLogger(DAOAsignacion.class.getName()).log(Level.SEVERE, null,ex);
     }
     
     return listaAsignaciones;
 }
 public boolean agregar(Asignacion asignacion)
    {
        String sql = "INSERT INTO asignaciones VALUES('" + asignacion.getClaveasignacion()+"','" +
                asignacion.getClaveempleado()+"','"+
                asignacion.getClavemat()+"','"+
                asignacion.getClavegrupo()+"')";
        
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
            Logger.getLogger(DAOAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
 
 public Asignacion buscar(String claveasignacion)
 {
    String sql = "SELECT * FROM asignaciones WHERE ClaveAsignacion='"+claveasignacion+"'";
        try 
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                asignacion = new Asignacion();
                asignacion.setClaveasignacion(rs.getString("ClaveAsignacion"));
                asignacion.setClaveempleado(rs.getString("ClaveEmpleado"));
                asignacion.setClavemat(rs.getString("ClaveMat"));
                asignacion.setClavegrupo(rs.getString("ClaveGrupo"));
            }
            rs.close();
            ps.close();
            con.close();   
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
 return asignacion;
 }
 
 
 public boolean actualizar(Asignacion asignacion,String old)
    {
    String sql = "UPDATE asignaciones SET "+
                 "ClaveAsignacion = '" + asignacion.getClaveasignacion() + "', " +
                 "ClaveEmpleado   = '" + asignacion.getClaveempleado()    + "', " +
                 "ClaveMat   = '" + asignacion.getClavemat()    + "', " +
                 "ClaveGrupo = '"+ asignacion.getClavegrupo() +"' "+
                 "WHERE ClaveAsignacion = '" + old + "'";
    
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
            Logger.getLogger(DAOAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
 
 public boolean eliminar(String claveasignacion)
 {
      String sql = "DELETE FROM asignaciones WHERE ClaveAsignaciones = '" + claveasignacion + "'";
     
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
            Logger.getLogger(DAOAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }        
    
     return true;
 }
 
}