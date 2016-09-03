package oneric.mnc.common;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import oneric.mnc.entity.passive.EntityDerp;

public class MNCEntities {
	
	//Boss
	//	Demon
	//
	//Dungeon:
	//	Slaughterer
	//
	//General:
	//	Souls, IceGhost, Ice Pigmann, Harpye, + more flying stuff for dead islands
	//
	//Effects:
	//	FireBall, IceBall, Special Arrows, etc
	
	
	public static void register()
	{
		EntityRegistry.registerModEntity(EntityDerp.class, "derp", 1, UltimateNetherMod.instance, 250, 10, true, 0xFFEEFF, 0x005500);
		
	}

}
