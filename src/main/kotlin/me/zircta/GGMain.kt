package me.zircta

import me.zircta.listener.ChatListener
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.event.EventBus

class GGMain: ModInitializer {
    override fun preInit() {
        println("[GG] Initialized")
        EventBus.subscribe(ChatListener())
    }
}
