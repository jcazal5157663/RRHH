package buscadores;

import clases.Cerrar_Escape;
import clases.EstilosLabel;
import clases.Tools;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import principal.menu;

public class buscador_ciudad extends javax.swing.JDialog {

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
    int id = 0;
    int xx;
    int xy;

    public buscador_ciudad(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        es.addEscapeListener(this);
        busqueda.requestFocus();
        lb.CambiarColor(btn_nuevo, entrada, Salida);
        lb.CambiarColor(btn_modificar, entrada, Salida);
        lb.CambiarColor(btn_eliminar, entrada, Salida);
        lb.CambiarColor(btn_cerrar, entrada, Salida);
        /*botones del modal*/
        lb.CambiarColor(btn_aplicar, entrada_1, Salida_1);
        lb.CambiarColor(btn_guardar, entrada_1, Salida_1);
        lb.CambiarColor(btn_cancelar, entrada_1, Salida_1);

        modelo = (DefaultTableModel) tabla.getModel();
        CargarGrilla();

        db.Busqued(tabla, modelo, busqueda);
        db.PagTablaAnterior(jScrollPane1, tabla, anterior, 11);
        db.PagTablaSigte(jScrollPane1, tabla, siguiente, 11);

        String cod[] = {"1", "0"};
        String desc[] = {"Activo", "Inactivo"};
        db.CargarCombo(estado, cod, desc);

        db.Solo_Letras(descripcion);
        db.limitarCaracter(descripcion, 250);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modal = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        pais_descri = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_busqueda = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_aplicar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        busqueda = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_cerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        modal.setModal(true);
        modal.setUndecorated(true);
        modal.setResizable(false);
        modal.setSize(new java.awt.Dimension(450, 189));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los Datos Solicitados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Descripción:");

        descripcion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Estado:");

        estado.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        pais_descri.setEditable(false);
        pais_descri.setBackground(new java.awt.Color(255, 255, 255));
        pais_descri.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        pais_descri.setForeground(new java.awt.Color(0, 102, 204));
        pais_descri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pais_descriKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("País:");

        btn_busqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_busqueda.setContentAreaFilled(false);
        btn_busqueda.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcion)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 231, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(pais_descri)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_busqueda)))
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pais_descri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(estado)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Save_32px.png"))); // NOI18N
        btn_guardar.setMnemonic('G');
        btn_guardar.setText("Guardar");
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

        btn_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Close_Window_32px_2.png"))); // NOI18N
        btn_cancelar.setMnemonic('C');
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_cancelar.setContentAreaFilled(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setFocusPainted(false);
        btn_cancelar.setOpaque(true);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_aplicar.setBackground(new java.awt.Color(255, 255, 255));
        btn_aplicar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_aplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Checkmark_32px.png"))); // NOI18N
        btn_aplicar.setMnemonic('A');
        btn_aplicar.setText("Aplicar");
        btn_aplicar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_aplicar.setContentAreaFilled(false);
        btn_aplicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_aplicar.setFocusPainted(false);
        btn_aplicar.setOpaque(true);
        btn_aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 54, Short.MAX_VALUE)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_aplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Buscador Ciudades:::");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "País", "idp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tabla.getColumnModel().getColumn(3).setMinWidth(0);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 102, 570, 356));

        busqueda.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        busqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar::::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                busquedaKeyTyped(evt);
            }
        });
        jPanel1.add(busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 55, 570, -1));

        jPanel3.setBackground(new java.awt.Color(34, 45, 50));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 54, 240, 42));

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
        jPanel3.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 102, 240, 42));

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
        jPanel3.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 151, 240, 42));

        jLabel2.setBackground(new java.awt.Color(58, 128, 167));
        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Menu_24px.png"))); // NOI18N
        jLabel2.setText("Buscador");
        jLabel2.setIconTextGap(5);
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 50));

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
        jPanel3.add(btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 199, 240, 42));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 512));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        anterior.setText("<<");
        jPanel2.add(anterior);

        siguiente.setText(">>");
        jPanel2.add(siguiente);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 464, 570, -1));

        jLabel5.setBackground(new java.awt.Color(64, 142, 186));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 590, 50));

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

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        busqueda.requestFocus();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        busqueda.requestFocus();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        operacion = 1;
        modal.setLocationRelativeTo(null);
        modal.setVisible(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        operacion = 2;
        Selecciona();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        operacion = 3;
        int row = tabla.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Debe de Seleccionar una Fila de la Tabla", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            id = Integer.parseInt(tabla.getValueAt(row, 0).toString());

            int confirma = JOptionPane.showConfirmDialog(null, "Desea Eliminar: " + tabla.getValueAt(row, 1) + "?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            if (confirma == 0) {
                abm();

            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed

        if (evt.getClickCount() == 2 && tabla.getSelectedRow() != -1) {
            int row = tabla.getSelectedRow();
            cod = Integer.parseInt(tabla.getValueAt(row, 0).toString());
            desrip = tabla.getValueAt(row, 1).toString();
            cod2 = Integer.parseInt(tabla.getValueAt(row, 3).toString());
            desrip2 = tabla.getValueAt(row, 2).toString();
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
            cod = Integer.parseInt(tabla.getValueAt(row, 0).toString());
            desrip = tabla.getValueAt(row, 1).toString();

            cod2 = Integer.parseInt(tabla.getValueAt(row, 3).toString());
            desrip2 = tabla.getValueAt(row, 2).toString();
            this.dispose();
        }
    }//GEN-LAST:event_tablaKeyTyped

    private void descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            pais_descri.requestFocus();
        }
    }//GEN-LAST:event_descripcionKeyTyped

    private void pais_descriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pais_descriKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            estado.requestFocus();
        }
    }//GEN-LAST:event_pais_descriKeyTyped

    private void btn_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busquedaActionPerformed
        buscador_pais bp = new buscador_pais(modal, true);
        bp.setVisible(true);
        idpais = bp.getCod();
        pais_descri.setText(bp.getDesrip());
    }//GEN-LAST:event_btn_busquedaActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if (validar()) {
            abm();
            limpiar();
            modal.dispose();
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpiar();
        modal.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aplicarActionPerformed
        if (validar()) {
            abm();
            limpiar();
            operacion = 1;
            descripcion.requestFocus();
        }
    }//GEN-LAST:event_btn_aplicarActionPerformed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        modal.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel4MousePressed

    private void CargarGrilla() {
        tabla.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "selectColumnCell");
        db.LimpiarBusqueda(busqueda, tabla);

        sql = "select dir.id, dir.descripcion,"
                + "p.descripcion, dir.pais \n"
                + "from ciudad dir \n"
                + "join pais p on dir.pais = p.id \n"
                + "order by dir.id";
        db.CargarTabla(sql, tabla, modelo, false, menu.getConexion());

        db.centrar(tabla, new int[]{0});

    }

    private void abm() {

        switch (operacion) {
            case 1:

                sql = "select * from pais where upper(descripcion) = '" + descripcion.getText().toUpperCase() + "'";

                res = db.QueryDinamico(sql, menu.getConexion());

                if (res == null) {
                    String columna[] = {"descripcion", "pais", "estado", "usuario_input"};
                    String datos[] = {"'" + descripcion.getText() + "'", String.valueOf(idpais), String.valueOf(estado.getItemAt(estado.getSelectedIndex()).getId()), String.valueOf(menu.getIduser())};
                    String tbl = "ciudad";
                    db.Insertar(tbl, columna, datos, true, menu.getConexion());

                } else {
                    JOptionPane.showMessageDialog(modal, "Este Dato ya Existe");
                }
                break;
            case 2:
                String columna2[] = {"descripcion", "pais", "estado", "usuario_update", "fecha_h_update"};
                String datos2[] = {"'" + descripcion.getText() + "'", String.valueOf(idpais), String.valueOf(estado.getItemAt(estado.getSelectedIndex()).getId()), String.valueOf(menu.getIduser()), "now()"};
                String tbl2 = "ciudad";
                String condicion = "id =" + id;
                db.Actualizar(tbl2, columna2, datos2, condicion, true, menu.getConexion());

                break;
            case 3:
                String tabla3 = "ciudad";
                String condicion3 = "id = " + id;
                db.eliminar(tabla3, condicion3, true, menu.getConexion());

                break;
        }

        CargarGrilla();
    }

    private Boolean validar() {
        if (descripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar una Descripcion");
            descripcion.requestFocus();
            return false;
        }

        if (pais_descri.getText().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar una NAcionalidad");
            pais_descri.requestFocus();
            return false;
        }
        return true;
    }

    private void Selecciona() {
        int row = tabla.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Debe de Seleccionar una Fila de la Tabla", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            id = Integer.parseInt(tabla.getValueAt(row, 0).toString());
            sql = "select c.descripcion,c.pais,p.descripcion, c.estado from ciudad c join pais p on p.id = c.pais  where c.id = " + id;
            res = db.QueryDinamico(sql, menu.getConexion());

            descripcion.setText(res[1]);
            pais_descri.setText(res[2]);
            db.SelectIdCombo(estado, Integer.parseInt(res[3]));
            modal.setLocationRelativeTo(null);
            modal.setVisible(true);
        }

    }

    private void limpiar() {
        descripcion.setText("");
        pais_descri.setText("");
        estado.setSelectedIndex(0);
    }

    private int cod;
    private String desrip;

    private int cod2;
    private String desrip2;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDesrip() {
        return desrip;
    }

    public void setDesrip(String desrip) {
        this.desrip = desrip;
    }

    public int getCod2() {
        return cod2;
    }

    public void setCod2(int cod2) {
        this.cod2 = cod2;
    }

    public String getDesrip2() {
        return desrip2;
    }

    public void setDesrip2(String desrip2) {
        this.desrip2 = desrip2;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton btn_aplicar;
    private javax.swing.JButton btn_busqueda;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JTextField busqueda;
    private javax.swing.JTextField descripcion;
    private javax.swing.JComboBox<Tools> estado;
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
    private javax.swing.JDialog modal;
    private javax.swing.JTextField pais_descri;
    private javax.swing.JButton siguiente;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
