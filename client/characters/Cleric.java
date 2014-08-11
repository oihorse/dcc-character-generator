package com.horsegoeswest.dcc.client.characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.horsegoeswest.dcc.client.CharacterGenerator;
import com.horsegoeswest.dcc.client.equipment.Weapon;
import com.horsegoeswest.dcc.client.events.WeaponListUpdateEvent;
import com.horsegoeswest.dcc.client.events.WeaponListUpdateEventHandler;
import com.horsegoeswest.dcc.client.resources.AbilityScores;
import com.horsegoeswest.dcc.client.resources.DCCTables;
import com.horsegoeswest.dcc.client.resources.Occupation;
import com.horsegoeswest.dcc.client.resources.Wallet;

public class Cleric extends CharacterClass {

	private int hitPointDie = 8;
	private String deity = "";
	private String spellCheck = "";
	private List<Integer> spellList = new ArrayList<Integer>();

	private List<String> firstLevelClericSpells = new ArrayList<String>(
			Arrays.asList("Blessing", "Darkness", "Detect evil",
					"Detect magic", "Food of the gods", "Holy sanctuary",
					"Paralysis", "Protection from evil", "Resist cold or heat",
					"Second sight", "Word of command"));

	private List<String> secondLevelClericSpells = new ArrayList<String>(
			Arrays.asList("Banish", "Binding", "Cure paralysis", "Curse",
					"Divine symbol", "Lotus stare",
					"Neutralize poison or disease", "Restore vitality",
					"Snake charm", "Stinging stone", "Wood wyrding"));

	private List<String> thirdLevelClericSpells = new ArrayList<String>(
			Arrays.asList("Animate dead", "Bolt from the blue", "Exorcise",
					"Remove curse", "Speak with the dead", "Spiritual weapon",
					"True name"));

	private List<String> fourthLevelClericSpells = new ArrayList<String>(
			Arrays.asList("Affliction of the gods", "Cause earthquake",
					"Sanctify / desecrate", "Vermin blight"));

	private List<String> fifthLevelClericSpells = new ArrayList<String>(
			Arrays.asList("Righteous fire", "Weather control", "Whirling doom"));

