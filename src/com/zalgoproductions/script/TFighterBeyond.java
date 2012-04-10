package com.zalgoproductions.script;

import com.zalgoproductions.resources.Fonts;
import com.zalgoproductions.strategies.script.antiban.AntibanCondition;
import com.zalgoproductions.strategies.script.antiban.AntibanTask;
import com.zalgoproductions.strategies.script.ammo.AmmoCondition;
import com.zalgoproductions.strategies.script.ammo.AmmoTask;
import com.zalgoproductions.strategies.script.attacking.AttackCondition;
import com.zalgoproductions.strategies.script.attacking.AttackTask;
import com.zalgoproductions.strategies.script.bones.BonesCondition;
import com.zalgoproductions.strategies.script.bones.BonesTask;
import com.zalgoproductions.strategies.script.continueing.ContinueCondition;
import com.zalgoproductions.strategies.script.continueing.ContinueTask;
import com.zalgoproductions.strategies.script.eating.EatingCondition;
import com.zalgoproductions.strategies.script.eating.EatingTask;
import com.zalgoproductions.strategies.script.exit.ExitCondition;
import com.zalgoproductions.strategies.script.exit.ExitTask;
import com.zalgoproductions.strategies.script.explorersring.RingCondition;
import com.zalgoproductions.strategies.script.explorersring.RingTask;
import com.zalgoproductions.strategies.script.inCombat.InCombatCondition;
import com.zalgoproductions.strategies.script.inCombat.InCombatTask;
import com.zalgoproductions.strategies.script.looting.LootingCondition;
import com.zalgoproductions.strategies.script.looting.LootingTask;
import com.zalgoproductions.strategies.script.potions.PotionTask;
import com.zalgoproductions.strategies.script.prayer.PrayerCondition;
import com.zalgoproductions.strategies.script.prayer.PrayerTask;
import com.zalgoproductions.strategies.script.running.RunningCondition;
import com.zalgoproductions.strategies.script.running.RunningTask;
import com.zalgoproductions.strategies.script.safespot.SafespotCondition;
import com.zalgoproductions.strategies.script.safespot.SafespotTask;
import com.zalgoproductions.strategies.setup.SetupCondition;
import com.zalgoproductions.strategies.setup.SetupTask;
import com.zalgoproductions.strategies.setup.SleepCondition;
import com.zalgoproductions.strategies.setup.SleepTask;
import com.zalgoproductions.util.Attacking;
import com.zalgoproductions.util.paint.Display;
import com.zalgoproductions.util.paint.displays.TFighterDisplay;
import com.zalgoproductions.util.paint.Paint;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.interactive.Npcs;
import org.powerbot.game.api.wrappers.interactive.Npc;
import org.powerbot.game.bot.event.listener.PaintListener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Manifest(name = "TFighter Beyond", description = "Universal Fighter", version = 0.1d, authors = {"Zalgo2462"})
public class TFighterBeyond extends ActiveScript implements PaintListener, MouseListener {
	public static boolean needsSetup = true;
	public static long startTime;
	public static final Manifest mani = TFighterBeyond.class.getAnnotation(Manifest.class);
	
