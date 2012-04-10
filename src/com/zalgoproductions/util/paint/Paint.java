package com.zalgoproductions.util.paint;

import com.zalgoproductions.resources.Images;
import com.zalgoproductions.util.paint.displays.LootDisplay;
import com.zalgoproductions.util.paint.displays.SkillsDisplay;
import com.zalgoproductions.util.paint.displays.TFighterDisplay;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

import java.awt.*;

public class Paint {
	private static boolean doPaint = false;
	
	private static final Display tFighter = new TFighterDisplay();
	
	private static final Display skills = new SkillsDisplay();
	
	private static final Display loot = new LootDisplay();

	public static final WidgetChild chat = Widgets.get(137, 0);

	public static final Tab settings = new Tab("Settings", 18, chat.getAbsoluteX() + 10, chat.getAbsoluteY() - 35);

	
	public static String millisToTime(long millis) {
		long hours = millis / (60 * 1000 * 60);
		long minutes = (millis - (hours * 60 * 1000 * 60)) / (60 * 1000);
		long seconds = (millis - (hours * 60 * 1000 * 60) - (minutes * 60 * 1000)) / 1000;
		return (hours >= 10 ? hours + ":" : "0" + hours + ":")
				+ (minutes >= 10 ? minutes + ":" : "0" + minutes + ":")
				+ (seconds >= 10 ? seconds : "0" + seconds);
	}
	
	public static void setPaint(boolean state) {
		doPaint = state;
	}

	public static boolean shouldPaint() {
		return doPaint;
	}
	
	public static void paintTab(Graphics g) {
		settings.draw(g);
	}
	
	public static void paintRug(Graphics g) {
		g.drawImage(Images.RUG_IMG, chat.getAbsoluteX(), chat.getAbsoluteY(), null);
	}
	
	public static void paintDisplay(Graphics g, Class<? extends Display> displayClass) {
		if(displayClass.equals(tFighter.getClass().asSubclass(Display.class))) {
			paintDisplay(g, tFighter);
		} else if (displayClass.equals(skills.getClass().asSubclass(Display.class))) {
			paintDisplay(g, skills);
		} else if (displayClass.equals(loot.getClass().asSubclass(Display.class))) {
			paintDisplay(g, loot);
		}
	}
	
	private static void paintDisplay(Graphics g, Display display) {
		display.draw(g, chat.getAbsoluteX(), chat.getAbsoluteY());
	}

	public static void paintMouse(Graphics g) {
		int x = Mouse.getLocation().x, y = Mouse.getLocation().y;
		g.setColor(System.currentTimeMillis() - Mouse.getPressTime() < 300 ? Color.MAGENTA : Color.RED);
		g.fillOval(x - 6, y - 6, 12, 12);
		g.setColor(Color.ORANGE);
		g.fillOval(x - 3, y - 3, 6, 6);
		g.drawLine(x - 10, y - 10, x + 10, y + 10);
		g.drawLine(x - 10, y + 10, x + 10, y - 10);
	}
}
