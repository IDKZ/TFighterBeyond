package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.tab.Skills;

public class OverloadStrategy extends PotionStrategy{
	public OverloadStrategy() {
		super(Potions.OVERLOAD_POTIONS);
	}

	protected boolean needsPotion() {
		return Skills.getLevel(Skills.STRENGTH) <= Skills.getRealLevel(Skills.STRENGTH) &&
				Skills.getLevel(Skills.ATTACK) <= Skills.getRealLevel(Skills.ATTACK) &&
				Skills.getLevel(Skills.DEFENSE) <= Skills.getRealLevel(Skills.DEFENSE) &&
				Skills.getLevel(Skills.MAGIC) <= Skills.getRealLevel(Skills.MAGIC) &&
				Skills.getLevel(Skills.RANGE) <= Skills.getRealLevel(Skills.MAGIC);
	}
}
