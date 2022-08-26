package com.wispy.ArrowTracer.events;

import com.wispy.ArrowTracer.enchantments.ArrowTracerEnchantment;

import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {

    @SubscribeEvent
    public void arrowCreated(EntityJoinLevelEvent event) {
        if (event.getEntity().getType().equals(EntityType.ARROW)) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getOwner() == null) return;
            for (ItemStack item : arrow.getOwner().getHandSlots()) {
                for (Tag tag : item.getEnchantmentTags()) {
                    if (tag.getAsString().contains("arrowtracer:tracing")) {
                        event.getEntity().addTag("tracing");
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void arrowHit(LivingAttackEvent event) {
        if (event.getSource().getDirectEntity() == null) return;
        if (event.getSource().getDirectEntity().getType().equals(EntityType.ARROW)) {
            Entity arrow = event.getSource().getDirectEntity();
            for (String tag : arrow.getTags()) {
                if (tag.equals("tracing")) {
                    ArrowTracerEnchantment.spawnTrap(arrow.getLevel(), arrow.blockPosition());
                }
            }
        }
    }

}