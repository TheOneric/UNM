package oneric.mnc.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oneric.mnc.achievements.MNCAchievementPage;
import oneric.mnc.proxy.MNCProxyServer;
import oneric.mnc.recipes.MNCFuelHandler;
import oneric.mnc.recipes.MNCRecipes;
import oneric.mnc.util.general.CircularList;

@Mod(modid = UltimateNetherMod.MOD_ID, name = UltimateNetherMod.MOD_NAME, version = UltimateNetherMod.MOD_VERSION)
public class UltimateNetherMod
{
    public static final String MOD_ID = "onerics_mnc";
    public static final String MOD_NAME = "Ultimate-Nether";
    public static final String MOD_VERSION = "1.8.8";
    
    public static MNCPreferences MNC_PREFERENCES;
    
    
    @SidedProxy(clientSide = "oneric.mnc.proxy.MNCProxyClient", serverSide = "oneric.mnc.proxy.MNCProxyServer")
	public static MNCProxyServer proxy;
    @Instance(value = UltimateNetherMod.MOD_ID)
    public static UltimateNetherMod instance = new UltimateNetherMod();
    
    
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    { 	
    	MNC_PREFERENCES = new MNCPreferences(new Configuration(event.getSuggestedConfigurationFile()));
    	
    	//Sounds
    	
    	
    	//RenderPlayerAPI ---- To Be Installed
    	MNCBlocks.initBlocks();
    	MNCBlocks.registerBlocks();
    	MNCItems.initItems();
    	MNCItems.registerItems();
    	MNCEntities.register();
    	proxy.registerAllBlockModels();
    	proxy.registerAllItemModels();
    	
    	MNCRecipes.registerAll();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	AchievementPage.registerAchievementPage(new MNCAchievementPage());
    	
    	MNCItems.registerOreDict();
    	MNCBlocks.registerOreDict();
    	
    	
    	
		//Render Stuff
    	//update Checker
    	//Biomes
    	//Recipes
    	//Events
    	//GameRegistry (WorldGen and such stuff)
    	//Network Registry
    	//Entities
    	//EnumTool and ArmorMaterials
    	
    	GameRegistry.registerFuelHandler(new MNCFuelHandler());
    }
    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	//some other stuff (packets in original)
    }
}
