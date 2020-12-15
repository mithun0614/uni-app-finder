package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import objects.UniversitiesInformation;

public class Results extends JPanel {

	public static JPanel resultsPanel;
	private static JLabel[] nameLabel = new JLabel[2];
	private static JLabel[] admissionLabel = new JLabel[2];
	private static JLabel[] tuitionLabel = new JLabel[2];
	private static JLabel[] distanceLabel = new JLabel[2];

	public static void CreateResults() {

		// Create results panel
		resultsPanel = new JPanel();
		Dashboard.displayPanel.add(resultsPanel);
		resultsPanel.setLayout(null);
		resultsPanel.setVisible(true);

		// Create title label
		JLabel titleLabel = new JLabel("Application Name/Logo");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(250, 10, 400, 65);
		resultsPanel.add(titleLabel);

		// Create caption label
		JLabel captionLabel = new JLabel("Your Results");
		captionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		captionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		captionLabel.setBounds(250, 65, 400, 25);
		resultsPanel.add(captionLabel);

		// Create description label
		JLabel descriptionLabel = new JLabel("Based on your answers, the following programs are best suited for you");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setBounds(200, 100, 500, 25);
		resultsPanel.add(descriptionLabel);

		// Create back button
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		backButton.setBounds(30, 30, 100, 30);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultsPanel.setVisible(false);
				UniMatchmaker.accountPanel.setVisible(true);
			}
		});
		resultsPanel.add(backButton);

		MatchmakingAlgorithm.Matchmaker();

		int[] num = new int[2];
		num[0] = MatchmakingAlgorithm.greatest;
		num[1] = MatchmakingAlgorithm.secondGreatest;

		String[] uni = new String[2];
		uni[0] = UniversitiesInformation.universities.get(num[0]).getName();
		uni[1] = UniversitiesInformation.universities.get(num[1]).getName();

		// Add university info label
		for (int x = 0; x < nameLabel.length; x++) {

			nameLabel[x] = new JLabel("#" + (x + 1) + " Institution Name: " + uni[x]);
			nameLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			nameLabel[x].setBounds(30 + 450 * x, 150, 150, 25);
			resultsPanel.add(nameLabel[x]);

			admissionLabel[x] = new JLabel("Cutoff Average:");
			admissionLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			admissionLabel[x].setBounds(30 + 450 * x, 220, 150, 25);
			resultsPanel.add(admissionLabel[x]);

			distanceLabel[x] = new JLabel("Distance:");
			distanceLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			distanceLabel[x].setBounds(30 + 450 * x, 290, 150, 25);
			resultsPanel.add(distanceLabel[x]);

			tuitionLabel[x] = new JLabel("Tuition (Annually):");
			tuitionLabel[x].setFont(new Font("Tahoma", Font.PLAIN, 14));
			tuitionLabel[x].setBounds(30 + 450 * x, 360, 150, 25);
			resultsPanel.add(tuitionLabel[x]);

		}

	}

}
