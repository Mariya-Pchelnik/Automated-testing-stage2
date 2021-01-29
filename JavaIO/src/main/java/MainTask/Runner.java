package MainTask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Input directory as a program argument");
            return;
        }

        Service service = new Service();
        File file = new File(args[0]);

        if (file.isDirectory()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Git" +
                    "\\Reprositories\\Automated-testing-stage2\\JavaIO\\src\\main\\resources\\" +
                    "TextOutPutForMainTask.txt"))) {
                writer.write(file.getName());
                writer.newLine();
                service.writeStructureForDirectory(file, writer);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            service.readFileAndPrintData(file);
        }
    }
}

