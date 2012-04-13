package com.zalgoproductions.strategies.setup;

import com.zalgoproductions.resources.Fonts;
import com.zalgoproductions.script.TFighterBeyond;
import com.zalgoproductions.util.*;
import com.zalgoproductions.util.paint.Paint;
import org.powerbot.concurrent.Task;
import org.powerbot.game.api.methods.interactive.Players;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SetupTask implements Task {
	private static boolean running = false;
	public void run() {
		running = true;
		Safespot.startTile = Players.getLocal().getPosition();
		Attacking.initializeEquipment();
		SkillWatcher.poll();
		final ZUI zui = new ZUI();
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					zui.setResizable(false);
					zui.setVisible(true);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isRunning() {
		return running;
	}

	private class ZUI extends JFrame {
//		private final File file;

		
		private JCheckBox useMulti, useSafe, useBones, usePrayer;

		private JTextField npcBox, lootBox, lootAboveBox, alchBox, foodBox;

		//private JLabel eatPercentLabel;
		//private JSlider foodSlider;

		private JButton start;

		private ZUI() {
//			file = new File("." + File.separator + "TFighter" + File.separator + "TFighter.txt");
			init();
			pack();
		}

		private void init() {
//			Properties props = loadProperties();

			JPanel north = new JPanel(new FlowLayout());
			north.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			{
				JLabel title = new JLabel("TFighter Beyond");
				title.setFont(Fonts.BATMAN_FONT.deriveFont(Font.PLAIN, 18));
				north.add(title);
			}
			add(north, BorderLayout.NORTH);

			JPanel center = new JPanel();
			center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
			center.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			{
				JPanel combat = new JPanel();
				combat.setLayout(new BoxLayout(combat, BoxLayout.PAGE_AXIS));
				combat.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				{
					JLabel title = new JLabel("Combat");
					JLabel npcLabel = new JLabel("Enter the names/ ids of the monsters to fight");
					npcBox = new JTextField("barbarian,278,dragon");
					useMulti = new JCheckBox("Attack monsters that are fighting others");
					useSafe = new JCheckBox("Use a safespot");
//					disableSpecials = new JCheckBox("Disable special attacks");

					title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					npcLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					npcBox.setAlignmentX(JTextField.CENTER_ALIGNMENT);
					useMulti.setAlignmentX(JCheckBox.CENTER_ALIGNMENT);
					useSafe.setAlignmentX(JCheckBox.CENTER_ALIGNMENT);
//					disableSpecials.setAlignmentX(JCheckBox.CENTER_ALIGNMENT);

					npcBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, npcBox.getPreferredSize().height));
					npcBox.setColumns(25);

//					if (props.getProperty("npcBox") != null) {
//						npcBox.setText(props.getProperty("npcBox"));
//					}
//					if (props.getProperty("useMulti") != null) {
//						if (props.getProperty("useMulti").equals("true"))
//							useMulti.setSelected(true);
//					}
//					if(props.getProperty("useSafe") != null) {
//						if(props.getProperty("useSafe").equals("true"))
//							useSafe.setSelected(true);
//					}
//					if(props.getProperty("disableSpecials") != null) {
//						if(props.get("disableSpecials").equals("true"))
//							disableSpecials.setSelected(true);
//					}

					combat.add(title);
					combat.add(new JLabel(" "));
					combat.add(npcLabel);
					combat.add(npcBox);
					combat.add(new JLabel(" "));
					combat.add(useMulti);
					combat.add(useSafe);
//					combat.add(disableSpecials);
					combat.add(Box.createVerticalGlue());
					combat.add(Box.createRigidArea(new Dimension(1,1)));
				}

				JPanel loot = new JPanel();
				loot.setLayout(new BoxLayout(loot, BoxLayout.PAGE_AXIS));
				loot.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				{
					JLabel title = new JLabel("Loot");
					JLabel lootLabel = new JLabel("Enter the names/ ids of the loot to pick up");
					lootBox = new JTextField("1024.526");
//					lootAboveBox = new JTextField("1000");
//					lootAbove = new JCheckBox("Loot everything above: ");
//					onlyLoot = new JCheckBox("Only loot from monsters you kill");

					title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					lootLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					lootBox.setAlignmentX(JTextField.CENTER_ALIGNMENT);
//					onlyLoot.setAlignmentX(JCheckBox.CENTER_ALIGNMENT);

					lootBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, lootBox.getPreferredSize().height));
					lootBox.setColumns(25);

//					lootAboveBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, lootAboveBox.getPreferredSize().height));
//					lootAboveBox.setColumns(10);
//
//					if (props.getProperty("lootBox") != null) {
//						lootBox.setText(props.getProperty("lootBox"));
//					}
//					if(props.getProperty("lootAbove") != null) {
//						if(props.get("lootAbove").equals("true"))
//							lootAbove.setSelected(true);
//					}
//					if (props.getProperty("lootAboveBox") != null) {
//						lootAboveBox.setText(props.getProperty("lootAboveBox"));
//					}
//					if(props.getProperty("onlyLoot") != null) {
//						if(props.get("onlyLoot").equals("true"))
//							onlyLoot.setSelected(true);
//					}

					loot.add(title);
					loot.add(new JLabel(" "));
					loot.add(lootLabel);
					loot.add(lootBox);
//					JPanel lootAbovePanel = new JPanel();
//					lootAbovePanel.add(lootAbove);
//					lootAbovePanel.add(lootAboveBox);
//					loot.add(new JLabel(" "));
//					lootAbovePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, lootAbovePanel.getPreferredSize().height));
//					lootAbovePanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
//					loot.add(lootAbovePanel);
//					loot.add(new JLabel(" "));
//					loot.add(onlyLoot);
					loot.add(Box.createVerticalGlue());
					loot.add(Box.createRigidArea(new Dimension(1,1)));
				}

//				JPanel food = new JPanel();
//				food.setLayout(new BoxLayout(food, BoxLayout.PAGE_AXIS));
//				food.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//				{
//					JLabel foodLabel = new JLabel("Food Settings");
//					JLabel foodBoxLabel = new JLabel("Enter the ids/ names of items to eat");
//					foodBox = new JTextField("");
//					foodSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 70);
//					eatPercentLabel = new JLabel("Eat at " + 70 + "%");
//
//					foodLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//					foodBoxLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//					foodBox.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//					eatPercentLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//					foodSlider.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//
//					foodSlider.setMajorTickSpacing(10);
//					foodSlider.setMinorTickSpacing(1);
//					foodSlider.addChangeListener(sliderChange);
//
//					foodBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, alchBox.getPreferredSize().height));
//
//					foodBox.setColumns(25);
//
//					food.add(foodLabel);
//					food.add(new JLabel(" "));
//					food.add(foodBoxLabel);
//					food.add(foodBox);
//					food.add(new JLabel(" "));
//					food.add(eatPercentLabel);
//					food.add(foodSlider);
//				}

				JPanel misc = new JPanel();
				misc.setLayout(new BoxLayout(misc, BoxLayout.PAGE_AXIS));
				misc.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				{
					JLabel miscLabel = new JLabel("Miscellaneous Settings");
					JLabel alchLabel = new JLabel("Enter the ids/ names of items to alch");
					alchBox = new JTextField("");
					usePrayer = new JCheckBox("Use Quick Prayers");
					useBones = new JCheckBox("Bury the bones you loot");

					miscLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					alchLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					alchBox.setAlignmentX(JLabel.CENTER_ALIGNMENT);
					usePrayer.setAlignmentX(JCheckBox.CENTER_ALIGNMENT);
					useBones.setAlignmentX(JCheckBox.CENTER_ALIGNMENT);
					

					alchBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, alchBox.getPreferredSize().height));

					alchBox.setColumns(25);
