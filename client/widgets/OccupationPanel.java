/**
 * 
 */
package com.horsegoeswest.dcc.client.widgets;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.horsegoeswest.dcc.client.characters.CharacterClass;
import com.horsegoeswest.dcc.client.characters.Cleric;
import com.horsegoeswest.dcc.client.characters.Dwarf;
import com.horsegoeswest.dcc.client.characters.Elf;
import com.horsegoeswest.dcc.client.characters.Halfling;
import com.horsegoeswest.dcc.client.characters.Thief;
import com.horsegoeswest.dcc.client.characters.Warrior;
import com.horsegoeswest.dcc.client.characters.Wizard;
import com.horsegoeswest.dcc.client.resources.DCCTables;
import com.horsegoeswest.dcc.client.resources.Occupation;

/**
 * @author Horse
 * 
 */
public class OccupationPanel extends Composite {

	private static OccupationPanelUiBinder uiBinder = GWT
			.create(OccupationPanelUiBinder.class);

	interface OccupationPanelUiBinder extends UiBinder<Widget, OccupationPanel> {
	}

	/**
	 * Because this class has a default constructor, it can be used as a binder
	 * template. In other words, it can be used in other *.ui.xml files as
	 * follows: <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 * xmlns:g="urn:import:**user's package**">
	 * <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that
	 * depending on the widget that is used, it may be necessary to implement
	 * HasHTML instead of HasText.
	 * 
	 * @param occupations
	 */

	@UiField
	ListBox occupationBox;
	@UiField
	ListBox classBox;
	@UiField
	Button generateOccupation;
	@UiField
	ListBox alignmentBox;
	@UiField
	ListBox levelBox;
	@UiField
	TextBox nameBox;
	@UiField
	Button nextButton;

	public CharacterClass character;

	public StandardStats standardStats;

	public OccupationPanel(List<Occupation> occupations) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		for (Occupation occupation : occupations) {
			occupationBox.addItem(occupation.getName());
		}
		populateClassBox(DCCTables.characterClasses);
		populateLevelBox();
		populateAlignmentBox(DCCTables.alignment);

	}

	@UiHandler("generateOccupation")
	void onClick(ClickEvent e) {
		int listIndex = DCCTables.randNumber(0,
				DCCTables.occupations.size() - 1);
		occupationBox.setItemSelected(listIndex, true);
		updateClass();
	}

	@UiHandler("nextButton")
	void onNextButtonClick(ClickEvent e) {
		int level = levelBox.getSelectedIndex() + 1;
		String alignment = alignmentBox.getValue(alignmentBox
				.getSelectedIndex());
		String name = nameBox.getValue();
		Occupation occupation =DCCTables.occupationList.get(occupationBox
				.getSelectedIndex());
		
		if (classBox.getValue(classBox.getSelectedIndex()).equals("Cleric")) {
			character = new Cleric(level, alignment, name, occupation);
			RootPanel.get().add(standardStats = new StandardStats(character));
			this.setVisible(false);

		} else if (classBox.getValue(classBox.getSelectedIndex()).equals(
				"Thief")) {
			character = new Thief(level, alignment, name, occupation);
			RootPanel.get().add(standardStats = new StandardStats(character));
			this.setVisible(false);

		} else if (classBox.getValue(classBox.getSelectedIndex()).equals(
				"Warrior")) {
			character = new Warrior(level, alignment, name, occupation);
			RootPanel.get().add(standardStats = new StandardStats(character));
			this.setVisible(false);

		} else if (classBox.getValue(classBox.getSelectedIndex()).equals(
				"Wizard")) {
			character = new Wizard(level, alignment, name, occupation);
			RootPanel.get().add(standardStats = new StandardStats(character));
			this.setVisible(false);

		} else if (classBox.getValue(classBox.getSelectedIndex()).equals(
				"Dwarf")) {
			character = new Dwarf(level, alignment, name, occupation);
			RootPanel.get().add(standardStats = new StandardStats(character));
			this.setVisible(false);
		} else if (classBox.getValue(classBox.getSelectedIndex()).equals("Elf")) {
			character = new Elf(level, alignment, name, occupation);
			RootPanel.get().add(standardStats = new StandardStats(character));
			this.setVisible(false);

		} else if (classBox.getValue(classBox.getSelectedIndex()).equals(
				"Halfling")) {
			character = new Halfling(level, alignment, name, occupation);
			RootPanel.get().add(standardStats = new StandardStats(character));
			this.setVisible(false);
		}

	}

	@UiHandler("occupationBox")
	void onChange(ChangeEvent e) {
		String currentValue = occupationBox.getValue(occupationBox
				.getSelectedIndex());

		if (currentValue.contains("Dwarven")) {
			classBox.setItemSelected(4, true);
			classBox.setEnabled(false);
		} else if (currentValue.contains("Elven")) {
			classBox.setItemSelected(5, true);
			classBox.setEnabled(false);
		} else if (currentValue.contains("Halfling")) {
			classBox.setItemSelected(6, true);
			classBox.setEnabled(false);
		} else {
			classBox.setItemSelected(0, true);
			classBox.setEnabled(true);
		}
	}

	@UiHandler("classBox")
	void onClick2(ClickEvent e) {
		classBox.getElement().getElementsByTagName("option").getItem(4)
				.setAttribute("disabled", "disabled");
		classBox.getElement().getElementsByTagName("option").getItem(5)
				.setAttribute("disabled", "disabled");
		classBox.getElement().getElementsByTagName("option").getItem(6)
				.setAttribute("disabled", "disabled");
	}

	public void populateClassBox(List<String> charClasses) {
		for (String charClass : charClasses) {
			classBox.addItem(charClass);
		}
	}

	public void populateAlignmentBox(List<String> alignments) {
		for (String alignment : alignments) {
			alignmentBox.addItem(alignment);
		}
	}

	public void updateClass() {
		String currentValue = occupationBox.getValue(occupationBox
				.getSelectedIndex());

		if (currentValue.contains("Dwarven")) {
			classBox.setItemSelected(4, true);
			classBox.setEnabled(false);
		} else if (currentValue.contains("Elven")) {
			classBox.setItemSelected(5, true);
			classBox.setEnabled(false);
		} else if (currentValue.contains("Halfling")) {
			classBox.setItemSelected(6, true);
			classBox.setEnabled(false);
		} else {
			classBox.setItemSelected(0, true);
			classBox.setEnabled(true);
		}
	}

	public void populateLevelBox() {
		Integer l = 1;
		while (l < 11) {
			levelBox.addItem(l.toString());
			l++;
		}
	}
	
	public Occupation getOccupation(int occupation)
	{
		Occupation newOccupation = DCCTables.occupationList.get(occupation);
		
		return newOccupation;
		
	}

}
