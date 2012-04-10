package com.zalgoproductions.strategies.script.potions;

import com.zalgoproductions.strategies.script.potions.prayer.PrayerPotionStrategy;
import com.zalgoproductions.strategies.script.potions.prayer.PrayerRenewalStrategy;
import com.zalgoproductions.strategies.script.potions.prayer.SuperPrayerStrategy;
import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Condition;

import java.util.ArrayList;

public class PotionTask implements Task, Condition {
	private static final PotionStrategy[] POTION_STRATEGIES = new PotionStrategy[] {
			new SaradominStrategy(), new RestoreStrategy(), new AntipoisonStrategy(), new EnergyStrategy(),
			new PrayerPotionStrategy(), new PrayerRenewalStrategy(), new SuperPrayerStrategy(),
			new OverloadStrategy(), new ZamarakStrategy(), new CombatStrategy(), new AttackStrategy(), 
			new DefenseStrategy(), new StrengthStrategy(), new MagicStrategy(), new RangeStrategy()
	};
	
	private static final ArrayList<PotionStrategy> validStrategies = new ArrayList<PotionStrategy>();
	
	public void run() {
		for(PotionStrategy strategy : validStrategies) {
			strategy.run();
		}
		validStrategies.clear();
	}

	public boolean validate() {
		boolean toReturn = false;		
		for(PotionStrategy strategy : POTION_STRATEGIES) {
			if(strategy.validate()) {
				validStrategies.add(strategy);
				if(!toReturn) {
					toReturn = true;
				}   				
			}
		}
		return toReturn;
	}
}
