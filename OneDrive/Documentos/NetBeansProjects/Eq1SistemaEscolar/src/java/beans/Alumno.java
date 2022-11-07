
package beans;


public class Alumno
{
    private String matricula;
    private String curp;
    private String nombre;
    private String apellidos;
    private String fechanac;
    private String sexo;
    
    
    public Alumno ()
    {
        matricula=curp=nombre=apellidos=fechanac=sexo="";
        
    }
    
    public Alumno(String matricula,String curp,String nombre,String apellidos,String fechanac,String sexo)
    {
    this.matricula = matricula;
    this.curp = curp;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechanac = fechanac;
    this.sexo = sexo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
       
}
