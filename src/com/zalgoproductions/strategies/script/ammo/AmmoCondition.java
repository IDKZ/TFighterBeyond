package com.zalgoproductions.strategies.script.ammo;

import com.zalgoproductions.util.Attacking;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.tab.Inventory;

public class AmmoCondition implements Condition {
	public boolean validate() {
		return Attacking.playerEquipment[3] != null && Attacking.playerEquipment[10] != null &&
				Attacking.playerEquipment[3].getName().contains("bow") &&
				Inventory.getCount(Attacking.playerEquipment[10].getId()) > 0;
	}
}
