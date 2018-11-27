package com.modcraft.projectmod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TeleporterBlockTileEntity extends TileEntity implements ITickable, IInventory{

	private ItemStackHandler handler;
	public int usages;
	public int id;
	
	public TeleporterBlockTileEntity() {
		this.handler = new ItemStackHandler(1);
	}
	
	//METHODS TO SAVE INFO IN THE BLOCK:
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		super.writeToNBT(compound);
		
		NBTTagList list = new NBTTagList();
		
		for (int i = 0; i < getSizeInventory(); i++) {
			if(getStackInSlot(i)!=ItemStack.EMPTY) {
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte)i);
				getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		
		compound.setTag("Items", list);
		compound.setLong("Usages Left", usages);
		compound.setInteger("ID", id);
		
		return compound;
	}

	public void readFromNBT(NBTTagCompound compound) {
		
		super.readFromNBT(compound);
		
		NBTTagList list = compound.getTagList("Items", 10);
		usages = (int) compound.getLong("Usages Left");
		id = compound.getInteger("ID");

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			setInventorySlotContents(slot, new ItemStack(stackTag));
		}
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		if(isItemValidForSlot(0, getStackInSlot(0))) {
		usages+= getItemBurnTime(getStackInSlot(0));
		getStackInSlot(0).setCount(getStackInSlot(0).getCount()-1);
		if(getStackInSlot(0).getCount()==0) {
			setInventorySlotContents(0, ItemStack.EMPTY);
		}
		markDirty();
	}	
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static boolean isItemFuel(ItemStack stack) {
		return false;
	}

	public static int getItemBurnTime(ItemStack stack) {
		return 0;
	}
	
	public int getUsage() {
		return 0;
	}
	
	public int getId() {
		return id;
	}
}
