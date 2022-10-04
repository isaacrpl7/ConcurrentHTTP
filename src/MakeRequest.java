import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MakeRequest {
    HttpResponse<String> response;
    HttpRequest request;
    public MakeRequest(String url, String x_rapid_api_key, String x_rapid_api_host) {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", x_rapid_api_key)
                .header("X-RapidAPI-Host", x_rapid_api_host)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }

    HttpResponse<String> executeRequest() {
        try {
            this.response = HttpClient.newHttpClient().send(this.request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.response;
    }

    String getStringResponse() {
        return this.response.body();
    }
}
