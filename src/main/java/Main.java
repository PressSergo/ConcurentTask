import Executors.AcceptExecutor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AcceptExecutor acceptExecutor = new AcceptExecutor();
        acceptExecutor.init();
        acceptExecutor.start();
    }
}
