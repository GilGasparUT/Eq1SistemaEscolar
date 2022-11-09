
package beans;


public class Calificacion
{
    private String clavecalificacion;
    private String p1;
    private String p2;
    private String p3;
    private String extra;
    private String claveasignacion;
    private String claveinscripcion;
   
    
    public Calificacion ()
    {
       clavecalificacion=p1=p2=p3=extra=claveasignacion=claveinscripcion="";
    }
    
    public Calificacion(String clavecalificacion, String p1, String p2, String p3, String extra, String claveasignacion, String claveinscripcion)
    {
    this.clavecalificacion = clavecalificacion;
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.extra= extra;
    this.claveasignacion = claveasignacion;
    this.claveinscripcion = claveinscripcion;
    }

    public String getClavecalificacion() {
        return clavecalificacion;
    }

    public void setClavecalificacion(String clavecalificacion) {
        this.clavecalificacion = clavecalificacion;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getClaveasignacion() {
        return claveasignacion;
    }

    public void setClaveasignacion(String claveasignacion) {
        this.claveasignacion = claveasignacion;
    }

    public String getClaveinscripcion() {
        return claveinscripcion;
    }

    public void setClaveinscripcion(String claveinscripcion) {
        this.claveinscripcion = claveinscripcion;
    }

    
 }
