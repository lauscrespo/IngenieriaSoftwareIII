package Login;

import Conexion.Conexion;
import static Main.Main.menuAdm;
import static Main.Main.menuCitas;
import static Main.Main.opcionesVentana;
import static Main.Main.menuDoctores;
import static Main.Main.menuPacientes;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class IniciarSesion extends javax.swing.JInternalFrame {

    private Opciones opciones;
    private Opciones2 opciones2;
    Conexion cc;
    Connection cn;
    private int cont;

    public IniciarSesion() {
        initComponents();
        cc = new Conexion();
        cn = cc.getConnection();
        this.setLocation(350, 50);
        PanelFondo F = new PanelFondo();
        this.add(F, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Iniciar Sesion");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NOMBRE DE USUARIO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CONTRASEÑA:");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIniciarSesion.setText("INICIAR SESION");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed

        String ip;
        String pass = new String(password.getPassword());
        String sqlusu = "select userid,Username,PasswordUser,estado,RolId from tbl_seg_user where UserName = '" + txtUser.getText() + "' and PasswordUser = '" + pass + "';";
        String sqlper = "Select Mnemonic ";
        String[] dato = new String[5];

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlusu);
            while (rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);
            }
            try {
                if (txtUser.getText().equals(dato[1]) && pass.equals(dato[2]) && dato[3].equals("1")) {
                    try {
                        if (cn != null) {
                            InetAddress address = InetAddress.getLocalHost();
                            ip = address.getHostAddress();
                            try {
                                PreparedStatement psql = cn.prepareStatement("INSERT INTO tbl_seg_loginhistory "
                                        + " (userid,fechaLog,ip ) values ('" + dato[0] + "', current_timestamp(),'" + ip + "');");
                                psql.executeUpdate();
                                psql.getMoreResults();
                            } catch (SQLException e) {
                                System.out.println(e);
                            }
                            JOptionPane.showMessageDialog(this, "CONECTADO");
                        }
                    } catch (UnknownHostException | HeadlessException e) {

                    }
                    if (dato[4].equals("2")) {
                        opcionesVentana = "opcion1";
                        this.hide();
                        menuCitas.setEnabled(true);
                        menuPacientes.setEnabled(true);
                        menuDoctores.setEnabled(true);
                        menuAdm.setEnabled(true);

                    } else {
                        opcionesVentana = "opcion2";
                        this.hide();
                        menuCitas.setEnabled(true);
                        menuPacientes.setEnabled(true);
                        menuDoctores.setEnabled(true);
                        menuAdm.setEnabled(true);
                    }

                    dispose();

                } else {
                    if (dato[3].equals("0") || cont == 3) {
                        JOptionPane.showMessageDialog(this, "USER BLOQUEADO");
                    } else {
                        JOptionPane.showMessageDialog(this, "USUARIO/CONTRASEÑA INCORRECTA");
                    }
                    cont++;
                }
            } catch (HeadlessException e) {
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
