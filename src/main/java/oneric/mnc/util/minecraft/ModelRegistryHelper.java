package oneric.mnc.util.minecraft;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelRegistryHelper {
	
	@SideOnly(Side.CLIENT)
	public static void registerBlockModel(Block block, int meta) {
		registerItemModel(Item.getItemFromBlock(block), meta);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemVariantNames(Block block, ResourceLocation... names) {
		registerItemVariantNames(Item.getItemFromBlock(block), names);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemVariantNames(Item item, ResourceLocation... names) {
		ModelLoader.registerItemVariants(item, names);
	}

}
