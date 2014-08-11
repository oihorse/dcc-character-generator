package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SetMissileDamageEvent extends GwtEvent<SetMissileDamageEventHandler>{

	public static final Type<SetMissileDamageEventHandler> TYPE = new Type<SetMissileDamageEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SetMissileDamageEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}
	
	
	private String damage;
	
	
	public String getDamage() {
		return damage;
	}
	

	public SetMissileDamageEvent(String damage) {
		this.damage = damage;
	}
	
	
	@Override
	protected void dispatch(SetMissileDamageEventHandler handler) {
		handler.setMissileWeaponDamage(this);
		
	}

}
