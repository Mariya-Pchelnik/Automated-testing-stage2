package mainTask;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class Runner {
    public static void main(String[] args) {
        Container array[] = new Container[Port.CAPACITY];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Container(i);
        }

        Port.containers = new LinkedBlockingQueue<Container>(Port.CAPACITY);
        Port.containers.addAll(Arrays.asList(array));
        Port port = new Port(new LinkedBlockingQueue<Dock>() {{
            add(new Dock("Dock1", Port.containers));
            add(new Dock("Dock2", Port.containers));
            add(new Dock("Dock3", Port.containers));
            add(new Dock("Dock4", Port.containers));
            add(new Dock("Dock5", Port.containers));
        }});

        Ship ship1 = new Ship("Ship1", "loading", 7, port);
        Ship ship2 = new Ship("Ship2", "loading", 5, port);
        Ship ship3 = new Ship("Ship3", "unloading",
                new LinkedList<Container>() {
            {
                for (int i = 0; i < 8; i++)
                    add(new Container((Port.CAPACITY + i)));
            }
        }, port);
        Ship ship4 = new Ship("Ship4", "unloading",
                new LinkedList<Container>() {
            {
                for (int i = 0; i < 4; i++)
                    add(new Container((Port.CAPACITY + ship3.getCapacity() + i)));
            }
        }, port);
        Ship ship5 = new Ship("Ship5", "unloading and loading",
                new LinkedList<Container>() {
            {
                for (int i = 0; i < 8; i++)
                    add(new Container((Port.CAPACITY + ship3.getCapacity()
                            + ship4.getCapacity() + i)));
            }
        }, port);
        Ship ship6 = new Ship("Ship6", "loading", 5, port);

        ship3.start();
        ship1.start();
        ship2.start();
        ship4.start();
        ship5.start();
        ship6.start();
    }
}
