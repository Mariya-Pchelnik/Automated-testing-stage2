package optionalTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Airplane extends Thread{
    private String name;
    private Airport airport;
    private Semaphore semaphore;

    public Airplane(String name, Airport airport) {
        this.name = name;
        this.airport = airport;
        this.semaphore=airport.getRunways();
    }

    @Override
    public void run() {
        try {
            System.out.println("Cамолет "+name+ "начал выход на полосу ");
            airport.getRunways().acquire();
            System.out.println("Полоса  приняла самолет "+name);
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Самолет"+name+ "взлетел");
            System.out.println("Полоса свободна");
            semaphore.release();
        } catch (InterruptedException e) {
            semaphore.release();
            e.printStackTrace();
        }
    }
}
