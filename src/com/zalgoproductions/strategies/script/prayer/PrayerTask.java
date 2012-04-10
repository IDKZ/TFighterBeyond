package com.zalgoproductions.strategies.script.prayer;

import com.zalgoproductions.util.Prayer;
import org.powerbot.concurrent.Task;

public class PrayerTask implements Task {
	public void run() {
		Prayer.setQuickPrayer(true);
	}
}
