package com.modcraft.projectmod.blocks;

import com.modcraft.projectmod.Main;
import com.modcraft.projectmod.init.ModBlocks;
import com.modcraft.projectmod.init.ModItems;
import com.modcraft.projectmod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

	//This class is the base class for all blocks
	public BlockBase(String name, Material material) {
		
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	//registers the models of the blocks
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRederer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
}
