package com.wispy.ArrowTracer.enchantments;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.client.ClientCommandHandler;

public class ArrowTracerEnchantment extends Enchantment {

    public ArrowTracerEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.BOW, pApplicableSlots);
    }
    
    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        // EntityType.LIGHTNING_BOLT.spawn((ServerLevel) pAttacker.level, null, null, pTarget.blockPosition(), MobSpawnType.TRIGGERED, true, true);
        EntityType.SKELETON_HORSE.spawn((ServerLevel) pAttacker.level, null, null, pTarget.blockPosition(), MobSpawnType.TRIGGERED, true, true);
        String pos = pTarget.getX() + " " + pTarget.getY() + " " + pTarget.getZ();
        ClientCommandHandler.runCommand("/summon skeleton_horse " + pos + " {SkeletonTrap:1}");
        System.out.println("/summon skeleton_horse " + pos + " {SkeletonTrap:1}");
    }

}
