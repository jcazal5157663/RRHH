package context;

import java.util.ArrayList;
import objetos.Model_permisos;

public class AppContext {

    public static ArrayList<Model_permisos> PERMISOS_MENUS = new ArrayList<Model_permisos>();
    //STRING O MENSAJES
    public static String MENSAJE_PERMISO_DENEGADO = "Usted no tiene los permisos para ingresar, Comuniquese con el Dpto. de Informática";
    public static int ROL_USUARIO ;
    public static String ROL_USUARIO_DESCRIP = "";
    //INFORMES
    public static String INFORME_APORTE = "reporte/aportes.jasper";
    public static String INFORME_PAIS = "reporte/paises.jasper";
    public static String INFORME_AMONESTACION = "reporte/amonestacion.jasper";
}
