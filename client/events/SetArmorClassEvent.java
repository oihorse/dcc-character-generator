package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SetArmorClassEvent extends GwtEvent<SetArmorClassEventHandler> {

	public static final Type<SetArmorClassEventHandler> TYPE = new Type<SetArmorClassEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SetArmorClassEventHandler> getAssociatedType() {
		return TYPE;
	}

	private int armorClass;

	public SetArmorClassEvent(int armorClass) {
		this.armorClass = armorClass;
	}

	/**
	 * @return the armorClass
	 */
	public int getArmorClass() {
		return armorClass;
	}

	@Override
	protected void dispatch(SetArmorClassEventHandler handler) {
		handler.setCharacterArmorClass(this);
	}

}
