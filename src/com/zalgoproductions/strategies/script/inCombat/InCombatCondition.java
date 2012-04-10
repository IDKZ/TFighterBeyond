package com.zalgoproductions.strategies.script.inCombat;

import com.zalgoproductions.util.Attacking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.concurrent.strategy.Condition;

public class InCombatCondition implements Condition {
	public boolean validate() {
		return Attacking.getInteracting() != null;
	}
}
