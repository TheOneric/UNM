package oneric.mnc.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import oneric.mnc.common.MNCBlocks;
import oneric.mnc.common.MNCItems;

public class BlockNetherMushroom extends BlockCrops {
	
	protected static final AxisAlignedBB AABB_1 = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.4000000059604645D, 0.699999988079071D);
	protected static final AxisAlignedBB AABB_0 = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.2D, 0.699999988079071D);
	protected static final AxisAlignedBB AABB_2 = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.5500000059604645D, 0.699999988079071D);
	
	public BlockNetherMushroom (String name) {
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName("mnc_" + name);
		
	}
	
	@Override
	protected boolean canSustainBush(IBlockState state) //~~ Can be sustained (called in canSustainPlant(...))
    {
        return (state.getBlock() == Blocks.NETHERRACK || state.getBlock() == MNCBlocks.infusedNetherrack || state.getBlock() == Blocks.SOUL_SAND);
    }
	
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (pos.getY() >= 0 && pos.getY() < 256 )
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.down());
            return iblockstate.getBlock() == MNCBlocks.infusedNetherrack ? true : ( (iblockstate.getBlock() == Blocks.NETHERRACK || iblockstate.getBlock() == Blocks.SOUL_SAND) && worldIn.provider.getDimensionType() == DimensionType.NETHER );
        }
        else
        {
            return false;
        }
    }
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return false;
    }
	
	@Override
	protected Item getSeed()
    {
        return MNCItems.netherMushroomSpores;
    }

	@Override
    protected Item getCrop()
    {
        return MNCItems.netherMushroom;
    }
	
	//@Override
	protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos) {
		return 1f; //TODO
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        //super.updateTick(worldIn, pos, state, rand);
        
        if(true); //TODO
    }
	
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if(state.getValue(AGE).intValue() < 2)
			return AABB_0;
		else if(state.getValue(AGE).intValue() < 7)
			return AABB_1;
		else
			return AABB_2;
		
	}

}
