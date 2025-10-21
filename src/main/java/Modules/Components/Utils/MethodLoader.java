package Modules.Components.Utils;

import Modules.Components.Annotations.Command;
import Modules.Components.Commands.CSVCommands;
import Modules.Components.Commands.MenuCommands;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class MethodLoader {

    private HashMap<String, Method> availableMethods = new HashMap<>();

    public HashMap<String, Method> getMethods(){
        return availableMethods;
    }

    private void loadMethods(){
        availableMethods.putAll(mapMethods(CSVCommands.class));
        availableMethods.putAll(mapMethods(MenuCommands.class));
    }

    private Map<String, Method> mapMethods(Class<?> componentClass) {
        return Arrays.stream(componentClass
                        .getDeclaredMethods())
                .collect(Collectors.toMap(
                        method -> method.getAnnotation(Command.class).commandName(),
                        method -> method)
                );
    }

    public MethodLoader(){
        this.loadMethods();
    }

}
