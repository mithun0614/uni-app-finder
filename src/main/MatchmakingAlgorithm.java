package main;

public class MatchmakingAlgorithm {

	public static int[] score = new int[14];

	public static void Matchmaker() {

		int[] dropDownValue = new int[6];
		int[] slidersValue = new int[6];

		for (int counter = 0; counter < dropDownValue.length; counter++) {
			dropDownValue[counter] = UniMatchmakerInfoEdit.dropDownLists[counter].getSelectedIndex();
			slidersValue[counter] = UniMatchmakerInfoEdit.sliders[counter].getValue();
		}

		int[] ranking = new int[14];
		int[] tuition = new int[14];
		int[] uniSize = new int[14];
		double[] residence = new double[14];
		int[] classSize = new int[14];

		for (int counter = 0; counter < 14; counter++) {

			ranking[counter] = UniversitiesInformation.universities.get(counter).getRanking();
			tuition[counter] = UniversitiesInformation.universities.get(counter).getTuition();
			uniSize[counter] = UniversitiesInformation.universities.get(counter).getUniSize();
			residence[counter] = UniversitiesInformation.universities.get(counter).getResidenceCost();
			classSize[counter] = UniversitiesInformation.universities.get(counter).getClassSize();

			score[counter] = 0;

			int factor = 0;

			if (ranking[counter] <= 5 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (ranking[counter] <= 10 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];

			factor++;

			if (tuition[counter] < 10000 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (tuition[counter] >= 10000 && tuition[counter] <= 15000 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (tuition[counter] > 15000 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

			factor++;

			if (uniSize[counter] < 10000 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (uniSize[counter] >= 10000 && uniSize[counter] <= 50000 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (uniSize[counter] > 50000 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

			factor++;

			if (residence[counter] < 10000 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (residence[counter] >= 10000 && residence[counter] <= 12000 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (residence[counter] > 12000 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

			factor++;

			if (classSize[counter] < 100 && dropDownValue[factor] == 0)
				score[counter] += slidersValue[factor];
			else if (classSize[counter] >= 100 && classSize[counter] <= 300 && dropDownValue[factor] == 1)
				score[counter] += slidersValue[factor];
			else if (classSize[counter] > 300 && dropDownValue[factor] == 2)
				score[counter] += slidersValue[factor];

		}

	}

}
