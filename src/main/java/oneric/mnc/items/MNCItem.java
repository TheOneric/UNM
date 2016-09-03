package oneric.mnc.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import oneric.mnc.common.MNCCreativeTabs;
import oneric.mnc.common.UltimateNetherMod;

public class MNCItem extends Item {
	
	public MNCItem(String name) {
		this.setUnlocalizedName("mnc_" + name);
		this.setRegistryName(name);
		this.setCreativeTab(MNCCreativeTabs.tab_mncItems);
	}

}
