package com.modcraft.projectmod.items.tools;

import com.modcraft.projectmod.Main;
import com.modcraft.projectmod.init.ModItems;
import com.modcraft.projectmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class Toolaxe extends ItemAxe implements IHasModel {

	public Toolaxe(String name, ToolMaterial material) {
		super(material, 10.0F, -2.5F);
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
