
package objetos;


public class Model_Cuota {
    
    private String fecha;
    private String cuota;
    private String monto;

    public Model_Cuota() {
    }

    public Model_Cuota(String fecha, String cuota, String monto) {
        this.fecha = fecha;
        this.cuota = cuota;
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Model_Cuota{" + "fecha=" + fecha + ", cuota=" + cuota + ", monto=" + monto + '}';
    }
    
    
    
    
}
