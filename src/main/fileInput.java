package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileInput {

    public static String[] names = new String[14];
    public static String[] overallAverages = new String[14];
    public static double[] intOverallAverages = new double[14];
    public fileInput() {


        Scanner input;


        try {
            input = new Scanner(new File("uni-app-finder/resources/dataTables/(CSV) Secondary School Averages 2016.csv"));
            input.useDelimiter(",");
            int index = 0;
            int arrayIndex = 0;
            int overallAveragesArrayIndex = 0;
            while (input.hasNext()) {
                String value = input.next();
                if (index % 9 == 0) {
                    names[arrayIndex] = value;
                    arrayIndex++;
                }
                if (index % 9 == 8) {
                    overallAverages[overallAveragesArrayIndex] = value;
                    overallAveragesArrayIndex++;
                }

                index++;
            }
            input.close();
            for (String name : names) {
                System.out.print(name + " ");
            }
            for(int i = 0; i < 14; i++) {
                intOverallAverages[i] = Double.parseDouble(overallAverages[i]);
            }

        } catch (FileNotFoundException e) { //Safety Check
            System.out.println("FILE ERROR");
        }
    }
}
