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
import com.horsegoeswest.dcc.client.equipment.Weapon;
import com.horsegoeswest.dcc.client.events.SetMeleeDamageEvent;
import com.horsegoeswest.dcc.client.events.SetMissileDamageEvent;
import com.horsegoeswest.dcc.client.events.SetMissileDamageFieldEvent;
import com.horsegoeswest.dcc.client.events.WeaponListUpdateEvent;
import com.horsegoeswest.dcc.client.resources.DCCTables;

public class WeaponPanel extends Composite {

	private static WeaponPanelUiBinder uiBinder = GWT
			.create(WeaponPanelUiBinder.class);

	interface WeaponPanelUiBinder extends UiBinder<Widget, WeaponPanel> {
	}

	@UiField
	HorizontalPanel weaponPanel;
	@UiField
	ListBox weaponsList;
	@UiField
	Button addWeapon;
	@UiField
	Button closeWeaponButton;
	@UiField
	Button openWeaponSelection;

	CellTable<Weapon> weaponTable = new CellTable<Weapon>();
	ListDataProvider<Weapon> dataProvider = new ListDataProvider<Weapon>();
	List<Weapon> list = dataProvider.getList();

	public WeaponPanel(CharacterClass character) {
		initWidget(uiBinder.createAndBindUi(this));

		weaponsList.setVisible(false);
		for (Weapon weapon : DCCTables.weaponList) {
			weaponsList.addItem(weapon.getName());
		}
		addWeapon.setVisible(false);
		closeWeaponButton.setVisible(false);

		// Add a text column to show the name.
		TextColumn<Weapon> nameColumn = new TextColumn<Weapon>() {
			@Override
			public String getValue(Weapon weapon) {
				return weapon.getName();
			}
		};

		// Add a text column to show the name.
		TextColumn<Weapon> damageColumn = new TextColumn<Weapon>() {
			@Override
			public String getValue(Weapon weapon) {
				return weapon.getDamage();
			}
		};

		// Add a text column to show the name.
		TextColumn<Weapon> rangeColumn = new TextColumn<Weapon>() {
			@Override
			public String getValue(Weapon weapon) {
				return weapon.getRange();
			}
		};

		// Add a selection model to handle user selection.
		final SingleSelectionModel<Weapon> selectionModel = new SingleSelectionModel<Weapon>();
		weaponTable.setSelectionModel(selectionModel);
		selectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						Weapon selected = selectionModel.getSelectedObject();
						if (selected != null) {
							if (selected.getRange() != "-") {
								setMissileDamage(selected.getDamage());
							} else {
								setMeleeDamage(selected.getDamage());
							}
						}

					}
				});

		Column<Weapon, String> deleteWeapon = new Column<Weapon, String>(
				new ButtonCell()) {
			@Override
			public String getValue(Weapon c) {
				return "x";
			}
		};

		deleteWeapon.setFieldUpdater(new FieldUpdater<Weapon, String>() {

			@Override
			public void update(int index, Weapon weapon, String value) {
				dataProvider.getList().remove(weapon);
				dataProvider.refresh();
				weaponTable.redraw();
				updateWeaponList(weapon, "remove");
			}
		});

		weaponTable.addColumn(nameColumn, "Name");
		weaponTable.addColumn(damageColumn, "Damage");
		weaponTable.addColumn(rangeColumn, "Range");
		weaponTable.addColumn(deleteWeapon, "");

		// Create a data provider.

		// Connect the table to the data provider.
		dataProvider.addDataDisplay(weaponTable);

		// Add the data to the data provider, which automatically pushes it to
		// the
		// widget.
		// List<Weapon> list = dataProvider.getList();
		// for (Weapon weapon : character.getCharacterWeapons()) {
		// list.add(weapon);
		// }

		list.addAll(character.getCharacterWeapons());

		weaponPanel.add(weaponTable);
	}

	private void setMeleeDamage(String damage) {
		CharacterGenerator.eventBus.fireEvent(new SetMeleeDamageEvent(damage));
	}

	private void setMissileDamage(String damage) {
		CharacterGenerator.eventBus.fireEvent(new SetMissileDamageEvent(damage));
	}

	@UiHandler("openWeaponSelection")
	void openWeaponSelection(ClickEvent e) {
		weaponsList.setVisible(true);
		addWeapon.setVisible(true);
		closeWeaponButton.setVisible(true);
	}

	@UiHandler("addWeapon")
	void addWeapons(ClickEvent e) {
		int index = weaponsList.getSelectedIndex();
		Weapon weapon = DCCTables.weaponList.get(index);
		updateWeaponList(weapon, "add");
	}

	@UiHandler("closeWeaponButton")
	void closeWeaponButton(ClickEvent e) {
		weaponsList.setVisible(false);
		addWeapon.setVisible(false);
		closeWeaponButton.setVisible(false);
	}

	private void updateWeaponList(Weapon weapon, String updateType) {

		CharacterGenerator.eventBus.fireEvent(new WeaponListUpdateEvent(weapon,
				updateType));

		if (updateType.equals("add")) {
			list.add(weapon);
		}
	}

}
