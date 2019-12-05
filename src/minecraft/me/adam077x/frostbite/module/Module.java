package me.adam077x.frostbite.module;

import me.adam077x.frostbite.event.Event;
import net.minecraft.client.Minecraft;

public class Module {
	private int key;
	private String name;
	private boolean toggled;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public Module(int key, String name) {
		this.key = key;
		this.name = name;
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
}
