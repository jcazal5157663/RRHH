
package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import principal.menu;


public class Verificar_Anticipo {

    public Verificar_Anticipo() {
    }
  public Boolean Verifica(int idfun, JTextField monto) {

        Calendar c = Calendar.getInstance();
        Tools tools = new Tools();
        Double Salario;
        Double porcentaje;
        int diaDel;
        int diaAl;
        int diaActual;
        Double montosolicitado;

        diaActual = c.get(Calendar.DAY_OF_MONTH);
        montosolicitado = tools.getParseString(monto);
        //Consultamos los parametros de la Configuracion Principal
        String sql = "select porcenadelsal, f_sol_ad_desde, f_sol_hasta from configuracion c\n"
                + "where id = 1";
        String res[] = tools.QueryDinamico(sql, menu.getConexion());
        if (res != null) {
            porcentaje = tools.getParseString(res[1]);
            diaDel = Integer.parseInt(res[2]);
            diaAl = Integer.parseInt(res[3]);
        } else {
            JOptionPane.showMessageDialog(null, "<html>No se ha Configurado los Parametros Necesarios para Generar el Anticipo, Por Favor-- <br>"
                    + "Consulte al Administrador del Sistema y Solicite la Configuración Correspondiente</html>", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (diaActual > diaAl) {
            JOptionPane.showMessageDialog(null, "El Periodo de Solicitud de Anticipo es del " + diaDel + " al " + diaAl + " De cada Mes, no se Generara el Anticipo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String sqlFuncionario = "select f.salario from  funcionario f\n"
                + "where f.id =" + idfun;
        res = tools.QueryDinamico(sqlFuncionario, menu.getConexion());
        Salario = tools.getParseString(res[1]);

        Double PorcentajeSalario = (Salario * porcentaje) / 100;
        if (montosolicitado > PorcentajeSalario) {
            JOptionPane.showMessageDialog(null, "El Monto Solicitado Supera el " + porcentaje + "% del Salario del Funcionario,Según la Limitación de Configuración de Su Sistema, Verifique", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH) + 1;
        int anho = c.get(Calendar.YEAR);
        if(dia > diaAl){
             JOptionPane.showMessageDialog(null, "La Fecha maxima de Carga de Solicitud es hasta el Día "+diaAl+" de Cada Mes", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        SimpleDateFormat fs = new SimpleDateFormat("dd/MM/yyyy");
        String fechaIiniciaMes = "01/" + tools.agregarCeros(String.valueOf(mes), 2) + "/" + anho + "";

        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date ultimoDia = c.getTime();
        String diafinal = fs.format(ultimoDia);

        String sqlSolicitud = "select coalesce(SUM(monto),0) from anticipo\n"
                + "where funcionario = " + idfun + " and \n"
                + "fecha_solicitud between '" + fechaIiniciaMes + "' and '" + diafinal + "'";

        res = tools.QueryDinamico(sqlSolicitud, menu.getConexion());
        Double sumatoria = tools.getParseString(res[1]);
        sumatoria = sumatoria + montosolicitado;

        if (sumatoria > PorcentajeSalario) {
            JOptionPane.showMessageDialog(null, "El Monto Solicitado en el Mes Supera el " + porcentaje + "% del Salario del Funcionario,Según la Limitación de Configuración de Su Sistema, Verifique", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
     

        return true;
    }
    
}
