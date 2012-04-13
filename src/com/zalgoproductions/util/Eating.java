package com.zalgoproductions.util;

import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.node.Item;

public class Eating {
	private static int eatPercent = 70;
	private static int[] eatIds = {};
	private static String[] eatNames = {};

	public static final Filter<Item> foodFilter = new Filter<Item>() {
		public boolean accept(Item item) {
			for(int id : eatIds) {
				if (item.getId() == id) {
					return true;
				}
			}
			for(String name : eatNames) {
				if(item.getName() != null && item.getName().toLowerCase().contains(name.toLowerCase())) {
					return true;
				}
			}
			return false;
		}
	};

	public static void setEatIds(int[] ids) {
		eatIds = ids;
	}

	public static void setEatNames(String[] names) {
		eatNames = names;
	}
	
	public static int getCurrentPercent() {
		int hpLevel = Skills.getLevel(Skills.CONSTITUTION);
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
