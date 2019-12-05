package me.adam077x.frostbite.command;

public abstract class Command {
	public String cmd;
	
	public Command(String cmd) {
		this.cmd = cmd;
	}
	
	public abstract void onCommand(String args); 
}
