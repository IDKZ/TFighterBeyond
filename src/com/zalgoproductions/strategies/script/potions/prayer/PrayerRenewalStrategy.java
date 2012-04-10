package com.zalgoproductions.strategies.script.potions.prayer;

import com.zalgoproductions.strategies.script.potions.PotionStrategy;
import com.zalgoproductions.util.Potions;
import com.zalgoproductions.util.Prayer;
import org.powerbot.game.api.methods.tab.Skills;

public class PrayerRenewalStrategy extends PotionStrategy{
	public PrayerRenewalStrategy() {
		super(Potions.PRAYER_RENEWAL);
	}

	@Override
	protected boolean needsPotion() {
		int restoration = 120 + 4 * Skills.getRealLevel(Skills.PRAYER);
		int prayerUsed = Prayer.getMaxPrayerPoints() - Prayer.getPrayerPoints();
		return restoration >= prayerUsed;
	}
}
