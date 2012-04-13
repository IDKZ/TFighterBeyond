package com.zalgoproductions.util;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.methods.node.Menu;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.GroundItem;
import org.powerbot.game.api.wrappers.node.Item;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Looting {
	private static int[] lootIDs = {};
	private static String[] lootNames = {};
	private static int maxRadius = 10; //TODO SET TO INTEGER.MAX_VALUE AFTER WALKING IS FIXED
	private static final HashMap<String, Integer> lootTaken = new HashMap<String, Integer>();

	public static final Filter<GroundItem> LOOT_FILTER =
			new Filter<GroundItem>() {
				public boolean accept(GroundItem item) {
					if(Calculations.distance(Players.getLocal().getPosition(), item.getPosition()) < maxRadius) {
						for(int id : lootIDs) {
							if (item.getGroundItem().getId() == id) {
								return true;
							}
						}
						for(String name : lootNames) {
							if(item.getGroundItem() != null && item.getGroundItem().getDefinition() != null && item.getGroundItem().getDefinition().getName() != null) {
								if(item.getGroundItem().getDefinition().getName().toLowerCase().contains(name.toLowerCase())) {
									return true;
								}
							}
						}
					}
					return false;
				}
			};

	public static void setLootIds(int[] ids) {
		lootIDs = ids;
	}
	
	public static void setLootNames(String[] names) {
		lootNames = names;
	}

	//Author: Zasz
	public static void takeitem(GroundItem item) {
		Point point = item.getCentralPoint();
		point = new Point(point.x - 3, point.y - 10);
		boolean taken = false;
		for (int i = 0; i < 7; i++) {
			Mouse.move(point.x, point.y);
			Time.sleep(50);
			// log.info(item.getGroundItem().getName());
			if (Menu.select("Take", item.getGroundItem().getName())) {
				Sleeping.waitWhileMoving();
				taken = true;
				break;
			}
			if (i > 5) {
				Camera.setAngle(Camera.getAngleTo(Random.nextInt(15, 25)));
			}
			point = new Point(point.x + i, point.y + i);
		}

		if(taken) {
			addLootTaken(item.getGroundItem(), item.getGroundItem().getStackSize());
		}
	}
	



	public static void setMaxRadius(int radius) {
		maxRadius = radius;
	}
	
	private static void addLootTaken(Item itemToAdd, int amount) {
		String name = itemToAdd.getName();
		if (lootTaken.get(name) != null) {
			int newAmount = amount + lootTaken.get(name);
			lootTaken.remove(name);
			lootTaken.put(name, newAmount);
		} else {
			lootTaken.put(name, amount);
		}
	}
	
	public static Map<String, Integer> getLootTaken() {
		return lootTaken;
	}

}
