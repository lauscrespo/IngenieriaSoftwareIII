package conexion;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class pool {

    public DataSource datasource;
    public String db = "login";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = "root";

    public pool() {
        iniciarDataSource();
    }

    private void iniciarDataSource() {
        BasicDataSource basic = new BasicDataSource();
        basic.setDriverClassName("org.gjt.mm.mysql.Driver");
        basic.setUsername(user);
        basic.setPassword(pass);
        basic.setUrl(url);
        basic.setMaxActive(50);

        datasource = basic;
    }
}
