package com.zalgoproductions.strategies.script.prayer;

import com.zalgoproductions.util.Prayer;
import org.powerbot.concurrent.strategy.Condition;

public class PrayerCondition implements Condition {

	public boolean validate() {
		return Prayer.usePrayer && !Prayer.isQuickPrayerOn() && Prayer.getPrayerPoints() > 1;
	}
}
