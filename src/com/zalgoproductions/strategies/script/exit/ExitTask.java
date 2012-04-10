package com.zalgoproductions.strategies.script.exit;

import org.powerbot.concurrent.Task;
import org.powerbot.game.api.ActiveScript;

public class ExitTask implements Task {
	private final ActiveScript scriptInstance;

	public ExitTask(ActiveScript script) {
		scriptInstance = script;
	}

	public void run() {
		scriptInstance.stop();
	}
}
