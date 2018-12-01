package com.modcraft.projectmod.items;

import com.modcraft.projectmod.Main;
import com.modcraft.projectmod.init.ModItems;
import com.modcraft.projectmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

//base class for all our items
public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRederer(this, 0, "inventory");
		
	}

}
