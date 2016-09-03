package oneric.mnc.common;

import net.minecraftforge.common.config.Configuration;

public class MNCPreferences {
	
	public final boolean enableSurfaceGhasts;
	//public final boolean enableAchievements;
	public final boolean checkForUpdates;
	
	
	public MNCPreferences(Configuration config) {
		enableSurfaceGhasts = config.getBoolean("enableSurfaceGhasts", Configuration.CATEGORY_GENERAL, true, "");
		//enableAchievements =  config.getBoolean("enableAcheivements", Configuration.CATEGORY_GENERAL, true, "");
		checkForUpdates =  config.getBoolean("checkForUpdates", Configuration.CATEGORY_GENERAL, true, "Update-Check not working atm :'(");
		
		config.save();
	}
	
	
	/*Set Up Config 
	(
		EntityIDs; BiomeIDs, (? still numerical IDs ?)
	)
	*/
}
