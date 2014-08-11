/**
 * 
 */
package com.horsegoeswest.dcc.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Horse
 * 
 */
public class ElfPanel extends Composite {

	private static ElfPanelUiBinder uiBinder = GWT
			.create(ElfPanelUiBinder.class);

	interface ElfPanelUiBinder extends UiBinder<Widget, ElfPanel> {
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
	public ElfPanel() {
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

	public ElfPanel(String baseSpellCheck, String familiar, String patron,
			String corruption) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		baseSpellCheckBox.setText(baseSpellCheck);
		familiarBox.setText(familiar);
		patronBox.setText(patron);
		corruptionBox.setText(corruption);
	}

}
