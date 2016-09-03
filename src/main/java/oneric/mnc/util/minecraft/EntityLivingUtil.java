package oneric.mnc.util.minecraft;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;

public class EntityLivingUtil {
	
	/**
	 * Adds a PotionEffect, considering already applied PotionEffects.
	 * If no PotionEffect of the same type is already applied the desired effect is simply added.
	 * If however the Entity is already under the effect of a PotionEffect of the same type, then:   <br />
	 * <ul>
	 * 	<li>If the already added effect is of the same level as the desired effect the remaining time of both is summed up.</li>
	 * 	<li>If the already added effect is <strong>not</strong> of the same level, the player will get the effect of the higher level. The times of both effects are added together, <strong>but</strong> 
	 * 		the time is halved for every level its weaker.</li>
	 * </ul>
	 * */
	public static void stackPotionEffect(EntityLivingBase entity, PotionEffect effectAdd) {
		PotionEffect active = entity.getActivePotionEffect(effectAdd.getPotion());
		if(active != null)
		{
			int levelDifference = effectAdd.getAmplifier() - active.getAmplifier();
			if(levelDifference < 0){
				entity.addPotionEffect( new PotionEffect(effectAdd.getPotion(), active.getDuration() + (int)(Math.pow(2, levelDifference) * effectAdd.getDuration()), active.getAmplifier() ));
			} else {
				entity.addPotionEffect( new PotionEffect(effectAdd.getPotion(), effectAdd.getDuration() + (int)(Math.pow(0.5, levelDifference) * active.getDuration()), effectAdd.getAmplifier()));
			}
		}
		else {
			entity.addPotionEffect(effectAdd);
		}	
	}

}
