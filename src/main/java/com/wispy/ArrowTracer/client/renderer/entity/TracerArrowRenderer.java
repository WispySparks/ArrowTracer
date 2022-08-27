package com.wispy.ArrowTracer.client.renderer.entity;

import com.wispy.ArrowTracer.entity.projectile.TracerArrow;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TracerArrowRenderer extends ArrowRenderer<TracerArrow> {

    public static final ResourceLocation NORMAL_ARROW_LOCATION = new ResourceLocation("textures/entity/projectiles/nothing.png");

    public TracerArrowRenderer(Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(TracerArrow pEntity) {
        return NORMAL_ARROW_LOCATION;
    }
    
}
