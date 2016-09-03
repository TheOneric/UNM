package oneric.mnc.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MNCCreativeTabs {
	
	@SideOnly(Side.CLIENT)
    public static CreativeTabs tab_mncBlocks = new CreativeTabs(UltimateNetherMod.MOD_ID+".blocks"){
    	@Override
    	@SideOnly(Side.CLIENT)
    	public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.NETHER_BRICK);
        }
    };
    
    @SideOnly(Side.CLIENT)
    public static CreativeTabs tab_mncItems = new CreativeTabs(UltimateNetherMod.MOD_ID+".items"){
    	@Override
    	@SideOnly(Side.CLIENT)
    	public Item getTabIconItem() {
            return MNCItems.netherStick;
        }
    };

}
