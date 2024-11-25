package com.example.esp;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLMod;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod("espmod")  // Remplacez "espmod" par l'ID de votre mod
public class EspMod
{
    public EspMod()
    {
        // Enregistrement des événements et des gestionnaires
        IEventBus modEventBus = FMLMod.getModEventBus();

        // Enregistrement du gestionnaire d'événements dans le bus de l'événement FML (pour la partie serveur et client)
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        // Enregistrement du gestionnaire d'événements pour le tick client
        MinecraftForge.EVENT_BUS.register(new AimbotHandler());
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Configuration commune ici (ce qui se passe côté serveur, par exemple)
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        // Configuration côté client ici (par exemple, l'initialisation de certains aspects graphiques ou d'autres ressources)
    }

    // Cette méthode est utilisée pour enregistrer des événements serveur (optionnel pour ce mod)
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Logique de démarrage du serveur si nécessaire
    }

    // Cette méthode est utilisée pour enregistrer des événements clients (optionnel pour ce mod)
    @SubscribeEvent
    public void onClientStarting()
    {
        // Logique de démarrage du client si nécessaire
    }
}
