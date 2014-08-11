/**
 * 
 */
package com.horsegoeswest.dcc.client.resources;

/**
 * @author Horse
 *
 */
public enum Coins {
	COPPER(1), SILVER(10), GOLD(100), ELECTRUM(1000), PLATINUM(10000);

	
	  int value;

	private Coins(int value) {
	        this.value = value;
	}
	
}