package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.Widgets;

//TODO GET POISONED TEXTURE OR HOOK
public class AntipoisonStrategy extends PotionStrategy {
	public AntipoisonStrategy() {
		super(Potions.ANTIPOISON);
	}

	@Override
	protected boolean needsPotion() {
		return Settings.get(102) > 0 || Widgets.get(748, 4).getTextureId() == 1801;
	}
}
