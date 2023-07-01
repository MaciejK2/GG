package me.zircta.listener

import net.minecraft.client.Minecraft
import net.weavemc.loader.api.event.ChatReceivedEvent
import net.weavemc.loader.api.event.ServerConnectEvent
import net.weavemc.loader.api.event.SubscribeEvent

class ChatListener {
    private var currentServer: String = ""

    @SubscribeEvent
    fun onServerConnect(event: ServerConnectEvent) {
        val ip = event.ip
        currentServer = when {
            ip.contains("voxyl") || ip.contains("bedwarspractice") -> "voxyl"
            ip.contains("mineman") || ip.contains("minemen") -> "mmc"
            ip.contains("kokscraft") || ip.contains("kokscraft") -> "kokscraft"
            else -> ""
        }
    }

    @SubscribeEvent
    fun onChatReceived(event: ChatReceivedEvent) {
        val message = event.message.unformattedText
        when (currentServer) {
            "voxyl" -> {
                if (message.startsWith("You have gained") && message.contains("XP from this game!")) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/ac gg")
                }
            }
            "mmc" -> {
                if (message == "Match Results (click player to view):") {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("gg")
                }
            }
            "kokscraft" -> {
                if (message.startsWith("+") && message.contains("XP (mnoznik:")) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("gg")
                }
            }
        }
    }
}
