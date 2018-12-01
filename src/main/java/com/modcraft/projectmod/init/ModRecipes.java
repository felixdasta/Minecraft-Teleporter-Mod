package com.modcraft.projectmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

//This class main function is convert items into new ones when in furnace 
public class ModRecipes {

	public static void init(){
		GameRegistry.addSmelting(ModItems.SAND_CLAY, new ItemStack(ModItems.SAND_BRICK, 1), 1.5F);
	}
}
