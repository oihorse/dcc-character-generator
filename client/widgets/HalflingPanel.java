package com.horsegoeswest.dcc.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class HalflingPanel extends Composite {

	private static HalflingPanelUiBinder uiBinder = GWT
			.create(HalflingPanelUiBinder.class);

	interface HalflingPanelUiBinder extends UiBinder<Widget, HalflingPanel> {
	}

	public HalflingPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox sneakSilentlyBox;
	@UiField
	TextBox hideInShadowsBox;

	public HalflingPanel(String sneakSilently, String hideInShadows) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		sneakSilentlyBox.setText(sneakSilently);
		hideInShadowsBox.setText(hideInShadows);

	}

}
