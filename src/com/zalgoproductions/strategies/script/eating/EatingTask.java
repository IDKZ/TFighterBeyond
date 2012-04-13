package com.zalgoproductions.strategies.script.eating;

import com.zalgoproductions.util.Eating;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class EatingTask implements Task {
	public void run() {
		Item[] foods = Inventory.getItems();
		Item toEat = null;
		
		for(Item food : foods) {
			if(Eating.foodFilter.accept(food)) {
				toEat = food;
				break;
			}
		}

		if(toEat != null) {
			toEat.getWidgetChild().interact("Eat");
		}
	}
}
