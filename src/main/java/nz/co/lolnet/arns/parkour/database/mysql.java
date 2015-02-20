package nz.co.lolnet.arns.parkour.database;
import java.sql.*;
import nz.co.lolnet.arns.parkour.Main;
/**
 *
 * @author Arni
 */
//Database.java
  
public class MySQL {

    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;

    public MySQL(String host, String databaseName, int port, String username, String password) {
        this.URL = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
            
        this.USERNAME = username;
        this.PASSWORD = password;
    }


    public Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Connect (String host, String port, String username, String password) throws SQLException {
    
    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        connection = DriverManager.getConnection(
        "jdbc:mysql://" + host + ":" + port + "/feedback?user=" + username + "&password=" + password
        );
        return !connection.isClosed();
    }
        
}