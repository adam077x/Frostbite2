package me.adam077x.frostbite.command;

import java.util.ArrayList;

import me.adam077x.frostbite.command.commands.ToggleCommand;

public class CommandManager {
	public static final ArrayList<Command> commands = new ArrayList<Command>();
	
	public void registerCommands() {
		commands.add(new ToggleCommand());
	}
	
	public boolean onCommand(String msg) {
		String processedMsg = msg;
		if(processedMsg.startsWith(".")) {
			processedMsg = processedMsg.substring(1);
			System.out.println(processedMsg);
		}
		for(int i = 0; i < commands.size(); i++) {
			Command c = commands.get(i);
			
			if(processedMsg.startsWith(c.cmd)) {
				processedMsg = processedMsg.substring(c.cmd.length()+1);
				System.out.println(processedMsg);
				c.onCommand(processedMsg);
				return true;
			}
		}
		return false;
	}
}
