package me.creepinson.lib.proxy;

import org.lwjgl.input.Keyboard;

import me.creepinson.core.CreepzDisguises;
import me.creepinson.handler.GuiHandler;
import me.creepinson.render.disguise.RenderDisguises;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
 
public class ClientProxy extends CommonProxy {
	
	public static KeyBinding[] keyBindings;
	
	
	
	
	@Override
	public void registerRenderers() {

	
		

	
	}
	@Override
	public void preInit() {
		  super.preInit();
		
	}

	public void init() {
		  super.init();
		
			
			
			RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new IRenderFactory(){@Override
		        public Render createRenderFor(RenderManager manager) { 
		            return RenderDisguises.pig;
		         }
		    });
			
			RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new IRenderFactory(){@Override
		        public Render createRenderFor(RenderManager manager) { 
		            return RenderDisguises.creeper;
		         }
		    });
			
			
			
			
			NetworkRegistry.INSTANCE.registerGuiHandler(CreepzDisguises.instance, new GuiHandler());
			
			
			//KEYBINDS

			// declare an array of key bindings
			keyBindings = new KeyBinding[1]; 
			  
			// instantiate the key bindings
			keyBindings[0] = new KeyBinding("Open Disguise Menu", Keyboard.KEY_GRAVE, "GUI");
		    	    
			// register all the key bindings
			for (int i = 0; i < keyBindings.length; ++i) 
			{
			    ClientRegistry.registerKeyBinding(keyBindings[i]);

			
			
			
	}
	}
	
}
