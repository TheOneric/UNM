package oneric.mnc.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNetherLog extends MNCBlock {

	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	//public static final PropertyEnum<BlockPlanks.EnumType> VARIANT = PropertyEnum.<BlockPlanks.EnumType>create("variant", BlockNetherLog.EnumType.class);
	
	public BlockNetherLog(String name) {
		super(Material.WOOD, SoundType.WOOD, name);
	}
	
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		
//		if(player.getHeldItem(EnumHand.MAIN_HAND) != null && player.getHeldItem(EnumHand.MAIN_HAND).getItem() == MNCItems.netherAxe) {
//			int rand = world.rand.nextInt(100);
//			if(rand > 90){
//				world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MNCItems.fireSap, 2)));
//			} else if(rand > 70) {
//					world.spawnEntityInWorld(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(MNCItems.fireSap, 1)));
//			}
//		}
		
		super.onBlockHarvested(world, pos, state, player);
	}
	
	 
	 
	@Override
	public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
	 
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = 4;
        int j = i + 1;

        if (worldIn.isAreaLoaded(pos.add(-j, -j, -j), pos.add(j, j, j)))
        {
            for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-i, -i, -i), pos.add(i, i, i)))
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos))
                {
                    iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
                }
            }
        }
    }
	
	
	@Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta).withProperty(LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
    }
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
        //iblockstate.withProperty(VARIANT, EnumType.NETHER);
        
        switch(meta & 3)
        {
        case 0:
        	iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
        	break;
//        case 1:
//        	iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
//        	break;
        case 2:
        	iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
        	break;
        case 3:
        	iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        	break;
        }
        
        
        return iblockstate;
    }
	
	@Override
	public int getMetaFromState(IBlockState state)
	{	
		int meta = 0;
		switch((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
		{
		case Y:
			meta |= 0;
			break;
			
		case X:
			meta |= 1;
			break;
			
		case Z:
			meta |= 2;
			break;
			
		case NONE:
			meta |= 3;
			break;
		}
		
		return meta;
	}
	
	
	@Override
	public boolean rotateBlock(net.minecraft.world.World world, BlockPos pos, EnumFacing axis) {
		net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
		for (net.minecraft.block.properties.IProperty<?> prop : state.getProperties().keySet()) {
			if (prop.getName().equals("axis")) {
				world.setBlockState(pos, state.cycleProperty(prop));
				return true;
			}
		}
		return false;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:

			switch (state.getValue(LOG_AXIS)) {
			case X:
				return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
			case Z:
				return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
			default:
				return state;
			}

		default:
			return state;
		}
	}
	

}
