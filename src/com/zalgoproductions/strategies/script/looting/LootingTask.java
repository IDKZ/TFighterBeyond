package com.zalgoproductions.strategies.script.looting;

import com.zalgoproductions.util.Looting;
import com.zalgoproductions.util.Sleeping;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.GroundItem;

import java.util.logging.Logger;

public class LootingTask implements Task {
	public void run() {
		GroundItem nearest = GroundItems.getNearest(Looting.getLootFilter());
		if(nearest.isOnScreen()) {
			int count = Inventory.getCount();
			Looting.takeitem(nearest);
			Sleeping.waitForInventoryChange(count, 1000);
		} else {
			Walking.walk(nearest.getPosition());
			Sleeping.waitWhileMoving();
			Time.sleep((Random.nextInt(200, 500)));
		}
	}
}
