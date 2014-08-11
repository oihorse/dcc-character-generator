package com.horsegoeswest.dcc.client.equipment;

public class Armor {

	private String name;
	private int acBonus;
	private int checkPenalty;
	private int speed;
	private String fumbleDie;
	private int cost; //in copper
	
	
	public Armor(String name, int acBonus, int checkPenalty, int speed,
			String fumbleDie, int cost) {

		this.name = name;
		this.acBonus = acBonus;
		this.checkPenalty = checkPenalty;
		this.speed = speed;
		this.fumbleDie = fumbleDie;
		this.cost = cost;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the acBonus
	 */
	public int getAcBonus() {
		return acBonus;
	}
	/**
	 * @param acBonus the acBonus to set
	 */
	public void setAcBonus(int acBonus) {
		this.acBonus = acBonus;
	}
	/**
	 * @return the checkPenalty
	 */
	public int getCheckPenalty() {
		return checkPenalty;
	}
	/**
	 * @param checkPenalty the checkPenalty to set
	 */
	public void setCheckPenalty(int checkPenalty) {
		this.checkPenalty = checkPenalty;
	}
	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * @return the fumbleDie
	 */
	public String getFumbleDie() {
		return fumbleDie;
	}
	/**
	 * @param fumbleDie the fumbleDie to set
	 */
	public void setFumbleDie(String fumbleDie) {
		this.fumbleDie = fumbleDie;
	}
	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Armor [name=" + name + ", acBonus=" + acBonus
				+ ", checkPenalty=" + checkPenalty + ", speed=" + speed
				+ ", fumbleDie=" + fumbleDie + ", cost=" + cost + "]";
	}
	
	
	
}
