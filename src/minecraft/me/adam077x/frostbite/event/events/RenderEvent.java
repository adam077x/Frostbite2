package me.adam077x.frostbite.event.events;

import me.adam077x.frostbite.event.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class RenderEvent extends Event{
	public FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
}
