package com.modcraft.projectmod.gui;

import com.modcraft.projectmod.container.TeleporterBlockContainer;
import com.modcraft.projectmod.tileentity.TeleporterBlockTileEntity;
import com.modcraft.projectmod.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class TeleporterBlockGui extends GuiContainer{

	private IInventory playerInv;
	
	/*/The static usages variable will be used to display on the GUI the amount of usages that
	 * the current right-clicked teleporter block has/*/
	
	public static int usages;
	
	public TeleporterBlockGui(IInventory playerInv, TeleporterBlockTileEntity te) {
		super(new TeleporterBlockContainer(playerInv, te));
		
		this.xSize = 174;
		this.ySize = 165;
		
		this.playerInv = playerInv;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString("Teleporter", 
		(this.xSize / 2 - this.fontRenderer.getStringWidth("Teleporter") / 2) + 3,
		8, 4210752);
		this.fontRenderer.drawString("Usages: " + usages, 
		(this.xSize / 2 - this.fontRenderer.getStringWidth("Usages: " + usages) / 2) + 3,
		24, 4210752);
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(),
		6, this.ySize - 92, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, 
				"textures/gui/container/teleporter_block_gui.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	

}
