/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zapoteco
 */

public class ConexionMySQL
{
    public static Connection getConnection() throws SQLException
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("controlador cargado");
            
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/controlescolareq1", "root","");
    }    
}

