package com.wispy.ArrowTracer;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.wispy.ArrowTracer.enchantment.ModEnchantments;
import com.wispy.ArrowTracer.entity.ModEntityTypes;
import com.wispy.ArrowTracer.events.ForgeEvents;
import com.wispy.ArrowTracer.events.ModEvents;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArrowTracer.MODID)
public class ArrowTracer {

    public static final String MODID = "arrowtracer";
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public ArrowTracer() { // register my events and registries
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ForgeEvents());
        eventBus.register(new ModEvents());
        ModEnchantments.register(eventBus);
        ModEntityTypes.register(eventBus);
    }

}