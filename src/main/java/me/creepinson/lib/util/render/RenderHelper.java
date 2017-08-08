package me.creepinson.lib.util.render;

import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.player.EntityPlayer;

@SuppressWarnings("rawtypes")
public class RenderHelper {


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

//
//    public boolean isDisguiseActive(EntityPlayer p) {
//        return p. != RenderDisguises.player;
//    }



}


