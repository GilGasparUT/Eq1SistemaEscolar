
package beans;


public class Alumno 
{
    private String matricula;
    private String year;
    private String curp;
    private String apellidos;
     private String nombre;
    private String fechanac;
    private String sexo;
    private String clavecarrera;
    private double prom; //solo metodo get, por ser variable de salida
    
    public Alumno ()
    {
        matricula=year=curp=apellidos=nombre=fechanac=sexo=clavecarrera="";
        prom=0.0;
    }
    
    public Alumno(String matricula,String year,String curp,String apellidos,String nombre,String fechanac,String sexo,String clavecarrera)
    {
    this.matricula = matricula;
    this.year = year;
    this.curp = curp;
    this.apellidos = apellidos;
    this.nombre = nombre;
    this.fechanac = fechanac;
    this.sexo = sexo;
    this.clavecarrera = clavecarrera;
    
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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

    public String getClavecarrera() {
        return clavecarrera;
    }

    public void setClavecarrera(String clavecarrera) {
        this.clavecarrera = clavecarrera;
    }
    
    public double getProm() {
        return prom;
    }

    public void setProm(double prom) {
        this.prom = prom;
    }

 }
