package movimiento;

import buscadores.buscador_Funcionario;

import java.util.Date;
import clases.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import principal.menu;

public class sol_anticipo extends javax.swing.JInternalFrame {

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
    int idAnticipo = 0;
    Verificar_Anticipo va = new Verificar_Anticipo();

    public sol_anticipo() {
        initComponents();
        lb.CambiarColor(btn_nuevo, entrada, Salida);
        lb.CambiarColor(btn_modificar, entrada, Salida);
        lb.CambiarColor(btn_eliminar, entrada, Salida);
        lb.CambiarColor(btn_cerrar, entrada, Salida);
        lb.CambiarColor(btn_informes, entrada, Salida);
        modelo = (DefaultTableModel) tbl_dcto.getModel();

        CargarGrilla();

        validarCaracteres();


        addKeyEvent();

        db.Busqued(tbl_dcto, modelo, txtBusqueda);

        new Cerrar_Escape().addEscapeListener(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modal = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnSaveAplication = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtFuncionario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        fechaSolicitud = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel6 = new javax.swing.JLabel();
        btnFuncionario = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
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
        modal.setSize(new java.awt.Dimension(416, 184));

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
        jLabel10.setText("Anticipo del Funcionario");

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

        jLabel4.setText("Monto:");

        txtMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonto.setText("0");

        fechaSolicitud.setBackground(new java.awt.Color(255, 255, 255));
        fechaSolicitud.setEnabled(false);

        jLabel6.setText("Fecha de Solicitud:");

        btnFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btnFuncionario.setContentAreaFilled(false);
        btnFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFuncionario.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMonto)
                                    .addComponent(fechaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 110, Short.MAX_VALUE))
                            .addComponent(txtFuncionario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFuncionario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveAplication, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator2)
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
                    .addComponent(jLabel4)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fechaSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveAplication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        fechaSolicitud.setDate(new Date());

