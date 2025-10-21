package Modules.Components.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MessageComponent {
    String messageName();
    Class<?> instanceClass();
}