//
//					if (props.getProperty("alchBox") != null) {
//						alchBox.setText(props.getProperty("alchBox"));
//					}
//					if(props.getProperty("useBones") != null) {
//						if(props.get("useBones").equals("true"))
//							useBones.setSelected(true);
//					}
//					if(props.getProperty("usePrayer") != null) {
//					    if(props.get("usePrayer").equals("true"))
//					        usePrayer.setSelected(true);
//					}
//					

					misc.add(miscLabel);
					misc.add(new JLabel(" "));
					misc.add(alchLabel);
					misc.add(alchBox);
					misc.add(new JLabel(" "));
					misc.add(usePrayer);
					misc.add(useBones);
				}

				JTabbedPane tabbedPane = new JTabbedPane();
				tabbedPane.addTab("Combat", combat);
				tabbedPane.addTab("Loot", loot);
//				tabbedPane.addTab("Food", food);
//				tabbedPane.addTab("Bank", bank);
				tabbedPane.addTab("Misc.", misc);
				center.add(tabbedPane);
			}
			add(center, BorderLayout.CENTER);

			JPanel south = new JPanel(new FlowLayout());
			south.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			{
				start = new JButton("Start script!");
				start.setAlignmentX(JButton.CENTER_ALIGNMENT);
				start.addActionListener(onStart);
				south.add(start);
			}
			add(south, BorderLayout.SOUTH);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setTitle("TFighter GUI");
		}

