package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SurveyResults {
	
	static JFrame f;
	static JPanel surveyResults;
	
	public static void SurveyResults() {
		
		surveyResults = new JPanel();
		surveyResults.setLayout(null);
		f = new JFrame ("Survey Results");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Results");
		title.setBounds(50, 0, 200, 200);
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		title.setForeground(new Color(255, 138, 226));
		surveyResults.add(title);
		
		surveyResults.setBackground(new Color(24, 61, 93));
		
		JButton progressButton = new JButton("Exit");
		progressButton.setBounds(950, 500, 100, 50);
		progressButton.setBackground(new Color(7, 37, 64));
		progressButton.setForeground(new Color(255, 138, 226));
		surveyResults.add(progressButton);
		progressButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == progressButton) {
					f.dispose();
				}
			}
		});
		
		
		if (surveyScreen.calculateResults() == "Aerospace Engineer") {
			JLabel aerospaceengineer = new JLabel("You got Aerospace Engineer!");
			aerospaceengineer.setBounds(675, 125, 450, 50);
			aerospaceengineer.setForeground(new Color(255, 138, 226));
			aerospaceengineer.setFont(new Font("Serif", Font.PLAIN, 30));
			surveyResults.add(aerospaceengineer);
			displayAerospace();
		}
		else if (surveyScreen.calculateResults() == "Civil Engineer") {
			JLabel civilengineer = new JLabel("You got Civil Engineer!");
			civilengineer.setForeground(new Color(255, 138, 226));
			civilengineer.setBounds(675, 125, 450, 50);
			civilengineer.setFont(new Font("Serif", Font.PLAIN, 20));
			surveyResults.add(civilengineer);
			displayCivil();
		}
		else if (surveyScreen.calculateResults() == "Software Engineer") {
			JLabel softwareengineer = new JLabel("You got Software Engineer!");
			softwareengineer.setBounds(675, 125, 450, 50);
			softwareengineer.setForeground(new Color(255, 138, 226));
			softwareengineer.setFont(new Font("Serif", Font.PLAIN, 20));
			surveyResults.add(softwareengineer);
			displaySoftware();
		}
		else if (surveyScreen.calculateResults() == "Mechanical Engineer") {
			JLabel mechanicalengineer = new JLabel("You got Mechanical Engineer!");
			mechanicalengineer.setBounds(675, 125, 450, 50);
			mechanicalengineer.setForeground(new Color(255, 138, 226));
			mechanicalengineer.setFont(new Font("Serif", Font.PLAIN, 20));
			surveyResults.add(mechanicalengineer);
			displayMechanical();
		}
		else if (surveyScreen.calculateResults() == "Electrical Engineer") {
			JLabel electricalengineer = new JLabel("You got Electrical Engineer!");
			electricalengineer.setBounds(675, 125, 450, 50);
			electricalengineer.setForeground(new Color(255, 138, 226));
			electricalengineer.setFont(new Font("Serif", Font.PLAIN, 20));
			surveyResults.add(electricalengineer);
			displayElectrical();
		}
		
		f.add(surveyResults);
		f.setSize(1152, 648);
		f.setVisible(true);
	}
	
	//GIVE CREDIT TO DEFINITION SOURCE (WIKIPEDIA)
	private static void displayAerospace() {
		ImageIcon AEicon = new ImageIcon("types/aerospace.jpg");
		JLabel AE = new JLabel(AEicon);
		AE.setBounds(50, 150, 600, 400);
		surveyResults.add(AE);
		
		JLabel AEdescription = new JLabel("<html>Aerospace Engineering is the primary field of engineering concerned with the development of aircraft and spacecraft. It has two major and overlapping branches: aeronautical engineering and astronautical engineering</html>");
		AEdescription.setBounds(675, 155, 400, 300);
		AEdescription.setFont(new Font("Serif", Font.PLAIN, 25));
		AEdescription.setForeground(new Color(255, 138, 226));
		surveyResults.add(AEdescription);
	}
	
	private static void displayCivil() {
		ImageIcon CEicon = new ImageIcon("types/civil.jpg");
		JLabel CE = new JLabel(CEicon);
		CE.setBounds(50, 150, 600, 400);
		surveyResults.add(CE);
		
		JLabel CEdescription = new JLabel("<html>Civil engineering is a professional engineering discipline that deals with the design, construction, and maintenance of the physical and naturally built environment, including public works such as roads, bridges, canals, dams, airports, sewerage systems, pipelines, structural components of buildings, and railways</html>");
		CEdescription.setBounds(675, 155, 400, 300);
		CEdescription.setFont(new Font("Serif", Font.PLAIN, 25));
		CEdescription.setForeground(new Color(255, 138, 226));
		surveyResults.add(CEdescription);
	}
	
	private static void displaySoftware() {
		ImageIcon SEicon = new ImageIcon("types/software.jpg");
		JLabel SE = new JLabel(SEicon);
		SE.setBounds(50, 150, 600, 400);
		surveyResults.add(SE);
		
		JLabel SEdescription = new JLabel("<html>Software engineering is the systematic application of engineering approaches to the development of software. Software engineering is a computing discipline.</html>");
		SEdescription.setBounds(675, 155, 400, 300);
		SEdescription.setFont(new Font("Serif", Font.PLAIN, 25));
		SEdescription.setForeground(new Color(255, 138, 226));
		surveyResults.add(SEdescription);
	}
	
	private static void displayMechanical() {
		ImageIcon MEicon = new ImageIcon("types/mechanical.jpg");
		JLabel ME = new JLabel(MEicon);
		ME.setBounds(50, 150, 600, 400);
		surveyResults.add(ME);
		
		JLabel MEdescription = new JLabel("<html>Mechanical Engineering includes design engineering, renewable energy, developing medical diagnostic devices, advanced manufacturing and materials, robotics and automation.</html>");
		MEdescription.setBounds(675, 155, 400, 300);
		MEdescription.setFont(new Font("Serif", Font.PLAIN, 25));
		MEdescription.setForeground(new Color(255, 138, 226));
		surveyResults.add(MEdescription);
	}
	
	private static void displayElectrical() {
		ImageIcon EEicon = new ImageIcon("types/electrical.jpg");
		JLabel EE = new JLabel(EEicon);
		EE.setBounds(50, 150, 600, 400);
		surveyResults.add(EE);
		
		JLabel EEdescription = new JLabel("<html>Electrical engineers design, develop, test and manage the manufacturing of electrical equipment, from electric motors and navigation systems to power generation equipment and the electrical components of vehicles and personal devices.</html>");
		EEdescription.setBounds(675, 155, 400, 300);
		EEdescription.setFont(new Font("Serif", Font.PLAIN, 25));
		EEdescription.setForeground(new Color(255, 138, 226));
		surveyResults.add(EEdescription);
	}

}
