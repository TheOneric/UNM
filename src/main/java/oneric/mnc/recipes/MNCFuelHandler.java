package oneric.mnc.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class MNCFuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		Item item = fuel.getItem();
		
		//TODO
		
		return 0;
	}
	
	

}
