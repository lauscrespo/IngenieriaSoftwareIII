/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Connex {

    public String sDriver = "";
    public String sUrl = null;
    public int iTimeout = 30;
    public Connection conn = null;

    public void setConnection() throws Exception {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Hospital;user=laus;password=soliz;";
            //"jdbc:sqlserver://localhost;databaseName=DBVentas;user=sa;password=sa;";
            conn = DriverManager.getConnection(connectionUrl);
           



        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

    }

    public void init() throws Exception {
        setConnection();

    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception ignore) {
        }
    }

    public static void main(String args[]) {
        Connex connex = new Connex();
    }
}
