package optionalTask;

import java.util.concurrent.Semaphore;

public class Airport {
    private String name;
    private Semaphore runways = new Semaphore(5,true);

    public Airport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Semaphore getRunways() {
        return runways;
    }
}
