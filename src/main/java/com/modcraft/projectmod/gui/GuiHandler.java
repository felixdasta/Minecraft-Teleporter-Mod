package com.modcraft.projectmod.gui;

import com.modcraft.projectmod.container.TeleporterBlockContainer;
import com.modcraft.projectmod.tileentity.TeleporterBlockTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int TELEPORTER_BLOCK = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == TELEPORTER_BLOCK) return new TeleporterBlockContainer(player.inventory, 
				(TeleporterBlockTileEntity) world.getTileEntity(new BlockPos(x,y,z)));
		else return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == TELEPORTER_BLOCK) return new TeleporterBlockGui(player.inventory, 
				(TeleporterBlockTileEntity) world.getTileEntity(new BlockPos(x,y,z)));
		else return null;
	}

}
