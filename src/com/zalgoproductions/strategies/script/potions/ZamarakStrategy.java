package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.tab.Skills;

public class ZamarakStrategy extends PotionStrategy{
	public ZamarakStrategy() {
		super(Potions.ZAMORAK_POTIONS);
	}

	protected boolean needsPotion() {
		return Skills.getLevel(Skills.STRENGTH) <= Skills.getRealLevel(Skills.STRENGTH) &&
				Skills.getLevel(Skills.ATTACK) <= Skills.getRealLevel(Skills.ATTACK);
	}
}
