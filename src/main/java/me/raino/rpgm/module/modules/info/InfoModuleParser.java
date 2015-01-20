package me.raino.rpgm.module.modules.info;

import me.raino.rpgm.module.Module;
import me.raino.rpgm.module.ModuleManager;
import me.raino.rpgm.module.ModuleParser;
import org.jdom2.Document;
import org.jdom2.Element;

public class InfoModuleParser implements ModuleParser {

    @Override
    public Module parse(Document document, ModuleManager moduleManager) throws Exception {
        Element root = document.getRootElement();
        String name = root.getChildTextNormalize("name");
        String version = root.getChildTextNormalize("version");
        String objective = root.getChildTextNormalize("objective");
        //TODO: the rest
        return new MapInfo(name, version, objective);
    }
}
