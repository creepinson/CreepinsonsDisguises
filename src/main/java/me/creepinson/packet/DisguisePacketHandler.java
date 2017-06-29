package me.creepinson.packet;

import me.creepinson.capability.DisguiseProvider;
import me.creepinson.capability.IDisguise;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DisguisePacketHandler implements IMessageHandler<DisguisePacket, IMessage> {

    @Override
    public IMessage onMessage(DisguisePacket message, MessageContext ctx) {

        EntityPlayerMP player = ctx.getServerHandler().playerEntity;
        IDisguise disguise = player.getCapability(DisguiseProvider.DISGUISE, null);
        if (disguise != null) {
            disguise.setID(message.disguiseID);
        }


        return null;
    }

}
