package movimiento;

import buscadores.buscador_Funcionario;
import clases.*;
import clases.calculoHorario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import principal.menu;

public class horariofuncionario extends javax.swing.JInternalFrame {

    EstilosLabel lb = new EstilosLabel();
    Color entrada = new Color(44, 59, 65);
    Color Salida = new Color(34, 45, 50);
    DefaultTableModel modelHorario;
    DefaultTableModel modeloIndex;
    JFormattedTextField formatoHorario = new JFormattedTextField("");
    Tools tools = new Tools();
    calculoHorario calc = new calculoHorario();
    int operacion = 0;
    int xx, xy;
    private static final int HEADER_HEIGHT = 32;
    String sql = "";
    String res[] = null;
    int idfuncionario = 0;

    public horariofuncionario() {
        initComponents();
        lb.CambiarColor(btn_nuevo, entrada, Salida);
        lb.CambiarColor(btn_modificar, entrada, Salida);
        lb.CambiarColor(btn_eliminar, entrada, Salida);
        lb.CambiarColor(btn_cerrar, entrada, Salida);
        //lb.CambiarColor(btn_informes, entrada, Salida);
        modelHorario = (DefaultTableModel) tblHorario.getModel();
        modeloIndex = (DefaultTableModel) tblIndex.getModel();
        FormatearCampo();
        AddElement();
        addEventModel();
        tblHorario.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
        tools.CentrarCabeceraTabla(tblHorario);

        JTableHeader header = tblHorario.getTableHeader();
        header.setPreferredSize(new Dimension(100, HEADER_HEIGHT));
        CargarGrilla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modal = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        txtfuncionario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fechaDesde = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel2 = new javax.swing.JLabel();
        fechaHasta = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtHoraSemanal = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnFuncionario1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buscador = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIndex = new javax.swing.JTable();

        modal.setModal(true);
        modal.setUndecorated(true);
        modal.setResizable(false);
        modal.setSize(new java.awt.Dimension(895, 410));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));

        txtfuncionario.setEditable(false);
        txtfuncionario.setBackground(new java.awt.Color(255, 255, 255));
        txtfuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionario"));

        jLabel1.setLabelFor(fechaDesde);
        jLabel1.setText("Fecha Desde:");

        jLabel2.setLabelFor(fechaHasta);
        jLabel2.setText("Fecha Hasta:");

        jCheckBox1.setText("Habilitar Horario por Rango de Fecha");

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Lunes", null, null, null, null, null, null, null},
                {"2", "Martes", null, null, null, null, null, null, null},
                {"3", "Miercoles", null, null, null, null, null, null, null},
                {"4", "Jueves", null, null, null, null, null, null, null},
                {"5", "Viernes", null, null, null, null, null, null, null},
                {"6", "Sabado", null, null, null, null, null, null, null},
                {"7", "Domingo", null, null, null, null, null, null, null}
            },
            new String [] {
                "Nro", "Día", "<html><center>Hora<br>Entrada</center></html>", "<html><center>Hora Salida<br>Almuerzo</center></html>", "<html><center>Hora Total<br>Mañana</center></html>", "<html><center>Hora Entrada<br>Almuerzo</center></html>", "<html><center>Hora<br>Salida</center></html>", "<html><center>Hora Total<br>de Tarde</center></html>", "<html><center>Total<br>Horas</center></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHorario.setColumnSelectionAllowed(true);
        tblHorario.setRowHeight(25);
        jScrollPane1.setViewportView(tblHorario);
        if (tblHorario.getColumnModel().getColumnCount() > 0) {
            tblHorario.getColumnModel().getColumn(0).setMinWidth(75);
            tblHorario.getColumnModel().getColumn(0).setPreferredWidth(75);
            tblHorario.getColumnModel().getColumn(0).setMaxWidth(75);
            tblHorario.getColumnModel().getColumn(1).setMinWidth(100);
            tblHorario.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(1).setMaxWidth(100);
            tblHorario.getColumnModel().getColumn(2).setMinWidth(100);
            tblHorario.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(2).setMaxWidth(100);
            tblHorario.getColumnModel().getColumn(3).setMinWidth(100);
            tblHorario.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(3).setMaxWidth(100);
            tblHorario.getColumnModel().getColumn(4).setMinWidth(100);
            tblHorario.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(4).setMaxWidth(100);
            tblHorario.getColumnModel().getColumn(5).setMinWidth(100);
            tblHorario.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(5).setMaxWidth(100);
            tblHorario.getColumnModel().getColumn(6).setMinWidth(100);
            tblHorario.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(6).setMaxWidth(100);
            tblHorario.getColumnModel().getColumn(7).setMinWidth(100);
            tblHorario.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(7).setMaxWidth(100);
            tblHorario.getColumnModel().getColumn(8).setMinWidth(100);
            tblHorario.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblHorario.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        jLabel3.setLabelFor(txtHoraSemanal);
        jLabel3.setText("Total de Horas Semanal:");

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

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));
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
        jLabel5.setText("Registro de Horario del Funcionario");

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

        btnFuncionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btnFuncionario1.setContentAreaFilled(false);
        btnFuncionario1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFuncionario1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionario1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 655, Short.MAX_VALUE)
                        .addComponent(txtHoraSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFuncionario1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFuncionario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoraSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout modalLayout = new javax.swing.GroupLayout(modal.getContentPane());
        modal.getContentPane().setLayout(modalLayout);
        modalLayout.setHorizontalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modalLayout.setVerticalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBorder(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(34, 45, 50));
        jPanel3.setToolTipText("");

        jLabel4.setBackground(new java.awt.Color(58, 128, 167));
        jLabel4.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Horario Funcionario");
        jLabel4.setOpaque(true);

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
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
            .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 150, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(64, 142, 186));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        buscador.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        buscador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Emoji", 0, 11))); // NOI18N

        tblIndex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Funcionario", "Cédula", "Cargo", "Departamento", "Total Horario por Semana", "Estado", "Fecha H. Creación", "Fecha de Última Modificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIndex.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tblIndex);
        if (tblIndex.getColumnModel().getColumnCount() > 0) {
            tblIndex.getColumnModel().getColumn(0).setMinWidth(100);
            tblIndex.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblIndex.getColumnModel().getColumn(0).setMaxWidth(100);
            tblIndex.getColumnModel().getColumn(1).setMinWidth(250);
            tblIndex.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblIndex.getColumnModel().getColumn(1).setMaxWidth(250);
            tblIndex.getColumnModel().getColumn(2).setMinWidth(100);
            tblIndex.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblIndex.getColumnModel().getColumn(2).setMaxWidth(100);
            tblIndex.getColumnModel().getColumn(3).setMinWidth(200);
            tblIndex.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblIndex.getColumnModel().getColumn(3).setMaxWidth(200);
            tblIndex.getColumnModel().getColumn(4).setMinWidth(200);
            tblIndex.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblIndex.getColumnModel().getColumn(4).setMaxWidth(200);
            tblIndex.getColumnModel().getColumn(5).setMinWidth(150);
            tblIndex.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblIndex.getColumnModel().getColumn(5).setMaxWidth(150);
            tblIndex.getColumnModel().getColumn(6).setMinWidth(100);
            tblIndex.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblIndex.getColumnModel().getColumn(6).setMaxWidth(100);
            tblIndex.getColumnModel().getColumn(7).setMinWidth(150);
            tblIndex.getColumnModel().getColumn(7).setPreferredWidth(150);
            tblIndex.getColumnModel().getColumn(7).setMaxWidth(150);
            tblIndex.getColumnModel().getColumn(8).setMinWidth(150);
            tblIndex.getColumnModel().getColumn(8).setPreferredWidth(150);
            tblIndex.getColumnModel().getColumn(8).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscador)
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        int row = tblIndex.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione Fila", "Alerta!", JOptionPane.WARNING_MESSAGE);
        } else {
//            idAporte = tools.getParseStringint(tblIndex, row, 0);
//            modalImprimir.setLocationRelativeTo(null);
//            modalImprimir.setVisible(true);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validar()) {
            abm();
            limpiar();
            CargarGrilla();
            modal.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//        Limpiar();
        modal.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        modal.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

    private void btnFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionario1ActionPerformed
        Boolean swt = false;

        while (!swt) {
            buscador_Funcionario bp = new buscador_Funcionario(modal, true);
            bp.setVisible(true);
            idfuncionario = bp.getIdbarrio();

            swt = true;
            txtfuncionario.setText(bp.getDescBarrio());
            // motivoAporte.requestFocus();

        }

    }//GEN-LAST:event_btnFuncionario1ActionPerformed

    private void AddElement() {
        tools.AsignarCuadroTexto(formatoHorario, tblHorario, 2);
        tools.AsignarCuadroTexto(formatoHorario, tblHorario, 3);
        tools.AsignarCuadroTexto(formatoHorario, tblHorario, 5);
        tools.AsignarCuadroTexto(formatoHorario, tblHorario, 6);
    }

    private void FormatearCampo() {
        try {
            formatoHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
        }
    }

    private void addEventModel() {
        modelHorario.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int columna = e.getColumn();
                int row = tblHorario.getSelectedRow();
                String h1 = "";
                String h2 = "";
                String hora = "";
                switch (columna) {
                    case 2:
                        h1 = (tblHorario.getValueAt(row, 2) != null ? tblHorario.getValueAt(row, 2).toString() : "00:00");
                        h2 = (tblHorario.getValueAt(row, 3) != null ? tblHorario.getValueAt(row, 3).toString() : "00:00");
                        hora = calc.restaHorario(h2, h1);
                        tblHorario.setValueAt(hora, row, 4);
                        sumaFila();
                        break;
                    case 3:
                        h1 = (tblHorario.getValueAt(row, 2) != null ? tblHorario.getValueAt(row, 2).toString() : "00:00");
                        h2 = (tblHorario.getValueAt(row, 3) != null ? tblHorario.getValueAt(row, 3).toString() : "00:00");
                        hora = calc.restaHorario(h2, h1);
                        tblHorario.setValueAt(hora, row, 4);
                        sumaFila();
                        break;

                    case 5:
                        h1 = (tblHorario.getValueAt(row, 5) != null ? tblHorario.getValueAt(row, 5).toString() : "00:00");
                        h2 = (tblHorario.getValueAt(row, 6) != null ? tblHorario.getValueAt(row, 6).toString() : "00:00");
                        hora = calc.restaHorario(h2, h1);
                        tblHorario.setValueAt(hora, row, 7);
                        sumaFila();
                        break;
                    case 6:
                        h1 = (tblHorario.getValueAt(row, 5) != null ? tblHorario.getValueAt(row, 5).toString() : "00:00");
                        h2 = (tblHorario.getValueAt(row, 6) != null ? tblHorario.getValueAt(row, 6).toString() : "00:00");
                        hora = calc.restaHorario(h2, h1);
                        tblHorario.setValueAt(hora, row, 7);
                        sumaFila();
                        break;

                }
            }
        });
    }

    private void sumaFila() {
        int row = tblHorario.getSelectedRow();
        String h1 = (tblHorario.getValueAt(row, 4) != null ? tblHorario.getValueAt(row, 4).toString() : "00:00");
        String h2 = (tblHorario.getValueAt(row, 7) != null ? tblHorario.getValueAt(row, 7).toString() : "00:00");
        String hora = calc.sumaHorario(h2, h1);
        tblHorario.setValueAt(hora, row, 8);
        formatoHorario.setValue("00:00");
        sumaColumna();
    }

    private void sumaColumna() {
        String hora = "00:00";
        for (int i = 0; i < tblHorario.getRowCount(); i++) {
            String h1 = (tblHorario.getValueAt(i, 8) != null ? tblHorario.getValueAt(i, 8).toString() : "00:00");
            hora = calc.sumaHorario(hora, h1);
        }
        txtHoraSemanal.setText(hora);
    }

    private void CargarGrilla() {
        try {
            sql = "select * from viewhorariofun";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            tools.CargarTabla(ps, tblIndex, modeloIndex, false);
        } catch (SQLException ex) {
            Logger.getLogger(horariofuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limpiar(){
        
    }
    
    private void abm(){
        PreparedStatement ps = null;
        try {
        switch(operacion){
            case 1:
                //Insertamos la Cabecera
                ps = menu.getConexion().prepareStatement(sql);
                tools.Insertar(ps, false);
                
                //insertamos El Detalle
                
                break;                
            case 2:
                
                ps = menu.getConexion().prepareStatement(sql);
                tools.Actualizar(ps, true);
                break;
            case 3:
                
                ps = menu.getConexion().prepareStatement(sql);
                tools.eliminar(ps, true);
                break;
        }
         } catch (SQLException ex) {
            Logger.getLogger(horariofuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Boolean validar(){
       
        return true; 
    }
    
    private void Seleccionar(){
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFuncionario1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JTextField buscador;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog modal;
    private javax.swing.JTable tblHorario;
    private javax.swing.JTable tblIndex;
    private javax.swing.JTextField txtHoraSemanal;
    private javax.swing.JTextField txtfuncionario;
    // End of variables declaration//GEN-END:variables
}
