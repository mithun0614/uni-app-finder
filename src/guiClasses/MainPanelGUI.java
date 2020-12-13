package guiClasses;

import main.UniversitiesInformation;
import main.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

public class MainPanelGUI extends JFrame implements ActionListener, AdjustmentListener{
    UniversitiesInformation uniClass = new UniversitiesInformation();
    private JLabel title = new JLabel("All Programs");
    private JButton nextBtn = new JButton();
    private JButton backBtn = new JButton();
    private JComboBox<String> combobox1 = new JComboBox<>();
    private JComboBox<String> combobox2 = new JComboBox<>();
    private JLabel sortBy = new JLabel("Sort by:");
    private JLabel picture = new JLabel();
    private ArrayList<University> uniArrayCopy = uniClass.getUniversities();
    private int currentPage = 0;
    private boolean reversed = false;
    private int oldLocation = 0;
    private JTextField keyword = new JTextField();
    private JButton searchButton = new JButton("Search");
    private JLabel searchLabel = new JLabel("Search");
    private JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL,0,1,0,14);
    private String[] sorting = new String[]{"Alpha: A-Z", "Alpha: Z-A", "Average: Low to High", "Average: High to Low"};
    private String info = "insert info about uni ~~this uni was founded in xxxx~~";
    private JPanel uniPanel;

    public MainPanelGUI() {
        setSize(1152, 864);
        setLayout(null);


        uniPanel = createUniPanel(uniArrayCopy.get(0).getName(), info);
        uniPanel.setBounds(800, 0, 400, 300);
        add(uniPanel);
        uniPanel.setVisible(true);

        for (University uni : uniArrayCopy) {
            combobox1.addItem(uni.getName());
        }

        picture.setIcon(new ImageIcon("uni-app-finder/resources/uniPictures/Carleton University.jpg"));
        picture.setBounds(300,300,700,500);
        picture.setVisible(true);
        add(picture);

        combobox1.setBounds(350, 50, 200, 40);
        combobox1.addActionListener(this);
        combobox1.setVisible(true);
        add(combobox1);

        for (String sorting : sorting) {
            combobox2.addItem(sorting);
        }
        combobox2.setBounds(350, 120, 200, 50);
        combobox2.addActionListener(this);
        combobox2.setVisible(true);
        add(combobox2);

        sortBy.setBounds(350,90,100,30);
        sortBy.setVisible(true);
        add(sortBy);

        title.setBounds(350, 0, 200, 50);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        add(title);


        scrollBar.setBounds(565,50,30,120);
        scrollBar.addAdjustmentListener((AdjustmentListener) this);
        add(scrollBar);

        keyword.setBounds(600, 60, 150,40);
        keyword.addActionListener(this);
        add(keyword);

        searchLabel.setBounds(600,30,50,30);
        add(searchLabel);

        searchButton.setBounds(600,100,100,35);
        searchButton.addActionListener(this);
        add(searchButton);

    }

    //Override Method
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == combobox2) {


            if (combobox2.getSelectedIndex() == 0) {            // if its A-Z
                uniArrayCopy = uniClass.getUniversities();
                currentPage = 0;
            }
            else if (combobox2.getSelectedIndex() == 1) {                //if its Z-A
                uniArrayCopy = uniClass.getUniversities();
                reverse();
                currentPage = 0;
            }


            else if (combobox2.getSelectedIndex() == 2 || combobox2.getSelectedIndex() == 3) {                //Low to High, Average
                uniArrayCopy = uniClass.getUniversities();
                insertionSort();
                if (combobox2.getSelectedIndex() == 3) {
                    uniArrayCopy = uniClass.getUniversities();
                    insertionSort();
                    reverse();
                }
                currentPage = 0;
            }


            remove(uniPanel);
            uniPanel = createUniPanel(uniArrayCopy.get(0).getName(), info);
            remove(picture);
            picture.setIcon(new ImageIcon("uni-app-finder/resources/uniPictures/"+uniArrayCopy.get(0).getName()+".jpg"));
            picture.repaint();
            uniPanel.setBounds(800,0,400,300);
            uniPanel.repaint();

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
            uniPanel = createUniPanel(uniArrayCopy.get(comboboxIndex).getName(), info);
            picture.setIcon(new ImageIcon("uni-app-finder/resources/uniPictures/"+ uniArrayCopy.get(comboboxIndex).getName()+" .jpg"));
            picture.setVisible(true);

            picture.repaint();

            uniPanel.setBounds(800,0,500,500);
            currentPage = comboboxIndex;
            uniPanel.repaint();
            uniPanel.setVisible(true);
            add(uniPanel);

            repaint();
        }

        if (event.getSource() == searchButton) {
            String text = keyword.getText();
        }
    }

    public void reverse() {
        ArrayList<University> temp = new ArrayList<University>(14);

        for (int i = uniArrayCopy.size(); i > 0; i--) {
            temp.add(uniArrayCopy.get(i-1));
        }
        uniArrayCopy = temp;
    }


    public JPanel createUniPanel(String name, String info) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(300, 300);
        JLabel nameLabel = new JLabel(name);
        JLabel infoLabel = new JLabel(info);

        nameLabel.setBounds(0, 0, 500, 150);
        nameLabel.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        infoLabel.setBounds(0, 50, 500, 150);
        panel.add(nameLabel);
        panel.add(infoLabel);

        return panel;

    }

    public void insertionSort() {
        //Runs for every index of the array except the first
        for (int x = 1; x < uniArrayCopy.size(); x++) {
            /* In the for loop below it will...
             * take the value in the index x (which is one greater in each iteration)
             * and continue to "shift" it until the value is greater than the value of the contents in index y
             * thus moving it into its sorted place in the array
             */
            for (int y = x - 1; y >= 0; y--) {
                if (uniArrayCopy.get(x).getAverage() < uniArrayCopy.get(y).getAverage()) {
                    swap(uniArrayCopy, x--, y);
                } else {
                    break;
                }
            }
        }

    }


    public void swap(ArrayList<University> universities, int x, int smallest) {
        University temp = universities.get(x);
        universities.set(x, universities.get(smallest));
        universities.set(smallest, temp);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        JLabel temp = new JLabel();
        int difference = e.getValue() - oldLocation;
        oldLocation = e.getValue();
        currentPage += difference;
        if (currentPage== 14) {
            currentPage = 0;
        }
        remove(uniPanel);
        uniPanel = createUniPanel(uniArrayCopy.get(currentPage).getName(), info);
        uniPanel.setBounds(800,0,400,300);
        remove(picture);
        picture = changePicture(uniArrayCopy.get(currentPage).getName());
        System.out.println(uniArrayCopy.get(currentPage).getName()+".jpg");
        picture = temp;
        combobox1.setSelectedItem(uniArrayCopy.get(currentPage).getName());
        combobox1.repaint();
        uniPanel.setVisible(true);

        add(uniPanel);

        repaint();
    }

    public JLabel changePicture(String uniName) {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("uni-app-finder/resources/uniPictures/"+uniName+".jpg"));
        label.setBounds(300,300,700,500);
        label.setVisible(true);
        return label;
    }
}