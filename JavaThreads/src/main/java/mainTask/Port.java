package mainTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Port {
   static final int CAPACITY=20;
   static BlockingQueue <Container> containers;
   private BlockingQueue <Dock> docks;

    public Port( LinkedBlockingQueue<Dock> docks) {
        this.docks=docks;
    }

    public Dock toDockInThePort(){
        Dock currentDock=null;

        try {
            currentDock=docks.poll(2000, TimeUnit.MILLISECONDS);//
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return currentDock;
    }

    public void leaveTheDock(Dock currentDock){
        docks.add(currentDock);
    }
}
