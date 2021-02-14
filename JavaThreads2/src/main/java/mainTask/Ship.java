package mainTask;

public class Ship extends Thread{
    private String name;
    private Goals goal;
    private int currentCapacity;
    private final int maxCapacity;
    private Port port;

    public Ship(String name, Goals goal, int currentCapacity, int maxCapacity, Port port) {
        this.name = name;
        this.goal = goal;
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
        this.port = port;
    }

    @Override
    public void run() {
        Dock dock=port.getFreeDock();

        System.out.println("Ship "+name+" with current capacity "+ currentCapacity
        +" and with maxCapacity "+maxCapacity+" have docked in the "+dock.getName());
        switch (goal){
            case LOADING:
                currentCapacity=port.loadShip(maxCapacity-currentCapacity)+currentCapacity;
                break;
            case UNLOADING:
                currentCapacity=port.unloadShip(currentCapacity);
                break;
            case UNLOADINGANDLOADING:
                currentCapacity=port.unloadShip(currentCapacity);
                currentCapacity=port.loadShip(maxCapacity-currentCapacity);
                break;
        }
        port.leaveTheDock(dock);
        System.out.println("Ship "+name+" have left the dock "+dock.getName()
                +" with current capacity"+ currentCapacity
                +" and with maxCapacity "+maxCapacity);
    }
}
