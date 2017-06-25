package me.creepinson.capability;

import net.minecraft.client.renderer.entity.RenderLivingBase;

public class Disguise  implements IDisguise
{
protected int render;

@Override
public int getRender() 
{
	return render;
}

@Override
public void setRender(int render) 
{
	this.render = render;
}
}