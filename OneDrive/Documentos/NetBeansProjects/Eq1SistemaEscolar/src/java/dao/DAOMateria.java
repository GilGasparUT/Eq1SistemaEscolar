package dao;

import beans.Materia;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOMateria 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Materia materia;
    
public ArrayList mostrar()  
 {
     ArrayList<Materia> listaMaterias = new ArrayList<>();
     String sql = "SELECT * FROM materias";
     
     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         materia=new Materia();
         materia.setClavemat(rs.getString("ClaveMat"));
         materia.setMateria(rs.getString("Materia"));
         materia.setSemestre(rs.getString("Semestre"));
         materia.setClavecarrera(rs.getString("ClaveCarrera"));
       
         listaMaterias.add(materia);
     }
     rs.close();
     ps.close();
     con.close();
     }
     
    catch (SQLException ex)
     {
     Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null,ex);
     }
     
     return listaMaterias;
 }
public ArrayList mostrar(String claveCarrera , String semestre)  
 {
     ArrayList<Materia> listaMaterias = new ArrayList<>();
    String sql = "SELECT * FROM materias WHERE ClaveCarrera ='"+claveCarrera+"' AND Semestre='"+semestre+"'";
    
     
     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         materia=new Materia();
         materia.setClavemat(rs.getString("ClaveMat"));
         materia.setMateria(rs.getString("Materia"));
         materia.setSemestre(rs.getString("Semestre"));
         materia.setClavecarrera(rs.getString("ClaveCarrera"));
       
         listaMaterias.add(materia);
     }
     rs.close();
     ps.close();
     con.close();
     }
     
    catch (SQLException ex)
     {
     Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null,ex);
     }
     
     return listaMaterias;
 }
 
 public boolean agregar(Materia materia)
    {
        String sql = "INSERT INTO materias VALUES('" + materia.getClavemat()+"','" +
                materia.getMateria() + "','" +
                materia.getSemestre() + "','" +
                materia.getClavecarrera() +"')";
                       
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
            Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
 
 public Materia buscar (String clavemat)
 {
    String sql ="SELECT * FROM materias WHERE ClaveMat='"+clavemat+"'";
        try 
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                materia = new Materia();
                materia.setClavemat(rs.getString("ClaveMat"));
                materia.setMateria(rs.getString("Materia"));
                materia.setSemestre(rs.getString("Semestre"));
                materia.setClavecarrera(rs.getString("ClaveCarrera"));

            }
            rs.close();
            ps.close();
            con.close();   
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
 return materia;
 }
 
 
 public boolean actualizar(Materia materia,String old)
    {
    String sql = "UPDATE materias SET "+
                 "ClaveMat ='"+ materia.getClavemat() +"', "+
                 "Materia    ='"+ materia.getMateria()+"', "+
                 "Semestre     ='"+ materia.getSemestre()+"', " +
                 "ClaveCarrera     ='"+ materia.getClavecarrera()+"' " +
                 "WHERE ClaveMat ='" + old + "'";
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
            Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
 
 public boolean eliminar(String clavemat)
 {
      String sql = "DELETE FROM materias WHERE ClaveMat = '" + clavemat + "'";
     
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
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }        
    
     return true;
 }

     
}
