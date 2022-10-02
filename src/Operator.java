import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Operator implements Runnable {

    private final static int WORK_THREAD = 4;
    private final CallQueue callQueue;

    public Operator(CallQueue callQueue) {
        this.callQueue = callQueue;
    }

    public void run() {
        System.out.println("Оператор приступил к работе\n");
        ExecutorService executor = Executors.newFixedThreadPool(WORK_THREAD);
        while (callQueue.isCycle() || !callQueue.getQueue().isEmpty()) {
            Runnable runTask = new OperatorRunuble(callQueue);
            executor.execute(runTask);
        }
        executor.shutdown();
        System.out.println(" ВСЕ ЗВОНКИ ОБРАБОТАННЫ!!! ");
    }
}