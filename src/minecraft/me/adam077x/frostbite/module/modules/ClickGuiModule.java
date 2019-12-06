package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.clickgui.ClickGui;
import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.RenderEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;

public class ClickGuiModule extends Module{
	private ClickGui clickGui = new ClickGui();
	
	public ClickGuiModule() {
		super(Keyboard.KEY_RSHIFT, "ClickGui", Category.MISC);
	}
	
	@Override
	public void onEnable() {
		mc.displayGuiScreen(clickGui);
	}
}
