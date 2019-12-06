package me.adam077x.frostbite.module.modules;



import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.UpdateEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;

public class Sprint extends Module {

	public Sprint() {
		super(Keyboard.KEY_M, "Sprint", Category.PLAYER);
	}
	public void onEnable() {mc.thePlayer.setSprinting(true);}
	public void onDisable() {mc.thePlayer.setSprinting(false);}
	public void onEvent(Event e) {
		
		if(!isToggled()) return;
		if(!(e instanceof UpdateEvent))
			return;
		
		if(!mc.thePlayer.isSprinting())
		{
			mc.thePlayer.setSprinting(true);
		}
	}
	

}
