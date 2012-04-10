package com.zalgoproductions.strategies.script.antiban;

import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.client.input.Canvas;

//TODO WRITE AFTER RANDOM METHODS
public class AntibanTask implements Task {
	public void run() {
		//TODO Move mouse randomly
		//TODO Move camera randomly
		//TODO Open tab randomly
		
		if (System.currentTimeMillis() > AntibanCondition.nextAntiban) {
			AntibanCondition.nextAntiban = System.currentTimeMillis() + Random.nextInt(2000, 30000);
		} else {
			return;
		}

		Thread mouseThread = new Thread() {
			public void run() {
				switch(Random.nextInt(0, 5)) {
					case 0:
						Mouse.putSide(Random.nextInt(0, 5));
						break;
					case 1:
					case 2:
						Mouse.move(Random.nextInt(0, Canvas.WIDTH), Random.nextInt(0, Canvas.HEIGHT));
						break;
				}
			}
		};

		Thread keyThread = new Thread() {
			public void run() {
				switch(Random.nextInt(0, 4)) {
					case 0:
					case 1:
					case 2:
						Camera.setAngle(Camera.getYaw()  + Random.nextInt(-100, 100));
						break;
				}
			}
		};

		int decision = Random.nextInt(1, 14);
		if(decision < 5) {
			keyThread.start();
			Time.sleep(Random.nextInt(0, 600));
			mouseThread.start();
		} else if (decision < 11) {
			mouseThread.start();
			Time.sleep(Random.nextInt(0, 600));
			keyThread.start();
		} else if (decision == 13) {
			Tabs tab = Tabs.getCurrent();
			Tabs.STATS.open();
			long timer = System.currentTimeMillis();
			while(tab == Tabs.getCurrent() && System.currentTimeMillis() - timer < 1000) {
				Time.sleep(Random.nextInt(50, 90));
			}
//			int decision2 = Random.nextInt(1, 4);
//			if(decision2 == 1)
//				kills.doHover(1);
//			else if (decision2 == 2)
//				skills.doHover(4);
//			else if (decision2 == 3)
//				skills.doHover(22);
			Time.sleep(Random.nextInt(4000, 5000));
		}
		while(keyThread.isAlive() || mouseThread.isAlive()) {
			Time.sleep(Random.nextInt(30, 100));
		}
	}
}
