package Login;

import static Main.Main.desktopFondo;
import java.awt.BorderLayout;


public class Opciones2 extends javax.swing.JInternalFrame {

    FrameUsuarios users;
    FrameRol rol;
    FramePerson person;
    public FrameUsuarios cbPermisoUsuarios;
    private boolean AddPermisosUser;
    
    public Opciones2() {
        initComponents();
        this.setLocation(150, 20);
        PanelFondo2 F = new PanelFondo2();
        this.add(F, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbRol = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbExit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbPerson = new javax.swing.JLabel();

        setIconifiable(true);
        setTitle("CLINICA PACIENTE");

        lbRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/rol.png"))); // NOI18N
        lbRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRolMouseClicked(evt);
            }
        });

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
                        .addGap(231, 231, 231)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(lbRol)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(255, 255, 255))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbExit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    
    private void lbRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRolMouseClicked
        // TODO add your handling code here:
   
        desktopFondo.removeAll();
        desktopFondo.repaint();
        rol = new FrameRol(3);
        desktopFondo.add(rol);
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
        desktopFondo.removeAll();
        desktopFondo.repaint();
        person = new FramePerson(3);
        desktopFondo.add(person);
        person.toFront();
        person.setVisible(true);
        this.hide();

    }//GEN-LAST:event_lbPersonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbPerson;
    private javax.swing.JLabel lbRol;
    // End of variables declaration//GEN-END:variables
}
