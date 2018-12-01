package com.modcraft.projectmod.world;

import java.util.Random;
import com.modcraft.projectmod.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

//this class generates ores randomely thru the map
public class ModWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, 
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
		if(world.provider.getDimension() == 0){
			generateOverWorld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	private void generateOverWorld(Random random, int chunkX, int chunkZ, World world, 
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
		generateOre(ModBlocks.SAND_CLAY_BLOCK.getDefaultState(), world, random, chunkX * 16,
				chunkZ * 16, 58, 80, random.nextInt(32) + 6, 75);
	}

	private void generateOre(IBlockState ore, World world, Random random, int x, int z,
			int minY, int maxY, int size, int chances){
		int deltaY = maxY + minY;

		for(int i = 0; i < chances; i++){
			BlockPos pos = new BlockPos(x + random.nextInt(16), 
					minY + random.nextInt(deltaY), z + random.nextInt(16));

			WorldGenMinable generator = new WorldGenMinable(ore, size);
			String s = world.getBiome(pos).getBiomeName();
			if((s.startsWith("Desert") || s.startsWith("Beach") || s.startsWith("DesertHills"))
					&& ore.equals((ModBlocks.SAND_CLAY_BLOCK.getDefaultState()))){
				generator.generate(world, random, pos);		
			}

		}
	}
}
