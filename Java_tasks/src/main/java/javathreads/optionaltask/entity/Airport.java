package javathreads.optionaltask.entity;

import java.util.concurrent.Semaphore;

public class Airport {
    private int numberOfRunways;
    private boolean[] runwaysStatus;
    private Semaphore runways;

    public Airport(int numberOfRunways) {
        this.numberOfRunways = numberOfRunways;
        runwaysStatus = new boolean[numberOfRunways];
        runways = new Semaphore(numberOfRunways, true);
    }

    public int getNumberOfRunways() {
        return numberOfRunways;
    }

    public void setNumberOfRunways(int numberOfRunways) {
        this.numberOfRunways = numberOfRunways;
    }

    public boolean[] getRunwaysStatus() {
        return runwaysStatus;
    }

    public void setRunwaysStatus(boolean[] runwaysStatus) {
        this.runwaysStatus = runwaysStatus;
    }

    public Semaphore getRunways() {
        return runways;
    }

    public void setRunways(Semaphore runways) {
        this.runways = runways;
    }
}
