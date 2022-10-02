import java.util.Random;

public class Ats implements Runnable {

    private static final int TIME_CALL_GENERATION = 2;
    private static final int NUMBER_CALL_GENERATION = 40;
    private static final int NUMBER_RUNDOM_GENERATION = 9999999;
    private static final int TIMER_ATS_DELAY = 100;

    private final Random random = new Random();
    private final CallQueue callQueue;

    public Ats(CallQueue callQueue) {
        this.callQueue = callQueue;
    }

    public void run() {
        System.out.println("АТС запущена");
        boolean atsOff = true;
        int countDownTime = TIME_CALL_GENERATION;
        try {
            while (atsOff) {
                for (int i = 1; i <= NUMBER_CALL_GENERATION; i++) {
                    Call tempCall = new Call(random.nextInt(NUMBER_RUNDOM_GENERATION));
                    callQueue.getQueue().add(tempCall);
                    System.out.println("Поступил вызов от -> " + tempCall.getCallNumber());
                }
                Thread.sleep(TIMER_ATS_DELAY);
                countDownTime--;
                if (countDownTime == 0) {
                    atsOff = false;
                }
            }
            callQueue.setCycle(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.print(" АТС БОЛЬШЕ НЕ РАБОТАЕТ\n");
        }
    }
}