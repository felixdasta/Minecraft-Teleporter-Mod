package modcraft.init;

import java.util.ArrayList;

import modcraft.blocks.LashaSandBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final ArrayList<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block LASHA_SAND_BLOCK = new LashaSandBlock("lasha_sand_block", Material.ROCK);
}
