package com.modcraft.projectmod.init;

import java.util.ArrayList;
import java.util.List;
import com.modcraft.projectmod.blocks.BlockBase;
import com.modcraft.projectmod.blocks.LashaSandBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final Block LASHA_SAND_BLOCK = new LashaSandBlock("lasha_sand_block", Material.ROCK);

}
