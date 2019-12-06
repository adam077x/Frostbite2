package me.adam077x.frostbite.clickgui;

import net.minecraft.client.gui.GuiScreen;

public class DraggableBox {
	public int x, y, width, height, color;
	private boolean dragged;
	
	public DraggableBox(int x, int y, int width, int height, int color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		dragged = false;
	}
	
	public void dragged(int mouseX, int mouseY) {
		if(dragged) {
			x += mouseX - x;
			y += mouseY - y;
		}
	}
	
	public void render(GuiScreen gui) {
		gui.drawRect(x, y, x+width, y+height, color);
	}
	
	public void mouseClicked() {
		dragged = true;
	}
	
	public void mouseReleased() {
		dragged = false;
	}
}
