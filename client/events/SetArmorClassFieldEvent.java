package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SetArmorClassFieldEvent extends GwtEvent<SetArmorClassFieldEventHandler>{

	public static final Type<SetArmorClassFieldEventHandler> TYPE = new Type<SetArmorClassFieldEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SetArmorClassFieldEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	private String armorClass;

	public SetArmorClassFieldEvent(int armorClass) {
		Integer ac = armorClass;
		this.armorClass = ac.toString();
	}

	/**
	 * @return the armorClass
	 */
	public String getArmorClass() {
		return armorClass;
	}

	@Override
	protected void dispatch(SetArmorClassFieldEventHandler handler) {
		handler.setArmorClassField(this);
		
	}

}
