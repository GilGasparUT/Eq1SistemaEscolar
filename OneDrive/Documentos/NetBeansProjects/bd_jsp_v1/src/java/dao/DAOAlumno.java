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
         
         
            con = ConexionMySQL.getConnection(); //Conectar a la BD
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); //ejecutar consulta y obtener resultados
            while(rs.next())
            {
                alumno=new Alumno();
                alumno.setMatricula(rs.getString("Matricula"));
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellidos(rs.getString("Apellidos"));
                alumno.setDwi(rs.getInt("Dwi"));
                alumno.setCjv(rs.getInt("Cjv"));
                alumno.setEcbd(rs.getInt("Ecbd"));
                alumno.calcularProm();
                listaAlumnos.add(alumno);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAlumnos;
    }
    
    public boolean agregar(Alumno alumno)
    {
        String sql = "INSERT INTO alumnos VALUES('" + alumno.getMatricula()+"','" +
                alumno.getNombre() + "','" +
                alumno.getApellidos() +"',"+
                alumno.getDwi() + "," +
                alumno.getCjv() + "," +
                alumno.getEcbd() + ")";
        
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
    
    public Alumno buscar (String matricula)
    {
        String sql = "SELECT * FROM alumnos WHERE Matricula='"+matricula+"'";
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                alumno=new Alumno();
                alumno.setMatricula(rs.getString("Matricula"));
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellidos(rs.getString("Apellidos"));
                alumno.setDwi(rs.getInt("Dwi"));
                alumno.setCjv(rs.getInt("Cjv"));
                alumno.setEcbd(rs.getInt("Ecbd"));
                
                
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
                 "Nombre    = '" + alumno.getNombre()    + "', " +
                 "Apellidos = '" + alumno.getApellidos() + "', " +
                 "Dwi       = "  + alumno.getDwi() + ",  " +
                 "Cjv       = "  + alumno.getCjv()  + ",  " +
                 "Ecbd      = "  + alumno.getEcbd() + 
                 " WHERE Matricula = '" + old + "'";
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
       String sql = "DELETE FROM alumnos WHERE Matricula ='" + matricula + "'";   
                 
       
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
}