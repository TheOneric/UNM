package oneric.mnc.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import oneric.mnc.common.MNCCreativeTabs;
import oneric.mnc.common.UltimateNetherMod;

public class ItemNetherMushroomSeeds extends ItemSeeds {

	public ItemNetherMushroomSeeds(String name, Block crops, Block soil) {
		super(crops, soil);
		this.setUnlocalizedName("mnc_" + name);
		this.setRegistryName(name);
		this.setCreativeTab(MNCCreativeTabs.tab_mncItems);
	}
	
	@Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Nether;
    }
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos); //TODO Check if already fixed in Vanilla
		Block plant = getPlant(worldIn, pos).getBlock(); 
		if(plant instanceof BlockBush) {
			
			if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) 
					&& state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, (BlockBush)plant) 
					&& ((BlockBush)plant).canBlockStay(worldIn, pos.up(), state) 
					&& worldIn.isAirBlock(pos.up()))
	        {
	            worldIn.setBlockState(pos.up(), this.getPlant(worldIn, pos));
	            --stack.stackSize;
	            return EnumActionResult.SUCCESS;
	        }
			else{
				return EnumActionResult.FAIL;
			}
		}
		
		return super.onItemUse(stack, playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}

}
