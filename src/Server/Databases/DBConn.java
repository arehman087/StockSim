//add DB Code here!
package Server.Databases;

import java.sql.*;

class DBConn{
    private String driver;
    private String url;

    private String user;
    private String pass;

    private Connection conn;

    /**
     * Makes an instance of the db to connect to it.
     */
    public DBConn(){

        this.driver = "org.postgresql.Driver";
        this.url = "jdbc:postgresql://localhost:5432/StockSim";

        this.user = "postgres";
        this.pass = "Passcode1";

    }

    public void openConn(){
        try{
            Class.forName(this.driver);
            System.out.println("connecting to db");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void closeConn(){
        try{
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void insertUser(){

    }

    public void insertWatchList(){

    }

    public void insertTransaction(){

    }

    //returns Results from db
    public ResultSet getData(){
        return null;
    }
}