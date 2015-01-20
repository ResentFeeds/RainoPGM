package me.raino.rpgm.module;

import org.jdom2.Document;

public interface ModuleParser {

    public Module parse(Document document, ModuleManager moduleManager) throws Exception;

}

