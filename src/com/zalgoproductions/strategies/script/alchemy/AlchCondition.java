package com.zalgoproductions.strategies.script.alchemy;

import com.zalgoproductions.util.Alchemy;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.tab.Inventory;

public class AlchCondition implements Condition {
	public boolean validate() {
		return Alchemy.doAlchemy && Alchemy.canAlch() && Inventory.getCount(Alchemy.ALCH_FILTER) > 0;
	}
}
