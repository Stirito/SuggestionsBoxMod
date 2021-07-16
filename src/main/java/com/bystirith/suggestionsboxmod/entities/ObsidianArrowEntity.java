package com.bystirith.suggestionsboxmod.entities;



import com.bystirith.suggestionsboxmod.core.init.ItemInit;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ObsidianArrowEntity extends ArrowEntity{

	private int damageArrow = 10;


	public ObsidianArrowEntity(EntityType<ObsidianArrowEntity> type, World world) {
		
		super(type, world);
		// TODO Auto-generated constructor stub
		this.setBaseDamage(damageArrow);
		
	}

	public ObsidianArrowEntity(World world, LivingEntity shooter) {
	      super(world,shooter);
	   }
	
	public ObsidianArrowEntity(World world, double x, double y, double z) {
		
		
	      super(world,x,y,z);
	   }


	@Override
	public IPacket<?> getAddEntityPacket() {
		// TODO Auto-generated method stub
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	public void tick() {
		
		
		
		
		if(!this.onGround)
		{
			this.level.addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D,0.0D);
		}
		
		
		
		super.tick();
	}


	@Override
	protected ItemStack getPickupItem() {
		// TODO Auto-generated method stub
		return new ItemStack(ItemInit.OBSIDIAN_ARROW_ITEM.get());
	}
	
	

}
