package com.adroit.data.configuration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;

/**
 * This annotation serves as the entry point to scan the package underneath
 * com.adroit.data
 * 
 * @author Adroit
 *
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(value = "com.adroit.data")
public @interface EnableStoreProcedure {

}
