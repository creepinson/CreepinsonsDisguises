package me.creepinson.handler.event;

import me.creepinson.capability.IDisguise;
import me.creepinson.core.CreepzDisguises;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.packet.CustomPacket;
import me.creepinson.render.disguise.RenderDisguises;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	@SubscribeEvent
	public void onPlayerRender(RenderPlayerEvent.Pre event) {
//		event.setCanceled(true);
		if (RenderHelper.currentRender == null) {
			CreepzDisguises.INSTANCE.sendToServer(new CustomPacket(2));
			
		} else {
			RenderHelper.currentRender.doRender(event.getEntityLiving(), 0, 0, 0, 0, 0);
		}
	}
	
	
	
}