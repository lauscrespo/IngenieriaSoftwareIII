package Main;

import Doctors.Doctores;
import Pacientes.Pacientes;
import javax.swing.ImageIcon;

public class Main extends javax.swing.JFrame {

    private Pacientes listPacientes;
    private Doctores listDoctors;
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopFondo = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuPacientes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuDoctores = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CLINICA - INGENIERIA DE SOFTWARE III");
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(new ImageIcon("logo.png").getImage());

        javax.swing.GroupLayout desktopFondoLayout = new javax.swing.GroupLayout(desktopFondo);
        desktopFondo.setLayout(desktopFondoLayout);
        desktopFondoLayout.setHorizontalGroup(
            desktopFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1315, Short.MAX_VALUE)
        );
        desktopFondoLayout.setVerticalGroup(
            desktopFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        menuPacientes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        menuPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paciente.png"))); // NOI18N
        menuPacientes.setText("PACIENTES");
        menuPacientes.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lista.png"))); // NOI18N
        jMenuItem1.setText("Ver Lista Pacientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuPacientes.add(jMenuItem1);

        jMenuBar1.add(menuPacientes);

        menuDoctores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/doctor.png"))); // NOI18N
        menuDoctores.setText("DOCTORES");
        menuDoctores.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lista.png"))); // NOI18N
        jMenuItem2.setText("Ver Lista de Doctores");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuDoctores.add(jMenuItem2);

        jMenuBar1.add(menuDoctores);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopFondo, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopFondo, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        listPacientes = new Pacientes();
        desktopFondo.add(listPacientes);
        listPacientes.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        listDoctors = new Doctores();
        desktopFondo.add(listDoctors);
        listDoctors.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktopFondo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menuDoctores;
    private javax.swing.JMenu menuPacientes;
    // End of variables declaration//GEN-END:variables

}
