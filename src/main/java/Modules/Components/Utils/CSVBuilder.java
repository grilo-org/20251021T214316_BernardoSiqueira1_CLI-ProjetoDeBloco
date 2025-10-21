package Modules.Components.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CSVBuilder {

    private final String DEFAULT_WRITING_PATH = System.getProperty("user.dir");

    public void buildContent(List<String> CSVFile) {
        StringBuilder dataBodyBuilder = new StringBuilder();
        int maxLineLength = 0;

        String[] columnNames = CSVFile.removeFirst().strip().split(",");

        List<String> formattedLines = new ArrayList<>();

        for (String line : CSVFile) {
            String[] values = line.strip().split(",");

            StringBuilder entryBuilder = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                String formatted = String.format(" %-10s: %-20s \n", columnNames[i].trim(), values[i].trim());
                entryBuilder.append(formatted);
                maxLineLength = Math.max(maxLineLength, formatted.length());
            }
            formattedLines.add(entryBuilder.toString());
        }

        String border = "+" + "-".repeat(maxLineLength - 2) + "+\n";

        for (String entry : formattedLines) {
            dataBodyBuilder.append(border);
            dataBodyBuilder.append(entry);
            dataBodyBuilder.append(border);
        }

        System.out.println(dataBodyBuilder);
    }

    public void writeContent(String fileName) throws IOException {
        boolean doLoop = true;
        Scanner userInputScanner = new Scanner(System.in);
        int lineCount = 1;


        Path filePath = Path.of(DEFAULT_WRITING_PATH + "/" + fileName);
        System.out.println(filePath);

        try {

            File CSVFile = Files.createFile(filePath).toFile();
            FileWriter fileWriter = new FileWriter(CSVFile);

            System.out.println("Defina as colunas iniciais do arquivo (separadas por espaço): ");
            String headerLine = userInputScanner.nextLine().trim();
            String[] columns = headerLine.split("\\s+");
            fileWriter.write(String.join(",", columns) + "\n");


            System.out.println("Para sair do arquivo digite enter sem nenhum conteúdo.");
            while (doLoop) {
                System.out.print(lineCount + " >> ");
                String line = userInputScanner.nextLine().trim();

                if (line.isEmpty()) {
                    doLoop = false;
                } else {
                    fileWriter.write(line.replace(" ", ",") + "\n");
                    lineCount++;
                }
            }
            fileWriter.close();
            System.out.println("Arquivo CSV criado com sucesso em: " + filePath);

        }
        catch (IOException exception) {
            System.out.println("Houve um erro na escrita do arquivo.");
        }
    }

}

