/**
 * 
 */
package com.horsegoeswest.dcc.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.horsegoeswest.dcc.client.CharacterGenerator;
import com.horsegoeswest.dcc.client.characters.CharacterClass;
import com.horsegoeswest.dcc.client.characters.Cleric;
import com.horsegoeswest.dcc.client.characters.Dwarf;
import com.horsegoeswest.dcc.client.characters.Elf;
import com.horsegoeswest.dcc.client.characters.Halfling;
import com.horsegoeswest.dcc.client.characters.Thief;
import com.horsegoeswest.dcc.client.characters.Warrior;
import com.horsegoeswest.dcc.client.characters.Wizard;
import com.horsegoeswest.dcc.client.events.SetArmorClassFieldEvent;
import com.horsegoeswest.dcc.client.events.SetArmorClassFieldEventHandler;
import com.horsegoeswest.dcc.client.events.SetMeleeDamageFieldEvent;
import com.horsegoeswest.dcc.client.events.SetMeleeDamageFieldEventHandler;
import com.horsegoeswest.dcc.client.events.SetMissileDamageFieldEvent;
import com.horsegoeswest.dcc.client.events.SetMissileDamageFieldEventHandler;

/**
 * @author Horse
 * 
 */
public class StandardStats extends Composite {

	private static StandardStatsUiBinder uiBinder = GWT
			.create(StandardStatsUiBinder.class);

	interface StandardStatsUiBinder extends UiBinder<Widget, StandardStats> {
	}

	/**
	 * Because this class has a default constructor, it can be used as a binder
	 * template. In other words, it can be used in other *.ui.xml files as
	 * follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 * xmlns:g="urn:import:**user's package**">
	 * <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement
	 * HasHTML instead of HasText.
	 */
	public StandardStats(CharacterClass character) {
		initWidget(uiBinder.createAndBindUi(this));
		setStandardStats(character);
	}

	@UiField
	TextBox nameBox;
	@UiField
	TextBox occupationBox;
	@UiField
	TextBox classBox;
	@UiField
	TextBox titleBox;
	@UiField
	TextBox alignmentBox;
	@UiField
	TextBox speedBox;
	@UiField
	TextBox levelBox;
	@UiField
	TextBox xpBox;
	@UiField
	TextBox armorClassBox;
	@UiField
	TextBox hitPointBox;
	@UiField
	TextBox initiativeBox;
	@UiField
	TextBox actionDieBox;
	@UiField
	TextBox attackBox;
	@UiField
	TextBox critDieBox;
	@UiField
	TextBox critTableBox;
//	@UiField
//	TextBox strengthBox;
//	@UiField
//	TextBox agilityBox;
//	@UiField
//	TextBox staminaBox;
//	@UiField
//	TextBox personalityBox;
//	@UiField
//	TextBox luckBox;
//	@UiField
//	TextBox intelligenceBox;
	@UiField
	TextBox refSaveBox;
	@UiField
	TextBox fortSaveBox;
	@UiField
	TextBox willSaveBox;
	@UiField
	TextArea luckyRollBox;
	@UiField
	TextBox meleeAttackBox;
	@UiField
	TextBox meleeDamageBox;
	@UiField
	TextBox missileAttackBox;
	@UiField
	TextBox missileDamageBox;
	@UiField
	TextBox languagesBox;

	
	@UiField
	TextArea treasureBox;
	
	@UiField
	VerticalPanel classPanel;
	
	@UiField 
	HorizontalPanel weaponPanel;
	
	@UiField 
	HorizontalPanel equipmentPanel;
	
	@UiField 
	HorizontalPanel armorPanel;
	
	@UiField
	VerticalPanel abilityPanel;

	public void setStandardStats(CharacterClass character) {
		nameBox.setText(character.getName());
		occupationBox.setText(character.getOccupation().getName());
		classBox.setText(character.getCharClass());
		titleBox.setText(character.getTitle());
		alignmentBox.setText(character.getAlignment());
		speedBox.setText(Integer.toString(character.getSpeed()));
		speedBox.setVisibleLength(2);
		levelBox.setText(Integer.toString(character.getLevel()));
		levelBox.setVisibleLength(2);
		xpBox.setText(Integer.toString(character.getXp()));
		xpBox.setVisibleLength(2);

		armorClassBox.setText(Integer.toString(character.getArmorClass()));
		armorClassBox.setVisibleLength(2);
		hitPointBox.setText(Integer.toString(character.getHitPoints()));
		hitPointBox.setVisibleLength(2);
		initiativeBox.setText(character.getInitiative());
		actionDieBox.setText(character.getActionDice());
		attackBox.setText(character.getAttack());
		critDieBox.setText(character.getCritDie());
		critTableBox.setText(character.getCritTable());

//		strengthBox.setText(Integer.toString(character.getAbilityScores()
//				.getStrength()));
//		strengthBox.setMaxLength(2);
//		agilityBox.setText(Integer.toString(character.getAbilityScores()
//				.getAgility()));
//		agilityBox.setVisibleLength(2);
//		staminaBox.setText(Integer.toString(character.getAbilityScores()
//				.getStamina()));
//		staminaBox.setVisibleLength(2);
//		personalityBox.setText(Integer.toString(character.getAbilityScores()
//				.getPersonality()));
//		personalityBox.setVisibleLength(2);
//		luckBox.setText(Integer
//				.toString(character.getAbilityScores().getLuck()));
//		luckBox.setVisibleLength(2);
//		intelligenceBox.setText(Integer.toString(character.getAbilityScores()
//				.getIntelligence()));
//		intelligenceBox.setVisibleLength(2);

		refSaveBox.setText(Integer.toString(character.getRefSave()));
		refSaveBox.setVisibleLength(2);
		fortSaveBox.setText(Integer.toString(character.getFortSave()));
		fortSaveBox.setVisibleLength(2);
		willSaveBox.setText(Integer.toString(character.getWillSave()));
		willSaveBox.setVisibleLength(2);

		luckyRollBox.setText(character.getLuckyRoll());

		meleeAttackBox.setText(character.getMeleeAttack());

		missileAttackBox.setText(character.getMissileAttack());

		treasureBox.setText(character.getWallet().toString());

		setClassPanel(character);
		
		setWeaponPanel(character);
		setEquipmentPanel(character);
		setArmorPanel(character);
		setAbilityPanel(character);
		
		CharacterGenerator.eventBus.addHandler(SetMeleeDamageFieldEvent.TYPE, new SetMeleeDamageFieldEventHandler() {

			@Override
			public void setMeleeWeaponDamageField(SetMeleeDamageFieldEvent event) {
				meleeDamageBox.setText(event.getMeleeDamageField());
			}
		});
		
		CharacterGenerator.eventBus.addHandler(SetMissileDamageFieldEvent.TYPE, new SetMissileDamageFieldEventHandler() {

			@Override
			public void setMissileWeaponDamageField(SetMissileDamageFieldEvent event) {
				missileDamageBox.setText(event.getDamage());
			}
		});
		
		CharacterGenerator.eventBus.addHandler(SetArmorClassFieldEvent.TYPE, new SetArmorClassFieldEventHandler() {

			@Override
			public void setArmorClassField(SetArmorClassFieldEvent event) {
				armorClassBox.setText(event.getArmorClass());
			}
		});
	}

