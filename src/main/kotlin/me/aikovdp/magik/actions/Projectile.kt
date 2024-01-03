package me.aikovdp.magik.actions

import me.aikovdp.magik.Context
import org.bukkit.Location
import org.bukkit.entity.BlockDisplay
import org.bukkit.entity.Entity
import org.bukkit.util.Vector

fun <S: Entity, T: Any> Context<S, T>.blockProjectile(
    source: Location = this.source.location,
    direction: Vector = this.source.location.direction,
    speed: Double = 1.0
) {
    source.world.spawn(source, BlockDisplay::class.java) {
        it.velocity = direction.normalize().multiply(speed)
    }

    // TODO: Add onImpact sub-actions

}
