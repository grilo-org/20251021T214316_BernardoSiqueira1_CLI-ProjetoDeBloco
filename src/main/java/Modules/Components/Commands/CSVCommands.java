package Modules.Components.Commands;


import Modules.Components.Annotations.Command;
import Modules.Components.Utils.CSVBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CSVCommands {

    private Scanner userInputScanner = new Scanner(System.in);
    private CSVBuilder csvBuilder = new CSVBuilder();

    @Command(commandName = "csv", instanceClass = CSVCommands.class)
    public void printCSVHelpMessage(){
        System.out.println("\n\n");
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                      Módulo CSV                        ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║                       Comandos                         ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ * csv -> mostra todos os comandos csv disponíveis      ║");
        System.out.println("║ * csv create -> inicia a criação de um arquivo .csv    ║");
        System.out.println("║ * csv import -> importa e lê um arquivo .csv           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("\n\n");
    }

    @Command(commandName = "csv import", instanceClass = CSVCommands.class)
    public void csvImport() throws IOException {
        System.out.println("Digite o caminho do arquivo: ");
        Path userPathInput = Path.of(userInputScanner.nextLine());
        try{
            List<String> fileContent = Files.readAllLines(userPathInput);
            csvBuilder.buildContent(fileContent);
        }
        catch (IOException exception){
            System.out.println("Não foi possível ler o arquivo selecionado.");
        }
    }

    @Command(commandName = "csv create", instanceClass = CSVCommands.class)
    public void csvCreate() throws IOException {

        System.out.print("Digite o nome do arquivo para ser salvo:");
        String fileName = userInputScanner.nextLine();

        csvBuilder.writeContent(fileName);
    }
}
