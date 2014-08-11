package com.horsegoeswest.dcc.client.characters;

import java.util.HashMap;
import java.util.Map;

import com.horsegoeswest.dcc.client.resources.AbilityScores;
import com.horsegoeswest.dcc.client.resources.DCCTables;
import com.horsegoeswest.dcc.client.resources.Occupation;
import com.horsegoeswest.dcc.client.resources.Wallet;

public class Thief extends CharacterClass {

	private int hitPointDie = 6;

	private int backstab;
	private int sneakSilently;
	private int hideInShadows;
	private int pickPocket;
	private int climbSheerSurfaces;
	private int pickLock;
	private int findTrap;
	private int disableTrap;
	private int forgeDocument;
	private int disguiseSelf;
	private int readLanguages;
	private int handlePoison;
	private int castSpellFromScroll;
	private String luckDie;

	public Thief(int level, String alignment, String name, Occupation occupation) {
		this.level = level;
		this.alignment = alignment;
		this.abilityScores = new AbilityScores();
		this.name = name;
		this.charClass = "Thief";
		this.critTable = "II";
		this.title = getThiefTitle(this.alignment, this.level);
		this.occupation = occupation;
		this.refSave = refSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getAgility());
		this.fortSave = fortSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers.get(abilityScores.getStamina());
		this.willSave = willSaveModifier.get(this.level)
				+ DCCTables.abilityModifiers
						.get(abilityScores.getPersonality());
		this.hitPoints = generateHitPoints(hitPointDie, this.level);
		this.speed = DCCTables.characterSpeed.get("Thief");
		this.luckyRoll = generateLuckyRoll();
		this.actionDice = actionDiceTable.get(this.level);
		this.initiative = generateInitiative(this.level, "Thief",
				DCCTables.abilityModifiers.get(abilityScores.getAgility()));
		this.actionDice = actionDiceTable.get(this.level);
		this.attack = attackBonus.get(this.level);
		this.critDie = critDieTable.get(this.level);
		this.characterWeapons
		.add(this.occupation.getTrainedWeapon());
		this.characterEquipment.add(this.occupation.getTradeGood());
		generateThiefSkills(
				this.alignment,
				this.level,
				DCCTables.abilityModifiers.get(abilityScores.getAgility()),
				DCCTables.abilityModifiers.get(abilityScores.getIntelligence()),
				DCCTables.abilityModifiers.get(abilityScores.getPersonality()));
		this.luckDie = luckDieTable.get(this.level);
		this.wallet =  new Wallet(this.level, this.charClass);
		setMeleeAttack(attackBonus.get(this.level), DCCTables.abilityModifiers.get(this.abilityScores.getStrength()));
		setMissileAttack(attackBonus.get(this.level));
		debugTheThief();
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
			put(1, "1d10");
			put(2, "1d12");
			put(3, "1d14");
			put(4, "1d16");
			put(5, "1d20");
			put(6, "1d24");
			put(7, "1d30");
			put(8, "1d30+2");
			put(9, "1d30+4");
			put(10, "1d30+6");
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

