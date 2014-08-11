package com.horsegoeswest.dcc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.horsegoeswest.dcc.client.resources.DCCTables;
import com.horsegoeswest.dcc.client.widgets.OccupationPanel;

public class CharacterGenerator implements EntryPoint {

	// vars
	private FlowPanel openingPanel;
	public static SimpleEventBus eventBus = new SimpleEventBus();


	@Override
	public void onModuleLoad() {
	
		DCCTables.populateArmorList();
		DCCTables.populateAmmunitionList();
		DCCTables.populateEquipmentList();
		DCCTables.populateWeaponList();
		DCCTables.populateOccupationList();		
		
		openingPanel = new FlowPanel();

		OccupationPanel occupationPanel = new OccupationPanel(
				DCCTables.occupationList);
		openingPanel.add(occupationPanel);

		RootPanel.get().add(openingPanel);

	}

	

}