//		private Properties loadProperties() {
//			try {
//				if (!file.exists())
//					file.createNewFile();
//				Properties p = new Properties();
//				p.load(new FileInputStream(file));
//				return p;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return null;
//		}

//		private void saveProperties() {
//			Properties p = new Properties();
//			p.put("npcBox", npcBox.getText());
//			p.put("lootBox", lootBox.getText());
////			p.put("lootAbove", Boolean.toString(lootAbove.isSelected()));
////			p.put("lootAboveBox", lootAboveBox.getText());
////			p.put("alchBox", alchBox.getText());
//			p.put("useMulti", Boolean.toString(useMulti.isSelected()));
//			p.put("useSafe", Boolean.toString(useSafe.isSelected()));
//		    p.put("usePrayer", Boolean.toString(usePrayer.isSelected()));
//			p.put("useBones", Boolean.toString(useBones.isSelected()));
////			p.put("disableSpecials", Boolean.toString(disableSpecials.isSelected()));
////			p.put("onlyLoot", Boolean.toString(onlyLoot.isSelected()));
//
////			p.put("enableBanking", Boolean.toString(enableBanking.isSelected()));
////			p.put("depositLoot", Boolean.toString(depositLoot.isSelected()));
////			p.put("depositBones", Boolean.toString(depositBones.isSelected()));
////			p.put("withdrawFood", Boolean.toString(withdrawFood.isSelected()));
////			p.put("foodBox", foodBox.getText());
//
//			try {
//				p.store(new FileOutputStream(file), "");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

		private final ActionListener onStart =  new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				saveProperties();
				Attacking.utilizeMultiwayCombat = useMulti.isSelected();
				Safespot.useSafespot = useSafe.isSelected();
				Bones.buryBones = useBones.isSelected();
				Prayer.usePrayer = usePrayer.isSelected();
//				u.loot.onlyTakeLootFromKilled = onlyLoot.isSelected();
//				u.loot.lootAbove = lootAbove.isSelected();
//				u.loot.lootAboveX = Integer.parseInt(lootAboveBox.getText());
//				u.bank.bankingEnabled = enableBanking.isSelected();
//				u.bank.depositLoot = depositLoot.isSelected();
//				u.bank.depositBones = depositBones.isSelected();
//				u.bank.withdrawFood = withdrawFood.isSelected();
//				u.bank.minimumFood = Integer.parseInt(foodBox.getText().split(",")[0]);
//				u.bank.maximumFood = Integer.parseInt(foodBox.getText().split(",")[1]);

				String[] ids = npcBox.getText().split(",");
				ArrayList<Integer> idList = new ArrayList<Integer>();
				ArrayList<String> nameList = new ArrayList<String>();
				for (String id3 : ids) {
					if (id3 != null && !id3.equals("")) {
						try {
							int id = Integer.parseInt(id3);
							idList.add(id);
						} catch (Exception e1) {
							nameList.add(id3);
						}
					}
				}
				Attacking.setNpcIds(idList.size() > 0 ? toIntArray(idList.toArray(new Integer[idList.size()])) : new int[0]);
				Attacking.setNpcNames(nameList.size() > 0 ? nameList.toArray(new String[nameList.size()]) : new String[0]);

				ids = lootBox.getText().split(",");
				idList = new ArrayList<Integer>();
				nameList = new ArrayList<String>();
				for (String id2 : ids) {
					if (id2 != null && !id2.equals("")) {
						try {
							int id = Integer.parseInt(id2);
							idList.add(id);
						} catch (Exception e1) {
							nameList.add(id2);
						}
					}
				}

				Looting.setLootIds(idList.size() > 0 ? toIntArray(idList.toArray(new Integer[idList.size()])) : new int[0]);
				Looting.setLootNames(nameList.size() > 0 ? nameList.toArray(new String[nameList.size()]) : new String[0]);

				ids = alchBox.getText().split(",");
				idList = new ArrayList<Integer>();
				nameList = new ArrayList<String>();
				for (String id1 : ids) {
					if (id1 != null && !id1.equals("")) {
						try {
							int id = Integer.parseInt(id1);
							idList.add(id);
						} catch (Exception e1) {
							nameList.add(id1.toLowerCase());
						}
					}
				}

				Alchemy.doAlchemy = !(idList.size() == 0 && nameList.size() == 0);
				Alchemy.setAlchIds(idList.size() > 0 ? toIntArray(idList.toArray(new Integer[idList.size()])) : new int[0]);
				Alchemy.setAlchNames(nameList.size() > 0 ? nameList.toArray(new String[nameList.size()]) : new String[0]);



