//Add db code here
package Server.API;

public class APIConn {

    private static String API_KEY = "4H1YEZO8ZXFT6DF";
    private static String QUERY = "https://www.alphavantage.co/query?function=";

    public enum Interval {
        DAILY,
        WEEKLY,
        MONTHLY;


        public static String getURLParam(Interval i){

            switch(i){
                case DAILY:         return "daily";
                case WEEKLY:        return "weekly";
                case MONTHLY:       return "monthly";
                default:            throw new IllegalArgumentException();
            }
        }
    }





}