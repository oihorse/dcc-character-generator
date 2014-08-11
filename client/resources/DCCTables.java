package com.horsegoeswest.dcc.client.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.Random;
import com.horsegoeswest.dcc.client.equipment.Ammunition;
import com.horsegoeswest.dcc.client.equipment.Armor;
import com.horsegoeswest.dcc.client.equipment.Equipment;
import com.horsegoeswest.dcc.client.equipment.Weapon;

public class DCCTables {

	// list of occupations. eventual rewrite as enum with weapons and trade
	// goods
	public static List<String> occupations = new ArrayList<String>(
			Arrays.asList("Alchemist", "Animal Trainer", "Armorer",
					"Astrologer", "Barber", "Beadle", "Beekeeper",
					"Blacksmith", "Butcher", "Caravan Guard", "Cheesemaker",
					"Cobbler", "Confidence artist", "Cooper", "Costermonger",
					"Cutpurse", "Ditch Digger", "Dwarven apothecarist",
					"Dwarven blacksmith", "Dwarven chest-maker",
					"Dwarven herder", "Dwarven miner",
					"Dwarven mushroom-farmer", "Dwarven Rat-catcher",
					"Dwarven Stonemason", "Elven artisan", "Elven barrister",
					"Elven chandler", "Elven falconer", "Elven forester",
					"Elven glassblower", "Elven navigator", "Elven sage",
					"Farmer", "Fortune-teller", "Gambler", "Gongfarmer",
					"Grave digger", "Guild beggar", "Halfling chicken butcher",
					"Halfling dyer", "Halfling glovemaker", "Halfling gypsy",
					"Halfling haberdasher", "Halfling mariner",
					"Halfling moneylender", "Halfling trader",
					"Halfling vagrant", "Healer", "Herbalist", "Herder",
					"Hunter", "Indentured servant", "Jester", "Jewler",
					"Locksmith", "Mendicant", "Mercenary", "Merchant",
					"Miller/baker", "Minstrel", "Noble", "Orphan", "Ostler",
					"Outlaw", "Rope maker", "Scribe", "Shaman", "Slave",
					"Smuggler", "Soldier", "Squire", "Tax collector",
					"Trapper", "Urchin", "Wainwright", "Weaver",
					"Wizard's apprentice", "Woodcutter"));
	
	
	//Occupations. Pre-populating now. Flat-file fed later.
	public static List<Occupation> occupationList = new ArrayList<Occupation>();
	
