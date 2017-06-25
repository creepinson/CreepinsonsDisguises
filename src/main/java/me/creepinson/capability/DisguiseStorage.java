package me.creepinson.capability;

import me.creepinson.lib.util.render.RenderHelper;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class DisguiseStorage implements IStorage<IDisguise>

{

 @Override

 public NBTBase writeNBT(Capability<IDisguise> capability, IDisguise instance, EnumFacing side)

 {

 return new NBTTagInt(instance.getRender());

 }



 @Override

 public void readNBT(Capability<IDisguise> capability, IDisguise instance, EnumFacing side, NBTBase nbt)

 {

 instance.setRender(RenderHelper.id);

 }

}