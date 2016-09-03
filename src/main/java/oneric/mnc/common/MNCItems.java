package oneric.mnc.common;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import oneric.mnc.items.MNCItem;
import oneric.mnc.items.MNCItemFood;
import oneric.mnc.util.minecraft.ModelRegistryHelper;
import oneric.mnc.items.ItemNetherMushroom;
import oneric.mnc.items.ItemNetherMushroomSeeds;

public class MNCItems {

	public static Item netherStick;
	public static Item iceBall;
	public static Item ingotPb;
	public static Item netherMushroom;
	public static Item netherMushroomSpores;
	
	//Armour * 2 (old ones, new ones to add)
	//Tool Set * 2
	//Artifices
	//Farming
	
	
	public static void initItems()
	{
		netherStick = new MNCItem("netherStick");
		iceBall = new MNCItem("iceBall");
		ingotPb = new MNCItem("ingotPb");
		netherMushroom = new ItemNetherMushroom("netherMushroom", 1, 1.0f, false);
		netherMushroomSpores = new ItemNetherMushroomSeeds("netherMushroomSpores", MNCBlocks.netherMushroom, MNCBlocks.infusedNetherrack);
	}
	
	public static void registerItems()
	{
		GameRegistry.register(netherStick);
		GameRegistry.register(iceBall);
		GameRegistry.register(ingotPb);
		GameRegistry.register(netherMushroom);
		GameRegistry.register(netherMushroomSpores);
	}
	
	public static void registerOreDict()
	{
		OreDictionary.registerOre("ingotLead", ingotPb);
	}
	
	
	public static void registerItemModels()
	{
		ModelRegistryHelper.registerItemModel(netherStick, 0);
		ModelRegistryHelper.registerItemModel(iceBall, 0);
		ModelRegistryHelper.registerItemModel(ingotPb, 0);
		ModelRegistryHelper.registerItemModel(netherMushroom, 0);
		ModelRegistryHelper.registerItemModel(netherMushroomSpores, 0);
	}

}
