package configuracion;

import clases.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Model_permisos;
import principal.menu;

public class permisosMenu extends javax.swing.JInternalFrame {

    Tools tools = new Tools();
    DefaultTableModel modelo;
    String sql;
    Model_permisos permiso;
    Cerrar_Escape es = new Cerrar_Escape();

    public permisosMenu(Model_permisos permiso) {
        initComponents();
        es.addEscapeListener(this);
        this.permiso = permiso;
        modelo = (DefaultTableModel) tblPermisos.getModel();
        CargarRoles();
        CargarGrilla();
        evtCombo();
        tools.Busqued(tblPermisos, modelo, txtBuscador);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPermisos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        chekAccTodo = new javax.swing.JCheckBox();
        chekNueTodo = new javax.swing.JCheckBox();
        chekModTodo = new javax.swing.JCheckBox();
        chekElimTodo = new javax.swing.JCheckBox();
        chekInfoTodo = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbRolUsuario = new javax.swing.JComboBox<>();
        txtBuscador = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblPermisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Cod. Menu", "Origen", "Menú", "Acceder", "Nuevo", "Modíficar", "Eliminar", "Informes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPermisos.setRowHeight(20);
        jScrollPane1.setViewportView(tblPermisos);
        if (tblPermisos.getColumnModel().getColumnCount() > 0) {
            tblPermisos.getColumnModel().getColumn(0).setMinWidth(0);
            tblPermisos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblPermisos.getColumnModel().getColumn(0).setMaxWidth(0);
            tblPermisos.getColumnModel().getColumn(1).setMinWidth(100);
            tblPermisos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblPermisos.getColumnModel().getColumn(1).setMaxWidth(100);
            tblPermisos.getColumnModel().getColumn(4).setMinWidth(100);
            tblPermisos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblPermisos.getColumnModel().getColumn(4).setMaxWidth(100);
            tblPermisos.getColumnModel().getColumn(5).setMinWidth(100);
            tblPermisos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblPermisos.getColumnModel().getColumn(5).setMaxWidth(100);
            tblPermisos.getColumnModel().getColumn(6).setMinWidth(100);
            tblPermisos.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblPermisos.getColumnModel().getColumn(6).setMaxWidth(100);
            tblPermisos.getColumnModel().getColumn(7).setMinWidth(100);
            tblPermisos.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblPermisos.getColumnModel().getColumn(7).setMaxWidth(100);
            tblPermisos.getColumnModel().getColumn(8).setMinWidth(100);
            tblPermisos.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblPermisos.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        chekAccTodo.setBackground(new java.awt.Color(255, 255, 255));
        chekAccTodo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        chekAccTodo.setText("Acceder a Todo");

        chekNueTodo.setBackground(new java.awt.Color(255, 255, 255));
        chekNueTodo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        chekNueTodo.setText("Nuevo a Todo");

        chekModTodo.setBackground(new java.awt.Color(255, 255, 255));
        chekModTodo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        chekModTodo.setText("Modificar Todo");

        chekElimTodo.setBackground(new java.awt.Color(255, 255, 255));
        chekElimTodo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        chekElimTodo.setText("Eliminar Todo");

        chekInfoTodo.setBackground(new java.awt.Color(255, 255, 255));
        chekInfoTodo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        chekInfoTodo.setText("Ver Todos los Informes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chekAccTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chekNueTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chekModTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chekElimTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chekInfoTodo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chekAccTodo)
                    .addComponent(chekNueTodo)
                    .addComponent(chekModTodo)
                    .addComponent(chekElimTodo)
                    .addComponent(chekInfoTodo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(25, 118, 210));

        jLabel1.setForeground(new java.awt.Color(187, 222, 251));
        jLabel1.setText("Permisos del Sistema por Rol de Usuario");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("SELECCIONE ROL DE USUARIO:");

        txtBuscador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtBuscador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Opciones del Sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Save_32px.png"))); // NOI18N
        btn_guardar.setMnemonic('G');
        btn_guardar.setText("Guardar Permiso");
        btn_guardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_guardar.setContentAreaFilled(false);
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.setFocusPainted(false);
        btn_guardar.setOpaque(true);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtBuscador)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_guardar)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        GuardarPermisos();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void CargarRoles() {
        sql = "select id, descripcion from roles_usuarios where estado = 1\n"
                + "order by id";
        tools.CargarCombo(cbRolUsuario, sql, menu.getConexion());
    }

    private void CargarGrilla() {
        try {
            sql = "select * from viewpermisos vp \n"
                    + "where vp.roles_usuarios = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, tools.getIdCombo(cbRolUsuario));
            tools.CargarTabla(ps, tblPermisos, modelo, false);
            tools.centrar(tblPermisos, new int[]{1});
        } catch (SQLException ex) {
            Logger.getLogger(permisosMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void evtCombo() {
        cbRolUsuario.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    CargarGrilla();

                }
            }
        });
    }

    private void GuardarPermisos() {
    tools.LimpiarBusqueda(txtBuscador, tblPermisos);
        try {
            sql = "UPDATE permiso_menu\n"
                    + "SET \n"
                    + "acceder=?, \n"
                    + "nuevo=?, \n"
                    + "editar=?, \n"
                    + "eliminar=?, \n"
                    + "informes=?,  \n"
                    + "usuario_update = ?,  \n"
                    + "fecha_h_update = ?\n"
                    + "WHERE id = ?;";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            for (int i = 0; i < tblPermisos.getRowCount(); i++) {
                ps.setBoolean(1, (chekAccTodo.isSelected() ? true : (Boolean) tblPermisos.getValueAt(i, 4)));
                ps.setBoolean(2, (chekNueTodo.isSelected() ? true : (Boolean) tblPermisos.getValueAt(i, 5)));
                ps.setBoolean(3, (chekModTodo.isSelected() ? true : (Boolean) tblPermisos.getValueAt(i, 6)));
                ps.setBoolean(4, (chekElimTodo.isSelected() ? true : (Boolean) tblPermisos.getValueAt(i, 7)));
                ps.setBoolean(5, (chekInfoTodo.isSelected() ? true : (Boolean) tblPermisos.getValueAt(i, 8)));
                ps.setInt(6, menu.getIduser());
                ps.setTimestamp(7, tools.getCurrentTimeStamp());
                ps.setInt(8, tools.getParseStringint(tblPermisos, i, 0));
                ps.addBatch();
            }
            ps.executeBatch();
            JOptionPane.showMessageDialog(null, "Permisos Modificados con Exito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            CargarGrilla();
            chekAccTodo.setSelected(false);
            chekNueTodo.setSelected(false);
            chekModTodo.setSelected(false);
            chekElimTodo.setSelected(false);
            chekInfoTodo.setSelected(false);
        } catch (SQLException ex) {
            Logger.getLogger(permisosMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<Tools> cbRolUsuario;
    private javax.swing.JCheckBox chekAccTodo;
    private javax.swing.JCheckBox chekElimTodo;
    private javax.swing.JCheckBox chekInfoTodo;
    private javax.swing.JCheckBox chekModTodo;
    private javax.swing.JCheckBox chekNueTodo;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPermisos;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
