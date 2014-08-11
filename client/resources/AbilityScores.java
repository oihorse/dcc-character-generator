package com.horsegoeswest.dcc.client.resources;

public class AbilityScores {

	int strength = 0;
	int agility = 0;
	int stamina = 0;
	int personality = 0;
	int luck = 0;
	int intelligence = 0;

	public AbilityScores() {
		generateAbilityScores();
	}

	private void generateAbilityScores() {
		// generate random ability scores
		strength = DCCTables.randNumber(3, 18);
		agility = DCCTables.randNumber(3, 18);
		stamina = DCCTables.randNumber(3, 18);
		personality = DCCTables.randNumber(3, 18);
		luck = DCCTables.randNumber(3, 18);
		intelligence = DCCTables.randNumber(3, 18);
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @param strength
	 *            the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * @return the agility
	 */
	public int getAgility() {
		return agility;
	}

	/**
	 * @param agility
	 *            the agility to set
	 */
	public void setAgility(int agility) {
		this.agility = agility;
	}

	/**
	 * @return the stamina
	 */
	public int getStamina() {
		return stamina;
	}

	/**
	 * @param stamina
	 *            the stamina to set
	 */
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	/**
	 * @return the personality
	 */
	public int getPersonality() {
		return personality;
	}

	/**
	 * @param personality
	 *            the personality to set
	 */
	public void setPersonality(int personality) {
		this.personality = personality;
	}

	/**
	 * @return the luck
	 */
	public int getLuck() {
		return luck;
	}

	/**
	 * @param luck
	 *            the luck to set
	 */
	public void setLuck(int luck) {
		this.luck = luck;
	}

	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * @param intelligence
	 *            the intelligence to set
	 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbilityScores" + "\n" + "strength=" + strength + "\n"
				+ "agility=" + agility + "\n" + "stamina=" + stamina + "\n"
				+ "personality=" + personality + "\n" + "luck=" + luck + "\n"
				+ "intelligence=" + intelligence;
	}

}
