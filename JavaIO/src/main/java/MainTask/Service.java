package MainTask;

import java.io.*;

public class Service {
    private StringBuilder stringBuilder = new StringBuilder();

    public void writeStructureForDirectory(File directory, BufferedWriter writer)
            throws IOException {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                writeDirectoryContent(file, writer);
            } else {
                writeFile(file, writer);
            }
        }
    }

    private void writeDirectoryContent(File directory, BufferedWriter writer) throws IOException {
        if (directory.listFiles() == null) {
            writer.write(increaseSpace() + "|--" + directory.getName());
            writer.newLine();
            decreaseSpace();
        } else {
            writer.write(increaseSpace() + "|--" + directory.getName());
            writer.newLine();
            writeStructureForDirectory(directory, writer);
            decreaseSpace();
        }

    }

    private void writeFile(File file, BufferedWriter writer) throws IOException {
        writer.write(increaseSpace() + "|*" + file.getName());
        writer.newLine();
        decreaseSpace();
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
            int symbol;
            int directoryCounter = 0;
            int fileCounter = 0;
            double sumOfFileNameLength = 0;

            while ((symbol = reader.read()) != -1) {
                if (symbol == '-') {
                    reader.read();
                    reader.readLine();
                    directoryCounter++;
                } else if (symbol == '*') {
                    String fileName = reader.readLine().trim();
                    sumOfFileNameLength += fileName.length();
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
