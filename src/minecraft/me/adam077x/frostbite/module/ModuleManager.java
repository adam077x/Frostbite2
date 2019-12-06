package me.adam077x.frostbite.module;

import java.util.ArrayList;

import me.adam077x.frostbite.module.modules.AimBot;
import me.adam077x.frostbite.module.modules.AntiBot;
import me.adam077x.frostbite.module.modules.ClickGuiModule;
import me.adam077x.frostbite.module.modules.ESP;
import me.adam077x.frostbite.module.modules.FastPlace;
import me.adam077x.frostbite.module.modules.Fly;
import me.adam077x.frostbite.module.modules.FullBright;
import me.adam077x.frostbite.module.modules.Hud;
import me.adam077x.frostbite.module.modules.Killaura;
import me.adam077x.frostbite.module.modules.NoFall;
import me.adam077x.frostbite.module.modules.Reach;
import me.adam077x.frostbite.module.modules.Sprint;
import me.adam077x.frostbite.module.modules.WaterWalk;

public class ModuleManager {
	public static final ArrayList<Module> modules = new ArrayList<Module>();
	
	public void registerModules() {
		modules.add(new Fly());
		modules.add(new Hud());
		modules.add(new FastPlace());
		modules.add(new WaterWalk());
		modules.add(new ClickGuiModule());
		modules.add(new AimBot());
		modules.add(new AntiBot());
		modules.add(new ESP());
		modules.add(new FullBright());
		modules.add(new Killaura());
		modules.add(new NoFall());
		modules.add(new Reach());
		modules.add(new Sprint());
		
	}
}
