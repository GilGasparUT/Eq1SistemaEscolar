
package beans;


public class Inscripcion
{
    private String claveinscripcion;
    private String fechainscripcion;
    private String clavegrupo;
    private String matricula;
     
    public Inscripcion ()
    {
        
        claveinscripcion=fechainscripcion=matricula=clavegrupo="";
       
    }
    
    public Inscripcion(String claveinscripcion,String fechainscripcion,String clavegrupo,String matricula)
    {
    this.claveinscripcion = claveinscripcion;
    this.fechainscripcion = fechainscripcion;
    this.clavegrupo = clavegrupo;
    this.matricula = matricula;
       
    }

    public String getClaveinscripcion() {
        return claveinscripcion;
    }

    public void setClaveinscripcion(String claveinscripcion) {
        this.claveinscripcion = claveinscripcion;
    }

    public String getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(String fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public String getClavegrupo() {
        return clavegrupo;
    }

    public void setClavegrupo(String clavegrupo) {
        this.clavegrupo = clavegrupo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
}
