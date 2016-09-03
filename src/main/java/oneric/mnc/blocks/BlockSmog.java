package oneric.mnc.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSmog extends MNCBlock {

	public BlockSmog(String name) {
		super(Material.ICE, SoundType.CLOTH, name);
		setHardness(0.2F);
        setLightOpacity(3);
        setLightLevel(0.3F);
	}
	
	
	/*@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		
	}*/
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity)
    {
		entity.fallDistance = 0.0F;
		//System.out.println("collision");
		if (entity.motionY < 0) {
			entity.motionY *= 0.005D;
			//System.out.println("--WoW--");
		}
    }
	
	@Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
        entityIn.fall(fallDistance, 0.0F);
        //onEntityWalk(worldIn, pos, entityIn);
        onEntityCollidedWithBlock(worldIn, pos, null, entityIn);
    }
	

	    

	  
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}


	
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();       
//            if (blockState != iblockstate)
//            {
//                return true;
//            }

            if (block == this)
            {
                return false;
            }
            
            return true;
    }
	
	
	
	
	protected static final AxisAlignedBB SMOG_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.05D, 1.0D);
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6_) {
		addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, SMOG_AABB);
		//super.addCollisionBoxToList(state, worldIn, pos, p_185477_4_, p_185477_5_, p_185477_6_);
	}
	/**
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState worldIn, World pos, BlockPos state) {
		//return SMOG_AABB.offset(state); //TODO
		return super.getCollisionBoundingBox(worldIn, pos, state);
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		//return FULL_BLOCK_AABB;
		return super.getSelectedBoundingBox(blockState, worldIn, pos);
	}
	*/
	

}
