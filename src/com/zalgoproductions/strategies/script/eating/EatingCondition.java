package com.zalgoproductions.strategies.script.eating;

import com.zalgoproductions.script.TFighterBeyond;
import com.zalgoproductions.strategies.script.exit.ExitCondition;
import com.zalgoproductions.strategies.script.exit.ExitTask;
import com.zalgoproductions.util.Eating;

import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.concurrent.strategy.Condition;

public class EatingCondition implements Condition {
	public boolean validate() {
		Tabs.INVENTORY.open();
		if(Eating.getCurrentPercent() <= Eating.getEatPercent()) {
			if(Inventory.getCount(Eating.foodFilter) > 0) {
				return true;
			}
			ExitCondition.stopScript();
		}
		return false;
	}
}
