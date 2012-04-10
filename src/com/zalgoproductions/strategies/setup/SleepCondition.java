package com.zalgoproductions.strategies.setup;

import org.powerbot.concurrent.strategy.Condition;

public class SleepCondition implements Condition {
	public boolean validate() {
		return SetupTask.isRunning();
	}
}