	public static void populateOccupationList()
	{
		Occupation alchemist = new Occupation("Alchemist","Oil, 1 flask","Staff");
		Occupation animalTrainer = new Occupation("Animal Trainer","Pony","Club");
		Occupation armorer = new Occupation("Armorer","Iron helmet", "Hammer (as club)");
		Occupation astrologer = new Occupation("Astrologer","Spyglass","Dagger");
		Occupation barber = new Occupation("Barber","Scissors","Razor (as dagger)");
		Occupation beadle = new Occupation("Beadle","Holy symbol","Staff");
		Occupation beekeeper = new Occupation("Beekeeper","Jar of honey","Staff");
		Occupation blacksmith = new Occupation("Blacksmith","Steel tongs","Hammer (as club)");
		Occupation butcher = new Occupation("Butcher","Side of beef","Cleaver (as axe)");
		Occupation caravanGuard = new Occupation("Caravan Guard","Linen, 1 yard","Short sword");
		Occupation cheesemarker = new Occupation("Cheesemaker","Stinky cheese","Cudgel (as staff)");
		Occupation cobbler = new Occupation("Cobbler","Shoehorn","Awl (as dagger)");
		Occupation confidenceArtist = new Occupation("Confidence artist","Quality cloak","Dagger");
		Occupation cooper = new Occupation("Cooper","Barrel","Crowbar (as club)");
		Occupation costermonger = new Occupation("Costermonger","Fruit","Knife (as dagger)");
		Occupation cutpurse = new Occupation("Cutpurse","Small chest","Dagger");
		Occupation ditchDigger = new Occupation("Ditch Digger","Fine dirt, 1 lb.","Shovel (as staff)");
		Occupation dwarvenApthoecarist = new Occupation("Dwarven apothecarist","Steel vial","Cudgel (as staff)");
		Occupation dwarvenBlacksmith = new Occupation("Dwarven blacksmith","Mithril, 1 oz.","Hammer (as club)");
		Occupation dwarvenChestmaker = new Occupation("Dwarven chest-maker","Wood, 10 lbs.","Chisel (as dagger)");
		Occupation dwarvenHerder = new Occupation("Dwarven herder","Sow","Staff");
		Occupation dwarvenMiner = new Occupation("Dwarven miner","Lantern","Pick (as club)");
		Occupation dwarvenMushroomFarmer = new Occupation("Dwarven mushroom-farmer","Sack","Shovel (as staff)");
		Occupation dwarvenRatCatcher= new Occupation("Dwarven Rat-catcher","Net","Club");
		Occupation dwarvenStonemason = new Occupation("Dwarven Stonemason","Fine Stone 10 lbs.","Hammer (as club)");
		Occupation elvenArtisan = new Occupation("Elven artisan","Clay, 1 lb.","Staff");
		Occupation elvenBarrister = new Occupation("Elven barrister","Book","Quill (as dart)");
		Occupation elvenChandler = new Occupation("Elven chandler","Candles, 20","Scissors (as dagger)");
		Occupation elvenFlaconer = new Occupation("Elven falconer","Falcon","Dagger");
		Occupation elvenForester = new Occupation("Elven forester","Herbs, 1 lb.","Staff");
		Occupation elvenGlassblower = new Occupation("Elven glassblower","Glass beads","Hammer");
		Occupation elvenNavigator = new Occupation("Elven navigator","Spyglass","Longbow");
		Occupation elvenSage = new Occupation("Elven sage","Parchment and quill pen","Dagger");
		Occupation farmer = new Occupation("Farmer","Hen","Pitchfork (as spear)");
		Occupation fortuneTeller = new Occupation("Fortune-teller","Tarot deck","Dagger");
		Occupation gambler = new Occupation("Gambler","Dice","Club");
		Occupation gongFarmer= new Occupation("Gongfarmer","Sack of night soil","Trowel (as dagger)");
		Occupation graveDigger = new Occupation("Grave digger","Trowel","Shovel (as staff)");
		Occupation guildBeggar = new Occupation("Guild beggar","Crutches","Sling");
		Occupation halflingChickenButcher = new Occupation("Halfling chicken butcher","Chicken meat, 5 lbs.","Handaxe");
		Occupation halflingDyer = new Occupation("Halfling dyer","Fabric, 3 yards","Staff");
		Occupation halflingGlovemaker= new Occupation("Halfling glovemaker","Gloves, 4 pairs","Awl (as dagger)");
		Occupation halflingGypsy = new Occupation("Halfling gypsy","Hex doll","Sling");
		Occupation halflingHaberdasher = new Occupation("Halfling haberdasher","Fine suits, 3 sets","Scissors (as dagger)");
		Occupation halflingMariner = new Occupation("Halfling mariner","Sailcloth, 2 yards","Knife (as dagger)");
		Occupation halflingMoneylender = new Occupation("Halfling moneylender","5 gp, 10 sp , 200 cp","Short sword");
		Occupation halflingTrader= new Occupation("Halfling trader","20 sp","Short sword");
		Occupation halflingVagrant = new Occupation("Halfling vagrant","Begging bowl","Club");
		Occupation healer = new Occupation("Healer","Holy water, 1 vial","Club");
		Occupation herbalist = new Occupation("Herbalist","Herbs, 1 lb.","Club");
		Occupation herder = new Occupation("Herder","Herding dog","Staff");
		Occupation hunter = new Occupation("Hunter","Deer pelt","Shortbow");
		Occupation indenturedServant = new Occupation("Indentured servant","Locket","Staff");
		Occupation jester = new Occupation("Jester","Silk clothes","Dart");
		Occupation jewler = new Occupation("Jewler","Gem worth 20 gp","Dagger");
		Occupation locksmith = new Occupation("Locksmith","Fine tools","Dagger");
		Occupation mendicant = new Occupation("Mendicant","Cheese dip","Club");
		Occupation mercenary = new Occupation("Mercenary","Hide armor","Longsword");
		Occupation merchant = new Occupation("Merchant","4 gp, 15 sp, 27 cp","Dagger");
		Occupation millerBaker = new Occupation("Miller/baker","Flour, 1 lb.","Club");
		Occupation minstrel = new Occupation("Minstrel","Ukulele","Dagger");
		Occupation noble = new Occupation("Noble","Gold ring worth 10 gp","Longsword");
		Occupation orphan = new Occupation("Orphan","Rag doll","Club");
		Occupation ostler = new Occupation("Ostler", "Bridle","Staff");
		Occupation outlaw = new Occupation("Outlaw","Leather armor","Short sword");
		Occupation ropeMaker = new Occupation("Rope maker","Rope, 100'","Knife (as dagger)");
		Occupation scribe = new Occupation("Scribe","Parchment, 10 sheets","Dart");
		Occupation shaman= new Occupation("Shaman","Herbs, 1 lb.","Mace");
		Occupation slave = new Occupation("Slave","Strange-looking rock","Club");
		Occupation smuggler = new Occupation("Smuggler","Waterproof sack","Sling");
		Occupation soldier = new Occupation("Soldier","Shield","Spear");
		Occupation squire = new Occupation("Squire","Steel helmet","Longsword");
		Occupation taxCollector = new Occupation("Tax collector","100 cp","Longsword");
		Occupation trapper = new Occupation("Trapper","Badger pelt","Sling");
		Occupation urchin = new Occupation("Urchin","begging bowl","Stick (as club)");
		Occupation wainwright = new Occupation("Wainwright","Pushcart","Club");
		Occupation weaver = new Occupation("Weaver","Fine suit of clothes","Dagger");
		Occupation wizardsApprentice = new Occupation("Wizard's apprentice","Black grimoire","Dagger");
		Occupation woodcutter = new Occupation("Woodcutter", "Bundle of wood", "Handaxe");
		
		occupationList.add(alchemist);
		occupationList.add(animalTrainer);
		occupationList.add(armorer);
		occupationList.add(astrologer);
		occupationList.add(barber);
		occupationList.add(beadle);
		occupationList.add(beekeeper);
		occupationList.add(blacksmith);
		occupationList.add(butcher);
		occupationList.add(caravanGuard);
		occupationList.add(cheesemarker);
		occupationList.add(cobbler);
		occupationList.add(confidenceArtist);
		occupationList.add(cooper);
		occupationList.add(costermonger);
		occupationList.add(cutpurse);
		occupationList.add(ditchDigger);
		occupationList.add(dwarvenApthoecarist);
		occupationList.add(dwarvenBlacksmith);
		occupationList.add(dwarvenChestmaker);
		occupationList.add(dwarvenHerder);
		occupationList.add(dwarvenMiner);
		occupationList.add(dwarvenMushroomFarmer);
		occupationList.add(dwarvenRatCatcher);
		occupationList.add(dwarvenStonemason);
		occupationList.add(elvenArtisan);
		occupationList.add(elvenBarrister);
		occupationList.add(elvenChandler);
		occupationList.add(elvenFlaconer);
		occupationList.add(elvenForester);
		occupationList.add(elvenGlassblower);
		occupationList.add(elvenNavigator);
		occupationList.add(elvenSage);
		occupationList.add(farmer);
		occupationList.add(fortuneTeller);
		occupationList.add(gambler);
		occupationList.add(gongFarmer);
		occupationList.add(graveDigger);
		occupationList.add(guildBeggar);
		occupationList.add(halflingChickenButcher);
		occupationList.add(halflingDyer);
		occupationList.add(halflingGlovemaker);
		occupationList.add(halflingGypsy);
		occupationList.add(halflingHaberdasher);
		occupationList.add(halflingMariner);
		occupationList.add(halflingMoneylender);
		occupationList.add(halflingTrader);
		occupationList.add(halflingVagrant);
		occupationList.add(healer);
		occupationList.add(herbalist);
		occupationList.add(herder);
		occupationList.add(hunter);
		occupationList.add(indenturedServant);
		occupationList.add(jester);
		occupationList.add(jewler);
		occupationList.add(locksmith);
		occupationList.add(mendicant);
		occupationList.add(mercenary);
		occupationList.add(merchant);
		occupationList.add(millerBaker);
		occupationList.add(minstrel);
		occupationList.add(noble);
		occupationList.add(orphan);
		occupationList.add(ostler);
		occupationList.add(outlaw);
		occupationList.add(ropeMaker);
		occupationList.add(scribe);
		occupationList.add(shaman);
		occupationList.add(slave);
		occupationList.add(smuggler);
		occupationList.add(soldier);
		occupationList.add(squire);
		occupationList.add(taxCollector);
		occupationList.add(trapper);
		occupationList.add(urchin);
		occupationList.add(wainwright);
		occupationList.add(weaver);
		occupationList.add(wizardsApprentice);
		occupationList.add(woodcutter);
		
		
	}
	
