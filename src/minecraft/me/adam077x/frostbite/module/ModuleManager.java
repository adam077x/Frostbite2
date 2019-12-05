package me.adam077x.frostbite.module;

import java.util.ArrayList;

import me.adam077x.frostbite.clickgui.ClickGui;
import me.adam077x.frostbite.module.modules.ClickGuiModule;
import me.adam077x.frostbite.module.modules.FastPlace;
import me.adam077x.frostbite.module.modules.Fly;
import me.adam077x.frostbite.module.modules.Hud;
import me.adam077x.frostbite.module.modules.WaterWalk;

public class ModuleManager {
	public static final ArrayList<Module> modules = new ArrayList<Module>();
	
	public void registerModules() {
		modules.add(new Fly());
		modules.add(new Hud());
		modules.add(new FastPlace());
		modules.add(new WaterWalk());
		modules.add(new ClickGuiModule());
	}
}
