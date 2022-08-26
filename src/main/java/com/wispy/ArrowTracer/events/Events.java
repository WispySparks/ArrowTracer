package com.wispy.ArrowTracer.events;

import com.wispy.ArrowTracer.enchantments.ArrowTracerEnchantment;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {

    @SubscribeEvent
    public void tickEvent(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (player.getUseItem().getItem() instanceof BowItem) {
            BowItem bow = (BowItem) player.getUseItem().getItem();
            if (bow.getEnchantmentLevel(player.getUseItem(), ArrowTracerEnchantment.tracingEnchantment) > 0) { // now you have a tracing bow thats charging
                bow.releaseUsing(player.getUseItem(), player.level, player, player.getUseItemRemainingTicks());
                int charge = bow.getUseDuration(player.getUseItem()) - player.getUseItemRemainingTicks();
                float velocity = BowItem.getPowerForTime(charge);
                System.out.println(velocity);
                player.level.addParticle(ParticleTypes.HEART, 
                player.getX(), player.getY(), player.getZ(),
                50, 50, 50);
            }
        }
    }

    @SubscribeEvent
    public void arrowCreated(EntityJoinLevelEvent event) {
        if (event.getEntity().getType().equals(EntityType.ARROW)) {
            Arrow arrow = (Arrow) event.getEntity();
            if (arrow.getOwner() == null) return;
            for (ItemStack item : arrow.getOwner().getHandSlots()) {
                if (item.getItem().getEnchantmentLevel(item, ArrowTracerEnchantment.tracingEnchantment) > 0) {
                    event.getEntity().addTag("tracing");
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
                    // ArrowTracerEnchantment.spawnTrap(arrow.getLevel(), arrow.blockPosition());
                }
            }
        }
    }

}