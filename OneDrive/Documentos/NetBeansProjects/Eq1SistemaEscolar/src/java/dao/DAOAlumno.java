package dao;

import beans.Alumno;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOAlumno 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Alumno alumno;
    
 public ArrayList mostrar()  
 {
     ArrayList<Alumno> listaAlumnos = new ArrayList<>();
     String sql = "SELECT * FROM alumnos";
     
     try 
     {   
         con = ConexionMySQL.getConnection();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next())
     {
         alumno=new Alumno();
         alumno.setMatricula(rs.getString("Matricula"));
         alumno.setCurp(rs.getString("CURP"));
         alumno.setNombre(rs.getString("Nombre"));
         alumno.setApellidos(rs.getString("Apellidos"));
         alumno.setFechanac(rs.getString("FechaNac"));
         alumno.setSexo(rs.getString("Sexo"));
         
         listaAlumnos.add(alumno);
     }
     rs.close();
     ps.close();
     con.close();
     }
     
    catch (SQLException ex)
     {
     Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null,ex);
     }
     
     return listaAlumnos;
 }
 public boolean agregar(Alumno alumno)
    {
        String sql = "INSERT INTO alumnos VALUES('" + alumno.getMatricula()+"','" +
                alumno.getCurp()+"','"+
                alumno.getNombre()+"','"+
                alumno.getApellidos()+"','"+
                alumno.getFechanac()+"','"+
                alumno.getSexo()+"')";
        
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
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
 
 public Alumno buscar(String matricula)
 {
    String sql = "SELECT * FROM alumnos WHERE Matricula='"+matricula+"'";
        try 
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
                alumno = new Alumno();
                alumno.setMatricula(rs.getString("Matricula"));
                alumno.setCurp(rs.getString("CURP"));
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellidos(rs.getString("Apellidos"));
                alumno.setFechanac(rs.getString("FechaNac"));
                alumno.setSexo(rs.getString("Sexo"));
            }
            rs.close();
            ps.close();
            con.close();   
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
 return alumno;
 }
 
 
 public boolean actualizar(Alumno alumno,String old)
    {
    String sql = "UPDATE alumnos SET "+
                 "Matricula = '" + alumno.getMatricula() + "', " +
                 "CURP   = '" + alumno.getCurp()    + "', " +
                 "Nombre = '" + alumno.getNombre() + "', " +
                 "Apellidos       = '"  + alumno.getApellidos() + "',  " +
                 "FechaNac       = '"  + alumno.getFechanac()  + "',  " +
                 "Sexo     = '"  + alumno.getSexo() + "'  " +
                 "WHERE Matricula = '" + old + "'";
    
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
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
 
 public boolean eliminar(String matricula)
 {
      String sql = "DELETE FROM alumnos WHERE Matricula = '" + matricula + "'";
     
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