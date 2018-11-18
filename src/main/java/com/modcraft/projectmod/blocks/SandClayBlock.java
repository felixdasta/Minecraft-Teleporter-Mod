package com.modcraft.projectmod.blocks;

import java.util.Random;

import com.modcraft.projectmod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SandClayBlock extends BlockBase{
	
	public SandClayBlock(String name, Material material) {
		super(name, material);

		setHardness(0.6F);
		setResistance(3F);
		setSoundType(SoundType.GROUND);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortuen){
		return ModItems.SAND_CLAY;
	}
	
	@Override
	public int quantityDropped(Random rand){
		return 9;
	}
}