	public static void populateOccupationsList(Occupation occupation)
	{
		occupationList.add(occupation);
	}
	

	// list of classes
	public static List<String> characterClasses = new ArrayList<String>(
			Arrays.asList("Cleric", "Thief", "Warrior", "Wizard", "Dwarf",
					"Elf", "Halfling"));

	// alignment list
	public static List<String> alignment = new ArrayList<String>(Arrays.asList(
			"Lawful", "Chaotic", "Neutral"));

	// public static List<String> trainedWeapons = new
	// ArrayList<String>(Arrays.asList(
	// "Staff",
	// "Club",
	// "Hammer (as club)",
	// "Dagger",
	// "Razor (as dagger)",
	// "Staff",
	// "Staff",
	// "Hammer (as club)",
	// "Cleaver (as axe)",
	// "Short sword",
	// "Cudgel (as staff)",
	// "Awl (as dagger)",
	// "Dagger",
	// "Crowbar (as club)",
	// "Knife (as dagger)",
	// "Dagger",
	// "Shovel (as staff)",
	// "Cudgel (as staff)",
	// "Hammer (as club)",
	// "Chisel (as dagger)",
	// "Staff",
	// "Pick (as club)",
	// "Shovel",
	// "Club",
	// "Hammer",
	// "Staff",
	// "Quill (as dart)",
	// "Scissors (as dagger)",
	// "Dagger",
	// "Staff",
	// "Hammer",
	// "Bow",
	// "Dagger",
	// "Pitchfork (as spear)",
	// "Dagger",
	// "Club",
	// "Trowel (as dagger)",
	// "Shovel (as staff)",
	// "Sling",
	// "Hand axe",
	// "Staff",
	// "Awl (as dagger)",
	// "Sling",
	// "Scissors (as dagger)",
	// "Knife (as dagger)",
	// "Short sword",
	// "Short sword",
	// "Club",
	// "Club",
	// "Club",
	// "Staff",
	// "Shortbow",
	// "Staff",
	// "Dart",
	// "Dagger",
	// "Dagger",
	// "Club",
	// "Longsword",
	// "Dagger",
	// "Club",
	// "Dagger",
	// "Longsword",
	// "Club",
	// "Staff",
	// "Short sword",
	// "Knife (as dagger)",
	// "Dart",
	// "Mace",
	// "Club",
	// "Sling",
	// "Spear",
	// "Longsword",
	// "Longsword",
	// "Sling",
	// "Stick (as club)",
	// "Club",
	// "Dagger",
	// "Dagger",
	// "Handaxe"
	// ));

