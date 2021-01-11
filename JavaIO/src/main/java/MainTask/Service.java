package MainTask;

import java.io.*;

public class Service {
    private static int fileSpace = 1;
    private static int directorySpace = 1;

    public void writeStructureForDirectory(File directory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java" +
                "\\JavaIO\\src\\main\\resources\\TextOutPutForMainTask.txt"))) {
            File[] filesStructure = directory.listFiles();

            writer.write(directory.getName());
            writer.newLine();
            writeContent(filesStructure, writer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void writeContent(File[] filesStructure, BufferedWriter writer) throws IOException {
        StringBuffer buffer = new StringBuffer("    " + "    " + "    "
                + "    " + "    " + "    ");

        for (File currentFile : filesStructure) {
            if (currentFile.isDirectory()) {
                File[] currentFileStructure = currentFile.listFiles();

                buffer.setLength(4 * (directorySpace++));
                writer.write(buffer.toString() + "|--" + currentFile.getName());
                writer.newLine();
                fileSpace++;
                writeContent(currentFileStructure, writer);
                fileSpace--;
                directorySpace--;
            } else {
                buffer.setLength(4 * (fileSpace));
                writer.write(buffer.toString() + "|*" + currentFile.getName());
                writer.newLine();
            }
        }
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
                    sumOfFileNameLength += reader.readLine().length();
                    fileCounter++;
                }
            }
            System.out.println("File amount: " + fileCounter);
            System.out.println("Directory amount: " + directoryCounter);
            System.out.println("Средняя длина файла: "
                    + sumOfFileNameLength / fileCounter);
            System.out.println("Cреднее количество файлов в папке: "
                    + fileCounter / directoryCounter);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
