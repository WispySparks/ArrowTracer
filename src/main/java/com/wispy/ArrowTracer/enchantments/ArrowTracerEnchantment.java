package com.wispy.ArrowTracer.enchantments;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public class ArrowTracerEnchantment extends Enchantment {

    public ArrowTracerEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.BOW, pApplicableSlots);
    }
    
    public static void spawnTrap(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            CompoundTag rootTag = new CompoundTag();
            CompoundTag EntityTag = new CompoundTag();
            EntityTag.putInt("SkeletonTrap", 1);
            EntityTag.putString("Team", "guards");
            rootTag.put("EntityTag", EntityTag);
            EntityType.SKELETON_HORSE.spawn((ServerLevel) level, rootTag, null, null, pos, MobSpawnType.TRIGGERED, true, true);
        }
    }

}
