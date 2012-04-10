package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.tab.Skills;

public class MagicStrategy extends PotionStrategy{
	public MagicStrategy() {
		super(Potions.MAGIC_POTIONS);
	}

	@Override
	protected boolean needsPotion() {
		return Skills.getLevel(Skills.MAGIC) <= Skills.getRealLevel(Skills.MAGIC);
	}
}
