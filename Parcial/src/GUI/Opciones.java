package GUI;

import conexion.pool;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Opciones extends javax.swing.JInternalFrame {

    FrameUsuarios users;
    FrameRol rol;
    FramePerson person;
    public FrameUsuarios cbPermisoUsuarios;
    private boolean AddPermisosUser;
    Connection cn = null;
     pool cc = new pool();
    
    public Opciones() {
        initComponents();
        this.setLocation(150, 20);
        PanelFondo2 F = new PanelFondo2();
        this.add(F, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbRol = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbExit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbPerson = new javax.swing.JLabel();

        setIconifiable(true);
        setResizable(true);
        setTitle("CLINICA");

        lbRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/rol.png"))); // NOI18N
        lbRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRolMouseClicked(evt);
            }
        });

        lbUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/user.png"))); // NOI18N
        lbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("USUARIOS");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setText("ROLES");

        lbExit.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbExit.setText("Salir");
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setText("PERSONAS");

        lbPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/person.png"))); // NOI18N
        lbPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPersonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)
                        .addGap(244, 244, 244)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRol)
                        .addGap(72, 72, 72)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel3)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbExit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    
    private void lbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseClicked

        // TODO add your handling code here:
          users = new FrameUsuarios();
          Main.escritorio.add(users);
          users.toFront();
          users.setVisible(true);
          this.hide();
    

//     if (users.equals) {
      
//   }
//        else{
//        users.setVisible(false);
//        }

           
    }//GEN-LAST:event_lbUserMouseClicked

    private void lbRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRolMouseClicked
        // TODO add your handling code here:
   
        rol = new FrameRol(2);
        Main.escritorio.add(rol);
        rol.toFront();
        rol.setVisible(true);
        this.hide();
      
        
    }//GEN-LAST:event_lbRolMouseClicked

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lbExitMouseClicked

    private void lbPersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPersonMouseClicked
        // TODO add your handling code here:
        person = new FramePerson(2);
        Main.escritorio.add(person);
        person.toFront();
        person.setVisible(true);
        this.hide();

    }//GEN-LAST:event_lbPersonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbPerson;
    private javax.swing.JLabel lbRol;
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables
}
