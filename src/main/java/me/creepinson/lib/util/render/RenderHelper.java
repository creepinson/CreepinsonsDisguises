package me.creepinson.lib.util.render;

import me.creepinson.lib.util.Utils;
import me.creepinson.render.disguise.RenderDisguise;
import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class RenderHelper {
    public static int playerid;
    public static RenderDisguises disguises = new RenderDisguises();
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


