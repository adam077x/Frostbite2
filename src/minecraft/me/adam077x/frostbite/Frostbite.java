package me.adam077x.frostbite;

import me.adam077x.frostbite.command.CommandManager;
import me.adam077x.frostbite.module.ModuleManager;

public class Frostbite {
	public static final boolean prerelease = true;
	public static ModuleManager moduleManager = new ModuleManager();
	public static CommandManager commandManager = new CommandManager();
	
	public void startClient() {
		moduleManager.registerModules();
		commandManager.registerCommands();
	}
	
	public static String getClientName() {
		return "Frostbite";
	}
	
	public static String getClientVersion() {
		if(prerelease) {
			return "2.0pre";
		}
		return "2.0";
	}
	
	public static String getClientFullName() {
		return getClientName() + " " + getClientVersion();
	}
}
