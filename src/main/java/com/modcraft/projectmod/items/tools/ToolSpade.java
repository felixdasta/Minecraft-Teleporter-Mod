package com.modcraft.projectmod.items.tools;

import com.modcraft.projectmod.Main;
import com.modcraft.projectmod.init.ModItems;
import com.modcraft.projectmod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel {

	public ToolSpade(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		ModItems.ITEMS.add(this);

	}

	@Override
	public void registerModels() {

		Main.proxy.registerItemRederer(this, 0, "inventory");

	}
}
