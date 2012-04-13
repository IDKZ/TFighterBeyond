package com.zalgoproductions.util;

import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.widget.Widget;

public class Alchemy {
	public static boolean doAlchemy = false;

	private static int[] alchIds = {};
	private static String[] alchNames = {};
	private static final int NATURE_RUNE = 561;
	private static final int FIRE_RUNE = 554;

	public static final Filter<Item> ALCH_FILTER =
			new Filter<Item>() {
				public boolean accept(Item item) {
					for( Item i : Inventory.getItems()) {
						for ( String s : alchNames) {
							if (i.getWidgetChild() != null && i.getId() != -1 && i.getName().toLowerCase().contains(s)) {
								return true;
							}
						}
						for ( int n : alchIds) {
							if( n == i.getId()) {
								return true;
							}
						}
					}
					return false;
				}
			};

	public static void setAlchIds(int[] ids) {
		alchIds = ids;
	}
	
	public static void setAlchNames(String[] names) {
		alchNames = names;
	}
	
	public static boolean canAlch() {
		return canHighAlch() || canLowAlch();
	}
	
	private static boolean canHighAlch() {
		return Inventory.getCount(true, NATURE_RUNE) >= 1 && (Inventory.getCount(true, FIRE_RUNE) >= 5 ||
				Attacking.playerEquipment[3].getName().toLowerCase().contains("fire") ||
				Attacking.playerEquipment[3].getName().toLowerCase().contains("steam") ||
				Attacking.playerEquipment[3].getName().toLowerCase().contains("lava")) &&
				Skills.getLevel(Skills.MAGIC) >= 55;
	}
	
	private static boolean canLowAlch() {
		return Inventory.getCount(true, NATURE_RUNE) >= 1 && (Inventory.getCount(true, FIRE_RUNE) >= 3 ||
				Attacking.playerEquipment[3].getName().toLowerCase().contains("fire") ||
				Attacking.playerEquipment[3].getName().toLowerCase().contains("steam") ||
				Attacking.playerEquipment[3].getName().toLowerCase().contains("lava")) &&
				Skills.getLevel(Skills.MAGIC) >= 21;
	}

	public static void alch(Item i) {
		if (i != null) {
			Tabs.MAGIC.open();
			Widget modernBook = Widgets.get(192);
			if(!modernBook.validate())
				return;
			if(canHighAlch()) {
				modernBook.getChild(59).interact("Cast");
			}
			else if(canLowAlch()) {
				modernBook.getChild(38).interact("Cast");
			}
			Time.sleep(Random.nextInt(150, 500));
			i.getWidgetChild().interact("Cast");
		}
	}
}
