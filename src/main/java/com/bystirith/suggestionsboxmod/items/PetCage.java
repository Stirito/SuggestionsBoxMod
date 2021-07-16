package com.bystirith.suggestionsboxmod.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;

import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;



public class PetCage extends Item {

	
	
	
	public PetCage() {
		super(new Item.Properties().tab(ItemGroup.TAB_TOOLS));
		
	}

	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		// TODO Auto-generated method stub
		return 10;
	}
	
	
	
	
	@SuppressWarnings("resource")
	@Override
	public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
		
		if(!context.getLevel().isClientSide )
		{
			if(stack.getTag().get("StockedMobTypeRegistryName") != null && stack.getTag().get("StockedMobNBT") != null)
			{
				System.out.println(stack.getTag().get("StockedMobTypeRegistryName"));
				EntityType<?> t = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(stack.getTag().get("StockedMobTypeRegistryName").getAsString()));
				LivingEntity copymob =  (LivingEntity) t.create(context.getLevel());
				copymob.deserializeNBT((CompoundNBT) stack.getTag().get("StockedMobNBT"));
				copymob.setPos(context.getClickedPos().getX()+0.5,context.getClickedPos().getY()+1,context.getClickedPos().getZ()+0.5);
		        context.getLevel().addFreshEntity(copymob);
		        
		        this.resetStockedMob(stack,context.getPlayer());
		        return ActionResultType.SUCCESS;
			}else
			{
				context.getPlayer().displayClientMessage(new StringTextComponent("Try to use it on a pet"), false);
				return ActionResultType.FAIL;
			}
			
		}
		return ActionResultType.FAIL;
	}
	
	@Override
	public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player,
			LivingEntity entity, Hand hand) {
		
		
		
		
		if(!player.level.isClientSide)
		{
			
			CompoundNBT nbt = stack.getOrCreateTag();
			
			if(nbt.get("StockedMobTypeRegistryName") == null && nbt.get("StockedMobNBT") == null)
			{
				
				nbt.putString("StockedMobTypeRegistryName", entity.getType().getRegistryName().toString());
				nbt.put("StockedMobNBT", entity.serializeNBT());
				
				entity.remove();
				player.setItemSlot(EquipmentSlotType.MAINHAND, stack);
			}else
			{
				player.displayClientMessage(new StringTextComponent("Already have a pet in it"), false);
				return ActionResultType.FAIL;
			}
			
			
			
		}
		
		
		return ActionResultType.SUCCESS;
		
		
	}
	
	
	
	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> lore,
			ITooltipFlag flag) {

		
			if(stack.getTag() != null && stack.getTag().get("StockedMobNBT") != null)
			{
				//"\u00A74"+stack.getTag().get("StockedMobTypeRegistryName").toString())
				lore.add(new StringTextComponent("\u00A74"+stack.getTag().get("StockedMobTypeRegistryName").toString()));
				
			}else
			{
				lore.add(new StringTextComponent("\u00A7b"+"Empty"));
				
			}

		super.appendHoverText(stack, world,lore,flag);
		
	}
	
	
	public void resetStockedMob(ItemStack stack, PlayerEntity player)
	{
		
		stack.getTag().remove("StockedMobTypeRegistryName");
		stack.getTag().remove("StockedMobNBT");
		player.setItemSlot(EquipmentSlotType.MAINHAND, stack);
	}
	
	
	
	
}
