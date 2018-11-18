package com.modcraft.projectmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init(){
		GameRegistry.addSmelting(ModItems.SAND_CLAY, new ItemStack(ModItems.SAND_BRICK, 1), 1.5F);
	}
}
