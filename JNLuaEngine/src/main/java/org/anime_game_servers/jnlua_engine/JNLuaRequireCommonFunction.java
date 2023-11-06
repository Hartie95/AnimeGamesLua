package org.anime_game_servers.jnlua_engine;

import io.github.oshai.kotlinlogging.KLogger;
import io.github.oshai.kotlinlogging.KotlinLogging;
import lombok.val;
import org.terasology.jnlua.LuaState;
import org.terasology.jnlua.NamedJavaFunction;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Files;

import static org.anime_game_servers.lua.engine.LuaEngine.scriptFinder;

public class JNLuaRequireCommonFunction implements NamedJavaFunction {
    private static KLogger logger = KotlinLogging.INSTANCE.logger(JNLuaEngine.class.getName());
    private static JNLuaRequireCommonFunction INSTANCE;
    @Override
    public int invoke(LuaState luaState) {
        val requiredName = luaState.checkString(1);
        luaState.remove(1);
        val path = "Common/" + requiredName + ".lua";
        val includePath = scriptFinder.getScriptPath(path);
        if (!Files.exists(includePath)) {
            logger.error(() -> "Require script not found. " + path);
            return 1;
        }
        try {
            val includeScript = Files.newInputStream(includePath);
            luaState.load(includeScript, requiredName, "t");
            luaState.call(0, 0);
        } catch (IOException e) {
            logger.error(e, ()-> "Error on loading require script. " + path);
            return 2;
        }
        return 0;
    }

    @Override
    public String getName() {
        return "require";
    }
}
