
package beans;


public class Grupo
{
    private String clavegrupo;
    private String semestre;
    private String letra;
    private String year;
    private String turno;
    private String clavecarrera;
    
    
    public Grupo ()
    {
        clavegrupo=semestre=letra=year=turno=clavecarrera="";
    }
    
    public Grupo(String clavegrupo,String semestre,String letra,String year,String turno,String clavecarrera)
    {
    this.clavecarrera = clavecarrera;
    this.semestre = semestre;
    this.letra = letra;
    this.year = year;
    this.turno = turno;
    this.clavecarrera = clavecarrera;
    }

    public String getClavegrupo() {
        return clavegrupo;
    }

    public void setClavegrupo(String clavegrupo) {
        this.clavegrupo = clavegrupo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getClavecarrera() {
        return clavecarrera;
    }

    public void setClavecarrera(String clavecarrera) {
        this.clavecarrera = clavecarrera;
    }

   
 }
