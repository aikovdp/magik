package me.aikovdp.magik

import me.aikovdp.magik.actions.damage
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class Magik : JavaPlugin() {

    val move: Move<Player, Player> = move {
        damage(2.0)
    }

    val move2: Move<Location, Player> = move {
        damage(2.0)
    }

    val move3: Move<Player, Player> = move {
        damage(
            amount = 2.0,
            target = source
        )
    }
}
