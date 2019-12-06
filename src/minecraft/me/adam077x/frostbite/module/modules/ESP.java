package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.RenderEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import net.minecraft.entity.EntityLiving;

public class ESP extends Module{

	public ESP() {
		super(Keyboard.KEY_P, "ESP", Category.RENDER);
	}
	public void onEvent(Event e) {
	
		if(!isToggled()) return;
		if(e instanceof RenderEvent)
		{
			
		}
	}
	
	public void getPlayer(EntityLiving e)
	{
		
	}

}
