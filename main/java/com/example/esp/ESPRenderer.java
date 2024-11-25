package com.example.esp;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class ESPRenderer {
    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        for (Entity entity : mc.world.loadedEntityList) {
            if (entity == mc.player) continue; // Ignore le joueur local

            double x = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * event.getPartialTicks() - mc.getRenderManager().viewerPosX;
            double y = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * event.getPartialTicks() - mc.getRenderManager().viewerPosY;
            double z = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * event.getPartialTicks() - mc.getRenderManager().viewerPosZ;

            GlStateManager.pushMatrix();
            GlStateManager.disableTexture2D();
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            GlStateManager.glLineWidth(2.0F);
            GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F); // Couleur rouge semi-transparente

            RenderGlobal.drawBoundingBox(
                    x - 0.5, y, z - 0.5, // Point inférieur gauche
                    x + 0.5, y + 1.8, z + 0.5, // Point supérieur droit
                    1.0F, 0.0F, 0.0F, 0.5F // Couleur RGBA
            );

            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.popMatrix();
        }
    }
}
