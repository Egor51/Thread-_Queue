import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallQueue {

    private static final int CALL_QUEUE_MAKE = 1000;
    private final Queue<Call> queue;
    private volatile boolean cycle = true;

    CallQueue() {
        queue = new ConcurrentLinkedQueue<>();

        Thread ats = new Thread(new Ats(this));
        Thread operator = new Thread(new Operator(this));
        ats.start();
        operator.start();

        while (operator.isAlive()) {
            try {
                Thread.sleep(CALL_QUEUE_MAKE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public Queue<Call> getQueue() {
        return queue;
    }

    public boolean isCycle() {
        return cycle;
    }

    public void setCycle(boolean cycle) {
        this.cycle = cycle;
    }
}