/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import objetos.Model_Cuota;

/**
 *
 * @author josec
 */
public class prueba {

    public static void main(String[] args) {
        int cuota = 15;
        int monto = 425000;
        
        ArrayList<Model_Cuota> array = new Query().TraerCuotas(monto, cuota);
        
        for (Model_Cuota array1 : array) {
            System.out.println(array1.toString());
            
        }
        
        

    }
}
