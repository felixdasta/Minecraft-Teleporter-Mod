package com.modcraft.projectmod.blocks;

import com.modcraft.projectmod.blocks.BlockBase;
import net.minecraft.block.material.Material;

public class LashaSandBlock extends BlockBase{

	//This block has custom hardness and resistance values 
	public LashaSandBlock(String name, Material material) {
		super(name, material);
		
		setHardness(1.5F);
		setResistance(30.0F);
		setHarvestLevel("pickaxe", 1);
	}

	
}
