package mainTask;

import java.util.concurrent.BlockingQueue;

public class Dock {
    private String name;
    private BlockingQueue<Container> containers;

    public Dock(String name, BlockingQueue<Container> listOfcontainers) {
        this.name = name;
        this.containers = listOfcontainers;
    }

    public boolean setContainer(Container container){
        return containers.offer(container);
    }

    public Container getContainer(){
        return containers.poll();
    }

    public String getName() {
        return name;
    }
}
