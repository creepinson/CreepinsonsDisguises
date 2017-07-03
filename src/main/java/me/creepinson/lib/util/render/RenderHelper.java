package me.creepinson.lib.util.render;

import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.renderer.entity.RenderLivingBase;

@SuppressWarnings("rawtypes")
public class RenderHelper {
    public static int playerid;
    public RenderLivingBase currentRender;

    public static RenderLivingBase getRenderFromID(int id) {
        switch (id) {
            case 0:
                return RenderDisguises.player;
            case 1:
                return RenderDisguises.pig;
            case 2:
                return RenderDisguises.creeper;
            case 3:
                return RenderDisguises.enderman;
            default:
                return RenderDisguises.player;
        }
    }


    public boolean isDisguiseActive() {
        return currentRender != RenderDisguises.player;
    }
}


