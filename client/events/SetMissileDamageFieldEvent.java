package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SetMissileDamageFieldEvent extends GwtEvent<SetMissileDamageFieldEventHandler> {

	public static final Type<SetMissileDamageFieldEventHandler> TYPE = new Type<SetMissileDamageFieldEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SetMissileDamageFieldEventHandler> getAssociatedType() {
		return TYPE;
	}

	

	private String damage;
	
	
	public String getDamage() {
		return damage;
	}
	

	public SetMissileDamageFieldEvent(String damage) {
		this.damage = damage;
	}
	
	
	
	@Override
	protected void dispatch(SetMissileDamageFieldEventHandler handler) {
		handler.setMissileWeaponDamageField(this);		
	}

}
