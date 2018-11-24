package com.modcraft.projectmod.gui;

import com.modcraft.projectmod.container.TeleporterBlockContainer;
import com.modcraft.projectmod.tileentity.TeleporterBlockTileEntity;
import com.modcraft.projectmod.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class TeleporterBlockGui extends GuiContainer{

	private TeleporterBlockTileEntity te;
	private IInventory playerInv;
	
	public TeleporterBlockGui(IInventory playerInv, TeleporterBlockTileEntity te) {
		super(new TeleporterBlockContainer(playerInv, te));
		
		this.xSize = 174;
		this.ySize = 165;
		
		this.te = te;
		this.playerInv = playerInv;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, 
				"textures/gui/container/teleporter_block_gui.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
	}
	
	

}
