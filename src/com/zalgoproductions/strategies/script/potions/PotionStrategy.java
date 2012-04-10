package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Sleeping;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.Item;


public abstract class PotionStrategy extends Strategy implements Task {
	private final int[] potionIDs;

	protected PotionStrategy(int[] ids) {
		potionIDs = ids;
	}

	public boolean validate() {
		boolean hasPotion = false;
outerLoop:
		for(Item item : Inventory.getItems()) {
			for(int id : potionIDs) {
				if(item.getId() == id) {
					hasPotion = true;
					break outerLoop;
				}
			}
		}
		return hasPotion && needsPotion();
	}
	
	protected abstract boolean needsPotion();

	public void run() {
		Item potion = null;
outerLoop:
		for(Item item : Inventory.getItems()) {
			for(int id : potionIDs) {
				if(item.getId() == id) {
					potion = item;
					break outerLoop;
				}
			}
		}
		if(potion != null) {
			potion.getWidgetChild().click(true);
			Time.sleep(Random.nextInt(1000, 1250));
		}
	}
}
