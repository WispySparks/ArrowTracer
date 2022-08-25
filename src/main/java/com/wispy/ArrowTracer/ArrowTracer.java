package com.wispy.ArrowTracer;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.wispy.ArrowTracer.events.Events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(ArrowTracer.modID)
public class ArrowTracer {

    public static final String modID = "arrowtracer";
    public static final Logger logger = LogUtils.getLogger();

    public ArrowTracer() {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Events());
    }

}