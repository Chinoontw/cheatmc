package com.example.esp;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.MinecraftForge;

@Mod(modid = ESPMod.MODID, name = ESPMod.NAME, version = ESPMod.VERSION)
public class ESPMod {

    public static final String MODID = "espmod";
    public static final String NAME = "ESP Mod";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Enregistrer les gestionnaires
        MinecraftForge.EVENT_BUS.register(new AimbotHandler()); // Pour l'aimbot
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler()); // Pour l'entrée clavier (menu)
        MinecraftForge.EVENT_BUS.register(new ESPHandler()); // Pour l'ESP si nécessaire
    }
}
