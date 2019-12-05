package me.adam077x.frostbite.command.commands;

import me.adam077x.frostbite.command.Command;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.module.ModuleManager;

public class ToggleCommand extends Command{

	public ToggleCommand() {
		super("t");
	}

	@Override
	public void onCommand(String args) {
		for(int i = 0; i < ModuleManager.modules.size(); i++) {
			Module m = ModuleManager.modules.get(i);
			if(m.getName().equalsIgnoreCase(args)) {
				m.toggleModule();
			}
		}
	}

}
