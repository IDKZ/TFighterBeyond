package com.zalgoproductions.strategies.script.explorersring;

import com.zalgoproductions.util.Attacking;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

import java.util.logging.Logger;

public class RingTask implements Task {
	public void run() {
		Logger logger = Logger.getLogger("RingTask");
		logger.info("Called!");
		Tabs.EQUIPMENT.open();
		Attacking.playerEquipment[9].getWidgetChild().interact("Run-replenish");
		long millis = System.currentTimeMillis();
		int run = Walking.getEnergy();
		while(System.currentTimeMillis() - millis < 5000 && run == Walking.getEnergy()) {
			Time.sleep(Random.nextInt(50, 70));
		}
		if(Widgets.get(211, 1) != null &&
				Widgets.get(211, 1).getText().contains("Your ring appears")) {
			RingCondition.charged = false;
		}
	}
}
