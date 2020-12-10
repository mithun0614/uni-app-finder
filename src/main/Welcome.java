package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Welcome {

	public static JFrame GUI;
	public static JPanel welcomePanel;
	public static JTextField usernameField;
	public static JPasswordField passwordField;

	/**
	 * @wbp.parser.entryPoint
	 * ^^ Allows me to use window builder
	 */
	public static void CreateWelcome() {

		// Create JFrame
		GUI = new JFrame();
		GUI.getContentPane().setBackground(Color.WHITE);
		GUI.setBounds(100, 100, 1152, 648);
		GUI.getContentPane().setLayout(new CardLayout(0, 0));
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create Welcome JPanel
		welcomePanel = new JPanel();
		welcomePanel.setLayout(null);
		GUI.getContentPane().add(welcomePanel);

		// Create title label
		JLabel titleLabel = new JLabel("Welcome to <App Name>");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Georgia", Font.PLAIN, 36));
		titleLabel.setBounds(50, 175, 500, 100);
		welcomePanel.add(titleLabel);

		// Create description label
		JLabel descriptionLabel = new JLabel("<Description Of App>");
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setFont(new Font("Georgia", Font.PLAIN, 24));
		descriptionLabel.setBounds(50, 275, 500, 100);
		welcomePanel.add(descriptionLabel);

		// Create username label
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(725, 100, 80, 25);
		welcomePanel.add(usernameLabel);

		// Create username textbox
		usernameField = new JTextField();
		usernameField.setBounds(725, 150, 300, 25);
		welcomePanel.add(usernameField);

		// Create password label
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(725, 200, 80, 25);
		welcomePanel.add(passwordLabel);

		// Create password textbox
		passwordField = new JPasswordField();
		passwordField.setBounds(725, 250, 300, 25);
		welcomePanel.add(passwordField);

		// Create sign in button
		JButton signInButton = new JButton("Sign In");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				Dashboard.CreateDashboard();
				Dashboard.dashboardPanel.setVisible(true);
			}
		});
		signInButton.setBounds(725, 300, 300, 30);
		welcomePanel.add(signInButton);

		// Create create account button
		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomePanel.setVisible(false);
				Dashboard.CreateDashboard();
				Dashboard.dashboardPanel.setVisible(true);
			}
		});
		createAccountButton.setBounds(725, 350, 300, 30);
		welcomePanel.add(createAccountButton);

		// Create help button
		JButton helpButton = new JButton("Help");
		helpButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		helpButton.setBounds(725, 450, 140, 30);
		welcomePanel.add(helpButton);

		// Create quit button
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		quitButton.setBounds(885, 450, 140, 30);
		welcomePanel.add(quitButton);

	}
}
