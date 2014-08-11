package com.horsegoeswest.dcc.client.widgets;

import com.sencha.gxt.cell.core.client.*;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.horsegoeswest.dcc.client.characters.CharacterClass;
import com.horsegoeswest.dcc.client.resources.DCCTables;

public class AbilitiesPanel extends Composite {

	private static AbilitiesPanelUiBinder uiBinder = GWT
			.create(AbilitiesPanelUiBinder.class);

	interface AbilitiesPanelUiBinder extends UiBinder<Widget, AbilitiesPanel> {
	}

	public AbilitiesPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

//	@UiField
//	VerticalPanel abilitiesPanel;
	@UiField
	TextBox strengthModifier;
	@UiField
	TextBox strengthScore;
//	@UiField
//	TextBox agilityModifier;
//	@UiField
//	TextBox agilityScore;
//	@UiField
//	HorizontalPanel modifierBox;
//	
	public AbilitiesPanel(CharacterClass character) {
		initWidget(uiBinder.createAndBindUi(this));
		
		//modifierBox.setStylePrimaryName("modifierBoxPrimary");
		
		strengthModifier.setText(Integer.toString(DCCTables.abilityModifiers.get(character.getAbilityScores()
				.getStrength())));
		strengthModifier.setMaxLength(2);
		strengthModifier.setVisibleLength(2);
		strengthScore.setText(Integer.toString(character.getAbilityScores()
				.getStrength()));
		strengthScore.setMaxLength(2);
		strengthScore.setVisibleLength(2);
		
//		agilityModifier.setText(Integer.toString(DCCTables.abilityModifiers.get(character.getAbilityScores()
//				.getAgility())));
//		agilityModifier.setMaxLength(2);
//		agilityModifier.setVisibleLength(2);
//		agilityScore.setText(Integer.toString(character.getAbilityScores()
//				.getAgility()));
//		agilityScore.setMaxLength(2);
//		agilityScore.setVisibleLength(2);
//		
	}

	
}
