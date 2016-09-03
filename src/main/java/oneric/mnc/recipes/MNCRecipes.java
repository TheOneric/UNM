package oneric.mnc.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import oneric.mnc.common.MNCBlocks;

public class MNCRecipes {

	public static void registerAll() {
		
		registerCrafting();
		registerHellAltar();
		
	}

	private static void registerCrafting() {
	
		registerToolsCrafting();
		registerArmorCrafting();
		registerWeaponsCrafting();
		registerGeneralCrafting();
		
	}
	
	
	
	private static void registerWeaponsCrafting() {
		// TODO Auto-generated method stub
		
	}

	private static void registerArmorCrafting() {
		// TODO Auto-generated method stub
		
	}

	private static void registerToolsCrafting() {
		// TODO Auto-generated method stub
		
	}
	
	private static void registerGeneralCrafting() {
		GameRegistry.addShapelessRecipe(new ItemStack(MNCBlocks.netherPlanks, 3), new ItemStack(MNCBlocks.netherLog));
		
	}

	

	private static void registerHellAltar() {
		// TODO Auto-generated method stub
		
	}
	
}
