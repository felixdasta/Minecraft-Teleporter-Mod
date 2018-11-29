package com.modcraft.projectmod.container;

import com.modcraft.projectmod.tileentity.TeleporterBlockTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class TeleporterBlockContainer extends Container{

	private IItemHandler handler;
	
	public TeleporterBlockContainer(IInventory playerInv, TeleporterBlockTileEntity te) {
		
		handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		this.addSlotToContainer(new TeleporterSlot(handler, 0, 79, 53));
		
		int xPos = 7;
		int yPos = 84;
				
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
			}
		}
				
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
}
}
