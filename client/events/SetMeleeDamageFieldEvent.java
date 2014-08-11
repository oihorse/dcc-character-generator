package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SetMeleeDamageFieldEvent  extends GwtEvent<SetMeleeDamageFieldEventHandler>{

	public static final Type<SetMeleeDamageFieldEventHandler> TYPE = new Type<SetMeleeDamageFieldEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SetMeleeDamageFieldEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}
	
	public String meleeDamageField;
	

	public SetMeleeDamageFieldEvent(String meleeDamageField) {
		this.meleeDamageField = meleeDamageField;
	}


	public String getMeleeDamageField() {
		return meleeDamageField;
	}


	@Override
	protected void dispatch(SetMeleeDamageFieldEventHandler handler) {
		handler.setMeleeWeaponDamageField(this);
		
	}

}
