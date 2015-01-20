package me.raino.rpgm.module;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

public class ModuleRegistry {

    private List<ModuleContainer> modules;

    public ModuleRegistry() {
        this.modules = Lists.newArrayList();
    }

    public void register(Class<? extends Module> module) {
        modules.add(ModuleContainer.fromClass(module));
    }

    public List<ModuleContainer> getModules() {
        return ImmutableList.copyOf(modules);
    }

}
