package me.creepinson.handler;

import me.creepinson.core.CreepzDisguises;
import me.creepinson.lib.proxy.ClientProxy;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.packet.CreepPacket;
import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeysHandler {
    private boolean teleported;

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(KeyInputEvent event) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        KeyBinding[] keyBindings = ClientProxy.keyBindings;


        if (keyBindings[0].isPressed()) {
            player.openGui(CreepzDisguises.instance, GuiHandler.MOMO, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
        }
        if (RenderHelper.currentRender == RenderDisguises.enderman) {
            if (keyBindings[1].isPressed()) {
                CreepzDisguises.INSTANCE.sendToServer(new CreepPacket());
            }
            if (RenderHelper.currentRender == RenderDisguises.creeper) {
                if (keyBindings[2].isPressed()) {
                    CreepzDisguises.INSTANCE.sendToServer(new CreepPacket());
                    player.worldObj.createExplosion(player, player.posX, player.posY, player.posZ, 5, false);
                    player.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
                }
            }
        }
    }

}