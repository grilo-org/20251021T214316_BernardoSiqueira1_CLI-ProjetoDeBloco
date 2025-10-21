package Modules.Components.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodExecutor {
    private final MethodLoader METHOD_LOADER = new MethodLoader();

    public void findAndCallMethod(String userInput){

            try {
                Method method =  this.METHOD_LOADER.getMethods().get(userInput);

                if (method != null) {
                    Object instance = method.getDeclaringClass().getDeclaredConstructor().newInstance();
                    method.invoke(instance);
                }

                else {
                    System.out.println("Comando não encontrado, digite 'help' para encontrar os módulos disponíveis.");
                }

            }

            catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                   InstantiationException exception){
                exception.printStackTrace();
            }

            catch (NullPointerException exception){
                exception.fillInStackTrace();
                exception.printStackTrace();
                System.out.println("\nAlgum método do CLI não foi anotado com @Command, verifique as classes do projeto.");
            }

    }
}