	@Override
	protected void setup() {
		log.info("Welcome the TFighter Beyond. Going beyond what reality allows.");
		if(!Game.isLoggedIn()) {
			log.info("Start the script logged in!");
			stop();
		}
		//TODO: CREATE AND SUBMIT TASKS
		Strategy antibanStrategy = new Strategy(new AntibanCondition(), new AntibanTask());
		antibanStrategy.setLock(false);
		antibanStrategy.setReset(false);
		provide(antibanStrategy);

		Strategy stopStrategy = new Strategy(new ExitCondition(), new ExitTask(this));
		stopStrategy.setLock(true);
		stopStrategy.setReset(true);

		Strategy setupStrategy = new Strategy(new SetupCondition(), new SetupTask());
		setupStrategy.setLock(true);
		setupStrategy.setReset(true);
		provide(setupStrategy);
		
		Strategy sleepWhileSetupStrategy = new Strategy(new SleepCondition(), new SleepTask());
		sleepWhileSetupStrategy.setLock(true);
		sleepWhileSetupStrategy.setReset(true);
		provide(sleepWhileSetupStrategy);

		Strategy continueStrategy = new Strategy(new ContinueCondition(), new ContinueTask());
		continueStrategy.setLock(true);
		continueStrategy.setReset(true);
		provide(continueStrategy);
		
		Strategy eatingStrategy = new Strategy(new EatingCondition(), new EatingTask());
		eatingStrategy.setLock(true);
		eatingStrategy.setReset(true);
		provide(eatingStrategy);
		
		Strategy ammoStrategy = new Strategy(new AmmoCondition(), new AmmoTask());
		ammoStrategy.setLock(true);
		ammoStrategy.setReset(true);
		provide(ammoStrategy);
		
		Strategy prayerStrategy = new Strategy(new PrayerCondition(), new PrayerTask());
		prayerStrategy.setLock(true);
		prayerStrategy.setReset(true);
		provide(prayerStrategy);
		
		Strategy ringStrategy = new Strategy(new RingCondition(), new RingTask());
		ringStrategy.setLock(true);
		ringStrategy.setReset(true);
		provide(ringStrategy);

		Strategy runningStrategy = new Strategy(new RunningCondition(), new RunningTask());
		runningStrategy.setLock(true);
		runningStrategy.setReset(true);
		provide(runningStrategy);

		Strategy safespotStrategy = new Strategy(new SafespotCondition(), new SafespotTask());
		safespotStrategy.setLock(true);
		safespotStrategy.setReset(true);
		provide(safespotStrategy);

		PotionTask potionTask = new PotionTask();
		Strategy potionManagerStrategy = new Strategy(potionTask, potionTask);
		potionManagerStrategy.setLock(true);
		potionManagerStrategy.setReset(true);
		provide(potionManagerStrategy);

		Strategy inCombatStrategy = new Strategy(new InCombatCondition(), new InCombatTask());
		inCombatStrategy.setLock(true);
		inCombatStrategy.setReset(true);
		provide(inCombatStrategy);

		Strategy lootingStrategy = new Strategy(new LootingCondition(), new LootingTask());
		lootingStrategy.setLock(true);
		lootingStrategy.setReset(true);
		provide(lootingStrategy);

		Strategy buryingStrategy = new Strategy(new BonesCondition(), new BonesTask());
		buryingStrategy.setLock(true);
		buryingStrategy.setReset(true);
		provide(buryingStrategy);
		
		Strategy attackStrategy = new Strategy(new AttackCondition(), new AttackTask());
		attackStrategy.setLock(true);
		attackStrategy.setReset(true);
		provide(attackStrategy);
	}

	public void onRepaint(final Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(Fonts.BATMAN_FONT.deriveFont(Font.PLAIN, 16));
		if(Paint.shouldPaint()) {
			g.setColor(Color.GREEN);                  `
			for(Npc npc : Npcs.getLoaded(Attacking.getNpcFilter())) {   				
				Polygon[] polygons = npc.getPosition().getBounds();
				for(Polygon p : polygons) {
					g.drawPolygon(p);
				}
			}
			g.setColor(Color.WHITE);
			Paint.paintRug(g);
			Paint.paintTab(g);
			Paint.paintDisplay(g, TFighterDisplay.class.asSubclass(Display.class));
		}
		Paint.paintMouse(g);
	}
	
	public static long getRunTime() {
		return System.currentTimeMillis() - startTime;
	}

	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		if(Paint.settings.getBounds().contains(p)) {
			needsSetup = true;
		}
		if(Paint.chat.contains(p)) {
			Paint.setPaint(!Paint.shouldPaint());
		}
	}

	public void mousePressed(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void mouseReleased(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void mouseEntered(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public void mouseExited(MouseEvent e) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
