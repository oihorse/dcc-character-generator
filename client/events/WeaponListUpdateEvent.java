package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.horsegoeswest.dcc.client.equipment.Weapon;

public class WeaponListUpdateEvent extends GwtEvent<WeaponListUpdateEventHandler> {

	public static final Type<WeaponListUpdateEventHandler> TYPE = new Type<WeaponListUpdateEventHandler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<WeaponListUpdateEventHandler> getAssociatedType() {
		return TYPE;
	}
	
	private Weapon weapon;
	private String typeOfUpdate;
	
	public WeaponListUpdateEvent(Weapon weapon, String typeOfUpdate)
	{
		this.weapon = weapon;
		this.typeOfUpdate = typeOfUpdate;
	}
	
	
	public Weapon getWeapon()
	{
		return weapon;
	}
	
	public String getTypeOfUpdate()
	{
		return typeOfUpdate;
	}
	
	@Override
	protected void dispatch(WeaponListUpdateEventHandler handler){
		handler.updateWeaponList(this);
	}


	
}

