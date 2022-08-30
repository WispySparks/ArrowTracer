package com.wispy.ArrowTracer.enchantment;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

@SuppressWarnings("resource")
public class TracingEnchantment extends Enchantment {

    public static final Enchantment tracingEnchantment =  new TracingEnchantment(EquipmentSlot.MAINHAND);

    public TracingEnchantment(EquipmentSlot... pApplicableSlots) {
        super(Rarity.RARE, EnchantmentCategory.BOW, pApplicableSlots);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.canApplyAtEnchantingTable(this);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override 
    public boolean isAllowedOnBooks() {
        if (Minecraft.getInstance().player.isCreative()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean allowedInCreativeTab(Item book, CreativeModeTab tab) {
        Enchantment eBook = (Enchantment) this;
        if (tab == CreativeModeTab.TAB_SEARCH)
        {
            return eBook.category != null;
        }
        else
        {
            return tab.hasEnchantmentCategory(eBook.category);
        }
    }
    
}
