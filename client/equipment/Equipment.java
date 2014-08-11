package com.horsegoeswest.dcc.client.equipment;

public class Equipment {
	private String name;
	private int cost; //in copper
	
public Equipment(String name, int cost) {
		this.name = name;
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
		return "Equipment [name=" + name + ", cost=" + cost + "]";
	}
	
	
	
}
