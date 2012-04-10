package com.zalgoproductions.strategies.script.safespot;

import com.zalgoproductions.util.Sleeping;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.Calculations;
import com.zalgoproductions.util.Safespot;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

public class SafespotTask implements Task {
	public void run() {
		if (!Calculations.isPointOnScreen(Safespot.startTile.getCentralPoint()) ?
				Walking.walk(Safespot.startTile) : 
				Safespot.startTile.click(true)) {
			Sleeping.waitWhileMoving();
			Time.sleep(Random.nextInt(200, 500));
		}
	}
}
