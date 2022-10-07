import java.util.ArrayList;

public class Concurrent {
    static void executarConcorrente(int n) {
        ArrayList<ConcurrentThread> threadsArray = new ArrayList<ConcurrentThread>();
        long initialTime = System.currentTimeMillis();

        for(int i = 0;i < n;i++) {
            ConcurrentThread ct = new ConcurrentThread("t"+i);
            threadsArray.add(ct);
            ct.start();
        }

        for(int j = 0;j < threadsArray.size();j++) {
            try {
                threadsArray.get(j).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long finalTime = System.currentTimeMillis();

        System.out.println( "Runtime (ms): " + (finalTime - initialTime) + "ms" );
    }

    public static void main(String[] args) {
        executarConcorrente(40);
    }
}
