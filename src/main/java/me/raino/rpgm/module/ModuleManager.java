package me.raino.rpgm.module;

import com.google.common.collect.Lists;
import me.raino.rpgm.RPGM;
import org.jdom2.Document;

import java.util.List;

public class ModuleManager {


    private List<Module> modules;

    public ModuleManager(ModuleRegistry registry, Document document) {
        this.modules = Lists.newArrayList();

        for (ModuleContainer container : registry.getModules()) {
            ModuleParser parser = container.getParser();
            Module module = null;
            try {
                module = parser.parse(document, this);
            } catch (Exception e) {
                RPGM.get().getLogger().warning("Could not load module '" + container.getInfo().name() + "' for document '" + document.getBaseURI() + "': " + e.getMessage());
            }
            modules.add(module);
        }
    }

    public <M extends Module> M getModule(Class<M> moduleClass) {
        for (Module module : modules)
            if (moduleClass.isInstance(module))
                return moduleClass.cast(module);
        return null;
    }

    public boolean hasModule(Class<? extends Module> moduleClass) {
        return getModule(moduleClass) != null;
    }

}
