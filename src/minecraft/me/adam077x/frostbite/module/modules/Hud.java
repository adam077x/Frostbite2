package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.Frostbite;
import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.RenderEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.module.ModuleManager;

public class Hud extends Module{

	public Hud() {
		super(Keyboard.KEY_H, "Hud", Category.MISC);
	}
	
	public void onEvent(Event e) {
		if(!isToggled()) return;
		
		if(e instanceof RenderEvent) {
			((RenderEvent) e).fr.drawStringWithShadow(Frostbite.getClientFullName(), 5, 5, 0xffffff);
			int yPos = 0;
			
			for(Module m : ModuleManager.modules) {
				if(m.isToggled()) {
					((RenderEvent) e).fr.drawStringWithShadow(m.getName(), 5, yPos * 8+14, 0x00ff00);
					yPos++;
				}
			}
		}
	}
}
