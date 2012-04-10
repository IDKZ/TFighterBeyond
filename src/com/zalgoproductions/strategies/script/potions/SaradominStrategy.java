package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.tab.Skills;

public class SaradominStrategy extends PotionStrategy{
	public SaradominStrategy() {
		super(Potions.SARADOMIN_POTIONS);
	}

	protected boolean needsPotion() {
		return Skills.getLevel(Skills.DEFENSE) <= Skills.getRealLevel(Skills.DEFENSE);
	}
}
