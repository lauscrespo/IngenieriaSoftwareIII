package Pacientes;

import Conexion.Conexion;
import Main.Main;
import static Main.Main.desktopFondo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class EditarPacientes extends javax.swing.JInternalFrame {

    private final Conexion conexion;
    private final Connection conection;

    public EditarPacientes(String id) {
        initComponents();
        conexion = new Conexion();
        conection = conexion.getConnection();
        lbIdPaciente.setText(id);
        mostrarPaciente(id);
        lbIdPaciente.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnEdit = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        rbtnM = new javax.swing.JRadioButton();
        rbtmF = new javax.swing.JRadioButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbIdPaciente = new javax.swing.JLabel();

        setClosable(true);
        setTitle("EDITAR DATOS PACIENTES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paciente.png"))); // NOI18N

        pnEdit.setBackground(new java.awt.Color(204, 255, 255));
        pnEdit.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("EDITAR");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("NOMBRES:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("APELLIDOS:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("EDAD:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("SEXO:");

        buttonGroup1.add(rbtnM);
        rbtnM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtnM.setForeground(new java.awt.Color(102, 102, 102));
        rbtnM.setText("MASCULINO");

        buttonGroup1.add(rbtmF);
        rbtmF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbtmF.setForeground(new java.awt.Color(102, 102, 102));
        rbtmF.setText("FEMENINO");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(102, 102, 102));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registrar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(102, 102, 102));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnEditLayout = new javax.swing.GroupLayout(pnEdit);
        pnEdit.setLayout(pnEditLayout);
        pnEditLayout.setHorizontalGroup(
            pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEditLayout.createSequentialGroup()
                        .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnEditLayout.createSequentialGroup()
                                    .addGap(170, 170, 170)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnEditLayout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEdad))
                                .addGroup(pnEditLayout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbtnM)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbtmF)))
                            .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnEditLayout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtApellidos))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnEditLayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnEditLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        pnEditLayout.setVerticalGroup(
            pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIdPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbtnM)
                    .addComponent(rbtmF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(pnEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (!txtNombres.getText().isEmpty() || !txtApellidos.getText().isEmpty() || !txtEdad.getText().isEmpty() || rbtmF.isSelected() || rbtnM.isSelected()) {
            try {
                PreparedStatement ps = conection.prepareStatement("EXEC spUpdatePacientes  ?,?,?,?,?");
                ps.setString(1, lbIdPaciente.getText());
                ps.setString(2, txtNombres.getText());
                ps.setString(3, txtApellidos.getText());
                ps.setString(4, txtEdad.getText());
                String sexo = "";
                if (rbtmF.isSelected()) {
                    sexo = "Femenino";
                } else {
                    sexo = "Masculino";
                }
                ps.setString(5, sexo);
                ps.executeUpdate();
                ps.getMoreResults();
                JOptionPane.showMessageDialog(this, "Paciente Editado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                desktopFondo.removeAll();
                desktopFondo.repaint();
                Pacientes paciente = new Pacientes();
                desktopFondo.add(paciente);
                paciente.toFront();
                paciente.setVisible(true);
                this.dispose();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Error Al Editar");
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos correctamente", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        Pacientes paciente = new Pacientes();
        Main.desktopFondo.add(paciente);
        paciente.toFront();
        paciente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbIdPaciente;
    private javax.swing.JPanel pnEdit;
    private javax.swing.JRadioButton rbtmF;
    private javax.swing.JRadioButton rbtnM;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

    public void mostrarPaciente(String id) {
        try {
            ResultSet rs = conexion.obtenerConsulta("select * from fnPacientesSelectById(" + id + ");");
            while (rs.next()) {
                txtNombres.setText(rs.getString(2));
                txtApellidos.setText(rs.getString(3));
                txtEdad.setText(rs.getString(4));
                if (rs.getString(5).equals("Masculino")) {
                    rbtnM.setSelected(true);
                } else {
                    rbtmF.setSelected(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
