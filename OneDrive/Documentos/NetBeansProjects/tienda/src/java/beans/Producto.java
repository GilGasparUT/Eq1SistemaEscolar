
package beans;



public class Producto
{
    private String Codigo_producto;
    private String Nombre;
    private double Precio;
    private String Codigo_fabricante;
    
    
    
    
    public Producto() 
    {
        Codigo_producto= Nombre = Codigo_fabricante = "";
        Precio=0.0;
        
    }
    public Producto(String Codigo_producto, String Nombre, String Codigo_fabricante,
            double Precio) 
    {
        this.Codigo_producto= Codigo_producto;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Codigo_fabricante = Codigo_fabricante;
          
    }

    public String getCodigo_producto() {
        return Codigo_producto;
    }

    public void setCodigo_producto(String Codigo_producto) {
        this.Codigo_producto = Codigo_producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getCodigo_fabricante() {
        return Codigo_fabricante;
    }

    public void setCodigo_fabricante(String Codigo_fabricante) {
        this.Codigo_fabricante = Codigo_fabricante;
    }
    

   

}

