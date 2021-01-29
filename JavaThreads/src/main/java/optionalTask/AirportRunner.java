package optionalTask;

public class AirportRunner {

    public static void main(String[] args) throws InterruptedException {
        Airport airport=new Airport("Minsk International Airport");
        Airplane [] array=new Airplane[10];

        for (int i=0; i<10;i++){
            array[i]=new Airplane("Airplane "+i,airport);
            array[i].start();
        }

    }
}
