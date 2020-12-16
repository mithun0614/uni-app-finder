package main;

import tools.Colour;

import javax.swing.*;

import java.awt.Font;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Welcome {

	public static JFrame GUI;
	public static JPanel welcomePanel;
	public static JTextField usernameField;
	public static JPasswordField passwordField;

	private static final int SCREEN_WIDTH = 648;
	private static final int SCREEN_HEIGHT = 1152;

	/*
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
		welcomePanel.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		welcomePanel.setLayout(null);
		GUI.getContentPane().add(welcomePanel);

		// Create username label
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setLayout(null);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		usernameLabel.setForeground(Colour.strongHighlight);
		usernameLabel.setBounds(800, 100, 150, 25);
		welcomePanel.add(usernameLabel);

		// Create username textbox
		usernameField = new JTextField();
		usernameField.setLayout(null);
		usernameField.setBounds(725, 150, 300, 25);
		welcomePanel.add(usernameField);

		// Create password label
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordLabel.setForeground(Colour.strongHighlight);
		passwordLabel.setBounds(800, 200, 150, 25);
		welcomePanel.add(passwordLabel);

		// Create password textbox
		passwordField = new JPasswordField();
		passwordField.setBounds(725, 250, 300, 25);
		welcomePanel.add(passwordField);

		// Create sign in button
		JButton signInButton = new JButton("Sign In");
		signInButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (VerifyLogin.verifyLogin(usernameField.getText(), String.valueOf(passwordField.getPassword()))) {
					welcomePanel.setVisible(false);
					Dashboard.CreateDashboard();
					Dashboard.dashboardPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(welcomePanel, "Invalid Login");
				}
			}
		});
		signInButton.setForeground(Colour.strongHighlight);
		signInButton.setBackground(Colour.lightBg);
		signInButton.setBorderPainted(false);
		signInButton.setFocusPainted(false);
		signInButton.setBounds(725, 300, 300, 30);
		welcomePanel.add(signInButton);

		// Create create account button
		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAccount();
				
			}
		});
		createAccountButton.setForeground(Colour.highlight);
		createAccountButton.setBackground(Colour.strike);
		createAccountButton.setBorderPainted(false);
		createAccountButton.setFocusPainted(false);
		createAccountButton.setBounds(725, 350, 300, 30);
		welcomePanel.add(createAccountButton);

		// Create help button
		JButton helpButton = new JButton("Help");
		helpButton.setFont(new Font("Georgia", Font.BOLD, 16));
		helpButton.setBounds(725, 450, 140, 30);
		helpButton.setForeground(Colour.strongHighlight);
		helpButton.setBackground(Colour.lightBg);
		helpButton.setBorderPainted(false);
		helpButton.setFocusPainted(false);
		welcomePanel.add(helpButton);

		// Create quit button
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitButton.setFont(new Font("Georgia", Font.BOLD, 16));
		quitButton.setBounds(885, 450, 140, 30);
		quitButton.setForeground(Colour.strongHighlight);
		quitButton.setBackground(Colour.lightBg);
		quitButton.setBorderPainted(false);
		quitButton.setFocusPainted(false);
		welcomePanel.add(quitButton);


		ImageIcon welcomeScreen = new ImageIcon("./resources/misc/welcome-screen.png"); //illustrator made image twice as big

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(welcomeScreen.getImage().getScaledInstance(welcomeScreen.getIconWidth()/2, welcomeScreen.getIconHeight()/2, 0)));
		logo.setBounds(0, 0, welcomeScreen.getIconWidth()/2, welcomeScreen.getIconHeight()/2);
		welcomePanel.add(logo);
		GUI.repaint();
	}
}
