package mainTask;

import java.util.ArrayList;
import java.util.List;

public class Ship extends Thread {
   private String name;
   private String goal;
   private int capacity;
   private List<Container> storage;
   private Port port;

    public Ship(String name, String goal,
                int capacity, Port port) {
        this.name = name;
        this.goal = goal;
        this.capacity = capacity;
        this.storage = new ArrayList<>(capacity);
        this.port = port;
    }

    public Ship(String name, String goal,
                List<Container> storage, Port port) {
        this.name = name;
        this.goal = goal;
        this.storage = storage;
        this.capacity = storage.size();
        this.port = port;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void run() {
        Dock dock = port.toDockInThePort();

        if (dock == null) {
            System.out.println("There are no available docks");
        } else {
            System.out.println("The ship " + name +
                    " have docked in the port " + dock.getName());
            switch (goal) {
                case "loading":
                    toLoadContainersOntoTheShip(dock);
                    break;
                case "unloading":
                    toUnloadTheShip(dock);
                    break;
                case "unloading and loading":
                    toUnloadTheShip(dock);
                    toLoadContainersOntoTheShip(dock);
                    break;
            }
            port.leaveTheDock(dock);
            System.out.println("The ship" + name + " have left the port " + dock.getName());
        }
    }

    private void toLoadContainersOntoTheShip(Dock dock) {
        for (int i = 0; i < capacity; i++) {
            Container container = dock.getContainer();

            if (container != null) {
                storage.add(container);
                System.out.println("The ship" + name + " has loaded the container"
                        + container.getRegistrationNumber());
            }else {
                return;
            }
        }
    }

    private void toUnloadTheShip(Dock dock) {
        for (int i = 0; i < capacity; i++) {
            Container container = storage.get(i);

            if (dock.setContainer(container)) {
                System.out.println("The ship " + name + " has unloaded the container "
                        + container.getRegistrationNumber());
            } else {
                System.out.println("The ship" + name + "failed to unload the container "
                        + container.getRegistrationNumber() + " port " + dock.getName() + " is full");
            }
        }
    }
}
