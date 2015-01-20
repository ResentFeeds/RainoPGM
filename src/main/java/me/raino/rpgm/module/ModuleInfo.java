package me.raino.rpgm.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInfo {

    public String name();

    public Class<? extends ModuleParser> parser();

    public boolean required() default false;

    public Class<? extends Module>[] depends() default {};

}
