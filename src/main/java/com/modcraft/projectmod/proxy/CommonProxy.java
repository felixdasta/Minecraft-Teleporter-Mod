package com.modcraft.projectmod.proxy;

import com.modcraft.projectmod.tileentity.TeleporterBlockTileEntity;
import com.modcraft.projectmod.util.Reference;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void registerItemRederer(Item item, int meta, String id) {
		
	}
	
	@SuppressWarnings("deprecation")
	public void registerTileEntities(){
		GameRegistry.registerTileEntity(TeleporterBlockTileEntity.class, Reference.MOD_ID + ":teleporter_block");
	}

}
