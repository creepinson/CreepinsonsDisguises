package me.creepinson.lib.proxy;

import me.creepinson.core.CreepzDisguises;
import me.creepinson.handler.GuiHandler;
import me.creepinson.handler.event.RenderingHandler;
import me.creepinson.lib.util.config.ConfigUtils;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {

    public static KeyBinding[] keyBindings;
    public static RenderHelper renderUtils = new RenderHelper();


    @Override
    public void registerRenderers() {


    }

    @Override
    public void preInit() {
        super.preInit();
        ConfigUtils.clientPreInit();
    }

    public void init() {
        super.init();
        MinecraftForge.EVENT_BUS.register(new me.creepinson.handler.event.RenderingHandler());


        RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new IRenderFactory() {
            @Override
            public Render createRenderFor(RenderManager manager) {
                return RenderDisguises.pig;
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new IRenderFactory() {
            @Override
            public Render createRenderFor(RenderManager manager) {
                return RenderDisguises.creeper;
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new IRenderFactory() {
            @Override
            public Render createRenderFor(RenderManager manager) {
                return RenderDisguises.player;
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new IRenderFactory() {
            @Override
            public Render createRenderFor(RenderManager manager) {
                return RenderDisguises.enderman;
            }
        });

        NetworkRegistry.INSTANCE.registerGuiHandler(CreepzDisguises.instance, new GuiHandler());
        RenderingHandler.init();

        //KEYBINDS

        // declare an array of key bindings
        keyBindings = new KeyBinding[3];

        // instantiate the key bindings
        keyBindings[0] = new KeyBinding("Open Disguise Menu", Keyboard.KEY_GRAVE, "GUI");
        if (ConfigUtils.teleportEnabled) {
            keyBindings[1] = new KeyBinding("Teleport", Keyboard.KEY_T, "DISGUISE SPECIAL ABILITIES");
        }
        if (ConfigUtils.explodeEnabled) {
            keyBindings[2] = new KeyBinding("Explode", Keyboard.KEY_P, "DISGUISE SPECIAL ABILITIES");
        }
        // register all the key bindings
        for (int i = 0; i < keyBindings.length; ++i) {
            ClientRegistry.registerKeyBinding(keyBindings[i]);


        }
    }

}
