package me.creepinson.handler.event;

import me.creepinson.disguise.Disguises;
import me.creepinson.disguise.PlayerDisguise;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderingHandler {
    private static Map<Class<? extends Entity>, IRenderFactory<? extends Entity>> map;
    public static void init() {
        try {
            Field field = RenderingRegistry.class.getDeclaredField("INSTANCE");
            field.setAccessible(true);
            RenderingRegistry object = (RenderingRegistry) field.get(null);
            field = object.getClass().getDeclaredField("entityRenderers");
            field.setAccessible(true);
            map = (Map<Class<? extends Entity>, IRenderFactory<? extends Entity>>) field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void playerRenderPre(RenderPlayerEvent.Pre event) {
        if (Disguises.getDisguises().containsKey(event.getEntityPlayer().getUniqueID())) {
            event.setCanceled(true);
        }
    }

    public static Map<Class<? extends Entity>, IRenderFactory<? extends Entity>> getEntityRendererMap() {
        return map;
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void playerRenderPre(RenderPlayerEvent.Post event) {
        if (Disguises.getDisguises().containsKey(event.getEntityPlayer().getUniqueID())) {
            try {

                PlayerDisguise d = Disguises.getDisguises().get(event.getEntityPlayer().getUniqueID());
                Render render = map.get(d.type.getClass()).createRenderFor(Minecraft.getMinecraft().getRenderManager());
                render.doRender(event.getEntity(), event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, event.getEntity().rotationYaw, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
