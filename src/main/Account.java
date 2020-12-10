package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Account extends JPanel {

	public static JPanel accountPanel;
	private static JLabel[] personsLabel = new JLabel[2];
	private static JLabel[] captionLabel = new JLabel[2];
	private static JLabel[] courseLabel = new JLabel[6];
	private static JLabel[] proximityLabel = new JLabel[2];
	private static JLabel[] tuitionLabel = new JLabel[2];
	private static JLabel[] cultureLabel = new JLabel[2];
	private static JLabel[] sizeLabel = new JLabel[2];
	private static JButton[] editButton = new JButton[2];

	public static void CreateAccount() {

		// Create account panel
		accountPanel = new JPanel();
		Dashboard.displayPanel.add(accountPanel);
		accountPanel.setLayout(null);
		accountPanel.setVisible(true);

		// Create title label
		for (int counter = 0; counter < personsLabel.length; counter++) {
			personsLabel[counter] = new JLabel(Welcome.usernameField.getText() + "'s Account");
			personsLabel[counter].setFont(new Font("Tahoma", Font.PLAIN, 20));
			personsLabel[counter].setBounds(50, 30, 280, 65);

			if (counter == 0)
				accountPanel.add(personsLabel[counter]);
			else
				AccountEdit.accountEditPanel.add(personsLabel[counter]);
		}

		// Create caption
		for (int counter = 0; counter < captionLabel.length; counter++) {
			captionLabel[counter] = new JLabel("Courses and Grades");
			captionLabel[counter].setFont(new Font("Tahoma", Font.PLAIN, 20));
			captionLabel[counter].setBounds(30, 130, 280, 65);

			if (counter == 0)
				accountPanel.add(captionLabel[counter]);
			else
				AccountEdit.accountEditPanel.add(captionLabel[counter]);
		}

		// Create edit button
		for (int counter = 0; counter < editButton.length; counter++) {
			editButton[counter] = new JButton("Edit");
			editButton[counter].setFont(new Font("Tahoma", Font.PLAIN, 16));
			editButton[counter].setBounds(750, 50, 100, 25);

			if (counter == 0) {
				accountPanel.add(editButton[counter]);

				editButton[counter].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						accountPanel.setVisible(false);
						AccountEdit.accountEditPanel.setVisible(true);
					}
				});
			} else {
				AccountEdit.accountEditPanel.add(editButton[counter]);

				editButton[counter].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AccountEdit.accountEditPanel.setVisible(false);
						CreateAccount();
						accountPanel.setVisible(true);
					}
				});
			}
		}

		// Create courses and grades label
		for (int counter = 0; counter < courseLabel.length; counter++) {
			courseLabel[counter] = new JLabel((counter + 1) + ". " + AccountEdit.courseTextField[counter].getText()
					+ " - " + AccountEdit.gradeTextField[counter].getText() + "%");
			courseLabel[counter].setFont(new Font("Tahoma", Font.PLAIN, 16));
			courseLabel[counter].setBounds(30, 210 + 50 * counter, 200, 40);
			accountPanel.add(courseLabel[counter]);
		}

		// Create proximity label
		for (int counter = 0; counter < proximityLabel.length; counter++) {
			proximityLabel[counter] = new JLabel("Proximity:");
			proximityLabel[counter].setFont(new Font("Tahoma", Font.PLAIN, 20));
			proximityLabel[counter].setBounds(330, 150, 150, 25);

			if (counter == 0)
				accountPanel.add(proximityLabel[counter]);
			else
				AccountEdit.accountEditPanel.add(proximityLabel[counter]);
		}

		// Create tuition label
		for (int counter = 0; counter < tuitionLabel.length; counter++) {
			tuitionLabel[counter] = new JLabel("Tuition:");
			tuitionLabel[counter].setFont(new Font("Tahoma", Font.PLAIN, 20));
			tuitionLabel[counter].setBounds(650, 150, 75, 25);

			if (counter == 0)
				accountPanel.add(tuitionLabel[counter]);
			else
				AccountEdit.accountEditPanel.add(tuitionLabel[counter]);
		}

		// Create culture label
		for (int counter = 0; counter < cultureLabel.length; counter++) {
			cultureLabel[counter] = new JLabel("Culture:");
			cultureLabel[counter].setFont(new Font("Tahoma", Font.PLAIN, 20));
			cultureLabel[counter].setBounds(330, 290, 75, 25);

			if (counter == 0)
				accountPanel.add(cultureLabel[counter]);
			else
				AccountEdit.accountEditPanel.add(cultureLabel[counter]);
		}

		// Create university size label
		for (int counter = 0; counter < sizeLabel.length; counter++) {
			sizeLabel[counter] = new JLabel("Univeristy Size:");
			sizeLabel[counter].setFont(new Font("Tahoma", Font.PLAIN, 20));
			sizeLabel[counter].setBounds(650, 290, 150, 25);

			if (counter == 0)
				accountPanel.add(sizeLabel[counter]);
			else
				AccountEdit.accountEditPanel.add(sizeLabel[counter]);
		}

		JLabel proximityValueLabel = new JLabel("Selected: " + AccountEdit.dropDownLists[0].getSelectedItem());
		proximityValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		proximityValueLabel.setBounds(330, 200, 200, 30);
		accountPanel.add(proximityValueLabel);

		JLabel tuitionValueLabel = new JLabel("~ $" + AccountEdit.sliders[0].getValue());
		tuitionValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tuitionValueLabel.setBounds(655, 200, 150, 30);
		accountPanel.add(tuitionValueLabel);

		JLabel cultureValueLabel = new JLabel("Selected: " + AccountEdit.dropDownLists[1].getSelectedItem());
		cultureValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cultureValueLabel.setBounds(330, 340, 150, 30);
		accountPanel.add(cultureValueLabel);

		JLabel uniSizeValueLabel = new JLabel("~ " + AccountEdit.sliders[1].getValue() + " Students");
		uniSizeValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		uniSizeValueLabel.setBounds(655, 340, 150, 30);
		accountPanel.add(uniSizeValueLabel);

	}

}
