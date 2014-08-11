package com.horsegoeswest.dcc.client.characters;

import java.util.ArrayList;
import java.util.List;

import com.horsegoeswest.dcc.client.CharacterGenerator;
import com.horsegoeswest.dcc.client.equipment.Armor;
import com.horsegoeswest.dcc.client.equipment.Equipment;
import com.horsegoeswest.dcc.client.equipment.Weapon;
import com.horsegoeswest.dcc.client.events.ArmorListUpdateEvent;
import com.horsegoeswest.dcc.client.events.ArmorListUpdateEventHandler;
import com.horsegoeswest.dcc.client.events.EquipmentListUpdateEvent;
import com.horsegoeswest.dcc.client.events.EquipmentListUpdateEventHandler;
import com.horsegoeswest.dcc.client.events.SetArmorClassEvent;
import com.horsegoeswest.dcc.client.events.SetArmorClassEventHandler;
import com.horsegoeswest.dcc.client.events.SetArmorClassFieldEvent;
import com.horsegoeswest.dcc.client.events.SetMeleeDamageEvent;
import com.horsegoeswest.dcc.client.events.SetMeleeDamageEventHandler;
import com.horsegoeswest.dcc.client.events.SetMeleeDamageFieldEvent;
import com.horsegoeswest.dcc.client.events.SetMissileDamageEvent;
import com.horsegoeswest.dcc.client.events.SetMissileDamageEventHandler;
import com.horsegoeswest.dcc.client.events.SetMissileDamageFieldEvent;
import com.horsegoeswest.dcc.client.events.WeaponListUpdateEvent;
import com.horsegoeswest.dcc.client.events.WeaponListUpdateEventHandler;
import com.horsegoeswest.dcc.client.resources.AbilityScores;
import com.horsegoeswest.dcc.client.resources.DCCTables;
import com.horsegoeswest.dcc.client.resources.Occupation;
import com.horsegoeswest.dcc.client.resources.Wallet;

public class CharacterClass {
	protected String name;
	protected String charClass;
	protected String alignment;
	protected int level;
	protected AbilityScores abilityScores;
	protected Occupation occupation;
	protected String title;
	protected int refSave;
	protected int fortSave;
	protected int willSave;
	protected int hitPoints;
	protected int speed;
	protected String initiative;
	protected String actionDice;
	protected String attack;
	protected String critDie;
	protected int armorClass;
	protected String  meleeAttack;
	protected String meleeDamage;
	protected String  missileAttack;
	protected String missileDamage;
	protected String luckyRoll;
	protected List<Weapon> characterWeapons = new ArrayList<Weapon>();
	protected List<String> characterTreasure = new ArrayList<String>();
	protected List<Equipment> characterEquipment = new ArrayList<Equipment>();
	protected List<Armor> characterArmor = new ArrayList<Armor>();
	protected List<String> languages = new ArrayList<String>();
	protected int xp;
	protected String critTable;
	protected Wallet wallet;
	protected Weapon mainWeapon;
	protected Weapon mainMissileWeapon;
	protected Armor mainArmor;

	
	
	

