package com.example.esp;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

import java.io.IOException;

public class ModGuiScreen extends GuiScreen {

    @Override
    public void initGui() {
        this.buttonList.clear();
        // Ajouter des boutons
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 50, "Toggle Aimbot: " + (ModSettings.aimbotEnabled ? "ON" : "OFF")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2, "Toggle ESP: " + (ModSettings.espEnabled ? "ON" : "OFF")));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 2 + 50, I18n.format("menu.returnToGame")));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case 0: // Toggle Aimbot
                ModSettings.aimbotEnabled = !ModSettings.aimbotEnabled;
                button.displayString = "Toggle Aimbot: " + (ModSettings.aimbotEnabled ? "ON" : "OFF");
                break;
            case 1: // Toggle ESP
                ModSettings.espEnabled = !ModSettings.espEnabled;
                button.displayString = "Toggle ESP: " + (ModSettings.espEnabled ? "ON" : "OFF");
                break;
            case 2: // Retour au jeu
                this.mc.displayGuiScreen(null);
                break;
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true; // Met le jeu en pause
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Mod Configuration", this.width / 2, this.height / 2 - 80, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
