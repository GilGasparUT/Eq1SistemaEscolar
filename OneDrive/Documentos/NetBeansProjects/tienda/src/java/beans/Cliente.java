
package beans;



public class Cliente
{
    private String Id_cliente;
    private String RFC;
    private String Nombre;
    private String Apellidos;
    private String Telefono;
    
    
    
    public Cliente() 
    {
      
      Id_cliente =  RFC = Nombre = Apellidos = Telefono =  "";
        
    }
    public Cliente(String Id_cliente, String RFC, String Nombre, String Apellidos, String Telefono) 
    {
        this.Id_cliente= Id_cliente;
        this.RFC = RFC;
        this.Nombre = Nombre;
        this.Apellidos  =  Apellidos;
        this.Telefono  =  Telefono;
     
    }

    public String getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(String Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

}

