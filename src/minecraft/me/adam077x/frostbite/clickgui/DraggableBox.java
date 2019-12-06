package me.adam077x.frostbite.clickgui;

import com.mojang.realmsclient.dto.RealmsServer.McoServerComparator;

import me.adam077x.frostbite.module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class DraggableBox {
	public int x, y, width, height, color;
	public String text;
	public Category category;
	public boolean dragged;
	
	public DraggableBox(int x, int y, int width, int height, int color, String text, Category category) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.text = text;
		this.category = category;
		dragged = false;
	}
	
	public void dragged(int mouseX, int mouseY) {
		if(dragged) {
			x += mouseX - x;
			y += mouseY - y;
		}
	}
	
	public void render(GuiScreen gui) {
		gui.drawRect(x, y, x+width, y+10, 0xff000000);
		gui.drawRect(x, y, x+width, y+height, color);
		gui.drawString(Minecraft.getMinecraft().fontRendererObj, text, x+4*text.length(), y+2, 0xffffff);
	}
	
	public void mouseClicked() {
		dragged = true;
	}
	
	public void mouseReleased() {
		dragged = false;
	}
}
