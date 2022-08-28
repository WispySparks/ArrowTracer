package com.wispy.ArrowTracer.events;

import com.wispy.ArrowTracer.enchantment.TracingEnchantment;
import com.wispy.ArrowTracer.entity.projectile.TracerArrow;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEvents {

    @SubscribeEvent
    public void playerTickEvent(TickEvent.PlayerTickEvent event) { // handle the tracing arrow code
        Player player = event.player;
        if (player.tickCount % 3 != 0) return;
        if (player.getUseItem().getItem() instanceof BowItem) {
            BowItem bow = (BowItem) player.getUseItem().getItem();
            if (bow.getEnchantmentLevel(player.getUseItem(), TracingEnchantment.tracingEnchantment) > 0) { // now you have a tracing bow thats charging
                int charge = bow.getUseDuration(player.getUseItem()) - player.getUseItemRemainingTicks();
                float velocity = BowItem.getPowerForTime(charge);
                if (velocity >= 1) {
                    AbstractArrow arrow = new TracerArrow(player, player.level);
                    arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity * 3.0F, 0);
                    player.level.addFreshEntity(arrow);
                }
            }
        }
    }

    @SubscribeEvent
    public void arrowHit(LivingDamageEvent event) {
        if (event.getEntity() == TracerArrow.target) {
            if (event.getEntity().getTags().contains("tracered")) {
                event.getEntity().setGlowingTag(false);
                event.getEntity().removeTag("tracered");
            }
        }
    }

}