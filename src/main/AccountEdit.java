package main;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class AccountEdit extends JPanel {

	public static JPanel accountEditPanel;
	public static JTextField[] courseTextField = new JTextField[6];
	public static JTextField[] gradeTextField = new JTextField[6];
	public static JComboBox[] dropDownLists = new JComboBox[2];
	public static JSlider[] sliders = new JSlider[2];
	private static JLabel[] sliderLabels = new JLabel[2];

	public static void EditAccount() {

		// Create panel when user is editing the account details
		accountEditPanel = new JPanel();
		Dashboard.displayPanel.add(accountEditPanel);
		accountEditPanel.setLayout(null);

		// Create courses and grades text fields
		for (int counter = 0; counter < courseTextField.length; counter++) {
			courseTextField[counter] = new JTextField("Course");
			courseTextField[counter].setBounds(30, 210 + 50 * counter, 130, 30);
			accountEditPanel.add(courseTextField[counter]);

			gradeTextField[counter] = new JTextField("Grade");
			gradeTextField[counter].setBounds(160, 210 + 50 * counter, 70, 30);
			accountEditPanel.add(gradeTextField[counter]);
		}

		sliderLabels[0] = new JLabel("$4,000                  -                  $20,000");
		sliderLabels[1] = new JLabel("1,000                    -                   50,000");

		// Create sliders and combo boxes for preference adjustments
		for (int counter = 0; counter < dropDownLists.length; counter++) {
			dropDownLists[counter] = new JComboBox();
			dropDownLists[counter].setBounds(330, 210 + 140 * counter, 200, 30);
			accountEditPanel.add(dropDownLists[counter]);

			sliders[counter] = new JSlider();
			sliders[counter].setBounds(655, 210 + 140 * counter, 200, 30);
			accountEditPanel.add(sliders[counter]);

			sliderLabels[counter].setBounds(655, 230 + 140 * counter, 200, 30);
			accountEditPanel.add(sliderLabels[counter]);
		}

		// Edit sliders
		sliders[0].setMinimum(4000);
		sliders[0].setMaximum(20000);

		sliders[1].setMinimum(1000);
		sliders[1].setMaximum(50000);

		// Edit combo boxes
		dropDownLists[0].addItem("Commutable");
		dropDownLists[0].addItem("Close Residence");
		dropDownLists[0].addItem("Distant Residence");

		dropDownLists[1].addItem("Party");
		dropDownLists[1].addItem("Quiet");

	}

}
