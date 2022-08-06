package dao;



import beans.Producto;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProducto
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Producto producto;        
            
    public ArrayList mostrar()
    {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM producto";
            
        try 
        {
         
         
            con = ConexionMySQL.getConnection(); //Conectar a la BD
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); //ejecutar consulta y obtener resultados
            while(rs.next())
            {
                producto=new Producto();
                producto.setCodigo_producto(rs.getString("Codigo_producto"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setCodigo_producto(rs.getString("Codigo_producto"));
                    
                listaProductos.add(producto);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaProductos;
    }
    
    public boolean agregar(Producto producto)
    {
        String sql = "INSERT INTO producto VALUES('" + producto.getCodigo_producto()+"','" +
                producto.getNombre() + "','" +
                producto.getPrecio() + "','" +
                producto.getCodigo_fabricante() + ")";
               
        
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
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    public Producto buscar (String codigo_producto)
    {
        String sql = "SELECT * FROM producto WHERE Id_cliente='"+codigo_producto+"'";
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                producto=new Producto();
                producto.setCodigo_producto(rs.getString("Codigo_producto"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setCodigo_fabricante(rs.getString("Codigo_fabricante"));
    
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return producto;
    }
   
    
    public boolean actualizar(Producto producto,String old)
    {
    String sql = "UPDATE producto SET "+
                 "Codigo_producto= '" + producto.getCodigo_producto() + "', " +
                 "Nombre     = '" + producto.getNombre()    + "', " +
                 "Precio    = '" + producto.getPrecio() + "', " +
                 "Codigo_fabricante = "  + producto.getCodigo_fabricante() + ",  " +
                 "WHERE Codigo_producto = '" + old + "'";
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
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
   

    public boolean eliminar(String codigo_producto)
    {
       String sql = "DELETE FROM producto WHERE Id_cliente ='" + codigo_producto + "'";   
                 
       
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
            Logger.getLogger(DAOProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}