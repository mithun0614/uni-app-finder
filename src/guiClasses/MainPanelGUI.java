package guiClasses;

import main.UniversitiesInformation;
import main.University;
import main.fileInput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MainPanelGUI extends JFrame implements ActionListener {
    public static JLabel title = new JLabel("All Programs");
    public static JButton nextBtn = new JButton();
    public static JButton backBtn = new JButton();
    public static JComboBox<String> combobox1 = new JComboBox<>();
    public static String[] names = fileInput.names;
    public static double[] overallAverages = fileInput.intOverallAverages;
    public static String[] namesSortedAverage = names;
    public static String[] arrayToUse = names;
    public static int currentIndex = 0;
    public static int currentPage = 0;
    public static boolean reversed = false;
    String[] sorting = new String[]{"A-Z", "Z-A", "Average: Low to High", "Average: High to Low"};
    int index = 0;
    String info = "insert info about uni dashodiahsdoiashdoiashdas";
    JPanel uniPanel;
    JComboBox<String> combobox2 = new JComboBox<>();
    public static int numCards;

    public MainPanelGUI() {
        UniversitiesInformation.setUniversities();
        insertionSort();
        for (double x : overallAverages) {
            System.out.println(x);
        }
        for (String x : namesSortedAverage) {
            System.out.println(x);
        }


        setSize(700, 700);
        setLayout(null);


        uniPanel = createUniPanel(UniversitiesInformation.universities.get(0).getName(), info);
        uniPanel.setBounds(0, 0, 400, 400);
        add(uniPanel);
        uniPanel.setVisible(true);

        for (String name : names) {
            combobox1.addItem(name);
        }


        combobox1.setBounds(400, 100, 200, 50);
        combobox1.addActionListener(this);
        combobox1.setVisible(true);
        add(combobox1);

        for (String sorting : sorting) {
            combobox2.addItem(sorting);
        }
        combobox2.setBounds(400, 200, 200, 50);
        combobox2.addActionListener(this);
        combobox2.setVisible(true);
        add(combobox2);


        title.setBounds(400, 0, 200, 50);
        add(title);

        nextBtn.setText("Next");
        nextBtn.setBounds(400, 500, 100, 50);
        nextBtn.addActionListener(this);
        nextBtn.setVisible(true);
        add(nextBtn);

        backBtn.setText("Back");
        backBtn.setBounds(500, 500, 100, 50);
        backBtn.addActionListener(this);
        backBtn.setVisible(true);
        add(backBtn);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Override Method
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == combobox2) {
            System.out.println(combobox2.getSelectedIndex());

            if (combobox2.getSelectedIndex() == 1) {
                if (!(currentIndex == 1)) {
                    reverse();
                    reversed = true;
                }
                for (int i = 0; i < names.length; i++) {
                }
                currentIndex = 1;
                arrayToUse = names;
            }
            if (combobox2.getSelectedIndex() == 0) {
                if (currentIndex != 0) {
                    reversed = false;
                    reverse();
                }
                currentIndex = 0;
                arrayToUse = names;
            }

            if (combobox2.getSelectedIndex() == 2) {
                if (currentIndex!= 2) {
                    arrayToUse = namesSortedAverage;
                    currentIndex = 2;
                }
            }


            remove(uniPanel);
            uniPanel = createUniPanel(arrayToUse[combobox2.getSelectedIndex()], info);
            uniPanel.repaint();
            System.out.println(arrayToUse[combobox2.getSelectedIndex()]);
            add(uniPanel);
            uniPanel.setVisible(true);

            repaint();
        }
        int comboboxIndex = combobox1.getSelectedIndex();
        if (reversed) {
            comboboxIndex = 13 - comboboxIndex;
        }

        if (event.getSource() == combobox1) {
            remove(uniPanel);
            uniPanel = createUniPanel(arrayToUse[comboboxIndex], info);
            System.out.println(arrayToUse[comboboxIndex]);

            currentPage = comboboxIndex;
            uniPanel.repaint();
            uniPanel.setVisible(true);
            add(uniPanel);

            repaint();
        }

        if (event.getSource() == nextBtn) {
            System.out.println("button");

            currentPage += 1;
            if (currentPage== 14) {
                currentPage = 0;
            }
            System.out.println(currentPage);
            remove(uniPanel);
            uniPanel = createUniPanel(arrayToUse[currentPage], info);

            System.out.println(namesSortedAverage[currentPage]);
            for (String x : arrayToUse) {
                System.out.println(x);
            }

            uniPanel.setVisible(true);
            add(uniPanel);

            repaint();
        }

        if (event.getSource() == backBtn) {
            System.out.println("button");

            currentPage -= 1;
            if (currentPage == -1) {
                currentPage = 13;
            }
            remove(uniPanel);
            uniPanel = createUniPanel(arrayToUse[currentPage], info);


            uniPanel.setVisible(true);
            add(uniPanel);

            repaint();
        }




    }


    static void reverse() {
        String[] temp = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            temp[names.length - i - 1] = names[i];
        }
        names = temp;
    }

    static void reverseAverages() {
        double[] temp = new double[overallAverages.length];

        for (int i = 0; i < overallAverages.length; i++) {
            temp[overallAverages.length - i - 1] = overallAverages[i];
        }
        overallAverages = temp;
    }

    static void reverseNameAverages() {
        String[] temp = new String[namesSortedAverage.length];

        for (int i = 0; i < namesSortedAverage.length; i++) {
            temp[namesSortedAverage.length - i - 1] = namesSortedAverage[i];
        }
        namesSortedAverage = temp;
    }

    public static JPanel createUniPanel(String name, String info) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(150, 150);
        JLabel nameLabel = new JLabel(name);
        JLabel infoLabel = new JLabel(info);

        nameLabel.setBounds(0, 0, 150, 50);
        infoLabel.setBounds(0, 50, 150, 100);
        panel.add(nameLabel);
        panel.add(infoLabel);

        return panel;

    }

    public static void insertionSort() {
        //Runs for every index of the array except the first
        for (int x = 1; x < UniversitiesInformation.universities.size(); x++) {
            /* In the for loop below it will...
             * take the value in the index x (which is one greater in each iteration)
             * and continue to "shift" it until the value is greater than the value of the contents in index y
             * thus moving it into its sorted place in the array
             */
            for (int y = x - 1; y >= 0; y--) {
                if (UniversitiesInformation.universities.get(x).getAverage() < UniversitiesInformation.universities.get(y).getAverage()) {
                    swap(UniversitiesInformation.universities, x--, y);
                } else {
                    break;
                }
            }
        }
    }


    private static void swap(ArrayList<University> universities, int x, int smallest) {
        University temp = universities.get(x);
        universities.set(x, universities.get(smallest));
        universities.set(smallest, temp);
    }
    private static void swap(String[] data, int x, int smallest) {
        String temp = data[x];
        data[x] = data[smallest];
        data[smallest] = temp;
    }

}