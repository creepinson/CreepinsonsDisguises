package me.creepinson.packet;

import me.creepinson.lib.util.disguise.DisguiseTypes;
import me.creepinson.lib.util.render.RenderHelper;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketHandler implements IMessageHandler<CustomPacket, IMessage> {
	 
	  @Override public IMessage onMessage(CustomPacket message, MessageContext ctx) {
	     
	
	 switch(message.id){
	 
	 case 0:
			RenderHelper.currentRender = DisguiseTypes.CREEPER.getDisguise();

		 break;
	 case 1:
			RenderHelper.currentRender = DisguiseTypes.PIG.getDisguise();

		 break;
	 
	 case 2:
			RenderHelper.currentRender = DisguiseTypes.PLAYER.getPlayer();
		 break;
	 }
	    return null;
	  }

	  
	}
	 
	 

