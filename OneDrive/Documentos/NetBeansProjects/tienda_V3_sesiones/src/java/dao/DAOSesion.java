
package dao;

import beans.Usuario;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOSesion 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public DAOSesion()
    {
        con = null;
        ps = null;
        rs = null;
    }
    

public Usuario iniciarSesion(String usu, String passwd)
    {
        Usuario usuario = null;
        String sql="SELECT * FROM usuarios WHERE Usuario=? AND Password=?";
        
        try
        {
            con=ConexionMySQL.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, usu);
            ps.setString(2, passwd);
            rs=ps.executeQuery();
        
        if(rs.next())
        {
            usuario=new Usuario(rs.getString("Usuario"),rs.getString("Password"));
        }
        
        rs.close();
        ps.close();
        con.close();
        }
        
        catch (SQLException ex)
        {
            Logger.getLogger(DAOSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
     return usuario;
    }
}
