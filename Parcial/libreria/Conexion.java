package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion
{
    public static Connection con;
    public static boolean loggedIn = false;
    private static Conexion ConexionConectada = null;    
    protected ResultSet rs;
    private String usr,pass,baseDatos,puerto,ip;
    

    public Conexion(String usr, String pass)
    {
        loggedIn=false;
        this.usr = usr;
        this.pass = pass;
        this.baseDatos="";
        this.puerto="";
        this.ip="";
       
        ifConnected();       
    }
   
    public PreparedStatement statamet(String sql)
    {
        try {
            return con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private boolean ifConnected()
    {        
        try
        {
            if (Conexion.loggedIn == true)
            {
                con = Conexion.getDatabaseConnection().getConnection();
                return true;
            }
            else
            {
                Conectar();
                return true;
            }
        }
        catch(Exception e)
        {
            
            return false;
        }
        
    }
    
    public Savepoint SavePoint() 
    {
        try {
            return con.setSavepoint();
        } catch (SQLException ex) {            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Conexion getDatabaseConnection()
    {
        return Conexion.ConexionConectada;
    }

    private static void setDatabaseConnection(Conexion conexion)
    {
        Conexion.ConexionConectada = conexion;
    }

        
    
    public void EjecutarSentencia(String sentencia) throws SQLException
    {
        ifConnected();
        PreparedStatement ps;
        ps = con.prepareStatement(sentencia);
        ps.execute();     
    }
    public void EjecutarDDL(String sentencia) throws SQLException
    {
        Statement ps;        
        ps = con.createStatement();
        ps.execute(sentencia);
    }
    
    
    public void EjecutarUpdate(String sentencia) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException 
    {
        ifConnected();
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.executeUpdate();     
    }
    
    public void Close()
    {
        if(loggedIn)
        {
            try {                
                con.close();
                loggedIn=false;
            } catch (SQLException ex) {
                loggedIn=false;
            }
        }
    }

    public ResultSet EjecutarConsulta(String consulta) throws SQLException 
    {
        ifConnected();
        PreparedStatement ps;
        try
        {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            return rs;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void Conectar() throws SQLException 
    {           
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();       
            Login();        
        }
        catch(Exception e)
        {
            
        }
        
    }

    private void Login() throws SQLException 
    {        
        con = DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":"+puerto+":"+baseDatos, usr, pass);            
        Conexion.loggedIn = true;
        Conexion.setDatabaseConnection(this);        
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Conexion.loggedIn = loggedIn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    

}
