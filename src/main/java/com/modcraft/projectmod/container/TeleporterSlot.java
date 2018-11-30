package com.modcraft.projectmod.container;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class TeleporterSlot extends SlotItemHandler{

	public TeleporterSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);

	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return itemstack.getItem().equals(Items.IRON_INGOT)
				|| itemstack.getItem().equals(Items.GOLD_INGOT)
				|| itemstack.getItem().equals(Items.DIAMOND);
	}
		 
	@Override
	public int getSlotStackLimit() {
	return 1;
	}

}
