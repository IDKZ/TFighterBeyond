package com.zalgoproductions.util;

import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.node.Item;

public class Bones {             
	public static boolean buryBones = false;
	public static final int BONES_ANIMATION = 827;
	
	private static final Filter<Item> bonesFilter = new Filter<Item>() {
		private final int[] BONE_IDS = new int[] { 526, 528, 530, 532, 534, 536, 2859, 3123, 3125, 3183, 6182 , 20268, 20266, 20264};
		public boolean accept(Item item) {
			for(int id : BONE_IDS) {
				if(item.getId() == id) {
					return true;
				}
			}
			return false;
		}
	};
	
	public static Filter<Item> getBonesFilter() {
		return bonesFilter;
	}
}