	public CharacterClass() {
		CharacterGenerator.eventBus.addHandler(WeaponListUpdateEvent.TYPE, new WeaponListUpdateEventHandler() {
			
			@Override
			public void updateWeaponList(WeaponListUpdateEvent event) {
				Weapon weapon = event.getWeapon();
				String typeOfUpdate = event.getTypeOfUpdate();
				
				if(typeOfUpdate.equals("add"))
				{
					addWeapon(weapon);
				}
				if (typeOfUpdate.equals("remove"))
				{
					removeWeapon(weapon);
				}
			}
		});
		
			CharacterGenerator.eventBus.addHandler(EquipmentListUpdateEvent.TYPE, new EquipmentListUpdateEventHandler() {
			
			@Override
			public void updateEquipmentList(EquipmentListUpdateEvent event) {
				Equipment equipment = event.getEquipment();
				String typeOfUpdate = event.getTypeOfUpdate();
				
				if(typeOfUpdate.equals("add"))
				{
					addEquipment(equipment);
				}
				if (typeOfUpdate.equals("remove"))
				{
					removeEquipment(equipment);
				}
			}
		});
			
			CharacterGenerator.eventBus.addHandler(ArmorListUpdateEvent.TYPE, new ArmorListUpdateEventHandler() {
				
				@Override
				public void updateArmorList(ArmorListUpdateEvent event) {
					Armor armor = event.getArmor();
					String typeOfUpdate = event.getTypeOfUpdate();
					
					if(typeOfUpdate.equals("add"))
					{
						addArmor(armor);
					}
					if (typeOfUpdate.equals("remove"))
					{
						removeArmor(armor);
					}
				}
			});
			
			CharacterGenerator.eventBus.addHandler(SetMeleeDamageEvent.TYPE, new SetMeleeDamageEventHandler() {
				
				@Override
				public void setMeleeWeaponDamage(SetMeleeDamageEvent event) {
					String damage = event.getDamage();
					
					setMeleeDamage(damage);
					CharacterGenerator.eventBus.fireEvent(new SetMeleeDamageFieldEvent(
							getMeleeDamage()));
				}
			});
			
			CharacterGenerator.eventBus.addHandler(SetMissileDamageEvent.TYPE, new SetMissileDamageEventHandler() {
				
				@Override
				public void setMissileWeaponDamage(SetMissileDamageEvent event) {
					String damage = event.getDamage();
					
					setMissileDamage(damage);
					CharacterGenerator.eventBus.fireEvent(new SetMissileDamageFieldEvent(
							getMissileDamage()));
				}
			});
			
			CharacterGenerator.eventBus.addHandler(SetArmorClassEvent.TYPE, new SetArmorClassEventHandler() {
				
				@Override
				public void setCharacterArmorClass(SetArmorClassEvent event) {
					int ac = event.getArmorClass();
					
					setArmorClass(ac);
					
					CharacterGenerator.eventBus.fireEvent(new SetArmorClassFieldEvent(
							getArmorClass()));
				}
			});
	
	}

	protected int generateHitPoints(int hitPointDie, int level) {
		int hp = 0;
		int i = 1;
		while (i <= level) {
			hp += DCCTables.randNumber(1, hitPointDie);
			i++;
		}
		hp += hp + DCCTables.randNumber(1, 4);

		return hp;
	}

	protected String generateLuckyRoll() {
		String lr = DCCTables.luckyRoll.get(DCCTables.randNumber(0, 29));

		return lr;

	}

	protected String generateInitiative(int level, String charClass,
			int agilityModifier) {
		String initRoll = "";

		if (charClass.equals("Warrior")) {
			initRoll = "1d20 + " + level + agilityModifier;
		} else {
			initRoll = "1d20 + " + agilityModifier;
		}

		return initRoll;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the charClass
	 */
	public String getCharClass() {
		return charClass;
	}

	/**
	 * @param charClass
	 *            the charClass to set
	 */
	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	/**
	 * @return the abilityScores
	 */
	public AbilityScores getAbilityScores() {
		return abilityScores;
	}

	/**
	 * @param abilityScores
	 *            the abilityScores to set
	 */
	public void setAbilityScores(AbilityScores abilityScores) {
		this.abilityScores = abilityScores;
	}

	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return alignment;
	}

	/**
	 * @param alignment
	 *            the alignment to set
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the occupation
	 */
	public Occupation getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation
	 *            the occupation to set
	 */
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the refSave
	 */
	public int getRefSave() {
		return refSave;
	}

	/**
	 * @param refSave
	 *            the refSave to set
	 */
	public void setRefSave(int refSave) {
		this.refSave = refSave;
	}

	/**
	 * @return the fortSave
	 */
	public int getFortSave() {
		return fortSave;
	}

	/**
	 * @param fortSave
	 *            the fortSave to set
	 */
	public void setFortSave(int fortSave) {
		this.fortSave = fortSave;
	}

	/**
	 * @return the willSave
	 */
	public int getWillSave() {
		return willSave;
	}

	/**
	 * @param willSave
	 *            the willSave to set
	 */
	public void setWillSave(int willSave) {
		this.willSave = willSave;
	}

	/**
	 * @return the hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * @param hitPoints
	 *            the hitPoints to set
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the initiative
	 */
	public String getInitiative() {
		return initiative;
	}

