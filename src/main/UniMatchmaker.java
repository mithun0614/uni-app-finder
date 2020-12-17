package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import guiClasses.MapScreen;
import objects.UniversitiesInformation;
import tools.Colour;

public class UniMatchmaker extends JPanel {

	public static JPanel accountPanel;
	private static JLabel[] courseLabel = new JLabel[6];
	private static JLabel[] headings = new JLabel[6];
	private static JLabel[] factorValue = new JLabel[6];
	private static JLabel[] importance = new JLabel[6];

	public static void CreateAccount() {

		Border border = BorderFactory.createLineBorder(Colour.strongHighlight, 3);

		// Create panel
		accountPanel = new JPanel();
		Dashboard.displayPanel.add(accountPanel);
		accountPanel.setBackground(Colour.bg);
		accountPanel.setLayout(null);
		accountPanel.setVisible(true);

		JPanel coursesPanel = new JPanel();
		coursesPanel.setBounds(10, 90, 300, 510);
		coursesPanel.setBackground(Colour.bg);
		coursesPanel.setLayout(null);
		coursesPanel.setBorder(border);
		accountPanel.add(coursesPanel);

		JPanel externalPanel = new JPanel();
		externalPanel.setBounds(325, 90, 590, 510);
		externalPanel.setBackground(Colour.bg);
		externalPanel.setLayout(null);
		externalPanel.setBorder(border);
		accountPanel.add(externalPanel);

		// Create title
		JLabel titleLabel = new JLabel("Preference University Matchmaker");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		titleLabel.setForeground(Colour.strongHighlight);
		titleLabel.setBounds(200, 10, 500, 65);
		accountPanel.add(titleLabel);

		// Create description
		JLabel descriptionLabel = new JLabel("External Factors:");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		descriptionLabel.setForeground(Colour.strongHighlight);
		descriptionLabel.setBounds(25, 15, 280, 40);
		externalPanel.add(descriptionLabel);

		// Create courses and grades heading
		JLabel courseGradeLabel = new JLabel("Courses and Grades:");
		courseGradeLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		courseGradeLabel.setForeground(Colour.strongHighlight);
		courseGradeLabel.setBounds(25, 15, 280, 40);
		coursesPanel.add(courseGradeLabel);

		// Create edit buttons
		JButton editButton = new JButton("Edit");
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton.setBackground(Colour.strike);
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
		resultsButton.setBackground(Colour.strike);
		resultsButton.setBounds(450, 450, 100, 30);
		resultsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MapScreen.logic) {
					Dashboard.hidePanel();
					Results.CreateResults();
					Results.resultsPanel.setVisible(true);
				} else
					JOptionPane.showMessageDialog(accountPanel,
							"Wait, first go to the view map tab to set your location!");
			}
		});
		externalPanel.add(resultsButton);

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
			courseLabel[counter].setBounds(20, 75 + 75 * counter, 250, 40);
			coursesPanel.add(courseLabel[counter]);

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
				headings[counter].setBounds(25, 80 + 150 * counter, 200, 25);
				factorValue[counter].setBounds(25, 110 + 150 * counter, 275, 25);
				importance[counter].setBounds(25, 140 + 150 * counter, 200, 25);
			} else {
				headings[counter].setBounds(275, 80 + 150 * (counter - 3), 200, 25);
				factorValue[counter].setBounds(275, 110 + 150 * (counter - 3), 275, 25);
				importance[counter].setBounds(275, 140 + 150 * (counter - 3), 200, 25);
			}

			externalPanel.add(headings[counter]);
			externalPanel.add(factorValue[counter]);
			externalPanel.add(importance[counter]);

		}

	}

}
