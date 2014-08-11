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
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.horsegoeswest.dcc.client.CharacterGenerator;
import com.horsegoeswest.dcc.client.characters.CharacterClass;
import com.horsegoeswest.dcc.client.equipment.Armor;
import com.horsegoeswest.dcc.client.events.ArmorListUpdateEvent;
import com.horsegoeswest.dcc.client.events.SetArmorClassEvent;
import com.horsegoeswest.dcc.client.resources.DCCTables;

public class ArmorPanel extends Composite  {

	private static ArmorPanelUiBinder uiBinder = GWT.create(ArmorPanelUiBinder.class);

	interface ArmorPanelUiBinder extends UiBinder<Widget, ArmorPanel> {
	}
	
	@UiField
	ListBox armorList;
	@UiField
	Button addArmor;
	@UiField
	Button openArmorSelection;
	@UiField 
	Button closeArmorButton;
	@UiField HorizontalPanel armorPanel;
	
	
	CellTable<Armor> armorTable = new CellTable<Armor>();
	ListDataProvider<Armor> dataProvider = new ListDataProvider<Armor>();
	List<Armor> list = dataProvider.getList();
	Boolean hasShield = false;

	public ArmorPanel(CharacterClass character) {
		initWidget(uiBinder.createAndBindUi(this));
		
		armorList.setVisible(false);
		for (Armor armor : DCCTables.armorList) {
			armorList.addItem(armor.getName());
		}
		addArmor.setVisible(false);
		closeArmorButton.setVisible(false);
		
		 // Add a text column to show the name.
	     TextColumn<Armor> nameColumn = new TextColumn<Armor>() {
	        @Override
	        public String getValue(Armor armor) {
	           return armor.getName();
	        }  
	     };
	     
	
	     armorTable.addColumn(nameColumn, "Name");
	
	     // Connect the table to the data provider.
	     dataProvider.addDataDisplay(armorTable);

	     // Add the data to the data provider, which automatically pushes it to the
	     // widget.
	    
	     for (Armor armor : character.getCharacterArmor()) {
	       list.add(armor);
	     }
	     
	     
	     Column<Armor, String> deleteArmor = new Column<Armor, String>(
					new ButtonCell()) {
				@Override
				public String getValue(Armor c) {
					return "x";
				}
			};

			deleteArmor.setFieldUpdater(new FieldUpdater<Armor, String>() {

				@Override
				public void update(int index, Armor armor, String value) {
					dataProvider.getList().remove(armor);
					dataProvider.refresh();
					armorTable.redraw();
					updateArmorList(armor, "remove");
					
					if (armor.getName().equals("Shield"))
						{
							hasShield = false;
						}
				}
			});
			
			
			// Add a selection model to handle user selection.
			final SingleSelectionModel<Armor> selectionModel = new SingleSelectionModel<Armor>();
			armorTable.setSelectionModel(selectionModel);
			selectionModel
					.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
						public void onSelectionChange(SelectionChangeEvent event) {
							Armor selected = selectionModel.getSelectedObject();
							if (selected != null) {
								int armorClass = selected.getAcBonus();
								
								updateCharacterArmorClass(armorClass);
							}
						}
					});
	     
	     
		armorTable.addColumn(deleteArmor, "");
	     
	     armorPanel.add(armorTable);
		
		
	}

	@UiHandler("openArmorSelection")
	void openArmorSelection(ClickEvent e) {
		armorList.setVisible(true);
		addArmor.setVisible(true);
		closeArmorButton.setVisible(true);
	}

	@UiHandler("addArmor")
	void addArmor(ClickEvent e) {
		int index = armorList.getSelectedIndex();
		Armor armor = DCCTables.armorList.get(index);
		updateArmorList(armor, "add");
	}

	@UiHandler("closeArmorButton")
	void closeArmorButton(ClickEvent e) {
		armorList.setVisible(false);
		addArmor.setVisible(false);
		closeArmorButton.setVisible(false);
	}
	
	private void updateArmorList(Armor armor, String updateType) {

		CharacterGenerator.eventBus.fireEvent(new ArmorListUpdateEvent(armor,
				updateType));

		if (updateType.equals("add")) {
			list.add(armor);
		}
		
		if (armor.getName().equals("Shield"))
		{
			hasShield = true;
		}
	}
	
	private void updateCharacterArmorClass(int armorClass)
	{
		if (hasShield)
		{
			//fire acEvent at +1
			int ac = armorClass + 1;
			CharacterGenerator.eventBus.fireEvent(new SetArmorClassEvent(ac));
		}
		else
		{
			//fire acEvent
			CharacterGenerator.eventBus.fireEvent(new SetArmorClassEvent(armorClass));
		}
		
	}

	
	
}
