package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Welcome {

	private JFrame GUI;
	private JPasswordField passwordField;
	private JTextField usernameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.GUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GUI = new JFrame();
		GUI.getContentPane().setBackground(Color.WHITE);
		GUI.setBackground(Color.WHITE);
		GUI.setBounds(100, 100, 600, 600);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel welcomePanel = new JPanel();
		GUI.getContentPane().add(welcomePanel, "name_211259512205400");
		welcomePanel.setLayout(null);

		JPanel signInPanel = new JPanel();
		GUI.getContentPane().add(signInPanel, "name_211303562859000");
		signInPanel.setLayout(null);

		JPanel dashboardPanel = new JPanel();
		GUI.getContentPane().add(dashboardPanel, "name_212157125978200");
		dashboardPanel.setLayout(null);

		JLabel titleLabel = new JLabel("Welcome to app name");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Georgia", Font.PLAIN, 48));
		titleLabel.setBounds(0, 91, 584, 60);
		welcomePanel.add(titleLabel);

		JLabel descriptionLabel = new JLabel("Description of app");
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setFont(new Font("Georgia", Font.PLAIN, 24));
		descriptionLabel.setBounds(0, 191, 584, 149);
		welcomePanel.add(descriptionLabel);

		JButton quitButton = new JButton("Quit\r\n");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		quitButton.setBounds(325, 411, 125, 30);
		welcomePanel.add(quitButton);

		JButton helpButton = new JButton("Help");
		helpButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		helpButton.setBounds(125, 411, 125, 30);
		welcomePanel.add(helpButton);

		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInPanel.setVisible(true);
				welcomePanel.setVisible(false);
			}
		});

		continueButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		continueButton.setBounds(192, 351, 200, 30);
		welcomePanel.add(continueButton);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(50, 50, 100, 25);
		signInPanel.add(usernameLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(50, 150, 100, 25);
		signInPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(50, 200, 160, 25);
		signInPanel.add(passwordField);

		usernameField = new JTextField();
		usernameField.setBounds(50, 100, 160, 25);
		signInPanel.add(usernameField);
		usernameField.setColumns(10);

		JButton signInButton = new JButton("Sign In");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardPanel.setVisible(true);
				signInPanel.setVisible(false);
			}
		});
		signInButton.setBounds(50, 250, 100, 25);
		signInPanel.add(signInButton);

		JButton createAccountButton = new JButton("Create an account");
		createAccountButton.setBounds(100, 400, 150, 25);
		signInPanel.add(createAccountButton);

		JButton quitButton2 = new JButton("Quit");
		quitButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitButton2.setBounds(350, 400, 125, 25);
		signInPanel.add(quitButton2);

		JPanel taskbarPanel = new JPanel();
		taskbarPanel.setBounds(0, 0, 150, 561);
		dashboardPanel.add(taskbarPanel);
		taskbarPanel.setLayout(null);

		JLabel logoLabel = new JLabel("Logo");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setBounds(46, 25, 46, 14);
		taskbarPanel.add(logoLabel);

		JButton accountButton = new JButton("My Account");
		accountButton.setBounds(10, 180, 130, 23);
		taskbarPanel.add(accountButton);

		JButton quizButton = new JButton("Take Quiz");
		quizButton.setBounds(10, 240, 130, 23);
		taskbarPanel.add(quizButton);

		JButton resultsButton = new JButton("View Results");
		resultsButton.setBounds(10, 300, 130, 23);
		taskbarPanel.add(resultsButton);

		JButton helpButton2 = new JButton("Help");
		helpButton2.setBounds(30, 450, 89, 23);
		taskbarPanel.add(helpButton2);

		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(30, 500, 89, 23);
		taskbarPanel.add(signOutButton);
		
		JButton uniInfoButton = new JButton("University Info");
		uniInfoButton.setBounds(10, 120, 130, 23);
		taskbarPanel.add(uniInfoButton);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setBounds(149, 0, 435, 561);
		dashboardPanel.add(displayPanel);
		displayPanel.setLayout(new CardLayout(0, 0));
		
		JPanel introPanel = new JPanel();
		displayPanel.add(introPanel, "name_145715419535900");
		introPanel.setLayout(null);
		
		JLabel titleLabel2 = new JLabel("App Name");
		titleLabel2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		titleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel2.setBounds(120, 30, 181, 70);
		introPanel.add(titleLabel2);
		
		JLabel quoteLabel = new JLabel("Quote");
		quoteLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		quoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quoteLabel.setBounds(142, 154, 141, 44);
		introPanel.add(quoteLabel);
		
		JLabel creatorLabel = new JLabel("Created By:");
		creatorLabel.setBounds(10, 517, 87, 33);
		introPanel.add(creatorLabel);
		
		JPanel uniInfoPanel = new JPanel();
		displayPanel.add(uniInfoPanel, "name_146038955817600");
		uniInfoPanel.setLayout(null);
		
		JLabel programLabel = new JLabel("All Programs");
		programLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		programLabel.setHorizontalAlignment(SwingConstants.CENTER);
		programLabel.setBounds(115, 22, 195, 64);
		uniInfoPanel.add(programLabel);
		
		JLabel uniLabel = new JLabel("Name of Program");
		uniLabel.setBounds(10, 97, 195, 112);
		uniInfoPanel.add(uniLabel);
		
		JLabel uniLabel2 = new JLabel("Name of Program");
		uniLabel2.setBounds(10, 220, 195, 112);
		uniInfoPanel.add(uniLabel2);
	}
}
