package OptionalTask;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void createAndSortFileWithRandomNumbers() {
        File file = new File("D:\\Java\\JavaIO\\src\\main" +
                "\\resources\\TextOutPutForOptionalTask.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (BufferedOutputStream writer = new BufferedOutputStream(
                new FileOutputStream(file))) {
            Random randomNumber = new Random();

            for (int i = 0; i < 8; i++) {
                writer.write(randomNumber.nextInt());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (BufferedInputStream reader = new BufferedInputStream(
                new FileInputStream(file))) {
            byte[] bytes = new byte[8];
            int numbers[] = new int[8];

            while (reader.read() != -1) {
                reader.read(bytes);
            }
            for (int i = 0; i < 8; i++) {
                numbers[i] = (int) bytes[i];
            }
            for (int i = numbers.length - 1; i > 0; i--) {
                for (int j = 0; j < numbers.length - 1; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int buf = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = buf;
                    }
                }
            }
            System.out.println(Arrays.toString(numbers));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readProgramAndReplaceWords() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Java" +
                "\\JavaIO\\src\\main\\java\\MainTask\\Service.java"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java" +
                     "\\JavaIO\\src\\main\\resources\\TextOutPutForOptionalTask.txt", true))) {
            String line;

            writer.newLine();
            writer.write("Read program and replace words:");
            writer.newLine();
            while ((line = reader.readLine()) != null) {
                writer.write(line.replace("public", "private"));
                writer.newLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readProgramAndReverseSymbols() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Java" +
                "\\JavaIO\\src\\main\\java\\MainTask\\Service.java"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java" +
                     "\\JavaIO\\src\\main\\resources\\TextOutPutForOptionalTask.txt", true))) {
            String line;

            writer.write("Read program and reverse symbols:");
            writer.newLine();
            while ((line = reader.readLine()) != null) {
                writer.write(new StringBuffer(line).reverse().toString());
                writer.newLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void readProgramAndChangeLetter() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Java" +
                "\\JavaIO\\src\\main\\java\\MainTask\\Service.java"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Java" +
                     "\\JavaIO\\src\\main\\resources\\TextOutPutForOptionalTask.txt", true))) {
            String line;

            writer.write("Read program and change letters:");
            writer.newLine();
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s");
                for (String word : words) {
                    if (word.length() > 2) {
                        writer.write(word.toUpperCase() + " ");
                    } else {
                        writer.write(word + " ");
                    }
                }
                writer.newLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createAndSortFileWithRandomNumbers();
        readProgramAndReplaceWords();
        readProgramAndReverseSymbols();
        readProgramAndChangeLetter();
    }
}
