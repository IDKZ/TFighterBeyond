package com.zalgoproductions.strategies.script.eating;

import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class EatingTask implements Task {
	public void run() {
		Item[] foods = Inventory.getItems();
		Item toEat = null;
		
outerLoop:
		for(Item food : foods) {
			if(food != null && food.getDefinition() != null) {
				for(String action : food.getDefinition().getActions()) {
					if(action.equalsIgnoreCase("Eat")) {
						toEat = food;
						break outerLoop;
					}
				}
			}
		}

		if(toEat != null) {
			toEat.getWidgetChild().interact("Eat");
		}
	}
}
