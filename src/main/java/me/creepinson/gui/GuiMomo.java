package me.creepinson.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import me.creepinson.capability.Disguise;
import me.creepinson.capability.IDisguise;
import me.creepinson.core.CreepzDisguises;
import me.creepinson.handler.event.EventHandler;
import me.creepinson.lib.util.Utils;
import me.creepinson.lib.util.disguise.DisguiseTypes;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.packet.CustomPacket;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiMomo extends GuiScreen {

	public static GuiDisguiseButton type1;
	
	public static GuiDisguiseButton type2;
	
	public static GuiDisguiseButton type3;
	


	public static final ResourceLocation resource = new ResourceLocation(Utils.MODID, "textures/gui/momo.png");


	@Override
	public void initGui() {
	     
		int i = (this.width - 248) / 2;
		int j = (this.height - 166) / 2;
        this.buttonList.clear();

        type1 = this.addButton(new GuiDisguiseButton(0, i, j, 150, 20, "Undisguise"));
      	type1.visible = true;
     	type1.enabled = true;
    	type2 = this.addButton(new GuiDisguiseButton(1, i, j + 25,  150, 20, "Change Disguise to Pig"));
     	type2.visible = true;
     	type2.enabled = true;
    	type3 = this.addButton(new GuiDisguiseButton(2, i, j + 50, 150, 20, "Change Disguise to Creeper"));
     	type3.visible = true;
     	type3.enabled = true;
    	
    	
		super.initGui();  
		
		
		
	}
	

@Override
public void updateScreen() {
	super.updateScreen();
	
}
@Override
public void onGuiClosed() {
	super.onGuiClosed();
	  Keyboard.enableRepeatEvents(false);
      
}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	  
		type1.drawButton(mc, mouseX, mouseY);
		type2.drawButton(mc, mouseX, mouseY);
		type3.drawButton(mc, mouseX, mouseY);
		
		GlStateManager.color(1.0F, 0.0F, 0.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(resource);
		int i = (this.width - 248) / 2;
		int j = (this.height - 166) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, 248, 166);
		 super.drawScreen(mouseX, mouseY, partialTicks);
	}
	

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		
		if (button.id == 1) {

			CreepzDisguises.INSTANCE.sendToServer(new CustomPacket(1));
			
			}
			if (button.id == 2) {
				CreepzDisguises.INSTANCE.sendToServer(new CustomPacket(0));

			}
			if (button.id == 0) {
				
				CreepzDisguises.INSTANCE.sendToServer(new CustomPacket(2));
				
			}
		}
}
