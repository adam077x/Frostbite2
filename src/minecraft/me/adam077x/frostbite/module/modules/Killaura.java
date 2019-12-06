package me.adam077x.frostbite.module.modules;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.UpdateEvent;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;

public class Killaura extends Module
{

	private EntityLivingBase playerTarget;
	private long cur, last;
	private float pitch,yaw;
	private double delay;
	public Killaura() {
		super(Keyboard.KEY_R, "Killaura", Category.COMBAT);
		resetTime();
	}
	public void onEvent(Event e)
	{
		if(!isToggled())return;
		if(!(e instanceof UpdateEvent)) return;
		playerTarget = getCloseTarget(mc.playerController.getBlockReachDistance());
		if(playerTarget == null)return;
		
		updateDamageTime();	
		yaw = mc.thePlayer.prevRotationYaw;
		pitch = mc.thePlayer.prevRotationPitch;

		if(cur - last > delay*100)
		{
			attack(playerTarget);
			resetTime();
		}
	}
	public void updateDamageTime()
	{
		cur = System.currentTimeMillis();
	}
	public void resetTime()
	{
		last = System.currentTimeMillis();
	}
	public boolean canAttack(EntityLivingBase player)
	{
		return(player != mc.thePlayer && player.isEntityAlive() && mc.thePlayer.getDistanceToEntity(player) <= mc.playerController.getBlockReachDistance() && player.ticksExisted > 30);
	}
	public void attack(EntityLivingBase player)
	{
		if(player == null)
			return;
		mc.thePlayer.swingItem();
		mc.playerController.attackEntity(mc.thePlayer, player);
		mc.thePlayer.rotationYaw = yaw;
		mc.thePlayer.rotationPitch = pitch;
		mc.thePlayer.setRotationYawHead(yaw);
		mc.thePlayer.rotationPitch = pitch;
	}
	public EntityLivingBase getCloseTarget(double range)
	{
		double dist = range;
		EntityLivingBase target = null;
		if(mc.theWorld.loadedEntityList.size() == 0)
			return null;
		System.out.println(mc.theWorld.loadedEntityList.size());
		for(Object o : mc.theWorld.loadedEntityList)
		{
			Entity en = (Entity)o;
			if(en instanceof EntityLivingBase)
			{
				EntityLivingBase player = (EntityLivingBase)en;
				if(canAttack(player))
				{
					//!(player instanceof EntityMob) && !(player instanceof EntityAnimal)
					if(true)
					{
						double curdist = mc.thePlayer.getDistanceToEntity(player);
						if(curdist <= dist)
						{
							dist = curdist;
							target = player;
						}
						
					}
					
				}
			}
		}

		return target;
	
	}
	
}
	