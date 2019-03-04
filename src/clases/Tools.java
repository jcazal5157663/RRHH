package clases;

import com.toedter.calendar.JDateChooser;
import java.awt.Checkbox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import objetos.Model_Cuota;

public class Tools {

    private int id;
    private String idDescri;
    private String descripcion;

    public Tools() {
    }

    public Tools(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Tools(String idDescri, String descripcion) {
        this.idDescri = idDescri;
        this.descripcion = descripcion;
    }

    public String getIdDescri() {
        return idDescri;
    }

    public void setIdDescri(String idDescri) {
        this.idDescri = idDescri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    public void CargarCombo(JComboBox<Tools> Combo, String cod[], String descri[]) {
        for (int i = 0; i < cod.length; i++) {
            Combo.addItem(new Tools(Integer.parseInt(cod[i]), descri[i]));
        }
    }

    public void CargarCombo2(JComboBox<Tools> Combo, String cod[], String descri[]) {
        for (int i = 0; i < cod.length; i++) {
            Combo.addItem(new Tools(cod[i], descri[i]));
        }
    }

    public void CargarCombo(JComboBox<Tools> Combo, String sql, Connection cn) {
        try {

            Statement Sentencia;
            ResultSet resultado;
            Combo.removeAllItems();
            Sentencia = cn.createStatement();
            resultado = Sentencia.executeQuery(sql);
            while (resultado.next()) {
                Combo.addItem(new Tools(resultado.getInt(1), resultado.getString(2)));
            }
            resultado.close();
            Sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SelectIdCombo(JComboBox<Tools> combo, int id) {
        for (int i = 0; i < combo.getModel().getSize(); i++) {
            Tools objeto = (Tools) combo.getModel().getElementAt(i);
            if (objeto.getId() == id) {
                combo.setSelectedItem(objeto);
            }
        }
    }

    public void SelectIdCombo(JComboBox<Tools> combo, String id) {
        for (int i = 0; i < combo.getModel().getSize(); i++) {
            Tools objeto = (Tools) combo.getModel().getElementAt(i);
            if (objeto.getIdDescri().endsWith(id)) {
                combo.setSelectedItem(objeto);
            }
        }
    }

    public void Insertar(String tabla, String Columnas[], String datos[], Boolean mensaje, Connection cn) {

        Statement Sentencia;
        try {
            String sql = "INSERT INTO " + tabla + "(";
            for (int col = 0; col < Columnas.length; col++) {
                sql += Columnas[col] + (col + 1 != Columnas.length ? "," : "");
            }
            sql += ") values(";
            for (int row = 0; row < datos.length; row++) {
                sql += datos[row] + (row + 1 != datos.length ? "," : "");
            }
            sql += ")";
            Sentencia = cn.createStatement();
            Sentencia.executeUpdate(sql);
            if (mensaje) {
                JOptionPane.showMessageDialog(null, "Datos Guardados con Éxito");
            }
            Sentencia.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void Insertar(PreparedStatement ps, Boolean mensaje) {

        try {
            ps.execute();
            ps.clearParameters();
            ps.close();
            if (mensaje) {
                JOptionPane.showMessageDialog(null, "Datos Guardados con Éxito");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    @SuppressWarnings("empty-statement")
    public void Actualizar(String tabla, String Columnas[], String datos[], String Condicion, Boolean mensaje, Connection cn) {

        Statement Sentencia;
        try {
            String sql = "UPDATE " + tabla + " SET ";
            for (int i = 0; i < Columnas.length; i++) {
                sql += Columnas[i] + " = " + datos[i] + (i + 1 != Columnas.length ? "," : " ");;
            }
            sql += "where " + Condicion;
            Sentencia = cn.createStatement();
            Sentencia.executeUpdate(sql);
            if (mensaje) {
                JOptionPane.showMessageDialog(null, "Datos Modificados con Éxito");
            }
            Sentencia.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void Actualizar(PreparedStatement ps, Boolean mensaje) {

        try {
            ps.execute();
            ps.clearParameters();
            ps.close();
            if (mensaje) {
                JOptionPane.showMessageDialog(null, "Datos Modificados con Éxito");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void eliminar(String tabla, String condicion, Boolean mensaje, Connection cn) {

        Statement Sentencia;
        try {
            String sql = "delete from " + tabla + " where " + condicion;
            Sentencia = cn.createStatement();
            Sentencia.executeUpdate(sql);
            if (mensaje) {
                JOptionPane.showMessageDialog(null, "Datos Eliminados con Éxito");
            }
            Sentencia.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void eliminar(PreparedStatement ps, Boolean mensaje) {

        try {
            ps.execute();
            ps.clearParameters();
            ps.close();
            if (mensaje) {
                JOptionPane.showMessageDialog(null, "Datos Eliminados con Éxito");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public void CargarTabla(String sql, JTable tabla, DefaultTableModel modelo, Boolean MostrarCabecera, Connection cn) {

        ResultSet resultado;
        Statement Sentencia;

        try {

            for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }

            tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            //Para establecer el modelo al JTable
            tabla.setModel(modelo);
            //Para ejecutar la consulta
            Sentencia = cn.createStatement();
            //Ejecutamos la consulta que escribimos en la variable sql
            //y los datos lo almacenamos en un ResultSet osea en resultado
            resultado = Sentencia.executeQuery(sql);
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultado.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            if (MostrarCabecera) {
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
            }
            //Creando las filas para el JTable
            DecimalFormat formato_decimal = new DecimalFormat("###,###.##");
            SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formato_fechaH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    //System.out.println(resultado.getMetaData().getColumnType(i + 1) + resultado.getMetaData().getColumnTypeName(i + 1));

                    switch (resultado.getMetaData().getColumnType(i + 1)) {
                        case 12:
                            fila[i] = resultado.getString(i + 1) != null ? resultado.getString(i + 1).trim().toUpperCase() : "";
                            break;
                        case 93:
                            fila[i] = resultado.getTimestamp(i + 1) != null ? formato_fechaH.format(resultado.getTimestamp(i + 1)) : "";
                            break;
                        case 4:
                            fila[i] = resultado.getInt(i + 1);
                            break;
                        case 2:
                            fila[i] = formato_decimal.format(resultado.getFloat(i + 1));
                            break;
                        case 91:
                            fila[i] = formato_fecha.format(resultado.getDate(i + 1));
                            break;
                        default:
                            fila[i] = resultado.getObject(i + 1);
                            break;
                    }

                }
                modelo.addRow(fila);
            }
            tabla.setRowHeight(20);
            JTableHeader jtableHeader = tabla.getTableHeader();
            DefaultTableCellRenderer rend = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
            rend.setHorizontalAlignment(JLabel.CENTER);
            jtableHeader.setDefaultRenderer(rend);
            TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<>(modelo);
            tabla.setRowSorter(elQueOrdena);
            tabla.setShowHorizontalLines(false);
            tabla.setShowVerticalLines(false);
            resultado.close();
            Sentencia.close();
            tabla.getTableHeader().setFont(new java.awt.Font("Segoe UI", 0, 12));
            tabla.setBackground(Color.white);
            tabla.setForeground(Color.BLACK);
            //tabla.setGridColor(Color.BLACK);
            tabla.getTableHeader().setBackground(Color.black);
            tabla.getSelectionModel().setSelectionInterval(0, 0);

        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void CargarTabla(PreparedStatement ps, JTable tabla, DefaultTableModel modelo, Boolean MostrarCabecera) {

        ResultSet resultado;

        try {

            for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }

            tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            //Para establecer el modelo al JTable
            tabla.setModel(modelo);
            //Para ejecutar la consulta

            //Ejecutamos la consulta que escribimos en la variable sql
            //y los datos lo almacenamos en un ResultSet osea en resultado
            resultado = ps.executeQuery();
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultado.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            if (MostrarCabecera) {
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
            }
            //Creando las filas para el JTable
            DecimalFormat formato_decimal = new DecimalFormat("###,###.##");
            SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formato_fechaH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    //System.out.println(resultado.getMetaData().getColumnType(i + 1) + resultado.getMetaData().getColumnTypeName(i + 1));

                    switch (resultado.getMetaData().getColumnType(i + 1)) {
                        case 12:
                            fila[i] = resultado.getString(i + 1) != null ? resultado.getString(i + 1).trim().toUpperCase() : "";
                            break;
                        case 93:
                            fila[i] = resultado.getTimestamp(i + 1) != null ? formato_fechaH.format(resultado.getTimestamp(i + 1)) : "";
                            break;
                        case 4:
                            fila[i] = resultado.getInt(i + 1);
                            break;
                        case 2:
                            fila[i] = resultado.getString(i + 1) != null ? formato_decimal.format(resultado.getFloat(i + 1)) : 0;
                            break;
                        case 8:
                            fila[i] = resultado.getString(i + 1) != null ? formato_decimal.format(resultado.getDouble(i + 1)) : 0;
                            break;
                        case 91:
                            fila[i] =  resultado.getString(i + 1) != null ? formato_fecha.format(resultado.getDate(i + 1)) : "";
                            break;
                        default:
                            fila[i] = resultado.getObject(i + 1);
                            break;
                    }

                }
                modelo.addRow(fila);
            }
            tabla.setRowHeight(20);
            JTableHeader jtableHeader = tabla.getTableHeader();
            DefaultTableCellRenderer rend = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
            rend.setHorizontalAlignment(JLabel.CENTER);
            jtableHeader.setDefaultRenderer(rend);
            TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<>(modelo);
            tabla.setRowSorter(elQueOrdena);
            tabla.setShowHorizontalLines(false);
            tabla.setShowVerticalLines(false);
            resultado.close();
            ps.clearParameters();
            ps.close();
            tabla.getTableHeader().setFont(new java.awt.Font("Segoe UI", 0, 12));
            tabla.setBackground(Color.white);
            tabla.setForeground(Color.BLACK);
            //tabla.setGridColor(Color.BLACK);
            tabla.getTableHeader().setBackground(Color.black);
            tabla.getSelectionModel().setSelectionInterval(0, 0);

        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void CargarTablaSinUpper(PreparedStatement ps, JTable tabla, DefaultTableModel modelo, Boolean MostrarCabecera) {

        ResultSet resultado;

        try {

            for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }

            tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            //Para establecer el modelo al JTable
            tabla.setModel(modelo);
            //Para ejecutar la consulta

            //Ejecutamos la consulta que escribimos en la variable sql
            //y los datos lo almacenamos en un ResultSet osea en resultado
            resultado = ps.executeQuery();
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = resultado.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            if (MostrarCabecera) {
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(rsMd.getColumnLabel(i));
                }
            }
            //Creando las filas para el JTable
            DecimalFormat formato_decimal = new DecimalFormat("###,###.##");
            SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formato_fechaH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    //System.out.println(resultado.getMetaData().getColumnType(i + 1) + resultado.getMetaData().getColumnTypeName(i + 1));

                    switch (resultado.getMetaData().getColumnType(i + 1)) {
                        case 12:
                            fila[i] = resultado.getString(i + 1) != null ? resultado.getString(i + 1).trim() : "";
                            break;
                        case 93:
                            fila[i] = resultado.getTimestamp(i + 1) != null ? formato_fechaH.format(resultado.getTimestamp(i + 1)) : "";
                            break;
                        case 4:
                            fila[i] = resultado.getInt(i + 1);
                            break;
                        case 2:
                            fila[i] = formato_decimal.format(resultado.getFloat(i + 1));
                            break;
                        case 91:
                            fila[i] = formato_fecha.format(resultado.getDate(i + 1));
                            break;
                        default:
                            fila[i] = resultado.getObject(i + 1);
                            break;
                    }

                }
                modelo.addRow(fila);
            }
            tabla.setRowHeight(20);
            JTableHeader jtableHeader = tabla.getTableHeader();
            DefaultTableCellRenderer rend = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
            rend.setHorizontalAlignment(JLabel.CENTER);
            jtableHeader.setDefaultRenderer(rend);
            TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<>(modelo);
            tabla.setRowSorter(elQueOrdena);
            tabla.setShowHorizontalLines(false);
            tabla.setShowVerticalLines(false);
            resultado.close();
            ps.clearParameters();
            ps.close();
            tabla.getTableHeader().setFont(new java.awt.Font("Segoe UI", 0, 12));
            tabla.setBackground(Color.white);
            tabla.setForeground(Color.BLACK);
            //tabla.setGridColor(Color.BLACK);
            tabla.getTableHeader().setBackground(Color.black);
            tabla.getSelectionModel().setSelectionInterval(0, 0);

        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void centrar(JTable tabla, int columna[]) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int columna1 : columna) {
            tabla.getColumnModel().getColumn(columna1).setCellRenderer(modelocentrar);
        }
    }

    public void izquierda(JTable tabla, int columna[]) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.LEFT);
        for (int columna1 : columna) {
            tabla.getColumnModel().getColumn(columna1).setCellRenderer(modelocentrar);
        }
    }

    public void derecha(JTable tabla, int columna[]) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int columna1 : columna) {
            tabla.getColumnModel().getColumn(columna1).setCellRenderer(modelocentrar);
        }
    }

    Dimension dimension;
    int alto;
    JScrollBar barra;

    public void PagTablaAnterior(JScrollPane scroll, JTable tabla, JButton ante, int fila) {
        dimension = tabla.getPreferredSize();
        scroll.setPreferredSize(
                new Dimension(dimension.width,
                        tabla.getRowHeight() * fila
                ));

        ante.addActionListener((ActionEvent evt) -> {
            alto = tabla.getRowHeight() * (fila - 1);
            barra = scroll.getVerticalScrollBar();
            barra.setValue(barra.getValue() - alto);
        });
    }

    public void PagTablaSigte(JScrollPane scroll, JTable tabla, JButton siguiente, int fila) {
        dimension = tabla.getPreferredSize();
        scroll.setPreferredSize(
                new Dimension(dimension.width,
                        tabla.getRowHeight() * fila
                ));

        siguiente.addActionListener((ActionEvent evt) -> {
            alto = tabla.getRowHeight() * (fila - 1);

            barra = scroll.getVerticalScrollBar();

            barra.setValue(barra.getValue() + alto);
        });
    }

    public String Nivel_Cuenta(String cuenta) {
        String dato[] = cuenta.replace(".", "-").split("-");
        String nivel;
        String aux = "";
        int c = 0;
        for (String dato1 : dato) {
            if (dato1.equals("0")) {
                aux = dato1;
            }
            if (Integer.parseInt(dato1) > 0) {
                c++;
            }
            if (Integer.parseInt(dato1) >= 0 && aux.equals("0")) {
                c++;
                aux = "";
            }
        }
        nivel = String.valueOf(c);
        return nivel;
    }

    public String[] QueryDinamico(String sql, Connection cn) {
        String respuesta[] = null;
        try {

            ResultSet resultado;
            Statement Sentencia;
            //   cn.conexion.setAutoCommit(false);
            Sentencia = cn.createStatement();
            resultado = Sentencia.executeQuery(sql);
            ResultSetMetaData rsMd = resultado.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount() + 1;
            respuesta = new String[cantidadColumnas];
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat formato_decimal = new DecimalFormat("###,###.##");
            if (resultado.next()) {
                for (int i = 1; i < cantidadColumnas; i++) {

                    switch (resultado.getMetaData().getColumnType(i)) {
                        case 91:
                            respuesta[i] = resultado.getString(i) != null ? formateador.format(resultado.getDate(i)) : "";
                            break;
                        case 2:
                            respuesta[i] = resultado.getString(i) != null ? formato_decimal.format(resultado.getFloat(i)) : "";
                            break;
                        default:
                            respuesta[i] = resultado.getString(i) != null ? resultado.getString(i).trim() : "";
                            break;
                    }

                }

            } else {
                respuesta = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;

    }

    public String[] QueryDinamico(PreparedStatement ps) {
        String respuesta[] = null;
        try {

            ResultSet resultado;

            //   cn.conexion.setAutoCommit(false);
            resultado = ps.executeQuery();
            ResultSetMetaData rsMd = resultado.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount() + 1;
            respuesta = new String[cantidadColumnas];
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat formato_decimal = new DecimalFormat("###,###.##");
            if (resultado.next()) {
                for (int i = 1; i < cantidadColumnas; i++) {
                    //System.out.println(resultado.getMetaData().getColumnType(i));        
                    switch (resultado.getMetaData().getColumnType(i)) {
                        case 91:
                            respuesta[i] = resultado.getString(i) != null ? formateador.format(resultado.getDate(i)) : "";
                            break;
                        case 2:
                            respuesta[i] = resultado.getString(i) != null ? formato_decimal.format(resultado.getFloat(i)) : "0";
                            break;
                        case 8:
                            respuesta[i] = resultado.getString(i) != null ? formato_decimal.format(resultado.getDouble(i)) : "0";
                            break;
                        default:
                            respuesta[i] = resultado.getString(i) != null ? resultado.getString(i).trim() : "";
                            break;
                    }

                }

            } else {
                respuesta = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;

    }

    TableRowSorter<TableModel> sorter;

    public void Busqued(JTable tabla, DefaultTableModel modelo, JTextField cuadro) {

        cuadro.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                sorter = new TableRowSorter<>(modelo);
                sorter.setRowFilter(RowFilter.regexFilter("^" + cuadro.getText().toUpperCase()));
                tabla.setRowSorter(sorter);
                tabla.getSelectionModel().setSelectionInterval(0, 0);
            }
        });

    }

    public void LimpiarBusqueda(JTextField busqueda, JTable table) {
        if (!busqueda.getText().isEmpty()) {
            sorter.setRowFilter(null);

        }

    }

    public void Solo_Numeros(JTextField texto) {
        texto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int letra = e.getKeyChar();
                if (!Character.isDigit(letra)) {
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void Solo_Letras(JTextField texto) {
        texto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int letra = e.getKeyChar();
                if (Character.isDigit(letra)) {
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public Boolean Controlar_Fecha(String fecha) {
        try {

            String ff[] = fecha.split("/");
            int year = Integer.parseInt(ff[2]);                 // año
            int month = Integer.parseInt(ff[1]);                      // mes [1,...,12]
            int dayOfMonth = Integer.parseInt(ff[0]);                // día [1,...,31]

            if (year < 1900) {
                throw new IllegalArgumentException("Año inválido.");
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1); // [0,...,11]
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            java.util.Date date = calendar.getTime();
            return true;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Fecha Invalida", "Verifique", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public String RetornarString(JDateChooser fecha) {

        return ((JTextField) fecha.getDateEditor()).getText();
    }

    public String agregarCeros(String string, int largo) {
        String ceros = "";

        int cantidad = largo - string.length();

        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros += "0";
            }

            return (ceros + string);
        } else {
            return string;
        }
    }

    public void limitarCaracter(JTextField texto, int limite) {
        texto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (texto.getText().length() == limite) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void limitarCaracter(JTextArea texto, int limite) {
        texto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (texto.getText().length() == limite) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

    public java.sql.Date convertUtilToSql(JDateChooser fecha) {
        java.util.Date uDate = fecha.getDate();
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public void transpasarFoco(JDateChooser fecha, Component componente) {
        ((JTextField) fecha.getDateEditor()).addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int letra = e.getKeyChar();
                if (letra == 10) {
                    componente.requestFocus();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void transpasarFoco(JDateChooser fecha, JDateChooser componente) {
        ((JTextField) fecha.getDateEditor()).addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int letra = e.getKeyChar();
                if (letra == 10) {
                    componente.getDateEditor().getUiComponent().requestFocus();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void reporte(String url, HashMap parameters, String titulo_informe, Connection cn) {
        try {

            URL urlMaestro = getClass().getClassLoader().getResource(url);
            JasperReport masterReport = null;
            masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);
            JasperPrint masterPrint = JasperFillManager.fillReport(masterReport, parameters, cn);
            JasperViewer vista = new JasperViewer(masterPrint);
            vista.setTitle(titulo_informe);
            vista.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void JtextFieldDecimal(JTextField jTextField) {
        DecimalFormat df = new DecimalFormat("###,###.##");
        jTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jTextField.getText().trim().equals("0")) {
                    String replace = jTextField.getText().replace("0", "");
                    jTextField.setText(replace);
                }
                /*validamos que sea solo una coma*/
                if (!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != ',') {
                    e.consume();
                }
                if (e.getKeyChar() == ',' && jTextField.getText().contains(",")) {
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (jTextField.getText().trim().equals("")) {
                    jTextField.setText("0");
                }

                int letra = e.getKeyChar();
                if (Character.isDigit(letra) || letra == 8) {
                    jTextField.setText(df.format(Double.parseDouble(jTextField.getText().replace(".", "").replace(",", "."))));
                }
            }
        });

    }

    public int CalcularDias(JDateChooser fecha1, JDateChooser fecha2, JCheckBox sabado, JCheckBox domingo) {

        Boolean valf1 = ValidacionFecha(fecha1, "Formato Invalido", "No puede Dejar Vacio", true, null);
        Boolean valf2 = ValidacionFecha(fecha2, "Formato Invalido", "No puede Dejar Vacio", true, null);
        int dias = 0;
        if (valf1 && valf2) {

            Calendar f1 = fecha1.getCalendar();
            Calendar f2 = fecha2.getCalendar();

            while (f1.before(f2) || f1.equals(f2)) {

                //Preguntamos si primero nunguno de los dos esta marcado
                if (!sabado.isSelected() && !domingo.isSelected()) {

                    if (f1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                            && f1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                        dias++;
                    }

                } else {
                    //Preguntamos si Solo Sabado Esta Marcado
                    if (sabado.isSelected() && !domingo.isSelected()) {

                        if (f1.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                            dias++;
                        }
                    } else {
                        if (!sabado.isSelected() && domingo.isSelected()) {
                            if (f1.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                                dias++;
                            }
                        } else {
                            //por Default toma si ninguno de los dos Esta Marcado
                            dias++;
                        }
                    }
                }
                f1.add(Calendar.DATE, 1);
            }

        }
        return dias;
    }

    public Boolean ValidacionFecha(JDateChooser fecha, String mensajeErroneo, String MensajeVacio, Boolean ValidarVacio, JDialog modal) {
        if (!((JTextField) fecha.getDateEditor()).getText().equals("__/__/____")) {
            if (!Controlar_Fecha(((JTextField) fecha.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, mensajeErroneo, "Error", JOptionPane.ERROR_MESSAGE);
                fecha.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        }
        if (((JTextField) fecha.getDateEditor()).getText().equals("__/__/____") && ValidarVacio) {
            JOptionPane.showMessageDialog(modal, MensajeVacio, "Error", JOptionPane.ERROR_MESSAGE);
            fecha.getDateEditor().getUiComponent().requestFocus();
            return false;
        }

        return true;
    }

    public String getDecimalString(Double monto) {
        return new DecimalFormat("###,###.##").format(monto);
    }

    public ArrayList<Model_Cuota> TraerCuotas(int Monto, int cuota) {
        ArrayList<Model_Cuota> arrayList = new ArrayList<>();

        int numero = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimal = new DecimalFormat("###,###.##");
        Calendar c = Calendar.getInstance();
        String fecha;
        int division = Monto / cuota;
        int sumador = 0;
        int diferencia = 0;
        while (numero < cuota) {
            Model_Cuota mc = new Model_Cuota();
            numero++;
            c.add(Calendar.MONTH, 1);
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            //obtenemos la fecha
            fecha = (dateFormat.format(c.getTime()));
            mc.setFecha(fecha);
            mc.setCuota(String.valueOf(numero));
            sumador = sumador + division;

            if (numero == cuota) {
                diferencia = Monto - sumador;
            }

            if (diferencia > 0) {
                division = division + diferencia;
            }

            mc.setMonto(decimal.format(division));

            arrayList.add(mc);

        }

        return arrayList;
    }

    public void CentrarCabeceraTabla(JTable jTable) {
        JTableHeader jtableHeader = jTable.getTableHeader();
        DefaultTableCellRenderer rend = (DefaultTableCellRenderer) jTable.getTableHeader().getDefaultRenderer();
        rend.setHorizontalAlignment(JLabel.CENTER);
        jtableHeader.setDefaultRenderer(rend);
    }

    public int getIdCombo(JComboBox<Tools> combo) {
        return combo.getItemAt(combo.getSelectedIndex()).getId();
    }

    public void getDisabledPanel(JPanel panel) {

        for (Component component : panel.getComponents()) {

            component.setEnabled(false);
        }

    }

    public void getEnabledPanel(JPanel panel) {

        for (Component component : panel.getComponents()) {

            component.setEnabled(true);
        }

    }

    public Double getParseString(String value) {
        return Double.parseDouble(value.replace(".", "").replace(",", "."));
    }

    public Double getParseString(JTextField value) {
        return Double.parseDouble(value.getText().replace(".", "").replace(",", "."));
    }
    
    public int getParseIntToString(String value){
        return Integer.parseInt(value.replace(".", "").replace(",", "."));
    }

    public void getMessage(int operacion) {
        switch (operacion) {
            case 1:
                JOptionPane.showMessageDialog(null, "Datos Guardados", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Datos Modificados", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Datos Eliminados", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public Double getParseString(JTable value, int position, int column) {
        return Double.parseDouble(value.getValueAt(position, column).toString().replace(".", "").replace(",", "."));
    }

    public int getParseStringint(JTable value, int position, int column) {
        return Integer.parseInt(value.getValueAt(position, column).toString().replace(".", "").replace(",", "."));
    }

    public java.sql.Date convertUtilToSql(JTable value, int position, int column) {
        try {
            String date = value.getValueAt(position, column).toString();
            SimpleDateFormat fs = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date uDate = fs.parse(date);
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            return sDate;
        } catch (ParseException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    

}
