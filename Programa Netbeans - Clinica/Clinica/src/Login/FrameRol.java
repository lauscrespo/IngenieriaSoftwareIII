package Login;

import static Main.Main.desktopFondo;
import conexion.pool;
import java.awt.BorderLayout;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameRol extends javax.swing.JInternalFrame {

    private Opciones2 opciones2;
    Opciones opciones;
    DatosRol datRol;
    pool cc = new pool();
    Connection cn = null;
    int tipoUsuario = 2;

    public FrameRol(int tipoUsuario) {
        initComponents();
        this.setLocation(250, 50);
        PanelFondo2 F = new PanelFondo2();
        this.add(F, BorderLayout.CENTER);
        this.tipoUsuario = tipoUsuario;
        mostrardatos("");
    }

    void mostrardatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Rol ID");
        modelo.addColumn("Rol");
        tblRoles.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "select * from tbl_roles";
        } else {
            // sql="SELECT * FROM detalle WHERE nro_venta ='"+valor+"'";
        }
        String[] datos = new String[7];
        try {
            cn = cc.datasource.getConnection();

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);

                modelo.addRow(datos);
            }
            tblRoles.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(FrameUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnRol = new javax.swing.JButton();
        BOTONeliminar = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lbExit = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();

        setIconifiable(true);
        setResizable(true);
        setTitle("ROLES");

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRoles);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnRol.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        btnRol.setText("VER ROL");
        btnRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolActionPerformed(evt);
            }
        });

        BOTONeliminar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        BOTONeliminar.setText("ELIMINAR");
        BOTONeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTONeliminarActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAdd.setText("AÑADIR ROL");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lbExit.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        lbExit.setText("Atras");
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setTitle("PERSONAS");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnRol, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BOTONeliminar)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbExit))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(BOTONeliminar)
                            .addComponent(btnRol)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolActionPerformed

        // TODO add your handling code here:
        int fila = tblRoles.getSelectedRow();
        if (fila >= 0) {
            DatosRol rol = new DatosRol(tipoUsuario);
            rol.llenar(tblRoles.getValueAt(fila, 0).toString(), tblRoles.getValueAt(fila, 1).toString());

            desktopFondo.removeAll();
        desktopFondo.repaint();
            desktopFondo.add(rol);
            rol.toFront();
            rol.setVisible(true);
            this.hide();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnRolActionPerformed

    private void BOTONeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTONeliminarActionPerformed
        int fila = tblRoles.getSelectedRow();
        if (fila >= 0) {
            DatosRol rol = new DatosRol(tipoUsuario);
            try {
                cn = cc.datasource.getConnection();
           PreparedStatement psql=cn.prepareStatement("delete from tbl_roles where rolid='"+tblRoles.getValueAt(fila, 0).toString()+"'");
           psql.executeUpdate();
           mostrardatos("");
            } catch (SQLException e) {
                System.out.println(e);
            }

        }else JOptionPane.showMessageDialog(this, "Seleccione una fila");
    }//GEN-LAST:event_BOTONeliminarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        desktopFondo.removeAll();
        desktopFondo.repaint();
        AddRol rol = new AddRol(tipoUsuario);
        desktopFondo.add(rol);
        rol.toFront();
        rol.setVisible(true);
        this.hide();
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        // TODO add your handling code here:
                            
       //                     InetAddress address = InetAddress.getLocalHost();
               //             ip = address.getHostAddress();
                            
                        
                            
                    if (tipoUsuario == 2) {
                        desktopFondo.removeAll();
        desktopFondo.repaint();
                        opciones = new Opciones();
                        desktopFondo.add(opciones);
                        opciones.toFront();
                        opciones.setVisible(true);
                        this.hide();
                    } else {
                        desktopFondo.removeAll();
        desktopFondo.repaint();
                        opciones2 = new Opciones2();
                        desktopFondo.add(opciones2);
                        opciones2.toFront();
                        opciones2.setVisible(true);
                        this.hide();
                    }
                        
        

   
       
    }//GEN-LAST:event_lbExitMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOTONeliminar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRol;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbExit;
    private javax.swing.JTable tblRoles;
    // End of variables declaration//GEN-END:variables
}
