package Login;

import static Main.Main.desktopFondo;
import conexion.pool;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddRol extends javax.swing.JInternalFrame {

    FrameRol rol;
    int tipoUsuario;

    public AddRol(int tipo) {
        initComponents();
        this.setLocation(350, 50);
        PanelFondo2 F = new PanelFondo2();
        this.add(F, BorderLayout.CENTER);
        tipoUsuario = tipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRolId = new javax.swing.JTextField();
        txtRolNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lbExit = new javax.swing.JLabel();

        setIconifiable(true);
        setTitle("AÑADIR ROLES");

        jLabel1.setFont(new java.awt.Font("Cooper Black", 3, 36)); // NOI18N
        jLabel1.setText("ROLES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Rol ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Nombre:");

        txtRolId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRolIdActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lbExit.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbExit.setText("Atras");
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbExit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRolId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRolNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRolId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRolNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(52, 52, 52)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        pool cc = new pool();
        Connection cn = null;

        try {
            cn = cc.datasource.getConnection();
            PreparedStatement psql = cn.prepareStatement("INSERT INTO tbl_roles(RolId,Rol) VALUES('"
                    + txtRolId.getText() + "','" + txtRolNombre.getText() + "');"
            );
            psql.executeUpdate();
            JOptionPane.showMessageDialog(this, "ROL INSERTADO");
        } catch (SQLException e) {
            System.out.println(e);
        }

        desktopFondo.removeAll();
        desktopFondo.repaint();
        rol = new FrameRol(tipoUsuario);
        desktopFondo.add(rol);
        rol.toFront();
        rol.setVisible(true);
        this.hide();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        rol = new FrameRol(tipoUsuario);
        desktopFondo.add(rol);
        rol.toFront();
        rol.setVisible(true);
        this.hide();
    }//GEN-LAST:event_lbExitMouseClicked

    private void txtRolIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRolIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRolIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbExit;
    private javax.swing.JTextField txtRolId;
    private javax.swing.JTextField txtRolNombre;
    // End of variables declaration//GEN-END:variables
}
