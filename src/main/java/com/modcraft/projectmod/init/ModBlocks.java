package com.modcraft.projectmod.init;

import java.util.ArrayList;
import java.util.List;

import com.modcraft.projectmod.blocks.LashaSandBlock;
import com.modcraft.projectmod.blocks.SandClayBlock;
import com.modcraft.projectmod.blocks.TeleporterBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

//This initializes all the ModBlocks in the game
public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	public static final Block LASHA_SAND_BLOCK = new LashaSandBlock("lasha_sand_block", Material.ROCK);
	public static final Block SAND_CLAY_BLOCK = new SandClayBlock("sand_clay_block", Material.CLAY);
	public static final Block TELEPORTER_BLOCK = new TeleporterBlock("teleporter_block", Material.IRON);
}
