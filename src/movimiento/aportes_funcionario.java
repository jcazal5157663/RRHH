package movimiento;

import AppContext.appContext;
import buscadores.buscador_Funcionario;
import clases.EstilosLabel;
import clases.Tools;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import principal.menu;

public class aportes_funcionario extends javax.swing.JInternalFrame {

    private int operacion = 0;
    private String sql;
    private String res[];
    Tools tools = new Tools();
    private final DefaultTableModel modelo;
    private final DefaultTableModel modeloDetalle;
    EstilosLabel lb = new EstilosLabel();
    Color entrada = new Color(44, 59, 65);
    Color Salida = new Color(34, 45, 50);
    private int xx;
    private int xy;
    private int idFuncionario;
    private int idbeneficiario;
    private int idAporte;
    private final JTextField montoDetalle = new JTextField("0");
    private final JComboBox<String> combo = new JComboBox<>();

    public aportes_funcionario() {
        initComponents();
        lb.CambiarColor(btn_nuevo, entrada, Salida);
        lb.CambiarColor(btn_modificar, entrada, Salida);
        lb.CambiarColor(btn_eliminar, entrada, Salida);
        lb.CambiarColor(btn_cerrar, entrada, Salida);
        lb.CambiarColor(btn_pagar, entrada, Salida);
        modelo = (DefaultTableModel) tblIndex.getModel();
        modeloDetalle = (DefaultTableModel) tblDetalle.getModel();
        CargarGrilla();
        ValidarCampos();
        AddItemCombo();
        agregarElementos();
        addEventoTable();
        tools.CentrarCabeceraTabla(tblDetalle);
        montoDetalle.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tblDetalle.editingStopped(new ChangeEvent(tblDetalle));
        CargarCombo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modal = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        btnEliminarFilas = new javax.swing.JButton();
        beneficiario = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        motivoAporte = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        modoDcto = new javax.swing.JComboBox<>();
        txtFuncionario = new javax.swing.JTextField();
        monto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtTotalEfectivo = new javax.swing.JTextField();
        txtTotalDcto = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnFuncionario = new javax.swing.JButton();
        btnFuncionario1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        modalDesembolso = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idport = new javax.swing.JTextField();
        funcio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mont = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbConcepto = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        modalImprimir = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbFiltro = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        btn_pagar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIndex = new javax.swing.JTable();

        modal.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        modal.setModal(true);
        modal.setUndecorated(true);
        modal.setResizable(false);
        modal.setSize(new java.awt.Dimension(603, 594));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnEliminarFilas.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnEliminarFilas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Erase_24px.png"))); // NOI18N
        btnEliminarFilas.setText("Eliminar Fila");
        btnEliminarFilas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEliminarFilas.setContentAreaFilled(false);
        btnEliminarFilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFilasActionPerformed(evt);
            }
        });

        beneficiario.setEditable(false);
        beneficiario.setBackground(new java.awt.Color(255, 255, 255));
        beneficiario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        beneficiario.setBorder(javax.swing.BorderFactory.createTitledBorder("Beneficiario"));

        jScrollPane4.setBorder(null);

        motivoAporte.setBorder(javax.swing.BorderFactory.createTitledBorder("Motivo de Aporte"));
        motivoAporte.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jScrollPane4.setViewportView(motivoAporte);

        modoDcto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        modoDcto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Descuento" }));

        txtFuncionario.setEditable(false);
        txtFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        txtFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        monto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        monto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        monto.setText("0");
        monto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Modo de Aporte:");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Add_Subnode_32px.png"))); // NOI18N
        jButton3.setText("Agregar");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblDetalle.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idFuncionario", "Funcionario", "Monto", "idmodo", "Modo de Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalle.setRowHeight(20);
        tblDetalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblDetalleFocusLost(evt);
            }
        });
        tblDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblDetalleKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetalle);
        if (tblDetalle.getColumnModel().getColumnCount() > 0) {
            tblDetalle.getColumnModel().getColumn(0).setMinWidth(0);
            tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
            tblDetalle.getColumnModel().getColumn(3).setMinWidth(0);
            tblDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registro de Aporte de Funcionario");

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        txtTotalEfectivo.setEditable(false);
        txtTotalEfectivo.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalEfectivo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTotalEfectivo.setForeground(new java.awt.Color(0, 153, 255));
        txtTotalEfectivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalEfectivo.setText("0");
        txtTotalEfectivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Efectivo"));

        txtTotalDcto.setEditable(false);
        txtTotalDcto.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalDcto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTotalDcto.setForeground(new java.awt.Color(0, 153, 255));
        txtTotalDcto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalDcto.setText("0");
        txtTotalDcto.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Dcto. Directo"));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 153, 255));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");
        txtTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));

        btnFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btnFuncionario.setContentAreaFilled(false);
        btnFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFuncionario.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioActionPerformed(evt);
            }
        });

        btnFuncionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btnFuncionario1.setContentAreaFilled(false);
        btnFuncionario1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFuncionario1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionario1ActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Save_32px.png"))); // NOI18N
        btnGuardar.setMnemonic('G');
        btnGuardar.setText("Grabar ALT+G");
        btnGuardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTotalEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalDcto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarFilas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                                    .addComponent(beneficiario))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFuncionario1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btnFuncionario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(modoDcto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(beneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFuncionario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(modoDcto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtFuncionario))
                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarFilas)
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalDcto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout modalLayout = new javax.swing.GroupLayout(modal.getContentPane());
        modal.getContentPane().setLayout(modalLayout);
        modalLayout.setHorizontalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modalLayout.setVerticalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        modalDesembolso.setModal(true);
        modalDesembolso.setUndecorated(true);
        modalDesembolso.setResizable(false);
        modalDesembolso.setSize(new java.awt.Dimension(492, 182));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Delete_24px.png"))); // NOI18N
        jButton6.setMnemonic('X');
        jButton6.setToolTipText("Presione Alt+X para salir");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);
        jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Desembolsar Aporte Funcionario");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Aporte Nro:");

        idport.setEditable(false);
        idport.setBackground(new java.awt.Color(255, 255, 255));
        idport.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        idport.setForeground(new java.awt.Color(0, 153, 255));

        funcio.setEditable(false);
        funcio.setBackground(new java.awt.Color(255, 255, 255));
        funcio.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        funcio.setForeground(new java.awt.Color(0, 153, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Monto Total a Descontar Fin de Mes:");

        mont.setEditable(false);
        mont.setBackground(new java.awt.Color(255, 255, 255));
        mont.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        mont.setForeground(new java.awt.Color(0, 153, 255));
        mont.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setText("Seleccione el Concepto:");

        cbConcepto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton1.setText("Ejecutar Acción");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idport, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(funcio))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mont, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 189, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbConcepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addComponent(jSeparator4)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funcio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout modalDesembolsoLayout = new javax.swing.GroupLayout(modalDesembolso.getContentPane());
        modalDesembolso.getContentPane().setLayout(modalDesembolsoLayout);
        modalDesembolsoLayout.setHorizontalGroup(
            modalDesembolsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modalDesembolsoLayout.setVerticalGroup(
            modalDesembolsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        modalImprimir.setModal(true);
        modalImprimir.setUndecorated(true);
        modalImprimir.setResizable(false);
        modalImprimir.setSize(new java.awt.Dimension(400, 206));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jPanel9.setBackground(new java.awt.Color(51, 153, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Informe Aportes");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Delete_24px.png"))); // NOI18N
        jButton7.setMnemonic('X');
        jButton7.setToolTipText("Presione Alt+X para salir");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton7))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel9.setText("Agrupar por:");

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Descuento Directo", "Todos" }));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Print_32px_1.png"))); // NOI18N
        jButton4.setText("Ver Informe");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout modalImprimirLayout = new javax.swing.GroupLayout(modalImprimir.getContentPane());
        modalImprimir.getContentPane().setLayout(modalImprimirLayout);
        modalImprimirLayout.setHorizontalGroup(
            modalImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modalImprimirLayout.setVerticalGroup(
            modalImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(34, 45, 50));
        jPanel3.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(58, 128, 167));
        jLabel1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aportes/Donaciones");
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

        btn_pagar.setBackground(new java.awt.Color(34, 45, 50));
        btn_pagar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_pagar.setForeground(new java.awt.Color(204, 204, 204));
        btn_pagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Money_32px.png"))); // NOI18N
        btn_pagar.setText("Desembolsar Aportes");
        btn_pagar.setBorderPainted(false);
        btn_pagar.setContentAreaFilled(false);
        btn_pagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pagar.setFocusPainted(false);
        btn_pagar.setFocusable(false);
        btn_pagar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_pagar.setOpaque(true);
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(34, 45, 50));
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(204, 204, 204));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Print_32px.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorderPainted(false);
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setFocusPainted(false);
        btnImprimir.setFocusable(false);
        btnImprimir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnImprimir.setOpaque(true);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
            .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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
                .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 216, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(64, 142, 186));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jTextField1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Emoji", 0, 11))); // NOI18N

        tblIndex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. de Aporte", "Beneficiario", "Monto Total", "Estado", "Fecha H. Creación", "Fecha de Última Modificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblIndex);
        if (tblIndex.getColumnModel().getColumnCount() > 0) {
            tblIndex.getColumnModel().getColumn(0).setMinWidth(100);
            tblIndex.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblIndex.getColumnModel().getColumn(0).setMaxWidth(100);
            tblIndex.getColumnModel().getColumn(2).setMinWidth(150);
            tblIndex.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblIndex.getColumnModel().getColumn(2).setMaxWidth(150);
            tblIndex.getColumnModel().getColumn(3).setMinWidth(150);
            tblIndex.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblIndex.getColumnModel().getColumn(3).setMaxWidth(150);
            tblIndex.getColumnModel().getColumn(4).setMinWidth(150);
            tblIndex.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblIndex.getColumnModel().getColumn(4).setMaxWidth(150);
            tblIndex.getColumnModel().getColumn(5).setMinWidth(150);
            tblIndex.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblIndex.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        Seleccionar();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        operacion = 3;
        Seleccionar();
        CargarGrilla();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
        operacion = 4;
        Seleccionar();
    }//GEN-LAST:event_btn_pagarActionPerformed

    private void btnFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionarioActionPerformed
        buscador_Funcionario bp = new buscador_Funcionario(modal, true);
        bp.setVisible(true);
        idFuncionario = bp.getIdbarrio();
        txtFuncionario.setText(bp.getDescBarrio());
        monto.requestFocus();

    }//GEN-LAST:event_btnFuncionarioActionPerformed

    private void btnFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionario1ActionPerformed
        Boolean swt = false;

        while (!swt) {
            buscador_Funcionario bp = new buscador_Funcionario(modal, true);
            bp.setVisible(true);
            idbeneficiario = bp.getIdbarrio();
            if (validarCab()) {
                swt = true;
                beneficiario.setText(bp.getDescBarrio());
                motivoAporte.requestFocus();

            }
        }


    }//GEN-LAST:event_btnFuncionario1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Limpiar();
        modal.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        modal.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (addItem()) {
            modeloDetalle.addRow(new Object[]{idFuncionario, txtFuncionario.getText(), monto.getText(), modoDcto.getSelectedIndex(), modoDcto.getSelectedItem()});
            SumarTabla();
            tools.UltFila(tblDetalle);
            tools.derecha(tblDetalle, new int[]{2});
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEliminarFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFilasActionPerformed
        tools.removeSelectedRows(tblDetalle);
        SumarTabla();
    }//GEN-LAST:event_btnEliminarFilasActionPerformed

    private void tblDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDetalleKeyTyped
        int letra = evt.getKeyChar();

        if (letra == 127) {
            modeloDetalle.removeRow(tblDetalle.getSelectedRow());
            SumarTabla();

        }
    }//GEN-LAST:event_tblDetalleKeyTyped

    private void tblDetalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDetalleFocusLost

    }//GEN-LAST:event_tblDetalleFocusLost

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarABM()) {
            abm_aporte();
            Limpiar();
            CargarGrilla();
            modal.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        modalDesembolso.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            sql = "SELECT * from sp_gen_ctafun_aporte(\n"
                    + "	?,\n"
                    + "	?,\n"
                    + "	?\n"
                    + ")";

            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, idAporte);
            ps.setInt(2, menu.getIduser());
            ps.setInt(3, tools.getIdCombo(cbConcepto));

            res = tools.QueryDinamico(ps);

            JOptionPane.showMessageDialog(null, res[1], "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            modalDesembolso.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(aportes_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        int row = tblIndex.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione Fila", "Alerta!", JOptionPane.WARNING_MESSAGE);
        } else {
            idAporte = tools.getParseStringint(tblIndex, row, 0);
            modalImprimir.setLocationRelativeTo(null);
            modalImprimir.setVisible(true);
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int desde = 0;
        int hasta = 0;

        switch (cbFiltro.getSelectedIndex()) {
            case 0:

                desde = 0;
                hasta = 0;
                break;
            case 1:
                desde = 1;
                hasta = 1;

                break;
            case 2:

                desde = 0;
                hasta = 1;

                break;

        }

        HashMap hashMap = new HashMap();
        hashMap.put("desde", desde);
        hashMap.put("hasta", hasta);
        hashMap.put("id", idAporte);
        hashMap.put("empresa", "Prueba");

        tools.reporte("reporte/aportes.jasper", hashMap, "Aporte de Funcionario", menu.getConexion());

      //  tools.reporte("reporte/paises.jasper", null, "Paises", menu.getConexion());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        modalImprimir.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void abm_aporte() {
        try {
            PreparedStatement ps = null;

            switch (operacion) {
                case 1:

                    sql = "INSERT INTO aporte_fun_cab\n"
                            + "(beneficiario, obs, estado, usuario_input)\n"
                            + "VALUES(?, ?, ?, ?)\n"
                            + "returning id";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idbeneficiario);
                    ps.setString(2, motivoAporte.getText());
                    ps.setInt(3, 1);
                    ps.setInt(4, menu.getIduser());
                    res = tools.QueryDinamico(ps);
                    idAporte = Integer.parseInt(res[1]);
                    //Recorremos la Tabla e insertamos el Detalle de la misma.
                    sql = "INSERT INTO aporte_fun_det\n"
                            + "(aporte_fun_cab, funcionario_donador, monto, tipo_pago)\n"
                            + "VALUES(?, ?, ?, ?)";
                    ps = menu.getConexion().prepareStatement(sql);
                    for (int row = 0; row < tblDetalle.getRowCount(); row++) {
                        ps.setInt(1, idAporte);
                        ps.setInt(2, tools.getParseStringint(tblDetalle, row, 0));
                        ps.setDouble(3, tools.getParseString(tblDetalle, row, 2));
                        ps.setInt(4, tools.getParseStringint(tblDetalle, row, 3));
                        ps.addBatch();
                    }
                    ps.executeBatch();
                    break;

                case 2:
                    sql = "UPDATE aporte_fun_cab\n"
                            + "SET beneficiario=? , \n"
                            + "obs= ?, \n"
                            + "usuario_update= ?, \n"
                            + "fecha_update= ?\n"
                            + "WHERE id= ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idbeneficiario);
                    ps.setString(2, motivoAporte.getText());
                    ps.setInt(3, menu.getIduser());
                    ps.setTimestamp(4, tools.getCurrentTimeStamp());
                    ps.setInt(5, idAporte);
                    tools.Actualizar(ps, false);
                    //Borramos todo el Detalle de la Grilla.......                    
                    sql = "DELETE FROM aporte_fun_det where aporte_fun_cab = ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idAporte);
                    tools.eliminar(ps, false);

                    //Reinsertamos el Detalle de Todo
                    sql = "INSERT INTO aporte_fun_det\n"
                            + "(aporte_fun_cab, funcionario_donador, monto, tipo_pago)\n"
                            + "VALUES(?, ?, ?, ?)";
                    ps = menu.getConexion().prepareStatement(sql);
                    for (int row = 0; row < tblDetalle.getRowCount(); row++) {
                        ps.setInt(1, idAporte);
                        ps.setInt(2, tools.getParseStringint(tblDetalle, row, 0));
                        ps.setDouble(3, tools.getParseString(tblDetalle, row, 2));
                        ps.setInt(4, tools.getParseStringint(tblDetalle, row, 3));
                        ps.addBatch();
                    }
                    ps.executeBatch();

                    break;
                case 3:
                    sql = "UPDATE aporte_fun_cab\n"
                            + "SET estado = ?\n"
                            + "WHERE id= ?";

                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, 2);
                    ps.setInt(2, idAporte);
                    tools.Actualizar(ps, false);
                    break;
            }
            tools.getMessage(operacion);
        } catch (SQLException ex) {
            Logger.getLogger(aportes_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void CargarGrilla() {
        sql = "select * from sp_view_aporte()";
        tools.CargarTabla(sql, tblIndex, modelo, false, menu.getConexion());
        tools.centrar(tblIndex, new int[]{0, 3, 4, 5});
        tools.derecha(tblIndex, new int[]{2});
    }

    private void ValidarCampos() {
        tools.JtextFieldDecimal(monto);
        tools.JtextFieldDecimal(montoDetalle);
        tools.Solo_Numeros(monto);
        tools.Solo_Numeros(montoDetalle);
    }

    private void AddItemCombo() {
        combo.addItem("Efectivo");
        combo.addItem("Descuento");
    }

    private void agregarElementos() {
        tools.AsignarCuadroTexto(montoDetalle, tblDetalle, 2);
        tools.AsignarCombo(combo, tblDetalle, 4);
    }

    private void addEventoTable() {

        modeloDetalle.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int columna = e.getColumn();
                    int row = tblDetalle.getSelectedRow();
                    switch (columna) {
                        case 2:
                            SumarTabla();
                            break;
                        case 4:
                            int idCol = combo.getSelectedIndex();
                            System.out.println(idCol);
                            tblDetalle.setValueAt(idCol, row, 3);
                            SumarTabla();
                            break;

                    }
                }
            }
        });
    }

    private void SumarTabla() {

        Double sumaEfectivo = 0.0;
        Double sumaDcto = 0.0;
        for (int i = 0; i < tblDetalle.getRowCount(); i++) {
            Double valor = tools.getParseString(tblDetalle, i, 2);
            if (tblDetalle.getValueAt(i, 3).toString().equals("0")) {
                sumaEfectivo = sumaEfectivo + valor;
            } else {
                sumaDcto = sumaDcto + valor;
            }
        }
        txtTotalEfectivo.setText(tools.getDecimalString(sumaEfectivo));
        txtTotalDcto.setText(tools.getDecimalString(sumaDcto));
        txtTotal.setText(tools.getDecimalString((sumaDcto + sumaEfectivo)));
    }

    private Boolean addItem() {
        for (int i = 0; i < tblDetalle.getRowCount(); i++) {
            int id = Integer.parseInt(tblDetalle.getValueAt(i, 0).toString());

            if (id == idFuncionario) {
                JOptionPane.showMessageDialog(modal, "El Funcionario ya Realizo el Aporte Correspondiente", "Alerta", JOptionPane.WARNING_MESSAGE);
                tblDetalle.getSelectionModel().setSelectionInterval(i, i);
                return false;
            }

        }

        if (idFuncionario == idbeneficiario) {
            JOptionPane.showMessageDialog(modal, "El Aportador no puede Ser el mismo al Beneficiario", "Alerta", JOptionPane.WARNING_MESSAGE);
            btnFuncionario.requestFocus();
            return false;
        }

        if (txtFuncionario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "El Aportador no puede estar vacío", "Alerta", JOptionPane.WARNING_MESSAGE);
            btnFuncionario.requestFocus();
            return false;
        }

        if (monto.getText().equals("0") || monto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "El Monto no puede Estar Vacío", "Alerta", JOptionPane.WARNING_MESSAGE);
            monto.requestFocus();
            return false;
        }

        return true;
    }

    public Boolean validarCab() {
        for (int i = 0; i < tblDetalle.getRowCount(); i++) {
            int id = Integer.parseInt(tblDetalle.getValueAt(i, 0).toString());

            if (id == idbeneficiario) {
                JOptionPane.showMessageDialog(modal, "El Funcionario No puede ser el mismo al Aportador", "Alerta", JOptionPane.WARNING_MESSAGE);
                tblDetalle.getSelectionModel().setSelectionInterval(i, i);
                return false;
            }

        }
        return true;
    }

    private Boolean selectEstado(int id) {
        try {
            sql = "select estado from aporte_fun_cab where id = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            res = tools.QueryDinamico(ps);

            if (res[1].equals("1")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede modificar ni eliminar un aporte ya procesado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {

            Logger.getLogger(aportes_funcionario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    private void Seleccionar() {
        int row = tblIndex.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione Fila para Modificar o Eliminar Datos", "Alerta!", JOptionPane.WARNING_MESSAGE);
        } else {
            idAporte = tools.getParseStringint(tblIndex, row, 0);
            if (selectEstado(idAporte)) {
                switch (operacion) {
                    case 2:
                        sql = "select ac.beneficiario, per.apenomb, ac.obs from aporte_fun_cab ac\n"
                                + "join funcionario f on f.id = ac.beneficiario\n"
                                + "join view_nompersona per on per.id = f.persona\n"
                                + "where ac.id = ?";
                         {
                            try {
                                PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                                ps.setInt(1, idAporte);
                                res = tools.QueryDinamico(ps);
                                idbeneficiario = tools.getParseIntToString(res[1]);
                                beneficiario.setText(res[2]);
                                motivoAporte.setText(res[3]);
                                //traemos el Detalle

                                sql = "select adet.funcionario_donador, v.apenomb, adet.monto, adet.tipo_pago, \n"
                                        + "case \n"
                                        + "	adet.tipo_pago\n"
                                        + "	when 1 then\n"
                                        + "		'Descuento'\n"
                                        + "	when 0 then\n"
                                        + "		'Efectivo'\n"
                                        + "end	\n"
                                        + "from aporte_fun_det adet\n"
                                        + "join funcionario f on f.id = adet.funcionario_donador\n"
                                        + "join view_nompersona v on v.id = f.persona\n"
                                        + "where adet.aporte_fun_cab = ? "
                                        + "order by adet.id";
                                PreparedStatement ps2 = menu.getConexion().prepareStatement(sql);
                                ps2.setInt(1, idAporte);
                                tools.CargarTabla(ps2, tblDetalle, modeloDetalle, false);
                                tools.UltFila(tblDetalle);
                                tools.derecha(tblDetalle, new int[]{2});
                                SumarTabla();
                                modal.setLocationRelativeTo(null);
                                modal.setVisible(true);

                            } catch (SQLException ex) {
                                Logger.getLogger(aportes_funcionario.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        break;
                    case 3:
                        int result = JOptionPane.showConfirmDialog(null, "Desea Eliminar el Aporte Nº: " + idAporte + " Generado", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                        if (result == 0) {
                            abm_aporte();
                        }
                        break;

                    case 4:
                        idport.setText(String.valueOf(idAporte));
                        funcio.setText(tblIndex.getValueAt(row, 1).toString());

                        sql = "select sum(ad.monto) from aporte_fun_det ad\n"
                                + "where ad.tipo_pago = 1 and ad.aporte_fun_cab = ?";
                         {
                            try {
                                PreparedStatement ps2 = menu.getConexion().prepareStatement(sql);
                                ps2.setInt(1, idAporte);
                                res = tools.QueryDinamico(ps2);
                                mont.setText(res[1]);

                            } catch (SQLException ex) {
                                Logger.getLogger(aportes_funcionario.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (!res[1].equals("0")) {
                            modalDesembolso.setLocationRelativeTo(null);
                            modalDesembolso.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "No Existe Monto para hacer Dcto. Directo", "Alerta", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                }
            }
        }
    }

    private void Limpiar() {
        idAporte = 0;
        idFuncionario = 0;
        idbeneficiario = 0;
        beneficiario.setText("");
        motivoAporte.setText("");
        txtFuncionario.setText("");
        monto.setText("0");
        modoDcto.setSelectedIndex(0);
        txtTotalEfectivo.setText("0");
        txtTotalDcto.setText("0");
        txtTotal.setText("0");
        tools.LimpiarTabla(tblDetalle, modeloDetalle);
    }

    private Boolean validarABM() {

        if (beneficiario.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "No puede Dejar Vacio el Funcionario", "Error", JOptionPane.ERROR_MESSAGE);
            beneficiario.requestFocus();
            return false;
        }

        if (motivoAporte.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Debe de Cargar un Motivo", "Error", JOptionPane.ERROR_MESSAGE);
            beneficiario.requestFocus();
            return false;
        }

        if (tblDetalle.getRowCount() < 0) {
            JOptionPane.showConfirmDialog(null, "Debe de Cargar el Listado de Aportadores", "Error", JOptionPane.ERROR_MESSAGE);
            btnFuncionario.requestFocus();
            return false;
        }

        if (txtTotal.getText().equals("0") || txtTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "No puede Dejar Monto en Cero", "Alerta", JOptionPane.WARNING_MESSAGE);
            monto.requestFocus();
            return false;
        }

        return true;
    }

    private void CargarCombo() {
        sql = "select id, descripcion from concepto where estado = 1";
        tools.CargarCombo(cbConcepto, sql, menu.getConexion());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beneficiario;
    private javax.swing.JButton btnEliminarFilas;
    private javax.swing.JButton btnFuncionario;
    private javax.swing.JButton btnFuncionario1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_pagar;
    private javax.swing.JComboBox<Tools> cbConcepto;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JTextField funcio;
    private javax.swing.JTextField idport;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog modal;
    private javax.swing.JDialog modalDesembolso;
    private javax.swing.JDialog modalImprimir;
    private javax.swing.JComboBox<String> modoDcto;
    private javax.swing.JTextField mont;
    private javax.swing.JTextField monto;
    private javax.swing.JTextPane motivoAporte;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTable tblIndex;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalDcto;
    private javax.swing.JTextField txtTotalEfectivo;
    // End of variables declaration//GEN-END:variables
}
