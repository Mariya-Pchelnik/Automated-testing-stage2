package mainTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Port {
    private final int maxCapacity;
    private int currentCapacity;
    BlockingQueue<Dock> docks;

    public Port(int docksNumber, int currentCapacity, int maxCapacity) {
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        docks = new LinkedBlockingQueue<>();
        for (int i = 0; i < docksNumber; i++) {
            docks.add(new Dock("Dock" + i));
        }
    }

    public Dock getFreeDock() {
        Dock currentDock = null;
        try {
            currentDock = docks.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentDock;
    }

    public void leaveTheDock(Dock currentDock) {
        docks.add(currentDock);
    }

    public synchronized int loadShip(int shipCapacity) {
        if (currentCapacity < shipCapacity) {
            int shipCurrentCapacity = currentCapacity;
            currentCapacity = 0;
            return shipCurrentCapacity;
        }
        currentCapacity = currentCapacity - shipCapacity;
        return shipCapacity;
    }

    public synchronized int unloadShip(int shipCapacity) {
        if (maxCapacity < shipCapacity + currentCapacity) {
            int unloadedCount = shipCapacity - maxCapacity;
            currentCapacity = maxCapacity;
            return unloadedCount;
        } else currentCapacity = currentCapacity + shipCapacity;
        return 0;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }
}
