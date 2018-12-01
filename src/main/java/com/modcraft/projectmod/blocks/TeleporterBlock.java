package com.modcraft.projectmod.blocks;
import com.modcraft.projectmod.Main;
import com.modcraft.projectmod.gui.GuiHandler;
import com.modcraft.projectmod.gui.TeleporterBlockGui;
import com.modcraft.projectmod.init.ModItems;
import com.modcraft.projectmod.tileentity.TeleporterBlockTileEntity;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TeleporterBlock extends BlockBase implements ITileEntityProvider{

	private int id;

	public TeleporterBlock(String name, Material material) {
		super(name, material);

		setHardness(5.0F);
		setResistance(30F);
		setSoundType(SoundType.METAL);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {		

		if(!worldIn.isRemote){

			TeleporterBlockTileEntity theBlock = (TeleporterBlockTileEntity) worldIn.getTileEntity(pos);
			id = theBlock.getId();

			/*/If the user rights click any side of the block, the block id will increase.
			 * If they right click the top, or the bottom of the block, the block id will decrease/*/
			if(playerIn.isSneaking()) { 
				if(facing == EnumFacing.NORTH || facing == EnumFacing.EAST ||
						facing == EnumFacing.WEST || facing == EnumFacing.SOUTH
						&& playerIn.getHeldItemMainhand().isEmpty()) {
					theBlock.id++;
				}
				else{
					if(theBlock.id > 0) theBlock.id--;
				}
				id = theBlock.getId();
				playerIn.sendMessage(new TextComponentString
						("The block ID has been set to " + id));
				theBlock.markDirty();
			//This code will be runned to find if a teleporter block is in range
			}else if(playerIn.getHeldItemMainhand().getItem().equals(ModItems.TELEPORT_BUTTON)){
				this.getTeleporterBlockInRange(worldIn, pos, playerIn, theBlock, 64);		
			}else if(playerIn.getHeldItemMainhand().getItem().equals(ModItems.TABLET)){
				/*/Each iron ingot will give 10 usages, each gold ingot will give 40 usages
				  and each diamond ingot will give 160 usages (4 times the amount of the previous
				  superior ingot)/*/
				if(theBlock.handler.getStackInSlot(0).isItemEqual
						(Items.IRON_INGOT.getDefaultInstance())){
					theBlock.usages += theBlock.handler.getStackInSlot(0).getCount() * 10;
					theBlock.handler.getStackInSlot(0).setCount(0);
					playerIn.sendMessage(new TextComponentString
							("The iron ingots were converted to usages!"));
					playerIn.sendMessage(new TextComponentString
							("Usages amount: " + theBlock.usages));
				}else if(theBlock.handler.getStackInSlot(0).isItemEqual
						(Items.GOLD_INGOT.getDefaultInstance())){
					theBlock.usages += theBlock.handler.getStackInSlot(0).getCount() * 40;
					theBlock.handler.getStackInSlot(0).setCount(0);
					playerIn.sendMessage(new TextComponentString
							("The gold ingots were converted to usages!"));
					playerIn.sendMessage(new TextComponentString
							("Usages amount: " + theBlock.usages));
				}
				else if(theBlock.handler.getStackInSlot(0).isItemEqual
						(Items.DIAMOND.getDefaultInstance())){
					theBlock.usages += theBlock.handler.getStackInSlot(0).getCount() * 160;
					theBlock.handler.getStackInSlot(0).setCount(0);
					playerIn.sendMessage(new TextComponentString
							("The diamonds were converted to usages!"));
					playerIn.sendMessage(new TextComponentString
							("Usages amount: " + theBlock.usages));
				}
				else{
					playerIn.sendMessage(new TextComponentString
							("Block ID: " + id));
					playerIn.sendMessage(new TextComponentString
							("Usages amount: " + theBlock.usages));
				}
			}else{
				TeleporterBlockGui.usages = theBlock.usages;
				playerIn.openGui(Main.instance, GuiHandler.TELEPORTER_BLOCK, worldIn,
						pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TeleporterBlockTileEntity();
	}

	public void getTeleporterBlockInRange(World worldIn, BlockPos pos, EntityPlayer playerIn, TeleporterBlockTileEntity theBlock, int range){

		BlockPos theBlockPos = null;
		double distance = 0;
		String message = "";

		//This nested for loop will look for the closest teleporter block in the determined range
		for(int x = pos.getX() - range; x < pos.getX() + range; x++){
			for(int y = pos.getY() - range; y < pos.getY() + range; y++){
				for(int z = pos.getZ() - range; z < pos.getZ() + range; z++){
					BlockPos otherPos = new BlockPos(x, y, z);
					if(worldIn.getTileEntity(otherPos) instanceof TeleporterBlockTileEntity && !(pos.equals(otherPos))){
						TeleporterBlockTileEntity theOtherBlock = (TeleporterBlockTileEntity) worldIn.getTileEntity(otherPos);
						if(theOtherBlock.id == theBlock.id){
							if(worldIn.isAirBlock(new BlockPos(x, y+1, z)) && worldIn.isAirBlock(new BlockPos(x, y+2, z))){
								if(distance == 0){
									theBlockPos = new BlockPos(x, y, z);
									distance = pos.getDistance(otherPos.getX(), otherPos.getY(), otherPos.getZ());
								}else if(pos.getDistance(otherPos.getX(), otherPos.getY(), otherPos.getZ()) < distance){
									theBlockPos = new BlockPos(x, y, z);
									distance = pos.getDistance(otherPos.getX(), otherPos.getY(), otherPos.getZ());
								}
							}else{
								message = "Solid block placed in the top of the teleporter may be preventing teleportation";
							}
						}

					}
				}
			}
		}

		/*/If a block position equivalent to a teleporter block with the same id was detected, 
		 * then the player will teleport to the nearest block/*/
		if(theBlockPos != null){
			/*/The amount of usages that will be used depends on the distance of the block
			   If the trip will consume more usages than the amount of usages the the block has,
			   then the teleporter will not be able to transport. The amount of usages will depend
			   on the distance. The formula used is the distance multiplied by 1.25/*/
			if(theBlock.usages*1.25 > 0){
				System.out.println(distance);
				playerIn.setPositionAndUpdate(theBlockPos.getX(), theBlockPos.getY() + 1, theBlockPos.getZ());
				playerIn.sendMessage(new TextComponentString
						(String.format("%s teleported to X: %d, Y: %d, Z: %d", 
								Minecraft.getMinecraft().player.getName(), theBlockPos.getX(), theBlockPos.getY() + 1, theBlockPos.getZ())));
				theBlock.usages-=distance*1.25;	
			}else{
				playerIn.sendMessage(new TextComponentString("Not enough usages"));
				return;
			}
		}/*/If all the scanned blocks that were valid had solid blocks in top of them,  then the 
		 * teleportation will not proceed since a player can't teleport in a solid block/*/
		else if(message.length()>0){
			playerIn.sendMessage(new TextComponentString(message));
		}
		//If all the scanned blocks didn't match the ID of the block, then player can't be teleported anywhere
		else playerIn.sendMessage(new TextComponentString("No teleporter block with matching ID within " + range + " blocks"));
	}
}


