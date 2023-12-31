package org.anime_game_servers.gi_lua.utils;

import lombok.val;
import org.anime_game_servers.core.gi.models.Vector;
import org.anime_game_servers.gi_lua.models.PositionImpl;
import org.anime_game_servers.lua.engine.LuaEngine;
import org.anime_game_servers.lua.engine.LuaTable;

public class ScriptUtils {

    public static LuaTable posToLua(Vector position, LuaEngine engine){
        var result = engine.createTable();
        if(position != null){
            result.set("x", position.getX());
            result.set("y", position.getY());
            result.set("z", position.getZ());
        } else {
            result.set("x", 0);
            result.set("y", 0);
            result.set("z", 0);
        }

        return result;
    }

    public static Vector luaToPos(LuaTable position){
        val result = new PositionImpl();
        if(position != null){
            result.setX(position.optInt("x", 0));
            result.setY(position.optInt("y", 0));
            result.setZ(position.optInt("z", 0));
        }

        return result;
    }
}
