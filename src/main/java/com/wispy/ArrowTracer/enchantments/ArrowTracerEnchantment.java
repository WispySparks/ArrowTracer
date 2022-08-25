package com.wispy.ArrowTracer.enchantments;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ArrowTracerEnchantment extends Enchantment {

    public ArrowTracerEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot... equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }
    
    @Override
    public void doPostHurt(LivingEntity attacker, Entity target, int level) {
        EntityType.LIGHTNING_BOLT.spawn((ServerLevel) attacker.level, null, null, target.blockPosition(), MobSpawnType.TRIGGERED, true, true);
    }

}
