import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserAPIProcessor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void printUserInformation(String user_json) {
        JSONObject my_obj = new JSONObject(user_json);
        JSONArray results = my_obj.getJSONArray("results");
        JSONObject data = (JSONObject) results.get(0);

        String gender = data.getString("gender");
        String email = data.getString("email");

        JSONObject name = data.getJSONObject("name");
        String first_name = name.getString("first");
        String last_name = name.getString("last");

        JSONObject location = data.getJSONObject("location");
        String country = location.getString("country");
        String state = location.getString("state");
        String postcode = null;
        try {
            postcode = location.getString("postcode");
        } catch (JSONException e){
            postcode = String.valueOf(location.getInt("postcode"));
        }

        JSONObject street = location.getJSONObject("street");
        String street_name = street.getString("name");
        Integer street_number = street.getInt("number");

        System.out.println(ANSI_GREEN+"-- DADOS SOBRE O USUÁRIO GERADO PELA API --"+ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_BLUE+"Nome: "+ANSI_RESET + first_name + " " + last_name);
        System.out.println(ANSI_BLUE+"Gênero: "+ANSI_RESET + gender);
        System.out.println(ANSI_BLUE+"E-mail: "+ANSI_RESET + email);
        System.out.println(ANSI_BLUE+"País: "+ANSI_RESET + country);
        System.out.println(ANSI_BLUE+"Estado: "+ANSI_RESET + state);
        System.out.println(ANSI_BLUE+"Código Postal: "+ANSI_RESET + postcode);
        System.out.println(ANSI_BLUE+"Endereço: "+ANSI_RESET + street_name + ", " + street_number);
        System.out.println();
        System.out.println(ANSI_GREEN+"-----------------------------------------"+ANSI_RESET);
        System.out.println();
    }
}
