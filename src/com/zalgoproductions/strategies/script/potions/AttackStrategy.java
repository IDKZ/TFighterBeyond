package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.tab.Skills;

public class AttackStrategy extends PotionStrategy {
	public AttackStrategy() {
		super(Potions.ATTACK_POTIONS);
	}

	@Override
	protected boolean needsPotion() {
		return Skills.getLevel(Skills.ATTACK) <= Skills.getRealLevel(Skills.ATTACK);
	}
}
