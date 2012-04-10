package com.zalgoproductions.strategies.script.continueing;

import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.Widgets;

public class ContinueCondition implements Condition {

	public boolean validate() {
		return Widgets.canContinue();
	}
}
