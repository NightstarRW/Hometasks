package javathreads.optionaltask;

import javathreads.optionaltask.entity.Airport;
import javathreads.optionaltask.entity.Plane;

public class AirportRunner {
    private static final int NUMBER_OF_RUNWAYS = 5;
    private static final int NUMBER_OF_PLANES = 10;

    public static void main(String[] args) {
        Airport airport = new Airport(NUMBER_OF_RUNWAYS);

        for (int i = 1; i < NUMBER_OF_PLANES + 1; i++) {
            new Thread(new Plane(i, airport.getRunways(), airport.getRunwaysStatus())).start();
        }
    }
}
