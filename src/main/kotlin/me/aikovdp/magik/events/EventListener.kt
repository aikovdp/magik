package me.aikovdp.magik.events

import kotlin.reflect.KClass

open class EventListener<T : Any> {
    private val listeners: MutableMap<KClass<out T>, MutableList<Handler<*>>> = mutableMapOf()

    fun <E : T> register(
        eventType: KClass<E>,
        precondition: (E) -> Boolean = { true },
        handler: (E) -> Unit
    ) {
        listeners.computeIfAbsent(eventType) { mutableListOf() }
            .add(Handler(precondition, handler))
    }

    fun <E : T> handleEvent(e: E) {
        val handlers = listeners[e::class] ?: return
        handlers
            .filterIsInstance<Handler<E>>()
            .filter { it.precondition(e) }
            .forEach {
                it.handler(e)
                handlers.remove(it)
            }
    }

    private data class Handler<E>(
        val precondition: (E) -> Boolean,
        val handler: (E) -> Unit
    )
}
