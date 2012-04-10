package com.zalgoproductions.strategies.script.looting;

import com.zalgoproductions.util.Looting;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.tab.Inventory;

public class LootingCondition implements Condition {
	public boolean validate() {
		return Inventory.getCount() < 28 && GroundItems.getNearest(Looting.LOOT_FILTER) != null;
	}
}
