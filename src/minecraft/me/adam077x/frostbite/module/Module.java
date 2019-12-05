package me.adam077x.frostbite.module;

import me.adam077x.frostbite.event.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Module {
	private int key;
	private String name;
	private boolean toggled;
	private Category category;
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
	
	public Module(int key, String name, Category category) {
		this.key = key;
		this.name = name;
		this.category = category;
		toggled = false;
	}
	
	public void onEnable() {}
	public void onDisable() {}
	public void onEvent(Event e) {}
	
	public void toggleModule() {
		toggled = !toggled;
		if(toggled) onEnable(); else onDisable();
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public boolean isToggled() {
		return toggled;
	}

	public Category getCategory() {
		return category;
	}
}
