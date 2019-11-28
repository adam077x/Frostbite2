package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.UpdateEvent;
import me.adam077x.frostbite.module.Module;

public class WaterWalk extends Module{

	public WaterWalk() {
		super(Keyboard.KEY_J, "WaterWalk");
	}
	
	public void onEvent(Event e) {
		if(!isToggled()) return;
		
		if(mc.thePlayer.isInWater()) {
			mc.thePlayer.onGround = true;
			mc.thePlayer.isAirBorne = true;
			mc.thePlayer.motionY = 0.05f;
		}
	}
}
