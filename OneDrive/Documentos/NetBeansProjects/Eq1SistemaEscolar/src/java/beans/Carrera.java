
package beans;


public class Carrera 
{
    private String clavecarrera;
    private String carrera;
    
    public Carrera()
    {
        clavecarrera=carrera="";
    }
    
    public Carrera(String clavecarrera,String carrera)
    {
    this.clavecarrera = clavecarrera;
    this.carrera = carrera;
    }

    public String getClavecarrera() {
        return clavecarrera;
    }

    public void setClavecarrera(String clavecarrera) {
        this.clavecarrera = clavecarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

 }
