package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.UpdateEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import net.minecraft.entity.Entity;

public class AntiBot extends Module
{

	public AntiBot() {
		super(Keyboard.KEY_B, "AntiBot", Category.COMBAT);
		// TODO Auto-generated constructor stub
	}
	public void onEvent(Event e)
	{
		if(!isToggled())return;
				if(!(e instanceof UpdateEvent))return;
				
		for(Entity en : mc.theWorld.loadedEntityList)
		{
			if(en.isInvisible() && en != mc.thePlayer )
			{
				mc.theWorld.removeEntity(en);
			}
		}
	}

}
