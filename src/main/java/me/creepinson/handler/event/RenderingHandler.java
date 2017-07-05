package me.creepinson.handler.event;

import me.creepinson.capability.DisguiseProvider;
import me.creepinson.capability.IDisguise;
import me.creepinson.lib.proxy.ClientProxy;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Creepinson on 7/4/2017.
 */
public class RenderingHandler {

    @SuppressWarnings("unchecked")
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void playerRenderPre(RenderPlayerEvent.Pre event) {
        EntityPlayer player = event.getEntityPlayer();
        Entity entity = event.getEntity();
        IDisguise playerCap = player.getCapability(DisguiseProvider.DISGUISE, null);
        if (playerCap != null) {
            ModelPlayer model = event.getRenderer().getMainModel();
            RenderPlayer renderP = (RenderPlayer) event.getRenderer();
            event.setCanceled(true);
            if (ClientProxy.renderUtils.currentRender == RenderDisguises.enderman) {
                player.eyeHeight = 2.62f;
            } else {
                player.eyeHeight = 1.62f;
            }
            ClientProxy.renderUtils.currentRender = RenderHelper.getRenderFromID(playerCap.getDisguiseID());
            if (ClientProxy.renderUtils.currentRender != null)
                ClientProxy.renderUtils.currentRender.doRender((EntityLivingBase) player, 0, 0, 0, 0, 1);
        }

    }



}
