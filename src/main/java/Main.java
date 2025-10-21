import Modules.Components.Utils.MethodExecutor;

import java.util.Scanner;

public class Main {

    private static boolean doLoop = true;
    private static MethodExecutor methodExecutor = new MethodExecutor();

    public static void main(String[] args){
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║               Projeto de Bloco - CLI                   ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║                Módulos Disponíveis                     ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ [CSV/csv] -> Digite 'csv' para ver os comandos         ║");
        System.out.println("║                   disponíveis para esse módulo         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        while (doLoop){
            System.out.print(">> ");
            String userInput = userInputScanner.nextLine();

            if (userInput.equals("exit")){
                doLoop = false;
                System.out.println("\nAdeus!\n");
            }
            else {
                methodExecutor.findAndCallMethod(userInput);
            }
        }

    }

}
