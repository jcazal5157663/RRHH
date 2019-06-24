package configuracion;

import clases.Tools;
import clases.calculoHorario;
import context.AppContext;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import objetos.Model_permisos;
import principal.menu;

public class horario_default extends javax.swing.JInternalFrame {

    JFormattedTextField formatoHorario = new JFormattedTextField("00:00");
    DefaultTableModel modelHorario;
    private static final int HEADER_HEIGHT = 32;
    Tools tools = new Tools();
    calculoHorario calc = new calculoHorario();
    Model_permisos permiso;
    String sql = "";
    Boolean isInsert;

    public horario_default(Model_permisos permiso) {
        initComponents();

        this.isInsert = Verificar();

        modelHorario = (DefaultTableModel) tblHorario.getModel();
        this.permiso = permiso;
        FormatearCampo();
        AddElement();
        addEventModel();
        tblHorario.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
        tools.CentrarCabeceraTabla(tblHorario);

        JTableHeader header = tblHorario.getTableHeader();
        header.setPreferredSize(new Dimension(100, HEADER_HEIGHT));

        //Codigo que da Aspecto del Label de la tabla a las columnas de las tablas
        tblHorario.getColumnModel().getColumn(0).setCellRenderer(
                tblHorario.getTableHeader().getDefaultRenderer());
        tblHorario.getColumnModel().getColumn(1).setCellRenderer(
                tblHorario.getTableHeader().getDefaultRenderer());
        tblHorario.getColumnModel().getColumn(4).setCellRenderer(
                tblHorario.getTableHeader().getDefaultRenderer());
        tblHorario.getColumnModel().getColumn(7).setCellRenderer(
                tblHorario.getTableHeader().getDefaultRenderer());
        tblHorario.getColumnModel().getColumn(8).setCellRenderer(
                tblHorario.getTableHeader().getDefaultRenderer());

        btnGuardar.setVisible(permiso.getNuevo());

        if (isInsert) {
            CargarGrilla();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable(){
            @Override
            public void changeSelection(int rowIndex, int columnIndex,
                boolean toggle, boolean extend) {
                switch(columnIndex){
                    case 0:
                    super.changeSelection(rowIndex, columnIndex + 2, toggle, extend);
                    break;
                    case 1:
                    super.changeSelection(rowIndex, columnIndex + 1, toggle, extend);
                    break;
                    case 4:
                    super.changeSelection(rowIndex, columnIndex + 1, toggle, extend);
                    break;
                    default:
                    super.changeSelection(rowIndex, columnIndex, toggle, extend);
                    break;
                }
            }
        };
        jLabel3 = new javax.swing.JLabel();
        txtHoraSemanal = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Lunes", null, null, null, null, null, null, null, null},
                {"2", "Martes", null, null, null, null, null, null, null, null},
                {"3", "Miercoles", null, null, null, null, null, null, null, null},
                {"4", "Jueves", null, null, null, null, null, null, null, null},
                {"5", "Viernes", null, null, null, null, null, null, null, null},
                {"6", "Sabado", null, null, null, null, null, null, null, null},
                {"7", "Domingo", null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nro", "Día", "<html><center>Hora<br>Entrada</center></html>", "<html><center>Hora Salida<br>Almuerzo</center></html>", "<html><center>Hora Total<br>Mañana</center></html>", "<html><center>Hora Entrada<br>Almuerzo</center></html>", "<html><center>Hora<br>Salida</center></html>", "<html><center>Hora Total<br>de Tarde</center></html>", "<html><center>Total<br>Horas</center></html>", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHorario.setColumnSelectionAllowed(true);
        tblHorario.setRowHeight(25);
        jScrollPane1.setViewportView(tblHorario);
        tblHorario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblHorario.getColumnModel().getColumnCount() > 0) {
            tblHorario.getColumnModel().getColumn(9).setMinWidth(0);
            tblHorario.getColumnModel().getColumn(9).setPreferredWidth(0);
            tblHorario.getColumnModel().getColumn(9).setMaxWidth(0);
        }

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
        jLabel5.setText("Horario por Defecto");

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
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html><center>Sistema de Gestión de<br>Recursos Humanos</center></html>");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Scatter_Plot_52px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SYSRRHH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoraSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoraSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addContainerGap())))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validar()) {
            InsertOrUpdate();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged

    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed

    }//GEN-LAST:event_jPanel5MousePressed

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
                        h1 = (tblHorario.getValueAt(row, 2) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(row, 2).toString(), 5) : "00:00");
                        h2 = (tblHorario.getValueAt(row, 3) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(row, 3).toString(), 5) : "00:00");
                        hora = calc.restaHorario(h2, h1);
                        tblHorario.setValueAt(hora, row, 4);
                        sumaFila();
                        break;
                    case 3:
                        h1 = (tblHorario.getValueAt(row, 2) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(row, 2).toString(), 5) : "00:00");
                        h2 = (tblHorario.getValueAt(row, 3) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(row, 3).toString(), 5) : "00:00");
                        hora = calc.restaHorario(h2, h1);
                        tblHorario.setValueAt(hora, row, 4);
                        sumaFila();
                        break;

                    case 5:
                        h1 = (tblHorario.getValueAt(row, 5) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(row, 5).toString(), 5) : "00:00");
                        h2 = (tblHorario.getValueAt(row, 6) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(row, 6).toString(), 5) : "00:00");
                        hora = calc.restaHorario(h2, h1);
                        tblHorario.setValueAt(hora, row, 7);
                        sumaFila();
                        break;
                    case 6:
                        h1 = (tblHorario.getValueAt(row, 5) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(row, 5).toString(), 5) : "00:00");
                        h2 = (tblHorario.getValueAt(row, 6) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(row, 6).toString(), 5) : "00:00");
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

    private Boolean Verificar() {
        int RowCount = 0;
        try {
            sql = "select count(*) from config_default_hor where empresa = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, AppContext.ID_EMPRESA);
            String res[] = tools.QueryDinamico(ps);
            RowCount = Integer.parseInt(res[1]);
        } catch (SQLException ex) {
            Logger.getLogger(horario_default.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (RowCount == 0) {
            return false;
        }

        return true;
    }

    private void CargarGrilla() {
        try {
            sql = "select vd.dia, vd.case, vd.hora_entrada, vd.hora_salida_alm, vd.hora1::time, vd.hora_entrada_alm, vd.hora_salida, vd.hora2::time, (hora1 + hora2)::time, vd.id from viewhora_config vd\n"
                    + "where vd.empresa = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, AppContext.ID_EMPRESA);
            tools.CargarTabla(ps, tblHorario, modelHorario, false);

            tblHorario.setRowHeight(25);
            tblHorario.setShowHorizontalLines(true);
            tblHorario.setShowVerticalLines(true);

            //Recorremos la Tabla
            for (int i = 0; i < tblHorario.getColumnCount(); i++) {
                for (int j = 0; j < tblHorario.getRowCount(); j++) {
                    if (tblHorario.getValueAt(j, i).toString().contains("00:00")) {
                        tblHorario.setValueAt(null, j, i);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(horario_default.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void InsertOrUpdate() {
        try {
            if (!isInsert) {
                sql = "INSERT INTO config_default_hor\n"
                        + "(empresa, hora_entrada, hora_salida_alm, hora_entrada_alm, hora_salida, dia, usuario_input,totalsemanal)\n"
                        + "VALUES(? ,? ,? ,? ,? ,? ,?,?)";
                PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                for (int i = 0; i < tblHorario.getRowCount(); i++) {
                    ps.setInt(1, AppContext.ID_EMPRESA);
                    ps.setTime(2, tools.hora((tblHorario.getValueAt(i, 2) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 2).toString(), 5) : "00:00")));
                    ps.setTime(3, tools.hora((tblHorario.getValueAt(i, 3) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 3).toString(), 5) : "00:00")));
                    ps.setTime(4, tools.hora((tblHorario.getValueAt(i, 5) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 5).toString(), 5) : "00:00")));
                    ps.setTime(5, tools.hora((tblHorario.getValueAt(i, 6) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 6).toString(), 5) : "00:00")));
                    ps.setInt(6, Integer.parseInt(tblHorario.getValueAt(i, 0).toString()));
                    ps.setInt(7, menu.getIduser());
                    ps.setString(8, txtHoraSemanal.getText());
                    ps.addBatch();
                }
                ps.executeBatch();
                JOptionPane.showMessageDialog(this, "Hora por Defecto Insertada", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                sql = "UPDATE config_default_hor\n"
                        + "SET \n"
                        + "empresa=?, \n"
                        + "hora_entrada=?, \n"
                        + "hora_salida_alm=?, \n"
                        + "hora_entrada_alm=?, \n"
                        + "hora_salida=?, \n"
                        + "dia=?, \n"
                        + "usuario_update=?, \n"
                        + "fecha_h_update=?, \n"
                        + "totalsemanal = ? \n"
                        + "WHERE id=?";
                PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                for (int i = 0; i < tblHorario.getRowCount(); i++) {
                    ps.setInt(1, AppContext.ID_EMPRESA);
                    ps.setTime(2, tools.hora((tblHorario.getValueAt(i, 2) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 2).toString(), 5) : "00:00")));
                    ps.setTime(3, tools.hora((tblHorario.getValueAt(i, 3) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 3).toString(), 5) : "00:00")));
                    ps.setTime(4, tools.hora((tblHorario.getValueAt(i, 5) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 5).toString(), 5) : "00:00")));
                    ps.setTime(5, tools.hora((tblHorario.getValueAt(i, 6) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 6).toString(), 5) : "00:00")));
                    ps.setInt(6, Integer.parseInt(tblHorario.getValueAt(i, 0).toString()));
                    ps.setInt(7, menu.getIduser());
                    ps.setTimestamp(8, tools.getCurrentTimeStamp());
                    ps.setString(9, txtHoraSemanal.getText());
                    ps.setInt(10, Integer.parseInt(tblHorario.getValueAt(i, 9).toString()));
                    ps.addBatch();
                }
                ps.executeBatch();
                JOptionPane.showMessageDialog(this, "Hora por Defecto Actualizada", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(horario_default.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Boolean validar() {

        //Controlamos los Datos de la Tabla
        for (int i = 0; i < tblHorario.getRowCount(); i++) {
            if (tblHorario.getValueAt(i, 8) != null) {

                if (tools.hora((tblHorario.getValueAt(i, 2) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 2).toString(), 5) : "00:00")).after(tools.hora((tblHorario.getValueAt(i, 3) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 3).toString(), 5) : "00:00")))) {
                    JOptionPane.showMessageDialog(this, "La Hora de Salida de Almuerzo, no puede ser Menor a la Hora de Entrada", "Error", JOptionPane.ERROR_MESSAGE);
                    tblHorario.getSelectionModel().setSelectionInterval(i, i);
                    tblHorario.changeSelection(i, 2, false, false);
                    return false;
                }

                if (tools.hora((tblHorario.getValueAt(i, 2) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 2).toString(), 5) : "00:00")).equals(tools.hora((tblHorario.getValueAt(i, 3) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 3).toString(), 5) : "00:00")))) {
                    JOptionPane.showMessageDialog(this, "La Hora de Salida de Almuerzo, no puede ser igual a la Hora de Entrada", "Error", JOptionPane.ERROR_MESSAGE);
                    tblHorario.getSelectionModel().setSelectionInterval(i, i);
                    tblHorario.changeSelection(i, 2, false, false);
                    return false;
                }

                if (tools.hora((tblHorario.getValueAt(i, 5) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 5).toString(), 5) : "00:00")).after(tools.hora((tblHorario.getValueAt(i, 6) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 6).toString(), 5) : "00:00")))) {
                    JOptionPane.showMessageDialog(this, "La Hora de Salida, no puede ser Menor a la Hora de Entrada del Almuerzo", "Error", JOptionPane.ERROR_MESSAGE);
                    tblHorario.getSelectionModel().setSelectionInterval(i, i);
                    tblHorario.changeSelection(i, 5, false, false);
                    return false;
                }
                if (tools.hora((tblHorario.getValueAt(i, 5) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 5).toString(), 5) : "00:00")).equals(tools.hora((tblHorario.getValueAt(i, 6) != null ? tools.agregarCerosDerecha(tblHorario.getValueAt(i, 6).toString(), 5) : "00:00")))) {
                    JOptionPane.showMessageDialog(this, "La Hora de Salida, no puede ser igual a la Hora de Entrada del Almuerzo", "Error", JOptionPane.ERROR_MESSAGE);
                    tblHorario.getSelectionModel().setSelectionInterval(i, i);
                    tblHorario.changeSelection(i, 5, false, false);
                    return false;
                }
            }
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHorario;
    private javax.swing.JTextField txtHoraSemanal;
    // End of variables declaration//GEN-END:variables
}
