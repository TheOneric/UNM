package oneric.mnc.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityDerp extends EntityAnimal{

	public EntityDerp(World worldIn) {
		super(worldIn);
		this.setEntityBoundingBox(new AxisAlignedBB(0, 0, 0, 1, 1.5, 1));
		this.setHealth(100.0F);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityDerp(this.worldObj);
	}
	
	get

}
