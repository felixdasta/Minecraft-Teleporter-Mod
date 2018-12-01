package com.modcraft.projectmod.config;

import com.modcraft.projectmod.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

//Handles all they unique keys creating unique features 
public class KeyInputHandler {
	
	static boolean flying = false;
	
	@SubscribeEvent
	public void onKeyInput (KeyInputEvent event) {
		if(Keybinds.fly.isPressed() && !flying) {
			if(!Minecraft.getMinecraft().player.isCreative() && Minecraft.getMinecraft().player.inventory.getCurrentItem().getItem().getUnlocalizedName().equals(ModItems.SAND_BRICK.getUnlocalizedName())){
				if(Minecraft.getMinecraft().player.experienceLevel>=10 && !flying) {
					Minecraft.getMinecraft().player.experienceLevel = Minecraft.getMinecraft().player.experienceLevel-10;
					Minecraft.getMinecraft().player.capabilities.allowFlying = true;
					flying = true;
					Minecraft.getMinecraft().player.sendChatMessage("Tooo infinity and BEYOND!!");
				}
				else {
					Minecraft.getMinecraft().player.sendChatMessage("You need 10 levels!!");
				}

			}
		}
	}

}
