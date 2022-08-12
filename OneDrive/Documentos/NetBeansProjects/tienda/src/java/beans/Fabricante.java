
package beans;

public class Fabricante
{
    private String Codigo_fabricante;
    private String Nombre;
    private String RFC;
    
    
    
    public Fabricante() 
    {
       
       Codigo_fabricante =  RFC = Nombre = "";
        
    }
    public Fabricante(String Codigo_fabricante,String RFC, String Nombre) 
    {
        this.Codigo_fabricante= Codigo_fabricante;
        this.RFC = RFC;
        this.Nombre = Nombre;
        
    }

    public String getCodigo_fabricante() {
        return Codigo_fabricante;
    }

    public void setCodigo_fabricante(String Codigo_fabricante) {
        this.Codigo_fabricante = Codigo_fabricante;
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
     

}
