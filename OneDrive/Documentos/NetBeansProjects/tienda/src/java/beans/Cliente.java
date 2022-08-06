
package beans;



public class Cliente
{
    private String Id_cliente;
    private String RFC;
    private String Nombre;
    private String Apellidos;
    private int Telefono;
    
    
    
    public Cliente() 
    {
        Telefono= 0;
       Id_cliente =  RFC = Nombre = Apellidos = "";
        
    }
    public Cliente(String RFC, String Nombre, String Apellidos,
            String Id_cliente, int Telefono) 
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

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

}

