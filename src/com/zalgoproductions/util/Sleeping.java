package com.zalgoproductions.util;

import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

public class Sleeping {
	public static void waitWhileMoving() {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < 1500 && !Players.getLocal().isMoving()) {
			Time.sleep(Random.nextInt(50, 200));
		}
		while (Players.getLocal().isMoving()) {
			Time.sleep(Random.nextInt(20, 50));
		}
	}

	public static void waitWhileAnim(int id) {
		while (Players.getLocal().getAnimation() == id) {
			Time.sleep(Random.nextInt(20, 50));
		}
	}

	public static void waitForAnim() {
		long timer = System.currentTimeMillis();
		while(System.currentTimeMillis() - timer < 2500 && Players.getLocal().getAnimation() == -1
				&& (System.currentTimeMillis() - timer < 1000 || Players.getLocal().getInteracting() != null))
			Time.sleep(Random.nextInt(50, 100));
	}

	public static void waitForInventoryChange(int count, int bound) {
		long start = System.currentTimeMillis();
		while(Inventory.getCount() == count && System.currentTimeMillis() < start + bound) {
			Time.sleep(Random.nextInt(20, 50));
		}
	}
}
