package main;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Results extends JPanel {

	public static JPanel resultsPanel;
	private static JLabel[] nameLabel = new JLabel[3];
	private static JLabel[] admissionLabel = new JLabel[3];
	private static JLabel[] coursesLabel = new JLabel[3];
	private static JLabel[] tuitionLabel = new JLabel[3];
	private static JLabel[] distanceLabel = new JLabel[3];

	public static void CreateResults() {

		// Create results panel
		resultsPanel = new JPanel();
		Dashboard.displayPanel.add(resultsPanel);
		resultsPanel.setLayout(null);
		resultsPanel.setVisible(true);

		// Create title label
		JLabel titleLabel = new JLabel("Application Name/Logo");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 29, 926, 81);
		resultsPanel.add(titleLabel);

		// Create caption label
		JLabel captionLabel = new JLabel("Your Results");
		captionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		captionLabel.setBounds(0, 121, 926, 25);
		resultsPanel.add(captionLabel);

		// Create description label
		JLabel descriptionLabel = new JLabel("Based on your answers, the following programs are best suited for you");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setBounds(0, 157, 926, 25);
		resultsPanel.add(descriptionLabel);

		// Add university info label
		for (int x = 0; x < nameLabel.length; x++) {

			nameLabel[x] = new JLabel("#" + (x + 1) + " Institution Name: ");
			nameLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			nameLabel[x].setBounds(30 + 300 * x, 220, 150, 25);
			resultsPanel.add(nameLabel[x]);

			admissionLabel[x] = new JLabel("Admission Average: ");
			admissionLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			admissionLabel[x].setBounds(30 + 300 * x, 290, 150, 25);
			resultsPanel.add(admissionLabel[x]);

			coursesLabel[x] = new JLabel("Courses Required: ");
			coursesLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			coursesLabel[x].setBounds(30 + 300 * x, 360, 150, 25);
			resultsPanel.add(coursesLabel[x]);

			distanceLabel[x] = new JLabel("Distance: ");
			distanceLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			distanceLabel[x].setBounds(30 + 300 * x, 430, 150, 25);
			resultsPanel.add(distanceLabel[x]);

			tuitionLabel[x] = new JLabel("Tuition (Annually): ");
			tuitionLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			tuitionLabel[x].setBounds(30 + 300 * x, 500, 150, 25);
			resultsPanel.add(tuitionLabel[x]);

		}

	}

}
