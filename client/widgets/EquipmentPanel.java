package com.horsegoeswest.dcc.client.widgets;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.horsegoeswest.dcc.client.CharacterGenerator;
import com.horsegoeswest.dcc.client.characters.CharacterClass;
import com.horsegoeswest.dcc.client.equipment.Equipment;
import com.horsegoeswest.dcc.client.events.EquipmentListUpdateEvent;
import com.horsegoeswest.dcc.client.resources.DCCTables;

public class EquipmentPanel extends Composite {

	@UiField
	ListBox equipmentList;
	@UiField
	Button addEquipment;
	@UiField
	Button openEquipmentSelection;
	@UiField 
	Button closeEquipmentButton;
	@UiField HorizontalPanel equipmentPanel;
	
	CellTable<Equipment> equipmentTable = new CellTable<Equipment>();
    ListDataProvider<Equipment> dataProvider = new ListDataProvider<Equipment>();
    List<Equipment> list = dataProvider.getList();
	
	
	private static EquipmentPanelUiBinder uiBinder = GWT
			.create(EquipmentPanelUiBinder.class);

	interface EquipmentPanelUiBinder extends UiBinder<Widget, EquipmentPanel> {
	}

	public EquipmentPanel(CharacterClass character) {
		initWidget(uiBinder.createAndBindUi(this));
		
		equipmentList.setVisible(false);
		for (Equipment equipment : DCCTables.equipmentList) {
			equipmentList.addItem(equipment.getName());
		}
		addEquipment.setVisible(false);
		closeEquipmentButton.setVisible(false);
		
		
		
		 // Add a text column to show the name.
	     TextColumn<Equipment> nameColumn = new TextColumn<Equipment>() {
	        @Override
	        public String getValue(Equipment equipment) {
	           return equipment.getName();
	        }  
	     };
	

	     
	     Column<Equipment, String> deleteEquipment = new Column<Equipment, String>(
	    		 new ButtonCell()) {
	    		 @Override
	    		 public String getValue(Equipment c) {
	    		 return "x";
	    		 }
	    		 };
	    		 
	    		 deleteEquipment.setFieldUpdater(new FieldUpdater<Equipment, String>() {
			 
			 @Override
			 public void update(int index, Equipment equipment, String value) {
			 dataProvider.getList().remove(equipment);
			 dataProvider.refresh();
			equipmentTable.redraw();
			updateEquipmentList(equipment, "remove")
;			 }
			 });
	
	   

	     // Connect the table to the data provider.
	     dataProvider.addDataDisplay(equipmentTable);

	     // Add the data to the data provider, which automatically pushes it to the
	     // widget.
	    
	     for (Equipment equipment : character.getCharacterEquipment()) {
	       list.add(equipment);
	     }
	     
	   equipmentTable.addColumn(nameColumn, "Name");
	   equipmentTable.addColumn(deleteEquipment, "");
	   
	   equipmentPanel.add(equipmentTable);
		
	}
	
	
	@UiHandler("openEquipmentSelection")
	void openEquipmentSelection(ClickEvent e) {
		equipmentList.setVisible(true);
		addEquipment.setVisible(true);
		closeEquipmentButton.setVisible(true);
	}

	@UiHandler("addEquipment")
	void addEquipment(ClickEvent e) {
//		int index = equipmentList.getSelectedIndex();
//		Equipment equipment = DCCTables.equipmentList.get(index);
		int index = equipmentList.getSelectedIndex();
		Equipment equipment = DCCTables.equipmentList.get(index);
		updateEquipmentList(equipment, "add");	
	}

	@UiHandler("closeEquipmentButton")
	void closeEquipmentButton(ClickEvent e) {
		equipmentList.setVisible(false);
		addEquipment.setVisible(false);
		closeEquipmentButton.setVisible(false);
	}
	
	private void updateEquipmentList(Equipment equipment, String updateType)
	{
		
		CharacterGenerator.eventBus.fireEvent(new EquipmentListUpdateEvent(equipment, updateType));
		
		if (updateType.equals("add"))
		{
		list.add(equipment);
		}
	}

}
