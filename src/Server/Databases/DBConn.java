//add DB Code here!
package Server.Databases;

import java.net.UnknownServiceException;
import java.sql.*;
import java.util.Hashtable;
import java.util.Properties;

public class DBConn{
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

    /**
     * Opens connection to the Database
     */
    private void openConn(){
        try{
            Class.forName(this.driver);
            System.out.println("connecting to db");
            Properties prop = new Properties();
            prop.setProperty("user", this.user);
            prop.setProperty("password", this.pass);
            this.conn = DriverManager.getConnection(this.url, prop);
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

    /**
     * Closes connection to the database
     */
    private void closeConn(){
        try{
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param fName first name of the user
     * @param lName last name of the user
     * @param uName UserName of the user - will be unique
     * @param passwrd password
     * @param start starting amount for users Portfolio to buy stocks
     * @return number of rows affected to indicate that it was successful in adding the new user
     */
    public int insertUser(String fName, String lName, String uName, String passwrd, double start){
        try{
            this.openConn();
            String sql = "INSERT INTO user_data(first_name, last_name, username, passwrd, portfolio) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, uName);
            ps.setString(4, passwrd);
            ps.setDouble(5, start);

            return ps.executeUpdate();

        }
        catch (Exception e){
            System.out.println("INSERT USER HAS FAILED");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            this.closeConn();
        }
        return -1;
    }

    /**
     *
     * @param stockName The ticker of the stock
     * @param price the current price of the stock
     * @param uid  identification number of the user
     * @param status means of the stock was bought watching 1=watching, 2 = sold
     * @return number of rows affected to indicate that it was successful in adding the stock
     */
    public int insertWatchList(String stockName, double price, int uid, int status){
        try{
            this.openConn();

            String sql = "INSERT INTO watchlist(stockname, price, uid, status) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stockName);
            ps.setDouble(2, price);
            ps.setInt(3, uid);
            ps.setInt(4, status);

            return ps.executeUpdate();

        }
        catch (Exception e){
            System.out.println("INSERT WATCHLIST HAS FAILED");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            this.closeConn();
        }
        return -1;
    }

    /**
     *
     * @param stockName name of the stock
     * @param bought price the stock when bought
     * @param sold price of the stock when sold
     * @param num number of stocks bought/sold
     * @param uid id of the user that bought/sold the stock
     * @return number of rows affected to indicate that it was successful in adding the transaction
     */
    public int insertTransaction(String stockName, double bought, double sold, int num, int uid){
        try{
            this.openConn();

            String sql = "INSERT INTO transactions(stockname, price_bought, price_sold, timestmp, num, uid) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stockName);
            if (bought <= 0){
                ps.setObject(2, null);
            }
            else{
                ps.setDouble(2, bought);
            }

            if (sold <= 0){
                ps.setObject(3, null);
            }
            else{
                ps.setDouble(3, sold);
            }
            ps.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
            ps.setInt(5, num);
            ps.setInt(6, uid);

            return ps.executeUpdate();

        }
        catch (Exception e){
            System.out.println("INSERT TRANSACTION HAS FAILED");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            this.closeConn();
        }
        return -1;
    }

    //a table with objects
    public UserData getUser(String usr, String pswd){
        try{
            this.openConn();
            Hashtable<Integer, UserData> user = new Hashtable<>();

            String sql = "SELECT * FROM user_data WHERE username = (?) AND passwrd = (?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usr);
            ps.setString(2, pswd);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                int i = rs.getInt("uid");
                String u = rs.getString("username");
                String p = rs.getString("passwrd");
                String f = rs.getString("first_name");
                String l = rs.getString("last_name");
                double m = rs.getDouble("portfolio");

                UserData ud = new UserData(i, f, l, u, p, m);
                return ud;
            }
            else{
                return null;
            }

        }
        catch(Exception e){
            System.out.println("USER RETRIEVAL HAS FAILED");
            System.out.println(e.getMessage());
        }
        finally {
            this.closeConn();
        }
        return null;
    }



}