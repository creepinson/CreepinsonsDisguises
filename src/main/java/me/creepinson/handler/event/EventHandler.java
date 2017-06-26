package me.creepinson.handler.event;

import me.creepinson.capability.DisguiseProvider;
import me.creepinson.capability.IDisguise;
import me.creepinson.lib.util.Utils;
import me.creepinson.lib.util.render.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void playerRenderPre(RenderPlayerEvent.Pre event) {
        EntityPlayer player = event.getEntityPlayer();
        IDisguise render = player.getCapability(DisguiseProvider.DISGUISE, null);
        event.setCanceled(true);
        if(render != null) {
            RenderHelper.currentRender = RenderHelper.getRenderFromID(render.getID());
            RenderHelper.currentRender.doRender((EntityLivingBase) event.getEntity(), 0, 0, 0, 0, 0);
        }
    }

	@SubscribeEvent
	public void playerRenderPost(RenderPlayerEvent.Post event) {
//		RenderHelper.currentRender = RenderHelper.getRenderFromID(0);
//
//		RenderHelper.currentRender.doRender((EntityLivingBase) event.getEntity(), 0, 0, 0, 0, 0);
		//
		// if (Minecraft.getMinecraft().thePlayer.equals(event.getEntity())) {
		//
		// if (RenderHelper.currentRender == null) {
		//
		// RenderHelper.currentRender = RenderHelper.getRenderFromID(0);
		//
		// } else {
		// RenderHelper.currentRender.doRender((EntityLivingBase)
		// event.getEntity(), 0, 0, 0, 0, 0);
		// }
		//
		// }
		//
		// else {
		//
		// if (RenderHelper.currentRender == null) {
		//
		// RenderHelper.currentRender = RenderHelper.getRenderFromID(0);
		//
		// } else {
		// RenderHelper.currentRender.doRender((EntityLivingBase)
		// Minecraft.getMinecraft().thePlayer, 0, 0, 0, 0,
		// 0);
		// }
		//
		// }
		//
		// EntityPlayer player = (EntityPlayer) event.getEntity();
		// EntityLivingBase living = (EntityLivingBase)
		// event.getEntity().getEntityWorld()
		// .getEntityByID(player.getEntityId());

	}

	@SubscribeEvent

	public void attachCapability(AttachCapabilitiesEvent.Entity event)

	{

		if (!(event.getEntity() instanceof EntityPlayer)) {
			return;
		}

		if (event.getEntity().hasCapability(DisguiseProvider.DISGUISE, null)) {
			System.out.println("Player already has capability");
			return;
		}
		event.addCapability(new ResourceLocation(Utils.MODID, "idisguise"), new DisguiseProvider());

	}

	@SubscribeEvent

	public void onPlayerClone(PlayerEvent.Clone event)

	{

		EntityPlayer player = event.getEntityPlayer();

		IDisguise render = player.getCapability(DisguiseProvider.DISGUISE, null);

		IDisguise oldRender = event.getOriginal().getCapability(DisguiseProvider.DISGUISE, null);

		render.setID(oldRender.getID());

	}
}