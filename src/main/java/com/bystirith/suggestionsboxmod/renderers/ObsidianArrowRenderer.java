package com.bystirith.suggestionsboxmod.renderers;

import com.bystirith.suggestionsboxmod.SuggestionsBoxMod;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.ResourceLocation;

public class ObsidianArrowRenderer extends ArrowRenderer<AbstractArrowEntity>{

	ResourceLocation TEXTURE = new ResourceLocation(SuggestionsBoxMod.MOD_ID, "textures/entity/obsidian_arrow.png");
	
	public ObsidianArrowRenderer(EntityRendererManager entityrenderermanager) {
		super(entityrenderermanager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceLocation getTextureLocation(AbstractArrowEntity p_110775_1_) {
		// TODO Auto-generated method stub
		return TEXTURE;
	}

	
}
