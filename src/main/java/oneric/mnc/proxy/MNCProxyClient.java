package oneric.mnc.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import oneric.mnc.common.MNCBlocks;
import oneric.mnc.common.MNCItems;
import oneric.mnc.common.UltimateNetherMod;

public class MNCProxyClient extends MNCProxyServer {

	@Override
	public void registerAllBlockModels() {
		MNCBlocks.registerBlockModels();
	}
	
	@Override
	public void registerAllItemModels() {
		MNCItems.registerItemModels();
	}
	
	@Override
	public void registerSounds(){
		//TODO
	}
	
}
