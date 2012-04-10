package com.zalgoproductions.strategies.script.alchemy;

import com.zalgoproductions.util.Alchemy;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class AlchTask implements Task {
	public void run() {
		for(Item i : Inventory.getItems()) {
			if(Alchemy.ALCH_FILTER.accept(i)) {
				Alchemy.alch(i);
			}
		}
	}
}
