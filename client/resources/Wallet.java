package com.horsegoeswest.dcc.client.resources;

import java.util.ArrayList;
import java.util.List;

import com.horsegoeswest.dcc.client.resources.Coins;

public class Wallet {

	// This class keeps track the coins available to the character.
	private List<Coins> changePurse = new ArrayList<Coins>();
	private String moneyString = "";

	public Wallet(int charLevel, String charClass) {
		updateChangePurse(DCCTables.generateGold(charLevel, charClass));
		generateMoneyString(changePurse);

	}

	public void caclulatePurchase(List<Coins> changePurse,
			int cost) {
		int copper = 0;
		int copperRemaining = 0;

		// calculate how much total copper is in the character's wallet
		for (Coins coin : changePurse) {
			copper += changeToCopper(coin);
		}

		copperRemaining = copper - cost;

		updateChangePurse(copperRemaining);

	}

	private int changeToCopper(Coins coin) {
		int pileOfMoney = 0;
		pileOfMoney = Coins.COPPER.value * coin.value;

		return pileOfMoney;
	}

	private void updateChangePurse(int copperRemaining) {

		int copper = copperRemaining;
		this.changePurse.clear();

		while (copper >= 10000) {
			this.changePurse.add(Coins.PLATINUM);
			copper += -10000;
		}

		while (copper >= 1000) {
			this.changePurse.add(Coins.ELECTRUM);
			copper += -1000;
		}

		while (copper >= 100) {
			this.changePurse.add(Coins.GOLD);
			copper += -100;
		}

		while (copper >= 10) {
			this.changePurse.add(Coins.SILVER);
			copper += -10;
		}

		while (copper >= 1) {
			this.changePurse.add(Coins.COPPER);
			copper += -1;
		}

	}

	// take the coins in the change purse and turn it into something that can be
	// printed
	private void generateMoneyString(List<Coins> changePurse) {

		int p = 0;
		int e = 0;
		int g = 0;
		int s = 0;
		int c = 0;
		String theMoney = "";

		for (Coins coin : changePurse) {
			switch (coin) {
			case PLATINUM:
				p++;
				break;
			case ELECTRUM:
				e++;
				break;
			case GOLD:
				g++;
				break;
			case SILVER:
				s++;
				break;
			case COPPER:
				c++;
				break;
			}
		}

		if (p != 0) {
			theMoney += p + "p ";
		}
		if (e != 0) {
			theMoney += e + "e ";
		}
		if (g != 0) {
			theMoney += g + "g ";
		}
		if (s != 0) {
			theMoney += s + "s ";
		}
		if (c != 0) {
			theMoney += c + "c";
		}

		this.moneyString = theMoney;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return moneyString;
	}
}
