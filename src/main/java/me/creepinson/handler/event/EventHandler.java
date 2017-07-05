package me.creepinson.handler.event;

import me.creepinson.capability.DisguiseProvider;
import me.creepinson.capability.IDisguise;
import me.creepinson.lib.proxy.ClientProxy;
import me.creepinson.lib.util.Utils;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {



    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {

        if (!(event.getObject() instanceof EntityPlayer)) {
            return;
        }

        if (event.getObject().hasCapability(DisguiseProvider.DISGUISE, null)) {
            System.out.println("Player already has capability");
            return;
        }
        event.addCapability(new ResourceLocation(Utils.MODID, "disguisecapability"), new DisguiseProvider());

    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();

        IDisguise render = player.getCapability(DisguiseProvider.DISGUISE, null);

        IDisguise oldRender = event.getOriginal().getCapability(DisguiseProvider.DISGUISE, null);

        if (event.isWasDeath()) {
            render.setDisguiseID(oldRender.getDisguiseID());
        }
    }

}