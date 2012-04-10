package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.tab.Skills;

public class StrengthStrategy extends PotionStrategy{
	public StrengthStrategy() {
		super(Potions.STRENGTH_POTIONS);
	}

	@Override
	protected boolean needsPotion() {
		return Skills.getLevel(Skills.STRENGTH) <= Skills.getRealLevel(Skills.STRENGTH);
	}
}
