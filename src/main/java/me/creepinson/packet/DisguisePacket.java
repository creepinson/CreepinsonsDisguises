package me.creepinson.packet;

import io.netty.buffer.ByteBuf;
import me.creepinson.capability.Disguise;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class DisguisePacket implements IMessage {

    public int disguiseID;

    public DisguisePacket() {


    }

    public DisguisePacket(int disguiseID) {

        this.disguiseID = disguiseID;

    }

    @Override
    public void toBytes(ByteBuf buf) {

        buf.writeInt(disguiseID);

    }

    @Override
    public void fromBytes(ByteBuf buf) {

        disguiseID = buf.readInt();


    }
}
