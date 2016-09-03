package oneric.mnc.recipes.hellAltar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import net.minecraft.item.ItemStack;
import oneric.mnc.util.general.CircularList;

public class HellAltarRegistry {
	
	private List<IHellAltarRecipe> recipies = new ArrayList<>();
	
	public void addRecipie(IHellAltarRecipe recipie) {
		recipies.add(recipie);
	}
	
	public IHellAltarRecipe getMatchingRecipie(ItemStack centerIn, CircularList<ItemStack> outerIn) {
		for(IHellAltarRecipe recp : recipies) {
			if(recp.matchesRecipie(centerIn, outerIn))
				return recp;
		}
		
		return null;
	}
	
	
	public List<IHellAltarRecipe> getAllRecipies() {
		return recipies;
	}
	
}
