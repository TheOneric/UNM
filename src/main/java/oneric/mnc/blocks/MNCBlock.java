package oneric.mnc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import oneric.mnc.common.MNCCreativeTabs;
import oneric.mnc.common.UltimateNetherMod;

public class MNCBlock extends Block {

	public MNCBlock(Material material, String name) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName("mnc_" + name);
		this.setCreativeTab(MNCCreativeTabs.tab_mncBlocks);
	}
	
	public MNCBlock(Material material, SoundType sound, String name) {
		this(material, name);
		this.setSoundType(sound);
	}

	
	
}
