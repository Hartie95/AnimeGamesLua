package org.anime_game_servers.gi_lua.script_lib

import org.anime_game_servers.gi_lua.models.scene.group.SceneGroup
import org.anime_game_servers.gi_lua.models.ScriptArgs

interface GroupEventLuaContext : LuaContext {
    fun getGroupInstance(): SceneGroup
    fun getArgs(): ScriptArgs

    fun <T: GroupEventLuaContext> getScriptLibHandlerProvider(): ScriptLibGroupHandlerProvider<T>
    /*override fun uid() = getArgs().uid
    override fun source_entity_id() = getArgs().source_eid
    override fun target_entity_id() = getArgs().target_eid*/

}