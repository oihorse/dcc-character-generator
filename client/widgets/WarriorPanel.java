/**
 * 
 */
package com.horsegoeswest.dcc.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Horse
 * 
 */
public class WarriorPanel extends Composite {

	private static WarriorPanelUiBinder uiBinder = GWT
			.create(WarriorPanelUiBinder.class);

	interface WarriorPanelUiBinder extends UiBinder<Widget, WarriorPanel> {
	}

	@UiField
	TextBox threatRangeBox;
	@UiField
	TextBox luckyWeaponBox;

	public WarriorPanel(String threatRange, String luckyWeapon) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		threatRangeBox.setText(threatRange);
		luckyWeaponBox.setText(luckyWeapon);
	}

}
