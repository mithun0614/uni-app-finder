package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversitiesInformation {
	public static String[] names = new String[14];
	public static double[] overallAverages = new double[14];
	public static double[] cutoff = new double[14];
	public static int[] tuition = new int[14];
	public static int[] classSize = new int[14];
	public static double[] longitude = new double[14];
	public static double[] latitude = new double[14];
	public static ArrayList<University> universities = new ArrayList<>(14);

	// Reads information from Universities.txt, and creates University objects for
	// each University.
	// Stores each instance in an ArrayList.

	public static void setUniversities() {
		int index = 0;
		int nameIndex = 0;
		int overallAvgIndex = 0;
		int cutoffIndex = 0;
		int tuitionIndex = 0;
		int classSizeIndex = 0;
		int longitudeIndex = 0;
		int latitudeIndex = 0;

		Scanner input;

		try {

			input = new Scanner(new File("resources/dataTables/All_Data.csv"));
			input.useDelimiter(",");

			while (input.hasNext()) {

				if (index % 9 == 0) {
					String value = input.next();
					names[nameIndex] = value;
					nameIndex++;
				}
				if (index % 9 == 1) {
					double value = input.nextDouble();
					overallAverages[overallAvgIndex] = value;
					overallAvgIndex++;
				}
				if (index % 9 == 2) {
					double value = input.nextDouble();
					cutoff[cutoffIndex] = value;
					cutoffIndex++;
				}
				if (index % 9 == 3) {
					int value = input.nextInt();
					tuition[tuitionIndex] = value;
					tuitionIndex++;
				}
				if (index % 9 == 4) {
					int value = input.nextInt();
					classSize[classSizeIndex] = value;
					classSizeIndex++;
				}
				if (index % 9 == 5) {
					double value = input.nextDouble();
					longitude[longitudeIndex] = value;
					longitudeIndex++;
				}
				if (index % 9 == 6) {
					double value = input.nextDouble();
					latitude[latitudeIndex] = value;
					latitudeIndex++;
				}

				index++;
			}

			input.close();

			for (int i = 0; i < names.length; i++) {
				universities.add(new University(names[i], overallAverages[i], cutoff[i], tuition[i], classSize[i],
						longitude[i], latitude[i]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not Found :(");
		}
	}
}