package buscadores;

import buscadores.buscador_ciudad;
import clases.Cerrar_Escape;
import clases.EstilosLabel;
import clases.Tools;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import principal.menu;

public class buscador_Funcionario extends javax.swing.JDialog {

    Color entrada = new Color(44, 59, 65);
    Color Salida = new Color(34, 45, 50);
    Color entrada_1 = new Color(240, 240, 240);
    Color Salida_1 = new Color(255, 255, 255);
    EstilosLabel lb = new EstilosLabel();
    Tools db = new Tools();
    Cerrar_Escape es = new Cerrar_Escape();
    DefaultTableModel modelo = new DefaultTableModel();
    String sql = "";
    String res[] = null;
    int operacion = 0;
    int idpais = 0;
    int idciu = 0;
    int id = 0;
    int xx;
    int xy;

    public buscador_Funcionario(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        es.addEscapeListener(this);
        busqueda.requestFocus();

        lb.CambiarColor(btn_cerrar, entrada, Salida);
        /*botones del modal*/

        modelo = (DefaultTableModel) tabla.getModel();
        CargarGrilla();

        db.Busqued(tabla, modelo, busqueda);
        db.PagTablaAnterior(jScrollPane1, tabla, anterior, 11);
        db.PagTablaSigte(jScrollPane1, tabla, siguiente, 11);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        busqueda = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setTitle("Buscador de Funcionario::::");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Apellido, Nombre", "Cédula de Identidqad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(75);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(75);
            tabla.getColumnModel().getColumn(0).setMaxWidth(75);
            tabla.getColumnModel().getColumn(2).setMinWidth(150);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        busqueda.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        busqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar::::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                busquedaKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(34, 45, 50));

        jLabel2.setBackground(new java.awt.Color(58, 128, 167));
        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Buscador de Funcionario");
        jLabel2.setOpaque(true);

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_cerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        anterior.setText("<<");
        jPanel2.add(anterior);

        siguiente.setText(">>");
        jPanel2.add(siguiente);

        jLabel6.setBackground(new java.awt.Color(64, 142, 186));
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(busqueda)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed

        if (evt.getClickCount() == 2 && tabla.getSelectedRow() != -1) {
            int row = tabla.getSelectedRow();
            idbarrio = Integer.parseInt(tabla.getValueAt(row, 0).toString());
            descBarrio = tabla.getValueAt(row, 1).toString();
            descCiudad = tabla.getValueAt(row, 2).toString();
            this.dispose();
        }
    }//GEN-LAST:event_tablaMousePressed

    private void busquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busquedaKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10 && tabla.getRowCount() > 0) {
            tabla.requestFocus();
        }

    }//GEN-LAST:event_busquedaKeyTyped

    private void tablaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            int row = tabla.getSelectedRow();
            idbarrio = Integer.parseInt(tabla.getValueAt(row, 0).toString());
            descBarrio = tabla.getValueAt(row, 1).toString();
            descCiudad = tabla.getValueAt(row, 2).toString();
            this.dispose();
        }
    }//GEN-LAST:event_tablaKeyTyped

    private void CargarGrilla() {
        try {
            tabla.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "selectColumnCell");
            db.LimpiarBusqueda(busqueda, tabla);

            sql = "select f.id, p.apellido || ', ' || p.nombre \"Apellido, Nombre\", p.cedula  from funcionario f \n"
                    + "join persona p on f.persona = p.id\n"
                    + "where f.estado = 1";

            PreparedStatement ps = menu.getConexion().prepareStatement(sql);

            db.CargarTabla(ps, tabla, modelo, false);

            db.centrar(tabla, new int[]{0, 2});
        } catch (SQLException ex) {
            Logger.getLogger(buscador_Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int idbarrio = 0;
    private String descBarrio = "";
    private String descCiudad = "";

    public int getIdbarrio() {
        return idbarrio;
    }

    public void setIdbarrio(int idbarrio) {
        this.idbarrio = idbarrio;
    }

    public String getDescBarrio() {
        return descBarrio;
    }

    public void setDescBarrio(String descBarrio) {
        this.descBarrio = descBarrio;
    }

    public String getDescCiudad() {
        return descCiudad;
    }

    public void setDescCiudad(String descCiudad) {
        this.descCiudad = descCiudad;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JTextField busqueda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton siguiente;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
