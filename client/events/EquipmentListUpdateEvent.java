package com.horsegoeswest.dcc.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.horsegoeswest.dcc.client.equipment.Equipment;

public class EquipmentListUpdateEvent extends GwtEvent<EquipmentListUpdateEventHandler> {
	
	public static final Type<EquipmentListUpdateEventHandler> TYPE = new Type<EquipmentListUpdateEventHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<EquipmentListUpdateEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}
	
	private Equipment equipment;
	private String typeOfUpdate;
	
	public EquipmentListUpdateEvent(Equipment equipment, String typeOfUpdate)
	{
		this.equipment = equipment;
		this.typeOfUpdate = typeOfUpdate;
	}
	
	

	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}



	/**
	 * @return the typeOfUpdate
	 */
	public String getTypeOfUpdate() {
		return typeOfUpdate;
	}



	@Override
	protected void dispatch(EquipmentListUpdateEventHandler handler) {
		handler.updateEquipmentList(this);
	}

}
