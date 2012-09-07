package com.joepritzel.cis269.assignment1.ann;

import java.lang.annotation.*;

/**
 * Use only when you want a menu's display method to be printed with print
 * rather than println.
 * 
 * @author Joe Pritzel
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Print {

}
