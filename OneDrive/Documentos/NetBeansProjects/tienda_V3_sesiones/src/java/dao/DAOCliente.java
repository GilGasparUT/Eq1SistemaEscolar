package dao;


import beans.Cliente;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Cliente cliente;        
            
    public ArrayList mostrar()
    {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
            
        try 
        {
         
         
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                cliente=new Cliente();
                cliente.setId_cliente(rs.getString("Id_cliente"));
                cliente.setRFC(rs.getString("RFC"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setTelefono(rs.getString("Telefono"));
                
                listaClientes.add(cliente);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaClientes;
    }
    
    public boolean agregar(Cliente cliente)
    {
        String sql = "INSERT INTO clientes VALUES('" + 
                cliente.getId_cliente() +"','"+
                cliente.getRFC() +"','"+
                cliente.getNombre() +"','"+
                cliente.getApellidos() +"','"+
                cliente.getTelefono() +"')";
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
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    public Cliente buscar (String id_cliente)
    {
        String sql = "SELECT * FROM clientes WHERE Id_cliente='"+id_cliente+"'";
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                cliente=new Cliente();
                cliente.setId_cliente(rs.getString("Id_cliente"));
                cliente.setRFC(rs.getString("RFC"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setTelefono(rs.getString("Telefono"));
       
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }
   
    
    public boolean actualizar(Cliente cliente,String old)
    {
    String sql = "UPDATE clientes SET "+
                 "Id_cliente = '" + cliente.getId_cliente() + "', " +
                 "RFC        = '" + cliente.getRFC()    + "', " +
                 "Nombre     = '" + cliente.getNombre() + "', " +
                 "Apellidos  = '"  + cliente.getApellidos() + "', " +
                 "Telefono   = '"  + cliente.getTelefono()  + "' " +
                 "WHERE Id_cliente = '" + old + "'";
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
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
   

    public boolean eliminar(String id_cliente)
    {
       String sql = "DELETE FROM clientes WHERE Id_cliente ='" + id_cliente + "'";   
                 
       
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
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}