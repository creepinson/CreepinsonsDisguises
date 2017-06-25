package me.creepinson.lib.util.render;

import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class RenderHelper {
public static int playerid;
public static RenderDisguises disguises = new RenderDisguises();

public static RenderLivingBase currentRender;

public static RenderLivingBase getRenderFromID (int id){
	
	switch(id) {
	
	case 0:
		return disguises.player;
	
	case 1:
		return disguises.pig;
	case 2:
		return disguises.creeper;
	default:
		return disguises.player;
	
	
	}
	
	
	
}



}
