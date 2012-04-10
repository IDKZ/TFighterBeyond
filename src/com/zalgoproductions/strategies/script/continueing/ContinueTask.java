package com.zalgoproductions.strategies.script.continueing;

import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

public class ContinueTask implements Task {
	public void run() {
		Widgets.clickContinue();
		Time.sleep(Random.nextInt(1200, 1600));
	}
}