	public void setClassPanel(CharacterClass characterClass) {

		if (characterClass instanceof Cleric) {
			ClericPanel clericPanel = new ClericPanel(
					((Cleric) characterClass).getDeity(),
					((Cleric) characterClass).getSpellCheck());
			classPanel.add(clericPanel);

		} else if (characterClass instanceof Dwarf) {
			DwarfPanel dwarfPanel = new DwarfPanel(
					((Dwarf) characterClass).getLuckyWeapon());
			classPanel.add(dwarfPanel);

		} else if (characterClass instanceof Elf) {
			ElfPanel elfPanel = new ElfPanel(
					((Elf) characterClass).getSpellCheck(),
					((Elf) characterClass).getFamiliar(),
					((Elf) characterClass).getPatron(),
					((Elf) characterClass).getCorruption());
			classPanel.add(elfPanel);
		} else if (characterClass instanceof Halfling) {
			HalflingPanel halflingPanel = new HalflingPanel(
					Integer.toString(((Halfling) characterClass)
							.getSneakSilently()),
					Integer.toString(((Halfling) characterClass)
							.getHideInShadows()));
			classPanel.add(halflingPanel);

		} else if (characterClass instanceof Thief) {
			ThiefPanel thiefPanel = new ThiefPanel(
					((Thief) characterClass).getLuckDie(),
					Integer.toString(((Thief) characterClass).getDisableTrap()),
					Integer.toString(((Thief) characterClass).getBackstab()),
					Integer.toString(((Thief) characterClass)
							.getForgeDocument()),
					Integer.toString(((Thief) characterClass)
							.getSneakSilently()),
					Integer.toString(((Thief) characterClass).getDisguiseSelf()),
					Integer.toString(((Thief) characterClass)
							.getHideInShadows()),
					Integer.toString(((Thief) characterClass)
							.getReadLanguages()),
					Integer.toString(((Thief) characterClass).getPickPocket()),
					Integer.toString(((Thief) characterClass).getHandlePoison()),
					Integer.toString(((Thief) characterClass)
							.getClimbSheerSurfaces()), Integer
							.toString(((Thief) characterClass)
									.getCastSpellFromScroll()), Integer
							.toString(((Thief) characterClass).getPickLock()),
					Integer.toString(((Thief) characterClass).getFindTrap()));
			classPanel.add(thiefPanel);
		} else if (characterClass instanceof Warrior) {
			WarriorPanel warriorPanel = new WarriorPanel(
					((Warrior) characterClass).getThreatRange(),
					((Warrior) characterClass).getLuckyWeapon());
			classPanel.add(warriorPanel);
		} else if (characterClass instanceof Wizard) {
			WizardPanel wizardPanel = new WizardPanel(
					((Wizard) characterClass).getSpellCheck(),
					((Wizard) characterClass).getFamiliar(),
					((Wizard) characterClass).getPatron(),
					((Wizard) characterClass).getCorruption());
			classPanel.add(wizardPanel);
		}

	}
	
	public void setWeaponPanel(CharacterClass character)
	{
		WeaponPanel weaponTable = new WeaponPanel(character);
		weaponPanel.add(weaponTable);
	}
	
	public void setEquipmentPanel(CharacterClass character)
	{
		EquipmentPanel equipmentTable = new EquipmentPanel(character);
		equipmentPanel.add(equipmentTable);
	}
	
	public void setArmorPanel(CharacterClass character)
	{
		ArmorPanel armorTable = new ArmorPanel(character);
		armorPanel.add(armorTable);
	}
	
	public void setAbilityPanel(CharacterClass character)
	{
		AbilitiesPanel abilitiesPanel = new AbilitiesPanel(character);
		abilityPanel.add(abilitiesPanel);
	}
	
	
	

}
