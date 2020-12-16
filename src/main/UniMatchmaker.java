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
import javax.swing.SwingConstants;

import objects.UniversitiesInformation;
import tools.Colour;

public class UniMatchmaker extends JPanel {

	public static JPanel accountPanel;
	private static JLabel[] courseLabel = new JLabel[6];
	private static JLabel[] headings = new JLabel[6];
	private static JLabel[] factorValue = new JLabel[6];
	private static JLabel[] importance = new JLabel[6];

	public static void CreateAccount() {

		// Create panel
		accountPanel = new JPanel();
		Dashboard.displayPanel.add(accountPanel);
		accountPanel.setBackground(Colour.bg);
		accountPanel.setLayout(null);
		accountPanel.setVisible(true);

		// Create title
		JLabel titleLabel = new JLabel("University Matchmaker");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		titleLabel.setForeground(Colour.strongHighlight);
		titleLabel.setBounds(300, 10, 400, 65);
		accountPanel.add(titleLabel);

		// Create description
		JLabel descriptionLabel = new JLabel("External Factors:");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		descriptionLabel.setForeground(Colour.strongHighlight);
		descriptionLabel.setBounds(330, 75, 280, 40);
		accountPanel.add(descriptionLabel);

		// Create courses and grades heading
		JLabel courseGradeLabel = new JLabel("Courses and Grades");
		courseGradeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		courseGradeLabel.setForeground(Colour.strongHighlight);
		courseGradeLabel.setBounds(40, 75, 280, 40);
		accountPanel.add(courseGradeLabel);

		// Create edit buttons
		JButton editButton = new JButton("Edit");
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton.setBounds(800, 30, 75, 30);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountPanel.setVisible(false);
				UniMatchmakerInfoEdit.accountEditPanel.setVisible(true);
			}
		});
		accountPanel.add(editButton);

		JButton resultsButton = new JButton("Results");
		resultsButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultsButton.setBounds(775, 550, 100, 30);
		resultsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountPanel.setVisible(false);
				Results.CreateResults();
				Results.resultsPanel.setVisible(true);
			}
		});
		accountPanel.add(resultsButton);

		// Create external factors headings
		headings[0] = new JLabel("Ranking:");
		headings[1] = new JLabel("Tuition:");
		headings[2] = new JLabel("University Size:");
		headings[3] = new JLabel("Distance:");
		headings[4] = new JLabel("Residence Cost:");
		headings[5] = new JLabel("Class Size:");

		// Create courses and grades label + external factors headings + factor values
		for (int counter = 0; counter < courseLabel.length; counter++) {
			courseLabel[counter] = new JLabel(
					(counter + 1) + ". " + UniMatchmakerInfoEdit.courseTextField[counter].getText() + " - "
							+ UniMatchmakerInfoEdit.gradeTextField[counter].getText() + "%");
			courseLabel[counter].setFont(new Font("Tahoma", Font.PLAIN, 16));
			courseLabel[counter].setForeground(Colour.strongHighlight);
			courseLabel[counter].setBounds(30, 150 + 75 * counter, 250, 40);
			accountPanel.add(courseLabel[counter]);

			headings[counter].setFont(new Font("Tahoma", Font.PLAIN, 18));
			headings[counter].setForeground(Colour.strongHighlight);

			factorValue[counter] = new JLabel(
					"Selected: " + UniMatchmakerInfoEdit.dropDownLists[counter].getSelectedItem());
			factorValue[counter].setFont(new Font("Tahoma", Font.PLAIN, 16));
			factorValue[counter].setForeground(Colour.strongHighlight);

			importance[counter] = new JLabel("Importance: " + UniMatchmakerInfoEdit.sliders[counter].getValue());
			importance[counter].setFont(new Font("Tahoma", Font.PLAIN, 16));
			importance[counter].setForeground(Colour.strongHighlight);

			if (counter <= 2) {
				headings[counter].setBounds(330, 150 + 150 * counter, 200, 25);
				factorValue[counter].setBounds(330, 180 + 150 * counter, 275, 25);
				importance[counter].setBounds(330, 210 + 150 * counter, 200, 25);
			} else {
				headings[counter].setBounds(650, 150 + 150 * (counter - 3), 200, 25);
				factorValue[counter].setBounds(650, 180 + 150 * (counter - 3), 275, 25);
				importance[counter].setBounds(650, 210 + 150 * (counter - 3), 200, 25);
			}

			accountPanel.add(headings[counter]);
			accountPanel.add(factorValue[counter]);
			accountPanel.add(importance[counter]);

		}

	}

}
