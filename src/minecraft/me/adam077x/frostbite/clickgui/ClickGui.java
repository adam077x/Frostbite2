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
	private DraggableBox draggableBox = new DraggableBox(100, 100, 100, 50, 0xaa000000);

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		//drawRect(0, 0, 100, 50, 0xff000000);
		draggableBox.render(this);
		draggableBox.dragged(mouseX, mouseY);
		
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		System.out.println("Action Performed");
	}

	@Override
	public void initGui() {
		
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if(mouseButton == 0) {
			if(mouseX >= draggableBox.x && mouseY >= draggableBox.y && mouseX < draggableBox.x + draggableBox.width && mouseY < draggableBox.y + draggableBox.height) {
				System.out.println(mouseButton);
				draggableBox.mouseClicked();
			}
		}
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		if(state == 0) {
			draggableBox.mouseReleased();
		}
	} 
}
