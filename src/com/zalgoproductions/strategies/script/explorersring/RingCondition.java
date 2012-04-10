package com.zalgoproductions.strategies.script.explorersring;

import com.zalgoproductions.util.Attacking;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.Walking;

public class RingCondition implements Condition {
	public static boolean charged = true;
	public boolean validate() {
		return Attacking.playerEquipment[9].getName().equalsIgnoreCase("Explorer's Ring") && charged && Walking.getEnergy() < 60;
	}
}
