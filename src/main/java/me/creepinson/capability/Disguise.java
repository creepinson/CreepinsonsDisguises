package me.creepinson.capability;

import net.minecraft.client.renderer.entity.RenderLivingBase;

public class Disguise  implements IDisguise
{
protected int id;

@Override
public int getID() 
{
	return id;
}

@Override
public void setID(int id) 
{
	this.id = id;
}
}