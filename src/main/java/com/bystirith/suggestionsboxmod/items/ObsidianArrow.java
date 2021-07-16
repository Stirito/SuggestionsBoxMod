package com.bystirith.suggestionsboxmod.items;

import com.bystirith.suggestionsboxmod.core.init.EntitiesInit;
import com.bystirith.suggestionsboxmod.entities.ObsidianArrowEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class ObsidianArrow extends ArrowItem{

	public ObsidianArrow(Properties prop) {
		super(prop.stacksTo(64));
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public AbstractArrowEntity createArrow(World world, ItemStack stack, LivingEntity player) {
		// TODO Auto-generated method stub
		ObsidianArrowEntity arrow = new ObsidianArrowEntity(EntitiesInit.OBSIDIAN_ARROW.get(),world);
		return arrow;
	}
	
	
	
}