	/**
	 * @param initiative
	 *            the initiative to set
	 */
	public void setInitiative(String initiative) {
		this.initiative = initiative;
	}

	/**
	 * @return the actionDice
	 */
	public String getActionDice() {
		return actionDice;
	}

	/**
	 * @param actionDice
	 *            the actionDice to set
	 */
	public void setActionDice(String actionDice) {
		this.actionDice = actionDice;
	}

	/**
	 * @return the attack
	 */
	public String getAttack() {
		return attack;
	}

	/**
	 * @param attack
	 *            the attack to set
	 */
	public void setAttack(String attack) {
		this.attack = attack;
	}

	/**
	 * @return the critDie
	 */
	public String getCritDie() {
		return critDie;
	}

	/**
	 * @param critDie
	 *            the critDie to set
	 */
	public void setCritDie(String critDie) {
		this.critDie = critDie;
	}

	/**
	 * @return the armorClass
	 */
	public int getArmorClass() {
		return armorClass;
	}

	/**
	 * @param armorClass
	 *            the armorClass to set
	 */
	public void setArmorClass(int armorClass) {
		this.armorClass = 10 + armorClass;
	}

	/**
	 * @return the meleeAttack
	 */
	public String getMeleeAttack() {
		return meleeAttack;
	}

	/**
	 * @param meleeAttack
	 *            the meleeAttack to set
	 */
	public void setMeleeAttack(String attackBonus, int strengthModifier) {
		if (this.charClass.equals("Warrior") || this.charClass.equals("Dwarf"))
		{
			this.meleeAttack = attackBonus + " " + strengthModifier;
		}
		else
		{
		Integer modifier = Integer.parseInt(attackBonus) + strengthModifier;
		this.meleeAttack = modifier.toString();
		}
	}

	/**
	 * @return the meleeDamage
	 */
	public String getMeleeDamage() {
		return meleeDamage;
	}

	/**
	 * @param meleeDamage
	 *            the meleeDamage to set
	 */
	public void setMeleeDamage(String meleeDamage) {
		int modifier = DCCTables.abilityModifiers.get(abilityScores.getStrength());
		
		if (modifier >= 0)
		{
			this.meleeDamage = meleeDamage + " + " + modifier;
		}
		else{
		this.meleeDamage  = meleeDamage + modifier;
		}
		
		System.out.println("meleeDamage is: " + this.meleeDamage);
	
	}

	/**
	 * @return the missileAttack
	 */
	public String getMissileAttack() {
		return missileAttack;
	}

	/**
	 * @param missileAttack
	 *            the missileAttack to set
	 */
	public void setMissileAttack(String missileAttack) {
		this.missileAttack = missileAttack;
	}

	/**
	 * @return the missileDamage
	 */
	public String getMissileDamage() {
		return missileDamage;
	}

	/**
	 * @param missileDamage
	 *            the missileDamage to set
	 */
	public void setMissileDamage(String missileDamage) {
		this.missileDamage = missileDamage;
	}

	/**
	 * @return the luckyRoll
	 */
	public String getLuckyRoll() {
		return luckyRoll;
	}

	/**
	 * @param luckyRoll
	 *            the luckyRoll to set
	 */
	public void setLuckyRoll(String luckyRoll) {
		this.luckyRoll = luckyRoll;
	}

	/**
	 * @return the characterWeapons
	 */
	public List<Weapon> getCharacterWeapons() {
		return characterWeapons;
	}

	/**
	 * @param characterWeapons
	 *            the characterWeapons to set
	 */
	public void setCharacterWeapons(List<Weapon> characterWeapons) {
		this.characterWeapons = characterWeapons;
		
	}
	
	
	public void addWeapon(Weapon weapon)
	{
		this.characterWeapons.add(weapon);
		System.out.println("character weaopns now is: " + characterWeapons);
	}
	
	public void removeWeapon(Weapon weapon)
	{
		this.characterWeapons.remove(this.characterWeapons.indexOf(weapon));
		System.out.println("character weaopns now is: " + characterWeapons);
	}

	/**
	 * @return the characterTreasure
	 */
	public List<String> getCharacterTreasure() {
		return characterTreasure;
	}

