package Modules.Components.Commands;

import Modules.Components.Annotations.Command;

public class MenuCommands {

    @Command(commandName = "help", instanceClass = MenuCommands.class)
    public void printAvailableCommands(){
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║               Projeto de Bloco - CLI                   ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║                Módulos Disponíveis                     ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ [CSV/csv] -> Digite 'csv' para ver os comandos         ║");
        System.out.println("║                   disponíveis para esse módulo         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }

}
