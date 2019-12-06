package me.adam077x.frostbite.clickgui;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.RenderEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen {
	public static final ArrayList<DraggableBox> draggableBoxes = new ArrayList<DraggableBox>();
	
	public ClickGui() {
		draggableBoxes.add(new DraggableBox(10, 100, 80, 100, 0x99000000, "PLAYER", Category.PLAYER));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		for(int i = 0; i < draggableBoxes.size(); i++) {
			draggableBoxes.get(i).render(this);
			draggableBoxes.get(i).dragged(mouseX, mouseY);
		}
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

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if(mouseButton == 0) {
			for(int i = 0; i < draggableBoxes.size(); i++) {
				DraggableBox db = draggableBoxes.get(i);
				if(mouseX >= db.x && mouseY >= db.y && mouseX < db.x + db.width && mouseY < db.y + db.height) {
					db.mouseClicked();
				}
			}
		}
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		if(state == 0) {
			for(int i = 0; i < draggableBoxes.size(); i++) {
				DraggableBox db = draggableBoxes.get(i);
				if(db.dragged) {
					db.mouseReleased();
				}
			}
		}
	} 
}
