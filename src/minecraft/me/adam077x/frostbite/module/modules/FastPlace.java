package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;

public class FastPlace extends Module{

	public FastPlace() {
		super(Keyboard.KEY_C, "FastPlace", Category.PLAYER);
	}
	
	public void onEvent(Event e) {
		if(!isToggled()) return;
		
		mc.rightClickDelayTimer = 0;
	}
	
	public void onDisable() {
		mc.rightClickDelayTimer = 6;
	}

}
