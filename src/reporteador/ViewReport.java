package reporteador;

import clases.EstilosLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

import net.sf.jasperreports.swing.JRViewer;


public class ViewReport extends javax.swing.JFrame {

    private JasperPrint jasperPrint;
    private String tituloInforme;
    private int button;
    Color entrada = new Color(102, 102, 102);
    Color Salida = new Color(51, 51, 51);
    EstilosLabel lb = new EstilosLabel();

    public ViewReport() {
        initComponents();
    }

    public ViewReport(JasperPrint jasperPrint, String tituloInforme) {
        this.jasperPrint = jasperPrint;
        this.tituloInforme = tituloInforme;
        initComponents();
        AddJasperPanel();

        lbTitle.setText(this.tituloInforme);
        setTitle(this.tituloInforme);

        lb.CambiarColor(btnExel, entrada, Salida);
        lb.CambiarColor(btnWord, entrada, Salida);
        lb.CambiarColor(btnPDF, entrada, Salida);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        btnExel = new javax.swing.JButton();
        btnWord = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        panelReport = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vista de Informe");
        setExtendedState(6);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Accounting_50px.png"))); // NOI18N
        jLabel1.setText("Informe");

        lbTitle.setFont(new java.awt.Font("Segoe UI Emoji", 0, 11)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("Aquì va el Título del Informe");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Circled_Menu_24px.png"))); // NOI18N
        jLabel3.setText("Opciones de Informe");

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Open_Box_14px.png"))); // NOI18N
        jLabel4.setText("Exportar a:");

        btnExel.setBackground(new java.awt.Color(51, 51, 51));
        btnExel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExel.setForeground(new java.awt.Color(204, 204, 204));
        btnExel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Microsoft_Excel_32px.png"))); // NOI18N
        btnExel.setMnemonic('M');
        btnExel.setText("Exportar a Excel");
        btnExel.setBorderPainted(false);
        btnExel.setContentAreaFilled(false);
        btnExel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExel.setFocusPainted(false);
        btnExel.setFocusable(false);
        btnExel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExel.setOpaque(true);
        btnExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExelActionPerformed(evt);
            }
        });

        btnWord.setBackground(new java.awt.Color(51, 51, 51));
        btnWord.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnWord.setForeground(new java.awt.Color(204, 204, 204));
        btnWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Microsoft_Word_32px.png"))); // NOI18N
        btnWord.setMnemonic('M');
        btnWord.setText("Exportar a Word");
        btnWord.setBorderPainted(false);
        btnWord.setContentAreaFilled(false);
        btnWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWord.setFocusPainted(false);
        btnWord.setFocusable(false);
        btnWord.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnWord.setOpaque(true);
        btnWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWordActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(51, 51, 51));
        btnPDF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPDF.setForeground(new java.awt.Color(204, 204, 204));
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_PDF_32px.png"))); // NOI18N
        btnPDF.setMnemonic('M');
        btnPDF.setText("Exportar a PDF");
        btnPDF.setBorderPainted(false);
        btnPDF.setContentAreaFilled(false);
        btnPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPDF.setFocusPainted(false);
        btnPDF.setFocusable(false);
        btnPDF.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPDF.setOpaque(true);
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(btnExel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnWord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btnPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnWord, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        panelReport.setBackground(new java.awt.Color(255, 255, 255));
        panelReport.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelReportLayout = new javax.swing.GroupLayout(panelReport);
        panelReport.setLayout(panelReportLayout);
        panelReportLayout.setHorizontalGroup(
            panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );
        panelReportLayout.setVerticalGroup(
            panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExelActionPerformed
        this.button = 1;
        exportar();
    }//GEN-LAST:event_btnExelActionPerformed

    private void btnWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWordActionPerformed
        this.button = 2;
        exportar();
    }//GEN-LAST:event_btnWordActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        this.button = 3;
        exportar();
    }//GEN-LAST:event_btnPDFActionPerformed

    private void AddJasperPanel() {
        MyJasperViewer jRViewer = new MyJasperViewer(jasperPrint);

        panelReport.removeAll();
        //para el tamaño de l reporte se agrega un BorderLayout
        panelReport.setLayout(new BorderLayout());
        panelReport.add(jRViewer, BorderLayout.CENTER);
        panelReport.setVisible(true);
        panelReport.repaint();
        panelReport.revalidate();

    }

    private void exportar() {
        JFileChooser fila = new JFileChooser();
        fila.setApproveButtonText("Exportar");
        fila.setDialogTitle("Exportar y Generar");
        FileNameExtensionFilter filtro = null;
        switch (this.button) {
            case 1:
                filtro = new FileNameExtensionFilter("Archivos Excel", "xls", "xlsx");
                break;
            case 2:
                filtro = new FileNameExtensionFilter("Documento de Word", "docx", "doc");
                break;
            case 3:
                filtro = new FileNameExtensionFilter("Documento Pdf", "pdf");
                break;
        }

        fila.setFileFilter(filtro);
        int seleccion = fila.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try {
                switch (this.button) {
                    case 1:

                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.create.custom.palette", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.one.page.per.sheet", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.remove.empty.space.between.rows", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.remove.empty.space.between.columns", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.white.page.background", "true");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.detect.cell.type", "true");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.size.fix.enabled", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.ignore.graphics", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.collapse.row.span", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.ignore.cell.border", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.ignore.cell.background", "false");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.max.rows.per.sheet", "0");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.wrap.text", "true");
                        this.jasperPrint.setProperty("net.sf.jasperreports.export.xls.use.timezone", "false");

                        JRXlsExporter exporterXLS = new JRXlsExporter();
                        exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT, this.jasperPrint);
                        exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                        exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                        exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);

                        exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(fila.getSelectedFile() + ".xls"));
                        exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                        exporterXLS.exportReport();
                        JOptionPane.showMessageDialog(this, "Archivo Excel Creado Correctamente", "Generación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        JRExporter exporter = new JRDocxExporter();
                        exporter.setParameter(JRExporterParameter.JASPER_PRINT, this.jasperPrint);
                        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(fila.getSelectedFile() + ".doc"));
                        exporter.exportReport();
                        JOptionPane.showMessageDialog(this, "Archivo Word Creado Correctamente", "Generación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                        JRExporter exporterPDF = new JRPdfExporter();
                        exporterPDF.setParameter(JRExporterParameter.JASPER_PRINT, this.jasperPrint);
                        exporterPDF.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(fila.getSelectedFile() + ".pdf"));

                        exporterPDF.exportReport();
                        JOptionPane.showMessageDialog(this, "Archivo PDF Creado Correctamente", "Generación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

            } catch (JRException ex) {
                Logger.getLogger(ViewReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReport().setVisible(true);
            }
        });
    }

    public class MyJasperViewer extends JRViewer {

        public MyJasperViewer(JasperPrint jrPrint) {
            super(jrPrint);

            JButton saveButton = (JButton) this.tlbToolBar.getComponent(0);
            saveButton.setVisible(false);
            
            
            

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExel;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnWord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panelReport;
    // End of variables declaration//GEN-END:variables
}
