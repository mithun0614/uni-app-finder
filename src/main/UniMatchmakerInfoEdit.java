package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class UniMatchmakerInfoEdit extends JPanel {

	public static JPanel accountEditPanel;
	public static JTextField[] courseTextField = new JTextField[6];
	public static JTextField[] gradeTextField = new JTextField[6];
	private static JLabel[] headings = new JLabel[6];
	public static JComboBox[] dropDownLists = new JComboBox[6];
	public static JSlider[] sliders = new JSlider[6];

	public static void EditAccount() {

		// Create panel
		accountEditPanel = new JPanel();
		Dashboard.displayPanel.add(accountEditPanel);
		accountEditPanel.setLayout(null);

		// Create title
		JLabel titleLabel = new JLabel("University Matchmaker");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		titleLabel.setBounds(300, 10, 400, 65);
		accountEditPanel.add(titleLabel);

		// Create description
		JLabel descriptionLabel = new JLabel("External Factors:");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descriptionLabel.setBounds(330, 75, 280, 40);
		accountEditPanel.add(descriptionLabel);

		// Create courses and grades heading
		JLabel courseGradeLabel = new JLabel("Courses and Grades");
		courseGradeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		courseGradeLabel.setBounds(40, 75, 280, 40);
		accountEditPanel.add(courseGradeLabel);

		// Create edit buttons
		JButton editButton = new JButton("Save");
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton.setBounds(800, 30, 75, 30);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountEditPanel.setVisible(false);
				UniMatchmaker.CreateAccount();
				UniMatchmaker.accountPanel.setVisible(true);
			}
		});
		accountEditPanel.add(editButton);

		// Create instructions label
		JLabel instructions = new JLabel(
				"*Use the sliders to indicate the level of importance for each external factor*");
		instructions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		instructions.setBounds(330, 120, 500, 30);
		accountEditPanel.add(instructions);

		// Create external factors headings
		headings[0] = new JLabel("Ranking:");
		headings[1] = new JLabel("Tuition:");
		headings[2] = new JLabel("University Size:");
		headings[3] = new JLabel("Distance:");
		headings[4] = new JLabel("Residence Cost:");
		headings[5] = new JLabel("Class Size:");

		// Create courses and grades label + external factors headings + slider and
		// combo boxes
		for (int counter = 0; counter < courseTextField.length; counter++) {
			courseTextField[counter] = new JTextField("<Course>");
			courseTextField[counter].setBounds(30, 150 + 75 * counter, 125, 30);
			accountEditPanel.add(courseTextField[counter]);

			gradeTextField[counter] = new JTextField("<Grade>");
			gradeTextField[counter].setBounds(160, 150 + 75 * counter, 70, 30);
			accountEditPanel.add(gradeTextField[counter]);

			headings[counter].setFont(new Font("Tahoma", Font.PLAIN, 18));

			dropDownLists[counter] = new JComboBox();

			sliders[counter] = new JSlider();
			sliders[counter].setMajorTickSpacing(1);
			sliders[counter].setMinimum(1);
			sliders[counter].setMaximum(5);
			sliders[counter].setPaintTicks(true);
			sliders[counter].setPaintLabels(true);
			sliders[counter].setSnapToTicks(true);

			if (counter <= 2) {
				headings[counter].setBounds(330, 170 + 140 * counter, 200, 25);
				dropDownLists[counter].setBounds(330, 200 + 140 * counter, 200, 30);
				sliders[counter].setBounds(330, 240 + 140 * counter, 200, 50);
			} else {
				headings[counter].setBounds(650, 170 + 140 * (counter - 3), 200, 25);
				dropDownLists[counter].setBounds(650, 200 + 140 * (counter - 3), 200, 30);
				sliders[counter].setBounds(650, 240 + 140 * (counter - 3), 200, 50);
			}

			accountEditPanel.add(headings[counter]);
			accountEditPanel.add(dropDownLists[counter]);
			accountEditPanel.add(sliders[counter]);

		}

		// Edit combo boxes
		dropDownLists[0].addItem("Top 5");
		dropDownLists[0].addItem("Top 10");
		dropDownLists[0].addItem("Does not matter");

		dropDownLists[1].addItem("<$10,000");
		dropDownLists[1].addItem("$10,000 - $15,000");
		dropDownLists[1].addItem(">$15,000");
		dropDownLists[1].addItem("Does not matter");

		dropDownLists[2].addItem("<10,000");
		dropDownLists[2].addItem("10,000 - 50,000");
		dropDownLists[2].addItem(">50,000");
		dropDownLists[2].addItem("Does not matter");

		dropDownLists[3].addItem("<30 km (Commutable)");
		dropDownLists[3].addItem("30 km - 150 km (1 - 2 hrs)");
		dropDownLists[3].addItem("150 km - 300 km (2 - 4 hrs)");
		dropDownLists[3].addItem(">400 km (4 hrs +)");
		dropDownLists[3].addItem("Does not matter");

		dropDownLists[4].addItem("<$10,000");
		dropDownLists[4].addItem("$10,000 - $12,000");
		dropDownLists[4].addItem(">$12,000");
		dropDownLists[4].addItem("Does not matter");

		dropDownLists[5].addItem("<100");
		dropDownLists[5].addItem("100 - 300");
		dropDownLists[5].addItem(">300");
		dropDownLists[5].addItem("Does not matter");

	}

}
