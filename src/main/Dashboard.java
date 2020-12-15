package main;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Dashboard extends JPanel {

	public static JPanel dashboardPanel;
	public static JPanel taskbarPanel;
	public static JPanel displayPanel;

	public static void CreateDashboard() {

		// Create dashboard panel
		dashboardPanel = new JPanel();
		Welcome.GUI.getContentPane().add(dashboardPanel);
		dashboardPanel.setLayout(null);
		
		// Create taskbar panel
		taskbarPanel = new JPanel();
		taskbarPanel.setBounds(0, 0, 210, 610);
		dashboardPanel.add(taskbarPanel);
		taskbarPanel.setLayout(null);

		// Create display panel
		displayPanel = new JPanel();
		displayPanel.setBounds(210, 0, 920, 610);
		dashboardPanel.add(displayPanel);
		displayPanel.setLayout(new CardLayout(0, 0));

		// Create introduction panel
		JPanel introPanel = new JPanel();
		displayPanel.add(introPanel);
		introPanel.setLayout(null);

		// Create logo label
		JLabel logoLabel = new JLabel("Logo");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setBounds(0, 20, 210, 35);
		taskbarPanel.add(logoLabel);

		// Create taskbar buttons
		JButton uniInfoButton = new JButton("University Information");
		uniInfoButton.setBounds(25, 115, 160, 25);
		taskbarPanel.add(uniInfoButton);

		JButton accountButton = new JButton("My Account");
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introPanel.setVisible(false);
				Results.resultsPanel.setVisible(false);
				Account.accountPanel.setVisible(true);
			}
		});
		accountButton.setBounds(25, 180, 160, 25);
		taskbarPanel.add(accountButton);

		JButton quizButton = new JButton("Take Quiz");
		quizButton.setBounds(25, 240, 160, 25);
		taskbarPanel.add(quizButton);

		JButton resultsButton = new JButton("View Results");
		resultsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introPanel.setVisible(false);
				Account.accountPanel.setVisible(false);
				Results.resultsPanel.setVisible(true);
			}
		});
		resultsButton.setBounds(25, 300, 160, 25);
		taskbarPanel.add(resultsButton);

		JButton helpButton2 = new JButton("Help");
		helpButton2.setBounds(45, 500, 120, 25);
		taskbarPanel.add(helpButton2);

		JButton signOutButton = new JButton("Sign Out");
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(false);
				Welcome.welcomePanel.setVisible(true);
			}
		});
		signOutButton.setBounds(45, 550, 120, 25);
		taskbarPanel.add(signOutButton);

		// Create intro screen
		JLabel titleLabel2 = new JLabel("App Name");
		titleLabel2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		titleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel2.setBounds(0, 30, 925, 90);
		introPanel.add(titleLabel2);

		JLabel quoteLabel = new JLabel("Quote");
		quoteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quoteLabel.setBounds(0, 155, 925, 75);
		introPanel.add(quoteLabel);

		JLabel creatorLabel = new JLabel("Created By:");
		creatorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		creatorLabel.setBounds(20, 550, 895, 60);
		introPanel.add(creatorLabel);

		// Create all other screens
		AccountEdit.EditAccount();
		Account.CreateAccount();
		Results.CreateResults();

	}


}
