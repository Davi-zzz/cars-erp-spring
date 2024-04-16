package com.example.apollo.utils.annotations;

import java.lang.annotation.*;

/**
 * Demarques an indentifier
 * 
 * This annotation can be used in place of "@Id".
 * 
 * @param name The field name to be used. Default: id
 */
// @Persistent
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UUID {
    String name() default "id";

}
