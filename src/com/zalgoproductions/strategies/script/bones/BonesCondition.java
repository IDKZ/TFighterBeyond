package com.zalgoproductions.strategies.script.bones;

import com.zalgoproductions.util.Bones;
import org.powerbot.concurrent.strategy.Condition;
import org.powerbot.game.api.methods.tab.Inventory;

import java.util.logging.Logger;

public class BonesCondition implements Condition{
	public boolean validate() {
		return Inventory.getCount(Bones.getBonesFilter()) > 0 && Bones.buryBones;
	}
}
