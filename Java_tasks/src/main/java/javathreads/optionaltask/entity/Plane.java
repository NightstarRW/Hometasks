package javathreads.optionaltask.entity;

import java.util.concurrent.Semaphore;

public class Plane implements Runnable {
    private final int id;
    private final Semaphore runway;
    private final boolean[] runwaysStatus;

    public Plane(int id, Semaphore runway, boolean[] runwaysStatus) {
        this.id = id;
        this.runway = runway;
        this.runwaysStatus = runwaysStatus;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        try {
            runway.acquire();
            int runwayNumber = 0;
            synchronized (runwaysStatus) {
                for (int i = 0; i < runwaysStatus.length; i++) {
                    if (!runwaysStatus[i]) {
                        runwaysStatus[i] = true;
                        System.out.println("Runway took a plane");
                        runwayNumber = i;
                        System.out.println("Plane №" + getId() + " entered the runway");
                        break;
                    }
                }
            }
            Thread.sleep(300);
            synchronized (runwaysStatus) {
                runwaysStatus[runwayNumber] = false;
            }
            System.out.println("Plane №" + getId() + " flew away");
            System.out.println("Runway is free");
            runway.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
