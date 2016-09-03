package oneric.mnc.achievements;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.AchievementPage;
import oneric.mnc.common.UltimateNetherMod;

public class MNCAchievementPage extends AchievementPage{

	public static final Achievement enterHell = new Achievement(UltimateNetherMod.MOD_ID+".ach.enterHell", UltimateNetherMod.MOD_ID+".enterHell", 0, 0, Blocks.NETHERRACK, null);
	public static final Achievement enterFallenSky = new Achievement(UltimateNetherMod.MOD_ID+".ach.enterFallenSky", UltimateNetherMod.MOD_ID+".enterFallenSky", 0, -2, /*TODO*/Blocks.GRAVEL, enterHell);
	public static final Achievement defeatDaemonLord = new Achievement(UltimateNetherMod.MOD_ID+".ach.defeatDaemon", UltimateNetherMod.MOD_ID+".defeatDaemon", 1, 2, /*TODO*/Items.IRON_HOE, enterHell);
	/*public static final Achievement daemonChicken = new Achievement("mnc.achievement.daemonChicken", "mnc.achievement.daemonChicken", 1, 2, /*TODO*(Item)null, null);
	
		- Created Daemon Chicken (infuse chicken egg with daemonic energy and (?)possibly daemon blodd/essence)
		*/
	
	public MNCAchievementPage() {
		
		super(
				I18n.translateToLocal("mnc.general.gui.achievementPage_name"),
				new Achievement[] {
						enterHell, enterFallenSky, defeatDaemonLord
					} 
				); 
	}

}
