package com.zalgoproductions.strategies.setup;

import com.zalgoproductions.script.TFighterBeyond;
import org.powerbot.concurrent.strategy.Condition;

public class SetupCondition implements Condition {
	public boolean validate() {
		return TFighterBeyond.needsSetup && !SetupTask.isRunning();
	}
}
