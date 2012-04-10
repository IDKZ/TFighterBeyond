package com.zalgoproductions.util;

import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

public class Prayer {

	public static boolean usePrayer;
	
	public static int getPrayerPoints() {
		return Integer.parseInt(Widgets.get(749, 6).getText());
	}
	
	public static int getMaxPrayerPoints() {
		return Skills.getLevel(Skills.PRAYER) * 10;
	}

	public static boolean setQuickPrayer(boolean activate) {
		if (isQuickPrayerOn() != activate) {
			if (getPrayerPoints() > 1) {
				Widgets.get(749, 2).click(true);
				while(isQuickPrayerOn() != activate) {
					Time.sleep(Random.nextInt(200, 300));
				}
			}
		}      		
		return isQuickPrayerOn() == activate;
	}

	public static boolean isQuickPrayerOn() {
		return Widgets.get(749, 0).getTextureId() == 782;
	}
}
