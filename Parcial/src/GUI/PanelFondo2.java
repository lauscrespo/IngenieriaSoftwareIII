package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class PanelFondo2 extends javax.swing.JPanel {

    private final String ruta;
    private final String ruta1;
    
    public PanelFondo2() {
        initComponents();
        this.setSize(1300, 900);
        this.ruta = "fondo4_1.jpg";
        this.ruta1 = "logoHospital.png";
    }
    

    @Override
    public void paintComponent(Graphics g) {
        Dimension tam = getSize();
        ImageIcon ImagenFondo = new ImageIcon(new ImageIcon(getClass().getResource(ruta)).getImage());
        ImageIcon ImagenFondo1 = new ImageIcon(new ImageIcon(getClass().getResource(ruta1)).getImage());
        g.drawImage(ImagenFondo.getImage(), 0, 0, tam.width, tam.height, null);
        g.drawImage(ImagenFondo1.getImage(), 250, 10,null);
        setOpaque(false);
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
