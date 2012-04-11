package com.zalgoproductions.util.paint.displays;

import com.zalgoproductions.resources.Fonts;
import com.zalgoproductions.script.TFighterBeyond;
import com.zalgoproductions.util.Looting;
import com.zalgoproductions.util.paint.Display;
import com.zalgoproductions.util.paint.Paint;
import com.zalgoproductions.util.SkillWatcher;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Map;

public class TFighterDisplay implements Display {
	public void draw(Graphics g, int x, int y) {
		NumberFormat nf = NumberFormat.getIntegerInstance();

		g.setColor(Color.WHITE);
		g.setFont(Fonts.BATMAN_FONT.deriveFont(Font.PLAIN, 16));
		g.drawString("TFighter Beyond (v" + TFighterBeyond.mani.version() + ")", x + 15, y += g.getFontMetrics().getMaxAscent() + 10);
		g.setFont(Fonts.BATMAN_FONT.deriveFont(Font.PLAIN, 14));
		g.drawString("By Zalgo2462", x + 20, y += g.getFontMetrics().getMaxAscent() + 5);
		g.setFont(new Font("Arial", Font.BOLD, 11));
		g.drawString("Run time: " + Paint.millisToTime(TFighterBeyond.getRunTime()), x + 45, y += g.getFontMetrics().getMaxAscent() + 5);

		//Exp gains
		g.drawString("Experience gained:", x + 25, y += g.getFontMetrics().getMaxAscent() + 10);
		g.setFont(new Font("Arial", Font.PLAIN, 11));

		int skillLayoutNumber = 0;
		int skillYStart = y;
		for (Map.Entry<String, Integer> entry : SkillWatcher.getExpGainedMap().entrySet()) {

			skillLayoutNumber++;

			double expPerSec = entry.getValue() / (double) (TFighterBeyond.getRunTime() / 1000);
			int expPerHour = (int) Math.round(expPerSec * 3600);


			if((skillLayoutNumber < 4)) {
				g.drawString(entry.getKey() + ": " + nf.format(entry.getValue()) +
						" (p/hr: " + nf.format(expPerHour) + ")", x + 25, skillYStart += g.getFontMetrics().getMaxAscent());
			}
			else if (skillLayoutNumber == 4) {
				g.drawString(entry.getKey() + ": " + nf.format(entry.getValue()) +
						" (p/hr: " + nf.format(expPerHour) + ")", x + 25, skillYStart += g.getFontMetrics().getMaxAscent());
				skillYStart = y;
			}
			
			else if (skillLayoutNumber > 4) {
				g.drawString(entry.getKey() + ": " + nf.format(entry.getValue()) +
						" (p/hr: " + nf.format(expPerHour) + ")", x + 175, skillYStart += g.getFontMetrics().getMaxAscent());
			}

		}

		y = Paint.chat.getAbsoluteY();
		g.setFont(Fonts.BATMAN_FONT.deriveFont(Font.PLAIN, 12));
		g.drawString("Loot taken:", x + 280, y += g.getFontMetrics().getMaxAscent() + 30);
		g.setFont(new Font("Arial", Font.PLAIN, 11));

		Map<String, Integer> loot = Looting.getLootTaken();
		for (Map.Entry<String, Integer> entry : loot.entrySet()) {
			g.drawString(entry.getKey() + " x" + entry.getValue(), x + 320, y += g.getFontMetrics().getMaxAscent());
		}
	}  	
}
