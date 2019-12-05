package me.adam077x.frostbite.clickgui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.RenderEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen {
	private DraggableBox draggableBox = new DraggableBox(100, 100, 100, 50, 0xff000000);
	
	public void onRender() {
		drawRect(0, 0, 100, 50, 0xff000000);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {

	}

	@Override
	public void initGui() {
		
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
