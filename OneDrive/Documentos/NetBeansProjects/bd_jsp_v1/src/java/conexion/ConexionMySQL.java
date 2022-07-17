package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMySQL
{
    public static Connection getConnection() throws SQLException
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Controlador MySQL 5.X cargado");
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dwi_2022_ejemplo1","root","");
    }
    
}
