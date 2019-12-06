package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;

public class FullBright extends Module
{
	private float old;

	public FullBright() {
		super(Keyboard.KEY_0, "FullBright", Category.MISC);
		// TODO Auto-generated constructor stub
	}
	public void onEnable()
	{
		old = mc.gameSettings.gammaSetting;
		mc.gameSettings.gammaSetting = 10f;
	}
	public void onDisable()
	{
		mc.gameSettings.gammaSetting = old;
	}

}
