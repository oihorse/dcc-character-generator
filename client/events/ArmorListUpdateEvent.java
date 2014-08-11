package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.horsegoeswest.dcc.client.equipment.Armor;

public class ArmorListUpdateEvent extends GwtEvent<ArmorListUpdateEventHandler>{
	
	public static final Type<ArmorListUpdateEventHandler> TYPE = new Type<ArmorListUpdateEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ArmorListUpdateEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	
	private Armor armor;
	private String typeOfUpdate;
	
	public ArmorListUpdateEvent(Armor armor, String typeOfUpdate)
	{
		this.armor = armor;
		this.typeOfUpdate = typeOfUpdate;
	}
	
	/**
	 * @return the armor
	 */
	public Armor getArmor() {
		return armor;
	}



	/**
	 * @return the typeOfUpdate
	 */
	public String getTypeOfUpdate() {
		return typeOfUpdate;
	}



	@Override
	protected void dispatch(ArmorListUpdateEventHandler handler) {
		handler.updateArmorList(this);		
	}

}
