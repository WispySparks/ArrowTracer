package com.wispy.ArrowTracer.enchantment;

import com.wispy.ArrowTracer.ArrowTracer;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, ArrowTracer.MODID);

    public static final RegistryObject<Enchantment> TRACING_ENCHANTMENT; 
    
    static {
        TRACING_ENCHANTMENT = ENCHANTMENTS.register("tracing_enchantment", () -> TracingEnchantment.tracingEnchantment);
    }

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

}
