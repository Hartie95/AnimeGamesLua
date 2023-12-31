package org.anime_game_servers.gi_lua.models.scene.group;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class SceneGarbage {
	private List<SceneMonster> monsters;
	private List<SceneGadget> gadgets;
	private List<SceneRegion> regions;
	private List<SceneTrigger> triggers;

	public boolean isEmpty() {
		return gadgets == null || gadgets.isEmpty();
	}
}
