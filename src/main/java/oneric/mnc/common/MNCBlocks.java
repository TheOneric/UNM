package oneric.mnc.common;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oneric.mnc.blocks.BlockBigMushBase;
import oneric.mnc.blocks.BlockBigMushTop;
import oneric.mnc.blocks.BlockNetherLog;
import oneric.mnc.blocks.BlockNetherMushroom;
import oneric.mnc.blocks.BlockSmog;
import oneric.mnc.blocks.MNCBlock;
import oneric.mnc.util.minecraft.ModelRegistryHelper;

public class MNCBlocks {
	
	public static Block bigMushBase;
	public static Block bigMushTop;
	public static Block smog;
	public static Block netherLog;
	public static Block netherPlanks;
	public static Block netherMushroom;
	public static Block infusedNetherrack = Blocks.NETHERRACK; //TODO
	public static Block goldOreNether;
	
	/*public static Block obsidianSlab;
	public static Block obsidianStair;
	public static Block obsidianFence;
	public static Block obsidianWall;
	public static Block obsidianFenceGate;
	public static Block obsidianTrapDoor;
	public static Block obsidianDoor;
	public static Block obsidianDoorHidden;
	//Glowstone, Netherbrick, Netherwood --> try as much metadata as possible
	
	public static Block soulSandEnchanted;
	public static Block grassPathEnchanted;*/
	
	
	
	public static void initBlocks()
	{
		bigMushBase = new BlockBigMushBase("mushBase").setLightLevel(0.1f).setHardness(1.0F).setResistance(150.0F);
		bigMushTop = new BlockBigMushTop("mushTop").setLightLevel(0.3f).setHardness(1.0F);
		smog = new BlockSmog("smog");
		netherLog = new BlockNetherLog("netherLog").setHardness(7.25F).setResistance(3.75F).setLightLevel(0.3f);
		netherPlanks = new MNCBlock(Material.WOOD, SoundType.WOOD, "netherPlanks").setHardness(6F).setResistance(3.5F);
		netherMushroom = new BlockNetherMushroom("netherMushroom_plant");
	}
	
	public static void registerBlocks()
	{
		registerDefaultBlock(bigMushBase);
		registerDefaultBlock(bigMushTop);
		registerDefaultBlock(smog);
		registerDefaultBlock(netherLog);
		registerDefaultBlock(netherPlanks);
		registerDefaultBlock(netherMushroom);
	}
	
	private static void registerDefaultBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName().getResourcePath()));
		
	}
	
	
	public static void registerOreDict()
	{
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerBlockModels()
	{
		ModelRegistryHelper.registerBlockModel(bigMushBase, 0);
		ModelRegistryHelper.registerBlockModel(bigMushTop, 0);
		ModelRegistryHelper.registerBlockModel(smog, 0);
		ModelRegistryHelper.registerBlockModel(netherLog, 0);
		ModelRegistryHelper.registerBlockModel(netherPlanks, 0);
		ModelRegistryHelper.registerBlockModel(netherMushroom, 0);
	}
	
	

}
