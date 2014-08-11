package com.horsegoeswest.dcc.client.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.horsegoeswest.dcc.client.resources.AbilityScores;
import com.horsegoeswest.dcc.client.resources.DCCTables;
import com.horsegoeswest.dcc.client.resources.Occupation;
import com.horsegoeswest.dcc.client.resources.Wallet;

public class Wizard extends CharacterClass {

	private int hitPointDie = 4;
	private String patron = "";
	private String spellCheck = "";
	private String familiar = "";
	private String corruption = "";
	private int numberOfSpells; // highest number of spells character can know
	private int maxSpellLevel; // highest spell level achieved based on level
	private int maxCastingLevel; // highest level spells character can learn
									// based off intelligence
	private List<Integer> spellList = new ArrayList<Integer>();

	@SuppressWarnings("serial")
	private Map<Integer, Integer> wizardSpellsKnownBonus = new HashMap<Integer, Integer>() {
		{
			put(3, -16);
			put(4, -2);
			put(5, -2);
			put(6, -1);
			put(7, -1);
			put(8, 0);
			put(9, 0);
			put(10, 0);
			put(11, 0);
			put(12, 0);
			put(13, 0);
			put(14, 1);
			put(15, 1);
			put(16, 1);
			put(17, 2);
			put(18, 2);
		}
	};

	@SuppressWarnings("serial")
	private Map<Integer, Integer> spellsKnown = new HashMap<Integer, Integer>() {
		{
			put(1, 4);
			put(2, 5);
			put(3, 6);
			put(4, 7);
			put(5, 8);
			put(6, 9);
			put(7, 10);
			put(8, 12);
			put(9, 14);
			put(10, 16);
		}
	};

	@SuppressWarnings("serial")
	private Map<Integer, Integer> maxSpellAtLevel = new HashMap<Integer, Integer>() {
		{
			put(1, 1);
			put(2, 1);
			put(3, 2);
			put(4, 2);
			put(5, 3);
			put(6, 3);
			put(7, 4);
			put(8, 4);
			put(9, 5);
			put(10, 5);
		}
	};

