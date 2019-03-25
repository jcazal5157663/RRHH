package movimiento;

import buscadores.buscador_Funcionario;

import java.util.Date;
import clases.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import objetos.Model_Cuota;
import principal.menu;

public class dcto_funcionario extends javax.swing.JInternalFrame {

    EstilosLabel lb = new EstilosLabel();
    Color entrada = new Color(44, 59, 65);
    Color Salida = new Color(34, 45, 50);
    int xx;
    int xy;
    int operacion = 0;
    DefaultTableModel modelo;
    DefaultTableModel modeloCuota;
    private String sql = "";
    Tools db = new Tools();
    int idFuncionario = 0;
    String res[];
    int dias = 0;
    int iddescuento = 0;

    public dcto_funcionario() {
        initComponents();
        lb.CambiarColor(btn_nuevo, entrada, Salida);
        lb.CambiarColor(btn_modificar, entrada, Salida);
        lb.CambiarColor(btn_eliminar, entrada, Salida);
        lb.CambiarColor(btn_cerrar, entrada, Salida);
        lb.CambiarColor(btn_informes, entrada, Salida);
        modelo = (DefaultTableModel) tbl_dcto.getModel();
        modeloCuota = (DefaultTableModel) tblCuota.getModel();
        CargarGrilla();
        CargarCombo();
        validarCaracteres();

        db.CentrarCabeceraTabla(tblCuota);

        fecha_vencimiento.setEnabled(true);
        txtCuota.setEnabled(false);
        btnGenCuotas.setEnabled(false);
        EventoCombo();
        db.getDisabledPanel(jpCalculo);
        addKeyEvent();

        db.Busqued(tbl_dcto, modelo, txtBusqueda);

        new Cerrar_Escape().addEscapeListener(this);

        sql = "select fraccionable from tipo_descuentos \n"
                + "where id = ?";
        PreparedStatement ps;
        try {
            ps = menu.getConexion().prepareCall(sql);
            ps.setInt(1, db.getIdCombo(cbTipoDcto));
            res = db.QueryDinamico(ps);
        } catch (SQLException ex) {
            Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (res[1].equals("t")) {
            cbFraccionar.setEnabled(true);
        } else {
            cbFraccionar.setEnabled(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modal = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnSaveAplication = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCuota = new javax.swing.JTable();
        jpCalculo = new javax.swing.JPanel();
        fecha_desde = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        fecha_hasta = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        checkSabado = new javax.swing.JCheckBox();
        chekDomingo = new javax.swing.JCheckBox();
        btnCalcula = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtDias = new javax.swing.JTextField();
        btnCalcDcto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtFuncionario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        cbTipoDcto = new javax.swing.JComboBox<>();
        txtSalario = new javax.swing.JTextField();
        txtSueldoporDia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCuota = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        fecha_vencimiento = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        cbFraccionar = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnFuncionario = new javax.swing.JButton();
        btnGenCuotas = new javax.swing.JButton();
        modal_informes = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        btn_informes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dcto = new javax.swing.JTable();

        modal.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        modal.setModal(true);
        modal.setUndecorated(true);
        modal.setResizable(false);
        modal.setSize(new java.awt.Dimension(563, 430));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Save_32px.png"))); // NOI18N
        btnSave.setMnemonic('G');
        btnSave.setText("Guardar Alt+G");
        btnSave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSave.setContentAreaFilled(false);
        btnSave.setIconTextGap(0);
        btnSave.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSaveAplication.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Checkmark_32px.png"))); // NOI18N
        btnSaveAplication.setMnemonic('A');
        btnSaveAplication.setText("Guardar y Continuar Alt+A");
        btnSaveAplication.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSaveAplication.setContentAreaFilled(false);
        btnSaveAplication.setIconTextGap(0);
        btnSaveAplication.setMargin(new java.awt.Insets(2, 0, 2, 0));
        btnSaveAplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAplicationActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCuota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuota", "F. Venc", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCuota);

        jpCalculo.setBackground(new java.awt.Color(255, 255, 255));
        jpCalculo.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuadro de Calculo de Dcto. por Ausencia"));

        fecha_desde.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Desde"));

        fecha_hasta.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Hasta"));

        checkSabado.setText("Considerar Sábado");

        chekDomingo.setText("Considerar Domingo");

        btnCalcula.setText("Calcular Días");
        btnCalcula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculaActionPerformed(evt);
            }
        });

        jLabel11.setText("Total Días");

        txtDias.setEditable(false);
        txtDias.setBackground(new java.awt.Color(255, 255, 255));
        txtDias.setForeground(new java.awt.Color(51, 153, 255));
        txtDias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDias.setText("0");

        btnCalcDcto.setText("Cal. Descto");
        btnCalcDcto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcDctoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCalculoLayout = new javax.swing.GroupLayout(jpCalculo);
        jpCalculo.setLayout(jpCalculoLayout);
        jpCalculoLayout.setHorizontalGroup(
            jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCalculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCalculoLayout.createSequentialGroup()
                        .addComponent(fecha_desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(fecha_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCalculoLayout.createSequentialGroup()
                        .addGroup(jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCalculoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDias))
                            .addComponent(chekDomingo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkSabado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCalcula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCalcDcto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpCalculoLayout.setVerticalGroup(
            jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCalculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCalculoLayout.createSequentialGroup()
                        .addComponent(checkSabado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chekDomingo)
                            .addComponent(btnCalcula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpCalculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCalculoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCalcDcto)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jpCalculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 51));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Registro de descuentos del Funcionario");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Delete_24px.png"))); // NOI18N
        jButton5.setMnemonic('X');
        jButton5.setToolTipText("Presione Alt+X para salir");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusable(false);
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5)
        );

        txtFuncionario.setEditable(false);
        txtFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        txtFuncionario.setForeground(new java.awt.Color(51, 153, 255));

        jLabel2.setText("Funcionario:");

        jLabel3.setText("Tipo de Descuento:");

        jLabel4.setText("Monto:");

        txtMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonto.setText("0");

        txtSalario.setEditable(false);
        txtSalario.setBackground(new java.awt.Color(255, 255, 255));
        txtSalario.setForeground(new java.awt.Color(51, 153, 255));
        txtSalario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSalario.setText("0");

        txtSueldoporDia.setEditable(false);
        txtSueldoporDia.setBackground(new java.awt.Color(255, 255, 255));
        txtSueldoporDia.setForeground(new java.awt.Color(51, 153, 255));
        txtSueldoporDia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSueldoporDia.setText("0");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Sueldo por Día:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Sueldo:");

        txtCuota.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        txtCuota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuotaKeyTyped(evt);
            }
        });

        jLabel7.setText("Cuotas:");

        cbFraccionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Sí" }));
        cbFraccionar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFraccionarItemStateChanged(evt);
            }
        });

        jLabel5.setText("Fraccionar:");

        jLabel6.setText("Fecha de Vencimiento:");

        btnFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btnFuncionario.setContentAreaFilled(false);
        btnFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFuncionario.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioActionPerformed(evt);
            }
        });

        btnGenCuotas.setText("Generar Cuotas");
        btnGenCuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenCuotasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbTipoDcto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMonto)
                                    .addComponent(cbFraccionar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha_vencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnGenCuotas))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSalario)
                                            .addComponent(txtSueldoporDia)))))
                            .addComponent(txtFuncionario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFuncionario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveAplication, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTipoDcto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtSueldoporDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbFraccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fecha_vencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnGenCuotas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveAplication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout modalLayout = new javax.swing.GroupLayout(modal.getContentPane());
        modal.getContentPane().setLayout(modalLayout);
        modalLayout.setHorizontalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modalLayout.setVerticalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(56, 56, 56));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(33, 150, 243));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Informes > Descuento Funcionario");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(232, 232, 232));

        jButton1.setBackground(new java.awt.Color(0, 77, 64));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ver Informe");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setOpaque(true);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jScrollPane3.setBorder(null);

        jList1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Descuentos por Resumen de Fecha", "Descuentos por Tipo de Descuentos", "Descuentos por Funcionarios", "Descuentos Activos", "Descuentos Pagados" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectionBackground(new java.awt.Color(232, 232, 232));
        jList1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jList1.setValueIsAdjusting(true);
        jList1.setVisibleRowCount(20);
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout modal_informesLayout = new javax.swing.GroupLayout(modal_informes.getContentPane());
        modal_informes.getContentPane().setLayout(modal_informesLayout);
        modal_informesLayout.setHorizontalGroup(
            modal_informesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modal_informesLayout.setVerticalGroup(
            modal_informesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(34, 45, 50));

        jLabel1.setBackground(new java.awt.Color(58, 128, 167));
        jLabel1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reg. de Descuento Fun.");
        jLabel1.setOpaque(true);

        btn_nuevo.setBackground(new java.awt.Color(34, 45, 50));
        btn_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_nuevo.setForeground(new java.awt.Color(204, 204, 204));
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Add_New_32px.png"))); // NOI18N
        btn_nuevo.setMnemonic('N');
        btn_nuevo.setText("Nuevo Alt+N");
        btn_nuevo.setBorderPainted(false);
        btn_nuevo.setContentAreaFilled(false);
        btn_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nuevo.setFocusPainted(false);
        btn_nuevo.setFocusable(false);
        btn_nuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_nuevo.setOpaque(true);
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_modificar.setBackground(new java.awt.Color(34, 45, 50));
        btn_modificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(204, 204, 204));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Edit_32px.png"))); // NOI18N
        btn_modificar.setMnemonic('M');
        btn_modificar.setText("Modificar Alt+M");
        btn_modificar.setBorderPainted(false);
        btn_modificar.setContentAreaFilled(false);
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.setFocusPainted(false);
        btn_modificar.setFocusable(false);
        btn_modificar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_modificar.setOpaque(true);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(34, 45, 50));
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(204, 204, 204));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Trash_32px.png"))); // NOI18N
        btn_eliminar.setMnemonic('E');
        btn_eliminar.setText("Eliminar Alt+E");
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setContentAreaFilled(false);
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.setFocusPainted(false);
        btn_eliminar.setFocusable(false);
        btn_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_eliminar.setOpaque(true);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_cerrar.setBackground(new java.awt.Color(34, 45, 50));
        btn_cerrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cerrar.setForeground(new java.awt.Color(204, 204, 204));
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Close_Window_32px_1.png"))); // NOI18N
        btn_cerrar.setText("Salir Esc");
        btn_cerrar.setBorderPainted(false);
        btn_cerrar.setContentAreaFilled(false);
        btn_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cerrar.setFocusPainted(false);
        btn_cerrar.setFocusable(false);
        btn_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cerrar.setOpaque(true);
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        btn_informes.setBackground(new java.awt.Color(34, 45, 50));
        btn_informes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_informes.setForeground(new java.awt.Color(204, 204, 204));
        btn_informes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_News_32px_2.png"))); // NOI18N
        btn_informes.setText("Imprimir");
        btn_informes.setBorderPainted(false);
        btn_informes.setContentAreaFilled(false);
        btn_informes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_informes.setFocusPainted(false);
        btn_informes.setFocusable(false);
        btn_informes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_informes.setOpaque(true);
        btn_informes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_informesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_informes, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_informes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 222, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(64, 142, 186));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        txtBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Funcionario"));

        tbl_dcto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Funcionario", "Concepto", "Cuota", "Deuda", "Pagado", "Saldo", "Estado", "Fecha H Creación", "Fecha H Actualización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dcto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tbl_dcto);
        if (tbl_dcto.getColumnModel().getColumnCount() > 0) {
            tbl_dcto.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_dcto.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbl_dcto.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl_dcto.getColumnModel().getColumn(1).setMinWidth(250);
            tbl_dcto.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbl_dcto.getColumnModel().getColumn(1).setMaxWidth(250);
            tbl_dcto.getColumnModel().getColumn(2).setMinWidth(150);
            tbl_dcto.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbl_dcto.getColumnModel().getColumn(2).setMaxWidth(150);
            tbl_dcto.getColumnModel().getColumn(3).setMinWidth(100);
            tbl_dcto.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl_dcto.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_dcto.getColumnModel().getColumn(4).setMinWidth(100);
            tbl_dcto.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbl_dcto.getColumnModel().getColumn(4).setMaxWidth(100);
            tbl_dcto.getColumnModel().getColumn(5).setMinWidth(100);
            tbl_dcto.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbl_dcto.getColumnModel().getColumn(5).setMaxWidth(100);
            tbl_dcto.getColumnModel().getColumn(6).setMinWidth(100);
            tbl_dcto.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbl_dcto.getColumnModel().getColumn(6).setMaxWidth(100);
            tbl_dcto.getColumnModel().getColumn(7).setMinWidth(200);
            tbl_dcto.getColumnModel().getColumn(7).setPreferredWidth(200);
            tbl_dcto.getColumnModel().getColumn(7).setMaxWidth(200);
            tbl_dcto.getColumnModel().getColumn(8).setMinWidth(150);
            tbl_dcto.getColumnModel().getColumn(8).setPreferredWidth(150);
            tbl_dcto.getColumnModel().getColumn(8).setMaxWidth(150);
            tbl_dcto.getColumnModel().getColumn(9).setMinWidth(150);
            tbl_dcto.getColumnModel().getColumn(9).setPreferredWidth(150);
            tbl_dcto.getColumnModel().getColumn(9).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusqueda)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        operacion = 1;
        modal.setLocationRelativeTo(null);
        modal.setVisible(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        operacion = 2;
        Modificar();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        operacion = 3;
        Eliminar();
        CargarGrilla();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        modal.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void btn_informesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_informesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_informesActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpiarModal();
        modal.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioActionPerformed
        buscador_Funcionario bp = new buscador_Funcionario(modal, true);
        bp.setVisible(true);
        idFuncionario = bp.getIdbarrio();
        txtFuncionario.setText(bp.getDescBarrio());
        cbTipoDcto.requestFocus();
        if (idFuncionario != 0) {
            TraerSalario(idFuncionario);
        }


    }//GEN-LAST:event_btnFuncionarioActionPerformed

    private void btnCalculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculaActionPerformed
        if (db.ValidacionFecha(fecha_desde, "Error de Formato", "No puede Dejar Vacio", true, modal)) {
            if (db.ValidacionFecha(fecha_hasta, "Error de Formato", "No puede Dejar Vacio", true, modal)) {
                if (fecha_hasta.getDate().before(fecha_desde.getDate())) {
                    JOptionPane.showMessageDialog(modal, "La Fecha Hasta, no puede Ser menor a la Fecha Desde", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    int dia = db.CalcularDias(fecha_desde, fecha_hasta, checkSabado, chekDomingo);
                    txtDias.setText(String.valueOf(dia));
                    this.dias = dia;
                }
            }
        }


    }//GEN-LAST:event_btnCalculaActionPerformed

    private void btnCalcDctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcDctoActionPerformed
        Double sxDia = Double.parseDouble(txtSueldoporDia.getText().replace(".", "").replace(",", "."));
        Double resultado = sxDia * this.dias;
        txtMonto.setText(db.getDecimalString(resultado));
    }//GEN-LAST:event_btnCalcDctoActionPerformed

    private void btnGenCuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenCuotasActionPerformed

        if (ValidarGenCuota()) {
            for (int i = tblCuota.getRowCount() - 1; i >= 0; i--) {
                modeloCuota.removeRow(i);
            }

            int cuota = (Integer) txtCuota.getValue();
            int monto = (Integer) Integer.parseInt(txtMonto.getText().replace(".", ""));
            ArrayList<Model_Cuota> array = db.TraerCuotas(monto, cuota);
            array.forEach((array1) -> {
                modeloCuota.addRow(new Object[]{array1.getCuota(), array1.getFecha(), array1.getMonto()});
            });

            db.centrar(tblCuota, new int[]{0, 1});
            db.derecha(tblCuota, new int[]{2});

        }

    }//GEN-LAST:event_btnGenCuotasActionPerformed

    private void cbFraccionarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFraccionarItemStateChanged
        fraccionar();
    }//GEN-LAST:event_cbFraccionarItemStateChanged

    private void txtCuotaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuotaKeyTyped
        int letra = evt.getKeyChar();
        if (Character.isDigit(letra)) {
            evt.consume();
        }

    }//GEN-LAST:event_txtCuotaKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (ValidarModal()) {
            spFormulario();
            limpiarModal();
            CargarGrilla();
            modal.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveAplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAplicationActionPerformed
        if (ValidarModal()) {
            spFormulario();
            limpiarModal();
            CargarGrilla();
            btnFuncionario.requestFocus();
        }
    }//GEN-LAST:event_btnSaveAplicationActionPerformed

    private void CargarGrilla() {
        db.LimpiarBusqueda(txtBusqueda, tbl_dcto);
        try {
            sql = "select * from sp_view_descuentos();";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            db.CargarTabla(ps, tbl_dcto, modelo, false);

            db.derecha(tbl_dcto, new int[]{4, 5, 6});
            db.centrar(tbl_dcto, new int[]{2, 3, 7});

        } catch (SQLException ex) {
            Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void validarCaracteres() {
        //numericos
        db.Solo_Numeros(txtMonto);
        db.JtextFieldDecimal(txtMonto);
    }

    private boolean ValidarModal() {

        if (idFuncionario == 0) {
            JOptionPane.showMessageDialog(modal, "Debe de Seleccionar un funcionario", "Error", JOptionPane.ERROR_MESSAGE);
            btnFuncionario.requestFocus();
            return false;
        }

        if (txtMonto.getText().equals("0") || txtMonto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe Cargar Monto", "Error", JOptionPane.ERROR_MESSAGE);
            txtMonto.requestFocus();
            return false;
        }
        if (cbFraccionar.getSelectedIndex() == 0) {
            if (!db.ValidacionFecha(fecha_vencimiento, "Error d Formato", "No puede Dejar Vacio", true, modal)) {
                return false;
            }
        } else {
            if (tblCuota.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(modal, "Debe de Generar la Cuota", "Error", JOptionPane.ERROR_MESSAGE);
                btnGenCuotas.requestFocus();
                return false;
            }

        }

        switch (db.getIdCombo(cbTipoDcto)) {

            case 5:
                if (!db.ValidacionFecha(fecha_desde, "Error d Formato", "No puede Dejar Vacio", true, modal)) {
                    return false;
                }
                if (!db.ValidacionFecha(fecha_hasta, "Error d Formato", "No puede Dejar Vacio", true, modal)) {
                    return false;
                }
                if (Integer.parseInt(txtDias.getText()) <= 0) {
                    JOptionPane.showMessageDialog(modal, "Debe de Generar los Dias de Ausencia", "Error", JOptionPane.ERROR_MESSAGE);
                    btnCalcula.requestFocus();
                    return false;
                }

                if (fecha_desde.getDate().before(new Date())) {
                    JOptionPane.showMessageDialog(modal, "No Puede Cargar una Ausencia Mayor a la Fecha Actual!", "Error", JOptionPane.ERROR_MESSAGE);
                    fecha_desde.requestFocus();
                    return false;
                }

                if (fecha_hasta.getDate().before(new Date())) {
                    JOptionPane.showMessageDialog(modal, "No Puede Cargar una Ausencia Mayor a la Fecha Actual!", "Error", JOptionPane.ERROR_MESSAGE);
                    fecha_hasta.requestFocus();
                    return false;
                }

                break;
            case 3:
                if (!db.ValidacionFecha(fecha_desde, "Error de Formato", "No puede Dejar Vacio", true, modal)) {
                    return false;
                }
                if (!db.ValidacionFecha(fecha_hasta, "Error de Formato", "No puede Dejar Vacio", true, modal)) {
                    return false;
                }
                if (Integer.parseInt(txtDias.getText()) <= 0) {
                    JOptionPane.showMessageDialog(modal, "Debe de Generar la Cuota", "Error", JOptionPane.ERROR_MESSAGE);
                    btnGenCuotas.requestFocus();
                    return false;
                }

                if (fecha_desde.getDate().before(new Date())) {
                    JOptionPane.showMessageDialog(modal, "No Puede Cargar una Ausencia Mayor a la Fecha Actual!", "Error", JOptionPane.ERROR_MESSAGE);
                    fecha_desde.requestFocus();
                    return false;
                }

                if (fecha_hasta.getDate().before(new Date())) {
                    JOptionPane.showMessageDialog(modal, "No Puede Cargar una Ausencia Mayor a la Fecha Actual!", "Error", JOptionPane.ERROR_MESSAGE);
                    fecha_hasta.requestFocus();
                    return false;
                }

                break;

        }

        return true;
    }

    private boolean ValidarGenCuota() {
        if (Integer.parseInt(txtMonto.getText().replace(".", "")) <= 0) {
            JOptionPane.showMessageDialog(modal, "Monto debe de ser Mayor a Cero", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (Integer.parseInt(txtCuota.getValue().toString()) <= 1) {
            JOptionPane.showMessageDialog(modal, "La Cuota debe de Ser Mayor a uno", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void CargarCombo() {
        sql = "select td.id, td.descripcion from tipo_descuentos td \n"
                + "where td.estado = 1\n"
                + "order by td.descripcion";
        db.CargarCombo(cbTipoDcto, sql, menu.getConexion());
    }

    private void TraerSalario(int id) {
        try {
            sql = "select v.salario, v.\"Salario por Dia\" from view_salariofun v \n"
                    + "where v.id = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            res = db.QueryDinamico(ps);
            if (res != null) {
                txtSalario.setText(res[1]);
                txtSueldoporDia.setText(res[2]);
            }

        } catch (SQLException ex) {
            Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fraccionar() {
        int st = cbFraccionar.getSelectedIndex();
        if (st == 0) {
            fecha_vencimiento.setEnabled(true);
            txtCuota.setEnabled(false);
            btnGenCuotas.setEnabled(false);
            for (int i = tblCuota.getRowCount() - 1; i >= 0; i--) {
                modeloCuota.removeRow(i);
            }

            txtCuota.setValue(1);

        } else {
            fecha_vencimiento.setEnabled(false);
            txtCuota.setEnabled(true);
            btnGenCuotas.setEnabled(true);
        }

    }

    private void EventoCombo() {
        cbTipoDcto.addItemListener((ItemEvent e) -> {
            try {
                switch (db.getIdCombo(cbTipoDcto)) {
                    case 5:
                        db.getEnabledPanel(jpCalculo);

                        break;
                    case 3:
                        db.getEnabledPanel(jpCalculo);

                        break;
                    default:

                        db.getDisabledPanel(jpCalculo);
                        fecha_desde.setDate(null);
                        fecha_hasta.setDate(null);
                        checkSabado.setSelected(false);
                        chekDomingo.setSelected(false);
                        txtDias.setText("0");
                        break;
                }

                sql = "select fraccionable from tipo_descuentos \n"
                        + "where id = ?";
                PreparedStatement ps = menu.getConexion().prepareCall(sql);
                ps.setInt(1, db.getIdCombo(cbTipoDcto));
                res = db.QueryDinamico(ps);

                if (res[1].equals("t")) {
                    cbFraccionar.setEnabled(true);
                } else {
                    cbFraccionar.setEnabled(false);
                    cbFraccionar.setSelectedIndex(0);
                }

            } catch (SQLException ex) {
                Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void spFormulario() {

        switch (operacion) {
            case 1:

                sql = "INSERT INTO desc_cab\n"
                        + "(funcionario, tipo_descuentos, monto, saldo, usuario_input, fraccionar)\n"
                        + "VALUES(?, ?, ?, ? ,? ,?)"
                        + "RETURNING id";

                try {
                    PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idFuncionario);
                    ps.setInt(2, db.getIdCombo(cbTipoDcto));
                    ps.setDouble(3, db.getParseString(txtMonto));
                    ps.setDouble(4, db.getParseString(txtMonto));
                    ps.setInt(5, menu.getIduser());
                    ps.setInt(6, cbFraccionar.getSelectedIndex());
                    res = db.QueryDinamico(ps);
                    iddescuento = Integer.parseInt(res[1]);

                    sql = "INSERT INTO desc_det_cuota\n"
                            + "(desc_cab, cuota, monto, fecha_pago)\n"
                            + "VALUES(?, ?, ?, ?)";

                    PreparedStatement psDetalle = menu.getConexion().prepareStatement(sql);
                    //Tomamos solamente los Datos que estan en la Cabecera
                    if (cbFraccionar.getSelectedIndex() == 0) {
                        psDetalle.setInt(1, iddescuento);
                        psDetalle.setInt(2, db.getParseIntToString(txtCuota.getValue().toString()));
                        psDetalle.setDouble(3, db.getParseString(txtMonto));
                        psDetalle.setDate(4, db.convertUtilToSql(fecha_vencimiento));
                        db.Insertar(psDetalle, false);
                    } else {

                        //Tomamos los Datos que estan en la Grilla
                        for (int i = 0; i < tblCuota.getRowCount(); i++) {
                            psDetalle.setInt(1, iddescuento);
                            psDetalle.setInt(2, db.getParseStringint(tblCuota, i, 0));
                            psDetalle.setDouble(3, db.getParseStringint(tblCuota, i, 2));
                            psDetalle.setDate(4, db.convertUtilToSql(tblCuota, i, 1));
                            psDetalle.addBatch();
                        }
                        psDetalle.executeBatch();
                    }
                    //Le decimos que nos guarde un historico de Descuento de Funcionario
                    if (db.getIdCombo(cbTipoDcto) == 5 || db.getIdCombo(cbTipoDcto) == 3) {
                        iddescuento = Integer.parseInt(res[1]);
                        sql = "INSERT INTO detdescausencia\n"
                                + "(tipo_descuentos, descuento_fun, fecha_desde, fecha_hasta, dias_ausencias, usuario_input, sabado, domingo)\n"
                                + "VALUES(?, ?, ? ,? ,? ,?,?,?);";
                        PreparedStatement ps2 = menu.getConexion().prepareStatement(sql);
                        ps2.setInt(1, db.getIdCombo(cbTipoDcto));
                        ps2.setInt(2, iddescuento);
                        ps2.setDate(3, db.convertUtilToSql(fecha_desde));
                        ps2.setDate(4, db.convertUtilToSql(fecha_hasta));
                        ps2.setInt(5, Integer.parseInt(txtDias.getText()));
                        ps2.setInt(6, menu.getIduser());
                        ps2.setBoolean(7, checkSabado.isSelected());
                        ps2.setBoolean(8, chekDomingo.isSelected());
                        db.Insertar(ps2, false);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
                sql = "update desc_cab SET \n"
                        + "funcionario = ?, "
                        + "tipo_descuentos = ?, "
                        + "monto = ?, "
                        + "saldo = ?, "
                        + "usuario_update = ?, "
                        + "fraccionar = ?, "
                        + "fecha_update = ?\n"
                        + "where id = ?";

                try {
                    PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idFuncionario);
                    ps.setInt(2, db.getIdCombo(cbTipoDcto));
                    ps.setDouble(3, db.getParseString(txtMonto));
                    ps.setDouble(4, db.getParseString(txtMonto));
                    ps.setInt(5, menu.getIduser());
                    ps.setInt(6, cbFraccionar.getSelectedIndex());
                    ps.setTimestamp(7, db.getCurrentTimeStamp());
                    ps.setInt(8, iddescuento);
                    db.Actualizar(ps, false);

                    sql = "DELETE FROM desc_det_cuota where desc_cab = ?";
                    PreparedStatement psDel = menu.getConexion().prepareStatement(sql);
                    psDel.setInt(1, iddescuento);
                    db.eliminar(psDel, false);

                    sql = "INSERT INTO desc_det_cuota\n"
                            + "(desc_cab, cuota, monto, fecha_pago)\n"
                            + "VALUES(?, ?, ?, ?)";

                    PreparedStatement psDetalle = menu.getConexion().prepareStatement(sql);
                    //Tomamos solamente los Datos que estan en la Cabecera
                    if (cbFraccionar.getSelectedIndex() == 0) {
                        psDetalle.setInt(1, iddescuento);
                        psDetalle.setInt(2, db.getParseIntToString(txtCuota.getValue().toString()));
                        psDetalle.setDouble(3, db.getParseString(txtMonto));
                        psDetalle.setDate(4, db.convertUtilToSql(fecha_vencimiento));
                        db.Insertar(psDetalle, false);
                    } else {

                        //Tomamos los Datos que estan en la Grilla
                        for (int i = 0; i < tblCuota.getRowCount(); i++) {
                            psDetalle.setInt(1, iddescuento);
                            psDetalle.setInt(2, db.getParseStringint(tblCuota, i, 0));
                            psDetalle.setDouble(3, db.getParseStringint(tblCuota, i, 2));
                            psDetalle.setDate(4, db.convertUtilToSql(tblCuota, i, 1));
                            psDetalle.addBatch();
                        }
                        psDetalle.executeBatch();
                    }
                    //Le decimos que nos guarde un historico de Descuento de Funcionario
                    if (db.getIdCombo(cbTipoDcto) == 5 || db.getIdCombo(cbTipoDcto) == 3) {
                       
                        sql = "UPDATE detdescausencia SET \n"
                                + "tipo_descuentos = ?, "
                                + "fecha_desde = ?, "
                                + "fecha_hasta = ?, "
                                + "dias_ausencias = ?, "
                                + "usuario_input = ?, "
                                + "sabado = ?, "
                                + "domingo = ?\n"
                                + "where descuento_fun = ?";
                        System.out.println(sql);
                        PreparedStatement ps2 = menu.getConexion().prepareStatement(sql);
                        ps2.setInt(1, db.getIdCombo(cbTipoDcto));
                        ps2.setDate(2, db.convertUtilToSql(fecha_desde));
                        ps2.setDate(3, db.convertUtilToSql(fecha_hasta));
                        ps2.setInt(4, Integer.parseInt(txtDias.getText()));
                        ps2.setInt(5, menu.getIduser());
                        ps2.setBoolean(6, checkSabado.isSelected());
                        ps2.setBoolean(7, chekDomingo.isSelected());
                        ps2.setInt(8, iddescuento);
                        db.Actualizar(ps2, false);
                        System.out.println("sddsdsd");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case 3:
                sql = "update desc_cab set estado = ? where id = ?";
                try {
                    PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, 2);
                    ps.setInt(2, iddescuento);
                    db.Actualizar(ps, false);

                    sql = "update desc_det_cuota set estado = ? where id = ?";
                    PreparedStatement psDet = menu.getConexion().prepareStatement(sql);
                    psDet.setInt(1, 2);
                    psDet.setInt(2, iddescuento);
                    db.Actualizar(psDet, false);
                } catch (SQLException ex) {
                    Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
        }
        db.getMessage(operacion);
    }

    private void addKeyEvent() {

        ActionListener escListener = (ActionEvent e) -> {
            CargarGrilla();
        };
        this.getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    private void limpiarModal() {
        txtFuncionario.setText("");
        idFuncionario = 0;
        cbTipoDcto.setSelectedIndex(0);
        txtMonto.setText("0");
        cbFraccionar.setSelectedIndex(0);
        fecha_vencimiento.setDate(null);
        txtSalario.setText("0");
        txtSueldoporDia.setText("0");
        txtCuota.setValue(1);
        fecha_desde.setDate(null);
        fecha_hasta.setDate(null);
        checkSabado.setSelected(false);
        chekDomingo.setSelected(false);
        txtDias.setText("0");
        for (int i = tblCuota.getRowCount() - 1; i >= 0; i--) {
            modeloCuota.removeRow(i);
        }

    }

    private Boolean Verificar(int id) {

        try {
            sql = "select count(*) from desc_det_cuota dc where dc.desc_cab = ?  and dc.estado = 0";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            res = db.QueryDinamico(ps);

            if (!res[1].equals("0")) {
                JOptionPane.showMessageDialog(null, "No se puede Modificar ni Eliminar un Dcto. con Cancelación", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void Modificar() {
        int select = tbl_dcto.getSelectedRow();
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila para poder modificar", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            iddescuento = db.getParseStringint(tbl_dcto, select, 0);
            if (Verificar(iddescuento)) {
                try {
                    sql = "select f.id, p.apellido || ', ' || p.nombre,\n"
                            + "dc.tipo_descuentos, fsa.salario, fsa.\"Salario por Dia\",\n"
                            + "dc.monto, dc.fraccionar \n"
                            + "from desc_cab dc \n"
                            + "join funcionario f on dc.funcionario = f.id\n"
                            + "join persona p on p.id = f.persona\n"
                            + "join view_salariofun fsa on fsa.id = f.id\n"
                            + "where dc.id = ?";
                    PreparedStatement psCabecera = menu.getConexion().prepareStatement(sql);
                    psCabecera.setInt(1, iddescuento);
                    res = db.QueryDinamico(psCabecera);
                    //Cargamos la Cabecera
                    idFuncionario = db.getParseIntToString(res[1]);
                    txtFuncionario.setText(res[2]);
                    txtSalario.setText(res[4]);
                    txtSueldoporDia.setText(res[5]);
                    txtMonto.setText(res[6]);
                    cbFraccionar.setSelectedIndex(Integer.parseInt(res[7]));
                    String frac = res[7];
                    db.SelectIdCombo(cbTipoDcto, db.getParseIntToString(res[3]));

                    //Consultamos el Detalle
                    if (frac.equals("0")) {
                        sql = "select  dt.fecha_pago from desc_det_cuota dt\n"
                                + "where dt.desc_cab = ?";
                        PreparedStatement psDetalle = menu.getConexion().prepareStatement(sql);
                        psDetalle.setInt(1, iddescuento);
                        res = db.QueryDinamico(psDetalle);
                        ((JTextField) fecha_vencimiento.getDateEditor()).setText(res[1]);
                        txtCuota.setValue(1);

                    } else {
                        sql = "select dt.cuota, dt.fecha_pago, dt.monto from desc_det_cuota dt\n"
                                + "where dt.desc_cab = ?";
                        PreparedStatement psDetalle = menu.getConexion().prepareStatement(sql);
                        psDetalle.setInt(1, iddescuento);
                        db.CargarTabla(psDetalle, tblCuota, modeloCuota, false);
                        db.centrar(tblCuota, new int[]{0, 1});
                        db.derecha(tblCuota, new int[]{2});
                        txtCuota.setValue(tblCuota.getRowCount());

                    }

                    //Traemos los Detalles de los Dias De Dcto.
                    sql = "select da.dias_ausencias, da.fecha_desde, da.fecha_hasta, da.sabado, da.domingo from detdescausencia da\n"
                            + "where da.descuento_fun = ?";
                    PreparedStatement psDcto = menu.getConexion().prepareStatement(sql);
                    psDcto.setInt(1, iddescuento);
                    res = db.QueryDinamico(psDcto);

                    if (res != null) {
                        txtDias.setText(res[1]);
                        ((JTextField) fecha_desde.getDateEditor()).setText(res[2]);
                        ((JTextField) fecha_hasta.getDateEditor()).setText(res[3]);
                        checkSabado.setSelected((res[4].equals("t")));
                        chekDomingo.setSelected((res[5].equals("t")));
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(dcto_funcionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                modal.setLocationRelativeTo(null);
                modal.setVisible(true);
            }
        }
    }

    private void Eliminar() {
        int select = tbl_dcto.getSelectedRow();
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila para poder modificar", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            iddescuento = db.getParseStringint(tbl_dcto, select, 0);
            if (Verificar(iddescuento)) {
                int confirma = JOptionPane.showConfirmDialog(null, "Desea Eliminar la Deuda Generada?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                if (confirma == 0) {
                    spFormulario();
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcDcto;
    private javax.swing.JButton btnCalcula;
    private javax.swing.JButton btnFuncionario;
    private javax.swing.JButton btnGenCuotas;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAplication;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_informes;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cbFraccionar;
    private javax.swing.JComboBox<clases.Tools> cbTipoDcto;
    private javax.swing.JCheckBox checkSabado;
    private javax.swing.JCheckBox chekDomingo;
    private com.toedter.calendar.JDateChooser fecha_desde;
    private com.toedter.calendar.JDateChooser fecha_hasta;
    private com.toedter.calendar.JDateChooser fecha_vencimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpCalculo;
    private javax.swing.JDialog modal;
    private javax.swing.JDialog modal_informes;
    private javax.swing.JTable tblCuota;
    private javax.swing.JTable tbl_dcto;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JSpinner txtCuota;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtSueldoporDia;
    // End of variables declaration//GEN-END:variables
}
