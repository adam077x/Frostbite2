package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.UpdateEvent;
import me.adam077x.frostbite.module.Module;

public class Fly extends Module{

	public Fly() {
		super(Keyboard.KEY_F, "Fly");
	}

	@Override
	public void onEnable() {
		super.onEnable();
	}

	@Override
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		super.onDisable();
	}
	
	public void onEvent(Event e) {
		if(!isToggled()) return;
		
		if(e instanceof UpdateEvent) {
			mc.thePlayer.capabilities.isFlying = true;
		}
	}
}
