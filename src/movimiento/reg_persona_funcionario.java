package movimiento;

import buscadores.buscador_barrio;
import buscadores.buscador_cargo;
import buscadores.buscador_departamento;
import buscadores.buscador_direccion;
import buscadores.buscador_instituto;
import buscadores.buscador_pais;
import buscadores.buscador_profesion;
import buscadores.buscador_sector;
import clases.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import principal.menu;

public class reg_persona_funcionario extends javax.swing.JInternalFrame {

    Cerrar_Escape es = new Cerrar_Escape();
    EstilosLabel lb = new EstilosLabel();
    Tools db = new Tools();
    String sql = "";
    String res[] = null;

    Color entrada = new Color(44, 59, 65);
    Color Salida = new Color(34, 45, 50);
    Color entrada_1 = new Color(240, 240, 240);
    Color Salida_1 = new Color(255, 255, 255);

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo_funcionario = new DefaultTableModel();
    DefaultTableModel modelo_Pariente = new DefaultTableModel();
    DefaultTableModel modelo_Referencia = new DefaultTableModel();
    DefaultTableModel modelo_Experiencia = new DefaultTableModel();

    DecimalFormat formato_decimal = new DecimalFormat("###,###.##");
    int xx;
    int xy;
    int operacion = 0;
    int operacion_funcionario = 0;
    int operacionParentesco = 0;
    int operacionReferencia = 0;
    int operacionExperiencia = 0;
    int idnacionalidad = 0;
    int idprofesion = 0;
    int idbarrio = 0;
    int idcargo = 0;
    int idsector = 0;
    int iddepto = 0;
    int iddireccion = 0;
    int idpersona = 0;
    int idfuncionario = 0;
    int idpariente = 0;
    int idRefrencia = 0;
    int idExperiencia = 0;
    int foco = 0;
    int st = 0;
    int idinstituto;
    int idtitulo;

    public reg_persona_funcionario() {
        initComponents();
        es.addEscapeListener(this);
        lb.CambiarColor(btn_nuevo, entrada, Salida);
        lb.CambiarColor(btn_modificar, entrada, Salida);
        lb.CambiarColor(btn_eliminar, entrada, Salida);
        lb.CambiarColor(btn_cerrar, entrada, Salida);
//        /*botones del modal*/
        lb.CambiarColor(btn_aplicar, entrada_1, Salida_1);
        lb.CambiarColor(btn_guardar, entrada_1, Salida_1);
        lb.CambiarColor(btn_cancelar, entrada_1, Salida_1);

        modelo = (DefaultTableModel) tbl_persona.getModel();
        modelo_funcionario = (DefaultTableModel) tbl_funcionario.getModel();
        modelo_Pariente = (DefaultTableModel) tbl_pariente.getModel();
        modelo_Referencia = (DefaultTableModel) tbl_ref_laboral.getModel();
        modelo_Experiencia = (DefaultTableModel) tbl_Experiencia.getModel();

        CargarGrillaPersona();
        TransFerirFoco();
        soloLetras();
        CargarCombo();
        limitarCaracter();
        funcio.setSelected(false);
        if (funcio.isSelected()) {
            for (Component component : panel_funcionario.getComponents()) {
                component.setEnabled(true);
            }
        } else {
            for (Component component : panel_funcionario.getComponents()) {
                component.setEnabled(false);
            }
        }
        InhabilitarTabs();

        tbl_pariente.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "selectColumnCell");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modal = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        panel_padre = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tipo_documento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        cedula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fecha_nacimiento = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel10 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        estado_civil = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        nacionalidad = new javax.swing.JTextField();
        btn_nacionalidad = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        grupo_sanguineo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        profesion = new javax.swing.JTextField();
        btn_profesion = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        barrio = new javax.swing.JTextField();
        btn_barrio = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        ciudad = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        celular = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        emails = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        direccion_particular = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        funcio = new javax.swing.JCheckBox();
        panel_funcionario = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        cargo = new javax.swing.JTextField();
        btn_cargo = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        sector = new javax.swing.JTextField();
        btn_sector = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        dpto = new javax.swing.JTextField();
        btn_dpto = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        btn_direccion = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        sucursal = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        nroips = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        fecha_ing_ips = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel27 = new javax.swing.JLabel();
        fecha_contrato = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        fecha_meets = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel30 = new javax.swing.JLabel();
        tipo_Contrato = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        tipo_empleado = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        resolucion = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        forma_cobro = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        nro_cuenta = new javax.swing.JTextField();
        fecha_fin_contrato = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel35 = new javax.swing.JLabel();
        banco = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        moneda = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        btn_guardar = new javax.swing.JButton();
        btn_aplicar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        fecha_vencimiento = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jPanel7 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        parientNombre = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_pariente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        parientApellido = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        parientTelefono = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        parientFechaNac = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel40 = new javax.swing.JLabel();
        parientParentesc = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        nuevoPariente = new javax.swing.JButton();
        modificarPariente = new javax.swing.JButton();
        eliminarPariente = new javax.swing.JButton();
        grabarPariente = new javax.swing.JButton();
        cancelarPariente = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        reflabNombre = new javax.swing.JTextField();
        reflaCargo = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        reflaTelefono = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_ref_laboral = new javax.swing.JTable();
        reflaNegocio = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        nuevoreflab = new javax.swing.JButton();
        modificarreflab = new javax.swing.JButton();
        eliminarreflab = new javax.swing.JButton();
        grabarreflab = new javax.swing.JButton();
        cancelarreflab = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_Experiencia = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        expeEmpresa = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        ExpeFDesde = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel48 = new javax.swing.JLabel();
        ExpeFHasta = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####",'_');
        jLabel49 = new javax.swing.JLabel();
        ExpeCargo = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ExpeDescripcion = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        ExpeNuevo = new javax.swing.JButton();
        ExpeModificar = new javax.swing.JButton();
        ExpeEliminar = new javax.swing.JButton();
        ExpeGrabar = new javax.swing.JButton();
        ExpeCancelar = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_Experiencia1 = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        formInstituto = new javax.swing.JTextField();
        btn_instituto = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        btn_titulo = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel55 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel16 = new javax.swing.JPanel();
        ExpeNuevo1 = new javax.swing.JButton();
        ExpeModificar1 = new javax.swing.JButton();
        ExpeEliminar1 = new javax.swing.JButton();
        ExpeGrabar1 = new javax.swing.JButton();
        ExpeCancelar1 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lb_persona = new javax.swing.JLabel();
        lb_funcionario = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        p_persona = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_persona = new javax.swing.JTable();
        p_funcionario = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_funcionario = new javax.swing.JTable();

