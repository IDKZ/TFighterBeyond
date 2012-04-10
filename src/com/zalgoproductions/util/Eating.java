package com.zalgoproductions.util;

import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.node.Item;

public class Eating {
	private static int eatPercent = 60;

	public static final Filter<Item> foodFilter = new Filter<Item>() {
		public boolean accept(Item item) {
			if(item.getDefinition() != null) {
				for(String action : item.getDefinition().getActions()) {
					if(action.contains("Eat")) {
						return true;
					}
				}
			}
			return false;
		}
	};
	
	public static int getCurrentPercent() {
		int hpLevel = Skills.getLevel(3);
		int totalHp = hpLevel * 10;
		int currHp = Integer.parseInt(Widgets.get(748, 8).getText());
		double decimal = totalHp / currHp;
		return (int)decimal * 100;
	}
	
	public static void setEatPercent(final int percent) {
		eatPercent = percent;
	}
	
	public static int getEatPercent() {
		return eatPercent;
	}
}
