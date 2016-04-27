package CitaAtencion;

import Conexion.Conexion;
import DatosCitaAtencion.DatCita;
import Doctors.Doctores;
import static Main.Main.desktopFondo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
<<<<<<< HEAD
import javax.swing.table.DefaultTableModel;
=======
>>>>>>> cb2c3ac2169ead0943a7fa0cd70418d14611ee44
import org.apache.log4j.LogManager;

public class Cita extends javax.swing.JInternalFrame {

    DatCita cCita;
    private int nEstado;
    private List<List<String>> rsform;
    private Atencion atencion;
<<<<<<< HEAD
    private final Conexion conexion;
    private final Connection conection;
    private DefaultTableModel cita_Modelo;
    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();

=======
    private static final org.apache.log4j.Logger logger = LogManager.getRootLogger();
    
>>>>>>> cb2c3ac2169ead0943a7fa0cd70418d14611ee44
    public Cita() {
        initComponents();
        cCita = new DatCita();
        nEstado = -1;
        this.txt_id.setEditable(false);
        this.btnnew.grabFocus();
        txthabilita(false);
        conexion = new Conexion();
        conection = conexion.getConnection();
        btnHabilita(true);
        mostrardatos();
    }

    private void mostrardatos() {
        cita_Modelo = new DefaultTableModel();
        cita_Modelo.addColumn("ID");
        cita_Modelo.addColumn("FECHA");
        cita_Modelo.addColumn("DOCTOR_ID");
        cita_Modelo.addColumn("PACIENTE_ID");
        cita_Modelo.addColumn("OBSERVAC");
        cita_Modelo.addColumn("USER_ID");
        jt_datos.setModel(cita_Modelo);
        String[] datos = new String[6];
        try {
            ResultSet rs = conexion.obtenerConsulta("select *from cita order by fecha_hora desc;");
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                cita_Modelo.addRow(datos);
            }
            jt_datos.setModel(cita_Modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Doctores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txthabilita(Boolean valor) {
        this.txt_idDoctor.setEditable(valor);
        this.txt_paciente.setEditable(valor);
        this.txt_usuario.setEditable(valor);
        this.txt_observaciones.setEditable(valor);
       this.jd_fecha.setEnabled(valor);
    }

    public void AbrirDB(String Navega) {
        cCita.setNavega(Navega);
        cCita.setProceso("QUERY_NAV");
        try {
            rsform = cCita.consultar("cita_TRANSACT");
        } catch (SQLException ex) {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
            logger.debug("AbrirBD Error");
        }
    }

    public void nuevo() {
        nEstado = 1;
        txthabilita(true);
        InitDatos();
        btnHabilita(false);
        this.txt_idDoctor.grabFocus();
    }

    public void cancelar() {
        nEstado = -1;
        this.InitDatos();
        this.txthabilita(false);
        this.btnHabilita(true);
        this.btnnew.requestFocus();
    }

    public void modificar() {
        if (("0".equals(this.txt_id.getText()))) {
            return;
        }

        if (("".equals(this.txt_id.getText()))) {
            return;
        }

        if (nEstado != -3) {
            JOptionPane.showMessageDialog(null,
                    "Operación debe ser precedida por una busqueda", "", JOptionPane.OK_OPTION);

        } else {
            nEstado = 2;
            nEstado = 2;
            txthabilita(true);
            btnHabilita(false);
        }
    }

    public void btnHabilita(Boolean bAccion) {
        if (bAccion == false) {
            this.btnnew.setEnabled(true);
            this.btnModify.setEnabled(true);
            this.btnanu.setEnabled(false);
            //btn Nav        
            this.btnfin.setEnabled(false);
            this.btnini.setEnabled(false);
            this.btnant.setEnabled(false);
            this.btnsig.setEnabled(false);

            this.btnnew.setText("Grabar");
            this.btnModify.setText("Cancelar");

        } else {

            this.btnnew.setEnabled(true);
            this.btnModify.setEnabled(true);
            this.btnanu.setEnabled(true);
            //btn Nav
            this.btnfin.setEnabled(true);
            this.btnini.setEnabled(true);
            this.btnant.setEnabled(true);
            this.btnsig.setEnabled(true);

            this.btnnew.setText("Nuevo");
            this.btnModify.setText("Modificar");

        }

    }

    public void preconsul() {
        nEstado = -3;
        this.txt_id.setText("");
        this.txt_id.setEditable(true);
        this.txt_id.grabFocus();

        btnHabilita(true);
    }

    public void posconsul(String Navega) throws java.text.ParseException {

        this.InitDatos();
        
        AbrirDB(Navega);

        this.cargaredit();

        this.txt_id.setEditable(false);

        nEstado = -3;
    }

    public void InitDatos() {

        this.txt_id.setText("0");
        txt_id.setEditable(false);
        this.txt_paciente.setText("");
        this.txt_usuario.setText("");
        this.txt_idDoctor.setText("");
        this.txt_observaciones.setText("");
        this.jd_fecha.setDate(new Date());

    }

    public void grabar() throws SQLException, java.text.ParseException {

        cargarclase();

        if (nEstado == 1) {

            cCita.GrabarNew();
            this.txt_id.setText(cCita.getCita_id() + "");

        } else if (nEstado == 2) {
            cCita.modificar();
        }

        //'- reestablecemos los parametros
        nEstado = -3;
        btnHabilita(true);
        txthabilita(false);
        btnnew.setFocusable(true);
        logger.debug("Grabar nueva cita");
    }

    public void cargarclase() throws java.text.ParseException {
        try {

            cCita.setCita_id(Integer.parseInt(txt_id.getText()));
            cCita.setDoctor_id(Integer.parseInt(txt_idDoctor.getText()));
            cCita.setPaciente_id(Integer.parseInt(txt_paciente.getText()));
            cCita.setObservaciones(txt_observaciones.getText());
            cCita.setUser_id(Integer.parseInt(txt_usuario.getText()));
            java.sql.Date fecha = convertJavaDateToSqlDate(this.jd_fecha.getDate());
            cCita.setFecha_hora(fecha);
            logger.debug("cargo clase");

        } catch (ParseException ex) {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public java.sql.Date convertJavaDateToSqlDate(Date fecha) throws java.text.ParseException {
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        return sqlDate;
    }

    public void cargaredit() {

        txt_id.setText(cCita.getCita_id() + "");
        txt_idDoctor.setText(cCita.getDoctor_id() + "");
        txt_paciente.setText(cCita.getPaciente_id() + "");
        txt_usuario.setText(cCita.getUser_id() + "");
        txt_observaciones.setText(cCita.getObservaciones().trim());
<<<<<<< HEAD
        jd_fecha.setDate(cCita.getFecha_hora());
=======
>>>>>>> cb2c3ac2169ead0943a7fa0cd70418d14611ee44
        logger.debug("cargo edit");

    }

    private void anular() throws SQLException {
        cCita.anular();
        InitDatos();
        logger.debug("se eliminara datos");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_panle = new javax.swing.JPanel();
        jd_fecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observaciones = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnnew = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnanu = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnini = new javax.swing.JButton();
        btnant = new javax.swing.JButton();
        btnsig = new javax.swing.JButton();
        btnfin = new javax.swing.JButton();
        txt_idDoctor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_paciente = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        btn_atender = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_datos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Citas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cita.png"))); // NOI18N

        jp_panle.setBackground(new java.awt.Color(204, 255, 255));
        jp_panle.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jp_panle.setToolTipText("");

        jLabel1.setText("Fecha:");

        jLabel2.setText("Observaciones:");

        txt_observaciones.setColumns(20);
        txt_observaciones.setRows(5);
        jScrollPane1.setViewportView(txt_observaciones);

        jLabel7.setText("Doctor:");

        btnnew.setText("Nuevo");
        btnnew.setPreferredSize(new java.awt.Dimension(69, 23));
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });

        btnModify.setText("Modificar");
        btnModify.setPreferredSize(new java.awt.Dimension(69, 23));
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnanu.setText("Eliminar");
        btnanu.setPreferredSize(new java.awt.Dimension(69, 23));
        btnanu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanuActionPerformed(evt);
            }
        });

