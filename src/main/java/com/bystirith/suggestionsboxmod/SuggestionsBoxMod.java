package com.bystirith.suggestionsboxmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bystirith.suggestionsboxmod.core.init.EntitiesInit;
import com.bystirith.suggestionsboxmod.core.init.ItemInit;
import com.bystirith.suggestionsboxmod.renderers.ObsidianArrowRenderer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("suggestionsboxmod")
@EventBusSubscriber(modid = SuggestionsBoxMod.MOD_ID, bus = Bus.MOD)

public class SuggestionsBoxMod {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "suggestionsboxmod";

	public SuggestionsBoxMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		EntitiesInit.ENTITIES_TYPES.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent e)
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitiesInit.OBSIDIAN_ARROW.get(), ObsidianArrowRenderer::new);
		
	}
	
}
