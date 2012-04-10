package com.zalgoproductions.strategies.script.running;

import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

public class RunningTask implements Task {
	public void run() {
		Walking.setRun(true);
		Time.sleep(Random.nextInt(1200, 1600));
	}
}
