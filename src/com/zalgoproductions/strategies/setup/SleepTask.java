package com.zalgoproductions.strategies.setup;

import org.powerbot.concurrent.Task;
import org.powerbot.game.api.util.Time;

public class SleepTask implements Task {
	public void run() {
		Time.sleep(100);
	}
}
