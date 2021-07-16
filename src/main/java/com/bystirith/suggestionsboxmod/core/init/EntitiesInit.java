package com.bystirith.suggestionsboxmod.core.init;

import com.bystirith.suggestionsboxmod.SuggestionsBoxMod;
import com.bystirith.suggestionsboxmod.entities.ObsidianArrowEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntitiesInit {

	
	public static final DeferredRegister<EntityType<?>> ENTITIES_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SuggestionsBoxMod.MOD_ID);
	
	public static final RegistryObject<EntityType<ObsidianArrowEntity>> OBSIDIAN_ARROW = ENTITIES_TYPES.register("obsidian_arrow", 
			() -> EntityType.Builder.<ObsidianArrowEntity>of(ObsidianArrowEntity::new, EntityClassification.MISC)
            .sized(0.5f, 0.5f)
            .build(new ResourceLocation(SuggestionsBoxMod.MOD_ID, "textures/entity/obsidian_arrow.png").toString()));
		
	
}
