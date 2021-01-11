package MainTask;

import java.io.File;

public class Runner {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Введите директорию как аргумент командной строки");
            return;
        }

        Service service = new Service();
        File file = new File(args[0]);

        if (file.isDirectory()) {
            service.writeStructureForDirectory(file);
        } else {
            service.readFileAndPrintData(file);
        }
    }
}

