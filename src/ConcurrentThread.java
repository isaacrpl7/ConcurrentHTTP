public class ConcurrentThread extends Thread {

    MakeRequest apiRequest;

    public ConcurrentThread(String name) {
        super(name);
        MakeRequest apiRequest = new MakeRequest("https://www.boredapi.com/api/activity");
        this.apiRequest = apiRequest;
    }

    @Override
    public void run() {
        this.apiRequest.executeRequest();
        String response = this.apiRequest.getStringResponse();

        APIJSONProcessor processor = new APIJSONProcessor(this.getName());
        processor.printApiInformation(response);

        // System.out.println("Finished thread " + this.getName());
    }
}
