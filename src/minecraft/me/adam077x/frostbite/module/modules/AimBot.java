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

public class AimBot extends Module
{

	public AimBot() {
		super(Keyboard.KEY_O, "AimBot", Category.COMBAT);
		// TODO Auto-generated constructor stub
		resetTime();
	}
	private EntityLivingBase player = null;
	private long cur,last;
	private int delay = 8;
	public void onEvent(Event e)
	{
		if(!isToggled())return;
		if(!(e instanceof UpdateEvent))return;
		
		player = getCloseTarget(mc.playerController.getBlockReachDistance());
		if(player == null) return;
		
		
		if(cur - last > delay*100)
		{
			lookAt(player);
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
	public void lookAt(EntityLivingBase en)
	{
		//Clone the loc to prevent applied changes to the input loc
		
		
		// Values of change in distance (make it relative)
		double dx = en.getPosition().getX() - mc.thePlayer.getPosition().getX();
		double dy = en.getPosition().getY() - mc.thePlayer.getPosition().getY();
		double dz = en.getPosition().getZ() - mc.thePlayer.getPosition().getZ();
		
		if (dx != 0)
		{
			// Set yaw start value based on dx
			if (dx < 0)
			{
				mc.thePlayer.setRotationYawHead(((float) (1.5 * Math.PI)));
			} else
			{
				mc.thePlayer.setRotationYawHead(((float) (0.5 * Math.PI)));
			}
			mc.thePlayer.setRotationYawHead(((float) mc.thePlayer.rotationYaw - (float) Math.atan(dz / dx)));
		} else if (dz < 0)
		{
			mc.thePlayer.setRotationYawHead(((float) Math.PI));;
		}

		// Get the distance from dx/dz
		double dxz = Math.sqrt(Math.pow(dx, 2) + Math.pow(dz, 2));

		// Set pitch
		mc.thePlayer.setPositionAndRotation(mc.thePlayer.getPosition().getX(), mc.thePlayer.getPosition().getY(), mc.thePlayer.getPosition().getZ(), mc.thePlayer.rotationYaw, ((float) -Math.atan(dy / dxz)));

		// Set values, convert to degrees (invert the yaw since Bukkit uses a different yaw dimension format)
		mc.thePlayer.setRotationYawHead((-mc.thePlayer.rotationYaw * 180f / (float) Math.PI));
		mc.thePlayer.setRotationYawHead((mc.thePlayer.rotationPitch * 180f / (float) Math.PI));
		
	}
	
	public EntityLivingBase getCloseTarget(double range)
	{
		double dist = range;
		EntityLivingBase target = null;
		for(Object o : mc.theWorld.loadedEntityList)
		{
			Entity en = (Entity)o;
			if(en instanceof EntityLivingBase)
			{
				EntityLivingBase player = (EntityLivingBase)en;
			
					if(player != mc.thePlayer) {
					//if(!(player instanceof EntityMob) && !(player instanceof EntityAnimal))
					//{
						double curdist = mc.thePlayer.getDistanceToEntity(player);
						if(curdist <= dist)
						{
							dist = curdist;
							target = player;
						}
					}
						
					//}
			}
		}
		System.out.print(target);
		return target;
	
	}
}
