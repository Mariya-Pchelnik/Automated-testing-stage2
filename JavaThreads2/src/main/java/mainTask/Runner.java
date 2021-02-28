package mainTask;

public class Runner {
    public static void main(String[] args) {
        Port port = new Port(5, 10, 20);
        new Ship("Ship1", Goals.LOADING, 5, 20, port).start();
        new Ship("Ship2", Goals.UNLOADING, 15, 20, port).start();
        new Ship("Ship3", Goals.UNLOADINGANDLOADING, 10, 20, port).start();
        new Ship("Ship4", Goals.UNLOADINGANDLOADING, 13, 20, port).start();
        new Ship("Ship5", Goals.UNLOADING, 30, 20, port).start();
        new Ship("Ship6", Goals.LOADING, 10, 20, port).start();
    }
}
