package me.raino.rpgm;

import me.raino.rpgm.module.ModuleManager;
import me.raino.rpgm.module.ModuleRegistry;
import me.raino.rpgm.module.modules.info.MapInfo;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

public class ModuleTest {

    private Document getDocument() {
        try {
            return new SAXBuilder().build(new StringReader("<map><name>Test Map</name><version>1.0.0</version><objective>have fun</objective></map>"));
        } catch (JDOMException | IOException e) {
            return null;
        }
    }

    @Test
    public void testMapInfo() {
        ModuleRegistry registry = new ModuleRegistry();
        registry.register(MapInfo.class);

        ModuleManager manager = new ModuleManager(registry, getDocument());

        MapInfo mapInfo = manager.getModule(MapInfo.class);

        Assert.assertTrue("has module", manager.hasModule(MapInfo.class));
        Assert.assertEquals("name", "Test Map", mapInfo.getName());
        Assert.assertEquals("version", "1.0.0", mapInfo.getVersion());
        Assert.assertEquals("objective", "have fun", mapInfo.getObjective());
    }

}
