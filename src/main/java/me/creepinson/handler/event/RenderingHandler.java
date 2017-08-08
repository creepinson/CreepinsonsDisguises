package me.creepinson.handler.event;

import me.creepinson.capability.DisguiseProvider;
import me.creepinson.capability.IDisguise;
import me.creepinson.lib.proxy.ClientProxy;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.render.disguise.RenderDisguise;
import me.creepinson.render.disguise.RenderDisguises;
import me.creepinson.st.Events;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Creepinson on 7/4/2017.
 */
@SideOnly(Side.CLIENT
)

public class RenderingHandler {

    @SuppressWarnings("unchecked")
    @SubscribeEvent(priority = EventPriority.HIGHEST)

    public void playerRenderPre(RenderLivingEvent.Pre<EntityLivingBase> event) {

        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            IDisguise playerCap = player.getCapability(DisguiseProvider.DISGUISE, null);
            if (playerCap != null) {


                event.setCanceled(true);
                if (playerCap.getDisguiseID() == 3) {
                    player.eyeHeight = 2.62f;
                } else {
                    player.eyeHeight = 1.62f;
                }

                RenderHelper.getRenderFromID(playerCap.getDisguiseID()).doRender((EntityLivingBase) player, 0, 0, 0, ((EntityLivingBase) player).rotationYaw, 1);

            }
        }
    }


    public void playerRenderPre(Events.Render.RenderCustomLivingEvent.Pre<EntityLivingBase> event) {

        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            IDisguise playerCap = player.getCapability(DisguiseProvider.DISGUISE, null);
            if (playerCap != null) {


                event.setCanceled(true);
                if (playerCap.getDisguiseID() == 3) {
                    player.eyeHeight = 2.62f;
                } else {
                    player.eyeHeight = 1.62f;
                }

                RenderHelper.getRenderFromID(playerCap.getDisguiseID()).doRender((EntityLivingBase) player, 0, 0, 0, ((EntityLivingBase) player).rotationYaw, 1);

            }
        }
    }

}