	/**
	 * @param characterTreasure
	 *            the characterTreasure to set
	 */
	public void setCharacterTreasure(List<String> characterTreasure) {
		this.characterTreasure = characterTreasure;
	}

	/**
	 * @return the characterEquipment
	 */
	public List<Equipment> getCharacterEquipment() {
		return characterEquipment;
	}

	/**
	 * @param characterEquipment
	 *            the characterEquipment to set
	 */
	public void setCharacterEquipment(List<Equipment> characterEquipment) {
		this.characterEquipment = characterEquipment;
	}
	
	public void addEquipment(Equipment equipment)
	{
		this.characterEquipment.add(equipment);
		System.out.println("character equipment now is: " + characterEquipment);
	}
	
	public void removeEquipment(Equipment equipment)
	{
		this.characterEquipment.remove(this.characterEquipment.indexOf(equipment));
		System.out.println("character weaopns equipment is: " + characterEquipment);
	}
	
	/**
	 * @return the languages
	 */
	public List<String> getLanguages() {
		return languages;
	}

	/**
	 * @param languages
	 *            the languages to set
	 */
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	/**
	 * @return the characterArmor
	 */
	public List<Armor> getCharacterArmor() {
		return characterArmor;
	}

	/**
	 * @param characterArmor
	 *            the characterArmor to set
	 */
	public void setCharacterArmor(List<Armor> characterArmor) {
		this.characterArmor = characterArmor;
		
		
	}
	
	public void addArmor(Armor armor)
	{
		this.characterArmor.add(armor);
		System.out.println("character armor now is: " + characterArmor);
	}
	
	public void removeArmor(Armor armor)
	{
		this.characterArmor.remove(this.characterArmor.indexOf(armor));
		System.out.println("character armor now is: " + characterArmor);
	}

	/**
	 * @return the xp
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * @param xp
	 *            the xp to set
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}

	/**
	 * @return the critTable
	 */
	public String getCritTable() {
		return critTable;
	}

	/**
	 * @param critTable
	 *            the critTable to set
	 */
	public void setCritTable(String critTable) {
		this.critTable = critTable;
	}

	/**
	 * @return the wallet
	 */
	public Wallet getWallet() {
		return wallet;
	}

	/**
	 * @param wallet the wallet to set
	 */
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public String getCharacterEquipmentNames()
	{
		String equipmentList = "";
		for (Equipment equipment : this.characterEquipment)
		{
			equipmentList += equipment.getName() + "\n";
		}
		
		return equipmentList;
	}
	
	public String getCharacterWeaponNames()
	{
		String weapnList = "";
		for (Weapon weapon : this.characterWeapons)
		{
			weapnList += weapon.getName() + "\n";
		}
		
		return weapnList;
	}
	
	public String getCharacterArmorNames()
	{
		String armorList = "";
		for (Armor armor : this.characterArmor)
		{
			armorList += armor.getName() + "\n";
		}
		
		return armorList;
	}
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CharacterClass " + "\n" + "name=" + name + "\n" + "alignment="
				+ alignment + "\n" + "level=" + level + "\n"
				+ abilityScores.toString() + "\n" + "occupation=" + occupation
				+ "\n" + "title=" + title + "\n" + "refSave=" + refSave + "\n"
				+ "fortSave=" + fortSave + "\n" + "willSave=" + willSave + "\n"
				+ "hitPoints=" + hitPoints + "\n" + "speed=" + speed + "\n"
				+ "initiative=" + initiative + "\n" + "actionDice="
				+ actionDice + "\n" + "attack=" + attack + "\n" + "critDie="
				+ critDie + "\n" + "armorClass=" + armorClass + "\n"
				+ "meleeAttack=" + meleeAttack + "\n" + "meleeDamage="
				+ meleeDamage + "\n" + "missileAttack=" + missileAttack + "\n"
				+ "missileDamage=" + missileDamage + "\n" + "luckyRoll="
				+ luckyRoll + "\n" + "characterWeapons=" + characterWeapons
				+ "\n" + "characterTreasure=" + characterTreasure + "\n"
				+ "characterEquipment=" + characterEquipment + "\n"
				+ "characterArmor=" + characterArmor + "\n"
				+ "wallet" + wallet;
	}

}
