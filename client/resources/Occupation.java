package com.horsegoeswest.dcc.client.resources;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.horsegoeswest.dcc.client.equipment.Equipment;
import com.horsegoeswest.dcc.client.equipment.Weapon;

public class Occupation {
	
	private String name;
	private Equipment tradeGood;
	private Weapon trainedWeapon;
	
	public Occupation(String name, String tradeGood, String trainedWeapon) {
		this.name = name;
		this.tradeGood = new Equipment(tradeGood, 0); //create trade good
		
		//Check to see if we have an item playing as another weapon
		if (trainedWeapon.contains("(as"))
			{
			//grab the existing as-weapon and the new weapon name
			
			String oldWeapon = "";
			String re ="\\s[a-z]+"; //regex pattern to grab the existing weapon name that appears within the parens
			
			
		    //Pattern p = Pattern.compile(re,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    //Matcher m = p.matcher(trainedWeapon);
			
			RegExp regExp = RegExp.compile(re);
			MatchResult m = regExp.exec(trainedWeapon);
			
			oldWeapon = m.getGroup(0).trim();
			
				
			//grab the new weapon name
			String newWeaponName = "";
			String re2 = "^[A-Z][a-z]+\\b"; //regex pattern to grab the weapon name ie Hammer in the phrase "Hammer (as club)"
			
			//Pattern p2 = Pattern.compile(re2, Pattern.DOTALL);
		    //Matcher m2 = p2.matcher(trainedWeapon);
			RegExp regExp2 = RegExp.compile(re2);
			MatchResult m2 = regExp2.exec(trainedWeapon);
			
		    newWeaponName = m2.getGroup(0);
			
		    //create the new weapon
		    String newWeaponDamage = "";
		    String newWeaponRange = "";
		    int NewWeaponCost = 0;
		    
		    for (Weapon weapon : DCCTables.weaponList)
			{   
				//match old weapon
				if (oldWeapon.equals(weapon.getName().toLowerCase()))
				{
					newWeaponDamage = weapon.getDamage();
					newWeaponRange = weapon.getRange();
					break;
				}
			}
		    
		    
		    Weapon customWeapon = new Weapon (newWeaponName, newWeaponDamage, newWeaponRange, NewWeaponCost);
		    
		    this.trainedWeapon = customWeapon;
			}
		
		else {
			for (Weapon weapon : DCCTables.weaponList)
				{   
					//match existing weapon
					if (trainedWeapon.equals(weapon.getName()))
					{
						this.trainedWeapon = weapon;
						break;
					}
				}
		}
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
	 * @return the tradeGood
	 */
	public Equipment getTradeGood() {
		return tradeGood;
	}

	/**
	 * @param tradeGood the tradeGood to set
	 */
	public void setTradeGood(Equipment tradeGood) {
		this.tradeGood = tradeGood;
	}

	/**
	 * @return the trainedWeapon
	 */
	public Weapon getTrainedWeapon() {
		return trainedWeapon;
	}

	/**
	 * @param trainedWeapon the trainedWeapon to set
	 */
	public void setTrainedWeapon(Weapon trainedWeapon) {
		this.trainedWeapon = trainedWeapon;
	}
	
	

}
