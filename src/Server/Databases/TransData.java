package Server.Databases;

import java.sql.Timestamp;

public class TransData {
    private int tid;
    private String stockName;
    private double bought;
    private double sold;
    private Timestamp timestmp;
    private int num;
    private int uid;

    public TransData(int t, String s, Double b, Double so, Timestamp ti, int n, int u){
        this.tid = t;
        this.stockName = s;
        this.bought = b;
        this.sold = so;
        this.timestmp = ti;
        this.num = n;
        this.uid = u;
    }

    public int getUid() {
        return uid;
    }

    public double getBought() {
        return bought;
    }

    public double getSold() {
        return sold;
    }

    public int getNum() {
        return num;
    }

    public int getTid() {
        return tid;
    }

    public String getStockName() {
        return stockName;
    }

    public Timestamp getTimestmp() {
        return timestmp;
    }

}
