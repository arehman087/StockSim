//Add db code here
package Server.API;

public class APIConn {

    private static String API_KEY = "4H1YEZO8ZXFT6DF";
    private static String QUERY = "https://www.alphavantage.co/query?function=";
    private static String SYMBOL ="&symbol=MSFT";
    private static String PARAM_API_KEY = "&apikey=";

    public enum Interval {
        DAILY,
        WEEKLY,
        MONTHLY;

        /**
         * Returns the respective string for the query based on the data entered
         * @param i is the type of data to be retrieved
         * @return the string to representation of the data
         */
        public static String getURLParam(Interval i){

            switch(i){
                case DAILY:         return "TIME_SERIES_DAILY";
                case WEEKLY:        return "TIME_SERIES_WEEKLY";
                case MONTHLY:       return "TIME_SERIES_MONTHLY";
                default:            throw new IllegalArgumentException();
            }
        }


        /**
         * method to build the string query
         * @param i is the type of data to  be retrieved
         * @return full URL query
         */
        private static String buildURL(Interval i){

            StringBuilder sb = new StringBuilder();

            sb.append(QUERY);

            sb.append(Interval.getURLParam(i));

            sb.append(SYMBOL);
            sb.append(PARAM_API_KEY);
            sb.append(API_KEY);

            return sb.toString();
        }


    }





}