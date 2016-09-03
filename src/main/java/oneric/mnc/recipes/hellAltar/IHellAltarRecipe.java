package oneric.mnc.recipes.hellAltar;

import java.util.List;
import java.util.Set;
import java.util.Stack;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3i;
import oneric.mnc.util.general.CircularList;

public interface IHellAltarRecipe {

	public boolean matchesRecipie(ItemStack centerIn, CircularList<ItemStack> outerIn);
	
	public Set<ItemStack> getOutput(ItemStack centerIn, CircularList<ItemStack> outerIn);
	
	public Vec3i getBloodCost(ItemStack centerIn);
}
