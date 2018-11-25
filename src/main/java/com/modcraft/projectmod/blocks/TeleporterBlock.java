package com.modcraft.projectmod.blocks;
import com.modcraft.projectmod.Main;
import com.modcraft.projectmod.gui.GuiHandler;
import com.modcraft.projectmod.init.ModItems;
import com.modcraft.projectmod.tileentity.TeleporterBlockTileEntity;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TeleporterBlock extends BlockBase implements ITileEntityProvider{

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
			if(playerIn.getHeldItemMainhand().getItem().equals(ModItems.TELEPORT_BUTTON)){

			}else if(playerIn.getHeldItemMainhand().getItem().equals(ModItems.TABLET)){

			}else{
				playerIn.openGui(Main.instance, GuiHandler.TELEPORTER_BLOCK, worldIn,
						pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TeleporterBlockTileEntity();
	}

}