	// Key: level, Value: Luck die
	@SuppressWarnings("serial")
	public Map<Integer, String> luckDieTable = new HashMap<Integer, String>() {
		{
			put(1, "d3");
			put(2, "d4");
			put(3, "d5");
			put(4, "d6");
			put(5, "d7");
			put(6, "d8");
			put(7, "d10");
			put(8, "d12");
			put(9, "d14");
			put(10, "d16");
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

	public String getThiefTitle(String alignment, int level) {
		String title = "";

		if (alignment.equals("Lawful")) {
			switch (level) {
			case 1:
				title = "Bravo";
				break;
			case 2:
				title = "Apprentice";
				break;
			case 3:
				title = "Rogue";
				break;
			case 4:
				title = "Capo";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Boss";
				break;
			default:
				title = "";
			}
			return title;
		}

		else if (alignment.equals("Neutral")) {
			switch (level) {
			case 1:
				title = "Beggar";
				break;
			case 2:
				title = "Cutpurse";
				break;
			case 3:
				title = "Burglar";
				break;
			case 4:
				title = "Robber";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Swindler";
				break;
			default:
				title = "";
			}
			return title;
		} else if (alignment.equals("Chaotic")) {
			switch (level) {
			case 1:
				title = "Thug";
				break;
			case 2:
				title = "Murderer";
				break;
			case 3:
				title = "Cutthroat";
				break;
			case 4:
				title = "Executioner";
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				title = "Assassin";
				break;
			default:
				title = "";
			}
			return title;
		}

		return title;
	}

	private void generateThiefSkills(String alignment, int level,
			int agilityModifier, int intelligenceModifier,
			int personalityModifier) {

		if (alignment.equals("Lawful")) {
			switch (level) {
			case 1:
				backstab = 1;
				sneakSilently = 1 + agilityModifier;
				hideInShadows = 3 + agilityModifier;
				pickPocket = 1 + agilityModifier;
				climbSheerSurfaces = 3 + agilityModifier;
				pickLock = 1 + agilityModifier;
				findTrap = 3 + intelligenceModifier;
				disableTrap = 3 + agilityModifier;
				forgeDocument = 0 + personalityModifier;
				disguiseSelf = 0 + personalityModifier;
				readLanguages = 0 + intelligenceModifier;
				handlePoison = 0;
				castSpellFromScroll = 10 + intelligenceModifier;
				break;
			case 2:
				backstab = 3;
				sneakSilently = 3 + agilityModifier;
				hideInShadows = 5 + agilityModifier;
				pickPocket = 3 + agilityModifier;
				climbSheerSurfaces = 5 + agilityModifier;
				pickLock = 3 + agilityModifier;
				findTrap = 5 + intelligenceModifier;
				disableTrap = 5 + agilityModifier;
				forgeDocument = 0 + personalityModifier;
				disguiseSelf = 1 + personalityModifier;
				readLanguages = 0 + intelligenceModifier;
				handlePoison = 1;
				castSpellFromScroll = 10 + intelligenceModifier;
				break;
			case 3:
				backstab = 5;
				sneakSilently = 5 + agilityModifier;
				hideInShadows = 7 + agilityModifier;
				pickPocket = 5 + agilityModifier;
				climbSheerSurfaces = 7 + agilityModifier;
				pickLock = 5 + agilityModifier;
				findTrap = 7 + intelligenceModifier;
				disableTrap = 7 + agilityModifier;
				forgeDocument = 1 + personalityModifier;
				disguiseSelf = 2 + personalityModifier;
				readLanguages = 1 + intelligenceModifier;
				handlePoison = 2;
				castSpellFromScroll = 12 + intelligenceModifier;
				break;
			case 4:
				backstab = 7;
				sneakSilently = 7 + agilityModifier;
				hideInShadows = 8 + agilityModifier;
				pickPocket = 7 + agilityModifier;
				climbSheerSurfaces = 8 + agilityModifier;
				pickLock = 7 + agilityModifier;
				findTrap = 8 + intelligenceModifier;
				disableTrap = 8 + agilityModifier;
				forgeDocument = 2 + personalityModifier;
				disguiseSelf = 3 + personalityModifier;
				readLanguages = 2 + intelligenceModifier;
				handlePoison = 3;
				castSpellFromScroll = 12 + intelligenceModifier;
				break;
			case 5:
				backstab = 8;
				sneakSilently = 8 + agilityModifier;
				hideInShadows = 9 + agilityModifier;
				pickPocket = 8 + agilityModifier;
				climbSheerSurfaces = 9 + agilityModifier;
				pickLock = 8 + agilityModifier;
				findTrap = 9 + intelligenceModifier;
				disableTrap = 9 + agilityModifier;
				forgeDocument = 3 + personalityModifier;
				disguiseSelf = 4 + personalityModifier;
				readLanguages = 3 + intelligenceModifier;
				handlePoison = 4;
				castSpellFromScroll = 14 + intelligenceModifier;
				break;
			case 6:
				backstab = 9;
				sneakSilently = 9 + agilityModifier;
				hideInShadows = 11 + agilityModifier;
				pickPocket = 9 + agilityModifier;
				climbSheerSurfaces = 11 + agilityModifier;
				pickLock = 9 + agilityModifier;
				findTrap = 11 + intelligenceModifier;
				disableTrap = 11 + agilityModifier;
				forgeDocument = 4 + personalityModifier;
				disguiseSelf = 5 + personalityModifier;
				readLanguages = 4 + intelligenceModifier;
				handlePoison = 5;
				castSpellFromScroll = 14 + intelligenceModifier;
				break;
			case 7:
				backstab = 10;
				sneakSilently = 10 + agilityModifier;
				hideInShadows = 12 + agilityModifier;
				pickPocket = 10 + agilityModifier;
				climbSheerSurfaces = 12 + agilityModifier;
				pickLock = 10 + agilityModifier;
				findTrap = 12 + intelligenceModifier;
				disableTrap = 12 + agilityModifier;
				forgeDocument = 5 + personalityModifier;
				disguiseSelf = 6 + personalityModifier;
				readLanguages = 5 + intelligenceModifier;
				handlePoison = 6;
				castSpellFromScroll = 16 + intelligenceModifier;
				break;
			case 8:
				backstab = 11;
				sneakSilently = 11 + agilityModifier;
				hideInShadows = 13 + agilityModifier;
				pickPocket = 11 + agilityModifier;
				climbSheerSurfaces = 13 + agilityModifier;
				pickLock = 11 + agilityModifier;
				findTrap = 13 + intelligenceModifier;
				disableTrap = 13 + agilityModifier;
				forgeDocument = 6 + personalityModifier;
				disguiseSelf = 7 + personalityModifier;
				readLanguages = 6 + intelligenceModifier;
				handlePoison = 7;
				castSpellFromScroll = 16 + intelligenceModifier;
				break;
			case 9:
				backstab = 12;
				sneakSilently = 12 + agilityModifier;
				hideInShadows = 14 + agilityModifier;
				pickPocket = 12 + agilityModifier;
				climbSheerSurfaces = 14 + agilityModifier;
				pickLock = 12 + agilityModifier;
				findTrap = 14 + intelligenceModifier;
				disableTrap = 14 + agilityModifier;
				forgeDocument = 7 + personalityModifier;
				disguiseSelf = 8 + personalityModifier;
				readLanguages = 7 + intelligenceModifier;
				handlePoison = 8;
				castSpellFromScroll = 20 + intelligenceModifier;
				break;
			case 10:
				backstab = 13;
				sneakSilently = 13 + agilityModifier;
				hideInShadows = 15 + agilityModifier;
				pickPocket = 13 + agilityModifier;
				climbSheerSurfaces = 15 + agilityModifier;
				pickLock = 13 + agilityModifier;
				findTrap = 15 + intelligenceModifier;
				disableTrap = 15 + agilityModifier;
				forgeDocument = 8 + personalityModifier;
				disguiseSelf = 9 + personalityModifier;
				readLanguages = 8 + intelligenceModifier;
				handlePoison = 9;
				castSpellFromScroll = 20 + intelligenceModifier;
				break;

			}

		} else if (alignment.equals("Neutral")) {
			switch (level) {
			case 1:
				backstab = 0;
				sneakSilently = 3 + agilityModifier;
				hideInShadows = 1 + agilityModifier;
				pickPocket = 3 + agilityModifier;
				climbSheerSurfaces = 3 + agilityModifier;
				pickLock = 1 + agilityModifier;
				findTrap = 1 + intelligenceModifier;
				disableTrap = 1 + agilityModifier;
				forgeDocument = 3 + personalityModifier;
				disguiseSelf = 0 + personalityModifier;
				readLanguages = 0 + intelligenceModifier;
				handlePoison = 0;
				castSpellFromScroll = 12 + intelligenceModifier;
				break;
			case 2:
				backstab = 1;
				sneakSilently = 5 + agilityModifier;
				hideInShadows = 3 + agilityModifier;
				pickPocket = 5 + agilityModifier;
				climbSheerSurfaces = 5 + agilityModifier;
				pickLock = 3 + agilityModifier;
				findTrap = 3 + intelligenceModifier;
				disableTrap = 3 + agilityModifier;
				forgeDocument = 5 + personalityModifier;
				disguiseSelf = 0 + personalityModifier;
				readLanguages = 1 + intelligenceModifier;
				handlePoison = 0;
				castSpellFromScroll = 12 + intelligenceModifier;
				break;
			case 3:
				backstab = 2;
				sneakSilently = 7 + agilityModifier;
				hideInShadows = 5 + agilityModifier;
				pickPocket = 7 + agilityModifier;
				climbSheerSurfaces = 7 + agilityModifier;
				pickLock = 5 + agilityModifier;
				findTrap = 5 + intelligenceModifier;
				disableTrap = 5 + agilityModifier;
				forgeDocument = 7 + personalityModifier;
				disguiseSelf = 1 + personalityModifier;
				readLanguages = 2 + intelligenceModifier;
				handlePoison = 1;
				castSpellFromScroll = 14 + intelligenceModifier;
				break;
			case 4:
				backstab = 3;
				sneakSilently = 8 + agilityModifier;
				hideInShadows = 7 + agilityModifier;
				pickPocket = 8 + agilityModifier;
				climbSheerSurfaces = 8 + agilityModifier;
				pickLock = 7 + agilityModifier;
				findTrap = 7 + intelligenceModifier;
				disableTrap = 7 + agilityModifier;
				forgeDocument = 8 + personalityModifier;
				disguiseSelf = 2 + personalityModifier;
				readLanguages = 3 + intelligenceModifier;
				handlePoison = 2;
				castSpellFromScroll = 14 + intelligenceModifier;
				break;
			case 5:
				backstab = 4;
				sneakSilently = 9 + agilityModifier;
				hideInShadows = 8 + agilityModifier;
				pickPocket = 9 + agilityModifier;
				climbSheerSurfaces = 9 + agilityModifier;
				pickLock = 8 + agilityModifier;
				findTrap = 8 + intelligenceModifier;
				disableTrap = 8 + agilityModifier;
				forgeDocument = 9 + personalityModifier;
				disguiseSelf = 3 + personalityModifier;
				readLanguages = 4 + intelligenceModifier;
				handlePoison = 3;
				castSpellFromScroll = 16 + intelligenceModifier;
				break;
			case 6:
				backstab = 5;
				sneakSilently = 11 + agilityModifier;
				hideInShadows = 9 + agilityModifier;
				pickPocket = 11 + agilityModifier;
				climbSheerSurfaces = 11 + agilityModifier;
				pickLock = 9 + agilityModifier;
				findTrap = 9 + intelligenceModifier;
				disableTrap = 9 + agilityModifier;
				forgeDocument = 11 + personalityModifier;
				disguiseSelf = 4 + personalityModifier;
				readLanguages = 5 + intelligenceModifier;
				handlePoison = 4;
				castSpellFromScroll = 16 + intelligenceModifier;
				break;
			case 7:
				backstab = 6;
				sneakSilently = 12 + agilityModifier;
				hideInShadows = 10 + agilityModifier;
				pickPocket = 12 + agilityModifier;
				climbSheerSurfaces = 12 + agilityModifier;
				pickLock = 10 + agilityModifier;
				findTrap = 10 + intelligenceModifier;
				disableTrap = 10 + agilityModifier;
				forgeDocument = 12 + personalityModifier;
				disguiseSelf = 5 + personalityModifier;
				readLanguages = 6 + intelligenceModifier;
				handlePoison = 5;
				castSpellFromScroll = 20 + intelligenceModifier;
				break;
			case 8:
				backstab = 7;
				sneakSilently = 13 + agilityModifier;
				hideInShadows = 11 + agilityModifier;
				pickPocket = 13 + agilityModifier;
				climbSheerSurfaces = 13 + agilityModifier;
				pickLock = 11 + agilityModifier;
				findTrap = 11 + intelligenceModifier;
				disableTrap = 11 + agilityModifier;
				forgeDocument = 13 + personalityModifier;
				disguiseSelf = 6 + personalityModifier;
				readLanguages = 7 + intelligenceModifier;
				handlePoison = 6;
				castSpellFromScroll = 20 + intelligenceModifier;
				break;
			case 9:
				backstab = 8;
				sneakSilently = 14 + agilityModifier;
				hideInShadows = 12 + agilityModifier;
				pickPocket = 14 + agilityModifier;
				climbSheerSurfaces = 14 + agilityModifier;
				pickLock = 12 + agilityModifier;
				findTrap = 12 + intelligenceModifier;
				disableTrap = 12 + agilityModifier;
				forgeDocument = 14 + personalityModifier;
				disguiseSelf = 7 + personalityModifier;
				readLanguages = 8 + intelligenceModifier;
				handlePoison = 7;
				castSpellFromScroll = 20 + intelligenceModifier;
				break;
			case 10:
				backstab = 9;
				sneakSilently = 15 + agilityModifier;
				hideInShadows = 13 + agilityModifier;
				pickPocket = 15 + agilityModifier;
				climbSheerSurfaces = 15 + agilityModifier;
				pickLock = 13 + agilityModifier;
				findTrap = 13 + intelligenceModifier;
				disableTrap = 13 + agilityModifier;
				forgeDocument = 15 + personalityModifier;
				disguiseSelf = 8 + personalityModifier;
				readLanguages = 9 + intelligenceModifier;
				handlePoison = 8;
				castSpellFromScroll = 20 + intelligenceModifier;
				break;

			}

		} else if (alignment.equals("Chaotic")) {
			switch (level) {
			case 1:
				backstab = 3;
				sneakSilently = 3 + agilityModifier;
				hideInShadows = 1 + agilityModifier;
				pickPocket = 0 + agilityModifier;
				climbSheerSurfaces = 1 + agilityModifier;
				pickLock = 1 + agilityModifier;
				findTrap = 1 + intelligenceModifier;
				disableTrap = 0 + agilityModifier;
				forgeDocument = 0 + personalityModifier;
				disguiseSelf = 3 + personalityModifier;
				readLanguages = 0 + intelligenceModifier;
				handlePoison = 3;
				castSpellFromScroll = 10 + intelligenceModifier;
				break;
			case 2:
				backstab = 5;
				sneakSilently = 5 + agilityModifier;
				hideInShadows = 3 + agilityModifier;
				pickPocket = 1 + agilityModifier;
				climbSheerSurfaces = 3 + agilityModifier;
				pickLock = 3 + agilityModifier;
				findTrap = 3 + intelligenceModifier;
				disableTrap = 1 + agilityModifier;
				forgeDocument = 0 + personalityModifier;
				disguiseSelf = 5 + personalityModifier;
				readLanguages = 0 + intelligenceModifier;
				handlePoison = 5;
				castSpellFromScroll = 10 + intelligenceModifier;
				break;
			case 3:
				backstab = 7;
				sneakSilently = 7 + agilityModifier;
				hideInShadows = 5 + agilityModifier;
				pickPocket = 2 + agilityModifier;
				climbSheerSurfaces = 5 + agilityModifier;
				pickLock = 5 + agilityModifier;
				findTrap = 5 + intelligenceModifier;
				disableTrap = 2 + agilityModifier;
				forgeDocument = 1 + personalityModifier;
				disguiseSelf = 7 + personalityModifier;
				readLanguages = 1 + intelligenceModifier;
				handlePoison = 7;
				castSpellFromScroll = 12 + intelligenceModifier;
				break;
			case 4:
				backstab = 8;
				sneakSilently = 8 + agilityModifier;
				hideInShadows = 7 + agilityModifier;
				pickPocket = 3 + agilityModifier;
				climbSheerSurfaces = 7 + agilityModifier;
				pickLock = 7 + agilityModifier;
				findTrap = 7 + intelligenceModifier;
				disableTrap = 3 + agilityModifier;
				forgeDocument = 2 + personalityModifier;
				disguiseSelf = 8 + personalityModifier;
				readLanguages = 2 + intelligenceModifier;
				handlePoison = 8;
				castSpellFromScroll = 12 + intelligenceModifier;
				break;
			case 5:
				backstab = 9;
				sneakSilently = 9 + agilityModifier;
				hideInShadows = 8 + agilityModifier;
				pickPocket = 4 + agilityModifier;
				climbSheerSurfaces = 8 + agilityModifier;
				pickLock = 8 + agilityModifier;
				findTrap = 8 + intelligenceModifier;
				disableTrap = 4 + agilityModifier;
				forgeDocument = 3 + personalityModifier;
				disguiseSelf = 9 + personalityModifier;
				readLanguages = 3 + intelligenceModifier;
				handlePoison = 9;
				castSpellFromScroll = 14 + intelligenceModifier;
				break;
			case 6:
				backstab = 11;
				sneakSilently = 11 + agilityModifier;
				hideInShadows = 9 + agilityModifier;
				pickPocket = 5 + agilityModifier;
				climbSheerSurfaces = 9 + agilityModifier;
				pickLock = 9 + agilityModifier;
				findTrap = 9 + intelligenceModifier;
				disableTrap = 5 + agilityModifier;
				forgeDocument = 4 + personalityModifier;
				disguiseSelf = 11 + personalityModifier;
				readLanguages = 4 + intelligenceModifier;
				handlePoison = 11;
				castSpellFromScroll = 14 + intelligenceModifier;
				break;
			case 7:
				backstab = 12;
				sneakSilently = 12 + agilityModifier;
				hideInShadows = 10 + agilityModifier;
				pickPocket = 6 + agilityModifier;
				climbSheerSurfaces = 10 + agilityModifier;
				pickLock = 10 + agilityModifier;
				findTrap = 10 + intelligenceModifier;
				disableTrap = 6 + agilityModifier;
				forgeDocument = 5 + personalityModifier;
				disguiseSelf = 12 + personalityModifier;
				readLanguages = 5 + intelligenceModifier;
				handlePoison = 12;
				castSpellFromScroll = 16 + intelligenceModifier;
				break;
			case 8:
				backstab = 13;
				sneakSilently = 13 + agilityModifier;
				hideInShadows = 11 + agilityModifier;
				pickPocket = 7 + agilityModifier;
				climbSheerSurfaces = 11 + agilityModifier;
				pickLock = 11 + agilityModifier;
				findTrap = 11 + intelligenceModifier;
				disableTrap = 7 + agilityModifier;
				forgeDocument = 6 + personalityModifier;
				disguiseSelf = 13 + personalityModifier;
				readLanguages = 6 + intelligenceModifier;
				handlePoison = 13;
				castSpellFromScroll = 16 + intelligenceModifier;
				break;
			case 9:
				backstab = 14;
				sneakSilently = 14 + agilityModifier;
				hideInShadows = 12 + agilityModifier;
				pickPocket = 8 + agilityModifier;
				climbSheerSurfaces = 12 + agilityModifier;
				pickLock = 12 + agilityModifier;
				findTrap = 12 + intelligenceModifier;
				disableTrap = 8 + agilityModifier;
				forgeDocument = 7 + personalityModifier;
				disguiseSelf = 14 + personalityModifier;
				readLanguages = 7 + intelligenceModifier;
				handlePoison = 14;
				castSpellFromScroll = 20 + intelligenceModifier;
				break;
			case 10:
				backstab = 15;
				sneakSilently = 15 + agilityModifier;
				hideInShadows = 13 + agilityModifier;
				pickPocket = 9 + agilityModifier;
				climbSheerSurfaces = 13 + agilityModifier;
				pickLock = 13 + agilityModifier;
				findTrap = 13 + intelligenceModifier;
				disableTrap = 9 + agilityModifier;
				forgeDocument = 8 + personalityModifier;
				disguiseSelf = 15 + personalityModifier;
				readLanguages = 8 + intelligenceModifier;
				handlePoison = 15;
				castSpellFromScroll = 20 + intelligenceModifier;
				break;

			}

		}

	}

	/**
	 * @return the backstab
	 */
	public int getBackstab() {
		return backstab;
	}

	/**
	 * @param backstab
	 *            the backstab to set
	 */
	public void setBackstab(int backstab) {
		this.backstab = backstab;
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

	/**
	 * @return the pickPocket
	 */
	public int getPickPocket() {
		return pickPocket;
	}

	/**
	 * @param pickPocket
	 *            the pickPocket to set
	 */
	public void setPickPocket(int pickPocket) {
		this.pickPocket = pickPocket;
	}

	/**
	 * @return the climbSheerSurfaces
	 */
	public int getClimbSheerSurfaces() {
		return climbSheerSurfaces;
	}

	/**
	 * @param climbSheerSurfaces
	 *            the climbSheerSurfaces to set
	 */
	public void setClimbSheerSurfaces(int climbSheerSurfaces) {
		this.climbSheerSurfaces = climbSheerSurfaces;
	}

	/**
	 * @return the pickLock
	 */
	public int getPickLock() {
		return pickLock;
	}

	/**
	 * @param pickLock
	 *            the pickLock to set
	 */
	public void setPickLock(int pickLock) {
		this.pickLock = pickLock;
	}

	/**
	 * @return the findTrap
	 */
	public int getFindTrap() {
		return findTrap;
	}

	/**
	 * @param findTrap
	 *            the findTrap to set
	 */
	public void setFindTrap(int findTrap) {
		this.findTrap = findTrap;
	}

	/**
	 * @return the disableTrap
	 */
	public int getDisableTrap() {
		return disableTrap;
	}

	/**
	 * @param disableTrap
	 *            the disableTrap to set
	 */
	public void setDisableTrap(int disableTrap) {
		this.disableTrap = disableTrap;
	}

	/**
	 * @return the forgeDocument
	 */
	public int getForgeDocument() {
		return forgeDocument;
	}

	/**
	 * @param forgeDocument
	 *            the forgeDocument to set
	 */
	public void setForgeDocument(int forgeDocument) {
		this.forgeDocument = forgeDocument;
	}

	/**
	 * @return the disguiseSelf
	 */
	public int getDisguiseSelf() {
		return disguiseSelf;
	}

	/**
	 * @param disguiseSelf
	 *            the disguiseSelf to set
	 */
	public void setDisguiseSelf(int disguiseSelf) {
		this.disguiseSelf = disguiseSelf;
	}

	/**
	 * @return the readLanguages
	 */
	public int getReadLanguages() {
		return readLanguages;
	}

	/**
	 * @param readLanguages
	 *            the readLanguages to set
	 */
	public void setReadLanguages(int readLanguages) {
		this.readLanguages = readLanguages;
	}

	/**
	 * @return the handlePoison
	 */
	public int getHandlePoison() {
		return handlePoison;
	}

	/**
	 * @param handlePoison
	 *            the handlePoison to set
	 */
	public void setHandlePoison(int handlePoison) {
		this.handlePoison = handlePoison;
	}

	/**
	 * @return the castSpellFromScroll
	 */
	public int getCastSpellFromScroll() {
		return castSpellFromScroll;
	}

	/**
	 * @param castSpellFromScroll
	 *            the castSpellFromScroll to set
	 */
	public void setCastSpellFromScroll(int castSpellFromScroll) {
		this.castSpellFromScroll = castSpellFromScroll;
	}

	/**
	 * @return the luckDie
	 */
	public String getLuckDie() {
		return luckDie;
	}

	/**
	 * @param luckDie
	 *            the luckDie to set
	 */
	public void setLuckDie(String luckDie) {
		this.luckDie = luckDie;
	}

	public void debugTheThief() {
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
		System.out.println("backstab: " + this.backstab);
		System.out.println("sneak silently: " + this.sneakSilently);
		System.out.println("hide In Shadows: " + this.hideInShadows);
		System.out.println("pick Pocket: " + this.pickPocket);
		System.out.println("climb Sheer Surfaces: " + climbSheerSurfaces);
		System.out.println("pick Lock: " + pickLock);
		System.out.println("find Trap: " + findTrap);
		System.out.println("disable Trap: " + disableTrap);
		System.out.println("forge Document: " + forgeDocument);
		System.out.println("disguise Self: " + disguiseSelf);
		System.out.println("read Languages: " + readLanguages);
		System.out.println("handle Poison: " + handlePoison);
		System.out.println("cast Spell From Scroll: " + castSpellFromScroll);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Thief" + "\n" + "hitPointDie="
				+ hitPointDie + "\n" + "critTable=" + critTable + "backstab="
				+ backstab + "\n" + "sneakSilently=" + sneakSilently
				+ "hideInShadows=" + hideInShadows + "\n" + "pickPocket="
				+ pickPocket + "\n" + "climbSheerSurfaces="
				+ climbSheerSurfaces + "\n" + "pickLock=" + pickLock + "\n"
				+ "findTrap=" + findTrap + "\n" + "disableTrap=" + disableTrap
				+ "\n" + "forgeDocument=" + forgeDocument + "\n"
				+ "disguiseSelf=" + disguiseSelf + "readLanguages="
				+ readLanguages + "\n" + "handlePoison=" + handlePoison + "\n"
				+ "castSpellFromScroll=" + castSpellFromScroll;
	}

}
