package com.wispy.ArrowTracer.entities;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class TracerArrow extends Arrow {
    
    public TracerArrow(Level level, LivingEntity shooter) {
        super(level, shooter);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround) {
            System.out.println("ticking!!!");
            this.level.addParticle(ParticleTypes.HEART, 
            this.getX(), this.getY()+ 10, this.getZ(), 10, 10, 10);
        }
    }

}
