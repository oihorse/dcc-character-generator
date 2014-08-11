package com.horsegoeswest.dcc.client.characters;

import java.util.HashMap;
import java.util.Map;

import com.horsegoeswest.dcc.client.resources.AbilityScores;
import com.horsegoeswest.dcc.client.resources.DCCTables;
import com.horsegoeswest.dcc.client.resources.Occupation;
import com.horsegoeswest.dcc.client.resources.Wallet;

public class Halfling extends CharacterClass {
	private int hitPointDie = 6;
	private int sneakSilently;
	private int hideInShadows;

	public Halfling(int level, String alignment, String name, Occupation occupation) {
		this.level = level;
		this.alignment = alignment;
		this.abilityScores = new AbilityScores();
		this.name = name;
		this.charClass = "Halfling";
		this.critTable = "III";
		this.title = getHalflingTitle(this.alignment, this.level);
		this.occupation = occupation;
		this.refSave = refSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getAgility());
		this.fortSave = fortSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getStamina());
		this.willSave = willSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers
						.get(abilityScores.getPersonality());
		this.hitPoints = generateHitPoints(hitPointDie, this.level);
		this.speed = DCCTables.characterSpeed.get("Halfling");
		this.luckyRoll = generateLuckyRoll();
		this.actionDice = actionDiceTable.get(this.level);
		this.initiative = generateInitiative(this.level, "Halfling",
				DCCTables.abilityModifiers.get(abilityScores.getAgility()));
		this.actionDice = actionDiceTable.get(this.level);
		this.attack = attackBonus.get(this.level);
		this.critDie = critDieTable.get(this.level);
		this.characterWeapons
		.add(this.occupation.getTrainedWeapon());
		this.characterEquipment.add(this.occupation.getTradeGood());
		this.sneakSilently = stealthSkills.get(this.level);
		this.hideInShadows = stealthSkills.get(this.level);
		this.wallet =  new Wallet(this.level, this.charClass);
		setMeleeAttack(attackBonus.get(this.level), DCCTables.abilityModifiers.get(this.abilityScores.getStrength()));
		setMissileAttack(attackBonus.get(this.level));

		debugTheHalfling();
	}

	// Key: level, Value: attack bonus
	@SuppressWarnings("serial")
	public Map<Integer, String> attackBonus = new HashMap<Integer, String>() {
		{
			put(1, "1");
			put(2, "2");
			put(3, "2");
			put(4, "3");
			put(5, "4");
			put(6, "5");
			put(7, "5");
			put(8, "6");
			put(9, "7");
			put(10, "8");
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
	public Map<Integer, Integer> stealthSkills = new HashMap<Integer, Integer>() {
		{
			put(1, 3);
			put(2, 5);
			put(3, 7);
			put(4, 8);
			put(5, 9);
			put(6, 11);
			put(7, 12);
			put(8, 13);
			put(9, 14);
			put(10, 15);
		}
	};

	// Key: level, Value: Reflex Save modifier
	@SuppressWarnings("serial")
	public Map<Integer, Integer> refSaveModifier = new HashMap<Integer, Integer>() {
		{
			put(1, 1);
			put(2, 1);
			put(3, 2);
			put(4, 2);
			put(5, 3);
			put(6, 3);
			put(7, 4);
			put(8, 5);
			put(9, 5);
			put(10, 6);
		}
	};

	public String getHalflingTitle(String alignment, int level) {
		String title = "";

		switch (level) {
		case 1:
			title = "Wanderer";
			break;
		case 2:
			title = "Explorer";
			break;
		case 3:
			title = "Collector";
			break;
		case 4:
			title = "Accumulator";
			break;
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			title = "Wise one";
			break;
		default:
			title = "";
		}
		return title;

	}

	/**
	 * @return the sneakSilently
	 */
	public int getSneakSilently() {
		return sneakSilently;
	}

	/**
	 * @param sneakSilently
	 *            the sneakSilently to set
	 */
	public void setSneakSilently(int sneakSilently) {
		this.sneakSilently = sneakSilently;
	}

	/**
	 * @return the hideInShadows
	 */
	public int getHideInShadows() {
		return hideInShadows;
	}

	/**
	 * @param hideInShadows
	 *            the hideInShadows to set
	 */
	public void setHideInShadows(int hideInShadows) {
		this.hideInShadows = hideInShadows;
	}

	public void debugTheHalfling() {
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
		System.out.println("Skills list: ");
		System.out.println("sneak silently: " + this.sneakSilently);
		System.out.println("hide In Shadows: " + this.hideInShadows);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Halfling" + "\n" + "hitPointDie="
				+ hitPointDie + "\n" + "critTable=" + critTable + "\n"
				+ "sneakSilently=" + sneakSilently + "\n" + "hideInShadows="
				+ hideInShadows;
	}
}
