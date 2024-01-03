package me.aikovdp.magik.actions

import me.aikovdp.magik.Context
import org.bukkit.entity.Damageable
import org.bukkit.entity.Entity

fun <S: Any, T: Damageable> Context<S, T>.damage(
    amount: Double,
    source: Entity? = if (this.source is Entity) this.source else null,
    target: Damageable = this.target
) {
    target.damage(amount, source)
}

fun <S: Any, T: Any> Context<S, T>.damage(
    amount: Double,
    source: Entity? = if (this.source is Entity) this.source else null,
    target: Damageable
) {
    target.damage(amount, source)
}
