package com.zalgoproductions.util;

import org.powerbot.game.api.methods.tab.Skills;

import java.util.HashMap;
import java.util.Map;

//Author !@!@!
public class SkillWatcher {
	private static final HashMap<Integer, Integer> startExpMap = new HashMap<Integer, Integer>();
	private static final int[] SKILLS_TO_WATCH = new int[]{Skills.SLAYER, Skills.CONSTITUTION, Skills.ATTACK, Skills.STRENGTH, Skills.DEFENSE, Skills.RANGE, Skills.MAGIC, Skills.PRAYER};
	public static final String[] SKILL_NAMES = {"attack", "defence",
			"strength", "constitution", "range", "prayer", "magic", "cooking",
			"woodcutting", "fletching", "fishing", "firemaking", "crafting",
			"smithing", "mining", "herblore", "agility", "thieving", "slayer",
			"farming", "runecrafting", "hunter", "construction", "summoning",
			"dungeoneering", "-unused-"};

	private static final HashMap<Integer, Integer> startLevelsMap = new HashMap<Integer, Integer>();

	/**
	 * Basically sets start exp for all skills we are watching.
	 */
	public static void poll() {
		for (int skill : SKILLS_TO_WATCH) {
			if (startExpMap.containsKey(skill)) {
				startExpMap.remove(skill);
			}
			if (startLevelsMap.containsKey(skill)) {
				startLevelsMap.remove(skill);
			}
			startExpMap.put(skill, Skills.getExperience(skill));
			startLevelsMap.put(skill, Skills.getRealLevel(skill));
		}
	}

	/**
	 * Returns the amount of exp gained in the specified skill.
	 *
	 * @param skill The skill see Skills.*
	 * @return the EXP Gained
	 */
	public static int getExpGainedIn(int skill) {
		if (startExpMap.get(skill) == null)
			return -1;
		return Skills.getExperience(skill) - startExpMap.get(skill);
	}

	public static int getExpStart(int skill) {
		if (startExpMap.get(skill) == null)
			return -1;
		return startExpMap.get(skill);
	}

	public static int getLevelsGainedIn(int skill) {
		return Skills.getRealLevel(skill) - startLevelsMap.get(skill);
	}

	/**
	 * Returns a map of skill names and exp gained.
	 *
	 * @return A map of exp gains and skill names.
	 */
	public static Map<String, Integer> getExpGainedMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i : SKILLS_TO_WATCH) {
			int gained = getExpGainedIn(i);
			if (gained != 0)
				map.put(SKILL_NAMES[i], gained);
		}
		return map;
	}
}