        modal.setModal(true);
        modal.setUndecorated(true);
        modal.setResizable(false);
        modal.setSize(new java.awt.Dimension(993, 672));
        modal.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                modalWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                modalWindowClosing(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
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

        panel_padre.setBackground(new java.awt.Color(255, 255, 255));
        panel_padre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo de Documento:");

        tipo_documento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tipo_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipo_documentoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cédula:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombre:");

        nombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nombre.setFocusCycleRoot(true);
        nombre.setFocusTraversalPolicyProvider(true);
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Apellidos:");

        apellido.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoKeyTyped(evt);
            }
        });

        cedula.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Fecha de Ven.:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fecha de Nacimiento:");

        fecha_nacimiento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Sexo:");

        sexo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        sexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sexoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Estado Civil:");

        estado_civil.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        estado_civil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                estado_civilKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Nacionalidad:");

        nacionalidad.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nacionalidad.setFocusable(false);

        btn_nacionalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_nacionalidad.setContentAreaFilled(false);
        btn_nacionalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nacionalidad.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_nacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nacionalidadActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Grupo. Sanguineo:");

        grupo_sanguineo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        grupo_sanguineo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                grupo_sanguineoKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Profesión");

        profesion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        profesion.setFocusable(false);

        btn_profesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_profesion.setContentAreaFilled(false);
        btn_profesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_profesion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_profesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profesionActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Barrio:");

        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Domicilio/Ubicación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        barrio.setEditable(false);
        barrio.setBackground(new java.awt.Color(255, 255, 255));
        barrio.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        barrio.setForeground(new java.awt.Color(0, 102, 204));
        barrio.setFocusable(false);

        btn_barrio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_barrio.setContentAreaFilled(false);
        btn_barrio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_barrio.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_barrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barrioActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Ciudad:");

        ciudad.setEditable(false);
        ciudad.setBackground(new java.awt.Color(255, 255, 255));
        ciudad.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ciudad.setForeground(new java.awt.Color(0, 102, 204));
        ciudad.setFocusable(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Teléfono:");

        telefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Celular:");

        celular.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                celularKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Emails:");

        emails.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        emails.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailsKeyTyped(evt);
            }
        });

        direccion_particular.setColumns(20);
        direccion_particular.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        direccion_particular.setLineWrap(true);
        direccion_particular.setRows(3);
        direccion_particular.setWrapStyleWord(true);
        direccion_particular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dirección Particular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N
        direccion_particular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccion_particularKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(direccion_particular);

        funcio.setBackground(new java.awt.Color(255, 255, 255));
        funcio.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        funcio.setText("Registrar Como Funcionario");
        funcio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                funcioItemStateChanged(evt);
            }
        });

        panel_funcionario.setBackground(new java.awt.Color(255, 255, 255));
        panel_funcionario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Funcionario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Cargo:");

        cargo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cargo.setFocusable(false);

        btn_cargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_cargo.setContentAreaFilled(false);
        btn_cargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cargo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Sector:");

        sector.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        sector.setFocusable(false);

        btn_sector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_sector.setContentAreaFilled(false);
        btn_sector.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sector.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_sector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sectorActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Dpto.:");

        dpto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        dpto.setFocusable(false);

        btn_dpto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_dpto.setContentAreaFilled(false);
        btn_dpto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dpto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_dpto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dptoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Dirección:");

        direccion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        direccion.setFocusable(false);

        btn_direccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_direccion.setContentAreaFilled(false);
        btn_direccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_direccion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_direccionActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Sucursal:");

        sucursal.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        sucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sucursalKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Nº I.P.S:");

        nroips.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nroips.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nroipsKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("F. Ingreso I.P.S:");

        fecha_ing_ips.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Fecha Contrato:");

        fecha_contrato.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Fecha Fin Contrato:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Fecha Ing. MEETS:");

        fecha_meets.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Tipo de Contrato:");

        tipo_Contrato.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tipo_Contrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipo_ContratoKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Tipo Empleado:");

        tipo_empleado.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tipo_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipo_empleadoKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Nº Resolución:");

        resolucion.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        resolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                resolucionKeyTyped(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Forma de Cobro:");

        forma_cobro.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Nº de Cuenta:");

        nro_cuenta.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nro_cuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nro_cuentaKeyTyped(evt);
            }
        });

        fecha_fin_contrato.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Banco:");

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Salario:");

        salario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        salario.setText("0");
        salario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                salarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salarioKeyTyped(evt);
            }
        });

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Moneda de Cobro:");

        javax.swing.GroupLayout panel_funcionarioLayout = new javax.swing.GroupLayout(panel_funcionario);
        panel_funcionario.setLayout(panel_funcionarioLayout);
        panel_funcionarioLayout.setHorizontalGroup(
            panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_funcionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_funcionarioLayout.createSequentialGroup()
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_funcionarioLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_funcionarioLayout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sector, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cargo)
                            .addComponent(btn_sector)))
                    .addGroup(panel_funcionarioLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpto, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dpto))
                    .addGroup(panel_funcionarioLayout.createSequentialGroup()
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel_funcionarioLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nroips))
                            .addGroup(panel_funcionarioLayout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_funcionarioLayout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_direccion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fecha_ing_ips, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha_contrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha_meets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha_fin_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipo_Contrato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipo_empleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resolucion)
                    .addComponent(forma_cobro, 0, 177, Short.MAX_VALUE)
                    .addComponent(nro_cuenta)
                    .addComponent(banco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salario)
                    .addComponent(moneda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_funcionarioLayout.setVerticalGroup(
            panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_funcionarioLayout.createSequentialGroup()
                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_funcionarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sector)
                            .addComponent(btn_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_dpto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(sucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)))
                    .addGroup(panel_funcionarioLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_funcionarioLayout.createSequentialGroup()
                                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha_ing_ips, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha_contrato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha_fin_contrato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)))
                            .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(resolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_funcionarioLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(forma_cobro, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(nro_cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fecha_meets, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35)
                                .addComponent(banco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipo_Contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(salario, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(nroips, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipo_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Save_32px.png"))); // NOI18N
        btn_guardar.setMnemonic('G');
        btn_guardar.setText("Guardar     ");
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
        jPanel12.add(btn_guardar);

        btn_aplicar.setBackground(new java.awt.Color(255, 255, 255));
        btn_aplicar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_aplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Checkmark_32px.png"))); // NOI18N
        btn_aplicar.setMnemonic('A');
        btn_aplicar.setText("Aplicar     ");
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
        jPanel12.add(btn_aplicar);

        btn_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Close_Window_32px_2.png"))); // NOI18N
        btn_cancelar.setMnemonic('C');
        btn_cancelar.setText("Cancelar     ");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_cancelar.setContentAreaFilled(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setFocusPainted(false);
        btn_cancelar.setMargin(new java.awt.Insets(2, 14, 2, 50));
        btn_cancelar.setOpaque(true);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel12.add(btn_cancelar);

        fecha_vencimiento.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(funcio)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre)
                            .addComponent(cedula)
                            .addComponent(sexo, 0, 154, Short.MAX_VALUE)
                            .addComponent(grupo_sanguineo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellido, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(profesion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_profesion))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(estado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(fecha_vencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipo_documento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(nacionalidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_nacionalidad))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(barrio)
                                    .addComponent(ciudad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_barrio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(emails)
                                        .addGap(18, 18, 18))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 53, Short.MAX_VALUE))))
                    .addComponent(panel_funcionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addComponent(fecha_nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(fecha_vencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexo)
                            .addComponent(jLabel11)
                            .addComponent(estado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(grupo_sanguineo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(profesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_profesion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(barrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_barrio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emails)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(funcio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_padre.addTab("Datos Personales", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setForeground(new java.awt.Color(0, 153, 255));
        jTextField3.setText("CAZAL, JOSE LUIS");
        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionario"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre del Pariente:");

        parientNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        parientNombre.setEnabled(false);
        parientNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parientNombreKeyTyped(evt);
            }
        });

        tbl_pariente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Apellido, Nombre", "Parentesco", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pariente.setFocusable(false);
        tbl_pariente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_parienteMousePressed(evt);
            }
        });
        tbl_pariente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_parienteKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_pariente);
        if (tbl_pariente.getColumnModel().getColumnCount() > 0) {
            tbl_pariente.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_pariente.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_pariente.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl_pariente.getColumnModel().getColumn(3).setMinWidth(75);
            tbl_pariente.getColumnModel().getColumn(3).setPreferredWidth(75);
            tbl_pariente.getColumnModel().getColumn(3).setMaxWidth(75);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido del Pariente:");

        parientApellido.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        parientApellido.setEnabled(false);
        parientApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parientApellidoKeyTyped(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Teléfono:");

        parientTelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        parientTelefono.setEnabled(false);
        parientTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parientTelefonoKeyTyped(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Fecha de Nacimiento:");

        parientFechaNac.setEnabled(false);
        parientFechaNac.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Parentesco:");

        parientParentesc.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        parientParentesc.setEnabled(false);
        parientParentesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parientParentescKeyTyped(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nuevoPariente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nuevoPariente.setText("Nuevo");
        nuevoPariente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoParienteActionPerformed(evt);
            }
        });
        jPanel11.add(nuevoPariente);

        modificarPariente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        modificarPariente.setText("Modificar");
        modificarPariente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarParienteActionPerformed(evt);
            }
        });
        jPanel11.add(modificarPariente);

        eliminarPariente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        eliminarPariente.setText("Eliminar");
        eliminarPariente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarParienteActionPerformed(evt);
            }
        });
        jPanel11.add(eliminarPariente);

        grabarPariente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        grabarPariente.setText("Grabar");
        grabarPariente.setEnabled(false);
        grabarPariente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarParienteActionPerformed(evt);
            }
        });
        jPanel11.add(grabarPariente);

        cancelarPariente.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cancelarPariente.setText("Cancelar");
        cancelarPariente.setEnabled(false);
        cancelarPariente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarParienteActionPerformed(evt);
            }
        });
        jPanel11.add(cancelarPariente);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parientNombre))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parientApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parientTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parientParentesc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parientFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parientNombre, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parientApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parientTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parientFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parientParentesc)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 352, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_padre.addTab("Datos Familiares/Ref. Personal", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setForeground(new java.awt.Color(0, 153, 255));
        jTextField4.setText("CAZAL, JOSE LUIS");
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionario"));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("Nombre y Apellido:");

        reflabNombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        reflabNombre.setEnabled(false);
        reflabNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reflabNombreKeyTyped(evt);
            }
        });

        reflaCargo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        reflaCargo.setEnabled(false);
        reflaCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reflaCargoKeyTyped(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Cargo:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Teléfono:");

        reflaTelefono.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        reflaTelefono.setEnabled(false);
        reflaTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reflaTelefonoKeyTyped(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Empresa o Negocio:");

        tbl_ref_laboral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Apellido, Nombre", "Empresa", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ref_laboral.setFocusable(false);
        tbl_ref_laboral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_ref_laboralMousePressed(evt);
            }
        });
        tbl_ref_laboral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_ref_laboralKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_ref_laboral);
        if (tbl_ref_laboral.getColumnModel().getColumnCount() > 0) {
            tbl_ref_laboral.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_ref_laboral.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_ref_laboral.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl_ref_laboral.getColumnModel().getColumn(3).setMinWidth(75);
            tbl_ref_laboral.getColumnModel().getColumn(3).setPreferredWidth(75);
            tbl_ref_laboral.getColumnModel().getColumn(3).setMaxWidth(75);
        }

        reflaNegocio.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        reflaNegocio.setEnabled(false);
        reflaNegocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reflaNegocioKeyTyped(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nuevoreflab.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        nuevoreflab.setText("Nuevo");
        nuevoreflab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoreflabActionPerformed(evt);
            }
        });
        jPanel14.add(nuevoreflab);

        modificarreflab.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        modificarreflab.setText("Modificar");
        modificarreflab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarreflabActionPerformed(evt);
            }
        });
        jPanel14.add(modificarreflab);

        eliminarreflab.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        eliminarreflab.setText("Eliminar");
        eliminarreflab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarreflabActionPerformed(evt);
            }
        });
        jPanel14.add(eliminarreflab);

        grabarreflab.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        grabarreflab.setText("Grabar");
        grabarreflab.setEnabled(false);
        grabarreflab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarreflabActionPerformed(evt);
            }
        });
        jPanel14.add(grabarreflab);

        cancelarreflab.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cancelarreflab.setText("Cancelar");
        cancelarreflab.setEnabled(false);
        cancelarreflab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarreflabActionPerformed(evt);
            }
        });
        jPanel14.add(cancelarreflab);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reflabNombre))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reflaCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reflaTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reflaNegocio)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reflabNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reflaCargo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reflaTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reflaNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_padre.addTab("Referencias Laborales", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Experiencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Empresa", "Cargo", "Descripción", "Fecha Desde", "Fecha Hasta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Experiencia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_Experiencia.setFocusable(false);
        tbl_Experiencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_ExperienciaMousePressed(evt);
            }
        });
        tbl_Experiencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_ExperienciaKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_Experiencia);
        if (tbl_Experiencia.getColumnModel().getColumnCount() > 0) {
            tbl_Experiencia.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_Experiencia.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_Experiencia.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl_Experiencia.getColumnModel().getColumn(1).setMinWidth(250);
            tbl_Experiencia.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbl_Experiencia.getColumnModel().getColumn(1).setMaxWidth(250);
            tbl_Experiencia.getColumnModel().getColumn(2).setMinWidth(250);
            tbl_Experiencia.getColumnModel().getColumn(2).setPreferredWidth(250);
            tbl_Experiencia.getColumnModel().getColumn(2).setMaxWidth(250);
            tbl_Experiencia.getColumnModel().getColumn(3).setMinWidth(200);
            tbl_Experiencia.getColumnModel().getColumn(3).setPreferredWidth(200);
            tbl_Experiencia.getColumnModel().getColumn(3).setMaxWidth(200);
            tbl_Experiencia.getColumnModel().getColumn(4).setMinWidth(75);
            tbl_Experiencia.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbl_Experiencia.getColumnModel().getColumn(4).setMaxWidth(75);
            tbl_Experiencia.getColumnModel().getColumn(5).setMinWidth(75);
            tbl_Experiencia.getColumnModel().getColumn(5).setPreferredWidth(75);
            tbl_Experiencia.getColumnModel().getColumn(5).setMaxWidth(75);
        }

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Empresa/Negocio:");

        expeEmpresa.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        expeEmpresa.setEnabled(false);
        expeEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                expeEmpresaKeyTyped(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Fecha Desde:");

        ExpeFDesde.setEnabled(false);
        ExpeFDesde.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("Fecha Hasta:");

        ExpeFHasta.setEnabled(false);
        ExpeFHasta.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Cargo:");

        ExpeCargo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeCargo.setEnabled(false);
        ExpeCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ExpeCargoKeyTyped(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText("Descripción:");

        ExpeDescripcion.setColumns(20);
        ExpeDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ExpeDescripcion.setLineWrap(true);
        ExpeDescripcion.setRows(5);
        ExpeDescripcion.setWrapStyleWord(true);
        ExpeDescripcion.setEnabled(false);
        ExpeDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ExpeDescripcionKeyTyped(evt);
            }
        });
        jScrollPane7.setViewportView(ExpeDescripcion);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ExpeNuevo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeNuevo.setText("Nuevo");
        ExpeNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeNuevoActionPerformed(evt);
            }
        });
        jPanel15.add(ExpeNuevo);

        ExpeModificar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeModificar.setText("Modificar");
        ExpeModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeModificarActionPerformed(evt);
            }
        });
        jPanel15.add(ExpeModificar);

        ExpeEliminar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeEliminar.setText("Eliminar");
        ExpeEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeEliminarActionPerformed(evt);
            }
        });
        jPanel15.add(ExpeEliminar);

        ExpeGrabar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeGrabar.setText("Grabar");
        ExpeGrabar.setEnabled(false);
        ExpeGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeGrabarActionPerformed(evt);
            }
        });
        jPanel15.add(ExpeGrabar);

        ExpeCancelar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeCancelar.setText("Cancelar");
        ExpeCancelar.setEnabled(false);
        ExpeCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeCancelarActionPerformed(evt);
            }
        });
        jPanel15.add(ExpeCancelar);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setForeground(new java.awt.Color(0, 153, 255));
        jTextField7.setText("CAZAL, JOSE LUIS");
        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionario"));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expeEmpresa)
                            .addComponent(ExpeCargo)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ExpeFDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(ExpeFHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 210, Short.MAX_VALUE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(expeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExpeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ExpeFDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ExpeFHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 284, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_padre.addTab("Experiencia Laboral", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        tbl_Experiencia1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Empresa", "Cargo", "Descripción", "Fecha Desde", "Fecha Hasta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Experiencia1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbl_Experiencia1.setFocusable(false);
        tbl_Experiencia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_Experiencia1MousePressed(evt);
            }
        });
        tbl_Experiencia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_Experiencia1KeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(tbl_Experiencia1);
        if (tbl_Experiencia1.getColumnModel().getColumnCount() > 0) {
            tbl_Experiencia1.getColumnModel().getColumn(0).setMinWidth(50);
            tbl_Experiencia1.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_Experiencia1.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl_Experiencia1.getColumnModel().getColumn(1).setMinWidth(250);
            tbl_Experiencia1.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbl_Experiencia1.getColumnModel().getColumn(1).setMaxWidth(250);
            tbl_Experiencia1.getColumnModel().getColumn(2).setMinWidth(250);
            tbl_Experiencia1.getColumnModel().getColumn(2).setPreferredWidth(250);
            tbl_Experiencia1.getColumnModel().getColumn(2).setMaxWidth(250);
            tbl_Experiencia1.getColumnModel().getColumn(3).setMinWidth(200);
            tbl_Experiencia1.getColumnModel().getColumn(3).setPreferredWidth(200);
            tbl_Experiencia1.getColumnModel().getColumn(3).setMaxWidth(200);
            tbl_Experiencia1.getColumnModel().getColumn(4).setMinWidth(75);
            tbl_Experiencia1.getColumnModel().getColumn(4).setPreferredWidth(75);
            tbl_Experiencia1.getColumnModel().getColumn(4).setMaxWidth(75);
            tbl_Experiencia1.getColumnModel().getColumn(5).setMinWidth(75);
            tbl_Experiencia1.getColumnModel().getColumn(5).setPreferredWidth(75);
            tbl_Experiencia1.getColumnModel().getColumn(5).setMaxWidth(75);
        }

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel51.setText("Instituto");

        formInstituto.setEditable(false);
        formInstituto.setBackground(new java.awt.Color(255, 255, 255));
        formInstituto.setForeground(new java.awt.Color(0, 153, 204));

        btn_instituto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_instituto.setContentAreaFilled(false);
        btn_instituto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_instituto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_instituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_institutoActionPerformed(evt);
            }
        });

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("Titulo:");

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setForeground(new java.awt.Color(0, 153, 204));

        btn_titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Search_24px.png"))); // NOI18N
        btn_titulo.setContentAreaFilled(false);
        btn_titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_titulo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tituloActionPerformed(evt);
            }
        });

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel53.setText("Situación:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cursando", "Culminado" }));

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel54.setText("F. Desde:");

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel55.setText("F. Hasta:");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ExpeNuevo1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeNuevo1.setText("Nuevo");
        ExpeNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeNuevo1ActionPerformed(evt);
            }
        });
        jPanel16.add(ExpeNuevo1);

        ExpeModificar1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeModificar1.setText("Modificar");
        ExpeModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeModificar1ActionPerformed(evt);
            }
        });
        jPanel16.add(ExpeModificar1);

        ExpeEliminar1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeEliminar1.setText("Eliminar");
        ExpeEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeEliminar1ActionPerformed(evt);
            }
        });
        jPanel16.add(ExpeEliminar1);

        ExpeGrabar1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeGrabar1.setText("Grabar");
        ExpeGrabar1.setEnabled(false);
        ExpeGrabar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeGrabar1ActionPerformed(evt);
            }
        });
        jPanel16.add(ExpeGrabar1);

        ExpeCancelar1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        ExpeCancelar1.setText("Cancelar");
        ExpeCancelar1.setEnabled(false);
        ExpeCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpeCancelar1ActionPerformed(evt);
            }
        });
        jPanel16.add(ExpeCancelar1);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setForeground(new java.awt.Color(0, 153, 255));
        jTextField5.setText("CAZAL, JOSE LUIS");
        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionario"));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(formInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_instituto))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_titulo))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(165, 165, 165)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel51)
                                    .addComponent(formInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_instituto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_padre.addTab("Formación Académica", jPanel10);

        jPanel13.setBackground(new java.awt.Color(0, 102, 51));
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel13MouseDragged(evt);
            }
        });
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel13MousePressed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Carga de Planilla Persona");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Delete_24px.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_padre)
                .addContainerGap())
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_padre)
                .addContainerGap())
        );

        javax.swing.GroupLayout modalLayout = new javax.swing.GroupLayout(modal.getContentPane());
        modal.getContentPane().setLayout(modalLayout);
        modalLayout.setHorizontalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        modalLayout.setVerticalGroup(
            modalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(34, 45, 50));

        jLabel1.setBackground(new java.awt.Color(58, 128, 167));
        jLabel1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Persona Funcionario");
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
                    .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(64, 142, 186));

        lb_persona.setBackground(new java.awt.Color(255, 255, 255));
        lb_persona.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lb_persona.setForeground(new java.awt.Color(102, 102, 102));
        lb_persona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_persona.setText("Persona");
        lb_persona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_persona.setOpaque(true);
        lb_persona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lb_personaMouseReleased(evt);
            }
        });

        lb_funcionario.setBackground(new java.awt.Color(64, 142, 186));
        lb_funcionario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lb_funcionario.setForeground(new java.awt.Color(255, 255, 255));
        lb_funcionario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_funcionario.setText("Funcionario");
        lb_funcionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_funcionario.setOpaque(true);
        lb_funcionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lb_funcionarioMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lb_persona, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lb_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_persona, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setLayout(new java.awt.CardLayout());

        p_persona.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        tbl_persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Apellido, Nombre", "Cédula", "Teléfono", "Celular", "Email", "F. H. Creación", "F. H. Actualización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_persona);
        if (tbl_persona.getColumnModel().getColumnCount() > 0) {
            tbl_persona.getColumnModel().getColumn(0).setMinWidth(75);
            tbl_persona.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbl_persona.getColumnModel().getColumn(0).setMaxWidth(75);
            tbl_persona.getColumnModel().getColumn(2).setMinWidth(100);
            tbl_persona.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_persona.getColumnModel().getColumn(2).setMaxWidth(100);
            tbl_persona.getColumnModel().getColumn(3).setMinWidth(100);
            tbl_persona.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl_persona.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_persona.getColumnModel().getColumn(4).setMinWidth(100);
            tbl_persona.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbl_persona.getColumnModel().getColumn(4).setMaxWidth(100);
            tbl_persona.getColumnModel().getColumn(5).setMinWidth(200);
            tbl_persona.getColumnModel().getColumn(5).setPreferredWidth(200);
            tbl_persona.getColumnModel().getColumn(5).setMaxWidth(200);
            tbl_persona.getColumnModel().getColumn(6).setMinWidth(150);
            tbl_persona.getColumnModel().getColumn(6).setPreferredWidth(150);
            tbl_persona.getColumnModel().getColumn(6).setMaxWidth(150);
            tbl_persona.getColumnModel().getColumn(7).setMinWidth(150);
            tbl_persona.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbl_persona.getColumnModel().getColumn(7).setMaxWidth(150);
        }

        javax.swing.GroupLayout p_personaLayout = new javax.swing.GroupLayout(p_persona);
        p_persona.setLayout(p_personaLayout);
        p_personaLayout.setHorizontalGroup(
            p_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_personaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                .addContainerGap())
        );
        p_personaLayout.setVerticalGroup(
            p_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_personaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel4.add(p_persona, "card2");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador Funcionario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11))); // NOI18N

        tbl_funcionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Apellido, Nombre", "Cédula", "Teléfono", "Celular", "Email", "F. H. Creación", "F. H. Actualización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_funcionario);
        if (tbl_funcionario.getColumnModel().getColumnCount() > 0) {
            tbl_funcionario.getColumnModel().getColumn(0).setMinWidth(75);
            tbl_funcionario.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbl_funcionario.getColumnModel().getColumn(0).setMaxWidth(75);
            tbl_funcionario.getColumnModel().getColumn(2).setMinWidth(100);
            tbl_funcionario.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_funcionario.getColumnModel().getColumn(2).setMaxWidth(100);
            tbl_funcionario.getColumnModel().getColumn(3).setMinWidth(100);
            tbl_funcionario.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl_funcionario.getColumnModel().getColumn(3).setMaxWidth(100);
            tbl_funcionario.getColumnModel().getColumn(4).setMinWidth(100);
            tbl_funcionario.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbl_funcionario.getColumnModel().getColumn(4).setMaxWidth(100);
            tbl_funcionario.getColumnModel().getColumn(5).setMinWidth(200);
            tbl_funcionario.getColumnModel().getColumn(5).setPreferredWidth(200);
            tbl_funcionario.getColumnModel().getColumn(5).setMaxWidth(200);
            tbl_funcionario.getColumnModel().getColumn(6).setMinWidth(150);
            tbl_funcionario.getColumnModel().getColumn(6).setPreferredWidth(150);
            tbl_funcionario.getColumnModel().getColumn(6).setMaxWidth(150);
            tbl_funcionario.getColumnModel().getColumn(7).setMinWidth(150);
            tbl_funcionario.getColumnModel().getColumn(7).setPreferredWidth(150);
            tbl_funcionario.getColumnModel().getColumn(7).setMaxWidth(150);
        }

        javax.swing.GroupLayout p_funcionarioLayout = new javax.swing.GroupLayout(p_funcionario);
        p_funcionario.setLayout(p_funcionarioLayout);
        p_funcionarioLayout.setHorizontalGroup(
            p_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_funcionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                .addContainerGap())
        );
        p_funcionarioLayout.setVerticalGroup(
            p_funcionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_funcionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jPanel4.add(p_funcionario, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb_personaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_personaMouseReleased
        p_persona.setVisible(true);
        p_funcionario.setVisible(false);
        lb_persona.setBackground(new Color(255, 255, 255));
        lb_persona.setForeground(new Color(102, 102, 102));
        /*el label primario*/
        lb_funcionario.setBackground(new Color(64, 142, 186));
        lb_funcionario.setForeground(new Color(255, 255, 255));
        CargarGrillaPersona();
        st = 0;
    }//GEN-LAST:event_lb_personaMouseReleased

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        operacion = 1;
        modal.setLocationRelativeTo(null);
        nombre.requestFocus();
        modal.setVisible(true);
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        operacion = 2;
        select();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        operacion = 3;
//        int row = tabla.getSelectedRow();
//
//        if (row < 0) {
//            JOptionPane.showMessageDialog(this, "Debe de Seleccionar una Fila de la Tabla", "Error", JOptionPane.ERROR_MESSAGE);
//        } else {
//            id = Integer.parseInt(tabla.getValueAt(row, 0).toString());
//
//            int confirma = JOptionPane.showConfirmDialog(null, "Desea Eliminar: " + tabla.getValueAt(row, 1) + "?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
//            if (confirma == 0) {
//                abm();
//
//            }
//        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_nacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nacionalidadActionPerformed
        buscador_pais bp = new buscador_pais(modal, true);
        bp.setVisible(true);
        idnacionalidad = bp.getCod();
        nacionalidad.setText(bp.getNacionalidad());
        grupo_sanguineo.requestFocus();
    }//GEN-LAST:event_btn_nacionalidadActionPerformed

    private void btn_profesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profesionActionPerformed
        buscador_profesion bp = new buscador_profesion(modal, true);
        bp.setVisible(true);
        idprofesion = bp.getCod();
        profesion.setText(bp.getDesrip());
        btn_barrio.requestFocus();
    }//GEN-LAST:event_btn_profesionActionPerformed

    private void btn_barrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barrioActionPerformed
        buscador_barrio bp = new buscador_barrio(modal, true);
        bp.setVisible(true);
        idbarrio = bp.getIdbarrio();
        barrio.setText(bp.getDescBarrio());
        ciudad.setText(bp.getDescCiudad());
        telefono.requestFocus();
    }//GEN-LAST:event_btn_barrioActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
