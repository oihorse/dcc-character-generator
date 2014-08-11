package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class SetMeleeDamageEvent extends GwtEvent<SetMeleeDamageEventHandler>{
	
	public static final Type<SetMeleeDamageEventHandler> TYPE = new Type<SetMeleeDamageEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SetMeleeDamageEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	private String damage;
	
	
	public String getDamage() {
		return damage;
	}
	

	public SetMeleeDamageEvent(String damage) {
		this.damage = damage;
	}


	@Override
	protected void dispatch(SetMeleeDamageEventHandler handler) {
		handler.setMeleeWeaponDamage(this);
		
	}

}