	// public static List<String> tradeGoods = new
	// ArrayList<String>(Arrays.asList(
	// "Oil, 1 flask",
	// "Pony",
	// "Iron helmet",
	// "Spyglass",
	// "Scissors",
	// "Holy symbol",
	// "Jar of honey",
	// "Steel tongs",
	// "Side of beef",
	// "Linen, 1 yard",
	// "Stinky cheese",
	// "Shoehorn",
	// "Quality cloak",
	// "Barrel",
	// "Fruit",
	// "Small chest",
	// "Fine dirt, 1 lb.",
	// "Steel vial",
	// "Mithril, 1 oz.",
	// "Wood, 10 lbs.",
	// "Sow",
	// "Lantern",
	// "Sack",
	// "Net",
	// "Fine Stone 10 lbs.",
	// "Clay, 1 lb.",
	// "Book",
	// "Candles, 20",
	// "Falcon",
	// "Herbs, 1 lb.",
	// "Glass beads",
	// "Spyglass",
	// "Parchment and quill pen",
	// "Hen",
	// "Tarot deck",
	// "Dice",
	// "Sack of night soil",
	// "Trowel",
	// "Crutches",
	// "Chicken meat, 5 lbs.",
	// "Fabric, 3 yards",
	// "Gloves, 4 pairs",
	// "Hex doll",
	// "Fine suits, 3 sets",
	// "Sailcloth, 2 yards",
	// "5 gp, 10 sp , 200 cp",
	// "20 sp",
	// "Begging bowl",
	// "Holy water, 1 vial",
	// "Herbs, 1 lb.",
	// "Herding dog",
	// "Deer pelt",
	// "Locket",
	// "Silk clothes",
	// "Gem worth 20 gp",
	// "Fine tools",
	// "Cheese dip",
	// "Hide armor",
	// "4 gp, 15 sp, 27 cp",
	// "Flour, 1 lb.",
	// "Ukulele",
	// "Gold ring worth 10 gp",
	// "Rag doll",
	// "Bridle",
	// "Leather armor",
	// "Rope, 100/'",
	// "Parchment, 10 sheets",
	// "Herbs, 1 lb.",
	// "Strange-looking rock",
	// "Waterproof sack",
	// "Shield",
	// "Steel helmet",
	// "100 cp",
	// "Badger pelt",
	// "begging bowl",
	// "Pushcart",
	// "Fine suit of clothes",
	// "Black grimoire",
	// "Bundle of wood"
	// ));

	// list of lucky rolls
	public static List<String> luckyRoll = new ArrayList<String>(Arrays.asList(
			"Harsh Winter: All attack rolls", "The bull: Melee attack rolls",
			"Fortunate date: Missile fire attack rolls",
			"Raised by wolves: Unarmed attack rolls",
			"Conceived on horseback: Mounted attack rolls",
			"Born on the battlefield: Damage rolls",
			"Path of the bear: Melee damage rolls",
			"Hawkeye: Missle fire damage rolls",
			"Pack hunter: Attack and damage rolls for 0-level starting weapon",
			"Born under the loom: Skill checks (including thief skills)",
			"Fox's cunning: Find/disarm traps",
			"Four-leafed clover: Find secret doors",
			"Seventh son: Spell checks", "The raging storm: Spell damage",
			"Righteous heart: Turn unholy checks",
			"Survived the plague: Magical healing",
			"Lucky sign: Saving throws",
			"Guardian angel: Saving throws to escape traps",
			"Survived a spider bite: Savings throws against poison",
			"Struck by lightning: Reflex saving throws",
			"Lived through famine: Fortitude saving throws",
			"Resisted temptation: Willpower saving throws",
			"Charmed house: Armor Class", "Speed of the cobra: Initiative",
			"Bountiful harvest: Hit points (appies at each level)",
			"Warrior's arm: Critical hit tables",
			"Unholy house: Corruption rolls", "The Broken Star: Fumbles",
			"Birdsong: Number of languages",
			"Wild child: Speed (each +1/-1 = +5'/-5' speed)"));

