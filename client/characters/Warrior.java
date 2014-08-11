package com.horsegoeswest.dcc.client.characters;

import java.util.HashMap;
import java.util.Map;

import com.horsegoeswest.dcc.client.resources.AbilityScores;
import com.horsegoeswest.dcc.client.resources.DCCTables;
import com.horsegoeswest.dcc.client.resources.Occupation;
import com.horsegoeswest.dcc.client.resources.Wallet;

public class Warrior extends CharacterClass {
	private int hitPointDie = 12;
	private String luckyWeapon = "";
	private String threatRange = "";

	public Warrior(int level, String alignment, String name, Occupation occupation) {
		this.level = level;
		this.alignment = alignment;
		this.abilityScores = new AbilityScores();
		this.name = name;
		this.charClass = "Warrior";
		this.title = getWarriorTitle(this.alignment, this.level);
		this.occupation = occupation;
		this.refSave = refSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getAgility());
		this.fortSave = fortSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getStamina());
		this.willSave = willSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers
						.get(abilityScores.getPersonality());
		this.hitPoints = generateHitPoints(hitPointDie, this.level);
		this.speed = DCCTables.characterSpeed.get("Warrior");
		this.luckyRoll = generateLuckyRoll();
		this.actionDice = actionDiceTable.get(this.level);
		this.initiative = generateInitiative(this.level, "Warrior",
				DCCTables.abilityModifiers.get(abilityScores.getAgility()));
		this.actionDice = actionDiceTable.get(this.level);
		this.attack = attackBonus.get(this.level);
		this.critDie = critDieTable.get(this.level);
		this.characterWeapons
		.add(this.occupation.getTrainedWeapon());
		this.characterEquipment.add(this.occupation.getTradeGood());
		this.critTable = generateCritDie(this.level);
		this.threatRange = threatRangeTable.get(this.level);
		this.wallet =  new Wallet(this.level, this.charClass);
		
		setMeleeAttack(attackBonus.get(this.level), DCCTables.abilityModifiers.get(this.abilityScores.getStrength()));
		setMissileAttack(attackBonus.get(this.level));

		debugTheWarrior();

	}

	// Key: level, Value: attack bonus
	@SuppressWarnings("serial")
	public Map<Integer, String> attackBonus = new HashMap<Integer, String>() {
		{
			put(1, "d3");
			put(2, "d4");
			put(3, "d5");
			put(4, "d6");
			put(5, "d7");
			put(6, "d8");
			put(7, "d10 + 1");
			put(8, "d10 + 2");
			put(9, "d10 + 3");
			put(10, "d10 + 4");
		}
	};

	// Key: level, Value: crit die
	@SuppressWarnings("serial")
	public Map<Integer, String> critDieTable = new HashMap<Integer, String>() {
		{
			put(1, "1d12");
			put(2, "1d14");
			put(3, "1d16");
			put(4, "1d20");
			put(5, "1d24");
			put(6, "1d30");
			put(7, "1d30");
			put(8, "2d20");
			put(9, "2d20");
			put(10, "2d20");
		}
	};

	// Key: level, Value: crit die
	@SuppressWarnings("serial")
	public Map<Integer, String> threatRangeTable = new HashMap<Integer, String>() {
		{
			put(1, "19-20");
			put(2, "19-20");
			put(3, "19-20");
			put(4, "19-20");
			put(5, "18-20");
			put(6, "18-20");
			put(7, "18-20");
			put(8, "18-20");
			put(9, "17-20");
			put(10, "17-20");
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
			put(5, "1d20 + 1d14");
			put(6, "1d20 + 1d16");
			put(7, "1d20 + 1d20");
			put(8, "1d20 + 1d20");
			put(9, "1d20 + 1d20");
			put(10, "1d20 + 1d20 + 1d14");
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
			put(6, 1);
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

	// Key: level, Value: Reflex Save modifier
	@SuppressWarnings("serial")
	public Map<Integer, Integer> refSaveModifier = new HashMap<Integer, Integer>() {
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

	public String getWarriorTitle(String alignment, int level) {
		String title = "";

		if (alignment.equals("Lawful")) {
			switch (level) {
			case 1:
				title = "Squire";
				break;
			case 2:
				title = "Champion";
				break;
			case 3:
				title = "Knight";
				break;
			case 4:
				title = "Cavalier";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Paladin";
				break;
			default:
				title = "";
			}
			return title;
		}

		else if (alignment.equals("Neutral")) {
			switch (level) {
			case 1:
				title = "Wilding";
				break;
			case 2:
				title = "Barbarian";
				break;
			case 3:
				title = "Berserker";
				break;
			case 4:
				title = "Headman/Headwoman";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Chieftain";
				break;
			default:
				title = "";
			}
			return title;
		} else if (alignment.equals("Chaotic")) {
			switch (level) {
			case 1:
				title = "Bandit";
				break;
			case 2:
				title = "Brigand";
				break;
			case 3:
				title = "Maraduer";
				break;
			case 4:
				title = "Ravager";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Reaver";
				break;
			default:
				title = "";
			}
			return title;
		}

		return title;
	}

	private String generateCritDie(int charLevel) {
		String crit = "";

		if (level < 3) {
			crit = "III";
		} else if (level < 5 && level > 2) {
			crit = "IV";
		} else {
			crit = "V";
		}

		return crit;
	}

	/**
	 * @return the luckyWeapon
	 */
	public String getLuckyWeapon() {
		return luckyWeapon;
	}

	/**
	 * @param luckyWeapon
	 *            the luckyWeapon to set
	 */
	public void setLuckyWeapon(String luckyWeapon) {
		this.luckyWeapon = luckyWeapon;
	}

	/**
	 * @return the threatRange
	 */
	public String getThreatRange() {
		return threatRange;
	}

	/**
	 * @param threatRange
	 *            the threatRange to set
	 */
	public void setThreatRange(String threatRange) {
		this.threatRange = threatRange;
	}

	public void debugTheWarrior() {
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
		System.out.println("crit die: " + this.critDie);
		System.out.println("crit table: " + this.critTable);
		System.out.println("threat range: " + this.threatRange);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Warrior" + "\n" + "hitPointDie="
				+ hitPointDie + "\n" + "critTable=" + critTable + "\n"
				+ "luckyWeapon=" + luckyWeapon + "\n" + "threatRange="
				+ threatRange;
	}
}
