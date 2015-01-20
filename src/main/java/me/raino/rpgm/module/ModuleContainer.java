package me.raino.rpgm.module;

import com.google.common.collect.Maps;

import java.util.Map;

public class ModuleContainer {

    private static Map<Class<? extends Module>, ModuleContainer> cache = Maps.newHashMap();

    private ModuleInfo info;
    private ModuleParser parser;

    private ModuleContainer(Class<? extends Module> moduleClass) {
        this.info = moduleClass.getAnnotation(ModuleInfo.class);
        if (info == null) throw new RuntimeException("Module '" + moduleClass.getSimpleName() + "' is missing ModuleInfo annotation");
        try {
            this.parser = info.parser().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Could not create parser for module '" + info.name() + "', no empty constructor found", e);
        }
    }

    public ModuleParser getParser() {
        return parser;
    }

    public ModuleInfo getInfo() {
        return info;
    }

    public static ModuleContainer fromClass(Class<? extends Module> moduleClass) {
        ModuleContainer container = cache.get(moduleClass);
        if (container == null) {
            container = new ModuleContainer(moduleClass);
            cache.put(moduleClass, container);
        }
        return container;
    }

}
