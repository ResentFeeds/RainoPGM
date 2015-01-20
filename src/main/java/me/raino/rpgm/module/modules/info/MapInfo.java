package me.raino.rpgm.module.modules.info;

import me.raino.rpgm.module.Module;
import me.raino.rpgm.module.ModuleInfo;

@ModuleInfo(name = "InfoModule", parser = InfoModuleParser.class)
public class MapInfo implements Module {

    private String name;
    private String version;
    private String objective;

    public MapInfo(String name, String version, String objective) {
        this.name = name;
        this.version = version;
        this.objective = objective;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getObjective() {
        return objective;
    }

}
