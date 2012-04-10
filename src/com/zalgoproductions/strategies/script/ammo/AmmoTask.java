package com.zalgoproductions.strategies.script.ammo;

import com.zalgoproductions.util.Attacking;
import com.zalgoproductions.util.Sleeping;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class AmmoTask implements Task {
	public void run() {
		for(Item item : Inventory.getItems()) {
			if(item.getId() == Attacking.playerEquipment[10].getId()) {
				int count = Inventory.getCount();
				item.getWidgetChild().interact("Wield");
				Sleeping.waitForInventoryChange(count, 3000);
			}
		}
	}
}
