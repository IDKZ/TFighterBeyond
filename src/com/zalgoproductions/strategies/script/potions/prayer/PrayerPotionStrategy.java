package com.zalgoproductions.strategies.script.potions.prayer;

import com.zalgoproductions.strategies.script.potions.PotionStrategy;
import com.zalgoproductions.util.Potions;
import com.zalgoproductions.util.Prayer;
import org.powerbot.game.api.methods.tab.Skills;

public class PrayerPotionStrategy extends PotionStrategy{
	public PrayerPotionStrategy() {
		super(Potions.PRAYER_POTIONS);
	}

	@Override
	protected boolean needsPotion() {
		int restoration = 70 + (int)Math.floor(2.5 * Skills.getRealLevel(Skills.PRAYER));
		int prayerUsed = Prayer.getMaxPrayerPoints() - Prayer.getPrayerPoints();
		return restoration >= prayerUsed;
	}
}
