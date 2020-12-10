package guiClasses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPanelGUI extends JFrame implements ActionListener {
    public static JButton button = new JButton("Continue");
    public static JLabel title = new JLabel("All Progrmas");
    public static JButton[] btn = new JButton[7];
    public static JComboBox<String> combobox1 = new JComboBox<>();
    public static String[] names = new String[]{"Waterloo","Hello","UofT"};

    String[] sorting = new String[]{"A-Z","Z-A","UofT"};
int index = 0;
String info;
    JComboBox<String> combobox2 = new JComboBox<>();
    public static int numCards;
    public MainPanelGUI() {
        setSize(700,700);
        setLayout(null);

        for (String name : names) {
            combobox1.addItem(name);
        }


        combobox1.setBounds(300,300, 100, 50);
        combobox1.addActionListener(this);
        combobox1.setVisible(true);
        add(combobox1);

        for (String sorting : sorting) {
            combobox2.addItem(sorting);
        }
        combobox2.setBounds(300,400, 100, 50);
        combobox2.addActionListener(this);
        combobox2.setVisible(true);
        add(combobox2);


        title.setBounds(288,200,200,50);
        add(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Override Method
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == combobox2) {
            JComboBox cb = (JComboBox)event.getSource();
            System.out.println(cb.getSelectedIndex());

            if (cb.getSelectedIndex() == 1) {
                reverse();
                for (int i = 0; i < names.length; i++) {
                    System.out.println(names[i]);
                }

                JPanel uniPanel;
                uniPanel = createUniPanel(names[index], info);
                uniPanel.setBounds(0,0,400,400);
                add(uniPanel);
                uniPanel.setVisible(true);

            }
        }

    }

    static void reverse() {
        String[] temp = new String[names.length];

        for (int i = 0; i< names.length; i++) {
            temp[names.length - i-1] = names[i];
        }
        names = temp;
    }

    public static JPanel createUniPanel(String name, String info) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(400,400);
        JLabel nameLabel = new JLabel(name);
        JLabel infoLabel = new JLabel(info);

        nameLabel.setBounds(100,0,50,50);
        infoLabel.setBounds(100,100,200,200);
        panel.add(nameLabel);
        panel.add(infoLabel);

        return panel;

    }


}