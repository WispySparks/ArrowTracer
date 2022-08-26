package com.wispy.ArrowTracer;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.wispy.ArrowTracer.enchantments.ArrowTracerEnchantment;
import com.wispy.ArrowTracer.events.Events;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(ArrowTracer.MODID)
public class ArrowTracer {

    public static final String MODID = "arrowtracer";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);
    public static final RegistryObject<Enchantment> TRACING_ENCHANTMENT = ENCHANTMENTS.register("tracing", () -> ArrowTracerEnchantment.tracingEnchantment);

    public ArrowTracer() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Events());
        ENCHANTMENTS.register(bus);
    }

}