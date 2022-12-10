package dao;

import beans.Grupo;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOGrupo 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Grupo grupo;

public ArrayList mostrar()
    {
        ArrayList<Grupo> listaGrupos = new ArrayList<>();
        String sql = "SELECT * FROM grupos";
            
        try 
        {
         
         
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                grupo=new Grupo();
                grupo.setClavegrupo(rs.getString("ClaveGrupo"));
                grupo.setSemestre(rs.getString("Semestre"));
                grupo.setLetra(rs.getString("Letra"));
                grupo.setYear(rs.getString("Year"));
                grupo.setTurno(rs.getString("Turno"));
                grupo.setClavecarrera(rs.getString("ClaveCarrera"));

                
                listaGrupos.add(grupo);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaGrupos;
    }

public ArrayList mostrar(String claveCarrera , String year, String semestre)
    {
        ArrayList<Grupo> listaGrupos = new ArrayList<>();
        String sql = "SELECT * FROM grupos WHERE ClaveCarrera ='"+claveCarrera+"' AND Year='"+year+"' AND Semestre='"+semestre+"'";
            
        try 
        {
         
         
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                grupo=new Grupo();
                grupo.setClavegrupo(rs.getString("ClaveGrupo"));
                grupo.setSemestre(rs.getString("Semestre"));
                grupo.setLetra(rs.getString("Letra"));
                grupo.setYear(rs.getString("Year"));
                grupo.setTurno(rs.getString("Turno"));
                grupo.setClavecarrera(rs.getString("ClaveCarrera"));

                
                listaGrupos.add(grupo);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaGrupos;
    }
    public ArrayList listSemestre()
    {
        ArrayList<Grupo> listaGrupos = new ArrayList<>();
        String sql = "SELECT DISTINCT Semestre FROM grupos";
            
        try 
        {
         
         
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                grupo=new Grupo();
                grupo.setSemestre(rs.getString("Semestre"));
                
                listaGrupos.add(grupo);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaGrupos;
    }
    
    public boolean agregar(Grupo grupo)
    {
        String sql = "INSERT INTO grupos VALUES('" + 
                grupo.getClavegrupo()+"','"+
                grupo.getSemestre()+"','"+
                grupo.getLetra()+"','"+
                grupo.getYear()+"','"+
                grupo.getTurno()+"','"+
                grupo.getClavecarrera()+"')";
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
            Logger.getLogger(DAOGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    public Grupo buscar (String clavegrupo)
    {
        String sql = "SELECT * FROM grupos WHERE ClaveGrupo='"+clavegrupo+"'";
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                grupo=new Grupo();
                grupo.setClavegrupo(rs.getString("ClaveGrupo"));
                grupo.setSemestre(rs.getString("Semestre"));
                grupo.setLetra(rs.getString("Letra"));
                grupo.setYear(rs.getString("Year"));
                grupo.setTurno(rs.getString("Turno"));
                grupo.setClavecarrera(rs.getString("ClaveCarrera"));
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return grupo;
    }
   
    
    public boolean actualizar(Grupo grupo,String old)
    {
    String sql = "UPDATE grupos SET "+
                 "ClaveGrupo = '" + grupo.getClavegrupo()+ "', " +
                 "Semestre = '" + grupo.getSemestre()+ "', " +
                 "Letra        = '" + grupo.getLetra()+ "', " +
                 "Year    = '" + grupo.getYear()+ "', " +
                 "Turno  = '"  + grupo.getTurno()+ "', " +
                 "ClaveCarrera = '"   + grupo.getClavecarrera()+ "' " +
                 "WHERE ClaveGrupo = '" + old + "'";
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
            Logger.getLogger(DAOGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
   

    public boolean eliminar(String clavegrupo)
    {
       String sql = "DELETE FROM grupos WHERE ClaveGrupo ='" + clavegrupo + "'";   
                 
       
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
            Logger.getLogger(DAOGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}