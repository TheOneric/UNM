package oneric.mnc.blocks;

import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockBigMushTop extends MNCBlock {

	public static final PropertyEnum<BlockBigMushTop.EnumType> VARIANT = PropertyEnum.<BlockBigMushTop.EnumType>create("variant", BlockBigMushTop.EnumType.class);
	
	public BlockBigMushTop(String name) {
		super(Material.WOOD, SoundType.WOOD, name);
		this.setDefaultState(blockState.getBaseState().withProperty(VARIANT, EnumType.ALL_OUTSIDE));
	}
	
	
	
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, 0);
		//return super.getPickBlock(state, target, world, pos, player);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, BlockBigMushTop.EnumType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		
		BlockBigMushTop.EnumType variant = state.getValue(VARIANT);
		
		switch(rot) 
		{
			case CLOCKWISE_180:
				switch(variant) {
					case EAST:
						return state.withProperty(VARIANT, BlockBigMushTop.EnumType.WEST);
					case NORTH:
						return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH);
					case NORTH_EAST:
						return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_WEST);
					case NORTH_WEST:
						return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_EAST);
					case SOUTH:
						return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH);
					case SOUTH_EAST:
						return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_WEST);
					case SOUTH_WEST:
						return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_EAST);
					case WEST:
						return state.withProperty(VARIANT, BlockBigMushTop.EnumType.EAST);
				
					default:
						break;
				}
				//break;  Redundant
			
			case CLOCKWISE_90:
				switch(variant) {
				case EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH);
				case NORTH:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.EAST);
				case NORTH_EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_EAST);
				case NORTH_WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_EAST);
				case SOUTH:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.WEST);
				case SOUTH_EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_WEST);
				case SOUTH_WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_WEST);
				case WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH);
			
				default:
					break;
			}
			
			case COUNTERCLOCKWISE_90:
				switch(variant) {
				case EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH);
				case NORTH:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.WEST);
				case NORTH_EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_WEST);
				case NORTH_WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_WEST);
				case SOUTH:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.EAST);
				case SOUTH_EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_EAST);
				case SOUTH_WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_EAST);
				case WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH);
			
				default:
					break;
			}
		
			case NONE:
				break;
		}
		
		return state;
	}
	
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		
		BlockBigMushTop.EnumType variant = state.getValue(VARIANT);
		
		switch (mirrorIn) 
		{
			case FRONT_BACK:
				switch(variant) {
				case EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.WEST);
				case WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.EAST);
				case NORTH_EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_WEST);
				case NORTH_WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_EAST);
				case SOUTH_EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_WEST);
				case SOUTH_WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_EAST);
				
			
				default:
					break;
			}
			
			case LEFT_RIGHT:
				switch(variant) {
				case NORTH:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH);
				case SOUTH:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH);
				case NORTH_EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_EAST);
				case NORTH_WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.SOUTH_WEST);
				case SOUTH_EAST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_EAST);
				case SOUTH_WEST:
					return state.withProperty(VARIANT, BlockBigMushTop.EnumType.NORTH_WEST);
			
				default:
					break;
			}
	
			default:
				break;
		
		}
		
		return super.withMirror(state, mirrorIn);
	}
	
	public enum EnumType implements IStringSerializable {
		
		NORTH_WEST(1, "north_west"),
        NORTH(2, "north"),
        NORTH_EAST(3, "north_east"),
        WEST(4, "west"),
        CENTER(5, "center"),
        EAST(6, "east"),
        SOUTH_WEST(7, "south_west"),
        SOUTH(8, "south"),
        SOUTH_EAST(9, "south_east"),
		ALL_OUTSIDE(0, "all_outside");
		
		private static final EnumType[] metaLookUp = new EnumType[10];
		
		private final int meta;
		private final String name;
		private EnumType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}
		
		public int getMetadata() {
			return this.meta;
		}

		public String toString() {
			return this.name;
		}

		public static BlockBigMushTop.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= metaLookUp.length) {
				meta = 0;
			}

			BlockBigMushTop.EnumType type = metaLookUp[meta];
			return type == null ? metaLookUp[0] : type;
		}

		public String getName() {
			return this.name;
		}
		
		static {
			for(EnumType vari : values()) {
				metaLookUp[vari.meta] = vari;
			}
		}
	}
}
