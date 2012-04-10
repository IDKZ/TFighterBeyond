package com.zalgoproductions.strategies.script.attacking;

import com.zalgoproductions.util.Attacking;
import com.zalgoproductions.util.Safespot;
import com.zalgoproductions.util.Sleeping;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Npcs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.interactive.Npc;

public class AttackTask implements Task {
	public void run() {
		Npc nearest = Npcs.getNearest(Attacking.getNpcFilter());
		if(nearest.isOnScreen()) {
			nearest.interact("Attack");
			if(Safespot.useSafespot)
				Sleeping.waitForAnim();
			else {  				
				long start = System.currentTimeMillis();
				while (System.currentTimeMillis() - start < 1500 && !Players.getLocal().isMoving() && 
						Attacking.getNpcFilter().accept(nearest)) {
					Time.sleep(Random.nextInt(50, 200));
				}
				while (Players.getLocal().isMoving() && Attacking.getNpcFilter().accept(nearest)) {
					Time.sleep(Random.nextInt(20, 50));
				}
			}
			if(Attacking.getNpcFilter().accept(nearest)) {
				Time.sleep(Random.nextInt(2000, 3000));
			}
		} else {
			Walking.walk(nearest.getPosition());
			if(Safespot.useSafespot)
				Sleeping.waitForAnim();
			else
				Sleeping.waitWhileMoving();
			Time.sleep((Random.nextInt(200, 500)));
		}
	}
}
