package me.creepinson.lib.util.render;

import me.creepinson.render.disguise.RenderDisguise;
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
            case 3:
            return RenderDisguises.enderman;
        default:
            return RenderDisguises.player;
        }
    }

    public static boolean isDisguiseActive(){

        return currentRender != RenderDisguises.player;

        }

    public static boolean isDisguiseActive(RenderDisguise disguise){

        if(disguise == RenderDisguises.creeper) {

            return true;

        }
        if(disguise == RenderDisguises.enderman) {

            return true;

        }
         if (disguise == RenderDisguises.pig){

            return true;

        }

    else {

             return false;

         }

    }



    }


