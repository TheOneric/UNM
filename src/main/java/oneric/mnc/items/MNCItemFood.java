package oneric.mnc.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import oneric.mnc.common.UltimateNetherMod;

public class MNCItemFood extends ItemFood{

	
	public MNCItemFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName("mnc_" + name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.FOOD);
	}

	

}
