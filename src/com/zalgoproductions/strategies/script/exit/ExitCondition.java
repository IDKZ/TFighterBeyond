package com.zalgoproductions.strategies.script.exit;

import org.powerbot.concurrent.strategy.Condition;

public class ExitCondition implements Condition {
	private static boolean needStop = false;

	public boolean validate() {
		return needStop;
	}

	public static void stopScript() {
		needStop = true;
	}
}
