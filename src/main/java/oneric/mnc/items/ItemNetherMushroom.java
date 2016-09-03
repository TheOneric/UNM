package oneric.mnc.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import oneric.mnc.util.minecraft.EntityLivingUtil;

public class ItemNetherMushroom extends MNCItemFood {

	public ItemNetherMushroom(String name, int amount, float saturation, boolean isWolfFood) {
		super(name, amount, saturation, isWolfFood);
		this.setAlwaysEdible();
	}
	
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(!worldIn.isRemote) {
			EntityLivingUtil.stackPotionEffect(player, new PotionEffect(MobEffects.FIRE_RESISTANCE, 420, 0));
			if(player.getFoodStats().getFoodLevel() == 20) {
				player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 510, 1));
			} else {
				player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 350, 1));
			}
		}
	}

}