//        if (validar()) {
//            abm();
//            limpiar();
//            modal.dispose();
//        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aplicarActionPerformed
        if (ValidarPersona()) {
            GuardarPersona();
            if (funcio.isSelected()) {
                if (ValidarFuncionario()) {
                    abmFuncionario();
                }
            }
        }
    }//GEN-LAST:event_btn_aplicarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        foco = 0;
        modal.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargoActionPerformed
        buscador_cargo bp = new buscador_cargo(modal, true);
        bp.setVisible(true);
        idcargo = bp.getCod();
        cargo.setText(bp.getDesrip());
        btn_sector.requestFocus();
    }//GEN-LAST:event_btn_cargoActionPerformed

    private void btn_sectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sectorActionPerformed
        buscador_sector bp = new buscador_sector(modal, true);
        bp.setVisible(true);
        idsector = bp.getCod();
        sector.setText(bp.getDesrip());
        btn_dpto.requestFocus();
    }//GEN-LAST:event_btn_sectorActionPerformed

    private void btn_dptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dptoActionPerformed
        buscador_departamento bp = new buscador_departamento(modal, true);
        bp.setVisible(true);
        iddepto = bp.getCod();
        dpto.setText(bp.getDesrip());
        btn_direccion.requestFocus();
    }//GEN-LAST:event_btn_dptoActionPerformed

    private void btn_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_direccionActionPerformed
        buscador_direccion bp = new buscador_direccion(modal, true);
        bp.setVisible(true);
        iddireccion = bp.getCod();
        direccion.setText(bp.getDesrip());
        sucursal.requestFocus();
    }//GEN-LAST:event_btn_direccionActionPerformed

    private void funcioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_funcioItemStateChanged
        if (funcio.isSelected()) {
            for (Component component : panel_funcionario.getComponents()) {
                component.setEnabled(true);
            }
        } else {
            for (Component component : panel_funcionario.getComponents()) {
                component.setEnabled(false);
            }
        }
    }//GEN-LAST:event_funcioItemStateChanged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        modal.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            apellido.requestFocus();
        }
    }//GEN-LAST:event_nombreKeyTyped

    private void apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            tipo_documento.requestFocus();
        }
    }//GEN-LAST:event_apellidoKeyTyped

    private void tipo_documentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_documentoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            cedula.requestFocus();
        }
    }//GEN-LAST:event_tipo_documentoKeyTyped

    private void cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            fecha_vencimiento.getDateEditor().getUiComponent().requestFocus();
        }
    }//GEN-LAST:event_cedulaKeyTyped

    private void sexoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sexoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            estado_civil.requestFocus();
        }
    }//GEN-LAST:event_sexoKeyTyped

    private void estado_civilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estado_civilKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            btn_nacionalidad.requestFocus();
        }
    }//GEN-LAST:event_estado_civilKeyTyped

    private void grupo_sanguineoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grupo_sanguineoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            btn_profesion.requestFocus();
        }
    }//GEN-LAST:event_grupo_sanguineoKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            celular.requestFocus();
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void celularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celularKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            emails.requestFocus();
        }

    }//GEN-LAST:event_celularKeyTyped

    private void emailsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailsKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            direccion_particular.requestFocus();
        }
    }//GEN-LAST:event_emailsKeyTyped

    private void direccion_particularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccion_particularKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            btn_cargo.requestFocus();
        }
    }//GEN-LAST:event_direccion_particularKeyTyped

    private void nroipsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nroipsKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            fecha_ing_ips.getDateEditor().getUiComponent().requestFocus();
        }
    }//GEN-LAST:event_nroipsKeyTyped

    private void sucursalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sucursalKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            nroips.requestFocus();
        }

    }//GEN-LAST:event_sucursalKeyTyped

    private void tipo_ContratoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_ContratoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            tipo_empleado.requestFocus();
        }
    }//GEN-LAST:event_tipo_ContratoKeyTyped

    private void tipo_empleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_empleadoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            resolucion.requestFocus();
        }
    }//GEN-LAST:event_tipo_empleadoKeyTyped

    private void resolucionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resolucionKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            forma_cobro.requestFocus();
        }
    }//GEN-LAST:event_resolucionKeyTyped

    private void nro_cuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nro_cuentaKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            nro_cuenta.requestFocus();
        }
    }//GEN-LAST:event_nro_cuentaKeyTyped

    private void modalWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_modalWindowActivated
        if (foco == 0) {
            nombre.requestFocus();
            foco = 1;
            panel_padre.setSelectedIndex(0);
        }

    }//GEN-LAST:event_modalWindowActivated

    private void modalWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_modalWindowClosing
        foco = 0;
    }//GEN-LAST:event_modalWindowClosing

    private void salarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salarioKeyReleased
        if (salario.getText().trim().equals("")) {
            salario.setText("0");
        }

        int letra = evt.getKeyChar();
        if (Character.isDigit(letra) || letra == 8) {
            salario.setText(formato_decimal.format(Double.parseDouble(salario.getText().replace(".", "").replace(",", ".") + "f")));
        }
    }//GEN-LAST:event_salarioKeyReleased

    private void salarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salarioKeyTyped
        if (salario.getText().trim().equals("0")) {
            String replace = salario.getText().replace("0", "");
            salario.setText(replace);
        }

        int letra = evt.getKeyChar();
        if (letra == 44 && moneda.getItemAt(moneda.getSelectedIndex()).getId() == 1) {
            evt.consume();
        }

        /*validamos que sea solo una coma*/
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != ',') {
            evt.consume();
        }
        if (evt.getKeyChar() == ',' && salario.getText().contains(",")) {
            evt.consume();
        }
    }//GEN-LAST:event_salarioKeyTyped

    private void lb_funcionarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_funcionarioMouseReleased
        st = 1;
        p_persona.setVisible(false);
        p_funcionario.setVisible(true);
        lb_funcionario.setBackground(new Color(255, 255, 255));
        lb_funcionario.setForeground(new Color(102, 102, 102));
        /*el label secundario*/
        lb_persona.setBackground(new Color(64, 142, 186));
        lb_persona.setForeground(new Color(255, 255, 255));
        CargarFuncionario();
    }//GEN-LAST:event_lb_funcionarioMouseReleased

    private void nuevoParienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoParienteActionPerformed
        habilitarPariente();
        LimpiarParentesco();
        operacionParentesco = 1;
    }//GEN-LAST:event_nuevoParienteActionPerformed

    private void cancelarParienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarParienteActionPerformed
        deshabilitarPariente();
        LimpiarParentesco();
    }//GEN-LAST:event_cancelarParienteActionPerformed

    private void parientNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parientNombreKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            parientApellido.requestFocus();
        }

    }//GEN-LAST:event_parientNombreKeyTyped

    private void parientApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parientApellidoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            parientTelefono.requestFocus();
        }
    }//GEN-LAST:event_parientApellidoKeyTyped

    private void parientTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parientTelefonoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            parientFechaNac.getDateEditor().getUiComponent().requestFocus();
        }
    }//GEN-LAST:event_parientTelefonoKeyTyped

    private void parientParentescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parientParentescKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            grabarPariente.requestFocus();
        }
    }//GEN-LAST:event_parientParentescKeyTyped

    private void modificarParienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarParienteActionPerformed
        operacionParentesco = 2;
        habilitarPariente();
    }//GEN-LAST:event_modificarParienteActionPerformed

    private void eliminarParienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarParienteActionPerformed
        operacionParentesco = 3;
        int row = tbl_pariente.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(modal, "Debe de Seleccionar una Fila para poder eleiminar al Pariente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            int respuesta = JOptionPane.showConfirmDialog(modal, "Desea Eliminar a: " + tbl_pariente.getValueAt(row, 1) + "?", "Confirme...", JOptionPane.OK_CANCEL_OPTION);
            if (respuesta == 0) {
                abmParentesco();
                CargargrillaPariente(idpersona);
                LimpiarParentesco();
                deshabilitarPariente();
            }
        }
    }//GEN-LAST:event_eliminarParienteActionPerformed

    private void tbl_parienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_parienteMousePressed
        SeleccionarPariente();
    }//GEN-LAST:event_tbl_parienteMousePressed

    private void tbl_parienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_parienteKeyReleased
        SeleccionarPariente();
    }//GEN-LAST:event_tbl_parienteKeyReleased

    private void grabarParienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarParienteActionPerformed
        if (ValidarPariente()) {
            abmParentesco();
            CargargrillaPariente(idpersona);
            LimpiarParentesco();
            deshabilitarPariente();
        }
    }//GEN-LAST:event_grabarParienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        foco = 0;
        modal.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel13MousePressed

    private void jPanel13MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        modal.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel13MouseDragged

    private void reflabNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reflabNombreKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            reflaCargo.requestFocus();
        }
    }//GEN-LAST:event_reflabNombreKeyTyped

    private void reflaCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reflaCargoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            reflaTelefono.requestFocus();
        }
    }//GEN-LAST:event_reflaCargoKeyTyped

    private void reflaTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reflaTelefonoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            reflaNegocio.requestFocus();
        }
    }//GEN-LAST:event_reflaTelefonoKeyTyped

    private void tbl_ref_laboralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ref_laboralMousePressed
        SeleccionarReferencia();
    }//GEN-LAST:event_tbl_ref_laboralMousePressed

    private void tbl_ref_laboralKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_ref_laboralKeyReleased
        SeleccionarReferencia();
    }//GEN-LAST:event_tbl_ref_laboralKeyReleased

    private void nuevoreflabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoreflabActionPerformed
        habilitarreferencia();
        LimpiarReferencia();
        operacionReferencia = 1;
    }//GEN-LAST:event_nuevoreflabActionPerformed

    private void modificarreflabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarreflabActionPerformed
        operacionReferencia = 2;
        habilitarreferencia();
    }//GEN-LAST:event_modificarreflabActionPerformed

    private void eliminarreflabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarreflabActionPerformed
        operacionReferencia = 3;
        int row = tbl_ref_laboral.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(modal, "Debe de Seleccionar una Fila para poder eleiminar al Pariente", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            int respuesta = JOptionPane.showConfirmDialog(modal, "Desea Eliminar a: " + tbl_ref_laboral.getValueAt(row, 1) + "?", "Confirme...", JOptionPane.OK_CANCEL_OPTION);
            if (respuesta == 0) {
                abmRefrencia();
                CargargrillaReferencia(idpersona);
                LimpiarReferencia();
                deshabilitarreferencia();
            }
        }
    }//GEN-LAST:event_eliminarreflabActionPerformed

    private void grabarreflabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarreflabActionPerformed
        if (ValidarReferencia()) {
            abmRefrencia();
            CargargrillaReferencia(idpersona);
            LimpiarReferencia();
            deshabilitarreferencia();
        }
    }//GEN-LAST:event_grabarreflabActionPerformed

    private void cancelarreflabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarreflabActionPerformed
        deshabilitarreferencia();
        LimpiarReferencia();
    }//GEN-LAST:event_cancelarreflabActionPerformed

    private void reflaNegocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reflaNegocioKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            grabarreflab.requestFocus();
        }
    }//GEN-LAST:event_reflaNegocioKeyTyped

    private void tbl_ExperienciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ExperienciaMousePressed
        SeleccionarExperiencia();
    }//GEN-LAST:event_tbl_ExperienciaMousePressed

    private void tbl_ExperienciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_ExperienciaKeyReleased
        SeleccionarExperiencia();
    }//GEN-LAST:event_tbl_ExperienciaKeyReleased

    private void ExpeNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeNuevoActionPerformed
        operacionExperiencia = 1;
        habilitarExperiencia();
        LimpiarExperiencia();
    }//GEN-LAST:event_ExpeNuevoActionPerformed

    private void ExpeModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeModificarActionPerformed
        operacionExperiencia = 2;
        habilitarExperiencia();
    }//GEN-LAST:event_ExpeModificarActionPerformed

    private void ExpeEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeEliminarActionPerformed
        operacionExperiencia = 3;
        int row = tbl_Experiencia.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(modal, "Debe de Seleccionar una Fila para poder eliminar Experiencia", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            int respuesta = JOptionPane.showConfirmDialog(modal, "Desea Eliminar a: " + tbl_Experiencia.getValueAt(row, 1) + "?", "Confirme...", JOptionPane.OK_CANCEL_OPTION);
            if (respuesta == 0) {
                abmExperiencia();
                CargargrillaExperiencia(idpersona);
                LimpiarExperiencia();
                deshabilitarExperiencia();
            }
        }
    }//GEN-LAST:event_ExpeEliminarActionPerformed

    private void ExpeGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeGrabarActionPerformed
        if (ValidarExperiencia()) {
            abmExperiencia();
            CargargrillaExperiencia(idpersona);
            LimpiarExperiencia();
            deshabilitarExperiencia();
            operacionExperiencia = 0;
        }
    }//GEN-LAST:event_ExpeGrabarActionPerformed

    private void ExpeCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeCancelarActionPerformed
        deshabilitarExperiencia();
        LimpiarExperiencia();
        operacionExperiencia = 0;
    }//GEN-LAST:event_ExpeCancelarActionPerformed

    private void ExpeDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ExpeDescripcionKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            ExpeFDesde.getDateEditor().getUiComponent().requestFocus();
        }
    }//GEN-LAST:event_ExpeDescripcionKeyTyped

    private void expeEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expeEmpresaKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            ExpeCargo.requestFocus();
        }
    }//GEN-LAST:event_expeEmpresaKeyTyped

    private void ExpeCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ExpeCargoKeyTyped
        int letra = evt.getKeyChar();
        if (letra == 10) {
            ExpeDescripcion.requestFocus();
        }
    }//GEN-LAST:event_ExpeCargoKeyTyped

    private void tbl_Experiencia1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Experiencia1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_Experiencia1MousePressed

    private void tbl_Experiencia1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_Experiencia1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_Experiencia1KeyReleased

    private void btn_institutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_institutoActionPerformed
        buscador_instituto bp = new buscador_instituto(modal, true);
        bp.setVisible(true);
        idinstituto = bp.getCod();
        formInstituto.setText(bp.getDesrip());
        btn_titulo.requestFocus();
    }//GEN-LAST:event_btn_institutoActionPerformed

    private void btn_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tituloActionPerformed

    private void ExpeNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeNuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExpeNuevo1ActionPerformed

    private void ExpeModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeModificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExpeModificar1ActionPerformed

    private void ExpeEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExpeEliminar1ActionPerformed

    private void ExpeGrabar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeGrabar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExpeGrabar1ActionPerformed

    private void ExpeCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpeCancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExpeCancelar1ActionPerformed

    private void CargarGrillaPersona() {
        try {
            sql = "select p.id, concat(trim(p.apellido),', ', trim(p.nombre)) as apellidoNombre, p.cedula, p.telefono, p.celular, p.email, p.fecha_h_input, p.fecha_h_updat  from persona p "
                    + "where p.esfuncionario = false \n"
                    + "order by p.id";
         
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            db.CargarTabla(ps, tbl_persona, modelo, false);
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CargarFuncionario() {
        try {
            sql = "select f.id, concat(trim(p.apellido),', ', trim(p.nombre)) as apellidoNombre, p.cedula, p.telefono, p.celular, p.email, p.fecha_h_input, p.fecha_h_updat  from persona p "
                    + "join funcionario f on p.id = f.persona "
                    + "where p.esfuncionario = true \n"
                    + "order by p.id";
            
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            db.CargarTabla(ps, tbl_funcionario, modelo_funcionario, false);
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void TransFerirFoco() {
        db.transpasarFoco(fecha_vencimiento, fecha_nacimiento);
        db.transpasarFoco(fecha_nacimiento, sexo);
        db.transpasarFoco(fecha_ing_ips, fecha_contrato);
        db.transpasarFoco(fecha_contrato, fecha_fin_contrato);
        db.transpasarFoco(fecha_fin_contrato, fecha_meets);
        db.transpasarFoco(fecha_meets, tipo_Contrato);
        db.transpasarFoco(parientFechaNac, parientParentesc);
        db.transpasarFoco(ExpeFDesde, ExpeFHasta);
        db.transpasarFoco(ExpeFHasta, ExpeGrabar);
    }

    private void soloLetras() {
        db.Solo_Letras(nombre);
        db.Solo_Letras(apellido);
        db.Solo_Numeros(nroips);
        /*Datos Familiares*/
        db.Solo_Letras(parientNombre);
        db.Solo_Letras(parientApellido);
        /*Datos de Referencia Laboral*/
        db.Solo_Letras(reflabNombre);
        db.Solo_Letras(reflaCargo);
        /*Experiencia Laboral*/
        db.Solo_Letras(ExpeCargo);

    }

    private void limitarCaracter() {
        db.limitarCaracter(nombre, 250);
        db.limitarCaracter(apellido, 250);
        db.limitarCaracter(cedula, 50);
        db.limitarCaracter(telefono, 50);
        db.limitarCaracter(celular, 50);
        db.limitarCaracter(emails, 250);
        db.limitarCaracter(nro_cuenta, 50);
        db.limitarCaracter(resolucion, 50);
        /*Datos Familiares*/
        db.limitarCaracter(parientNombre, 250);
        db.limitarCaracter(parientApellido, 250);
        db.limitarCaracter(parientTelefono, 50);
        /*Datos de Referencia Laboral*/
        db.limitarCaracter(reflabNombre, 250);
        db.limitarCaracter(reflaCargo, 250);
        db.limitarCaracter(reflaTelefono, 50);
        db.limitarCaracter(reflaNegocio, 250);
        /*Experiencia Laboral*/
        db.limitarCaracter(expeEmpresa, 250);
        db.limitarCaracter(ExpeCargo, 250);
        db.limitarCaracter(ExpeDescripcion, 250);

    }

    private void CargarCombo() {
        sql = "select td.id, td.descripcion from tipo_documento td order by td.id	";
        db.CargarCombo(tipo_documento, sql, menu.getConexion());

        String idsexo[] = {"M", "F"};
        String descSexo[] = {"Másculino", "Femenino"};
        db.CargarCombo2(sexo, idsexo, descSexo);

        String idEstadCivi[] = {"S", "C", "V", "D"};
        String estaDescri[] = {"Soltero/a", "Casado/a", "Viudo/a", "Divorciado/a"};
        db.CargarCombo2(estado_civil, idEstadCivi, estaDescri);

        sql = "select s.id, s.descripcion from sucursal s\n"
                + "order by s.id";
        db.CargarCombo(sucursal, sql, menu.getConexion());

        sql = "select gs.id, gs.descripcion from grupo_sanguineo gs\n"
                + "order by gs.id";
        db.CargarCombo(grupo_sanguineo, sql, menu.getConexion());

        sql = "select tc.id, tc.descripcion from tipo_de_contrato tc order by tc.id";
        db.CargarCombo(tipo_Contrato, sql, menu.getConexion());

        sql = "select tc.id, tc.descripcion from tipo_empleado tc order by tc.id";
        db.CargarCombo(tipo_empleado, sql, menu.getConexion());

        sql = "select tc.id, tc.descripcion from forma_cobro tc order by tc.id";
        db.CargarCombo(forma_cobro, sql, menu.getConexion());

        sql = "select id, descripcion from moneda order by id";
        db.CargarCombo(moneda, sql, menu.getConexion());

        sql = "select id, descripcion from banco order by id";
        db.CargarCombo(banco, sql, menu.getConexion());

        sql = "select id, descripcion from parentesco  order by id";
        db.CargarCombo(parientParentesc, sql, menu.getConexion());
    }

    private Boolean ValidarPersona() {
        if (nombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Agregar un Nombre", "Error", JOptionPane.ERROR_MESSAGE);
            nombre.requestFocus();
            return false;
        }

        if (apellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Agregar un Apellido", "Error", JOptionPane.ERROR_MESSAGE);
            apellido.requestFocus();
            return false;
        }

        if (cedula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Agregar Nro de Cedula", "Error", JOptionPane.ERROR_MESSAGE);
            cedula.requestFocus();
            return false;
        }
        /*validamos los campos de fechas*/

        if (!((JTextField) fecha_vencimiento.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) fecha_vencimiento.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha de Vencimiento de Documento Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                fecha_vencimiento.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(modal, "No se puede dejar la fecha de Vencimiento de Cédula Vacío", "Error", JOptionPane.ERROR_MESSAGE);
            fecha_vencimiento.getDateEditor().getUiComponent().requestFocus();
            return false;
        }
        if (!((JTextField) fecha_nacimiento.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) fecha_nacimiento.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha de Nacimiento Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                fecha_nacimiento.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(modal, "No se puede dejar la Fecha de Nacimiento Vacío", "Error", JOptionPane.ERROR_MESSAGE);
            fecha_nacimiento.getDateEditor().getUiComponent().requestFocus();
            return false;
        }

        if (nacionalidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Nacionalidad", "Error", JOptionPane.ERROR_MESSAGE);
            btn_nacionalidad.requestFocus();
            return false;
        }
        if (profesion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Profesión", "Error", JOptionPane.ERROR_MESSAGE);
            btn_profesion.requestFocus();
            return false;
        }
        if (barrio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Barrio", "Error", JOptionPane.ERROR_MESSAGE);
            btn_barrio.requestFocus();
            return false;
        }

        if (telefono.getText().trim().isEmpty() && celular.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Teléfono o Celular del Contacto", "Error", JOptionPane.ERROR_MESSAGE);
            telefono.requestFocus();
            return false;
        }

        if (direccion_particular.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese una Dirección Particular", "Error", JOptionPane.ERROR_MESSAGE);
            direccion_particular.requestFocus();
            return false;
        }

        return true;
    }

    /*Metodo que Comprueba si la fecha esta bien*/
    private boolean comprueba(String fecha) {
        try {

            String par[] = fecha.split("/");

            int dayOfMonth = Integer.parseInt(par[0]);
            int month = Integer.parseInt(par[1]);
            int year = Integer.parseInt(par[2]);

            if (year < 1900) {
                throw new IllegalArgumentException("Año inválido.");
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1); // [0,...,11]
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            Date date = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            return true;
        } catch (IllegalArgumentException ex) {

            return false;
        }
    }

    private void GuardarPersona() {
        try {
            PreparedStatement ps;

            switch (operacion) {
                case 1:
                    sql = "INSERT INTO persona(\n"
                            + "	 nombre, apellido, cedula, tipo_documento, fecha_nac, sexo, estado_civil, nacionalidad, grupo_sanguineo,  direccion, barrio, telefono, celular, email,  usuario_input,  profesion, esfuncionario,fecha_venDoc)\n"
                            + "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n"
                            + "RETURNING id ";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setString(1, nombre.getText());
                    ps.setString(2, apellido.getText());
                    ps.setString(3, cedula.getText());
                    ps.setInt(4, tipo_documento.getItemAt(tipo_documento.getSelectedIndex()).getId());
                    ps.setDate(5, convertUtilToSql(fecha_nacimiento.getDate()));
                    ps.setString(6, sexo.getItemAt(sexo.getSelectedIndex()).getIdDescri());
                    ps.setString(7, estado_civil.getItemAt(estado_civil.getSelectedIndex()).getIdDescri());
                    ps.setInt(8, idnacionalidad);
                    ps.setInt(9, grupo_sanguineo.getItemAt(grupo_sanguineo.getSelectedIndex()).getId());
                    ps.setString(10, direccion_particular.getText());
                    ps.setInt(11, idbarrio);
                    ps.setString(12, telefono.getText());
                    ps.setString(13, celular.getText());
                    ps.setString(14, emails.getText());
                    ps.setInt(15, menu.getIduser());
                    ps.setInt(16, idprofesion);
                    ps.setBoolean(17, funcio.isSelected());
                    ps.setDate(18, (!((JTextField) fecha_vencimiento.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(fecha_vencimiento.getDate()) : null));
                    res = db.QueryDinamico(ps);
                    idpersona = Integer.parseInt(res[1]);

                    break;
                case 2:
                    sql = "UPDATE persona\n"
                            + "	SET  nombre=?, \n"
                            + "    apellido=?, \n"
                            + "    cedula=?, \n"
                            + "    tipo_documento=?, \n"
                            + "    fecha_nac=?, "
                            + "    sexo=?, \n"
                            + "    estado_civil=?, \n"
                            + "    nacionalidad=?, \n"
                            + "    grupo_sanguineo=?, \n"
                            + "    direccion=?, \n"
                            + "    barrio=?, \n"
                            + "    telefono=?, \n"
                            + "    celular=?, \n"
                            + "    email=?, \n"
                            + "    fecha_h_updat=?, \n"
                            + "    usuario_updat=?, \n"
                            + "    profesion=?, \n"
                            + "    esfuncionario=?, \n"
                            + "    fecha_vendoc=?\n"
                            + "WHERE id = ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setString(1, nombre.getText());
                    ps.setString(2, apellido.getText());
                    ps.setString(3, cedula.getText());
                    ps.setInt(4, tipo_documento.getItemAt(tipo_documento.getSelectedIndex()).getId());
                    ps.setDate(5, convertUtilToSql(fecha_nacimiento.getDate()));
                    ps.setString(6, sexo.getItemAt(sexo.getSelectedIndex()).getIdDescri());
                    ps.setString(7, estado_civil.getItemAt(estado_civil.getSelectedIndex()).getIdDescri());
                    ps.setInt(8, idnacionalidad);
                    ps.setInt(9, grupo_sanguineo.getItemAt(grupo_sanguineo.getSelectedIndex()).getId());
                    ps.setString(10, direccion_particular.getText());
                    ps.setInt(11, idbarrio);
                    ps.setString(12, telefono.getText());
                    ps.setString(13, celular.getText());
                    ps.setString(14, emails.getText());
                    ps.setDate(15, convertUtilToSql(new Date()));
                    ps.setInt(16, menu.getIduser());
                    ps.setInt(17, idprofesion);
                    ps.setBoolean(18, funcio.isSelected());
                    ps.setDate(19, (!((JTextField) fecha_vencimiento.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(fecha_vencimiento.getDate()) : null));
                    ps.setInt(20, idpersona);
                    db.Actualizar(ps, true);
                    break;
                case 3:
                    break;
            }

            CargarGrillaPersona();
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    private void InhabilitarTabs() {
        panel_padre.setEnabledAt(1, false);
        panel_padre.setEnabledAt(2, false);
        panel_padre.setEnabledAt(3, false);
        panel_padre.setEnabledAt(4, false);
    }

    private void habilitarTabs() {
        panel_padre.setEnabledAt(1, true);
        panel_padre.setEnabledAt(2, true);
        panel_padre.setEnabledAt(3, true);
        panel_padre.setEnabledAt(4, true);
    }

    private Boolean ValidarFuncionario() {
        if (cargo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Cargo", "Error", JOptionPane.ERROR_MESSAGE);
            btn_cargo.requestFocus();
            return false;
        }

        if (direccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Dirección", "Error", JOptionPane.ERROR_MESSAGE);
            btn_direccion.requestFocus();
            return false;
        }

        if (dpto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Departamento", "Error", JOptionPane.ERROR_MESSAGE);
            btn_dpto.requestFocus();
            return false;
        }

        if (sector.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Sector", "Error", JOptionPane.ERROR_MESSAGE);
            btn_sector.requestFocus();
            return false;
        }

        if (nroips.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Nº Seg. IPS", "Error", JOptionPane.ERROR_MESSAGE);
            nroips.requestFocus();
            return false;
        }

        if (!((JTextField) fecha_ing_ips.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) fecha_ing_ips.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha de Ingreso de IPS Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                fecha_ing_ips.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        }

        if (!((JTextField) fecha_contrato.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) fecha_contrato.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha de Contrato Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                fecha_contrato.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(modal, "No se puede dejar la Fecha de Contrato Vacío", "Error", JOptionPane.ERROR_MESSAGE);
            fecha_contrato.getDateEditor().getUiComponent().requestFocus();
            return false;
        }

        if (!((JTextField) fecha_fin_contrato.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) fecha_fin_contrato.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha de Ingreso de Fin de Contrato Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                fecha_fin_contrato.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        }
        if (!((JTextField) fecha_meets.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) fecha_meets.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha de Ingreso de MEETS Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                fecha_meets.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        }

        if (resolucion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Ingrese Nº de Resolución", "Error", JOptionPane.ERROR_MESSAGE);
            resolucion.requestFocus();
            return false;
        }

        if (nro_cuenta.getText().trim().isEmpty() && forma_cobro.getItemAt(forma_cobro.getSelectedIndex()).getId() == 2) {
            JOptionPane.showMessageDialog(modal, "Ingrese Nº de Cuenta", "Error", JOptionPane.ERROR_MESSAGE);
            nro_cuenta.requestFocus();
            return false;
        }

        if (salario.getText().trim().isEmpty() || Double.parseDouble(salario.getText().replace(".", "").replace(",", ".")) <= 0) {
            JOptionPane.showMessageDialog(modal, "Ingrese Salario", "Error", JOptionPane.ERROR_MESSAGE);
            salario.requestFocus();
            return false;
        }

        return true;
    }

    private void abmFuncionario() {
        try {
            PreparedStatement ps;

                    sql = "INSERT INTO funcionario(\n"
                            + "	 persona, cargo, sector, departamento, direccion, sede, nro_seg_ips, fecha_ingreso, fecha_de_contrato,"
                            + " fecha_ing_meets,"
                            + " tipo_de_contrato, tipo_empleado, nro_res, forma_cobro, cta_banco_nro,  "
                            + "usuario_input, banco, salario, moneda, fecha_fin_contrato)\n"
                            + "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idpersona);
                    ps.setInt(2, idcargo);
                    ps.setInt(3, idsector);
                    ps.setInt(4, iddepto);
                    ps.setInt(5, iddireccion);
                    ps.setInt(6, sucursal.getItemAt(sucursal.getSelectedIndex()).getId());
                    ps.setInt(7, Integer.parseInt(nroips.getText()));
                    ps.setDate(8, (!((JTextField) fecha_ing_ips.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(fecha_ing_ips.getDate()) : null));
                    ps.setDate(9, convertUtilToSql(fecha_contrato.getDate()));
                    ps.setDate(10, (!((JTextField) fecha_meets.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(fecha_meets.getDate()) : null));
                    ps.setInt(11, tipo_Contrato.getItemAt(tipo_Contrato.getSelectedIndex()).getId());
                    ps.setInt(12, tipo_empleado.getItemAt(tipo_empleado.getSelectedIndex()).getId());
                    ps.setString(13, resolucion.getText());
                    ps.setInt(14, forma_cobro.getItemAt(forma_cobro.getSelectedIndex()).getId());
                    ps.setString(15, nro_cuenta.getText());
                    ps.setInt(16, menu.getIduser());
                    ps.setInt(17, banco.getItemAt(banco.getSelectedIndex()).getId());
                    ps.setDouble(18, Double.parseDouble(salario.getText().replace(".", "").replace(",", ".")));
                    ps.setInt(19, moneda.getItemAt(moneda.getSelectedIndex()).getId());
                    ps.setDate(20, (!((JTextField) fecha_fin_contrato.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(fecha_fin_contrato.getDate()) : null));
                    ps.execute();

                 
            
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void select() {
        int row;
        switch (st) {
            case 0:
                row = tbl_persona.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una Fila para poder Modificar la Persona", "Atención", JOptionPane.WARNING_MESSAGE);
                } else {
                    idpersona = Integer.parseInt(tbl_persona.getValueAt(row, 0).toString());
                    traerPersona(idpersona);
                    habilitarTabs();
                    modal.setLocationRelativeTo(null);
                    modal.setVisible(true);
                }

                break;
            case 1:
                row = tbl_persona.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una Fila para poder Modificar la Persona", "Atención", JOptionPane.WARNING_MESSAGE);
                } else {
                    idfuncionario = Integer.parseInt(tbl_funcionario.getValueAt(row, 0).toString());
                }

                break;
        }
    }

    private void traerPersona(int id) {
        try {
            sql = "SELECT nombre, apellido, cedula, tipo_documento, fecha_nac, sexo, estado_civil,\n"
                    + "nacionalidad, pa.pronom_nacionalidad,\n"
                    + "grupo_sanguineo, direccion,\n"
                    + "barrio,b.descripcion, ciu.descripcion ,telefono, celular, email,\n"
                    + "profesion,prof.descripcion,fecha_venDoc, esfuncionario\n"
                    + "FROM persona p\n"
                    + "join pais pa on p.nacionalidad = pa.id\n"
                    + "join barrio b on b.id = p.barrio\n"
                    + "join ciudad ciu on ciu.id = b.ciudad\n"
                    + "join profesion prof on prof.id = p.profesion"
                    + " where p.id = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            res = db.QueryDinamico(ps);
            nombre.setText(res[1]);
            apellido.setText(res[2]);
            cedula.setText(res[3]);
            db.SelectIdCombo(tipo_documento, Integer.parseInt(res[4]));
            ((JTextField) fecha_nacimiento.getDateEditor()).setText(res[5]);
            db.SelectIdCombo(sexo, res[6]);
            db.SelectIdCombo(estado_civil, res[7]);
            idnacionalidad = Integer.parseInt(res[8]);
            nacionalidad.setText(res[9]);
            db.SelectIdCombo(grupo_sanguineo, Integer.parseInt(res[10]));
            direccion_particular.setText(res[11]);
            idbarrio = Integer.parseInt(res[12]);
            barrio.setText(res[13]);
            ciudad.setText(res[14]);
            telefono.setText(res[15]);
            celular.setText(res[16]);
            emails.setText(res[17]);
            idprofesion = Integer.parseInt(res[18]);
            profesion.setText(res[19]);
            ((JTextField) fecha_vencimiento.getDateEditor()).setText(res[20]);
            CargargrillaPariente(idpersona);
            CargargrillaReferencia(idpersona);
            CargargrillaExperiencia(idpersona);
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void habilitarPariente() {
        parientApellido.setEnabled(true);
        parientNombre.setEnabled(true);
        parientTelefono.setEnabled(true);
        parientFechaNac.setEnabled(true);
        parientParentesc.setEnabled(true);
        nuevoPariente.setEnabled(false);
        modificarPariente.setEnabled(false);
        eliminarPariente.setEnabled(false);
        grabarPariente.setEnabled(true);
        cancelarPariente.setEnabled(true);
        parientNombre.requestFocus();
    }

    private void deshabilitarPariente() {
        parientApellido.setEnabled(false);
        parientNombre.setEnabled(false);
        parientTelefono.setEnabled(false);
        parientFechaNac.setEnabled(false);
        parientParentesc.setEnabled(false);
        nuevoPariente.setEnabled(true);
        modificarPariente.setEnabled(true);
        eliminarPariente.setEnabled(true);
        grabarPariente.setEnabled(false);
        cancelarPariente.setEnabled(false);

    }

    private void LimpiarParentesco() {
        parientApellido.setText("");
        parientNombre.setText("");
        parientTelefono.setText("");
        parientFechaNac.setDate(null);
        parientParentesc.setSelectedIndex(0);
    }

    private void abmParentesco() {
        try {
            PreparedStatement ps;
            switch (operacionParentesco) {
                case 1:
                    sql = "INSERT INTO personafamilia(\n"
                            + "	persona, nombre, apellido, parentesco, telefono, fecha_nac,  usuario_input)\n"
                            + "	VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idpersona);
                    ps.setString(2, parientNombre.getText());
                    ps.setString(3, parientApellido.getText());
                    ps.setInt(4, parientParentesc.getItemAt(parientParentesc.getSelectedIndex()).getId());
                    ps.setString(5, parientTelefono.getText());
                    ps.setDate(6, (!((JTextField) parientFechaNac.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(parientFechaNac.getDate()) : null));
                    ps.setInt(7, menu.getIduser());
                    db.Insertar(ps, true);
                    break;
                case 2:
                    sql = "UPDATE personafamilia SET\n"
                            + "	 persona=?, \n"
                            + "     nombre=?, \n"
                            + "     apellido=?, \n"
                            + "     parentesco=?, \n"
                            + "     telefono=?, \n"
                            + "     fecha_nac=?,      \n"
                            + "     usuario_update=?, \n"
                            + "     fecha_h_update=? \n"
                            + "WHERE id = ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idpersona);
                    ps.setString(2, parientNombre.getText());
                    ps.setString(3, parientApellido.getText());
                    ps.setInt(4, parientParentesc.getItemAt(parientParentesc.getSelectedIndex()).getId());
                    ps.setString(5, parientTelefono.getText());
                    ps.setDate(6, (!((JTextField) parientFechaNac.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(parientFechaNac.getDate()) : null));
                    ps.setInt(7, menu.getIduser());
                    ps.setDate(8, convertUtilToSql(new Date()));
                    ps.setInt(9, idpariente);
                    db.Actualizar(ps, true);
                    break;
                case 3:
                    sql = "delete from personafamilia where id = ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idpariente);
                    db.eliminar(ps, true);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SeleccionarPariente() {
        try {
            if (tbl_pariente.getRowCount() > 0) {
                int row = tbl_pariente.getSelectedRow();

                idpariente = Integer.parseInt(tbl_pariente.getValueAt(row, 0).toString());
                sql = "SELECT nombre, apellido, parentesco, telefono, fecha_nac\n"
                        + "FROM personafamilia\n"
                        + "where id = ?";
                PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                ps.setInt(1, idpariente);
                res = db.QueryDinamico(ps);
                parientApellido.setText(res[2]);
                parientNombre.setText(res[1]);
                parientTelefono.setText(res[4]);
                ((JTextField) parientFechaNac.getDateEditor()).setText(res[5]);
                db.SelectIdCombo(parientParentesc, Integer.parseInt(res[3]));
            }
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CargargrillaPariente(int id) {
        try {
            sql = "select pf.id, trim(pf.apellido) || ', ' || trim(pf.nombre), par.descripcion, pf.telefono from personafamilia pf\n"
                    + "join parentesco par on pf.parentesco = par.id\n"
                    + "where pf.persona = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            db.CargarTabla(ps, tbl_pariente, modelo_Pariente, false);

        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Boolean ValidarPariente() {

        if (parientNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar Nombre del Pariente", "Error", JOptionPane.ERROR_MESSAGE);
            parientNombre.requestFocus();
            return false;
        }

        if (parientApellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar Apellido del Pariente", "Error", JOptionPane.ERROR_MESSAGE);
            parientApellido.requestFocus();
            return false;
        }
        /*validamos los campos de fechas*/

        if (!((JTextField) parientFechaNac.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) parientFechaNac.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha de Nacimiento Incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                parientFechaNac.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(modal, "No se puede dejar la fecha de Nacimiento Vacío", "Error", JOptionPane.ERROR_MESSAGE);
            parientFechaNac.getDateEditor().getUiComponent().requestFocus();
            return false;
        }

        return true;
    }

    /*Referencia Laboral*/
    private void habilitarreferencia() {
        reflabNombre.setEnabled(true);
        reflaCargo.setEnabled(true);
        reflaTelefono.setEnabled(true);
        reflaNegocio.setEnabled(true);

        nuevoreflab.setEnabled(false);
        modificarreflab.setEnabled(false);
        eliminarreflab.setEnabled(false);
        grabarreflab.setEnabled(true);
        cancelarreflab.setEnabled(true);
        reflabNombre.requestFocus();
    }

    private void LimpiarReferencia() {

        reflabNombre.setText("");
        reflaCargo.setText("");
        reflaTelefono.setText("");
        reflaNegocio.setText("");
    }

    private void deshabilitarreferencia() {
        reflabNombre.setEnabled(false);
        reflaCargo.setEnabled(false);
        reflaTelefono.setEnabled(false);
        reflaNegocio.setEnabled(false);

        nuevoreflab.setEnabled(true);
        modificarreflab.setEnabled(true);
        eliminarreflab.setEnabled(true);
        grabarreflab.setEnabled(false);
        cancelarreflab.setEnabled(false);
        reflabNombre.requestFocus();
    }

    private void abmRefrencia() {
        try {
            PreparedStatement ps;
            switch (operacionReferencia) {
                case 1:
                    sql = "INSERT INTO \"personaRefLaboral\"(\n"
                            + "	 persona, contacto, telefono, usuario_input,  empresa, cargo)\n"
                            + "	VALUES (?, ?, ?, ?, ?, ?)";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idpersona);
                    ps.setString(2, reflabNombre.getText());
                    ps.setString(3, reflaTelefono.getText());
                    ps.setInt(4, menu.getIduser());
                    ps.setString(5, reflaNegocio.getText());
                    ps.setString(6, reflaCargo.getText());
                    db.Insertar(ps, true);
                    break;
                case 2:
                    sql = "UPDATE \"personaRefLaboral\" set\n"
                            + "	 persona=?, \n"
                            + "     contacto=?, \n"
                            + "     telefono=?, \n"
                            + "     usuario_update=?, \n"
                            + "     fecha_h_update=?, \n"
                            + "     empresa=?, \n"
                            + "     cargo=?\n"
                            + "WHERE id = ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idpersona);
                    ps.setString(2, reflabNombre.getText());
                    ps.setString(3, reflaTelefono.getText());
                    ps.setInt(4, menu.getIduser());
                    ps.setDate(5, convertUtilToSql(new Date()));
                    ps.setString(6, reflaNegocio.getText());
                    ps.setString(7, reflaCargo.getText());
                    ps.setInt(8, idRefrencia);
                    db.Actualizar(ps, true);
                    break;
                case 3:
                    sql = "delete from \"personaRefLaboral\" where id = ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idRefrencia);
                    db.eliminar(ps, true);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SeleccionarReferencia() {
        try {
            if (tbl_ref_laboral.getRowCount() > 0) {
                int row = tbl_ref_laboral.getSelectedRow();

                idRefrencia = Integer.parseInt(tbl_ref_laboral.getValueAt(row, 0).toString());
                sql = "SELECT contacto, telefono,   empresa, cargo\n"
                        + "FROM \"personaRefLaboral\" \n"
                        + "where id = ?";
                PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                ps.setInt(1, idRefrencia);
                res = db.QueryDinamico(ps);
                reflabNombre.setText(res[1]);
                reflaTelefono.setText(res[2]);
                reflaNegocio.setText(res[3]);
                reflaCargo.setText(res[4]);

            }
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CargargrillaReferencia(int id) {
        try {
            sql = "SELECT id,  contacto,empresa, telefono\n"
                    + "	FROM \"personaRefLaboral\" rp\n"
                    + "    where rp.persona = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            db.CargarTabla(ps, tbl_ref_laboral, modelo_Referencia, false);

        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Boolean ValidarReferencia() {

        if (reflabNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar Nombre de la Referencia", "Error", JOptionPane.ERROR_MESSAGE);
            reflabNombre.requestFocus();
            return false;
        }

        if (reflaCargo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar Cargo de la Referencia", "Error", JOptionPane.ERROR_MESSAGE);
            reflaCargo.requestFocus();
            return false;
        }

        if (reflaTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar Telefono de la Referencia", "Error", JOptionPane.ERROR_MESSAGE);
            reflaTelefono.requestFocus();
            return false;
        }

        if (reflaNegocio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar Empresa de la Referencia", "Error", JOptionPane.ERROR_MESSAGE);
            reflaNegocio.requestFocus();
            return false;
        }

        return true;
    }

    /*Experiencia Laboral*/
    private void habilitarExperiencia() {
        expeEmpresa.setEnabled(true);
        ExpeCargo.setEnabled(true);
        ExpeDescripcion.setEnabled(true);
        ExpeFDesde.setEnabled(true);
        ExpeFHasta.setEnabled(true);

        ExpeNuevo.setEnabled(false);
        ExpeModificar.setEnabled(false);
        ExpeEliminar.setEnabled(false);
        ExpeGrabar.setEnabled(true);
        ExpeCancelar.setEnabled(true);
        expeEmpresa.requestFocus();
    }

    private void LimpiarExperiencia() {

        expeEmpresa.setText("");
        ExpeCargo.setText("");
        ExpeDescripcion.setText("");
        ExpeFDesde.setDate(null);
        ExpeFHasta.setDate(null);

    }

    private void deshabilitarExperiencia() {
        expeEmpresa.setEnabled(false);
        ExpeCargo.setEnabled(false);
        ExpeDescripcion.setEnabled(false);
        ExpeFDesde.setEnabled(false);
        ExpeFHasta.setEnabled(false);

        ExpeNuevo.setEnabled(true);
        ExpeModificar.setEnabled(true);
        ExpeEliminar.setEnabled(true);
        ExpeGrabar.setEnabled(false);
        ExpeCancelar.setEnabled(false);

    }

    private void abmExperiencia() {
        try {
            PreparedStatement ps;
            switch (operacionExperiencia) {
                case 1:
                    sql = "INSERT INTO personaexperiencia(\n"
                            + "	 empresa, cargo, descripcion, fecha_desde, fecha_hasta, persona, estado, usuario_input)\n"
                            + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setString(1, expeEmpresa.getText());
                    ps.setString(2, ExpeCargo.getText());
                    ps.setString(3, ExpeDescripcion.getText());
                    ps.setDate(4, (!((JTextField) ExpeFDesde.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(ExpeFDesde.getDate()) : null));
                    ps.setDate(5, (!((JTextField) ExpeFHasta.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(ExpeFHasta.getDate()) : null));
                    ps.setInt(6, idpersona);
                    ps.setInt(7, 1);
                    ps.setInt(8, menu.getIduser());

                    db.Insertar(ps, true);
                    break;
                case 2:
                    sql = "UPDATE personaexperiencia\n"
                            + "	SET  \n"
                            + "	empresa=?, \n"
                            + "	cargo=?, \n"
                            + "	descripcion=?, \n"
                            + "	fecha_desde=?, \n"
                            + "	fecha_hasta=?, \n"
                            + "	persona=?, \n"
                            + "	estado=?, \n"
                            + "	usuario_update=?, \n"
                            + "	fecha_h_update=?\n"
                            + "	WHERE id = ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setString(1, expeEmpresa.getText());
                    ps.setString(2, ExpeCargo.getText());
                    ps.setString(3, ExpeDescripcion.getText());
                    ps.setDate(4, (!((JTextField) ExpeFDesde.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(ExpeFDesde.getDate()) : null));
                    ps.setDate(5, (!((JTextField) ExpeFHasta.getDateEditor()).getText().equals("__/__/____") ? convertUtilToSql(ExpeFHasta.getDate()) : null));
                    ps.setInt(6, idpersona);
                    ps.setInt(7, 1);
                    ps.setInt(8, menu.getIduser());
                    ps.setDate(9, convertUtilToSql(new Date()));
                    ps.setInt(10, idExperiencia);
                    db.Actualizar(ps, true);
                    break;
                case 3:
                    sql = "delete from personaexperiencia where id = ?";
                    ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idExperiencia);
                    db.eliminar(ps, true);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CargargrillaExperiencia(int id) {
        try {
            sql = "SELECT id, empresa, cargo, descripcion, fecha_desde, fecha_hasta\n"
                    + "	FROM personaexperiencia\n"
                    + "	where persona = ?";
            PreparedStatement ps = menu.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            db.CargarTabla(ps, tbl_Experiencia, modelo_Experiencia, false);

        } catch (SQLException ex) {
            Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Boolean ValidarExperiencia() {

        if (expeEmpresa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar Nombre de la Empresa", "Error", JOptionPane.ERROR_MESSAGE);
            expeEmpresa.requestFocus();
            return false;
        }

        if (ExpeCargo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar Cargo que Obtuvo en la Empresa", "Error", JOptionPane.ERROR_MESSAGE);
            ExpeCargo.requestFocus();
            return false;
        }

        if (ExpeDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(modal, "Debe de Cargar la Descripción del Cargo que Tuvo en la Empresa", "Error", JOptionPane.ERROR_MESSAGE);
            ExpeDescripcion.requestFocus();
            return false;
        }
        /*validamos los campos de fechas*/

        if (!((JTextField) ExpeFDesde.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) ExpeFDesde.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha de Inicio Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                ExpeFDesde.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(modal, "No se puede dejar la fecha de Inicio Vacío", "Error", JOptionPane.ERROR_MESSAGE);
            ExpeFDesde.getDateEditor().getUiComponent().requestFocus();
            return false;
        }
        if (!((JTextField) ExpeFHasta.getDateEditor()).getText().equals("__/__/____")) {
            if (!comprueba(((JTextField) ExpeFHasta.getDateEditor()).getText())) {
                JOptionPane.showMessageDialog(modal, "Fecha Final Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                ExpeFHasta.getDateEditor().getUiComponent().requestFocus();
                return false;
            }
        }
        return true;
    }

    private void SeleccionarExperiencia() {
        if (operacionExperiencia == 0) {
            try {
                if (tbl_Experiencia.getRowCount() > 0) {
                    int row = tbl_Experiencia.getSelectedRow();

                    idExperiencia = Integer.parseInt(tbl_Experiencia.getValueAt(row, 0).toString());
                    sql = "SELECT empresa, cargo, descripcion, fecha_desde, fecha_hasta\n"
                            + "	FROM personaexperiencia\n"
                            + "	where id = ?";
                    PreparedStatement ps = menu.getConexion().prepareStatement(sql);
                    ps.setInt(1, idExperiencia);
                    res = db.QueryDinamico(ps);
                    expeEmpresa.setText(res[1]);
                    ExpeCargo.setText(res[2]);
                    ExpeDescripcion.setText(res[3]);
                    ((JTextField) ExpeFDesde.getDateEditor()).setText(res[4]);
                    ((JTextField) ExpeFHasta.getDateEditor()).setText(res[5]);
                }
            } catch (SQLException ex) {
                Logger.getLogger(reg_persona_funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExpeCancelar;
    private javax.swing.JButton ExpeCancelar1;
    private javax.swing.JTextField ExpeCargo;
    private javax.swing.JTextArea ExpeDescripcion;
    private javax.swing.JButton ExpeEliminar;
    private javax.swing.JButton ExpeEliminar1;
    private com.toedter.calendar.JDateChooser ExpeFDesde;
    private com.toedter.calendar.JDateChooser ExpeFHasta;
    private javax.swing.JButton ExpeGrabar;
    private javax.swing.JButton ExpeGrabar1;
    private javax.swing.JButton ExpeModificar;
    private javax.swing.JButton ExpeModificar1;
    private javax.swing.JButton ExpeNuevo;
    private javax.swing.JButton ExpeNuevo1;
    private javax.swing.JTextField apellido;
    private javax.swing.JComboBox<Tools> banco;
    private javax.swing.JTextField barrio;
    private javax.swing.JButton btn_aplicar;
    private javax.swing.JButton btn_barrio;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cargo;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_direccion;
    private javax.swing.JButton btn_dpto;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_instituto;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nacionalidad;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_profesion;
    private javax.swing.JButton btn_sector;
    private javax.swing.JButton btn_titulo;
    private javax.swing.JButton cancelarPariente;
    private javax.swing.JButton cancelarreflab;
    private javax.swing.JTextField cargo;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextArea direccion_particular;
    private javax.swing.JTextField dpto;
    private javax.swing.JButton eliminarPariente;
    private javax.swing.JButton eliminarreflab;
    private javax.swing.JTextField emails;
    private javax.swing.JComboBox<Tools> estado_civil;
    private javax.swing.JTextField expeEmpresa;
    private com.toedter.calendar.JDateChooser fecha_contrato;
    private com.toedter.calendar.JDateChooser fecha_fin_contrato;
    private com.toedter.calendar.JDateChooser fecha_ing_ips;
    private com.toedter.calendar.JDateChooser fecha_meets;
    private com.toedter.calendar.JDateChooser fecha_nacimiento;
    private com.toedter.calendar.JDateChooser fecha_vencimiento;
    private javax.swing.JTextField formInstituto;
    private javax.swing.JComboBox<Tools> forma_cobro;
    private javax.swing.JCheckBox funcio;
    private javax.swing.JButton grabarPariente;
    private javax.swing.JButton grabarreflab;
    private javax.swing.JComboBox<Tools> grupo_sanguineo;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lb_funcionario;
    private javax.swing.JLabel lb_persona;
    private javax.swing.JDialog modal;
    private javax.swing.JButton modificarPariente;
    private javax.swing.JButton modificarreflab;
    private javax.swing.JComboBox<Tools> moneda;
    private javax.swing.JTextField nacionalidad;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nro_cuenta;
    private javax.swing.JTextField nroips;
    private javax.swing.JButton nuevoPariente;
    private javax.swing.JButton nuevoreflab;
    private javax.swing.JPanel p_funcionario;
    private javax.swing.JPanel p_persona;
    private javax.swing.JPanel panel_funcionario;
    private javax.swing.JTabbedPane panel_padre;
    private javax.swing.JTextField parientApellido;
    private com.toedter.calendar.JDateChooser parientFechaNac;
    private javax.swing.JTextField parientNombre;
    private javax.swing.JComboBox<Tools> parientParentesc;
    private javax.swing.JTextField parientTelefono;
    private javax.swing.JTextField profesion;
    private javax.swing.JTextField reflaCargo;
    private javax.swing.JTextField reflaNegocio;
    private javax.swing.JTextField reflaTelefono;
    private javax.swing.JTextField reflabNombre;
    private javax.swing.JTextField resolucion;
    private javax.swing.JTextField salario;
    private javax.swing.JTextField sector;
    private javax.swing.JComboBox<Tools> sexo;
    private javax.swing.JComboBox<Tools> sucursal;
    private javax.swing.JTable tbl_Experiencia;
    private javax.swing.JTable tbl_Experiencia1;
    private javax.swing.JTable tbl_funcionario;
    private javax.swing.JTable tbl_pariente;
    private javax.swing.JTable tbl_persona;
    private javax.swing.JTable tbl_ref_laboral;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<Tools> tipo_Contrato;
    private javax.swing.JComboBox<Tools> tipo_documento;
    private javax.swing.JComboBox<Tools> tipo_empleado;
    // End of variables declaration//GEN-END:variables
}
