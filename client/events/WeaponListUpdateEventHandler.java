package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.EventHandler;


public interface WeaponListUpdateEventHandler extends EventHandler {

	public void updateWeaponList(WeaponListUpdateEvent event);
	
}
