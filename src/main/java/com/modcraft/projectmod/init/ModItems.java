package com.modcraft.projectmod.init;

import java.util.ArrayList;
import java.util.List;
import com.modcraft.projectmod.items.ItemBase;
import com.modcraft.projectmod.items.armor.ArmorBase;
import com.modcraft.projectmod.items.tools.ToolPickaxe;
import com.modcraft.projectmod.items.tools.ToolSpade;
import com.modcraft.projectmod.items.tools.ToolSword;
import com.modcraft.projectmod.items.tools.ToolAxe;
import com.modcraft.projectmod.items.tools.ToolHoe;
import com.modcraft.projectmod.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	//MATERIALS
	public static final ToolMaterial MATERIAL_NOVA = EnumHelper.addToolMaterial("material_nova", 1, 200, 5.0f, 1.5f, 12);
	public static final ArmorMaterial ARMOR_MATERIAL_NOVA = EnumHelper.addArmorMaterial("armor_material_nova", Reference.MOD_ID+":nova", 18, 
			new int[] {4, 8, 10, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	
	//ITEMS
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final Item SAND_BRICK = new ItemBase("sand_brick");
	public static final Item SAND_CLAY = new ItemBase("sand_clay");
	public static final Item REMOTE_CONTROL = new ItemBase("remote_control");
	
	//TOOLS
	public static final ItemSword NOVA_SWORD = new ToolSword("nova_sword", MATERIAL_NOVA);
	public static final ItemSpade NOVA_SHOVEL = new ToolSpade("nova_shovel", MATERIAL_NOVA);
	public static final ItemPickaxe NOVA_PICKAXE = new ToolPickaxe("nova_pickaxe", MATERIAL_NOVA);
	public static final ItemAxe NOVA_AXE = new ToolAxe("nova_axe", MATERIAL_NOVA);
	public static final ItemHoe NOVA_Hoe = new ToolHoe("nova_hoe", MATERIAL_NOVA);
	
	//ARMORS
	public static final Item NOVA_HELMET = new ArmorBase("nova_helmet", ARMOR_MATERIAL_NOVA, 1, EntityEquipmentSlot.HEAD);
	public static final Item NOVA_CHESTPLACE = new ArmorBase("nova_chestplate", ARMOR_MATERIAL_NOVA, 1, EntityEquipmentSlot.CHEST);
	public static final Item NOVA_LEGGINGS = new ArmorBase("nova_leggings", ARMOR_MATERIAL_NOVA, 2, EntityEquipmentSlot.LEGS);
	public static final Item NOVA_BOOTS = new ArmorBase("nova_boots", ARMOR_MATERIAL_NOVA, 1, EntityEquipmentSlot.FEET);

}
