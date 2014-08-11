package com.horsegoeswest.dcc.client.equipment;

public class Weapon {
	
	private String name;
	private String damage;
	private String range;
	private int cost;
	

	public Weapon(String name, String damage, String range, int cost) {
		this.name = name;
		this.damage = damage;
		this.range = range;
		this.cost = cost; //in copper
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
	 * @return the damage
	 */
	public String getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(String damage) {
		this.damage = damage;
	}
	/**
	 * @return the range
	 */
	public String getRange() {
		return range;
	}
	/**
	 * @param range the range to set
	 */
	public void setRange(String range) {
		this.range = range;
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
		return "Weapons [name=" + name + ", damage=" + damage + ", range="
				+ range + ", cost=" + cost + "]";
	}

}
