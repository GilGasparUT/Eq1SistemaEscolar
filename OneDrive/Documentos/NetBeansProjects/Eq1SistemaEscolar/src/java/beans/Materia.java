package beans;


public class Materia 
{
    private String clavemat;
    private String materia;
    private String semestre;
    private String clavecarrera;
    
public Materia ()
    {
        clavemat=materia=semestre=clavecarrera="";
    }

public Materia(String clavemat,String materia,String semestre, String clavecarrera)
{
this.clavemat = clavemat;
this.materia = materia;
this.semestre = semestre;
this.clavecarrera = clavecarrera;
}

    public String getClavemat() {
        return clavemat;
    }

    public void setClavemat(String clavemat) {
        this.clavemat = clavemat;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getClavecarrera() {
        return clavecarrera;
    }

    public void setClavecarrera(String clavecarrera) {
        this.clavecarrera = clavecarrera;
    }



    }