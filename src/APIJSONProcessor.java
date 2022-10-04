import org.json.JSONObject;

public class APIJSONProcessor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    String threadName;

    public APIJSONProcessor(){
    }
    public APIJSONProcessor(String threadName){
        this.threadName = threadName;
    }
    public void printApiInformation(String api_json) {
        JSONObject activity = new JSONObject(api_json);
        String act = activity.getString("activity");
        if(this.threadName == null) {
            System.out.println(ANSI_BLUE+"Activity: "+ANSI_RESET + act);
        } else {
            System.out.println(ANSI_BLUE+"Activity: "+ANSI_RESET + act + ANSI_RED+" (thread: " + this.threadName + ")"+ANSI_RESET);
        }
    }
}
