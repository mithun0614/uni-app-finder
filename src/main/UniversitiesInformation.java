package main;

import objects.UniversityDistance;

import javax.swing.*;
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

	private ArrayList<String> keyWords = new ArrayList<>();

	private ArrayList<String> keyWords = new ArrayList<>();
	private ArrayList<University> universities = new ArrayList<>(14);
	private ArrayList<UniversityDistance[]> distances = new ArrayList<>();

	// Reads information from Universities.txt, and creates University objects for
	// each University.
	// Stores each instance in an ArrayList.
	public UniversitiesInformation() {
		String[] names = new String[14];
		String path = new File("").getAbsolutePath();
		double[] overallAverages = new double[14];
		double[] cutoff = new double[14];
		int[] tuition = new int[14];
		int[] classSize = new int[14];
		double[] longitude = new double[14];
		double[] latitude = new double[14];
		int[] nationalRank = new int[14];
	}

	public static void setUniversities() {
		int index = 0;
		int nameIndex = 0;
		int overallAvgIndex = 0;
		int cutoffIndex = 0;
		int tuitionIndex = 0;
		int classSizeIndex = 0;
		int longitudeIndex = 0;
		int latitudeIndex = 0;
		int nationalRankIndex = 0;
		int descriptionIndex = 0;

		Scanner input;

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
			try {
				=======
						try {
							>>>>>>> 44331e8d4d630f33fc4537fe7c61b6992faaa707

							input = new Scanner(new File(path+"/resources/dataTables/All Data.csv"));
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
								if (index % 9 == 7) {
									int value = input.nextInt();
									nationalRank[nationalRankIndex] = value;
									nationalRankIndex++;
								}

								index++;
							}
							universities.clear();
							for (int i = 0; i < names.length; i++) {
								universities.add(new University(names[i],overallAverages[i],cutoff[i],tuition[i],classSize[i],longitude[i],latitude[i],nationalRank[i]));
							}

							input.close();


							universities.get(0).setName(universities.get(0).getName().substring(1));			//fixes error with a character before C on carleton
							for (University uni : universities) {
								System.out.println(path+"/resources/descriptions/" + uni.getName() + " Description.txt");
								try {
									String value = "";
									input = new Scanner(new File(path+"/resources/descriptions/" + uni.getName() + " Description.txt"));
									System.out.println("The path is: " + path+"/resources/descriptions/" + uni.getName() + " Description.txt"+ "|");
									while (input.hasNext()){

										value = value + " " +input.next();

									}

									uni.setDescription(value);
									input.close();


								} catch(FileNotFoundException e){
									System.out.println("File not Found :( (description)");
								}

								uni.setIcon(new ImageIcon(path+"/resources/uniPictures/" + uni.getName() + ".jpg"));

								try {
									input = new Scanner(new File(path+"/resources/keyWords/" + uni.getName() + ".txt"));

									input.useDelimiter(",");
									keyWords.clear();
									while (input.hasNext()){
										keyWords.add(input.next());
									}
									uni.setKeywords(keyWords);
									input.close();


									<<<<<<< HEAD
								} catch (FileNotFoundException e) {
									System.out.println("File not Found :( (all other fields)");
									>>>>>>> a535e6ed1a1886d22a8c52729fea6011485eef9d
									=======
								} catch(FileNotFoundException e){
									//System.out.println("File not Found :( (searching)");
									System.out.println((int)uni.getName().charAt(0));
								}
								>>>>>>> 44331e8d4d630f33fc4537fe7c61b6992faaa707
							}

						} catch (FileNotFoundException e) {
							System.out.println("File not Found :( (all other fields)");
						}
			}

			<<<<<<< HEAD
			for (int i = 0; i < names.length; i++) {
				universities.add(new University(names[i], overallAverages[i], cutoff[i], tuition[i], classSize[i],
						longitude[i], latitude[i]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not Found :(");
		}
		=======

				public ArrayList<University> getUniversities() {
			return universities;
			>>>>>>> a535e6ed1a1886d22a8c52729fea6011485eef9d
		}<<<<<<<HEAD

	}=======

	public ArrayList<UniversityDistance[]> getUniversityDistances() {
		return distances;
	}
}>>>>>>>44331e8d 4d 630f 33f c4537fe7c61b6992faaa707
