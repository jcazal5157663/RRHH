package movimiento;

import clases.Tools;
import clases.calculoHorario;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class horariofuncionario extends javax.swing.JInternalFrame {

    DefaultTableModel modelHorario;
    JFormattedTextField formatoHorario = new JFormattedTextField("");
    Tools tools = new Tools();
    calculoHorario calc = new calculoHorario();

    public horariofuncionario() {
        initComponents();

        modelHorario = (DefaultTableModel) tblHorario.getModel();
        FormatearCampo();
        AddElement();
        addEventModel();
        tblHorario.getInputMap(tblHorario.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modal = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fechaDesde = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel2 = new javax.swing.JLabel();
        fechaHasta = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtHoraSemanal = new javax.swing.JTextField();

        modal.setModal(true);
        modal.setUndecorated(true);
        modal.setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionario"));

        jButton1.setText("Buscar");

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
                "Nro", "Día", "<html>Hora<br>Entrada</html>", "<html>Hora Salida<br>Almuerzo</html>", "<html>Hora Total<br>Mañana</html>", "<html>Hora Entrada<br>Almuerzo</html>", "<html>Hora<br>Salida</html>", "<html>Hora Total<br>de Tarde</html>", "<html>Total<br>Horas</html>"
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                        .addComponent(txtHoraSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoraSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout modalLayout = new javax.swing.GroupLayout(modal.getContentPane());
        modal.getContentPane().setLayout(modalLayout);
        modalLayout.setHorizontalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        modalLayout.setVerticalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            ex.printStackTrace();
        }
    }

    private void addEventModel() {
        modelHorario.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog modal;
    private javax.swing.JTable tblHorario;
    private javax.swing.JTextField txtHoraSemanal;
    // End of variables declaration//GEN-END:variables
}
