public class Sequential {

    static void executarSequencial(int n) {
        for(int i = 0;i < n;i++) {
            MakeRequest apiRequest = new MakeRequest("https://catfact.ninja/fact");

            apiRequest.executeRequest();
            String response = apiRequest.getStringResponse();

            APIJSONProcessor processor = new APIJSONProcessor();
            processor.printApiInformation(response);
        }
    }

    public static void main(String[] args) {
        executarSequencial(10);
    }
}