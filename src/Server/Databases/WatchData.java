package Server.Databases;

public class WatchData {
    private String stockName;
    private double price;
    private int uid;
    private int status;

    public WatchData(String s, double p, int u, int st){
        this.stockName = s;
        this.price = p;
        this.uid = u;
        this.status = st;
    }

    public String getStockName() {
        return stockName;
    }

    public int getUid() {
        return uid;
    }

    public double getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

}
