package me.aikovdp.magik

class Move<S, T>(
    private val actions: Context<S, T>.() -> Unit
) {
    fun execute(source: S, target: T) {
        actions(Context(source, target))
    }
}

fun <S, T> move(actions: Context<S, T>.() -> Unit): Move<S, T> {
    return Move(actions)
}
