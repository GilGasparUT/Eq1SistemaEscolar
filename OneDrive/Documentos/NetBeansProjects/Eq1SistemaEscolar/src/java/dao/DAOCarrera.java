package dao;


import beans.Carrera;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCarrera
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Carrera carrera;

 public ArrayList mostrar()  
 {
     ArrayList<Carrera> listaCarrera = new ArrayList<>();
     String sql = "SELECT * FROM carreras";

     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         carrera=new Carrera();
         carrera.setClavecarrera(rs.getString("ClaveCarrera"));
         carrera.setCarrera(rs.getString("Carrera"));

         listaCarrera.add(carrera);
     }
     rs.close();
     ps.close();
     con.close();
     }

    catch (SQLException ex)
     {
     Logger.getLogger(DAOCarrera.class.getName()).log(Level.SEVERE, null,ex);
     }

     return listaCarrera;
 }
 public boolean agregar(Carrera carrera)
    {
        String sql = "INSERT INTO carreras VALUES('" + carrera.getClavecarrera()+"','" +
                carrera.getCarrera()+"')";

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
            Logger.getLogger(DAOCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }


        return true;
    }

 public Carrera buscar(String clavecarrera)
 {
    String sql = "SELECT * FROM carreras WHERE ClaveCarrera='"+clavecarrera+"'";
        try 
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                carrera = new Carrera();
                carrera.setClavecarrera(rs.getString("ClaveCarrera"));
                carrera.setCarrera(rs.getString("Carrera"));
            }
            rs.close();
            ps.close();
            con.close();   
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
 return carrera;
 }


 public boolean actualizar(Carrera carrera,String old)
    {
    String sql = "UPDATE carreras SET "+
                 "ClaveCarrera = '" + carrera.getClavecarrera() + "', " +
                 "Carrera     = '"  + carrera.getCarrera() + "'  " +
                 "WHERE ClaveCarrera = '" + old + "'";

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
            Logger.getLogger(DAOCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

 public boolean eliminar(String clavecarrera)
 {
      String sql = "DELETE FROM carreras WHERE CalveCarrera = '" + clavecarrera + "'";

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
            Logger.getLogger(DAOCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }        

     return true;
 }

}