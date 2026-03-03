/**
 * tackt generator was sonst
 * 
 * @author mathis (mathiiiiiis) 
 * @version 1.1.0
 */
public class tacktGenerator {

    private WeckStoppUhr weckStoppUhr;
    private Thread thread;
    private volatile boolean laeuft;
    private static int counter = 0;

    public tacktGenerator(WeckStoppUhr weckStoppUhr) {
        this.weckStoppUhr = weckStoppUhr;
        this.laeuft = false;
    }

    public synchronized void starten() {

        // stop active thread if one exists
        if (thread != null && thread.isAlive()) {
            stoppen();
        }

        laeuft = true;

        thread = new Thread(() -> {
            while (laeuft && !Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    weckStoppUhr.erhoeheZeit();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "tacktGenerator-" + (++counter));

        thread.setDaemon(true);
        thread.start();
    }

    public synchronized void stoppen() {
        laeuft = false;

        if (thread != null && thread.isAlive()) {
            thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public String getThreadName() {
        return thread != null ? thread.getName() : "No thread";
    }
}