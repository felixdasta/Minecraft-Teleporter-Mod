package com.modcraft.projectmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TeleporterBlockTileEntity extends TileEntity implements ITickable{

	public ItemStackHandler handler;
	public int usages;
	public int id;
	
	public TeleporterBlockTileEntity() {
		this.handler = new ItemStackHandler(1);
		this.usages = 0;
	}
	
	//METHODS TO SAVE INFO IN THE BLOCK:
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		super.writeToNBT(compound);
		
		compound.setLong("Usages Left", usages);
		compound.setInteger("ID", id);
		compound.setTag("ItemStackHandler", this.handler.serializeNBT());
		
		return compound;
	}

	public void readFromNBT(NBTTagCompound compound) {
		
		super.readFromNBT(compound);
		
		this.usages = (int) compound.getLong("Usages Left");
		this.id = compound.getInteger("ID");
		this.handler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
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

	@Override
	public void update() {	
		markDirty();
	}	
	
	public int getId() {
		return id;
	}
}
