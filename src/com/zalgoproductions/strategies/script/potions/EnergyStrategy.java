package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.Walking;


public class EnergyStrategy extends PotionStrategy{
	public EnergyStrategy() {
		super(Potions.ENERGY_POTIONS);
	}

	@Override
	protected boolean needsPotion() {
		return Walking.getEnergy() <= 60;
	}
}
