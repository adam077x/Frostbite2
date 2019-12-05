package me.adam077x.frostbite.clickgui;

import net.minecraft.client.gui.Gui;

public class DraggableBox {
	public int x, y, width, height, color;
	
	public DraggableBox(int x, int y, int width, int height, int color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void dragged(int mouseX, int mouseY) {
		x += mouseX - x;
		y += mouseY - y;
	}
	
	public void render() {
		Gui.drawRect(x, y, x+width, y+height, color);
	}
}
