package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDb implements Database{

    private String username;
    private String password;
    private String database;

    public MariaDb() {

    }

    public MariaDb(String database, String username, String password){

        this.database = database;
        this.username = username;
        this.password = password;
    }

    public Connection connect(){
        Connection con= null;
        try {
            con = tryConnect();
        } catch (SQLException e) {
            System.err.println("Hiba! Az adatbázis kapcsolódás sikertelen.");
        }
        return con;
    }

    public Connection tryConnect()throws SQLException{

        String url = "jdbc:mariadb://localhost:3306/" + database;
        Connection con = DriverManager.getConnection(url, "shop", "titok");
        return con;
    }
    
    public void close(Connection con){

        try {
            tryClose(con);
        } catch (Exception e) {
            System.err.println("hiba! az adatbázis lezárás sikertelen");
        }
    }

    public void tryClose(Connection con) throws SQLException{
        con.close();
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
