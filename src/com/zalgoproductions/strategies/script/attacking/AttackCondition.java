package com.zalgoproductions.strategies.script.attacking;

import com.zalgoproductions.util.Attacking;
import org.powerbot.game.api.methods.interactive.Npcs;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.interactive.Players;

public class AttackCondition implements Condition {
	public boolean validate() {
		return (Players.getLocal().getInteracting() == null || Players.getLocal().isInCombat()) && Npcs.getNearest(Attacking.getNpcFilter()) != null;
	}
}