//				u.eat.foodOfChoice = u.eat.getFood();
//
//				if(u.eat.foodOfChoice == null && u.bank.withdrawFood) {
//					log("You do not have any food in your inventory! Food withdrawal banking will not be used!");
//					log("If you want to use food withdrawal banking, start the script with the food you use in your inventory.");
//				}

//				game.openTab(Game.Tab.EQUIPMENT);
//				//Credit: The Powerbot Scripters Team
//				if(equipment.getItem(Equipment.WEAPON) != null && !disableSpecials.isSelected()){
//					u.npcs.weapon = equipment.getItem(Equipment.WEAPON).getName();
//					if(u.npcs.weapon.contains(">")) {
//						u.npcs.weapon = u.npcs.weapon.substring(u.npcs.weapon.indexOf(">") + 1);
//					}
//
//					String[] specialWeaponsArray = new String[] {"Rune thrownaxe", "Rod of ivandis", "Dragon Dagger",
//							"Dragon dagger (p)", "Dragon dagger (p+)", "Dragon dagger (p++)", "Dragon Mace", "Dragon Spear",
//							"Dragon longsword", "Rune claws", "Dragon Halberd", "Magic Longbow", "Magic Composite Bow",
//							"Dragon Claws", "Abyssal Whip", "Granite Maul", "Darklight", "Barrelchest Anchor",
//							"Armadyl Godsword", "Magic Shortbow", "Dragon Scimitar", "Dragon 2H Sword", "Zamorak Godsword",
//							"Korasi's sword", "Dorgeshuun Crossbow", "Bone Dagger", "Bone Dagger (p+)", "Bone Dagger (p++)",
//							"Brine Sabre", "Bandos Godsword", "Dragon Battleaxe", "Dragon Hatchet", "Seercull Bow",
//							"Excalibur", "Enhanced excalibur", "Ancient Mace", "Saradomin sword"};
//
//					for(String weapon : specialWeaponsArray ) {
//						if (weapon.equalsIgnoreCase(u.npcs.weapon)) {
//							u.npcs.hasSpecialWeapon = true;
//						}
//					}
//				}
//
//				if(equipment.getItem(Equipment.AMMO) != null) {
//					u.npcs.ammo = equipment.getItem(Equipment.AMMO).getName();
//				}
//
//				if(equipment.getItem(Equipment.RING) != null) {
//					u.npcs.ring = equipment.getItem(Equipment.RING).getName();
//				}

				running = false;
				Paint.setPaint(true);
				TFighterBeyond.startTime = System.currentTimeMillis();
				TFighterBeyond.needsSetup = false;
				dispose();
			}
		};

//		private final ChangeListener sliderChange = new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				eatPercentLabel.setText("Eat at " + ((JSlider)e.getSource()).getValue() + "%");
//				eatPercentLabel.revalidate();
//				eatPercentLabel.repaint();
//			}
//		};
////		private ActionListener disableAllBankingOptions = new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////				AbstractButton abstractButton = (AbstractButton) e.getSource();
////				boolean selected = abstractButton.getModel().isSelected();
////
////				if(selected) {
////
////					withdrawFood.setEnabled(selected);
////					depositLoot.setEnabled(selected);
////				} else {
////					withdrawFood.setSelected(selected);
////					depositLoot.setSelected(selected);
////					depositBones.setSelected(selected);
////					withdrawFood.setEnabled(selected);
////					depositLoot.setEnabled(selected);
////					depositBones.setEnabled(selected);
////					foodBox.setEnabled(selected);
////				}
////			}
////		};
//
//		private ActionListener disableDepositBones = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				AbstractButton abstractButton = (AbstractButton) e.getSource();
//				boolean selected = abstractButton.getModel().isSelected();
//				depositBones.setEnabled(selected);
//			}
//		};
//
//		private ActionListener disableFoodBox = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				AbstractButton abstractButton = (AbstractButton) e.getSource();
//				boolean selected = abstractButton.getModel().isSelected();
//				foodBox.setEnabled(selected);
//			}
//		};

		private int[] toIntArray(Integer[] ints) {
			int[] done = new int[ints.length];
			for (int i = 0; i < done.length; i++) {
				done[i] = ints[i];
			}
			return done;
		}
	}
}
