package modcraft.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class LashaSandBrick extends BlockBase{

	public LashaSandBrick(String name, Material material) {
		super(name, material);
		
		setHardness(1.5F);
		setResistance(30.0F);
		setHarvestLevel("pickaxe", 1);
	}

	
}
