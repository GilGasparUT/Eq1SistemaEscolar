package beans;


public class Profesor
{
    private String claveempleado;
    private String apellidos;
    private String nombre;
    private String clavecarrera;
    
    public Profesor() 
    {
        claveempleado=apellidos=nombre=clavecarrera= " ";
        
    }
    public Profesor(String claveempleado, String apellidos, String nombre, String clavecarrera)
    {
        this.claveempleado = claveempleado;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.clavecarrera  =  clavecarrera;
    }

    public String getClaveempleado() {
        return claveempleado;
    }

    public void setClaveempleado(String claveempleado) {
        this.claveempleado = claveempleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClavecarrera() {
        return clavecarrera;
    }

    public void setClavecarrera(String clavecarrera) {
        this.clavecarrera = clavecarrera;
    }
    
 }