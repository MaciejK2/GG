package me.zircta

import me.zircta.listener.ChatListener
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.event.EventBus

class ExampleMod: ModInitializer {
    override fun preInit() {
        println("[GG] Initialized")
        EventBus.subscribe(ChatListener())
    }
}
