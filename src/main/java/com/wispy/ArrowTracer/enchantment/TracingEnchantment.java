package com.wispy.ArrowTracer.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

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
        return false;
    }
    
}