        jButton6.setForeground(new java.awt.Color(255, 0, 0));
        jButton6.setText("Salir");
        jButton6.setMaximumSize(new java.awt.Dimension(69, 23));
        jButton6.setMinimumSize(new java.awt.Dimension(69, 23));
        jButton6.setPreferredSize(new java.awt.Dimension(69, 23));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnini.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btnini.setText("|<");
        btnini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniActionPerformed(evt);
            }
        });

        btnant.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btnant.setText("<");
        btnant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnantActionPerformed(evt);
            }
        });

        btnsig.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btnsig.setText(">");
        btnsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsigActionPerformed(evt);
            }
        });

        btnfin.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btnfin.setText(">|");
        btnfin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinActionPerformed(evt);
            }
        });

        jLabel9.setText("ID:");

        jLabel6.setText("Paciente:");

        jLabel10.setText("Usuario:");

        btn_atender.setForeground(new java.awt.Color(0, 51, 255));
        btn_atender.setText("Atender");
        btn_atender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atenderActionPerformed(evt);
            }
        });

        jt_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jt_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_datosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jt_datos);

        javax.swing.GroupLayout jp_panleLayout = new javax.swing.GroupLayout(jp_panle);
        jp_panle.setLayout(jp_panleLayout);
        jp_panleLayout.setHorizontalGroup(
            jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_panleLayout.createSequentialGroup()
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_idDoctor)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_panleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_atender)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_panleLayout.createSequentialGroup()
                                        .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnanu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jp_panleLayout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(btnini)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnant)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnsig)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnfin))))
                            .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jp_panleLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel2)
                                    .addGap(12, 12, 12)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jp_panleLayout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_paciente, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                            .addComponent(txt_usuario))
                                        .addComponent(jd_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_panleLayout.setVerticalGroup(
            jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_panleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_idDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jd_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnanu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_atender))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnfin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsig)
                            .addComponent(btnant)
                            .addComponent(btnini)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_panle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_panle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        if ((nEstado == 1) || (nEstado == 2)) {
            try {
                grabar();
            } catch (SQLException | java.text.ParseException ex) {
                Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            nuevo();
        }
    }//GEN-LAST:event_btnnewActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        if ((nEstado == 1) || (nEstado == 2)) {
            cancelar();
        } else {
            modificar();
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnanuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanuActionPerformed
        try {
            anular();
        } catch (SQLException ex) {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnanuActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btniniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniActionPerformed
        try {
            posconsul("TOP");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btniniActionPerformed

    private void btnantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnantActionPerformed
        try {
            posconsul("BACK");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnantActionPerformed

    private void btnsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsigActionPerformed
        try {
            posconsul("NEXT");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsigActionPerformed

    private void btnfinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinActionPerformed
        try {
            posconsul("BOTTON");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Cita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnfinActionPerformed

    private void btn_atenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atenderActionPerformed
<<<<<<< HEAD

=======
        
        
>>>>>>> cb2c3ac2169ead0943a7fa0cd70418d14611ee44
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (!txt_id.getText().equals("") && !txt_id.getText().equals("0")) {
                    desktopFondo.removeAll();
                    desktopFondo.repaint();
                    atencion = new Atencion(cCita.getCita_id());
                    desktopFondo.add(atencion);
                    atencion.show();
                    logger.debug(cCita.getCita_id());
                } else {
                    JOptionPane.showMessageDialog(Cita.this, "Eliga una consulta");
                    logger.error("Eliga una consulta");
                }
            }
        });

    }//GEN-LAST:event_btn_atenderActionPerformed

    private void jt_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_datosMouseClicked
         int row = jt_datos.rowAtPoint(evt.getPoint());

        this.InitDatos();

        AbrirDB(jt_datos.getValueAt(row, 0).toString());

        this.cargaredit();

        this.txt_id.setEditable(false);

        nEstado = -3;
    }//GEN-LAST:event_jt_datosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btn_atender;
    private javax.swing.JButton btnant;
    private javax.swing.JButton btnanu;
    private javax.swing.JButton btnfin;
    private javax.swing.JButton btnini;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnsig;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jd_fecha;
    private javax.swing.JPanel jp_panle;
    private javax.swing.JTable jt_datos;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_idDoctor;
    private javax.swing.JTextArea txt_observaciones;
    private javax.swing.JTextField txt_paciente;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
