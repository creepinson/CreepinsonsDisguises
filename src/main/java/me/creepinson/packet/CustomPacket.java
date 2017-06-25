package me.creepinson.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CustomPacket implements IMessage {
	public int id;
	// A default constructor is always required
	public CustomPacket(int id) {
		
		this.id = id;

		
	}
public CustomPacket() {

	
	
}


	@Override
	public void toBytes(ByteBuf buf) {

		buf.writeInt(id);
		
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		// Reads the int back from the buf. Note that if you have multiple
		// values, you must read in the same order you wrote.

		id = buf.readInt();
	}
}
