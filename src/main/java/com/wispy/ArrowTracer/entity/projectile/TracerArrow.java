package com.wispy.ArrowTracer.entity.projectile;

import com.wispy.ArrowTracer.entity.ModEntityTypes;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class TracerArrow extends AbstractArrow {

    public static Entity target;
    
    public TracerArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.setSilent(true);
    }

    public TracerArrow(LivingEntity shooter, Level level) {
        super(ModEntityTypes.TRACER_ARROW.get(), shooter, level);
        this.setSilent(true);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.ARROW);    
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 2 == 0) {
            if (this.getOwner() == null) return;
            if (this.distanceTo(this.getOwner()) > 4) {
                this.level.addAlwaysVisibleParticle(ParticleTypes.SMOKE, true,
                this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) { // discard arrow on entity hit
        if (pResult.getEntity() != TracerArrow.target && TracerArrow.target != null) {
            TracerArrow.target.setGlowingTag(false);
            TracerArrow.target.removeTag("tracered");
        }
        TracerArrow.target = pResult.getEntity();
        TracerArrow.target.setGlowingTag(true);
        TracerArrow.target.addTag("tracered");
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) { // discard arrow on block hit
        if (TracerArrow.target != null) {
            TracerArrow.target.setGlowingTag(false);
        }
        this.discard();
    }
    
}