	// ability modifiers
	@SuppressWarnings("serial")
	public static Map<Integer, Integer> abilityModifiers = new HashMap<Integer, Integer>() {
		{
			put(3, -3);
			put(4, -2);
			put(5, -2);
			put(6, -1);
			put(7, -1);
			put(8, -1);
			put(9, 0);
			put(10, 0);
			put(11, 0);
			put(12, 0);
			put(13, 1);
			put(14, 1);
			put(15, 1);
			put(16, 2);
			put(17, 2);
			put(18, 3);
		}
	};

	// base speed per class
	@SuppressWarnings("serial")
	public static Map<String, Integer> characterSpeed = new HashMap<String, Integer>() {
		{
			put("Cleric", 30);
			put("Thief", 30);
			put("Warrior", 30);
			put("Wizard", 30);
			put("Dwarf", 20);
			put("Elf", 30);
			put("Halfling", 20);
		}
	};

	// List of starting goods per occupation. eventual rewrite as enum
	@SuppressWarnings("serial")
	public static Map<String, String> tradeGoods = new HashMap<String, String>() {
		{
			put("Alchemist", "Oil, 1 flask");
			put("Animal Trainer", "Pony");
			put("Armorer", "Iron helmet");
			put("Astrologer", "Spyglass");
			put("Barber", "Scissors");
			put("Beadle", "Holy symbol");
			put("Beekeeper", "Jar of honey");
			put("Blacksmith", "Steel tongs");
			put("Butcher", "Side of beef");
			put("Caravan Guard", "Linen, 1 yard");
			put("Cheesemaker", "Stinky cheese");
			put("Cobbler", "Shoehorn");
			put("Confidence artist", "Quality cloak");
			put("Cooper", "Barrel");
			put("Costermonger", "Fruit");
			put("Cutpurse", "Small chest");
			put("Ditch Digger", "Fine dirt, 1 lb.");
			put("Dwarven apothecarist", "Steel vial");
			put("Dwarven blacksmith", "Mithril, 1 oz.");
			put("Dwarven chest-maker", "Wood, 10 lbs.");
			put("Dwarven herder", "Sow");
			put("Dwarven miner", "Lantern");
			put("Dwarven mushroom-farmer", "Sack");
			put("Dwarven Rat-catcher", "Net");
			put("Dwarven Stonemason", "Fine Stone 10 lbs.");
			put("Elven artisan", "Clay, 1 lb.");
			put("Elven barrister", "Book");
			put("Elven chandler", "Candles, 20");
			put("Elven falconer", "Falcon");
			put("Elven forester", "Herbs, 1 lb.");
			put("Elven glassblower", "Glass beads");
			put("Elven navigator", "Spyglass");
			put("Elven sage", "Parchment and quill pen");
			put("Farmer", "Hen");
			put("Fortune-teller", "Tarot deck");
			put("Gambler", "Dice");
			put("Gongfarmer", "Sack of night soil");
			put("Grave digger", "Trowel");
			put("Guild beggar", "Crutches");
			put("Halfling chicken butcher", "Chicken meat, 5 lbs.");
			put("Halfling dyer", "Fabric, 3 yards");
			put("Halfling glovemaker", "Gloves, 4 pairs");
			put("Halfling gypsy", "Hex doll");
			put("Halfling haberdasher", "Fine suits, 3 sets");
			put("Halfling mariner", "Sailcloth, 2 yards");
			put("Halfling moneylender", "5 gp, 10 sp , 200 cp");
			put("Halfling trader", "20 sp");
			put("Halfling vagrant", "Begging bowl");
			put("Healer", "Holy water, 1 vial");
			put("Herbalist", "Herbs, 1 lb.");
			put("Herder", "Herding dog");
			put("Hunter", "Deer pelt");
			put("Indentured servant", "Locket");
			put("Jester", "Silk clothes");
			put("Jewler", "Gem worth 20 gp");
			put("Locksmith", "Fine tools");
			put("Mendicant", "Cheese dip");
			put("Mercenary", "Hide armor");
			put("Merchant", "4 gp, 15 sp, 27 cp");
			put("Miller/baker", "Flour, 1 lb.");
			put("Minstrel", "Ukulele");
			put("Noble", "Gold ring worth 10 gp");
			put("Orphan", "Rag doll");
			put("Ostler", "Bridle");
			put("Outlaw", "Leather armor");
			put("Rope maker", "Rope, 100\'");
			put("Scribe", "Parchment, 10 sheets");
			put("Shaman", "Herbs, 1 lb.");
			put("Slave", "Strange-looking rock");
			put("Smuggler", "Waterproof sack");
			put("Soldier", "Shield");
			put("Squire", "Steel helmet");
			put("Tax collector", "100 cp");
			put("Trapper", "Badger pelt");
			put("Urchin", "begging bowl");
			put("Wainwright", "Pushcart");
			put("Weaver", "Fine suit of clothes");
			put("Wizard's apprentice", "Black grimoire");
			put("Woodcutter", "Bundle of wood");

		}
	};

