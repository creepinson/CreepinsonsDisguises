package me.creepinson.handler;

import me.creepinson.capability.DisguiseProvider;
import me.creepinson.core.CreepzDisguises;
import me.creepinson.lib.proxy.ClientProxy;
import me.creepinson.lib.util.config.ConfigUtils;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.packet.CreepPacket;
import me.creepinson.packet.EnderPacket;
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


        if (player.getCapability(DisguiseProvider.DISGUISE, null) != null) {
            if (keyBindings[0].isPressed()) {
                player.openGui(CreepzDisguises.instance, GuiHandler.MOMO, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
            }
            if (ConfigUtils.teleportEnabled) {
                if (player.getCapability(DisguiseProvider.DISGUISE, null).getDisguiseID() == 3) {
                    if (keyBindings[1].isPressed()) {
                        CreepzDisguises.INSTANCE.sendToServer(new EnderPacket());
                    }
                }
            }
            if (ConfigUtils.explodeEnabled) {
                if (player.getCapability(DisguiseProvider.DISGUISE, null).getDisguiseID() == 2) {
                    if (keyBindings[2].isPressed()) {
                        CreepzDisguises.INSTANCE.sendToServer(new CreepPacket());

                    }
                }
            }
        }
    }

}