package com.wispy.ArrowTracer.events;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {

    @SubscribeEvent
    public void joinWorld(BlockEvent.BreakEvent event) {
        Minecraft mc = Minecraft.getInstance();
        mc.player.sendSystemMessage(Component.translatable("Testing"));
    }

}