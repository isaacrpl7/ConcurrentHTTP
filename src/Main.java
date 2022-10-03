import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        GetUserRequest getUserRequest = new GetUserRequest("https://random-user.p.rapidapi.com/getuser",
    "0d6178b922msh48f80de9c65c23ap1bbda8jsne622c61f187e",
    "random-user.p.rapidapi.com");

        getUserRequest.executeRequest();
        String response = getUserRequest.getStringResponse();

        UserAPIProcessor processor = new UserAPIProcessor();
        processor.printUserInformation(response);
    }
}