	public Wizard(int level, String alignment, String name, Occupation occupation) {
		this.level = level;
		this.alignment = alignment;
		this.abilityScores = new AbilityScores();
		this.name = name;
		this.charClass = "Wizard";
		this.critTable = "I";
		this.title = getWizardTitle(this.alignment, this.level);
		this.occupation = occupation;
		this.refSave = refSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getAgility());
		this.fortSave = fortSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getStamina());
		this.willSave = willSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers
						.get(abilityScores.getPersonality());
		this.hitPoints = generateHitPoints(hitPointDie, this.level);
		this.speed = DCCTables.characterSpeed.get("Wizard");
		this.luckyRoll = generateLuckyRoll();
		this.actionDice = actionDiceTable.get(this.level);
		this.initiative = generateInitiative(this.level, "Wizard",
				DCCTables.abilityModifiers.get(abilityScores.getAgility()));
		this.actionDice = actionDiceTable.get(this.level);
		this.attack = attackBonus.get(this.level);
		this.critDie = critDieTable.get(this.level);
		this.characterWeapons
		.add(this.occupation.getTrainedWeapon());
		this.characterEquipment.add(this.occupation.getTradeGood());
		this.spellCheck = getSpellCheck(this.level,
				DCCTables.abilityModifiers.get(abilityScores.getIntelligence()));
		this.numberOfSpells = getNumberOfSpellsKnown(
				this.level,
				wizardSpellsKnownBonus.get(this.abilityScores.getIntelligence()));
		this.maxSpellLevel = maxSpellAtLevel.get(this.level);
		this.maxCastingLevel = DCCTables.maxSpells.get(this.abilityScores
				.getIntelligence());
		this.wallet =  new Wallet(this.level, this.charClass);
		
		setMeleeAttack(attackBonus.get(this.level), DCCTables.abilityModifiers.get(this.abilityScores.getStrength()));
		setMissileAttack(attackBonus.get(this.level));

		debugTheWizard();

	}

	// Key: level, Value: attack bonus
	@SuppressWarnings("serial")
	public Map<Integer, String> attackBonus = new HashMap<Integer, String>() {
		{
			put(1, "0");
			put(2, "1");
			put(3, "1");
			put(4, "1");
			put(5, "2");
			put(6, "2");
			put(7, "3");
			put(8, "3");
			put(9, "4");
			put(10, "4");
		}
	};

	// Key: level, Value: crit die
	@SuppressWarnings("serial")
	public Map<Integer, String> critDieTable = new HashMap<Integer, String>() {
		{
			put(1, "1d6");
			put(2, "1d6");
			put(3, "1d8");
			put(4, "1d8");
			put(5, "1d10");
			put(6, "1d10");
			put(7, "1d12");
			put(8, "1d12");
			put(9, "1d14");
			put(10, "1d14");
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
			put(7, "1d20 + 1d16");
			put(8, "1d20 + 1d20");
			put(9, "1d20 + 1d20");
			put(10, "1d20 + 1d20 + 1d14");
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

	public String getWizardTitle(String alignment, int level) {
		String title = "";

		if (alignment.equals("Lawful")) {
			switch (level) {
			case 1:
				title = "Evoker";
				break;
			case 2:
				title = "Controller";
				break;
			case 3:
				title = "Conjurer";
				break;
			case 4:
				title = "Summoner";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Elementalist";
				break;
			default:
				title = "";
			}
			return title;
		}

		else if (alignment.equals("Neutral")) {
			switch (level) {
			case 1:
				title = "Astrologist";
				break;
			case 2:
				title = "Enchanter";
				break;
			case 3:
				title = "Magician";
				break;
			case 4:
				title = "Thaumaturgust";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Sorcerer";
				break;
			default:
				title = "";
			}
			return title;
		} else if (alignment.equals("Chaotic")) {
			switch (level) {
			case 1:
				title = "Cultist";
				break;
			case 2:
				title = "Shaman";
				break;
			case 3:
				title = "Diabolist";
				break;
			case 4:
				title = "Warlock / Witch";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Necromancer";
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

	public int getNumberOfSpellsKnown(int charLevel, int abilityModifier) {
		int sk = 0;

		sk = spellsKnown.get(charLevel) + abilityModifier;

		if (sk <= 0) {
			return 0;
		}

		return sk;

	}

	/**
	 * @return the patron
	 */
	public String getPatron() {
		return patron;
	}

	/**
	 * @param patron
	 *            the patron to set
	 */
	public void setPatron(String patron) {
		this.patron = patron;
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
	 * @return the familiar
	 */
	public String getFamiliar() {
		return familiar;
	}

	/**
	 * @param familiar
	 *            the familiar to set
	 */
	public void setFamiliar(String familiar) {
		this.familiar = familiar;
	}

	/**
	 * @return the corruption
	 */
	public String getCorruption() {
		return corruption;
	}

	/**
	 * @param corruption
	 *            the corruption to set
	 */
	public void setCorruption(String corruption) {
		this.corruption = corruption;
	}

	public void debugTheWizard() {
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
		System.out.println("number of spells: " + this.numberOfSpells);
		System.out.println("max spell level: " + this.maxSpellLevel);
		System.out.println("max casting level: " + this.maxCastingLevel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Wizard" + "\n" + "hitPointDie="
				+ hitPointDie + "\n" + "critTable=" + critTable + "\n"
				+ "patron=" + patron + "\n" + "spellCheck=" + spellCheck + "\n"
				+ "familiar=" + familiar + "\n" + "corruption=" + corruption
				+ "\n" + "numberOfSpells=" + numberOfSpells + "\n"
				+ "maxSpellLevel=" + maxSpellLevel + "\n" + "maxCastingLevel="
				+ maxCastingLevel;
	}

}
