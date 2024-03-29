package org.anime_game_servers.lua.models

import org.anime_game_servers.lua.engine.Class
import kotlin.jvm.JvmField

open class IntLuaValue(protected val value: Int) : MockLuaValue {
    override fun isInteger() = true

    override fun asBoolean() = value != 0
    override fun asInteger() = value
    override fun asLong() = value.toLong()
    override fun asDouble() = value.toDouble()
    override fun asFloat() = value.toFloat()
    override fun asString() = value.toString()

    override fun <T> asObject(type: Class<T>): T? = null

    companion object {
        @JvmField
        val ZERO = IntLuaValue(0)
        @JvmField
        val ONE = IntLuaValue(1)
        @JvmField
        val N_ONE = IntLuaValue(-1)
    }
}
