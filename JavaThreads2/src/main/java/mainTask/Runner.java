package mainTask;

public class Runner {
    public static void main(String[] args) {
        Port port = new Port(5, 10, 20);
        Ship ship1 = new Ship("Ship1", Goals.LOADING, 5, 20, port);
        Ship ship2 = new Ship("Ship2", Goals.UNLOADING, 15, 20, port);
        Ship ship3 = new Ship("Ship3", Goals.UNLOADINGANDLOADING, 10, 20, port);
        Ship ship4 = new Ship("Ship4", Goals.UNLOADINGANDLOADING, 13, 20, port);
        Ship ship5 = new Ship("Ship5", Goals.UNLOADING, 30, 20, port);
        Ship ship6 = new Ship("Ship6", Goals.LOADING, 10, 20, port);
        ship1.run();
        ship2.run();
        ship3.run();
        ship4.run();
        ship5.run();
        ship6.run();
    }
}
