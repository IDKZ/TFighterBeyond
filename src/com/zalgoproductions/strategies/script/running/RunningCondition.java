package com.zalgoproductions.strategies.script.running;

import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.util.Random;

import java.util.logging.Logger;

public class RunningCondition implements Condition {
	public boolean validate() {
		return !Walking.isRunEnabled() && Walking.getEnergy() > Random.nextInt(60, 90);
	}
}


