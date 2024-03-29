package org.anime_game_servers.gi_lua.script_lib

import org.anime_game_servers.gi_lua.script_lib.handler.entites.GroupGadgetHandler
import org.anime_game_servers.gi_lua.script_lib.handler.activity.SummerTimeScriptHandler

interface ScriptLibGroupHandlerProvider<GroupEventContext : GroupEventLuaContext> {
    fun getScriptLibHandler(): ScriptLibHandler<GroupEventContext>

    /* Entity handlers */
    fun getGroupGadgetHandler(): GroupGadgetHandler<GroupEventContext>? = null

    /* Activity handlers */
    fun getSummerTimeScriptHandler(): SummerTimeScriptHandler<GroupEventContext>? = null
}