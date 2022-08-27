package com.wispy.ArrowTracer.entity;

import com.wispy.ArrowTracer.ArrowTracer;
import com.wispy.ArrowTracer.entity.projectile.TracerArrow;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ArrowTracer.MODID);

    public static final RegistryObject<EntityType<TracerArrow>> TRACER_ARROW;
    
    static {
        TRACER_ARROW = ENTITIES.register("tracer_arrow", () -> EntityType.Builder.<TracerArrow>of(TracerArrow::new, MobCategory.MISC)
            .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(ArrowTracer.MODID, "tracer_arrow").toString()));
    }

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

}
