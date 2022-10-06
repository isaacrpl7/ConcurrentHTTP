public class Sequential {

    static void executarSequencial(int n) {
        long initialTime = System.currentTimeMillis();

        for(int i = 0;i < n;i++) {
            MakeRequest apiRequest = new MakeRequest("https://www.boredapi.com/api/activity");

            apiRequest.executeRequest();
            String response = apiRequest.getStringResponse();

            APIJSONProcessor processor = new APIJSONProcessor();
            processor.printApiInformation(response);
        }

        long finalTime = System.currentTimeMillis();

        System.out.println( "Runtime (ms): " + (finalTime - initialTime) + "ms" );
    }

    public static void main(String[] args) {
        executarSequencial(40);
    }
}