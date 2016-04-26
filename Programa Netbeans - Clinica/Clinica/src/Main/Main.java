package Main;

import CitaAtencion.Cita;
import Doctors.Doctores;
import Login.IniciarSesion;
import Login.Opciones;
import Login.Opciones2;
import Pacientes.Pacientes;
import java.net.URL;
import javax.swing.ImageIcon;
import org.apache.log4j.PropertyConfigurator;

public class Main extends javax.swing.JFrame {

    private Pacientes listPacientes;
    private Doctores listDoctors;
    private Cita cita;
    private IniciarSesion iniSesion;
    private Opciones opciones;
    private Opciones2 opciones2;
    public static String opcionesVentana;

    public Main() {
        initComponents();
        menuCitas.setEnabled(false);
        menuPacientes.setEnabled(false);
        menuDoctores.setEnabled(false);
        menuAdm.setEnabled(false);
        opcionesVentana = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopFondo = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemLogIn = new javax.swing.JMenuItem();
        menuCitas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuPacientes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuDoctores = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuAdm = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

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

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paciente.png"))); // NOI18N
        jMenu1.setText("OPCIONES");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        menuItemLogIn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        menuItemLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registrar.png"))); // NOI18N
        menuItemLogIn.setText("Iniciar Secion");
        menuItemLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogInActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLogIn);

        menuBar.add(jMenu1);

        menuCitas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        menuCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cita.png"))); // NOI18N
        menuCitas.setText("CITAS");
        menuCitas.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        menuCitas.setHideActionText(true);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lista.png"))); // NOI18N
        jMenuItem3.setText("Ver Citas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuCitas.add(jMenuItem3);

        menuBar.add(menuCitas);

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

        menuBar.add(menuPacientes);

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

        menuBar.add(menuDoctores);

        menuAdm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lista.png"))); // NOI18N
        menuAdm.setText("ADMINISTRAR");
        menuAdm.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/registrar.png"))); // NOI18N
        jMenuItem5.setText("Opciones");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuAdm.add(jMenuItem5);

        menuBar.add(menuAdm);

        setJMenuBar(menuBar);

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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        cita = new Cita();
        desktopFondo.add(cita);
        cita.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuItemLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogInActionPerformed
        // TODO add your handling code here:
        if (menuItemLogIn.getText().equals("Iniciar Secion")) {
            desktopFondo.removeAll();
            desktopFondo.repaint();
            iniSesion = new IniciarSesion();
            desktopFondo.add(iniSesion);
            iniSesion.show();
            menuItemLogIn.setText("Cerrar Secion");
        } else {
            desktopFondo.removeAll();
            desktopFondo.repaint();
            menuItemLogIn.setText("Iniciar Secion");
            menuCitas.setEnabled(false);
            menuPacientes.setEnabled(false);
            menuDoctores.setEnabled(false);
            menuAdm.setEnabled(false);
        }


    }//GEN-LAST:event_menuItemLogInActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        if ("opcion1".equals(opcionesVentana)) {
            opciones = new Opciones();
            desktopFondo.add(opciones);
            opciones.show();
        } else {
            opciones2 = new Opciones2();
            desktopFondo.add(opciones2);
            opciones2.show();
        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        String resource
                = "/auditoria.properties";
        URL configFileResource;
        configFileResource = Main.class.getResource(resource);
        PropertyConfigurator.configure(configFileResource);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktopFondo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    public static javax.swing.JMenu menuAdm;
    public static javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu menuCitas;
    public static javax.swing.JMenu menuDoctores;
    private javax.swing.JMenuItem menuItemLogIn;
    public static javax.swing.JMenu menuPacientes;
    // End of variables declaration//GEN-END:variables

}
