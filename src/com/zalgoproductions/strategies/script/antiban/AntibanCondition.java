package com.zalgoproductions.strategies.script.antiban;

import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.util.Random;

public class AntibanCondition implements Condition {
	public static long nextAntiban = 0;
	public boolean validate() {             		
		return Random.nextInt(0, 5) == 4 && System.currentTimeMillis() > nextAntiban;
	}
}
