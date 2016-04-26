package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Conexion {

    private Connection connection;
    public static final String DATABASE = "clinica";
    public static final String SERVERNAME = "sa";
    public static final String PASSWORD = "root";

    public Conexion() {
        getInstance();
    }

    public Connection getInstance() {
        connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=" + DATABASE + ";";
            connection = DriverManager.getConnection(connectionUrl, SERVERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + DATABASE + " : OK\n");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException u) {
            System.out.println("Class not Found Exception: " + u.toString());
        }
        return connection;
    }

    public void ejecutarConsulta(String sql) throws SQLException {
        Statement consulta = connection.createStatement();
        consulta.executeUpdate(sql);
    }

    public ResultSet obtenerConsulta(String sql) throws SQLException {
        Statement consulta = connection.createStatement();
        return consulta.executeQuery(sql);
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }

}
