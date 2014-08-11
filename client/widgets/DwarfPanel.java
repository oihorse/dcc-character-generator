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
public class DwarfPanel extends Composite {

	private static DwarfPanelUiBinder uiBinder = GWT
			.create(DwarfPanelUiBinder.class);

	interface DwarfPanelUiBinder extends UiBinder<Widget, DwarfPanel> {
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

	@UiField
	TextBox luckyWeaponBox;

	public DwarfPanel(String luckyWeapon) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi

		luckyWeaponBox.setText(luckyWeapon);
	}

}
