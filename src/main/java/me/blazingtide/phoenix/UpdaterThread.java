package me.blazingtide.phoenix;

public class UpdaterThread extends Thread {

    private final Phoenix phoenix;

    UpdaterThread(Phoenix phoenix) {
        super("Phoenix Updater Thread");
        this.phoenix = phoenix;
    }

    @Override
    public void run() {
        while (true) {
            //Made it a parallel stream to prevent any latency with updating GUIs just in case you got a server with like 2k GUIs open.
            phoenix.getOpenGUIS().values().parallelStream().filter(gui -> gui.isAutoUpdating() && (System.currentTimeMillis() - gui.getLastTick() + gui.getUpdateTick() <= 0)).forEach(GUI::update);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
