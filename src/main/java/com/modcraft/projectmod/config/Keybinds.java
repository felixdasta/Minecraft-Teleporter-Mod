package com.modcraft.projectmod.config;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

//This class is for creating keybindings in minecraft settings
public class Keybinds {
	
	public static KeyBinding fly;
	
	public static void register() { 
		fly = new KeyBinding("key.fly", Keyboard.KEY_GRAVE, "key.categories.mod");
		ClientRegistry.registerKeyBinding(fly);
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		Keybinds.register();
	}
}
