package com.zalgoproductions.util;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.interactive.Npc;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.widget.Widget;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Attacking {
	public static boolean utilizeMultiwayCombat = false;
	public static int[] npcIDs = {};
	public static String[] npcNames = {};
	public static Item[] playerEquipment = {};

	private static int[] specWeaponUsage = {10, 25, 33, 35, 45, 50, 55, 60, 80, 85, 100};
	private static String[][] specWeapons = {
			{"Rune thrownaxe", "Rod of ivandis"},
			{"Dragon Dagger", "Dragon dagger (p)", "Dragon dagger (p+)",
					"Dragon dagger (p++)", "Dragon Mace", "Dragon Spear",
					"Dragon longsword", "Rune claws"},
			{"Dragon Halberd"},
			{"Magic Longbow"},
			{"Magic Composite Bow"},
			{"Dragon Claws", "Abyssal Whip", "Granite Maul", "Darklight",
					"Barrelchest Anchor", "Armadyl Godsword"},
			{"Magic Shortbow"},
			{"Dragon Scimitar", "Dragon 2H Sword", "Zamorak Godsword",
					"Korasi's sword"},
			{"Dorgeshuun Crossbow", "Bone Dagger", "Bone Dagger (p+)",
					"Bone Dagger (p++)"},
			{"Brine Sabre"},
			{"Bandos Godsword", "Dragon Battleaxe", "Dragon Hatchet",
					"Seercull Bow", "Excalibur", "Enhanced excalibur",
					"Ancient Mace", "Saradomin sword"}};
	
	
	private static int maxRadius = 10; //TODO CHANGE TO INT MAX_VALUE AFTER WALKING IS FIXED

	public static Filter<Npc> getNpcFilter() {
		return new Filter<Npc>() {
			public boolean accept(Npc npc) {
				if(npc.validate() && npc.getHpPercent() > 0 && Calculations.distance(Players.getLocal().getPosition(), npc.getPosition()) < maxRadius &&
						(utilizeMultiwayCombat || !npc.isInCombat() && npc.getInteracting() == null)) {
					for(int id : npcIDs) {
						if (npc.getId() == id) {
							return true;
						}
					}
					for(String name : npcNames) {
						if(npc.getName().toLowerCase().contains(name.toLowerCase())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static void initializeEquipment() {
		if (Tabs.getCurrent() != Tabs.EQUIPMENT) {
			Tabs.EQUIPMENT.open();
			Time.sleep(Random.nextInt(900, 1500));
		}
		final Widget equipmentWidget = Widgets.get(387);
		final WidgetChild[] equip = equipmentWidget.getChildren();
		final Item[] items = new Item[12];
		for (int i = 0; i < 11; i++) {
			items[i] = new Item(equip[i * 3 + 6]);
		}
		items[11] = new Item(equip[45]);
		playerEquipment = items;  		

		//6 => Helm
		//9 => Cape
		//12 => Neck
		//15 => Weapon
		//18 => Chest
		//21 => Shield
		//24 => Legs
		//27 => Gloves
		//30 => Shoes
		//33 => Ring
		//36 => Ammo
		//45 => Aura
	}

	public static boolean setSpecialAttack(boolean set) {
		if (isSpecialEnabled() != set) {
			Tabs.ATTACK.open();
			//TODO: UPDATE SPEC BAR LOCATION IF NEEDED
			final WidgetChild specBar = Widgets.get(884, 4);
			if (specBar != null && isSpecialEnabled() != set) {
				return specBar.click(true);
			}
		}
		return false;
	}

	public static boolean shouldSpecial() {
		if(playerEquipment[3] != null) {
			for (int i = 0; i < specWeapons.length; i++) {
				for (int j = 0; j < specWeapons[i].length; j++) {
					if (specWeapons[i][j].equalsIgnoreCase(playerEquipment[3].getName())) {
						return getSpecialBarEnergy() >= specWeaponUsage[i];
					}
				}
			}
		}
		return false;
	}

	private static boolean isSpecialEnabled() {
		return Settings.get(301) == 1;
	}

	private static int getSpecialBarEnergy() {
		return Settings.get(300) / 10;
	}
}
