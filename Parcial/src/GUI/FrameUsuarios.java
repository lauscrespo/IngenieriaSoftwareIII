package GUI;

import conexion.pool;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FrameUsuarios extends javax.swing.JInternalFrame {

    DatosUser datUser;
    Opciones opciones;
    pool cc = new pool();
    Connection cn = null;
    AddPermisosUser per;
    int a;

    public FrameUsuarios() {
        initComponents();
        this.setLocation(100, 0);
        PanelFondo2 F = new PanelFondo2();
        this.add(F, BorderLayout.CENTER);
        mostrardatos("");

        this.pack();
    }

    public void mostrardatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("User ID");
        modelo.addColumn("Person ID");
        modelo.addColumn("User Name");
        modelo.addColumn("E-mail");
        modelo.addColumn("Rol");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Estado");

        tblTablaDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
//              sql = "SELECT u.UserId,u.PersonId,u.UserName,u.Email,r.Rol,per.Description, u.estado \n"
//                    + "                    FROM tbl_seg_user u,tbl_roles r, tbl_seg_permissionsuserroles p,tbl_seg_permissions per where u.RolId = r.RolId and u.UserId = p.OwnerId \n"
//                    + "			and r.RolId = p.OwnerType  and p.PermissionId = per.PermissionId;";
              
            sql = "SELECT u.UserId,u.PersonId,u.UserName,u.Email,r.Rol,per.Description, u.estado \n"
                    + "                    FROM tbl_seg_user u,tbl_roles r, tbl_seg_permissionsuserroles p,tbl_seg_permissions per where u.RolId = r.RolId and u.UserId = p.OwnerId \n"
                    + "			and r.RolId = p.OwnerType and p.PermissionId = per.PermissionId;";
 //           sql = "select * from tbl_seg_user;";
        } else {
          
        }
        String[] datos = new String[7];
        try {
            cn = cc.datasource.getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                modelo.addRow(datos);
            }
            tblTablaDatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(FrameUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaDatos = new javax.swing.JTable();
        pnBotones = new javax.swing.JPanel();
        btnVerUser = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnPer = new javax.swing.JButton();
        lbExit = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setIconifiable(true);
        setTitle("DATOS USUARIOS");

        tblTablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTablaDatos);

        pnBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 13))); // NOI18N

        btnVerUser.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        btnVerUser.setText("VER DATOS DE USUARIO");
        btnVerUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerUserActionPerformed(evt);
            }
        });

        btEliminar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btEliminar.setText("ELIMINAR");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnNew.setText("INSERTAR NUEVO USUARIO");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnPer.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnPer.setText("PERMISOS");
        btnPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerActionPerformed(evt);
            }
        });

        lbExit.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbExit.setText("Atras");
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jButton1.setText("BLOQUEAR/DESBLOQUEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotonesLayout = new javax.swing.GroupLayout(pnBotones);
        pnBotones.setLayout(pnBotonesLayout);
        pnBotonesLayout.setHorizontalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                .addComponent(lbExit)
                .addContainerGap())
        );
        pnBotonesLayout.setVerticalGroup(
            pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotonesLayout.createSequentialGroup()
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBotonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVerUser)
                            .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(pnBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPer)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(pnBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerUserActionPerformed
        // TODO add your handling code here:
        DatosUser us = new DatosUser();

        int fila = tblTablaDatos.getSelectedRow();
        if (fila >= 0) {
            us.llenar(tblTablaDatos.getValueAt(fila, 0).toString(), tblTablaDatos.getValueAt(fila, 1).toString(), tblTablaDatos.getValueAt(fila, 2).toString(),
                    tblTablaDatos.getValueAt(fila, 3).toString(),
                    tblTablaDatos.getValueAt(fila, 4).toString(), tblTablaDatos.getValueAt(fila, 5).toString(), tblTablaDatos.getValueAt(fila, 6).toString());
            Main.escritorio.add(us);
            us.toFront();
            us.setVisible(true);
            mostrardatos("");
            this.hide();
        } else {
            JOptionPane.showMessageDialog(null, "NO SELECCION NINGUN USUARIO");
            mostrardatos("");
        }


    }//GEN-LAST:event_btnVerUserActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed

        int fila = tblTablaDatos.getSelectedRow();
        if (fila >= 0) {
            try {
                cn = cc.datasource.getConnection();
                PreparedStatement psql = cn.prepareStatement("delete from tbl_seg_user where userid = '" + tblTablaDatos.getValueAt(fila, 0).toString() + "'");
                psql.executeUpdate();
                mostrardatos("");

            } catch (SQLException e) {
                System.out.print(e);
            }
            mostrardatos("");
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UNA FILA");
        }
        mostrardatos("");

    }//GEN-LAST:event_btEliminarActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        AddUser add = new AddUser();
        Main.escritorio.add(add);
        add.toFront();
        add.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerActionPerformed
        // TODO add your handling code here:
        per = new AddPermisosUser();
        Main.escritorio.add(per);
        per.toFront();
        per.setVisible(true);
        this.hide();

    }//GEN-LAST:event_btnPerActionPerformed

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        // TODO add your handling code here:
        opciones = new Opciones();
        Main.escritorio.add(opciones);
        opciones.toFront();
        opciones.setVisible(true);
        this.hide();
        this.dispose();
    }//GEN-LAST:event_lbExitMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pool cc = new pool();
        Connection cn = null;
        if (a == 0) {
            a = 1;
        } else {
            a = 0;
        }
        int fila = tblTablaDatos.getSelectedRow();
        if (fila >= 0) {

            try {
                cn = cc.datasource.getConnection();
                PreparedStatement psql = cn.prepareStatement("UPDATE  tbl_seg_user set estado='" + a + "' where userid='" + tblTablaDatos.getValueAt(fila, 0).toString() + "'");

                psql.executeUpdate();
                mostrardatos("");
            } catch (SQLException e) {
                System.out.println(e);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblTablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaDatosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTablaDatosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPer;
    private javax.swing.JButton btnVerUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbExit;
    private javax.swing.JPanel pnBotones;
    private javax.swing.JTable tblTablaDatos;
    // End of variables declaration//GEN-END:variables
}
