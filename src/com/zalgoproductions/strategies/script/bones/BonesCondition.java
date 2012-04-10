package com.zalgoproductions.strategies.script.bones;

import com.zalgoproductions.util.Bones;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.tab.Inventory;

public class BonesCondition implements Condition{
	public boolean validate() {
		return Inventory.getCount(Bones.bonesFilter) > 0 && Bones.buryBones;
	}
}
