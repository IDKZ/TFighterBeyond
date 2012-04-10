package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.tab.Skills;

public class DefenseStrategy extends PotionStrategy{
	public DefenseStrategy() {
		super(Potions.DEFENSE_POTIONS);
	}

	@Override
	protected boolean needsPotion() {
		return Skills.getLevel(Skills.DEFENSE) <= Skills.getRealLevel(Skills.DEFENSE);
	}
}
