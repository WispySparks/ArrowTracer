package com.wispy.ArrowTracer;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.wispy.ArrowTracer.enchantments.ArrowTracerEnchantment;
import com.wispy.ArrowTracer.events.Events;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(ArrowTracer.modID)
public class ArrowTracer {

    public static final String modID = "arrowtracer";
    public static final Logger logger = LogUtils.getLogger();
    public static final DeferredRegister<Enchantment> enchantments = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, modID);
    public static RegistryObject<Enchantment> tracingEnchantment = enchantments.register("tracing", 
    () -> new ArrowTracerEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));

    public ArrowTracer() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Events());
        enchantments.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}