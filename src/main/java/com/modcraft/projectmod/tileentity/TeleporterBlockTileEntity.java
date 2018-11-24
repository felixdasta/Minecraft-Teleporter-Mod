package com.modcraft.projectmod.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TeleporterBlockTileEntity extends TileEntity implements ICapabilityProvider{

	private ItemStackHandler handler;
	private int gold_ingots = 0;
	
	public TeleporterBlockTileEntity() {
		this.handler = new ItemStackHandler(1);
	}
	
	public boolean addIngots(){
		if(gold_ingots < 768){
			gold_ingots++;
			return true;
		}
		return false;
	}
	
	public void removeIngots(){
		if(!world.isRemote){
			if(gold_ingots > 0){
				world.spawnEntity(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 
						new ItemStack(Items.GOLD_INGOT)));
				gold_ingots--;
			}
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt){;
		nbt.setInteger("Gold_Ingots", this.gold_ingots);
		nbt.setTag("ItemStackHandler", this.handler.serializeNBT());
		return super.writeToNBT(nbt);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		this.gold_ingots = nbt.getInteger("Gold_Ingots");
		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler"));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		else return super.hasCapability(capability, facing);
	}
}