	// List of starting weapons per occupation. eventual rewrite as enum
	@SuppressWarnings("serial")
	public static Map<String, String> trainedWeapons = new HashMap<String, String>() {
		{
			put("Alchemist", "Staff");
			put("Animal Trainer", "Club");
			put("Armorer", "Hammer (as club)");
			put("Astrologer", "Dagger");
			put("Barber", "Razor (as dagger)");
			put("Beadle", "Staff");
			put("Beekeeper", "Staff");
			put("Blacksmith", "Hammer (as club)");
			put("Butcher", "Cleaver (as axe)");
			put("Caravan Guard", "Short sword");
			put("Cheesemaker", "Cudgel (as staff)");
			put("Cobbler", "Awl (as dagger)");
			put("Confidence artist", "Dagger");
			put("Cooper", "Crowbar (as club)");
			put("Costermonger", "Knife (as dagger)");
			put("Cutpurse", "Dagger");
			put("Ditch Digger", "Shovel (as staff)");
			put("Dwarven apothecarist", "Cudgel (as staff)");
			put("Dwarven blacksmith", "Hammer (as club)");
			put("Dwarven chest-maker", "Chisel (as dagger)");
			put("Dwarven herder", "Staff");
			put("Dwarven miner", "Pick (as club)");
			put("Dwarven mushroom-farmer", "Shovel");
			put("Dwarven Rat-catcher", "Club");
			put("Dwarven Stonemason", "Hammer");
			put("Elven artisan", "Staff");
			put("Elven barrister", "Quill (as dart)");
			put("Elven chandler", "Scissors (as dagger)");
			put("Elven falconer", "Dagger");
			put("Elven forester", "Staff");
			put("Elven glassblower", "Hammer");
			put("Elven navigator", "Bow");
			put("Elven sage", "Dagger");
			put("Farmer", "Pitchfork (as spear)");
			put("Fortune-teller", "Dagger");
			put("Gambler", "Club");
			put("Gongfarmer", "Trowel (as dagger)");
			put("Grave digger", "Shovel (as staff)");
			put("Guild beggar", "Sling");
			put("Halfling chicken butcher", "Hand axe");
			put("Halfling dyer", "Staff");
			put("Halfling glovemaker", "Awl (as dagger)");
			put("Halfling gypsy", "Sling");
			put("Halfling haberdasher", "Scissors (as dagger)");
			put("Halfling mariner", "Knife (as dagger)");
			put("Halfling moneylender", "Short sword");
			put("Halfling trader", "Short sword");
			put("Halfling vagrant", "Club");
			put("Healer", "Club");
			put("Herbalist", "Club");
			put("Herder", "Staff");
			put("Hunter", "Shortbow");
			put("Indentured servant", "Staff");
			put("Jester", "Dart");
			put("Jewler", "Dagger");
			put("Locksmith", "Dagger");
			put("Mendicant", "Club");
			put("Mercenary", "Longsword");
			put("Merchant", "Dagger");
			put("Miller/baker", "Club");
			put("Minstrel", "Dagger");
			put("Noble", "Longsword");
			put("Orphan", "Club");
			put("Ostler", "Staff");
			put("Outlaw", "Short sword");
			put("Rope maker", "Knife (as dagger)");
			put("Scribe", "Dart");
			put("Shaman", "Mace");
			put("Slave", "Club");
			put("Smuggler", "Sling");
			put("Soldier", "Spear");
			put("Squire", "Longsword");
			put("Tax collector", "Longsword");
			put("Trapper", "Sling");
			put("Urchin", "Stick (as club)");
			put("Wainwright", "Club");
			put("Weaver", "Dagger");
			put("Wizard's apprentice", "Dagger");
			put("Woodcutter", "Handaxe");

		}
	};
	
	
	//Weapons. Pre-populating now. Flat-file fed later.
	public static List<Weapon> weaponList = new ArrayList<Weapon>();
	
