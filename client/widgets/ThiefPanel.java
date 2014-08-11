package com.horsegoeswest.dcc.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ThiefPanel extends Composite {

	private static ThiefPanelUiBinder uiBinder = GWT
			.create(ThiefPanelUiBinder.class);

	interface ThiefPanelUiBinder extends UiBinder<Widget, ThiefPanel> {
	}

	public ThiefPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox luckDieBox;
	@UiField
	TextBox disableTrapBox;
	@UiField
	TextBox backStabBox;
	@UiField
	TextBox forgeDocumentBox;
	@UiField
	TextBox sneakSilentlyBox;
	@UiField
	TextBox disguiseSelfBox;
	@UiField
	TextBox hideInShadowsBox;
	@UiField
	TextBox readLanguagesBox;
	@UiField
	TextBox pickPocketBox;
	@UiField
	TextBox handlePoisonBox;
	@UiField
	TextBox climbSheerSurfacesBox;
	@UiField
	TextBox castSpellFromScrollBox;
	@UiField
	TextBox pickLockBox;
	@UiField
	TextBox findTrapBox;

	public ThiefPanel(String luckDie, String disabletrap, String backStab,
			String forgeDocument, String sneakSilently, String disguiseSelf,
			String hideInShadows, String readLanguages, String pickPocket,
			String handlePoison, String climbSheerSurfaces,
			String castSpellFromScroll, String pickLock, String findTrap) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		luckDieBox.setText(luckDie);
		disableTrapBox.setText(disabletrap);
		backStabBox.setText(backStab);
		forgeDocumentBox.setText(forgeDocument);
		sneakSilentlyBox.setText(sneakSilently);
		disguiseSelfBox.setText(disguiseSelf);
		hideInShadowsBox.setText(hideInShadows);
		readLanguagesBox.setText(readLanguages);
		pickPocketBox.setText(pickPocket);
		handlePoisonBox.setText(handlePoison);
		climbSheerSurfacesBox.setText(climbSheerSurfaces);
		castSpellFromScrollBox.setText(castSpellFromScroll);
		pickLockBox.setText(pickLock);
		findTrapBox.setText(findTrap);

	}

}
