package com.wispy.ArrowTracer.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class TracerEnchantment extends Enchantment {

    public static final Enchantment tracingEnchantment =  new TracerEnchantment(EquipmentSlot.MAINHAND);

    public TracerEnchantment(EquipmentSlot... pApplicableSlots) {
        super(Rarity.RARE, EnchantmentCategory.BOW, pApplicableSlots);
    }
    
}