        ((JTextField) fechaSolicitud.getDateEditor()).setEnabled(false);

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

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(34, 45, 50));

        jLabel1.setBackground(new java.awt.Color(58, 128, 167));
        jLabel1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reg. de Anticipo Fun.");
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(0, 209, Short.MAX_VALUE))
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
            .addGap(0, 50, Short.MAX_VALUE)
        );

        txtBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Funcionario"));

        tbl_dcto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Funcionario", "Nro. de C.I", "Fecha de Solicitud", "Monto", "Estado", "Fecha H Creación", "Fecha H Actualización", "esta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_dcto);
        if (tbl_dcto.getColumnModel().getColumnCount() > 0) {
            tbl_dcto.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_dcto.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbl_dcto.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl_dcto.getColumnModel().getColumn(2).setMinWidth(75);
            tbl_dcto.getColumnModel().getColumn(2).setPreferredWidth(75);
            tbl_dcto.getColumnModel().getColumn(2).setMaxWidth(75);
            tbl_dcto.getColumnModel().getColumn(3).setMinWidth(100);
            tbl_dcto.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl_dcto.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_dcto.getColumnModel().getColumn(4).setMinWidth(100);
            tbl_dcto.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbl_dcto.getColumnModel().getColumn(4).setMaxWidth(100);
            tbl_dcto.getColumnModel().getColumn(5).setMinWidth(200);
            tbl_dcto.getColumnModel().getColumn(5).setPreferredWidth(200);
            tbl_dcto.getColumnModel().getColumn(5).setMaxWidth(200);
            tbl_dcto.getColumnModel().getColumn(6).setMinWidth(150);
            tbl_dcto.getColumnModel().getColumn(6).setPreferredWidth(150);
            tbl_dcto.getColumnModel().getColumn(6).setMaxWidth(150);
            tbl_dcto.getColumnModel().getColumn(7).setMinWidth(150);
            tbl_dcto.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbl_dcto.getColumnModel().getColumn(7).setMaxWidth(150);
            tbl_dcto.getColumnModel().getColumn(8).setMinWidth(0);
            tbl_dcto.getColumnModel().getColumn(8).setPreferredWidth(0);
            tbl_dcto.getColumnModel().getColumn(8).setMaxWidth(0);
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

        System.out.println(""+bp.getIdbarrio());
    }//GEN-LAST:event_btnFuncionarioActionPerformed

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
            sql = "select * from view_anticipos";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            db.CargarTabla(ps, tbl_dcto, modelo, false);

            db.derecha(tbl_dcto, new int[]{4});
            db.centrar(tbl_dcto, new int[]{2, 3, 5});

        } catch (SQLException ex) {
            Logger.getLogger(sol_anticipo.class.getName()).log(Level.SEVERE, null, ex);
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

        if(!va.Verifica(idFuncionario, txtMonto)){
            return false;
        }
        
        return true;
    }

    private void spFormulario() {

        try {
            switch (operacion) {
                case 1:
                    sql = "INSERT INTO anticipo\n"
                            + "(funcionario, monto, fecha_solicitud, usuario_input, origen)\n"
                            + "VALUES(?, ?, ?, ?, ?)";
                    PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idFuncionario);
                    ps.setDouble(2, db.getParseString(txtMonto));
                    ps.setDate(3, db.convertUtilToSql(fechaSolicitud));
                    ps.setInt(4, menu.getIduser());
                    ps.setInt(5, 0);
                    db.Insertar(ps, true);
                    break;
                case 2:
                    sql = "UPDATE anticipo\n"
                            + "	SET funcionario = ?, \n"
                            + "	monto = ?, \n"
                            + "	fecha_solicitud = ?, \n"
                            + "	usuario_update = ?, \n"
                            + " fecha_update = ?, \n"
                            + " origen = ?\n"
                            + "WHERE id = ?;";
                    PreparedStatement psUpdate = menu.getConexion().prepareStatement(sql);
                    psUpdate.setInt(1, idFuncionario);
                    psUpdate.setDouble(2, db.getParseString(txtMonto));
                    psUpdate.setDate(3, db.convertUtilToSql(fechaSolicitud));
                    psUpdate.setInt(4, menu.getIduser());
                    psUpdate.setTimestamp(5, db.getCurrentTimeStamp());
                    psUpdate.setInt(6, 0);
                    psUpdate.setInt(7, idAnticipo);
                    db.Actualizar(psUpdate, true);

                    break;

                case 3:

                    sql = "UPDATE anticipo set estado = ? where id = ?";
                    PreparedStatement psCancelar = menu.getConexion().prepareStatement(sql);
                    psCancelar.setInt(1, 2);
                    psCancelar.setInt(2, idAnticipo);
                    db.Actualizar(psCancelar, false);
                    JOptionPane.showMessageDialog(this, "Anticipo Cancelado Exitosamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(sol_anticipo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        txtMonto.setText("0");
        idFuncionario = 0;

    }

    private Boolean Verificar(int id) {

        try {
            sql = "select estado from anticipo where id = ? ";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            res = db.QueryDinamico(ps);

            if (!res[1].equals("0")) {
                JOptionPane.showMessageDialog(null, "No se puede Modificar ni Eliminar un Anticipo Pagado o Cancelado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(sol_anticipo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void Modificar() {
        int select = tbl_dcto.getSelectedRow();
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila para poder modificar", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            idAnticipo = db.getParseStringint(tbl_dcto, select, 0);
            if (Verificar(idAnticipo)) {

                try {
                    sql = "select f.id, nom.apenomb, a.monto, a.fecha_solicitud from anticipo a\n" +
                            "join funcionario f on f.id = a.funcionario\n" +
                            "join view_nompersona nom on nom.id = f.persona\n" +
                            "where a.id = ?";
                    PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idAnticipo);
                    res = db.QueryDinamico(ps);
                    idFuncionario = Integer.parseInt(res[1]);
                    txtFuncionario.setText(res[2]);
                    txtMonto.setText(res[3]);
                    ((JTextField) fechaSolicitud.getDateEditor()).setText(res[4]);
                    modal.setLocationRelativeTo(null);
                    modal.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(sol_anticipo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void Eliminar() {
        int select = tbl_dcto.getSelectedRow();
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una Fila para poder modificar", "Alerta", JOptionPane.WARNING_MESSAGE);
        } else {
            idAnticipo = db.getParseStringint(tbl_dcto, select, 0);
            if (Verificar(idAnticipo)) {
                int confirma = JOptionPane.showConfirmDialog(null, "Desea Cancelar el Anticipo Generado?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                if (confirma == 0) {
                    spFormulario();
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFuncionario;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAplication;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_informes;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private com.toedter.calendar.JDateChooser fechaSolicitud;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JDialog modal;
    private javax.swing.JTable tbl_dcto;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
