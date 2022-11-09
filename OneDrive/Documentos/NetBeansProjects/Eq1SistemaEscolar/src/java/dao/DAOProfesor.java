package dao;

import beans.Profesor;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProfesor 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Profesor profesor;

 public ArrayList mostrar()  
 {
     ArrayList<Profesor> listaProfesor = new ArrayList<>();
     String sql = "SELECT * FROM profesores";

     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         profesor=new Profesor();
         profesor.setClaveempleado(rs.getString("ClaveEmpleado"));
         profesor.setApellidos(rs.getString("Apellidos"));
         profesor.setNombre(rs.getString("Nombre"));
         profesor.setClavecarrera(rs.getString("ClaveCarrera"));
         

         listaProfesor.add(profesor);
     }
     rs.close();
     ps.close();
     con.close();
     }

    catch (SQLException ex)
     {
     Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null,ex);
     }

     return listaProfesor;
 }
 public boolean agregar(Profesor profesor)
    {
        String sql = "INSERT INTO profesores VALUES('" + profesor.getClaveempleado()+"','" +
                profesor.getApellidos()+"','"+
                profesor.getNombre()+"','"+
                profesor.getClavecarrera()+"')";

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
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }


        return true;
    }

 public Profesor buscar(String claveempleado)
 {
    String sql = "SELECT * FROM profesores WHERE ClaveEmpleado='"+claveempleado+"'";
        try 
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                profesor = new Profesor();
                profesor.setClaveempleado(rs.getString("ClaveEmpleado"));
                profesor.setApellidos(rs.getString("Apellidos"));
                profesor.setNombre(rs.getString("Nombre"));
                profesor.setClavecarrera(rs.getString("ClaveCarrera"));
            }
            rs.close();
            ps.close();
            con.close();   
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
 return profesor;
 }


 public boolean actualizar(Profesor profesor,String old)
    {
    String sql = "UPDATE profesores SET "+
                 "ClaveEmpleado = '" + profesor.getClaveempleado() + "', " +
                 "Apellidos   = '" + profesor.getApellidos()    + "', " +
                 "Nombre = '" + profesor.getNombre() + "', " +
                 "ClaveCarrera     = '"  + profesor.getClavecarrera() + "'  " +
                 "WHERE ClaveEmpleado = '" + old + "'";

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
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

 public boolean eliminar(String claveempleado)
 {
      String sql = "DELETE FROM profesores WHERE ClaveEmpleado = '" + claveempleado + "'";

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
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }        

     return true;
 }

}