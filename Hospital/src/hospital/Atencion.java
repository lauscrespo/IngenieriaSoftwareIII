/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import Datos.DatAtencion;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laus
 */
public class Atencion extends javax.swing.JFrame {

    DatAtencion cAtencion;
    private int nEstado;
    private List<List<String>> rsform;

    public Atencion() {

        initComponents();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setTitle("ATENCION CONSULTA");

        cAtencion = new DatAtencion();

        nEstado = -1;
        this.txt_id.setEditable(false);
        this.btnnew.grabFocus();
        txthabilita(false);
        btnHabilita(true);
    }

    private void txthabilita(Boolean valor) {
        this.txt_diagno.setEditable(valor);
        this.txt_estud.setEditable(valor);
        this.txt_medic.setEditable(valor);
        this.txt_observaciones.setEditable(valor);
        this.jd_fecha.setEnabled(valor);
    }

    public void AbrirDB(String Navega) {

        cAtencion.setNavega(Navega);
        cAtencion.setProceso("QUERY_NAV");

        try {
            rsform = cAtencion.consultar("atencion_consulta_TRANSACT");
        } catch (SQLException ex) {
            Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void nuevo() {
        nEstado = 1;
        txthabilita(true);
        InitDatos();
        btnHabilita(false);
        this.txt_idCita.grabFocus();
    }

    public void cancelar() {

        nEstado = -1;
        this.InitDatos();
        this.txthabilita(false);
        this.btnHabilita(true);
        this.btnnew.requestFocus();
    }

    public void modificar() {
        if ((this.txt_id.getText() == "0")) {
            return;
        }

        if ((this.txt_id.getText() == "")) {
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
       // this.cargarclase();

        //' codigo para cargar los datos a la pantalla
        AbrirDB(Navega);

        this.cargaredit();

        this.txt_id.setEditable(false);

        nEstado = -3;
    }

    public void InitDatos() {

        this.txt_id.setText("0");
        txt_id.setEditable(false);
        this.txt_diagno.setText("");
        this.txt_medic.setText("");
        this.txt_estud.setText("");
        this.txt_idCita.setText("");
        this.txt_observaciones.setText("");
       this.jd_fecha.setDate(new Date());

    }

    public void grabar() throws SQLException, java.text.ParseException {

        cargarclase();

        if (nEstado == 1) {

            cAtencion.GrabarNew();
            this.txt_id.setText(cAtencion.getAtencion_id() + "");

        } else {
            if (nEstado == 2) {
                cAtencion.modificar();
            }
        }

        //'- reestablecemos los parametros
        nEstado = -3;
        btnHabilita(true);
        txthabilita(false);
        btnnew.setFocusable(true);
    }

    public void cargarclase() throws java.text.ParseException {
        try {

            cAtencion.setAtencion_id(Integer.parseInt(txt_id.getText()));
            cAtencion.setCita_id(Integer.parseInt(txt_idCita.getText()));
            cAtencion.setMedicamentos(txt_medic.getText());
            cAtencion.setObservaciones(txt_observaciones.getText());
            cAtencion.setDiagnostico(txt_diagno.getText());
            cAtencion.setEstudios(txt_estud.getText());
            java.sql.Date fecha = convertJavaDateToSqlDate(this.jd_fecha.getDate());
            cAtencion.setFecha_hora(fecha);

        } catch (ParseException ex) {
            Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public java.sql.Date convertJavaDateToSqlDate(Date fecha) throws java.text.ParseException {
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        return sqlDate;
    }

    public void cargaredit() {

        txt_id.setText(cAtencion.getAtencion_id()+ "");
        txt_idCita.setText(cAtencion.getCita_id()+"");
        txt_estud.setText(cAtencion.getEstudios().trim());
        txt_diagno.setText(cAtencion.getDiagnostico().trim());
        txt_medic.setText(cAtencion.getMedicamentos().trim());
        txt_observaciones.setText(cAtencion.getObservaciones().trim());
       
    }
    private void anular() throws SQLException {
        cAtencion.anular();
        InitDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_panle = new javax.swing.JPanel();
        jd_fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_estud = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_medic = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observaciones = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_diagno = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnnew = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnanu = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnini = new javax.swing.JButton();
        btnant = new javax.swing.JButton();
        btnsig = new javax.swing.JButton();
        btnfin = new javax.swing.JButton();
        txt_idCita = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_estud.setColumns(20);
        txt_estud.setRows(5);
        jScrollPane3.setViewportView(txt_estud);

        jLabel1.setText("Fecha:");

        jLabel5.setText("Medicamentos:");

        jLabel2.setText("Observaciones:");

        txt_medic.setColumns(20);
        txt_medic.setRows(5);
        jScrollPane4.setViewportView(txt_medic);

        txt_observaciones.setColumns(20);
        txt_observaciones.setRows(5);
        jScrollPane1.setViewportView(txt_observaciones);

        jLabel3.setText("Diagnostico:");

        jLabel7.setText("Cita:");

        txt_diagno.setColumns(20);
        txt_diagno.setRows(5);
        jScrollPane2.setViewportView(txt_diagno);

        jLabel4.setText("Estudios:");

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

        javax.swing.GroupLayout jp_panleLayout = new javax.swing.GroupLayout(jp_panle);
        jp_panle.setLayout(jp_panleLayout);
        jp_panleLayout.setHorizontalGroup(
            jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_panleLayout.createSequentialGroup()
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jp_panleLayout.createSequentialGroup()
                                .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnanu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jd_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(btnini)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnant)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnfin))
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp_panleLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel9))
                            .addGroup(jp_panleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_panleLayout.createSequentialGroup()
                                .addComponent(txt_idCita)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel8)
                                .addGap(87, 87, 87))
                            .addGroup(jp_panleLayout.createSequentialGroup()
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jp_panleLayout.setVerticalGroup(
            jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_panleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_idCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jd_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(25, 25, 25)
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_panleLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnanu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_panleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsig)
                    .addComponent(btnant)
                    .addComponent(btnini))
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
            .addComponent(jp_panle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinActionPerformed
        try {
            posconsul("BOTTON");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnfinActionPerformed

    private void btnsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsigActionPerformed
        try {
            posconsul("NEXT");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsigActionPerformed

    private void btnantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnantActionPerformed
        try {
            posconsul("BACK");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnantActionPerformed

    private void btniniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniActionPerformed
        try {
            posconsul("TOP");
        } catch (java.text.ParseException ex) {
            Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btniniActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnanuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanuActionPerformed
        try {
            anular();
        } catch (SQLException ex) {
            Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnanuActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        if ((nEstado == 1) || (nEstado == 2)) {
            cancelar();
        } else {
            modificar();
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        if ((nEstado == 1) || (nEstado == 2)) {
            try {
                grabar();
            } catch (SQLException ex) {
                Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.text.ParseException ex) {
                Logger.getLogger(Atencion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            nuevo();
        }
    }//GEN-LAST:event_btnnewActionPerformed

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
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atencion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnant;
    private javax.swing.JButton btnanu;
    private javax.swing.JButton btnfin;
    private javax.swing.JButton btnini;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnsig;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jd_fecha;
    private javax.swing.JPanel jp_panle;
    private javax.swing.JTextArea txt_diagno;
    private javax.swing.JTextArea txt_estud;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_idCita;
    private javax.swing.JTextArea txt_medic;
    private javax.swing.JTextArea txt_observaciones;
    // End of variables declaration//GEN-END:variables

    
}
