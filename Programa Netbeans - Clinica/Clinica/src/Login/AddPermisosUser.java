package Login;

import Conexion.Conexion;
import static Main.Main.desktopFondo;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public final class AddPermisosUser extends javax.swing.JInternalFrame {

    Conexion cc;
    Connection cn;
    FrameUsuarios users;

    public AddPermisosUser() {
        initComponents();
        cc = new Conexion();
        cn = cc.getConnection();
        
        llenarRol();
        llenarUser();
        this.setLocation(350, 50);
        PanelFondo2 F = new PanelFondo2();
        this.add(F, BorderLayout.CENTER);

        txtUser.setVisible(false);
        txtRol.setVisible(false);
        llenarPer();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbUser = new javax.swing.JComboBox();
        cbRoles = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();
        cbPermiso = new javax.swing.JComboBox();
        lbExit = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setIconifiable(true);
        setTitle("Permisos A Usuarios");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ID PERMISO:");

        cbUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUserActionPerformed(evt);
            }
        });

        cbRoles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRolesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("USUARIO:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("ROLES:");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cbPermiso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPermisoActionPerformed(evt);
            }
        });

        lbExit.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbExit.setText("Atras");
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbExit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(cbPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbUser, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(txtUser))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbRoles, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(txtRol)))
                    .addComponent(jLabel3))
                .addGap(66, 66, 66)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        int a = Integer.parseInt(txtRol.getText());
        System.out.println(a);

        try {
            PreparedStatement psql = cn.prepareStatement("insert into tbl_seg_permissionsuserroles (PermissionId, OwnerId, OwnerType) values ('"
                    + cbPermiso.getSelectedItem().toString() + "','" + txtUser.getText() + "'," + a + ");"
            );
            psql.executeUpdate();
            psql.getMoreResults();
            JOptionPane.showMessageDialog(this, "Permiso/User/Rol Insertado");
        } catch (SQLException e) {
            System.out.println(e);
        }

        desktopFondo.removeAll();
        desktopFondo.repaint();
        users = new FrameUsuarios();
        desktopFondo.add(users);
        users.toFront();
        users.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUserActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "select userid from tbl_seg_user where username= '" + cbUser.getSelectedItem().toString() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                txtUser.setText(String.valueOf(rs.getInt("userid")));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbUserActionPerformed

    private void cbRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRolesActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "select rolid from tbl_roles where rol= '" + cbRoles.getSelectedItem().toString() + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                txtRol.setText(String.valueOf(rs.getInt("rolid")));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbRolesActionPerformed

    private void cbPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPermisoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbPermisoActionPerformed

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        users = new FrameUsuarios();
        users.mostrardatos("");
        desktopFondo.add(users);
        users.toFront();
        users.setVisible(true);
        this.hide();
    }//GEN-LAST:event_lbExitMouseClicked

    public void llenarRol() {
        this.cbRoles.removeAllItems();
        String sql = "select * from tbl_roles";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                this.cbRoles.addItem(rs.getString("rol"));
            }
        } catch (Exception e) {
        }

    }

    public void llenarUser() {
        this.cbUser.removeAllItems();
        String sql = "select * from tbl_seg_user";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                this.cbUser.addItem(rs.getString("username"));
            }
        } catch (Exception e) {
        }
    }

    public void llenarPer() {
        this.cbPermiso.removeAllItems();
        String sql = "select * from tbl_seg_permissions";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                this.cbPermiso.addItem(rs.getString("permissionid"));
            }
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbPermiso;
    private javax.swing.JComboBox cbRoles;
    private javax.swing.JComboBox cbUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbExit;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
