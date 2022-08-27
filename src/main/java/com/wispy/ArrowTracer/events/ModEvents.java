package com.wispy.ArrowTracer.events;

import com.wispy.ArrowTracer.client.renderer.entity.TracerArrowRenderer;
import com.wispy.ArrowTracer.entity.ModEntityTypes;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {
    
    @SubscribeEvent
    public void entityRendererSetup(EntityRenderersEvent.RegisterRenderers event) { // register my arrow renderer to my arrow
        event.registerEntityRenderer(ModEntityTypes.TRACER_ARROW.get(), TracerArrowRenderer::new);
    }

}
