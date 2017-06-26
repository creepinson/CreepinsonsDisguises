package me.creepinson.lib.util.render;

import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.renderer.entity.RenderLivingBase;

public class RenderHelper
{
    public static int playerid;
    public static RenderDisguises disguises = new RenderDisguises();

    public static RenderLivingBase currentRender;

    public static RenderLivingBase getRenderFromID(int id)
    {
        switch (id)
        {
        case 0:
            return RenderDisguises.player;
        case 1:
            return RenderDisguises.pig;
        case 2:
            return RenderDisguises.creeper;
        default:
            return RenderDisguises.player;
        }
    }

}
