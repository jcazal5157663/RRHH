/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import clases.*;

import java.awt.Color;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPanel;
import movimiento.*;
import configuracion.*;
import context.*;
import javax.swing.JOptionPane;
import objetos.Model_permisos;
import referenciales.*;


public class menu extends javax.swing.JFrame implements Runnable {

    Ventanas vn = new Ventanas();
    Color entrada = new Color(240, 240, 240);
    Color Salida = new Color(255, 255, 255);
    EstilosLabel lb = new EstilosLabel();
    SimpleDateFormat fHora = new SimpleDateFormat("EEEE, dd' de 'MMMM' del 'yyyy");
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    Tools tools = new Tools();
    Model_permisos permiso = new Model_permisos();
    Object[] options = {"Refrescar Permisos",
        "Salir"
    };

    public menu() {
        initComponents();
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            //lbHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            lblHora.setText(hora);
            lblMinutos.setText(minutos);
            lblSegundos.setText(segundos);
            lblpm.setText(ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void calcula() {
        Calendar cal = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        cal.setTime(fechaHoraActual);
        ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = cal.get(Calendar.HOUR_OF_DAY) - 12;

            if (h == 0) {
                h = 12;
            }

            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = cal.get(Calendar.HOUR_OF_DAY) > 9 ? "" + cal.get(Calendar.HOUR_OF_DAY) : "0" + cal.get(Calendar.HOUR_OF_DAY);
        }
        minutos = cal.get(Calendar.MINUTE) > 9 ? "" + cal.get(Calendar.MINUTE) : "0" + cal.get(Calendar.MINUTE);
        segundos = cal.get(Calendar.SECOND) > 9 ? "" + cal.get(Calendar.SECOND) : "0" + cal.get(Calendar.SECOND);
        lblFecha.setText(ucFirst(fHora.format(new Date())));
    }

    public menu(int iduser, String nombre, Connection conexion) {
        menu.iduser = iduser;
        this.nombre = nombre;
        menu.conexion = conexion;
        initComponents();
        botones();

        h1 = new Thread(this);
        h1.start();
        
        CargarPermisos();
    }

    public static String ucFirst(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length()).toLowerCase();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuUser = new javax.swing.JPopupMenu();
        opciones = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        p_referenciales = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_cargo = new javax.swing.JButton();
        btn_departamento = new javax.swing.JButton();
        btn_direccion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_sector = new javax.swing.JButton();
        btn_sucursales = new javax.swing.JButton();
        btn_tipo_documentó = new javax.swing.JButton();
        btn_bancos = new javax.swing.JButton();
        btn_concepto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btn_forma_cobro = new javax.swing.JButton();
        btn_descuento = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btn_moneda = new javax.swing.JButton();
        btn_pais = new javax.swing.JButton();
        btn_ciudades = new javax.swing.JButton();
        btn_barrios = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btn_pais1 = new javax.swing.JButton();
        btn_pais2 = new javax.swing.JButton();
        btn_pais3 = new javax.swing.JButton();
        btn_pais4 = new javax.swing.JButton();
        btn_moneda1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btn_pais5 = new javax.swing.JButton();
        btn_pais6 = new javax.swing.JButton();
        btn_pais7 = new javax.swing.JButton();
        btn_pais8 = new javax.swing.JButton();
        p_movimiento = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_cargo1 = new javax.swing.JButton();
        btn_cargo2 = new javax.swing.JButton();
        btn_cargo3 = new javax.swing.JButton();
        btn_cargo4 = new javax.swing.JButton();
        btn_cargo6 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        btn_cargo7 = new javax.swing.JButton();
        btn_cargo8 = new javax.swing.JButton();
        p_configuración = new javax.swing.JPanel();
        btnPermisos = new javax.swing.JButton();
        btn_Men = new javax.swing.JButton();
        btn_Mensys = new javax.swing.JButton();
        btn_RolUser = new javax.swing.JButton();
        btn_newUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_reg = new javax.swing.JLabel();
        btn_mov = new javax.swing.JLabel();
        btn_utilitarios = new javax.swing.JLabel();
        btn_informes = new javax.swing.JLabel();
        btn_configuracion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        escritorio = new javax.swing.JDesktopPane();
        jPanel4 = new JPanel();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblMinutos = new javax.swing.JLabel();
        lblSegundos = new javax.swing.JLabel();
        lblMinutos1 = new javax.swing.JLabel();
        lblpm = new javax.swing.JLabel();

        menuUser.setBorder(null);

        opciones.setBackground(new java.awt.Color(255, 255, 255));
        opciones.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        opciones.setText("Opciones");
        opciones.setToolTipText("");
        opciones.setEnabled(false);
        opciones.setOpaque(true);
        menuUser.add(opciones);
        menuUser.add(jSeparator3);

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Configurar");
        jMenuItem1.setOpaque(true);
        menuUser.add(jMenuItem1);

        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("Modificar Perfil");
        jMenuItem2.setOpaque(true);
        menuUser.add(jMenuItem2);

        jMenuItem3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("Salir del Sistema");
        jMenuItem3.setOpaque(true);
        menuUser.add(jMenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.CardLayout());

        p_referenciales.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Opciones");

        btn_cargo.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cargo.setForeground(new java.awt.Color(102, 102, 102));
        btn_cargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bill_14px.png"))); // NOI18N
        btn_cargo.setText("Cargo");
        btn_cargo.setBorderPainted(false);
        btn_cargo.setContentAreaFilled(false);
        btn_cargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo.setFocusPainted(false);
        btn_cargo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cargo.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargoActionPerformed(evt);
            }
        });

        btn_departamento.setBackground(new java.awt.Color(255, 255, 255));
        btn_departamento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_departamento.setForeground(new java.awt.Color(102, 102, 102));
        btn_departamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Name_Tag_14px.png"))); // NOI18N
        btn_departamento.setText("Departamento");
        btn_departamento.setBorderPainted(false);
        btn_departamento.setContentAreaFilled(false);
        btn_departamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_departamento.setFocusPainted(false);
        btn_departamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_departamento.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_departamentoActionPerformed(evt);
            }
        });

        btn_direccion.setBackground(new java.awt.Color(255, 255, 255));
        btn_direccion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_direccion.setForeground(new java.awt.Color(102, 102, 102));
        btn_direccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Price_Tag_14px.png"))); // NOI18N
        btn_direccion.setText("Dirección");
        btn_direccion.setBorderPainted(false);
        btn_direccion.setContentAreaFilled(false);
        btn_direccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_direccion.setFocusPainted(false);
        btn_direccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_direccion.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_direccionActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_sector.setBackground(new java.awt.Color(255, 255, 255));
        btn_sector.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_sector.setForeground(new java.awt.Color(102, 102, 102));
        btn_sector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Git_14px.png"))); // NOI18N
        btn_sector.setText("Sección");
        btn_sector.setBorderPainted(false);
        btn_sector.setContentAreaFilled(false);
        btn_sector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sector.setFocusPainted(false);
        btn_sector.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sector.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_sector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sectorActionPerformed(evt);
            }
        });

        btn_sucursales.setBackground(new java.awt.Color(255, 255, 255));
        btn_sucursales.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_sucursales.setForeground(new java.awt.Color(102, 102, 102));
        btn_sucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Skyscrapers_14px.png"))); // NOI18N
        btn_sucursales.setText("Sucursales");
        btn_sucursales.setBorderPainted(false);
        btn_sucursales.setContentAreaFilled(false);
        btn_sucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sucursales.setFocusPainted(false);
        btn_sucursales.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_sucursales.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_sucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sucursalesActionPerformed(evt);
            }
        });

        btn_tipo_documentó.setBackground(new java.awt.Color(255, 255, 255));
        btn_tipo_documentó.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_tipo_documentó.setForeground(new java.awt.Color(102, 102, 102));
        btn_tipo_documentó.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Slider__14px.png"))); // NOI18N
        btn_tipo_documentó.setText("Tipo Documento");
        btn_tipo_documentó.setBorderPainted(false);
        btn_tipo_documentó.setContentAreaFilled(false);
        btn_tipo_documentó.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tipo_documentó.setFocusPainted(false);
        btn_tipo_documentó.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_tipo_documentó.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_tipo_documentó.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tipo_documentóActionPerformed(evt);
            }
        });

        btn_bancos.setBackground(new java.awt.Color(255, 255, 255));
        btn_bancos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_bancos.setForeground(new java.awt.Color(102, 102, 102));
        btn_bancos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Museum_14px.png"))); // NOI18N
        btn_bancos.setText(" Bancos");
        btn_bancos.setBorderPainted(false);
        btn_bancos.setContentAreaFilled(false);
        btn_bancos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_bancos.setFocusPainted(false);
        btn_bancos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_bancos.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_bancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bancosActionPerformed(evt);
            }
        });

        btn_concepto.setBackground(new java.awt.Color(255, 255, 255));
        btn_concepto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_concepto.setForeground(new java.awt.Color(102, 102, 102));
        btn_concepto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Google_Wallet_14px.png"))); // NOI18N
        btn_concepto.setText("Concepto Salarial");
        btn_concepto.setBorderPainted(false);
        btn_concepto.setContentAreaFilled(false);
        btn_concepto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_concepto.setFocusPainted(false);
        btn_concepto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_concepto.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_concepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conceptoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Opciones Administrativas");

        btn_forma_cobro.setBackground(new java.awt.Color(255, 255, 255));
        btn_forma_cobro.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_forma_cobro.setForeground(new java.awt.Color(102, 102, 102));
        btn_forma_cobro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Refund_14px.png"))); // NOI18N
        btn_forma_cobro.setText("Forma de Cobro");
        btn_forma_cobro.setBorderPainted(false);
        btn_forma_cobro.setContentAreaFilled(false);
        btn_forma_cobro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_forma_cobro.setFocusPainted(false);
        btn_forma_cobro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_forma_cobro.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_forma_cobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_forma_cobroActionPerformed(evt);
            }
        });

        btn_descuento.setBackground(new java.awt.Color(255, 255, 255));
        btn_descuento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_descuento.setForeground(new java.awt.Color(102, 102, 102));
        btn_descuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_descuento.setText("Dìas Feriados");
        btn_descuento.setBorderPainted(false);
        btn_descuento.setContentAreaFilled(false);
        btn_descuento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_descuento.setFocusPainted(false);
        btn_descuento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_descuento.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_descuentoActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_moneda.setBackground(new java.awt.Color(255, 255, 255));
        btn_moneda.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_moneda.setForeground(new java.awt.Color(102, 102, 102));
        btn_moneda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Stack_of_Money_14px.png"))); // NOI18N
        btn_moneda.setText("Moneda");
        btn_moneda.setBorderPainted(false);
        btn_moneda.setContentAreaFilled(false);
        btn_moneda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_moneda.setFocusPainted(false);
        btn_moneda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_moneda.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_moneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_monedaActionPerformed(evt);
            }
        });

        btn_pais.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais.setText("País");
        btn_pais.setBorderPainted(false);
        btn_pais.setContentAreaFilled(false);
        btn_pais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais.setFocusPainted(false);
        btn_pais.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paisActionPerformed(evt);
            }
        });

        btn_ciudades.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_ciudades.setForeground(new java.awt.Color(102, 102, 102));
        btn_ciudades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_ciudades.setText("Ciudades");
        btn_ciudades.setBorderPainted(false);
        btn_ciudades.setContentAreaFilled(false);
        btn_ciudades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ciudades.setFocusPainted(false);
        btn_ciudades.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_ciudades.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_ciudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ciudadesActionPerformed(evt);
            }
        });

        btn_barrios.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_barrios.setForeground(new java.awt.Color(102, 102, 102));
        btn_barrios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_barrios.setText("Barrios");
        btn_barrios.setBorderPainted(false);
        btn_barrios.setContentAreaFilled(false);
        btn_barrios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_barrios.setFocusPainted(false);
        btn_barrios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_barrios.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_barrios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barriosActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Datos Ref. de Planilla Funcionario");

        btn_pais1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais1.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais1.setText("Grupo Sanguíneo");
        btn_pais1.setBorderPainted(false);
        btn_pais1.setContentAreaFilled(false);
        btn_pais1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais1.setFocusPainted(false);
        btn_pais1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais1.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pais1ActionPerformed(evt);
            }
        });

        btn_pais2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais2.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais2.setText("Colegio/Universidades");
        btn_pais2.setBorderPainted(false);
        btn_pais2.setContentAreaFilled(false);
        btn_pais2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais2.setFocusPainted(false);
        btn_pais2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais2.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pais2ActionPerformed(evt);
            }
        });

        btn_pais3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais3.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais3.setText("Profesiones");
        btn_pais3.setBorderPainted(false);
        btn_pais3.setContentAreaFilled(false);
        btn_pais3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais3.setFocusPainted(false);
        btn_pais3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais3.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pais3ActionPerformed(evt);
            }
        });

        btn_pais4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais4.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais4.setText("Títulos");
        btn_pais4.setBorderPainted(false);
        btn_pais4.setContentAreaFilled(false);
        btn_pais4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais4.setFocusPainted(false);
        btn_pais4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais4.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pais4ActionPerformed(evt);
            }
        });

        btn_moneda1.setBackground(new java.awt.Color(255, 255, 255));
        btn_moneda1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_moneda1.setForeground(new java.awt.Color(102, 102, 102));
        btn_moneda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Stack_of_Money_14px.png"))); // NOI18N
        btn_moneda1.setText("Descuentos");
        btn_moneda1.setBorderPainted(false);
        btn_moneda1.setContentAreaFilled(false);
        btn_moneda1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_moneda1.setFocusPainted(false);
        btn_moneda1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_moneda1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_moneda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moneda1ActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_pais5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais5.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais5.setText("Tipo de Contrato");
        btn_pais5.setBorderPainted(false);
        btn_pais5.setContentAreaFilled(false);
        btn_pais5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais5.setFocusPainted(false);
        btn_pais5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais5.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pais5ActionPerformed(evt);
            }
        });

        btn_pais6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais6.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais6.setText("Tipo de Empleado");
        btn_pais6.setBorderPainted(false);
        btn_pais6.setContentAreaFilled(false);
        btn_pais6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais6.setFocusPainted(false);
        btn_pais6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais6.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pais6ActionPerformed(evt);
            }
        });

        btn_pais7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais7.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais7.setText("Tipo de Amonestaciones");
        btn_pais7.setBorderPainted(false);
        btn_pais7.setContentAreaFilled(false);
        btn_pais7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais7.setFocusPainted(false);
        btn_pais7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais7.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pais7ActionPerformed(evt);
            }
        });

        btn_pais8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_pais8.setForeground(new java.awt.Color(102, 102, 102));
        btn_pais8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Tax_14px.png"))); // NOI18N
        btn_pais8.setText("Tipo de Cortesía");
        btn_pais8.setBorderPainted(false);
        btn_pais8.setContentAreaFilled(false);
        btn_pais8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pais8.setFocusPainted(false);
        btn_pais8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pais8.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_pais8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pais8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_referencialesLayout = new javax.swing.GroupLayout(p_referenciales);
        p_referenciales.setLayout(p_referencialesLayout);
        p_referencialesLayout.setHorizontalGroup(
            p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_referencialesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_referencialesLayout.createSequentialGroup()
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_direccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_departamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cargo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_sucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_tipo_documentó, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(p_referencialesLayout.createSequentialGroup()
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_forma_cobro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(btn_concepto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(btn_bancos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_descuento, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(btn_moneda, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(btn_moneda1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_referencialesLayout.createSequentialGroup()
                        .addComponent(btn_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pais1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p_referencialesLayout.createSequentialGroup()
                        .addComponent(btn_ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pais2))
                    .addGroup(p_referencialesLayout.createSequentialGroup()
                        .addComponent(btn_barrios, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pais3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_pais5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pais6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pais4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_pais7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pais8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(228, 228, 228))
        );
        p_referencialesLayout.setVerticalGroup(
            p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(p_referencialesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_referencialesLayout.createSequentialGroup()
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pais1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pais4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pais7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ciudades, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pais2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pais5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pais8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_barrios, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pais3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_pais6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(p_referencialesLayout.createSequentialGroup()
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p_referencialesLayout.createSequentialGroup()
                                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_bancos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_concepto, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_moneda, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_forma_cobro, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_moneda1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_referencialesLayout.createSequentialGroup()
                                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_sucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_tipo_documentó, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(p_referencialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel2.add(p_referenciales, "card2");

        p_movimiento.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Funcionario");

        btn_cargo1.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargo1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cargo1.setForeground(new java.awt.Color(102, 102, 102));
        btn_cargo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bill_14px.png"))); // NOI18N
        btn_cargo1.setText("Persona/Funcionario");
        btn_cargo1.setBorderPainted(false);
        btn_cargo1.setContentAreaFilled(false);
        btn_cargo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo1.setFocusPainted(false);
        btn_cargo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cargo1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_cargo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo1ActionPerformed(evt);
            }
        });

        btn_cargo2.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargo2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cargo2.setForeground(new java.awt.Color(102, 102, 102));
        btn_cargo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bill_14px.png"))); // NOI18N
        btn_cargo2.setText("Registrar Contrato");
        btn_cargo2.setBorderPainted(false);
        btn_cargo2.setContentAreaFilled(false);
        btn_cargo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo2.setFocusPainted(false);
        btn_cargo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cargo2.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_cargo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo2ActionPerformed(evt);
            }
        });

        btn_cargo3.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargo3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cargo3.setForeground(new java.awt.Color(102, 102, 102));
        btn_cargo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bill_14px.png"))); // NOI18N
        btn_cargo3.setText("Descuentos");
        btn_cargo3.setBorderPainted(false);
        btn_cargo3.setContentAreaFilled(false);
        btn_cargo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo3.setFocusPainted(false);
        btn_cargo3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cargo3.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_cargo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo3ActionPerformed(evt);
            }
        });

        btn_cargo4.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargo4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cargo4.setForeground(new java.awt.Color(102, 102, 102));
        btn_cargo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bill_14px.png"))); // NOI18N
        btn_cargo4.setText("Solicitud de Anticipos Manual");
        btn_cargo4.setBorderPainted(false);
        btn_cargo4.setContentAreaFilled(false);
        btn_cargo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo4.setFocusPainted(false);
        btn_cargo4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cargo4.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_cargo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo4ActionPerformed(evt);
            }
        });

        btn_cargo6.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargo6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cargo6.setForeground(new java.awt.Color(102, 102, 102));
        btn_cargo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bill_14px.png"))); // NOI18N
        btn_cargo6.setText("Aporte Funcionario");
        btn_cargo6.setBorderPainted(false);
        btn_cargo6.setContentAreaFilled(false);
        btn_cargo6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo6.setFocusPainted(false);
        btn_cargo6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cargo6.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_cargo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo6ActionPerformed(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sanciones");

        btn_cargo7.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargo7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cargo7.setForeground(new java.awt.Color(102, 102, 102));
        btn_cargo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bill_14px.png"))); // NOI18N
        btn_cargo7.setText("Amonestación de Funcionario");
        btn_cargo7.setBorderPainted(false);
        btn_cargo7.setContentAreaFilled(false);
        btn_cargo7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo7.setFocusPainted(false);
        btn_cargo7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cargo7.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_cargo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo7ActionPerformed(evt);
            }
        });

        btn_cargo8.setBackground(new java.awt.Color(255, 255, 255));
        btn_cargo8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cargo8.setForeground(new java.awt.Color(102, 102, 102));
        btn_cargo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bill_14px.png"))); // NOI18N
        btn_cargo8.setText("Horario de Funcionario");
        btn_cargo8.setBorderPainted(false);
        btn_cargo8.setContentAreaFilled(false);
        btn_cargo8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo8.setFocusPainted(false);
        btn_cargo8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cargo8.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btn_cargo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargo8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_movimientoLayout = new javax.swing.GroupLayout(p_movimiento);
        p_movimiento.setLayout(p_movimientoLayout);
        p_movimientoLayout.setHorizontalGroup(
            p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_movimientoLayout.createSequentialGroup()
                .addGroup(p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(p_movimientoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cargo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cargo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cargo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cargo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cargo6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_cargo7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cargo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(748, 748, 748))
        );
        p_movimientoLayout.setVerticalGroup(
            p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(p_movimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_movimientoLayout.createSequentialGroup()
                        .addGroup(p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cargo1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cargo4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p_movimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cargo2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cargo6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cargo3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_movimientoLayout.createSequentialGroup()
                        .addComponent(btn_cargo7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cargo8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12))))
        );

        jPanel2.add(p_movimiento, "card3");

        p_configuración.setBackground(new java.awt.Color(255, 255, 255));

        btnPermisos.setBackground(new java.awt.Color(255, 255, 255));
        btnPermisos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnPermisos.setForeground(new java.awt.Color(102, 102, 102));
        btnPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Access_32px.png"))); // NOI18N
        btnPermisos.setText("<html>Permisos de<br><p align='center'>Usuario</p></html>");
        btnPermisos.setBorderPainted(false);
        btnPermisos.setContentAreaFilled(false);
        btnPermisos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPermisos.setFocusPainted(false);
        btnPermisos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPermisos.setIconTextGap(0);
        btnPermisos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPermisos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisosActionPerformed(evt);
            }
        });

        btn_Men.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_Men.setForeground(new java.awt.Color(102, 102, 102));
        btn_Men.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Todo_List_18px.png"))); // NOI18N
        btn_Men.setText("Cabecera de Menú");
        btn_Men.setBorderPainted(false);
        btn_Men.setContentAreaFilled(false);
        btn_Men.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Men.setFocusPainted(false);
        btn_Men.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Men.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_Men.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenActionPerformed(evt);
            }
        });

        btn_Mensys.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_Mensys.setForeground(new java.awt.Color(102, 102, 102));
        btn_Mensys.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_List_18px.png"))); // NOI18N
        btn_Mensys.setText("Menus del Sistema");
        btn_Mensys.setBorderPainted(false);
        btn_Mensys.setContentAreaFilled(false);
        btn_Mensys.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Mensys.setFocusPainted(false);
        btn_Mensys.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Mensys.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_Mensys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MensysActionPerformed(evt);
            }
        });

        btn_RolUser.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_RolUser.setForeground(new java.awt.Color(102, 102, 102));
        btn_RolUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_User_Menu_Male_18px.png"))); // NOI18N
        btn_RolUser.setText("Roles de Usuario");
        btn_RolUser.setBorderPainted(false);
        btn_RolUser.setContentAreaFilled(false);
        btn_RolUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_RolUser.setFocusPainted(false);
        btn_RolUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_RolUser.setMargin(new java.awt.Insets(2, 0, 0, 0));
        btn_RolUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RolUserActionPerformed(evt);
            }
        });

        btn_newUser.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_newUser.setForeground(new java.awt.Color(102, 102, 102));
        btn_newUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_User_Location_32px_1.png"))); // NOI18N
        btn_newUser.setText("<html><center>Nuevo<br>Usuario</center></html>");
        btn_newUser.setBorderPainted(false);
        btn_newUser.setContentAreaFilled(false);
        btn_newUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_newUser.setFocusPainted(false);
        btn_newUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_newUser.setIconTextGap(0);
        btn_newUser.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_newUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_newUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_configuraciónLayout = new javax.swing.GroupLayout(p_configuración);
        p_configuración.setLayout(p_configuraciónLayout);
        p_configuraciónLayout.setHorizontalGroup(
            p_configuraciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_configuraciónLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p_configuraciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_configuraciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_RolUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Mensys))
                    .addComponent(btn_Men))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_newUser, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(972, Short.MAX_VALUE))
        );
        p_configuraciónLayout.setVerticalGroup(
            p_configuraciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_configuraciónLayout.createSequentialGroup()
                .addGroup(p_configuraciónLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_newUser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnPermisos, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(p_configuraciónLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_RolUser, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Mensys, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Men, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(p_configuración, "card4");

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SISTEMA DE RECURSOS HUMANOS \"Mapachesys\"");

        btn_reg.setBackground(new java.awt.Color(0, 102, 204));
        btn_reg.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        btn_reg.setForeground(new java.awt.Color(255, 255, 255));
        btn_reg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_reg.setText("REGISTRO");
        btn_reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reg.setOpaque(true);
        btn_reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_regMouseReleased(evt);
            }
        });

        btn_mov.setBackground(new java.awt.Color(255, 255, 255));
        btn_mov.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        btn_mov.setForeground(new java.awt.Color(102, 102, 102));
        btn_mov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_mov.setText("MOVIMIENTO");
        btn_mov.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_mov.setOpaque(true);
        btn_mov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_movMouseReleased(evt);
            }
        });

        btn_utilitarios.setBackground(new java.awt.Color(255, 255, 255));
        btn_utilitarios.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        btn_utilitarios.setForeground(new java.awt.Color(102, 102, 102));
        btn_utilitarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_utilitarios.setText("UTILITARIOS");
        btn_utilitarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_utilitarios.setOpaque(true);

        btn_informes.setBackground(new java.awt.Color(255, 255, 255));
        btn_informes.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        btn_informes.setForeground(new java.awt.Color(102, 102, 102));
        btn_informes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_informes.setText("INFORMES");
        btn_informes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_informes.setOpaque(true);

        btn_configuracion.setBackground(new java.awt.Color(255, 255, 255));
        btn_configuracion.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        btn_configuracion.setForeground(new java.awt.Color(102, 102, 102));
        btn_configuracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_configuracion.setText("CONFIGURACIÓN");
        btn_configuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_configuracion.setOpaque(true);
        btn_configuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_configuracionMouseReleased(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("José Luis Cazal");
        jLabel8.setComponentPopupMenu(menuUser);
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_mov, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_utilitarios, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_informes, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mov, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_utilitarios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_informes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        escritorio.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lblHora.setBackground(new java.awt.Color(51, 51, 51));
        lblHora.setFont(new java.awt.Font("Segoe UI Black", 0, 70)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHora.setText("00");
        lblHora.setOpaque(true);

        lblFecha.setBackground(new java.awt.Color(51, 51, 51));
        lblFecha.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("jLabel12");
        lblFecha.setOpaque(true);

        lblMinutos.setBackground(new java.awt.Color(51, 51, 51));
        lblMinutos.setFont(new java.awt.Font("Segoe UI Black", 0, 70)); // NOI18N
        lblMinutos.setForeground(new java.awt.Color(255, 255, 255));
        lblMinutos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMinutos.setText("00");
        lblMinutos.setOpaque(true);

        lblSegundos.setBackground(new java.awt.Color(51, 51, 51));
        lblSegundos.setFont(new java.awt.Font("Segoe UI Black", 0, 42)); // NOI18N
        lblSegundos.setForeground(new java.awt.Color(255, 255, 255));
        lblSegundos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSegundos.setText("00");
        lblSegundos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblSegundos.setOpaque(true);

        lblMinutos1.setBackground(new java.awt.Color(51, 51, 51));
        lblMinutos1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lblMinutos1.setForeground(new java.awt.Color(255, 255, 255));
        lblMinutos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinutos1.setText(":");
        lblMinutos1.setOpaque(true);

        lblpm.setBackground(new java.awt.Color(51, 51, 51));
        lblpm.setFont(new java.awt.Font("Segoe UI Black", 0, 42)); // NOI18N
        lblpm.setForeground(new java.awt.Color(255, 255, 255));
        lblpm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpm.setText("PM");
        lblpm.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblpm.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblMinutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpm, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMinutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMinutos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblpm, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lblSegundos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        escritorio.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(escritorio)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(escritorio))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_departamentoActionPerformed
        departamento dir = new departamento();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_departamentoActionPerformed

    private void btn_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargoActionPerformed
        cargo dir = new cargo();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_cargoActionPerformed

    private void btn_sectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sectorActionPerformed
        seccion dir = new seccion();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_sectorActionPerformed

    private void btn_sucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sucursalesActionPerformed
        sucursales dir = new sucursales();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_sucursalesActionPerformed

    private void btn_tipo_documentóActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tipo_documentóActionPerformed
        tipo_documento dir = new tipo_documento();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_tipo_documentóActionPerformed

    private void btn_bancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bancosActionPerformed
        bancos dir = new bancos();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_bancosActionPerformed

    private void btn_conceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conceptoActionPerformed
        concepto dir = new concepto();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_conceptoActionPerformed

    private void btn_forma_cobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_forma_cobroActionPerformed
        forma_cobro dir = new forma_cobro();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_forma_cobroActionPerformed

    private void btn_descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_descuentoActionPerformed
        dias_feriados dir = new dias_feriados();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_descuentoActionPerformed

    private void btn_monedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_monedaActionPerformed
        moneda dir = new moneda();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_monedaActionPerformed

    private void btn_paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paisActionPerformed
        pais dir = new pais();

        vn.Abrir_ventana(escritorio, dir, true);

    }//GEN-LAST:event_btn_paisActionPerformed

    private void btn_ciudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ciudadesActionPerformed
        ciudades dir = new ciudades();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_ciudadesActionPerformed

    private void btn_barriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barriosActionPerformed
        barrios dir = new barrios();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_barriosActionPerformed

    private void btn_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_direccionActionPerformed
        direccion dir = new direccion();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_direccionActionPerformed

    private void btn_pais1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pais1ActionPerformed
        grupo_sanguineo dir = new grupo_sanguineo();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_pais1ActionPerformed

    private void btn_pais2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pais2ActionPerformed
        institutos_estudios dir = new institutos_estudios();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_pais2ActionPerformed

    private void btn_pais3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pais3ActionPerformed
        profesiones dir = new profesiones();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_pais3ActionPerformed

    private void btn_pais4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pais4ActionPerformed
        titulos dir = new titulos();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_pais4ActionPerformed

    private void btn_moneda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moneda1ActionPerformed
        tipo_descuento dir = new tipo_descuento();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_moneda1ActionPerformed

    private void btn_movMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_movMouseReleased
        p_movimiento.setVisible(true);
        p_referenciales.setVisible(false);
    }//GEN-LAST:event_btn_movMouseReleased

    private void btn_regMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_regMouseReleased
        p_movimiento.setVisible(false);
        p_referenciales.setVisible(true);
    }//GEN-LAST:event_btn_regMouseReleased

    private void btn_cargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo1ActionPerformed
        reg_persona_funcionario dir = new reg_persona_funcionario();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_cargo1ActionPerformed

    private void btn_pais5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pais5ActionPerformed
        tipo_contrato dir = new tipo_contrato();
        vn.Abrir_ventana(escritorio, dir, true);

    }//GEN-LAST:event_btn_pais5ActionPerformed

    private void btn_pais6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pais6ActionPerformed
        tipo_empleado dir = new tipo_empleado();
        vn.Abrir_ventana(escritorio, dir, true);

    }//GEN-LAST:event_btn_pais6ActionPerformed

    private void btn_cargo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo2ActionPerformed
        contratos dir = new contratos();
        vn.Abrir_ventana(escritorio, dir, true);
    }//GEN-LAST:event_btn_cargo2ActionPerformed

    private void btn_cargo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo3ActionPerformed
        dcto_funcionario desc = new dcto_funcionario();
        vn.Abrir_ventana(escritorio, desc, true);
    }//GEN-LAST:event_btn_cargo3ActionPerformed

    private void btn_cargo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo4ActionPerformed
        sol_anticipo desc = new sol_anticipo();
        vn.Abrir_ventana(escritorio, desc, true);
    }//GEN-LAST:event_btn_cargo4ActionPerformed

    private void btn_configuracionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_configuracionMouseReleased
        p_movimiento.setVisible(false);
        p_referenciales.setVisible(false);
        p_configuración.setVisible(true);

    }//GEN-LAST:event_btn_configuracionMouseReleased

    private void btn_cargo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo6ActionPerformed
        aportes_funcionario ap = new aportes_funcionario();
        vn.Abrir_ventana(escritorio, ap, true);
    }//GEN-LAST:event_btn_cargo6ActionPerformed

    private void btn_pais7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pais7ActionPerformed
        tipo_amonestaciones ap = new tipo_amonestaciones();
        vn.Abrir_ventana(escritorio, ap, true);
    }//GEN-LAST:event_btn_pais7ActionPerformed

    private void btn_cargo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo7ActionPerformed
        amonestaciones ap = new amonestaciones();
        vn.Abrir_ventana(escritorio, ap, true);
    }//GEN-LAST:event_btn_cargo7ActionPerformed

    private void btn_pais8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pais8ActionPerformed
        tipo_cortesia ap = new tipo_cortesia();
        vn.Abrir_ventana(escritorio, ap, true);
    }//GEN-LAST:event_btn_pais8ActionPerformed

    private void btn_cargo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargo8ActionPerformed
        horariofuncionario ap = new horariofuncionario();
        vn.Abrir_ventana(escritorio, ap, true);
    }//GEN-LAST:event_btn_cargo8ActionPerformed

    private void btnPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisosActionPerformed
        permiso = new Tools().permisoMenu(1);

        if (permiso.getAcceder()) {
            permisosMenu cab = new permisosMenu(permiso);
            vn.Abrir_ventana(escritorio, cab, true);
        } else {
            int i = JOptionPane.showOptionDialog(this,
                    AppContext.MENSAJE_PERMISO_DENEGADO,
                    "Acceso Restringido",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null,//do not use a custom Icon
                    options,//the titles of buttons
                    options[0]);//default button title
            if (i == 0) {
                CargarPermisos();
            }
        }
    }//GEN-LAST:event_btnPermisosActionPerformed

    private void btn_MenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenActionPerformed
        permiso = new Tools().permisoMenu(2);

        if (permiso.getAcceder()) {
            menuCab cab = new menuCab(permiso);
            vn.Abrir_ventana(escritorio, cab, true);
        } else {
            int i = JOptionPane.showOptionDialog(this,
                    AppContext.MENSAJE_PERMISO_DENEGADO,
                    "Acceso Restringido",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null,//do not use a custom Icon
                    options,//the titles of buttons
                    options[0]);//default button title
            if (i == 0) {
                CargarPermisos();
            }
        }
    }//GEN-LAST:event_btn_MenActionPerformed

    private void btn_MensysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MensysActionPerformed
        permiso = new Tools().permisoMenu(3);

        if (permiso.getAcceder()) {
            menuDet cab = new menuDet(permiso);
            vn.Abrir_ventana(escritorio, cab, true);
        } else {
            int i = JOptionPane.showOptionDialog(this,
                    AppContext.MENSAJE_PERMISO_DENEGADO,
                    "Acceso Restringido",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null,//do not use a custom Icon
                    options,//the titles of buttons
                    options[0]);//default button title
            if (i == 0) {
                CargarPermisos();
            }
        }
    }//GEN-LAST:event_btn_MensysActionPerformed

    private void btn_RolUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RolUserActionPerformed

        permiso = new Tools().permisoMenu(4);
        if (permiso.getAcceder()) {

            roles_usuario ru = new roles_usuario(permiso);
            vn.Abrir_ventana(escritorio, ru, true);

        } else {
            int i = JOptionPane.showOptionDialog(this,
                    AppContext.MENSAJE_PERMISO_DENEGADO,
                    "Acceso Restringido",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null,//do not use a custom Icon
                    options,//the titles of buttons
                    options[0]);//default button title
            if (i == 0) {
                CargarPermisos();
            }
        }
    }//GEN-LAST:event_btn_RolUserActionPerformed

    private void btn_newUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newUserActionPerformed
        permiso = new Tools().permisoMenu(5);

        if (permiso.getAcceder()) {
            usuarios fac = new usuarios(permiso);
            vn.Abrir_ventana(escritorio, fac, true);
        } else {
            int i = JOptionPane.showOptionDialog(this,
                    AppContext.MENSAJE_PERMISO_DENEGADO,
                    "Acceso Restringido",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null,//do not use a custom Icon
                    options,//the titles of buttons
                    options[0]);//default button title
            if (i == 0) {
                CargarPermisos();
            }

        }
    }//GEN-LAST:event_btn_newUserActionPerformed

    private static int iduser;
    private String nombre;
    private static Connection conexion;

    public static int getIduser() {
        return iduser;
    }

    public static void setIduser(int iduser) {
        menu.iduser = iduser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        menu.conexion = conexion;
    }
    
    
        private void CargarPermisos() {

        String sql = "select menu_det, acceder, nuevo, editar, eliminar, informes from permiso_menu\n"
                + "where roles_usuarios = " + AppContext.ROL_USUARIO + "\n"
                + "order by id";
        new Tools().CargarPermiso(sql, menu.getConexion());
        //ConsultarPermisos();

    }
    

    private void botones() {
        lb.CambiarColor(btn_cargo, entrada, Salida);
        lb.CambiarColor(btn_departamento, entrada, Salida);
        lb.CambiarColor(btn_direccion, entrada, Salida);
        lb.CambiarColor(btn_sector, entrada, Salida);
        lb.CambiarColor(btn_sucursales, entrada, Salida);
        lb.CambiarColor(btn_tipo_documentó, entrada, Salida);
        lb.CambiarColor(btn_bancos, entrada, Salida);
        lb.CambiarColor(btn_concepto, entrada, Salida);
        lb.CambiarColor(btn_forma_cobro, entrada, Salida);
        lb.CambiarColor(btn_descuento, entrada, Salida);
        lb.CambiarColor(btn_moneda, entrada, Salida);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPermisos;
    private javax.swing.JButton btn_Men;
    private javax.swing.JButton btn_Mensys;
    private javax.swing.JButton btn_RolUser;
    private javax.swing.JButton btn_bancos;
    private javax.swing.JButton btn_barrios;
    private javax.swing.JButton btn_cargo;
    private javax.swing.JButton btn_cargo1;
    private javax.swing.JButton btn_cargo2;
    private javax.swing.JButton btn_cargo3;
    private javax.swing.JButton btn_cargo4;
    private javax.swing.JButton btn_cargo6;
    private javax.swing.JButton btn_cargo7;
    private javax.swing.JButton btn_cargo8;
    private javax.swing.JButton btn_ciudades;
    private javax.swing.JButton btn_concepto;
    private javax.swing.JLabel btn_configuracion;
    private javax.swing.JButton btn_departamento;
    private javax.swing.JButton btn_descuento;
    private javax.swing.JButton btn_direccion;
    private javax.swing.JButton btn_forma_cobro;
    private javax.swing.JLabel btn_informes;
    private javax.swing.JButton btn_moneda;
    private javax.swing.JButton btn_moneda1;
    private javax.swing.JLabel btn_mov;
    private javax.swing.JButton btn_newUser;
    private javax.swing.JButton btn_pais;
    private javax.swing.JButton btn_pais1;
    private javax.swing.JButton btn_pais2;
    private javax.swing.JButton btn_pais3;
    private javax.swing.JButton btn_pais4;
    private javax.swing.JButton btn_pais5;
    private javax.swing.JButton btn_pais6;
    private javax.swing.JButton btn_pais7;
    private javax.swing.JButton btn_pais8;
    private javax.swing.JLabel btn_reg;
    private javax.swing.JButton btn_sector;
    private javax.swing.JButton btn_sucursales;
    private javax.swing.JButton btn_tipo_documentó;
    private javax.swing.JLabel btn_utilitarios;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMinutos;
    private javax.swing.JLabel lblMinutos1;
    private javax.swing.JLabel lblSegundos;
    private javax.swing.JLabel lblpm;
    private javax.swing.JPopupMenu menuUser;
    private javax.swing.JMenuItem opciones;
    private javax.swing.JPanel p_configuración;
    private javax.swing.JPanel p_movimiento;
    private javax.swing.JPanel p_referenciales;
    // End of variables declaration//GEN-END:variables

}
