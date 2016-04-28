package Login;

import static Main.Main.desktopFondo;
import java.awt.BorderLayout;

public class Opciones extends javax.swing.JInternalFrame {

    FrameUsuarios users;
    FrameRol rol;
    FramePerson person;
    public FrameUsuarios cbPermisoUsuarios;
    private boolean AddPermisosUser;
    

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
        jLabel3 = new javax.swing.JLabel();
        lbPerson = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("CLINICA");

        lbRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/rol.png"))); // NOI18N
        lbRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRolMouseClicked(evt);
            }
        });

        lbUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/user.png"))); // NOI18N
        lbUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUserMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("USUARIOS");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setText("ROLES");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setText("PERSONAS");

        lbPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/person.png"))); // NOI18N
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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
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
                        .addGap(171, 171, 171)
                        .addComponent(lbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lbUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUserMouseClicked
        desktopFondo.removeAll();
        desktopFondo.repaint();
        users = new FrameUsuarios();
        desktopFondo.add(users);
        users.toFront();
        users.setVisible(true);
        this.hide();
    }//GEN-LAST:event_lbUserMouseClicked

    private void lbRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRolMouseClicked
        // TODO add your handling code here:

        desktopFondo.removeAll();
        desktopFondo.repaint();
        rol = new FrameRol(2);
        desktopFondo.add(rol);
        rol.toFront();
        rol.setVisible(true);
        this.hide();


    }//GEN-LAST:event_lbRolMouseClicked

    private void lbPersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPersonMouseClicked
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        person = new FramePerson(2);
        desktopFondo.add(person);
        person.toFront();
        person.setVisible(true);
        this.hide();

    }//GEN-LAST:event_lbPersonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbPerson;
    private javax.swing.JLabel lbRol;
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables
}
