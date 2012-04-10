package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.util.Potions;
import com.zalgoproductions.util.SkillWatcher;
import org.powerbot.game.api.methods.tab.Skills;

public class RestoreStrategy extends PotionStrategy {
	public RestoreStrategy() {
		super(Potions.RESTORE_POTIONS);
	}

	@Override
	protected boolean needsPotion() {
		for(int skill = 0; skill < SkillWatcher.SKILL_NAMES.length - 1; skill++) {
			if(Skills.getLevel(skill) < Skills.getRealLevel(skill)) {
				return true;
			}
		}
		return false;
	}
}
