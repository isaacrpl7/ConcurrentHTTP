public class Main {

    public static void main(String[] args) {
        MakeRequest getUserRequest = new MakeRequest("https://random-user.p.rapidapi.com/getuser",
    "0d6178b922msh48f80de9c65c23ap1bbda8jsne622c61f187e",
    "random-user.p.rapidapi.com");

        getUserRequest.executeRequest();
        String response = getUserRequest.getStringResponse();

        UserAPIProcessor processor = new UserAPIProcessor();
        processor.printUserInformation(response);
    }
}