
package beans;


public class Asignacion
{
    private String claveasignacion;
    private String claveempleado;
    private String clavemat;
    private String clavegrupo;
    
    public Asignacion ()
    {
        claveasignacion=claveempleado=clavemat=clavegrupo="";
    }
    
    public Asignacion(String claveasignacion,String claveempleado,String clavemat,String clavegrupo)
    {
    this.claveasignacion = claveasignacion;
    this.claveempleado = claveempleado;
    this.clavemat = clavemat;
    this.clavegrupo= clavegrupo;
    }

    public String getClaveasignacion() {
        return claveasignacion;
    }

    public void setClaveasignacion(String claveasignacion) {
        this.claveasignacion = claveasignacion;
    }

    public String getClaveempleado() {
        return claveempleado;
    }

    public void setClaveempleado(String claveempleado) {
        this.claveempleado = claveempleado;
    }

    public String getClavemat() {
        return clavemat;
    }

    public void setClavemat(String clavemat) {
        this.clavemat = clavemat;
    }

    public String getClavegrupo() {
        return clavegrupo;
    }

    public void setClavegrupo(String clavegrupo) {
        this.clavegrupo = clavegrupo;
    }

 }