	private List<Integer> levelOneSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(4));
	private List<Integer> levelTwoSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(5));
	private List<Integer> levelThreeSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(5, 3));
	private List<Integer> levelFourSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(6, 4));
	private List<Integer> levelFiveSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(6, 5, 2));
	private List<Integer> levelSixSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(7, 5, 3));
	private List<Integer> levelSevenSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(7, 6, 4, 1));
	private List<Integer> levelEightSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(8, 6, 5, 2));
	private List<Integer> levelNineSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(8, 7, 5, 3, 1));
	private List<Integer> levelTenSpellsKnown = new ArrayList<Integer>(
			Arrays.asList(9, 7, 6, 4, 2));

	public Cleric(int level, String alignment, String name, Occupation occupation) {
		super();
		this.level = level;
		this.alignment = alignment;
		this.abilityScores = new AbilityScores();
		this.name = name;
		this.critTable = "III";
		this.charClass = "Cleric";
		this.title = getClericTitle(this.alignment, this.level);
		this.occupation = occupation;
		this.refSave = refSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getAgility());
		this.fortSave = fortSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getStamina());
		this.willSave = willSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers
						.get(abilityScores.getPersonality());
		this.hitPoints = generateHitPoints(hitPointDie, this.level);
		this.speed = DCCTables.characterSpeed.get("Cleric");
		this.luckyRoll = generateLuckyRoll();
		this.actionDice = actionDiceTable.get(this.level);
		this.initiative = generateInitiative(this.level, "Cleric",
				DCCTables.abilityModifiers.get(abilityScores.getAgility()));
		this.actionDice = actionDiceTable.get(this.level);
		this.attack = attackBonus.get(this.level);
		this.critDie = critDieTable.get(this.level);
		this.characterWeapons
				.add(this.occupation.getTrainedWeapon());
		this.characterEquipment.add(this.occupation.getTradeGood());
		this.spellCheck = getSpellCheck(this.level,
				DCCTables.abilityModifiers.get(abilityScores.getPersonality()));
		this.spellList = getNumberOfSpells(this.level,
				DCCTables.maxSpells.get(this.abilityScores.getPersonality()));
		this.wallet =  new Wallet(this.level, this.charClass);
		setMeleeAttack(attackBonus.get(this.level), DCCTables.abilityModifiers.get(this.abilityScores.getStrength()));
		setMissileAttack(attackBonus.get(this.level));
		debugTheCleric();
		
	}
	

	// Key: level, Value: attack bonus
	@SuppressWarnings("serial")
	public Map<Integer, String> attackBonus = new HashMap<Integer, String>() {
		{
			put(1, "0");
			put(2, "1");
			put(3, "2");
			put(4, "2");
			put(5, "3");
			put(6, "4");
			put(7, "5");
			put(8, "5");
			put(9, "6");
			put(10, "7");
		}
	};

	// Key: level, Value: crit die
	@SuppressWarnings("serial")
	public Map<Integer, String> critDieTable = new HashMap<Integer, String>() {
		{
			put(1, "1d8");
			put(2, "1d8");
			put(3, "1d10");
			put(4, "1d10");
			put(5, "1d12");
			put(6, "1d12");
			put(7, "1d14");
			put(8, "1d14");
			put(9, "1d16");
			put(10, "1d16");
		}
	};

	// Key: level, Value: action dice
	@SuppressWarnings("serial")
	public Map<Integer, String> actionDiceTable = new HashMap<Integer, String>() {
		{
			put(1, "1d20");
			put(2, "1d20");
			put(3, "1d20");
			put(4, "1d20");
			put(5, "1d20");
			put(6, "1d20 + 1d14");
			put(7, "1d20 + 1d16");
			put(8, "1d20 + 1d20");
			put(9, "1d20 + 1d20");
			put(10, "1d20 + 1d20");
		}
	};

	// Key: level, Value: Willpower Save modifier
	@SuppressWarnings("serial")
	public Map<Integer, Integer> willSaveModifier = new HashMap<Integer, Integer>() {
		{
			put(1, 1);
			put(2, 1);
			put(3, 2);
			put(4, 2);
			put(5, 3);
			put(6, 4);
			put(7, 4);
			put(8, 5);
			put(9, 5);
			put(10, 6);
		}
	};

	// Key: level, Value: Fortitude Save modifier
	@SuppressWarnings("serial")
	public Map<Integer, Integer> fortSaveModifier = new HashMap<Integer, Integer>() {
		{
			put(1, 1);
			put(2, 1);
			put(3, 1);
			put(4, 2);
			put(5, 2);
			put(6, 2);
			put(7, 3);
			put(8, 3);
			put(9, 3);
			put(10, 4);
		}
	};

	// Key: level, Value: Reflex Save modifier
	@SuppressWarnings("serial")
	public Map<Integer, Integer> refSaveModifier = new HashMap<Integer, Integer>() {
		{
			put(1, 0);
			put(2, 0);
			put(3, 1);
			put(4, 1);
			put(5, 1);
			put(6, 2);
			put(7, 2);
			put(8, 2);
			put(9, 3);
			put(10, 3);
		}
	};

	public String getClericTitle(String alignment, int level) {
		String title = "";

		if (alignment.equals("Lawful")) {
			switch (level) {
			case 1:
				title = "Acolyte";
				break;
			case 2:
				title = "Heathen-slayer";
				break;
			case 3:
				title = "Brother";
				break;
			case 4:
				title = "Curate";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Father";
				break;
			default:
				title = "";
			}
			return title;
		}

		else if (alignment.equals("Neutral")) {
			switch (level) {
			case 1:
				title = "Witness";
				break;
			case 2:
				title = "Pupil";
				break;
			case 3:
				title = "Chronicler";
				break;
			case 4:
				title = "Judge";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Druid";
				break;
			default:
				title = "";
			}
			return title;
		} else if (alignment.equals("Chaotic")) {
			switch (level) {
			case 1:
				title = "Zealot";
				break;
			case 2:
				title = "Convert";
				break;
			case 3:
				title = "Cultist";
				break;
			case 4:
				title = "Apostle";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "High priest";
				break;
			default:
				title = "";
			}
			return title;
		}

		return title;
	}

	public String getSpellCheck(int charLevel, int abillityModifier) {
		String sc = "";
		int scModifier = charLevel + abillityModifier;
		sc = "1d20 + " + scModifier;

		return sc;
	}

	// Determine number of spells per level
	public List<Integer> getNumberOfSpells(int charLevel, int maxSpellModifier) {
		List<Integer> numberOfSpells = new ArrayList<Integer>();

		if (charLevel == 1) {
			for (int spell : levelOneSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 2) {
			for (int spell : levelTwoSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 3) {
			for (int spell : levelThreeSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 4) {
			for (int spell : levelFourSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 5) {
			for (int spell : levelFiveSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 6) {
			for (int spell : levelSixSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 7) {
			for (int spell : levelSevenSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 8) {
			for (int spell : levelEightSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 9) {
			for (int spell : levelNineSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		} else if (charLevel == 10) {
			for (int spell : levelTenSpellsKnown) {
				if (spell > maxSpellModifier) {
					numberOfSpells.add(maxSpellModifier);
				} else {
					numberOfSpells.add(spell);
				}
			}
		}

		return numberOfSpells;
	}

	/**
	 * @return the deity
	 */
	public String getDeity() {
		return deity;
	}

	/**
	 * @param deity
	 *            the deity to set
	 */
	public void setDeity(String deity) {
		this.deity = deity;
	}

	/**
	 * @return the spellCheck
	 */
	public String getSpellCheck() {
		return spellCheck;
	}

	/**
	 * @param spellCheck
	 *            the spellCheck to set
	 */
	public void setSpellCheck(String spellCheck) {
		this.spellCheck = spellCheck;
	}

	/**
	 * @return the spellList
	 */
	public List<Integer> getSpellList() {
		return spellList;
	}

	/**
	 * @param spellList
	 *            the spellList to set
	 */
	public void setSpellList(List<Integer> spellList) {
		this.spellList = spellList;
	}

	/**
	 * @return the critDieTable
	 */
	public Map<Integer, String> getCritDieTable() {
		return critDieTable;
	}

	/**
	 * @param critDieTable
	 *            the critDieTable to set
	 */
	public void setCritDieTable(Map<Integer, String> critDieTable) {
		this.critDieTable = critDieTable;
	}

	public void debugTheCleric() {
		System.out.println("Level is: " + this.level);
		System.out.println("Alignment is: " + this.alignment);
		System.out.println("Name is: " + this.name);
		System.out.println("Title is: " + this.title);
		System.out.println("Occupation is: " + this.occupation);

		System.out.println("Strength: " + this.abilityScores.getStrength());
		System.out.println("Agility: " + this.abilityScores.getAgility());
		System.out.println("Stamina: " + this.abilityScores.getStamina());
		System.out.println("Personality: "
				+ this.abilityScores.getPersonality());
		System.out.println("Luck: " + this.abilityScores.getLuck());
		System.out.println("Intelligence: "
				+ this.abilityScores.getIntelligence());
		System.out.println("refsave: " + this.refSave);
		System.out.println("fortsave: " + this.fortSave);
		System.out.println("willsave: " + this.willSave);
		System.out.println("hitpoints: " + this.hitPoints);
		System.out.println("speed: " + this.speed);
		System.out.println("lucky roll: " + this.luckyRoll);
		System.out.println("weapons: " + this.characterWeapons.toString());
		System.out.println("equipment: " + this.characterEquipment.toString());
		System.out.println("spellcheck: " + this.spellCheck);
		System.out.println("number of spells: " + this.spellList);
		System.out.println("wallet: " + this.wallet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Cleric" + "\n" + "hitPointDie="
				+ hitPointDie + "\n" + "critTable=" + critTable + "\n"
				+ "deity=" + deity + "\n" + "spellCheck=" + spellCheck + "\n"
				+ "spellList=" + spellList;
	}

}
