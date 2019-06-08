
package objetos;




public class Model_permisos {
    
    
    private int idMenu;
    private Boolean acceder;
    private Boolean nuevo;
    private Boolean modificar;
    private Boolean eliminar;
    private Boolean informe;

   
    
    public Model_permisos() {
    }

    public Model_permisos(int idMenu, Boolean acceder, Boolean nuevo, Boolean modificar, Boolean eliminar, Boolean informe) {
        this.idMenu = idMenu;
        this.acceder = acceder;
        this.nuevo = nuevo;
        this.modificar = modificar;
        this.eliminar = eliminar;
        this.informe = informe;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public Boolean getAcceder() {
        return acceder;
    }

    public void setAcceder(Boolean acceder) {
        this.acceder = acceder;
    }

    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Boolean getModificar() {
        return modificar;
    }

    public void setModificar(Boolean modificar) {
        this.modificar = modificar;
    }

    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
    }

    public Boolean getInforme() {
        return informe;
    }

    public void setInforme(Boolean informe) {
        this.informe = informe;
    }
    
    

   
}
