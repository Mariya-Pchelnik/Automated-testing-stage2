package MainTask;

import java.io.*;

public class Service {
    private StringBuilder stringBuilder = new StringBuilder();

    public void writeStructureForDirectory(File directory, BufferedWriter writer)
            throws IOException {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                writer.write(increaseSpace() + "|--" + file.getName());
                writer.newLine();
                if (file != null) {
                    writeStructureForDirectory(file, writer);
                }
            } else {
                writer.write(increaseSpace() + "|*" + file.getName());
                writer.newLine();
            }
            decreaseSpace();
        }
    }

    private StringBuilder increaseSpace() {
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    private void decreaseSpace() {
        stringBuilder.setLength(stringBuilder.length() - 4);
    }


    public void readFileAndPrintData(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String string;
            int directoryCounter = 0;
            int fileCounter = 0;
            double sumOfFileNameLength = 0;

            while ((string = reader.readLine()) != null) {
                if (string.contains("|--")) {
                    directoryCounter++;
                } else if (string.contains("|*")) {
                    sumOfFileNameLength += string.trim().substring(2).length();
                    fileCounter++;
                }
            }

            System.out.println("Amount of files: " + fileCounter);
            System.out.println("Amount of directories: " + directoryCounter);
            System.out.println("Average length of the file: "
                    + sumOfFileNameLength / fileCounter);
            System.out.println("Average amount of files in a directory: "
                    + fileCounter / directoryCounter);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
