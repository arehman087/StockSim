package Server.Databases;

public class UserData {
    private int uid;
    private String fName;
    private String lName;
    private String userName;
    private String pass;
    private double portfilio;

    public UserData(int id, String f, String l, String u, String p, double m){
        this.uid = id;
        this.fName = f;
        this.lName = l;
        this.userName = u;
        this.pass = p;
        this.portfilio = m;
    }

    public int getUid() {
        return uid;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public double getPortfilio() {
        return portfilio;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPortfilio(double portfilio) {
        this.portfilio = portfilio;
    }
}
