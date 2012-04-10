package com.zalgoproductions.strategies.script.bones;

import com.zalgoproductions.util.Bones;
import com.zalgoproductions.util.Sleeping;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.node.Item;

public class BonesTask implements Task {
	public void run() {
		for(Item item : Inventory.getItems()) {
			if(Bones.bonesFilter.accept(item)) {
				item.getWidgetChild().click(true);
				Time.sleep(1000);
				Sleeping.waitWhileAnim(Bones.BONES_ANIMATION);
			}
		}
	}
}
