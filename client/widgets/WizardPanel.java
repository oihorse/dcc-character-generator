package com.horsegoeswest.dcc.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class WizardPanel extends Composite {

	private static WizardPanelUiBinder uiBinder = GWT
			.create(WizardPanelUiBinder.class);

	interface WizardPanelUiBinder extends UiBinder<Widget, WizardPanel> {
	}

	public WizardPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox baseSpellCheckBox;
	@UiField
	TextBox familiarBox;
	@UiField
	TextBox patronBox;
	@UiField
	TextBox corruptionBox;
	@UiField
	TextArea notesBox;
	@UiField
	TextArea spellBox;

	public WizardPanel(String baseSpellCheck, String familiar, String patron,
			String corruption) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		baseSpellCheckBox.setText(baseSpellCheck);
		familiarBox.setText(familiar);
		patronBox.setText(patron);
		corruptionBox.setText(corruption);
	}

}
