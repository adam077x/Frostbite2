package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.UpdateEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends Module {

	public NoFall() {
		super(Keyboard.KEY_1, "Nofall", Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
		public void onEvent(Event e)
		{
			if(!isToggled())return;
			if(!(e instanceof UpdateEvent)) return;
			if(mc.thePlayer.fallDistance > 2)
			{
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
		}
}
