package com.modcraft.projectmod.items.tools;

import com.modcraft.projectmod.Main;
import com.modcraft.projectmod.init.ModItems;
import com.modcraft.projectmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
	
	public ToolPickaxe(String name, ToolMaterial material) {
		super(material);
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
