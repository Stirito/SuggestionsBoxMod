package com.bystirith.suggestionsboxmod.core.init;

import com.bystirith.suggestionsboxmod.SuggestionsBoxMod;
import com.bystirith.suggestionsboxmod.items.ObsidianArrow;
import com.bystirith.suggestionsboxmod.items.PetCage;

import net.minecraft.item.Item;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuggestionsBoxMod.MOD_ID);
	
	public static final RegistryObject<Item> PET_CAGE = ITEMS.register("pet_cage", () -> new PetCage());
	public static final RegistryObject<Item> OBSIDIAN_ARROW_ITEM = ITEMS.register("obsidian_arrow_item", () -> new ObsidianArrow(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
}