	public static void populateWeaponList()
	{
		
		 Weapon battleaxe = new Weapon("Battleaxe", "1d10", "-", 700);
		 Weapon blackjack = new Weapon("BlackJack", "1d3/2d6", "-", 300);
		 Weapon blowgun = new Weapon("Blowgun", "1d3/1d5", "20/40/60", 600);
		 Weapon club = new Weapon("Club", "1d4", "-", 300);
		 Weapon crossbow = new Weapon("Crossbow", "1d6", "80/160/240", 3000);
		 Weapon dagger = new Weapon("Dagger", "1d4/1d10", "10/20/30", 300);
		 Weapon dart = new Weapon("Dart", "1d4", "20/40/60", 50);
		 Weapon flail = new Weapon("Flail", "1d6", "-", 600);
		 Weapon garrote = new Weapon("Garrote", "1/3d4", "-", 200);
		 Weapon handaxe = new Weapon("Handaxe", "1d6", "10/20/30", 400);
		 Weapon javelin = new Weapon("Javelin", "1d6", "30/60/90", 100);
		 Weapon lance = new Weapon("Lance", "1d12", "-", 2500);
		 Weapon longbow = new Weapon("Longbow", "1d6", "70/140/210", 4000);
		 Weapon longsword = new Weapon("Longsword", "1d8", "-", 1000);
		 Weapon mace = new Weapon("Mace", "1d6", "-", 500);
		 Weapon polearm = new Weapon("Polearm", "1d10", "-", 700);
		 Weapon shortbow = new Weapon("Shortbow", "1d6", "50/100/150", 2500);
		 Weapon shortSword = new Weapon("Short sword", "1d6", "-", 700);
		 Weapon sling = new Weapon("Sling", "1d4", "40/80/160", 200);
		 Weapon spear = new Weapon("Spear", "1d8", "-", 300);
		 Weapon staff = new Weapon("Staff", "1d4", "-", 50);
		 Weapon twoHandedSword = new Weapon("Two-handed sword", "1d10", "-", 1500);
		 Weapon warhammer = new Weapon("Warhammer", "1d8", "-", 500);
		 
		 weaponList.add(battleaxe);
		 weaponList.add(blackjack);
		 weaponList.add(blowgun);
		 weaponList.add(club);
		 weaponList.add(crossbow);
		 weaponList.add(dagger);
		 weaponList.add(dart);
		 weaponList.add(flail);
		 weaponList.add(garrote);
		 weaponList.add(handaxe);
		 weaponList.add(javelin);
		 weaponList.add(lance);
		 weaponList.add(longbow);
		 weaponList.add(longsword);
		 weaponList.add(mace);
		 weaponList.add(polearm);
		 weaponList.add(shortSword);
		 weaponList.add(shortbow);
		 weaponList.add(sling);
		 weaponList.add(spear);
		 weaponList.add(staff);
		 weaponList.add(twoHandedSword);
		 weaponList.add(warhammer);
	}
	
	public static void populateWeaponList(Weapon weapon)
	{
		weaponList.add(weapon);
	}
	
	
	
	//Equipment. Pre-populating now. Flat-file fed later.
		public static List<Equipment> equipmentList = new ArrayList<Equipment>();
	
		public static void populateEquipmentList()
			{
			Equipment backpack = new Equipment("Backpack", 200);
			Equipment candle =  new Equipment("Candle", 1);
			Equipment chain = new Equipment("Chain, 10'", 3000);
			Equipment chalk =  new Equipment("Chalk, 1 piece", 1);
			Equipment chest =  new Equipment("Chest, empty", 200);
			Equipment crowbar =  new Equipment("Crowbar", 200);
			Equipment flask =  new Equipment("Flask,empty", 3);
			Equipment flintAndSteel =  new Equipment("Flint & steel", 15);
			Equipment grapplingHook =  new Equipment("Grappling hook", 100);
			Equipment smallHammer =  new Equipment("Hammer, small", 50);
			Equipment holySymbol = new Equipment("Holy symbol", 2500);
			Equipment holyWater =  new Equipment("Holy water, 1 vial", 2500);
			Equipment ironSpike =  new Equipment("Iron spike", 10);
			Equipment lantern =  new Equipment("Lantern", 1000);
			Equipment mirror =  new Equipment("Mirror, hand-sized", 1000);
			Equipment oilFlak =  new Equipment("Oil, 1 flask", 20);
			Equipment tenFootPole =  new Equipment("Pole, 10-foot", 15);
			Equipment rations =  new Equipment("Rations, per day", 5);
			Equipment rope =  new Equipment("Rope, 50'", 25);
			Equipment largeSack =  new Equipment("Sack, large", 12);
			Equipment smallSack =  new Equipment("Sack, small", 8);
			Equipment thievesTools = new Equipment("Thieves' tools", 2500);
			Equipment torch =  new Equipment("Torch", 1);
			Equipment waterskin =  new Equipment("Waterskin", 50);
			
			equipmentList.add(backpack);
			equipmentList.add(candle);
			equipmentList.add(chain);
			equipmentList.add(chalk);
			equipmentList.add(chest);
			equipmentList.add(crowbar);
			equipmentList.add(flask);
			equipmentList.add(flintAndSteel);
			equipmentList.add(grapplingHook);
			equipmentList.add(smallHammer);
			equipmentList.add(holySymbol);
			equipmentList.add(holyWater);
			equipmentList.add(ironSpike);
			equipmentList.add(lantern);
			equipmentList.add(mirror);
			equipmentList.add(oilFlak);
			equipmentList.add(tenFootPole);
			equipmentList.add(rations);
			equipmentList.add(rope);
			equipmentList.add(largeSack);
			equipmentList.add(smallSack);
			equipmentList.add(thievesTools);
			equipmentList.add(torch);
			equipmentList.add(waterskin);
			
			}
		
		public static void populateEquipmentList(Equipment equipment)
		{
			equipmentList.add(equipment);
		}
		
		//Armor. Pre-populating now. Flat-file fed later.
		public static List<Armor> armorList = new ArrayList<Armor>();
		
