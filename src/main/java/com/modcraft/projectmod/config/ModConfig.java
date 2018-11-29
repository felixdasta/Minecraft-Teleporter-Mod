package com.modcraft.projectmod.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.modcraft.projectmod.util.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModConfig {
	
	private static Configuration config = null;
	
	public static final String CATEGORY_NAME_BLOCKS = "blocks";
	
	public static int machineCooldownBasic;
	
	public static int machineCooldownAdvance;
	
	public static void preInit() {
		File configFile = new File(Loader.instance().getConfigDir(), "BitOfEverything.cfg");
		config = new Configuration(configFile);
		syncFromFiles();
	}
	
	public static Configuration getConfig() {
		return config;
	}
	
	public static void clientPreInit() {
		MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());
	}
	
	public static void syncFromFiles() {
		syncConfig(true, true);
	}
	
	public static void syncFromGui() {
		syncConfig(false, true);
	}
	
	public static void syncFromFields() {
		syncConfig(false, false);
	}
	
	private static void syncConfig(boolean loadFromConfigFile, boolean readFieldsFromConfig) {
		if(loadFromConfigFile)
			config.load();
			
		Property propertyMachineCooldownBasic = config.get(CATEGORY_NAME_BLOCKS, "machine_cooldown_basic", 100);
		propertyMachineCooldownBasic.setLanguageKey("gui.config.blocks.machine_cooldown_basic.name");
		propertyMachineCooldownBasic.setComment(I18n.format("gui.config.blocks.machine_cooldown_basic.comment"));
		propertyMachineCooldownBasic.setMinValue(10);
		propertyMachineCooldownBasic.setMaxValue(200);
		Property propertyMachineCooldownAdvanced = config.get(CATEGORY_NAME_BLOCKS, "machine_cooldown_advanced", 50);
		propertyMachineCooldownBasic.setLanguageKey("gui.config.blocks.machine_cooldown_advanced.name");
		propertyMachineCooldownBasic.setComment(I18n.format("gui.config.blocks.machine_cooldown_advanced.comment"));
		propertyMachineCooldownBasic.setMinValue(10);
		propertyMachineCooldownBasic.setMaxValue(200);
		
		List<String> propertyOrderBlocks = new ArrayList<String>();
		propertyOrderBlocks.add(propertyMachineCooldownBasic.getName());
		propertyOrderBlocks.add(propertyMachineCooldownAdvanced.getName());
		config.setCategoryPropertyOrder(CATEGORY_NAME_BLOCKS, propertyOrderBlocks);
		
		if(readFieldsFromConfig) {
			machineCooldownBasic = propertyMachineCooldownBasic.getInt();
			machineCooldownAdvance = propertyMachineCooldownAdvanced.getInt();
		}
		
		propertyMachineCooldownBasic.set(machineCooldownBasic);
		propertyMachineCooldownAdvanced.set(machineCooldownAdvance);
		
		if(config.hasChanged())
			config.save();
	}
	public static class ConfigEventHandler {
		@SubscribeEvent(priority = EventPriority.LOWEST)
		public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
			if(event.getModID().equals(Reference.MOD_ID)) {
				syncFromGui();
			}
		}
	}
}
