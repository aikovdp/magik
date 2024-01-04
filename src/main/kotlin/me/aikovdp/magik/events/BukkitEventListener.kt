package me.aikovdp.magik.events

import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class BukkitEventListener : EventListener<Event>(), Listener {

    @EventHandler
    fun onPlayerMove(e: PlayerMoveEvent) = handleEvent(e)
}