		public static void populateArmorList()
		{
			Armor unarmored = new Armor("Unarmored", 0, 0, 0, "d4", 0);
			Armor padded =  new Armor("Padded", 1, 0, 0, "d8", 500);
			Armor leather = new Armor("Leather", 2, -1, 0, "d8", 2000);
			Armor studdedLeather = new Armor("Studded Leather", 3, -2, 0, "d8", 4500);
			Armor hide = new Armor("Hide", 3, -3, 0, "d12", 3000);
			Armor scaleMail =  new Armor("Scale mail", 4, -4, -5, "d12", 8000);
			Armor chainMail =  new Armor("Chainmail", 5, -5, -5, "d12", 15000);
			Armor bandedMail =  new Armor("Banded mail", 6, -6, -5, "d16", 25000);
			Armor halfPlate =  new Armor("Half-plate", 7, -7, -10, "d16", 55000);
			Armor fullPlate = new Armor("Full Plate", 8, -8, -10, "d16", 120000);
			Armor shield =  new Armor("Shield", 1, -1, 0, "", 1000);
			
			armorList.add(unarmored);
			armorList.add(padded);
			armorList.add(leather);
			armorList.add(studdedLeather);
			armorList.add(hide);
			armorList.add(scaleMail);
			armorList.add(chainMail);
			armorList.add(bandedMail);
			armorList.add(halfPlate);
			armorList.add(fullPlate);
			armorList.add(shield);
			
			
		}
		
		public static void populateArmorList(Armor armor)
		{
			armorList.add(armor);
		}
		
		
	//Ammunition. Pre-populating now. Flat-file fed later.
	public static List<Ammunition> ammunitionList = new ArrayList<Ammunition>();
	
	
	public static void populateAmmunitionList()
	{
			Ammunition arrows = new Ammunition("Arrows", 20, 50);
			Ammunition silverTippedArrows = new Ammunition("Arrow, silver-tipped", 1, 50);
			Ammunition quarrels = new Ammunition("Quarrels", 30, 100);
			Ammunition slingStones = new Ammunition("Sling stones", 30, 1);
			
			ammunitionList.add(arrows);
			ammunitionList.add(silverTippedArrows);
			ammunitionList.add(quarrels);
			ammunitionList.add(slingStones);
			
	}
	
	public static void populateAmmunitionList(Ammunition ammunition)
	{
		ammunitionList.add(ammunition);
	}
			
	// makes random numbers
	public static int randNumber(int min, int max) {

		int randomNum = Random.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	// max spell casting level based off ability modifier
	@SuppressWarnings("serial")
	public static Map<Integer, Integer> maxSpells = new HashMap<Integer, Integer>() {
		{
			put(3, 0);
			put(4, 1);
			put(5, 1);
			put(6, 1);
			put(7, 1);
			put(8, 2);
			put(9, 2);
			put(10, 3);
			put(11, 3);
			put(12, 4);
			put(13, 4);
			put(14, 4);
			put(15, 5);
			put(16, 5);
			put(17, 5);
			put(18, 6);
		}
	};
	
	
	

	// Calculate newly created character money
	public static int generateGold(int charLevel, String charClass) {
		int gold = 0;
		if (charClass.equals("Warrior")) {
			switch (charLevel) {
			case 1:
				gold = randNumber(5, 60);
				break;
			case 2:
				gold = randNumber(5, 60) + 500;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				gold = randNumber(5, 60) + 1500;
				break;
			}
		} else if (charClass.equals("Wizard")) {
			switch (charLevel) {
			case 1:
				gold = randNumber(3, 30);
				break;
			case 2:
				gold = randNumber(3, 30) + (randNumber(2, 8) * 100);
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				gold = randNumber(3, 30) + (randNumber(5, 20) * 100);
				break;
			}
		} else if (charClass.equals("Cleric")) {
			switch (charLevel) {
			case 1:
				gold = randNumber(4, 80);
				break;
			case 2:
				gold = randNumber(4, 80) + 400;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				gold = randNumber(4, 80) + 1300;
				break;
			}
		} else if (charClass.equals("Thief")) {
			switch (charLevel) {
			case 1:
				gold = randNumber(3, 30);
				break;
			case 2:
				gold = randNumber(3, 30) + (randNumber(1, 6) * 100);
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				gold = randNumber(3, 30) + (randNumber(3, 18) * 100);
				break;
			}
		} else if (charClass.equals("Elf")) {
			switch (charLevel) {
			case 1:
				gold = randNumber(2, 24);
				break;
			case 2:
				gold = randNumber(3, 36) + 500;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				gold = randNumber(3, 36) + 2000;
				break;
			}
		} else if (charClass.equals("Halfling")) {
			switch (charLevel) {
			case 1:
				gold = randNumber(2, 60);
				break;
			case 2:
				gold = randNumber(3, 60) + 250;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				gold = randNumber(3, 60) + 1500;
				break;
			}
		} else if (charClass.equals("Dwarf")) {
			switch (charLevel) {
			case 1:
				gold = randNumber(5, 60);
				break;
			case 2:
				gold = randNumber(5, 60) + 700;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				gold = randNumber(5, 60) + 2000;
				break;
			}
		}
		
		int copper = gold*100;
		return copper;
	}
}
