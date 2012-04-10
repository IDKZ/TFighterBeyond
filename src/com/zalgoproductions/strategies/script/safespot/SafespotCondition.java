package com.zalgoproductions.strategies.script.safespot;

import com.zalgoproductions.util.Safespot;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.interactive.Players;

public class SafespotCondition implements Condition {
	public boolean validate() {
		return Calculations.distance(Players.getLocal().getPosition(), Safespot.startTile) > 0 && Safespot.useSafespot;
	}
}
